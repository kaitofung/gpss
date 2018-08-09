<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast的样式 -->
<link href="https://cdn.bootcss.com/toastr.js/latest/toastr.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<style type="text/css">
.main-container {
	padding: 20px
}
</style>
<body class="main-container ">
	<div class="form-inline">
		<div class="form-group">
			<label for="id">用户账号</label> <input type="text" class="form-control"
				id="id" placeholder="请输入要搜索的账号id">
		</div>
		<div class="form-group">
			<label for="name">用户角色</label> <input type="text"
				class="form-control" id="name" placeholder="请输入要搜索的用户角色">
		</div>
		<div class="form-group">
			<label for="frametype">锁定状态</label> <input type="checkbox" />
		</div>
		<button type="button" class="btn btn-default btn-primary">
			<span class="glyphicon glyphicon-search"></span> 查询
		</button>
		<button type="button" class="btn btn-default btn-primary">
			<span class="glyphicon glyphicon-plus"></span> 新增
		</button>
		<button type="button" class="btn btn-default btn-danger"
			>
			<span class="glyphicon glyphicon-minus"></span> 删除
		</button>
	</div>

	<table class="table table-bordered">
		<caption></caption>
		<thead>
			<tr class="info">
				<th><input type="checkbox" /></th>
				<th>用户ID</th>
				<th>用户名称</th>
				<th>员工编号</th>
				<th>更新时间</th>
				<th>锁定状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody url="${context}/user" id="itemContainer" class="itemContainer">
		</tbody>
	</table>

	<!-- 分页组件 -->
	<nav style="text-align: center" url="${context}/user/user_data_items"
		id="url_holder" all_data_count="${Request.userDataCount!'0'}">
	<ul class="pagination" id="pagination"></ul>
	</nav>
	<!-- 用户信息编辑弹出框 -->
<#include "/user_manage_user_edit_diolog.ftl">
	<script src="${base}/js/user-manage.js"></script>
</body>
</html>
