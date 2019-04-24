<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建商品</title>
<link
	href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" 
		url="${context}/goods/create" id="creategoodsesModal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" style="min-width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">创建商品</h4>
				</div>
				<div class="modal-body">
					<form 
						class="form-horizontal form-label-left" id="create_goods_form"
						novalidate="novalidate" enctype="multipart/form-data" name="create_goods_form">
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="">商品名称： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="goods_name_input_create" class="form-control col-md-7 col-xs-12"
									name="goods_name_input_create" placeholder="请输入商品名称" type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="">商品生产商名称： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="goods_manager_producer_input_create" class="form-control col-md-7 col-xs-12"
									name="goods_manager_producer_input_create" placeholder="请输入商品生产商名称" type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="">商品价格： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="goods_price_input_create" class="form-control col-md-7 col-xs-12"
									name="goods_price_input_create" placeholder="请输入商品价格" type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="">商品类别： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select url="${context}/goods/goods_types" type="text" id="goods_gtype_input_create" name="goods_gtype_input_create" required="required"
									class="form-control col-md-7 col-xs-12" aria-required="true"
									placeholder="" >
									<option value="" id="select_goods_gtype_first">请选择商品类型</option>
									</select>
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="">商品规格： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select type="text" url="${context}/goods/goods_specification_name" id="goods_specification_input_create" name="goods_specification_input_create" required="required"
									class="form-control col-md-7 col-xs-12" aria-required="true"
									placeholder="" >
									<option value="" id="select_goods_specification_first">请选择商品规格</option>
									</select>
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="">商品描述： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="goods_description_input_create" name="goods_description_input_create" required="required"
									class="form-control col-md-7 col-xs-12" aria-required="true"
									placeholder="请输入仓库描述" />
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="">商品图片： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="file" id="goods_photo_input_create" name="goods_photo_input_create" required="required"
									class="form-control col-md-7 col-xs-12" aria-required="true" 
									placeholder="请选择要上传的商品图片" />
							</div>
						</div>
						<div class="ln_solid"></div>
					</form>
				</div>
				<div class="modal-footer">
						<div class="form-group">
						<div >
							<button id="summit_goods_create" class="btn btn-success"
								type="button">提交</button>
							<button data-dismiss="modal" class="btn btn-info"
								type="button">取消</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<script src="../js/base.js"></script>
	<script  src="../js/goods_manage_goods_create_diolog.js"></script>
	<script >
		
	</script>
</body>
</html>
