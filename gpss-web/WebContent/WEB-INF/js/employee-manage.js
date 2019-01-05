$(document).ready(function(){
	getEmployeeTypes();
	var url = $('#employee_manage_table').attr("url");
	$('#employee_manage_table').bootstrapTable({
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
		uniqueId : "ID", //每一行的唯一标识，一般为主键列
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
				name : $("#input_name_search_employee_manage").val(),
				etypeid : $("#input_employee_type_search_employee_manage").val(),
			/* roleName : $(".form").find("input[name='roleName']")
					.val().trim(), */
			};
		},
		onLoadSuccess : function(params) {
			setOnEditClickLister();
		},
		columns : [ {
			checkbox : true
		}, 
		{
			field : 'eid',
			title : '员工ID'
		}, {
			field : 'name',
			title : '员工姓名'
		}, {
			field : 'mobile',
			title : '员工电话'
		}, {
			field : 'etypeName',
			title : '员工类型',
			sortable : true
		}, {
			field : 'birthday',
			sortable : true,
			title : '员工生日'
		} , {
			field : 'eid',
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
    	$("[btn_edit_employee_manage_eid]").click(function(){
    		var eid = $(this).attr("btn_edit_employee_manage_eid");
    		$("#editEmployeeModal").attr("eid",eid);
    	});
    }
    
    
    
  //操作栏的格式化
    function actionFormatter(value, row, index) {
//    	log(value);
//    	log(row);
//    	log(index);
        var id = value;
        var result = "";
        result += "<a btn_edit_employee_manage_eid='" + id + "' data-toggle='modal' data-target='#editEmployeeModal' href='javascript:;' class='btn btn-xs blue' onclick=\"onEditClick('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
        return result;
    }
    

	// 搜索方法
	function search() {
		$('#employee_manage_table').bootstrapTable('refresh');
	}
	// 重置方法
	function refresh() {
		$(".form")[0].reset();
		search();
	}
	
	$("#btn_search_employee").click(function(){
		$('#employee_manage_table').bootstrapTable('refresh');
	});
	
	//获取员工类别
	function getEmployeeTypes(){
		var url = $("#input_employee_type_search_employee_manage").attr("url");
 		$.post(url,function(data,status){
				var html = "";
				$("#input_employee_type_search_employee_manage").empty();
				html = html + "<option value=''>请选择员工类别</option>";
				if(data != null) {
					for(i = 0; i < data.length; i ++) {
						var item = data[i];
					html = html 
					+ "<option value='" + item.etypeid + "' etypeid='" + item.etypeid + "'>" + item.name + "</option>";
					}
					$("#input_employee_type_search_employee_manage").html(html);
				}
		    }
		);
	}
	
	$("#btn_delete_employee_manage").click(function(){
		var items = $('#employee_manage_table').bootstrapTable("getSelections");
		var eids = new Array();
		for(i = 0; i < items.length; i ++){
			eids[i] = (items[i].eid) ;
			log(eids[i]);
		}
		var url = $("#btn_delete_employee_manage").attr("url");
		$.post(url,
		   {
			   eids: eids,
			   dataType:"json", 
		   },
		    function(status,result){
			   if(status.isSucceed == true) {
					$('#employee_manage_table').bootstrapTable('refresh');
					toastr.success('删除成功');
			   }else {
				   toastr.error('删除失败');
			   }
		   }
		);
		
	});
	
});


