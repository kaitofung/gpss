<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建菜单</title>
</head>
<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" 
		url="${context}/system_manage//create_menu"
		id="createMenuModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="min-width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">创建菜单</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal form-label-left"
						id="create_menu_form" novalidate="novalidate"
						enctype="multipart/form-data" name="create_menu_form">
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">菜单名称：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="menu_name_input_create"
									class="form-control col-md-7 col-xs-12"
									name="menu_name_input_create" placeholder="请输入菜单名称"
									type="text">
							</div>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">菜单URL：
								<span class="required" aria-required="true">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="menu_url_input_create"
									class="form-control col-md-7 col-xs-12"
									name="menu_url_input_create" placeholder="请输入菜单URL"
									type="text" >
							</div>
						</div>
						<div class="ln_solid"></div>
					</form>
				</div>
				<div class="modal-footer">
						<div class="form-group">
							<div >
								<button id="summit_menu_create" class="btn btn-success"
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
	
	<script src="../js/base.js"></script>
	<script src="../js/menu_manage_menu_create_diolog.js"></script>
	
</body>
</html>
