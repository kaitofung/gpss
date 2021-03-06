$(document).ready(function(){
	getStorages();
	getSuppliers();
	getOrderStatuses();
	setOnClickOutputData();
	var currentPage = 1;
	var pageSize = 5;
	var poid = null;
	var gname = null;
	var supplierId = null;
	var storageId = null;
	var createrName = null;
	var createdTime = null;
	var url = $('#purchase_order_table_audit').attr("url");
	$('#purchase_order_table_audit').bootstrapTable({
		method : 'get', // 服务器数据的请求方式 get or post
		url : url, // 服务器数据的加载地址
		striped : true, //是否显示行间隔色
		toolbar : "#purchase_order_audit_toolbar", //toolbar
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, //是否显示分页（*）
		sortable : false, //是否启用排序
		//sortName : 'createTime',
		sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, //初始化加载第一页，默认第一页
		pageSize : 5, //每页的记录行数（*）
		pageList : [ 5, 25, 50, 100 ], //可供选择的每页的行数（*）
		strictSearch : true,
		minimumCountColumns : 2, //最少允许的列数
		clickToSelect : true, //是否启用点击选中行
		uniqucid : "ID", //每一行的唯一标识，一般为主键列
		cardView : false,
		detailView : true, //是否显示详细视图
		detailFormatter : detailFormatter,
		smartDisplay : false,
		showRefresh : true, // 显示刷新按钮
		//showToggle : true,
		//showColumns : true,
		search : false, //此设置为客户端搜索，意义不大
		strictSearch : false,//设置为 true启用全匹配搜索，否则为模糊搜索。
		sortOrder : "asc",
		queryParams : function(params) {
			var poid = $("#input_id_search_purchase_order_audit").val();
			var gname = $("#input_gname_search_purchase_order_audit").val();
			var supplierId = $("#input_supplier_name_search_purchase_order_audit").val();
			var storageId = $("#input_storage_name_search_purchase_order_audit").val();
			var createrName = $("#input_creater_name_search_purchase_order_audit").val();
			var createdTime = $("#input_created_time_search_purchase_order_audit").val().toString("yyyy-MM-dd");
			var auditStatus = $("#input_audit_status_search_purchase_order_audit").val();
			currentPage = params.offset / params.limit + 1;
			pageSize = params.limit;
			return {
				pageSize : params.limit,
				currentPage : currentPage,
				createdtime : createdTime,
				poid : poid,
				gname : gname,
				supplierId : supplierId,
				storageId : storageId,
				auditStatus : auditStatus,
				createrName : createrName
			};
		},
		onLoadSuccess : function(params) {
			setOnEditClickLister();
			setOutputUrl();
		},
		columns : [ {
			checkbox : true
		}, 
		{
			field : 'poid',
			title : '订单ID'
		}, {
			field : 'gname',
			title : '商品名称'
		}, {
			field : 'gsname',
			title : '商品规格'
		}, {
			field : 'supplierName',
			title : '供应商名称',
			sortable : false
		}
		, {
			field : 'storageName',
			sortable : false,
			title : '仓库名称'
		} 
		, {
			field : 'num',
			sortable : false,
			title : '数量'
		} 
		, {
			field : 'price',
			sortable : false,
			title : '单价'
		} 
		, {
			field : 'sum',
			sortable : false,
			title : '总价'
		} 
		, {
			field : 'auditStatusName',
			sortable : false,
			title : '审核状态',
			formatter:auditStatusNameFormatter
		} 
		, {
			field : 'createdtime',
			sortable : false,
			title : '创建时间',
			formatter: updatedTimeFormatter
		} 
		, {
			field : 'poid',
			title : '操作',
			formatter: actionFormatter
		} ]
	});
	
    function detailFormatter(index, row) {
        var html = [];
        $.each(row, function (key, value) {
            html.push('<p><b>' + key + ':</b> ' + value + '</p>');
        });
        return html.join('');
    }
    
    function setOnEditClickLister() {
    	$("[btn_purchase_order_audit_poid]").click(function(){
    		var poid = $(this).attr("btn_purchase_order_audit_poid");
    		var num = $(this).attr("num");
    		var gid = $(this).attr("gid");
    		var gspecificationId = $(this).attr("gspecificationId");
    		var storageId = $(this).attr("storageId");
    		$("#editPurchaseOrderAuditModal").attr("poid",poid);
    		$("#editPurchaseOrderAuditModal").attr("num",num);
    		$("#editPurchaseOrderAuditModal").attr("gspecificationId",gspecificationId);
    		$("#editPurchaseOrderAuditModal").attr("storageId",storageId);
    		$("#editPurchaseOrderAuditModal").attr("gid",gid);
    	});
    }
    
  //操作栏的格式化
    function actionFormatter(value, row, index) {
        var id = value;
        var result = "";
        result += "<a storageId='"+row.storageId+"' gspecificationId='"+ row.purchaseOrderGspecificationId +"' gid='" + row.purchaseOrderGid + "' num='" + row.num + "' btn_purchase_order_audit_poid='" + id + "' data-toggle='modal' data-target='#editPurchaseOrderAuditModal' href='javascript:;' class='btn btn-xs blue' onclick=\"onEditClick('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
        return result;
    }
    
    //审核状态的格式化
    function auditStatusNameFormatter(value, row, index) {
    	var name = value;
    	var labelType = "label-info";
    	if(name == "审核中" || name == "退货中") {
    		var labelType = "label-warning";
    	} else if(name == "申请退货" || name == "退货失败") {
    		var labelType = "label-danger";
    	} else if(name == "已退货") {
    		var labelType = "label-default";
    	}  else if(name == "审核通过") {
    		var labelType = "label-success";
    	} 
    	var result = "<span class='label " + labelType + "'>" + name + "</span>";
    	return result;
    }
    
    function setOnClickOutputData(){
    	$("#btn_output_data_purchase_order_audit").on("click",function(){
    		var poid = $("#input_id_search_purchase_order_audit").val();
    		var gname = $("#input_gname_search_purchase_order_audit").val();
    		var supplierId = $("#input_supplier_name_search_purchase_order_audit").val();
    		var storageId = $("#input_storage_name_search_purchase_order_audit").val();
    		var createrName = $("#input_creater_name_search_purchase_order_audit").val();
    		var createdTime = $("#input_created_time_search_purchase_order_audit").val().toString("yyyy-MM-dd");
    		var url = $("#btn_output_data_purchase_order_audit").attr("url");
    		$.get(url,
    				{
						pageSize : pageSize,
						currentPage : currentPage,
						createdtime : createdTime,
						poid : poid,
						gname : gname,
						supplierId : supplierId,
						storageId : storageId,
						createrName : createrName
    				},
    				    function(result,status){
    				   }
    		);
    	});
    }
    
    
    
    function setOutputUrl(){
    	var poid = $("#input_id_search_purchase_order_audit").val();
		var gname = $("#input_gname_search_purchase_order_audit").val();
		var supplierId = $("#input_supplier_name_search_purchase_order_audit").val();
		var storageId = $("#input_storage_name_search_purchase_order_audit").val();
		var createrName = $("#input_creater_name_search_purchase_order_audit").val();
		var createdTime = $("#input_created_time_search_purchase_order_audit").val().toString("yyyy-MM-dd");
		var url = $("#btn_output_data_purchase_order_audit").attr("url")+"?";
		url = url + "poid=" + poid + "&";
		url = url + "gname=" + gname + "&";
		url = url + "supplierId=" + supplierId + "&";
		url = url + "storageId=" + storageId + "&";
		url = url + "createrName=" + createrName + "&";
		url = url + "createdTime=" + createdTime + "&";
		url = url + "pageSize=" + pageSize + "&";
		url = url + "currentPage=" + currentPage + "&";
		$("#btn_output_data_purchase_order_audit").attr("href", url);
    }
    
    //订单创建时间栏格式化
    function updatedTimeFormatter(value, row, index) {
    	var time = value;
    	var result = dateFormat(time);
    	return result;
    }
    

	// 搜索方法
	function search() {
		$('#purchase_order_table_audit').bootstrapTable('refresh');
		setOutputUrl();
	}
	
	// 重置方法
	function refresh() {
		$(".form")[0].reset();
		search();
	}
	
	$("#btn_search_purchase_order_audit").click(function(){
		$('#purchase_order_table_audit').bootstrapTable('refresh');
	});
	
	//获取仓库列表数据
	function getStorages(){
		var select = $("#input_storage_name_search_purchase_order_audit");
		var url = select.attr("url");
		$.post(url,
				{},
				    function(result,status){
					   var html = "<option value=''>请选择仓库</option>";
					   select.empty();
					   if(result != null) {
						   for(i = 0; i <result.length; i++){
							   var option = result[i];
							   html = html +"<option value=" +  option.sid +  " sid= " + option.sid + ">" + option.name + "</option>"
						   }
					   }
					   select.html(html);
				   }
		);
	}
	
	//获取供应商列表数据
	function getSuppliers(){
		var select = $("#input_supplier_name_search_purchase_order_audit");
		var url = select.attr("url");
		$.post(url,
				{},
				function(result,status){
					var html = "<option value>请选择供应商</option>";
					select.empty();
					if(result != null) {
						for(i = 0; i <result.length; i++){
							var option = result[i];
							html = html +"<option value=" +  option.sid +  " sid= " + option.sid + ">" + option.name + "</option>"
						}
					}
					select.html(html);
				}
		);
	}
	
	//获取订单状态列表的数据
	function getOrderStatuses(){
		var select = $("#input_audit_status_search_purchase_order_audit");
		var url = select.attr("url");
		$.post(url,
				{},
				function(result,status){
					var html = "<option value>请选择订单的审核状态</option>";
					select.empty();
					if(result != null) {
						for(i = 0; i <result.length; i++){
							var option = result[i];
							html = html +"<option value=" +  option.osid +  " osid= " + option.osid + ">" + option.name + "</option>"
						}
					}
					select.html(html);
				}
		);
	}
	//获取供应商列表数据
	function getSuppliers(){
		var select = $("#input_supplier_name_search_purchase_order_audit");
		var url = select.attr("url");
		$.post(url,
				{},
				function(result,status){
					var html = "<option value>请选择供应商</option>";
					select.empty();
					if(result != null) {
						for(i = 0; i <result.length; i++){
							var option = result[i];
							html = html +"<option value=" +  option.sid +  " sid= " + option.sid + ">" + option.name + "</option>"
						}
					}
					select.html(html);
				}
		);
	}
	
	$("#btn_delete_client_manage").click(function(){
		var items = $('#purchase_order_table_audit').bootstrapTable("getSelections");
		var cids = new Array();
		for(i = 0; i < items.length; i ++){
			cids[i] = (items[i].cid) ;
		}
		var url = $("#btn_delete_client_manage").attr("url");
		$.post(url,
		   {
			   cids: cids,
			   dataType:"json", 
		   },
		    function(status,result){
			   if(status.isSucceed == true) {
					$('#purchase_order_table_audit').bootstrapTable('refresh');
					toastr.success('删除成功');
			   }else {
				   toastr.error('删除失败');
			   }
		   }
		);
		
	});
	
});


