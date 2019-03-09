<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品销售订单审核</title>
<link
	href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" 
		url="${context}/sales/sales_order_modify"
		id="editSalesOrderAuditModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" poid="">
		<div class="modal-dialog" style="min-width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">销售订单审核</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal form-label-left" id="edit_sales_order_form"
						novalidate="novalidate" enctype="multipart/form-data"
						name="edit_client_form">
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">订单状态：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select name="input_order_status_sales_order_audit_edit"
									id="input_order_status_sales_order_audit_edit"
									url="${context}/purchase//order_status" type="text"
									class="form-control">
									<option value>请选择订单状态</option>
								</select>
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">备注：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<textarea id="input_appendix_sales_order_audit_edit"
									class="form-control col-md-7 col-xs-12"
									name="input_appendix_sales_order_audit_edit" placeholder="请输入订单审核备注内容"
									type="text"  />
							</div>
						</div>
						<div class="ln_solid"></div>
						<div class="form-group">
							<div class="col-md-6 col-md-offset-3">
								<!-- <button type="submit" class="btn btn-primary">Cancel</button> -->
								<button id="summit_sales_order_edit" class="btn btn-success"
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
	<script src="../js/sales_audit_sales_order_edit_diolog.js"></script>
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
