$(document).ready(function(){
	
	var url = $('#user_manage_table').attr("url");
	$('#user_manage_table').bootstrapTable({
		method : 'get', // 服务器数据的请求方式 get or post
		url : url, // 服务器数据的加载地址
		striped : true, //是否显示行间隔色
		toolbar : "#user_manage_toolbar", //toolbar
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, //是否显示分页（*）
		sortable : false, //是否启用排序
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
			var locked = $("#input_locked_search_user_manage").prop("checked") == true ? 1: 0;
			return {
				pageSize : params.limit,
				currentPage : params.offset / params.limit + 1,
				uid : $("#input_name_search_user_manage").val(),
				roleName : $("#input_role_search_user_manage").val(),
				locked : locked
			};
		},
		onLoadSuccess : function(params) {
			setOnItemBtnClickLister();
		},
		columns : [ {
			checkbox : true
		}, 
		{
			field : 'uid',
			title : '用户ID'
		}, {
			field : 'realName',
			title : '员工真实姓名'
		}, 
		 {
			field : 'nickName',
			title : '昵称'
		}, 
		{
			field : 'roleName',
			title : '角色名称'
		}, {
			field : 'locked',
			title : '锁定状态',
			sortable : false,
			formatter: lockFormatter
		}, 
		 {
			field : 'eid',
			title : '员工ID',
			sortable : false
		}, 
		{
			field : 'updatedTime',
			title : '更新时间',
			sortable : false,
			formatter: updatedTimeFormatter
		}, 
		{
			field : 'uid',
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
    
    function setOnItemBtnClickLister() {
    	$("[edit_btn_uid]").on("click", function(){
    		var uid = $(this).attr("edit_btn_uid");
    		var role_name = $(this).attr("role_name");
    		var realName = $(this).attr("real_name");
    		var rid = $(this).attr("role_id");
    		$("#edituserModal").attr("uid",uid);
    		$("#edituserModal").attr("role_name",role_name);
    		$("#edituserModal").attr("realName",realName);
    		$("#edituserModal").attr("rid",rid);

    		$("#input_uid_user_manage_edit").val(uid);
        	$("#input_real_name_user_manage_edit").val(realName);
        	$("#input_role_user_manage_edit").val(rid);
    	});
    	
//    	锁定用户/解锁用户
		$("[btn_uid_locked]").on("click",function(){
			var url = $("#input_lock_url_user_manage").attr("url");
			var uid = $(this).attr("btn_uid_locked");
			var locked = $(this).attr("locked") == 0 ? 1:0;
		    $.post(url,
		    {
		        uid:uid,
		        locked:locked
		    },
		        function(data,status){
		    	if(!data.isSucceed) {
		    		toastr.success('操作失败');
		    		return;
		    	}
		    	toastr.success('操作成功');
		    	refreshPage();
		    });
		});
    }
    
  //操作栏的格式化
    function actionFormatter(value, row, index) {
        var id = value;
        var result = "";
        var lockedClass =  row.locked == 0 ? "label label-success fa  fa-unlock-alt":"label label-danger fa  fa-lock";
    	var lockedLebelText = row.locked == 0 ? "锁定用户":"解锁用户";
        var lockedBtn = "<button locked='"+ row.locked + "' btn_uid_locked='"+ id + "' type='button' class='" + lockedClass + "' style='margin: 2px'>" + lockedLebelText + "</button>";
        result += lockedBtn;
        result += "<button  data-toggle='modal' real_name='"+ row.realName +"' role_name='"+row.roleName+"' role_id='" + row.rid + "' data-target='#edituserModal' edit_btn_uid='"+ id + "' type='button' class=' btn btn-default btn-info btn-xs fa fa-edit 'style='margin: 2px'>编辑</button>";
        return result;
    }
    
    //锁定状态格式化
    function lockFormatter(value, row, index) {
    	var lock = value;
    	var result = "";
    	var lockedClass =  lock == 0 ? "label label-success":"label label-danger";
    	var lockedLebelText = lock == 0 ? "未锁定":"已锁定";
    	result += "<span class='"+lockedClass+"'>" + lockedLebelText + "</span>";
    	return result;
    }
    
    //更新时间格式化
    function updatedTimeFormatter(value, row, index) {
    	return dateFormat(value);
    }
    
    //图片地址的格式化
    function photoFormatter(value, row, index) {
    	var photoURL = value;
    	var result = "";
    	result += "<img style='width:100px;height:100px;' alt='无图' src='" + photoURL + "'>";
    	return result;
    }

	// 搜索方法
	function search() {
		$('#user_manage_table').bootstrapTable('refresh');
	}
	// 重置方法
	function refresh() {
		$(".form")[0].reset();
		search();
	}
	
	$("#btn_search_user").click(function(){
		refreshPage();
	});
	
	function refreshPage() {
		$('#user_manage_table').bootstrapTable('refresh');
	}
	
	$("#btn_delete_goodses").click(function(){
		var items = $('#user_manage_table').bootstrapTable("getSelections");
		var gids = new Array();
		for(i = 0; i < items.length; i ++){
			gids[i] = (items[i].gid) ;
		}
		var url = $("#btn_delete_goodses").attr("url");
		$.post(url,
		   {
			gids: gids,
			   dataType:"json", 
		   },
		    function(status,result){
			   if(status.isSucceed == true) {
				   refreshPage();
				   toastr.success('删除成功');
			   }else {
				   toastr.error('删除失败');
			   }
		   }
		);
		
	});
	


});


