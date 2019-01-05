<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast的样式 -->
<link href="https://cdn.bootcss.com/toastr.js/latest/toastr.min.css"
	rel="stylesheet">
<link
	href="https://cdn.bootcss.com/bootstrap-table/1.12.1/bootstrap-table.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户管理</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<style type="text/css">
.main-container {
	padding: 20px
}
</style>
<body class="main-container ">
	<div class="panel-body" style="padding-bottom: 0px;">

		<div id="toolbar" class="btn-group">
			<div class="form-inline">
				<button data-toggle="modal" data-target="#createClientModal" id="btn_add" type="button" class="btn btn-default btn-info">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				<button url="${context}/marketing_manage/delete/client_delete" id="btn_delete_client_manage" type="button"
					class="btn btn-default btn-danger">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button>
			 <input name="input_name_search_client_manage"
					id="input_name_search_client_manage" type="text"
					class="form-control" placeholder="请输入要查询的客户名称"> </input>
				<button id="btn_search_client" type="button"
					class="btn btn-default btn-primary">
					<span class="glyphicon glyphicon-search"></span> 查询
				</button>
			</div>
		</div>
		<table id="client_manage_table" url="${context}/marketing_manage//clients"
			data-mobile-responsive="true" class="mb-bootstrap-table text-nowrap"></table>
	</div>
	<#include "/client_manage_client_create_diolog.ftl"> 
	<#include "/client_manage_client_edit_diolog.ftl"> 

</body>
	<script
		src="../js/bootstrap-table.min.js"></script> <script
		src="../js/bootstrap-table-zh-CN.min.js"></script> <script
		src="${base}/js/client-manage.js"></script>
</html>
