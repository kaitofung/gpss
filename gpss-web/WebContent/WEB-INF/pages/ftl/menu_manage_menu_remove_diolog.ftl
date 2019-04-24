<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除菜单</title>
</head>
<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" 
		url="${context}/system_manage/remove_menu"
		id="removeMenuModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="min-width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">删除菜单</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal form-label-left"
						id="remove_menu_form" novalidate="novalidate"
						enctype="multipart/form-data" name="remove_menu_form">
						<div class="ln_solid" ></div>
						<h6 id="body_modal_remove_menu"></h6>
					
					</form>
				</div>
				<div class="modal-footer">
							<div class="form-group">
							<div >
								<!-- <button type="submit" class="btn btn-primary">Cancel</button> -->
								<button id="summit_menu_remove" class="btn btn-success"
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
	<script src="../js/menu_manage_menu_remove_diolog.js"></script>
	
</body>
</html>
