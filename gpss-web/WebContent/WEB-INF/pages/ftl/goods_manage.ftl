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
			<label for="goods_name">仓库名称</label> <input
				name="input_goodses_search_goods_manage"
				id="input_goodses_search_goods_manage" type="text"
				class="form-control" id="goods_name" placeholder="请输入要搜索的仓库名称">
		</div>
		<button id="btn_search_goodses"
			url="${context}/goods/goodses/count" type="button"
			class="btn btn-default btn-primary">
			<span class="glyphicon glyphicon-search"></span> 查询
		</button>
		<button data-toggle="modal" data-target="#creategoodsesModal"
			url="${context}/goods/create" id="btn_create_goodses"
			type="button" class="btn btn-default btn-primary">
			<span class="glyphicon glyphicon-plus"></span> 新增
		</button>
		<button type="button" url="${context}/goods/delete"
			id="btn_delete_goodses" class="btn btn-default btn-danger">
			<span class="glyphicon glyphicon-minus"></span> 删除
		</button>
	</div>

	<table class="table table-bordered">
		<caption></caption>
		<thead>
			<tr class="info">
				<th><input id="cb_goods_manage_all" type="checkbox" /></th>
				<th>商品ID</th>
				<th>商品名称</th>
				<th>食品生产商</th>
				<th>商品价格/元</th>
				<th>商品类别</th>
				<th>商品规格</th>
				<th>商品图片</th>
				<th>商品描述</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="itemContainer_goodses" class="itemContainer_goodses">
		</tbody>
	</table>

	<!-- 分页组件 -->
	<div class="row">
		<div class="col-sm-5 pagination" style="padding-left: 15px;">
			<div style="display: inline;" role="status" aria-live="polite">共
				${Request.goodsesCount!'0'}项记录,</div>
			<div style="display: inline;">
				<label> 
				<select class="form-control input-goods-manage" id='select_page_size_goods_manage'>
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="50">50</option>
						<!-- <option value="-1">全部</option> -->
				</select>
				</label>记录/页
			</div>
			<div style="display: inline;">
				<label> <input onkeyup="this.value=this.value.replace(/\D/g,'')" id="goto_page_goods-manage" name="goto_page_goods-manage" style="width: 55px;"
					type="text" class="form-control input-goods-manage"> </input>
				</label>
				<button id="btn_goto_goodses_goods-manage"
					url="${context}/goods/goodses/count" type="button"
					class="btn btn-sm btn-primary">
					<span class="glyphicon glyphicon glyphicon-share-alt"></span> 跳转
				</button>
			</div>
		</div>
		<div row="col-md-7">
			<nav url="${context}/goods/goodses"
				id="url_holder_goods_manage"
				all_data_count="${Request.goodsesCount!'0'}"
				style="padding-right: 40px;position: absolute;right: 0px;">
			<ul class="pagination" id="pagination_goodses"></ul>
			</nav>
		</div>
	</div>


	<!-- 添加仓库弹出框 -->
	<#include "/goods_manage_goods_create_diolog.ftl"> 
	<!-- 仓库信息编辑弹出框 -->
	<#include "/goods_manage_goods_edit_diolog.ftl"> 
	<script
		src="${base}/js/base.js"></script>
	<script
		src="${base}/js/goods-manage.js"></script>
</body>
</html>
