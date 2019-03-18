$(document).ready(function(){
	var url = $('#role_manage_table').attr("url");
	$('#role_manage_table').bootstrapTable({
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
		uniqurid : "ID", //每一行的唯一标识，一般为主键列
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
			var roleCode = $("#input_name_search_role_manage").val();
			return {
				pageSize : params.limit,
				currentPage : params.offset / params.limit + 1,
				roleCode : roleCode
			};
		},
		onLoadSuccess : function(params) {
			setOnEditClickLister();
		},
		columns : [ {
			checkbox : true
		}, 
		{
			field : 'rid',
			title : '角色ID'
		}, {
			field : 'name',
			title : '角色名称'
		}, {
			field : 'roleCode',
			title : '角色编码'
		}, {
			field : 'menuList',
			title : '角色菜单',
			sortable : true
		}, {
			field : 'description',
			sortable : true,
			title : '角色描述'
		} , {
			field : 'createdTime',
			sortable : true,
			title : '创建时间',
			formatter: updatedTimeFormatter
		} , {
			field : 'rid',
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
    	$("[btn_edit_role_manage_rid]").click(function(){
    		var rid = $(this).attr("btn_edit_role_manage_rid");
    		$("#editRoleModal").attr("rid",rid);
    	});
    }
    
    
    
  //操作栏的格式化
    function actionFormatter(value, row, index) {
        var id = value;
        var result = "";
        result += "<a btn_edit_role_manage_rid='" + id + "' data-toggle='modal' data-target='#editRoleModal' href='javascript:;' class='btn btn-xs blue' onclick=\"onEditClick('" + id + "')\" title='编辑'><span class=' fa fa-edit btn btn-default btn-info btn-xs'>编辑</span></a>";
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
		$('#role_manage_table').bootstrapTable('refresh');
	}
	// 重置方法
	function refresh() {
		$(".form")[0].reset();
		search();
	}
	
	$("#btn_search_client").click(function(){
		$('#role_manage_table').bootstrapTable('refresh');
	});
	
	$("#btn_delete_role_manage").click(function(){
		var items = $('#role_manage_table').bootstrapTable("getSelections");
		var rids = new Array();
		for(i = 0; i < items.length; i ++){
			rids[i] = (items[i].rid) ;
		}
		var url = $("#btn_delete_role_manage").attr("url");
		$.post(url,
		   {
			   rids: rids,
			   dataType:"json", 
		   },
		    function(status,result){
			   if(status.isSucceed == true) {
					$('#role_manage_table').bootstrapTable('refresh');
					toastr.success('删除成功');
			   }else {
				   toastr.error('删除失败');
			   }
		   }
		);
		
	});
	
});


