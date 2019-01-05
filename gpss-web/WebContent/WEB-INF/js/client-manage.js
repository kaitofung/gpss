$(document).ready(function(){
	var url = $('#client_manage_table').attr("url");
	$('#client_manage_table').bootstrapTable({
		method : 'get', // 服务器数据的请求方式 get or post
		url : url, // 服务器数据的加载地址
		striped : true, //是否显示行间隔色
		toolbar : "#toolbar", //toolbar
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, //是否显示分页（*）
		sortable : true, //是否启用排序
		//sortName : 'createTime',
		sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, //初始化加载第一页，默认第一页
		pageSize : 5, //每页的记录行数（*）
		pageList : [ 5, 25, 50, 100 ], //可供选择的每页的行数（*）
		strictSearch : true,
		minimumCountColumns : 2, //最少允许的列数
		clickToSelect : true, //是否启用点击选中行
		uniqucid : "ID", //每一行的唯一标识，一般为主键列
		cardView : false,
		detailView : true, //是否显示详细视图
		detailFormatter : detailFormatter,
		smartDisplay : false,
		showRefresh : true, // 显示刷新按钮
		//showToggle : true,
		//showColumns : true,
		search : false, //此设置为客户端搜索，意义不大
		strictSearch : false,//设置为 true启用全匹配搜索，否则为模糊搜索。
		sortOrder : "asc",
		queryParams : function(params) {
			return {
				pageSize : params.limit,
				currentPage : params.offset / params.limit + 1,
				name : $("#input_name_search_client_manage").val(),
			};
		},
		onLoadSuccess : function(params) {
			setOnEditClickLister();
		},
		columns : [ {
			checkbox : true
		}, 
		{
			field : 'cid',
			title : '客户ID'
		}, {
			field : 'name',
			title : '客户姓名'
		}, {
			field : 'phoneNum',
			title : '员工电话'
		}, {
			field : 'address',
			title : '客户地址',
			sortable : true
		}, {
			field : 'description',
			sortable : true,
			title : '客户描述'
		} , {
			field : 'updatedTime',
			sortable : true,
			title : '最后更新时间',
			formatter: updatedTimeFormatter
		} , {
			field : 'cid',
			title : '操作',
			formatter: actionFormatter
		} ]
	});
	
    function detailFormatter(index, row) {
        var html = [];
        $.each(row, function (key, value) {
            html.push('<p><b>' + key + ':</b> ' + value + '</p>');
        });
        return html.join('');
    }
    
    function setOnEditClickLister() {
    	$("[btn_edit_client_manage_cid]").click(function(){
    		var cid = $(this).attr("btn_edit_client_manage_cid");
    		$("#editClientModal").attr("cid",cid);
    	});
    }
    
    
    
  //操作栏的格式化
    function actionFormatter(value, row, index) {
        var id = value;
        var result = "";
        result += "<a btn_edit_client_manage_cid='" + id + "' data-toggle='modal' data-target='#editClientModal' href='javascript:;' class='btn btn-xs blue' onclick=\"onEditClick('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
        return result;
    }
    
    //最后更新时间栏格式化
    function updatedTimeFormatter(value, row, index) {
    	var time = value;
    	var result = dateFormat(time);
    	return result;
    }
    

	// 搜索方法
	function search() {
		$('#client_manage_table').bootstrapTable('refresh');
	}
	// 重置方法
	function refresh() {
		$(".form")[0].reset();
		search();
	}
	
	$("#btn_search_client").click(function(){
		$('#client_manage_table').bootstrapTable('refresh');
	});
	
	$("#btn_delete_client_manage").click(function(){
		var items = $('#client_manage_table').bootstrapTable("getSelections");
		var cids = new Array();
		for(i = 0; i < items.length; i ++){
			cids[i] = (items[i].cid) ;
		}
		var url = $("#btn_delete_client_manage").attr("url");
		$.post(url,
		   {
			   cids: cids,
			   dataType:"json", 
		   },
		    function(status,result){
			   if(status.isSucceed == true) {
					$('#client_manage_table').bootstrapTable('refresh');
					toastr.success('删除成功');
			   }else {
				   toastr.error('删除失败');
			   }
		   }
		);
		
	});
	
});


