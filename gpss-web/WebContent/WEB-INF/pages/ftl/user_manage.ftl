<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Toast的样式 -->
<link href="https://cdn.staticfile.org/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="http://cdn.staticfile.org/bootstrap-table/1.12.1/bootstrap-table.min.css"
	rel="stylesheet">
</head>
<style type="text/css">
.main-container {
	padding: 20px
}
</style>
<body class="main-container ">
	<div id="user_manage_toolbar" class="btn-group">
		<div class="form-inline">
		<div class="form-group">
			<label for="id">用户id</label> <input type="text" class="form-control"
				id="input_name_search_user_manage" placeholder="请输入要搜索的账号id">
		</div>
		<div class="form-group">
			<label for="name">用户角色</label> <input type="text"
				class="form-control" id="input_role_search_user_manage" placeholder="请输入要搜索的用户角色">
		</div>
		<div class="form-group">
			<label for="frametype">锁定状态</label> <input type="checkbox" id="input_locked_search_user_manage"/>
		</div>
		<button id="btn_search_user" type="button" class="btn btn-default btn-primary">
			<span class="glyphicon glyphicon-search"></span> 查询
		</button>
		<button type="button" data-toggle='modal' data-target='#createuserModal' class="btn btn-default btn-primary">
			<span class="glyphicon glyphicon-plus"></span> 新增
		</button>
		<button type="button" class="btn btn-default btn-danger"
			>
			<span class="glyphicon glyphicon-minus"></span> 删除
		</button>
	</div>
	</div>
	
	
	
		<input id="input_lock_url_user_manage" type="hidden" url= "${context}/user/lock"></input>
		<table id="user_manage_table"
		url="${context}/user/user_data_items"
		data-mobile-responsive="true" class="mb-bootstrap-table text-nowrap"></table>

<#include "/user_manage_user_edit_diolog.ftl">
<#include "/user_manage_user_create_diolog.ftl">
		<script src="../js/dateformat.js"></script>
		<script src="../js/bootstrap-table.min.js"></script>
	<script src="../js/bootstrap-table-zh-CN.min.js"></script>
	<script
		src="https://cdn.staticfile.org/toastr.js/latest/js/toastr.min.js"></script>
		<script
		src="${base}/js/base.js"></script>
	<script src="${base}/js/user-manage.js"></script>
</body>
</html>
