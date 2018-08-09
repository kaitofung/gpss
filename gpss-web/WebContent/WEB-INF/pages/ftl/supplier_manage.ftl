<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast的样式 -->
<link href="https://cdn.bootcss.com/toastr.js/latest/toastr.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商管理</title>
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
			<label for="supplier_name">供应商名称</label> <input
				name="input_suppliers_search_supplier_manage"
				id="input_suppliers_search_supplier_manage" type="text"
				class="form-control" id="supplier_name" placeholder="请输入要搜索的供应商名称">
		</div>
		<button id="btn_search_suppliers"
			url="${context}/supplier/suppliers/count" type="button"
			class="btn btn-default btn-primary">
			<span class="glyphicon glyphicon-search"></span> 查询
		</button>
		<button data-toggle="modal" data-target="#createSuppliersModal"
			url="${context}/supplier/delete" id="btn_create_suppliers"
			type="button" class="btn btn-default btn-primary">
			<span class="glyphicon glyphicon-plus"></span> 新增
		</button>
		<button type="button" url="${context}/supplier/delete"
			id="btn_delete_suppliers" class="btn btn-default btn-danger">
			<span class="glyphicon glyphicon-minus"></span> 删除
		</button>
	</div>

	<table class="table table-bordered">
		<caption></caption>
		<thead>
			<tr class="info">
				<th><input id="cb_supplier_manager_all" type="checkbox" /></th>
				<th>供应商ID</th>
				<th>供应商名称</th>
				<th>供应商联系人</th>
				<th>联系电话</th>
				<th>联系地址</th>
				<th>描述更新时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="itemContainer_suppliers" class="itemContainer_suppliers">
		</tbody>
	</table>

	<!-- 分页组件 -->
	<div class="row">
		<div class="col-sm-5 pagination" style="padding-left: 15px;">
			<div style="display: inline;" role="status" aria-live="polite">共
				${Request.suppliersCount!'0'}项记录,</div>
			<div style="display: inline;">
				<label> 
				<select class="form-control input-sm" id='select_page_size_sm'>
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="50">50</option>
						<!-- <option value="-1">全部</option> -->
				</select>
				</label>记录/页
			</div>
			<div style="display: inline;">
				<label> <input onkeyup="this.value=this.value.replace(/\D/g,'')" id="goto_page_sm" name="goto_page_sm" style="width: 55px;"
					type="text" class="form-control input-sm"> </input>
				</label>
				<button id="btn_goto_suppliers_sm"
					url="${context}/supplier/suppliers/count" type="button"
					class="btn btn-sm btn-primary">
					<span class="glyphicon glyphicon glyphicon-share-alt"></span> 跳转
				</button>
			</div>
		</div>
		<div row="col-md-7">
			<nav url="${context}/supplier/suppliers"
				id="url_holder_supplier_manage"
				all_data_count="${Request.suppliersCount!'0'}"
				style="padding-right: 40px;position: absolute;right: 0px;">
			<ul class="pagination" id="pagination_suppliers"></ul>
			</nav>
		</div>
	</div>


	<!-- 添加供应商弹出框 -->
	<#include "/supplier_manage_supplier_create_diolog.ftl"> 
	<!-- 供应商信息编辑弹出框 -->
	<#include "/supplier_manage_supplier_edit_diolog.ftl"> 
	<script
		src="${base}/js/supplier-manage.js"></script>
</body>
</html>
