<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑商品规格</title>
</head>
<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" url="${context}/goods/edit/goods_specification"
		id="editgoods_paramesModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="min-width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">编辑商品规格</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal form-label-left"
						id="edit_goods_param_form" novalidate="novalidate"
						enctype="multipart/form-data" name="edit_goods_param_form">
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">商品规格名称：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="goods_param_name_input_edit"
									class="form-control col-md-7 col-xs-12"
									name="goods_param_name_input_edit" placeholder="请输入商品名称"
									type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">规格类别名称：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="goods_param_type_input_edit"
									class="form-control col-md-7 col-xs-12"
									name="goods_param_type_input_edit" placeholder="请输入规格类别名称"
									type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">商品规格描述：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="goods_param_description_input_edit"
									name="goods_param_description_input_edit" required="required"
									class="form-control col-md-7 col-xs-12" aria-required="true"
									placeholder="请输入商品规格描述" />
							</div>
						</div>
						<div class="ln_solid"></div>
					</form>
				</div>
				<div class="modal-footer">
					<div class="form-group">
						<div class="">
							<!-- <button type="submit" class="btn btn-primary">Cancel</button> -->
							<button id="summit_goods_param_edit" class="btn btn-success"
								type="button">提交</button>
							<button  data-dismiss="modal" class="btn btn-info"
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
	<script src="../js/goods_param_manage_goods_param_edit_diolog.js"></script>
	<script>
		
	</script>
</body>
</html>
