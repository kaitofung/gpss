<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast的样式 -->
<link
	href="https://cdn.staticfile.org/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
<link
	href="http://cdn.staticfile.org/bootstrap-table/1.12.1/bootstrap-table.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础参数</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<style type="text/css">
.main-container {
	padding: 20px
}
</style>
<body class="main-container ">
	<div id="goods_param_manage_toolbar" class="btn-group">
		<div class="form-inline">
			<div class="form-group">
				<label for="goods_param_name">参数类别：</label> <select
					url="${context}/goods/goods_specification_type"
					name="input_gspecification_search_goods_param_manage"
					id="input_goods_parames_search_goods_param_manage" type="text"
					class="form-control">
					<option value="">请选择参数类别</option>
				</select>
			</div>
			<button id="btn_search_goods_parames"
				url="${context}/goods/gspecification/count" type="button"
				class="btn btn-default btn-primary">
				<span class="glyphicon glyphicon-search"></span> 查询
			</button>
			<button data-toggle="modal" data-target="#creategoods_paramesModal"
				url="${context}/goods_param/create" id="btn_create_gspecification"
				type="button" class="btn btn-default btn-primary">
				<span class="glyphicon glyphicon-plus"></span> 新增
			</button>
			<button type="button"
				url="${context}/goods/delete/goods_specification"
				id="btn_delete_goods_parames" class="btn btn-default btn-danger">
				<span class="glyphicon glyphicon-minus"></span> 删除
			</button>
		</div>
	</div>

	<table id="goods_param_manage_table"
		url="${context}/goods/goods_specifications"
		data-mobile-responsive="true" class="mb-bootstrap-table text-nowrap"></table>

	<script src="${base}/js/base.js"></script>
	<script src="../js/bootstrap-table.min.js"></script>
	<script src="../js/bootstrap-table-zh-CN.min.js"></script>
	<script
		src="https://cdn.staticfile.org/toastr.js/latest/js/toastr.min.js"></script>
	<script src="${base}/js/goods-param-manage.js"></script>
	<#include "/goods_param_manage_goods_param_create_diolog.ftl">
	<#include "/goods_param_manage_goods_param_edit_diolog.ftl">
</body>
</html>
