<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast的样式 -->
<link href="https://cdn.staticfile.org/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓库管理</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<link
	href="https://cdn.staticfile.org/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
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
	<div id="storage_manage_toolbar" class="btn-group">
		<div class="form-inline">
			<div class="form-group">
				<label for="storage_name">仓库名称</label> <input
					name="input_storages_search_storage_manage"
					id="input_storages_search_storage_manage" type="text"
					class="form-control" id="storage_name" placeholder="请输入要搜索的仓库名称">
			</div>
			<button id="btn_search_storages"
				url="${context}/storage/storages/count" type="button"
				class="btn btn-default btn-primary">
				<span class="glyphicon glyphicon-search"></span> 查询
			</button>
			<button data-toggle="modal" data-target="#createStoragesModal"
				url="${context}/storage/delete" id="btn_create_storages"
				type="button" class="btn btn-default btn-primary">
				<span class="glyphicon glyphicon-plus"></span> 新增
			</button>
			<button type="button" url="${context}/storage/delete"
				id="btn_delete_storages" class="btn btn-default btn-danger">
				<span class="glyphicon glyphicon-minus"></span> 删除
			</button>
		</div>
	</div>


	<table id="storage_manage_table"
		url="${context}/storage/storages"
		data-mobile-responsive="true" class="mb-bootstrap-table text-nowrap"></table>

	<!-- 添加仓库弹出框 -->
	<#include "/storage_manage_storage_create_diolog.ftl"> 
	<!-- 仓库信息编辑弹出框 -->
	<#include "/storage_manage_storage_edit_diolog.ftl"> 

		<script src="../js/bootstrap-table.min.js"></script>
	<script src="../js/bootstrap-table-zh-CN.min.js"></script>
	<script
		src="https://cdn.staticfile.org/toastr.js/latest/js/toastr.min.js"></script>
	<script
		src="${base}/js/storage-manage.js"></script>
</body>
</html>
