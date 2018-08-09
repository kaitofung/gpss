<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast的样式 -->
<link href="https://cdn.bootcss.com/toastr.js/latest/toastr.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓库管理</title>
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

	<table class="table table-bordered">
		<caption></caption>
		<thead>
			<tr class="info">
				<th><input id="cb_storage_manage_all" type="checkbox" /></th>
				<th>仓库ID</th>
				<th>仓库名称</th>
				<th>仓库管理员姓名</th>
				<th>管理员电话</th>
				<th>仓库地址</th>
				<th>描述</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="itemContainer_storages" class="itemContainer_storages">
		</tbody>
	</table>

	<!-- 分页组件 -->
	<div class="row">
		<div class="col-sm-5 pagination" style="padding-left: 15px;">
			<div style="display: inline;" role="status" aria-live="polite">共
				${Request.storagesCount!'0'}项记录,</div>
			<div style="display: inline;">
				<label> 
				<select class="form-control input-storage-manage" id='select_page_size_storage_manage'>
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="50">50</option>
						<!-- <option value="-1">全部</option> -->
				</select>
				</label>记录/页
			</div>
			<div style="display: inline;">
				<label> <input onkeyup="this.value=this.value.replace(/\D/g,'')" id="goto_page_storage-manage" name="goto_page_storage-manage" style="width: 55px;"
					type="text" class="form-control input-storage-manage"> </input>
				</label>
				<button id="btn_goto_storages_storage-manage"
					url="${context}/storage/storages/count" type="button"
					class="btn btn-sm btn-primary">
					<span class="glyphicon glyphicon glyphicon-share-alt"></span> 跳转
				</button>
			</div>
		</div>
		<div row="col-md-7">
			<nav url="${context}/storage/storages"
				id="url_holder_storage_manage"
				all_data_count="${Request.storagesCount!'0'}"
				style="padding-right: 40px;position: absolute;right: 0px;">
			<ul class="pagination" id="pagination_storages"></ul>
			</nav>
		</div>
	</div>


	<!-- 添加仓库弹出框 -->
	<#include "/storage_manage_storage_create_diolog.ftl"> 
	<!-- 仓库信息编辑弹出框 -->
	<#include "/storage_manage_storage_edit_diolog.ftl"> 
	<script
		src="${base}/js/storage-manage.js"></script>
</body>
</html>
