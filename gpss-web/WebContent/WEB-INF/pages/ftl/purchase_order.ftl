<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Toast的样式 -->
<link href="https://cdn.staticfile.org/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
<link
	href="http://cdn.staticfile.org/bootstrap-table/1.12.1/bootstrap-table.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>采购订单</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
</head>
<style type="text/css">
.main-container {
	padding: 20px
}
</style>
<body class="main-container ">

	<div class="panel-body" style="padding-bottom: 0px;">

		<div id="purchase_order_toolbar" class="btn-group">
			<div class="form-inline">

				<div class="col-md-10">
					<span style="margin-right: 5px;"> <label>订单号：</label> <input
						name="input_id_search_purchase_order_manage"
						id="input_id_search_purchase_order_manage" type="text"
						class="form-control" placeholder="请输入订单号"> </input>
					</span> <span style="margin-right: 5px;"> <label>商品名称：</label> <input
						name="input_gname_search_purchase_order_manage"
						id="input_gname_search_purchase_order_manage" type="text"
						class="form-control" placeholder="请输入商品"> </input>
					</span> <span style="margin-right: 5px;"> <label>供应商：</label> <select
						name="input_supplier_name_search_purchase_order_manage"
						id="input_supplier_name_search_purchase_order_manage" url="${context}/purchase/suppliers" type="text"
						class="form-control">
							<option value>请选择供应商</option>
					</select>
					</span> <span style="margin-right: 5px;"> <label>仓库：</label> <select
						name="input_storage_name_search_purchase_order_manage"
						id="input_storage_name_search_purchase_order_manage" type="text" url="${context}/purchase/storages"
						class="form-control">
							<option value>请选择仓库</option>
					</select>
					</span>
				</div>

				<div class="col-md-10" style="margin-top: 7px;">
					<span style="margin-right: 5px;"> <label>经办人：</label> <input
						name="input_creater_name_search_purchase_order_manage"
						id="input_creater_name_search_purchase_order_manage" type="text"
						class="form-control" placeholder="请输入经办人"> </input>
					</span> <span style="margin-right: 5px;"> <label>审核状态：</label> <select
						name="input_audit_status_search_purchase_order_manage"
						id="input_audit_status_search_purchase_order_manage" type="text"
						class="form-control" url="${context}/purchase/order_status">
							<option value>请选择订单的审核状态</option>
					</select>
					</span> <span style="margin-right: 5px;"> <label>创建时间：</label>
						<div class="input-group date form_date " data-date=""
							data-date-format="yyyy-mm-dd" data-link-field="dtp_input2"
							data-link-format="yyyy-mm-dd">
							<input id="input_created_time_search_purchase_order_manage"
								name="input_created_time_search_purchase_order_manage"
								class="form-control" size="16" type="text" value="" readonly /><span
								class="input-group-addon"><span
								class="glyphicon glyphicon-remove"></span></span> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-calendar"></span></span>
						</div>
					</span>

					<button id="btn_search_purchase_order" type="button"
						class="btn btn-default btn-primary">
						<span class="glyphicon glyphicon-search"></span> 查询
					</button>
					<button data-toggle="modal" data-target="#createPurchaseModal" id="btn_purchase_purchase_order_manage" type="button"
						class="btn btn-default btn-primary">
						<span class="glyphicon glyphicon-plus"></span> 采购
					</button>
				<!-- 	<button id="btn_search_client"  
						class="btn  disabled" >
						<span class="glyphicon glyphicon-minus" ></span> 退货
					</button> -->
					
					<a href="${context}/purchase/purchase_orders/output_data" url="${context}/purchase/purchase_orders/output_data" id="btn_output_data_purchase_order_manage" type="button"
						class="btn btn-default btn-primary" target="_blank">
						<span class="glyphicon glyphicon-save"></span> 导出
					</a>
				</div>

			</div>
		</div>
		<table id="purchase_order_table"
			url="${context}/purchase/purchase_orders"
			data-mobile-responsive="true" class="mb-bootstrap-table text-nowrap"></table>
	</div>
	 	<#include  "/purchase_manage_purchase_order_create_diolog.ftl"> 
	<#include  "/purchase_manage_purchase_order_edit_diolog.ftl"> 
</body>

<script src="../js/bootstrap-datetimepicker.min.js"></script>
<script src="../js/bootstrap-datetimepicker.zh-CN.js"></script>

<script src="../js/bootstrap-table.min.js"></script>
<script src="../js/bootstrap-table-zh-CN.min.js"></script>
<script src="${base}/js/purchase-order.js"></script>

<script>
	$('.form_date').datetimepicker({
		language : 'zh-CN',
		dateFormat : 'yy-mm-dd hh:ii',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0
	});
</script>
</html>
