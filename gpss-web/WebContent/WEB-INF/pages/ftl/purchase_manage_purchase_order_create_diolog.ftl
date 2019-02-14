<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品采购</title>
<link
	href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" 
		url="${context}/purchase/purchase_order_create"
		id="createPurchaseModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" createrId="${Session.user.eid}">
		<div class="modal-dialog" style="min-width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">创建采购订单</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal form-label-left" id="create_purchase_order_form"
						novalidate="novalidate" enctype="multipart/form-data"
						name="edit_client_form">
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">商品名称：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select name="input_goods_name_purchase_order_create"
									id="input_goods_name_purchase_order_create"
									url="${context}/purchase/goodses" type="text"
									class="form-control">
									<option value="">请选择订单的商品名称</option>
								</select>
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">商品规格：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select name="input_goods_specification_purchase_order_create"
									id="input_goods_specification_purchase_order_create"
									url="${context}/purchase//goods_specications" type="text"
									class="form-control">
									<option value="">请选择订单的商品规格</option>
								</select>
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">供应商：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select name="input_supplier_name_purchase_order_create"
									id="input_supplier_name_purchase_order_create"
									url="${context}/purchase/suppliers" type="text"
									class="form-control">
									<option value="">请选择订单的供应商</option>
								</select>
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">入库仓库：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select name="input_storage_name_purchase_order_create"
									id="input_storage_name_purchase_order_create"
									url="${context}/purchase/storages" type="text"
									class="form-control">
									<option value="">请选择订单的入库仓库</option>
								</select>
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">数量：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="input_goods_count_purchase_order_create"
									class="form-control col-md-7 col-xs-12"
									name="input_goods_count_purchase_order_create" placeholder="请输入商品数量"
									type="number" value="" linkage="money">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">商品单价：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input  id="input_goods_price_purchase_order_create" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" 
									class="form-control col-md-7 col-xs-12"
									name="input_goods_price_purchase_order_create" placeholder="请输入商品单价"
									type="text" value="" linkage="money">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">商品总价：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="input_goods_sum_purchase_order_create"
									class="form-control col-md-7 col-xs-12"
									name="input_goods_sum_purchase_order_create" placeholder="请输入总价"
									type="text" value="0"  readonly="true" >
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">备注：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<textarea id="input_appendix_purchase_order_create"
									class="form-control col-md-7 col-xs-12"
									name="input_appendix_purchase_order_create" placeholder="请输入订单备注"
									type="text"  />
							</div>
						</div>
						<div class="ln_solid"></div>
						<div class="form-group">
							<div class="col-md-6 col-md-offset-3">
								<!-- <button type="submit" class="btn btn-primary">Cancel</button> -->
								<button id="summit_purchase_order_create" class="btn btn-success"
									type="button">提交</button>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<script src="../js/bootstrap-datetimepicker.min.js"></script>
	<script src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script src="../js/base.js"></script>
	<script src="../js/purchase_manage_purchase_order_create_diolog.js"></script>
	<!-- 时间选择器的JS -->
	<script>
		$('.form_date').datetimepicker({
			language : 'zh-CN',
			dateFormat : 'yy-mm-dd hh:ii',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0
		});
	</script>

</body>
</html>
