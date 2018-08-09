<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usersInfo</title>
<!-- Toast的样式 -->
<link href="https://cdn.bootcss.com/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
</head>
<body>
	<form url="${context}/user/process_modify_user_profile"
		class="form-horizontal form-label-left" id="user_data_form"
		 uid="${Session.user.uid!''}">
		<div class="item form-group">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="passsword">原密码 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input id="password" name="password"
					class="form-control col-md-7 col-xs-12" placeholder="请输入原密码"
					type="password">
			</div>
		</div>
		<div class="item form-group">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="newpassword">新密码 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="password" id="newPassword" name="newPassword"
					class="form-control col-md-7 col-xs-12" placeholder="请输入新密码">
			</div>
		</div>
		<div class="item form-group">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="newpasswordagain">再次输入新密码 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input placeholder="请再次输入新密码" type="password"
					id="newPasswordAgain" name="newPasswordAgain"
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="ln_solid"></div>
		<div class="form-group">
			<div class="col-md-6 col-md-offset-3">
				<!-- <button type="submit" class="btn btn-primary">Cancel</button> -->
				<button id="summit" class="btn btn-success">提交</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="../js/modify_user_profile.js"></script>
</body>
</html>
