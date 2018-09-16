<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usersInfo</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap-table/1.12.1/bootstrap-table.min.css"
	rel="stylesheet">
</head>
<body>
<!-- 	<div class="panel-body" style="padding-bottom: 0px;">

        <div class="panel panel-default">
            <div class="panel-heading">查询条件</div>
            <div class="panel-body">
                <form id="formSearch" class="form-horizontal">
                    <div class="form-group" style="margin-top:15px">
                        <label class="control-label col-sm-1" for="txt_search_departmentname">部门名称</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="txt_search_departmentname">
                        </div>
                        <label class="control-label col-sm-1" for="txt_search_statu">状态</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="txt_search_statu">
                        </div>
                        <div class="col-sm-3" style="text-align:left;">
                            <button type="button" style="margin-top:0px;float: right!important;" id="btn_query" class="btn btn-primary">查询</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>       


		<div id="toolbar" class="btn-group">

			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</div>
		<table id="roleTable" data-mobile-responsive="true"
			class="mb-bootstrap-table text-nowrap"></table>
	</div> -->



	 hello!,${Session.user.uid!"-- "},欢迎来到gpss系统！！






</body>
<!-- <script src="../js/bootstrap-table.min.js"></script>
<script src="../js/bootstrap-table-zh-CN.min.js"></script>
<script>
	$('#roleTable').bootstrapTable({
		method : 'get', // 服务器数据的请求方式 get or post
		url : "/gpss-web/goods/roles", // 服务器数据的加载地址
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
				pageNum : params.offset / params.limit + 1,
			/* roleName : $(".form").find("input[name='roleName']")
					.val().trim(), */
			};
		},
		columns : [ {
			checkbox : true
		}, 
		{
			field : 'roleId',
			title : '角色ID'
		}, {
			field : 'roleName',
			title : '角色'
		}, {
			field : 'remark',
			title : '描述'
		}, {
			field : 'createTime',
			title : '创建时间',
			sortable : true
		}, {
			field : 'modifyTime',
			sortable : true,
			title : '修改时间'
		} ]
	});
    function detailFormatter(index, row) {
    	console.log("xx" + index +"----" + row);
        var html = [];
        $.each(row, function (key, value) {
            html.push('<p><b>' + key + ':</b> ' + value + '</p>');
        });
        return html.join('');
    }
	// 搜索方法
	function search() {
		$('#roleTable').bootstrapTable('refresh');
	}
	// 重置方法
	function refresh() {
		$(".form")[0].reset();
		search();
	}
</script> -->
</html>
