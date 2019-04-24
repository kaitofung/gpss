<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usersInfo</title>
<script type="module" src="https://cdn.bootcss.com/popper.js/1.12.9/popper.min.js"></script>
<!-- Toast的样式 -->
<link href="https://cdn.staticfile.org/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
<!-- jquery.treegrid -->
<link
	href="https://cdn.bootcss.com/jquery-treegrid/0.2.0/css/jquery.treegrid.min.css"
	rel="stylesheet">
<script src="../js/jquery.treegrid.min.js"></script>

<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>
<body id="menu_manage_body">
	<table id="tb_menu_manage" url="${context}/system_manage/menus"></table>
	<#include "/menu_manage_menu_edit_diolog.ftl"> 
	<#include "/menu_manage_menu_create_diolog.ftl"> 
	<#include "/menu_manage_menu_remove_diolog.ftl"> 
</body>
<script src="https://cdn.staticfile.org/toastr.js/latest/toastr.min.js"></script>
<!-- jquery.treegrid.extension -->
<script src="../js/jquery.treegrid.extension.js"></script>
<script src="../js/menu_manage.js"></script>
<script src="../js/base.js"></script>
</html>
