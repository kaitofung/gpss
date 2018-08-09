<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建仓库</title>
<link
	href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" 
		url="${context}/storage/create" id="createStoragesModal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" style="min-width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">创建仓库</h4>
				</div>
				<div class="modal-body">
					<form 
						class="form-horizontal form-label-left" id="create_storage_form"
						novalidate="novalidate" >
<!-- 						novalidate="novalidate" onsubmit="return sub();"> -->
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="">仓库名称： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="storage_name_input_create" class="form-control col-md-7 col-xs-12"
									name="storage_name_input_create" placeholder="请输入仓库名称" type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="">仓库管理员姓名： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="storage_manager_name_input_create" class="form-control col-md-7 col-xs-12"
									name="storage_manager_name_input_create" placeholder="请输入仓库管理员姓名" type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="">管理员电话： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="storage_mobile_input_create" class="form-control col-md-7 col-xs-12"
									name="storage_mobile_input_create" placeholder="请输入仓库管理员电话" type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="">仓库地址： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="storage_address_input_create" name="storage_address_input_create" required="required"
									class="form-control col-md-7 col-xs-12" aria-required="true"
									placeholder="请输入仓库地址" />
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="">仓库描述： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="storage_description_input_create" name="storage_description_input_create" required="required"
									class="form-control col-md-7 col-xs-12" aria-required="true"
									placeholder="请输入仓库描述" />
							</div>
						</div>
						<div class="ln_solid"></div>
						<div class="form-group">
							<div class="col-md-6 col-md-offset-3">
								<!-- <button type="submit" class="btn btn-primary">Cancel</button> -->
								<button id="summit_storage_create" class="btn btn-success" type="button">提交</button>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button id="summit_data" name="summit_data" data-dismiss="modal"
						type="button" class="btn btn-primary">提交更改</button> -->
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<script src="../js/base.js"></script>
	<script src="../js/storage_manage_storage_create_diolog.js"></script>
	<script >
		
	</script>
</body>
</html>
