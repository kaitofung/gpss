<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast的样式 -->
<link href="https://cdn.bootcss.com/toastr.js/latest/toastr.min.css"
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
	<div class="form-inline">
		<div class="form-group">
			<label for="goods_param_name">参数类别：</label> <select
				url ="${context}/goods/goods_specification_type"
				name="input_gspecification_search_goods_param_manage"
				id="input_goods_parames_search_goods_param_manage" type="text"
				class="form-control"  >
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
		<button type="button" url="${context}/goods/delete/goods_specification"
			id="btn_delete_goods_parames" class="btn btn-default btn-danger">
			<span class="glyphicon glyphicon-minus"></span> 删除
		</button>
	</div>

	<table class="table table-bordered">
		<caption></caption>
		<thead>
			<tr class="info">
				<th><input id="cb_goods_param_manage_all" type="checkbox" /></th>
				<th>商品规格ID</th>
				<th>规格名称</th>
				<th>规格类别</th>
				<th>规格描述</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="itemContainer_goods_parames" class="itemContainer_goods_parames">
		</tbody>
	</table>

	<!-- 分页组件 -->
	<div class="row">
		<div class="col-sm-5 pagination" style="padding-left: 15px;">
			<div style="display: inline;" role="status" aria-live="polite">共
				${Request.gspecificationCount!'0'}项记录,</div>
			<div style="display: inline;">
				<label> 
				<select class="form-control input-goods_param-manage" id='select_page_size_goods_param_manage'>
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="50">50</option>
						<!-- <option value="-1">全部</option> -->
				</select>
				</label>记录/页
			</div>
			<div style="display: inline;">
				<label> <input onkeyup="this.value=this.value.replace(/\D/g,'')" id="goto_page_goods_param-manage" name="goto_page_goods_param-manage" style="width: 55px;"
					type="text" class="form-control input-goods_param-manage"> </input>
				</label>
				<button id="btn_goto_goods_parames_goods_param-manage"
					url="${context}/goods/gspecification/count" type="button"
					class="btn btn-sm btn-primary">
					<span class="glyphicon glyphicon glyphicon-share-alt"></span> 跳转
				</button>
			</div>
		</div>
		<div class="col-md-7">
			<nav url="${context}/goods/goods_specifications"
				id="url_holder_goods_param_manage"
				all_data_count="${Request.gspecificationCount!'0'}"
				style="text-align: right;">
			<ul class="pagination" id="pagination_goods_parames"></ul>
			</nav>
		</div>
	</div>

	<#include "/goods_param_manage_goods_param_create_diolog.ftl"> 
	<#include "/goods_param_manage_goods_param_edit_diolog.ftl"> 

	<script
		src="${base}/js/base.js"></script>
	<script
		src="${base}/js/goods-param-manage.js"></script>
</body>
</html>
