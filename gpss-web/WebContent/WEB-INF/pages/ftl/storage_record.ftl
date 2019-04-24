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
<title>库存记录</title>
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

		<div id="toolbar_storage_record" class="btn-group">
			<div class="form-inline">
			 <input name="input_name_search_storage_record_manage"
					id="input_name_search_storage_record_manage" type="text"
					class="form-control" placeholder="请输入商品名称"> </input>
			 <select name="input_name_gspecification_search_storage_record"
					id="input_name_gspecification_search_storage_record" type="text"
					class="form-control" url="${context}/purchase//goods_specications">
					<option value>请选择商品规格</option>
					 </select>
			 <select name="input_name_search_storage_storage_record"
					id="input_name_search_storage_storage_record" url="${context}/purchase/storages"  type="text"
					class="form-control" >
					<option value>请选择商品仓库</option>
				</select>
				<button id="btn_search_storage_record" type="button"
					class="btn btn-default btn-primary">
					<span class="glyphicon glyphicon-search"></span> 查询
				</button>
			</div>
		</div>
		<table id="storage_record_manage_table" url="${context}/storage/storage_records"
			data-mobile-responsive="true" class="mb-bootstrap-table text-nowrap"></table>
	</div>
	<#include "/storage_record_manage_storage_record_edit_diolog.ftl"> 
</body>
	<script
		src="../js/bootstrap-table.min.js"></script> <script
		src="../js/bootstrap-table-zh-CN.min.js"></script> <script
		src="${base}/js/storage_record.js"></script>
</html>
