<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast的样式 -->
<link href="https://cdn.staticfile.org/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
<link
	href="http://cdn.staticfile.org/bootstrap-table/1.12.1/bootstrap-table.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
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
		<div id="employee_manage_toolbar" class="btn-group">
			<div class="form-inline">
				<button data-toggle="modal" data-target="#createEmployeeModal" id="btn_add" type="button" class="btn btn-default btn-info">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				<button url="${context}/user/delete/employee_delete" id="btn_delete_employee_manage" type="button"
					class="btn btn-default btn-danger">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button>

				<select url="${context}/user/employee_types"
					name="input_employee_type_search_employee_manage"
					id="input_employee_type_search_employee_manage"
					class="form-control"><option value="">请选择员工类别</option>
					<option value="">-</option>
				</select> <input name="input_name_search_employee_manage"
					id="input_name_search_employee_manage" type="text"
					class="form-control" placeholder="请输入员工名称"> </input>
				<button id="btn_search_employee" type="button"
					class="btn btn-default btn-primary">
					<span class="glyphicon glyphicon-search"></span> 查询
				</button>
			</div>
		</div>
		<table id="employee_manage_table" url="${context}/user//employees"
			data-mobile-responsive="true" class="mb-bootstrap-table text-nowrap"></table>
	</div>
	<#include "/employee_manage_employee_create_diolog.ftl"> 
	<#include "/employee_manage_employee_edit_diolog.ftl"> 
</body>
	<script
		src="../js/bootstrap-table.min.js"></script> <script
		src="../js/bootstrap-table-zh-CN.min.js"></script> <script
		src="${base}/js/employee-manage.js"></script>
</html>
