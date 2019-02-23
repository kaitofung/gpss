<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usersInfo</title>
</head>
<body>
	<aside class="main-sidebar"> <!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar"> <!-- Sidebar user panel (optional) -->
	<div class="user-panel">
		<div class="pull-left image">
			<img src="../dist/img/avatar-160x160.jpg" class="img-circle"
				alt="User Image">
		</div>
		<div class="pull-left info">
			<p>${Session.user.name!"--用户"}</p>
			<!-- Status -->
			<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
		</div>
	</div>

	<!-- search form (Optional) -->
	<form action="#" method="get" class="sidebar-form">
		<div class="input-group">
			<input type="text" name="q" class="form-control"
				placeholder="Search..."> <span class="input-group-btn">
				<button type="submit" name="search" id="search-btn"
					class="btn btn-flat">
					<i class="fa fa-search"></i>
				</button>
			</span>
		</div>
	</form>
	<!-- /.search form --> <!-- Sidebar Menu -->
	<ul class="sidebar-menu" data-widget="tree">
		<!--  <li class="header">HEADER</li>
        Optionally, you can add icons to the links
        <li class="active"><a href="#"><i class="fa fa-link"></i> <span>Link</span></a></li>
        <li><a href="#"><i class="fa fa-link"></i> <span>Another Link</span></a></li> -->

		<li class="treeview"><a href="#"><i class="fa  fa-cog"></i> <span>基础设置</span>
				<span class="pull-right-container"> <i
					class="fa fa-angle-left pull-right"></i>
			</span> </a>
			<ul class="treeview-menu">
				<li><a class="list-sub-item" url="${context}/goods/goods_manage">商品管理</a></li>
				<li><a class="list-sub-item" url="${context}/storage/storage_manage">仓库管理</a></li>
				<@shiro.hasRole name="admin">
					<li><a class="list-sub-item" url="${context}/user/employee_manage">员工管理</a></li>
				</@shiro.hasRole>
				<@shiro.hasAnyRoles name="admin,saler">
					<li><a class="list-sub-item" url="${context}/goods/goods_param_manage">商品参数管理</a></li>
				</@shiro.hasAnyRoles>
			</ul>
		</li>
		<@shiro.hasAnyRoles name="admin,purchaser">
			<li class="treeview"><a href="#"><i class="fa fa-money"></i>
					<span>采购管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a class="list-sub-item" url="${context}/supplier/supplier_manage">供应商管理</a></li>
					<li><a class="list-sub-item" url="${context}/purchase/purchase_orders_manage">采购订单</a></li>
				</ul>
			</li>
		</@shiro.hasAnyRoles>
		
		<@shiro.hasAnyRoles name="admin,saler">
			<li class="treeview"><a href="#"><i
					class="fa fa-balance-scale"></i> <span>销售管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a class="list-sub-item" url="${context}/marketing_manage/client_manage">客户管理</a></li>
					<li><a class="list-sub-item" url="${context}/sales/sales_orders_manage">销售订单</a></li>
				</ul>
			</li>
		</@shiro.hasAnyRoles>
		<@shiro.hasAnyRoles name="admin,storer">
			<li class="treeview"><a href="#"><i class="fa  fa-cubes"></i>
					<span>库存管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a class="list-sub-item" url="${context}/user/welcome">库存概况</a></li>
					<li><a class="list-sub-item" url="${context}/user/welcome">采购审核</a></li>
					<li><a class="list-sub-item" url="${context}/user/welcome">销售审核</a></li>
				</ul>
			</li>
		</@shiro.hasAnyRoles>
		
		<li class="treeview"><a href="#"><i
				class="fa  fa-bar-chart-o"></i> <span>统计分析</span> <span
				class="pull-right-container"> <i
					class="fa fa-angle-left pull-right"></i>
			</span> </a>
			<ul class="treeview-menu">
				<li><a class="list-sub-item" url="${context}/user/welcome">采购统计</a></li>
				<li><a class="list-sub-item" url="${context}/user/welcome">销售统计</a></li>
			</ul>
		</li>
		
		<@shiro.hasAnyRoles name="admin">
			<li class="treeview"><a href="#"><i class="fa fa-cogs"></i> <span>系统管理</span>
					<span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a class="list-sub-item" url="${context}/system_manage/menu_manage">菜单管理</a></li>
					<li><a class="list-sub-item" url="${context}/user/welcome">角色管理</a></li>
					<li><a class="list-sub-item" url="${context}/user/user_manage">用户管理</a></li>
					<li><a class="list-sub-item" url="${context}/user/modify_user_profile">修改资料</a></li>
				</ul>
			</li>
		</@shiro.hasAnyRoles>

	</ul>
	<!-- /.sidebar-menu --> </section> <!-- /.sidebar --> </aside>
</body>
</html>


