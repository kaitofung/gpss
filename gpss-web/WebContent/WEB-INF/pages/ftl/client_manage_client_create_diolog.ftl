<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建新客户</title>
<link
	href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" updater="${Session.user.uid}"
		url="${context}/marketing_manage/create/client_create"
		id="createClientModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="min-width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">创建客户</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal form-label-left"
						id="create_client_form" novalidate="novalidate"
						enctype="multipart/form-data" name="create_client_form">
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">客户名称：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="client_name_input_create"
									class="form-control col-md-7 col-xs-12"
									name="client_name_input_create" placeholder="请输入客户名称"
									type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">客户联系人：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="client_contacts_input_create"
									class="form-control col-md-7 col-xs-12"
									name="client_contacts_input_create" placeholder="请输入客户联系人姓名"
									type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">客户电话号码：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="client_mobile_input_create"
									class="form-control col-md-7 col-xs-12"
									name="client_mobile_input_create" placeholder="请输入客户电话号码"
									type="text" >
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">客户描述：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="client_description_input_create"
									class="form-control col-md-7 col-xs-12"
									name="client_description_input_create" placeholder="请输入客户描述"
									type="text" value="">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">客户地址：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="client_address_input_create"
									class="form-control col-md-7 col-xs-12"
									name="client_address_input_create" placeholder="请输入客户地址"
									type="text" value="">
							</div>
						</div>
						<div class="ln_solid"></div>
					</form>
				</div>
				<div class="modal-footer">
						<div class="form-group">
						<div >
							<button id="summit_client_create" class="btn btn-success"
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
	
	<script src="../js/bootstrap-datetimepicker.min.js"></script>
	<script src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script src="../js/base.js"></script>
	<script src="../js/client_manage_client_create_diolog.js"></script>
		<!-- 时间选择器的JS -->
	<script>
	$('.form_date').datetimepicker({
        language:  'zh-CN',
        dateFormat: 'yy-mm-dd hh:ii', 
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
	</script>
	
</body>
</html>
