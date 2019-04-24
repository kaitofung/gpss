<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改角色信息</title>
<link
	href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" updater="${Session.user.uid}"
		url="${context}/system_manage/modify_role"
		id="editRoleModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="min-width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">修改角色信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal form-label-left"
						id="edit_role_form" novalidate="novalidate"
						enctype="multipart/form-data" name="edit_role_form">
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">角色名称：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="role_name_input_edit"
									class="form-control col-md-7 col-xs-12"
									name="role_name_input_edit" placeholder="请输入角色名称"
									type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">角色描述：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<textarea id="role_description_input_edit"
									class="form-control col-md-7 col-xs-12"
									name="role_description_input_edit" placeholder="请输入角色描述"
									type="text" value=""></textarea>
							</div>
						</div>
						<div class="ln_solid"></div>
					</form>
				</div>
				<div class="modal-footer">
							<div class="form-group">
							<div class="">
								<!-- <button type="submit" class="btn btn-primary">Cancel</button> -->
								<button id="summit_role_edit" class="btn btn-success"
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
	
	<script src="../js/bootstrap-datetimepicker.min.js"></script>
	<script src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script src="../js/base.js"></script>
	<script src="../js/role_manage_role_edit_diolog.js"></script>
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
