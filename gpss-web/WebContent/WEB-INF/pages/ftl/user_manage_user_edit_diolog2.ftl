<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usersInfo</title>
<link
	href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" updater="${Session.user.uid!'admin001'}"
		url="${context}/user/modify_employee_data" id="edituserModal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">用户编辑</h4>
				</div>
				<div class="modal-body">
					<form uid="${Session.user.uid!''}"
						class="form-horizontal form-label-left" id="data_modify_form"
						novalidate="novalidate" onsubmit="return sub();">
<!-- 						novalidate="novalidate" onsubmit="return sub();"> -->
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="name">真实姓名： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="real_name" class="form-control col-md-7 col-xs-12"
									name="real_name" placeholder="请输入真实姓名" type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="employee_type">员工类型：<span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select id="employee_type" type="text" name="employee_type"
									class="optional form-control col-md-7 col-xs-12">
									<option e_type_id="1">普通员工</option>
								</select>
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="birthday">生日：<span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<div class="input-group date form_date " data-date=""
									data-date-format="dd MM yyyy" data-link-field="dtp_input2"
									data-link-format="yyyy-mm-dd">
									<input id="birthday" name="birthday" class="form-control"
										size="16" type="text" value="" readonly> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-remove"></span></span> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-calendar"></span></span>
								</div>
								<input type="hidden" id="dtp_input2" value="" /><br />
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="telephone">手机号码： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="tel" id="mobile" name="mobile" required="required"
									class="form-control col-md-7 col-xs-12" aria-required="true"
									placeholder="请输入手机号码" />
							</div>
						</div>
						<div class="ln_solid"></div>
						<div class="form-group">
							<div class="col-md-6 col-md-offset-3">
								<!-- <button type="submit" class="btn btn-primary">Cancel</button> -->
								<button id="summit" class="btn btn-success" >提交</button>
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

	<script src="../js/user_manage_user_edit_diolog.js"></script>
</body>
</html>
