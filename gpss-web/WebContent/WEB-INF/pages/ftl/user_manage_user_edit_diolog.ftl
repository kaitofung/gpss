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
		url="${context}/user/edit/user_data_items" id="edituserModal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true" >
		<div class="modal-dialog">
			<div class="modal-content" style="width: 750px">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">用户编辑</h4>
				</div>
				<div class="modal-body">
					<form id="edit_user_form" uid="${Session.user.uid!''}"
						class="form-horizontal form-label-left" id="data_modify_form"
						novalidate="novalidate" onsubmit="return sub();">
<!-- 						novalidate="novalidate" onsubmit="return sub();"> -->
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="name">用户ID： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input disabled="disabled" id="input_uid_user_manage_edit" class="form-control col-md-7 col-xs-12"
									name="input_uid_user_manage_edit" placeholder="请输入用户ID" type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="name">用户昵称： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="input_nickName_user_manage_edit" class="form-control col-md-7 col-xs-12"
									name="input_nickName_user_manage_edit" placeholder="请输入用户昵称" type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="name">员工名/真实姓名： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="input_real_name_user_manage_edit" disabled="disabled" class="form-control col-md-7 col-xs-12"
									name="input_real_name_user_manage_edit" placeholder="请输入员工名" type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="name">用户密码： <span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="input_password_user_manage_edit" class="form-control col-md-7 col-xs-12"
									name="input_password_user_manage_edit" placeholder="请输入用户密码" type="password">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="employee_type">角色名称：<span class="required"
								aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
							<select  class="optional form-control col-md-7 col-xs-12" id="input_role_user_manage_edit" name="input_role_user_manage_edit" url="${context}/user/roles">
								<option value>请选择角色名称</option>
							</select>
							</div>
						</div>
						<div class="ln_solid"></div>
					</form>
				</div>
				<div class="modal-footer">
						<div class="form-group">
						<div class="">
							<button id="summit_user_edit" class="btn btn-success" type="button">提交</button>
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

	<script src="../js/user_manage_user_edit_diolog.js"></script>
</body>
</html>
