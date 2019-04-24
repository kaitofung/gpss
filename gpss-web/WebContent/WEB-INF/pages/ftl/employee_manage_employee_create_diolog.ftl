<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建新员工</title>
<link
	href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" updater="${Session.user.uid}"
		url="${context}/user/create/employee_create"
		id="createEmployeeModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="min-width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">创建员工</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal form-label-left"
						id="create_employee_form" novalidate="novalidate"
						enctype="multipart/form-data" name="create_employee_form">
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">商品规格名称：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="employee_name_input_create"
									class="form-control col-md-7 col-xs-12"
									name="employee_name_input_create" placeholder="请输入员工姓名"
									type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">员工电话号码：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="employee_mobile_input_create"
									class="form-control col-md-7 col-xs-12"
									name="employee_mobile_input_create" placeholder="请输入员工电话号码"
									type="text" >
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">员工类别：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select url="${context}/user/employee_types"
									name="input_employee_type_create_employee_manage"
									id="input_employee_type_create_employee_manage"
									class="form-control"><option value="">请选择员工类别</option>
									<option value="">-</option>
								</select>
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="birthday">员工生日：<span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<div class="input-group date form_date " data-date=""
									data-date-format="yyyy-mm-dd" data-link-field="dtp_input2"
									data-link-format="yyyy-mm-dd">
									<input id="input_birthday_create_employee_manage" name="input_birthday_create_employee_manage" class="form-control"
										size="16" type="text" value="" readonly/><span
										class="input-group-addon"><span
										class="glyphicon glyphicon-remove"></span></span> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-calendar"></span></span>
								</div>
								<input type="hidden" id="dtp_input2" value="" /><br />
							</div>
						</div>
						<div class="ln_solid"></div>
					</form>
				</div>
				<div class="modal-footer">
					<div class="form-group">
						<div >
							<button id="summit_employee_create" class="btn btn-success"
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
	<script src="../js/employee_manage_employee_create_diolog.js"></script>
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
