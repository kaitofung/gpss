$(document).ready(function() {
	getSuppliers();
	getStorages();
	getGoodses();
	getSpecifications();
	  var validator = $("#edit_purchase_order_form").validate({rules : {
		  input_goods_name_purchase_order_edit : {
				required : true,
				url : false
			},
			input_supplier_name_purchase_order_edit : {
				required : true,
				url : false
			},
			input_goods_specification_purchase_order_edit : {
				required : true,
				url : false
			},
			input_storage_name_purchase_order_edit : {
				required : true,
				url : false
			},
			input_goods_count_purchase_order_edit : {
				required : true,
				number:true,
				maxlength:200
			},
			input_goods_price_purchase_order_edit : {
				required : true,
				number:true,
				maxlength:200
			},
			input_appendix_purchase_order_edit : {
				required : true,
				maxlength:500
			}
		},
			messages : {
				input_goods_name_purchase_order_edit : {
					required : "请选择商品名称"
				},
				input_supplier_name_purchase_order_edit  : {
					required : "请选择供应商"
				},
				input_goods_specification_purchase_order_edit  : {
					required : "请选择商品规格"
				},
				input_storage_name_purchase_order_edit  : {
					required : "请选择入库仓库"
				},
				input_goods_count_purchase_order_edit  : {
					required : "请输入商品数量",
					maxlength: "请输入最多15位"
				},
				input_goods_price_purchase_order_edit  : {
					required : "请输入商品的价格",
					number : "请输入数字类型",
					maxlength: "请输入最多15位"
				},
				input_appendix_purchase_order_edit  : {
					required : "请输入订单备注",
					maxlength: "请输入最多500位字符"
				}
			}
		});
	    
	setUpResetForm("#editPurchaseOrderModal", validator);
    
    
    //提交
    $("#summit_purchase_order_edit").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#editPurchaseOrderModal").attr("url");
    		var purchaseOrderGid = $("#input_goods_name_purchase_order_edit").val();
    		var purchaseOrderGspecificationId = $("#input_goods_specification_purchase_order_edit").val();
    		var supplierId = $("#input_supplier_name_purchase_order_edit").val();
    		var storageId = $("#input_storage_name_purchase_order_edit").val();
    		var num = $("#input_goods_count_purchase_order_edit").val();
    		var price = $("#input_goods_price_purchase_order_edit").val();
    		var appendix = $("#input_appendix_purchase_order_edit").val();
    		var poid = $("#editPurchaseOrderModal").attr("poid");
     		$.post(url,  {
     			purchaseOrderGid : purchaseOrderGid,
     			purchaseOrderGspecificationId : purchaseOrderGspecificationId,
     			supplierId : supplierId,
     			storageId : storageId,
     			purchaseOrderStoreId : storageId,
     			poid : poid,
     			num : num,
				price : price,
				appendix : appendix,
     		},function(data,status){
					if(data.isSucceed) {
						$('#editPurchaseOrderModal').modal('hide');
						$('#purchase_order_table').bootstrapTable('refresh');
						toastr.success('创建成功');
					} else{
						toastr.error('创建失败');
					}
			    }
			);
     		
    	}else{
    		showError('参数有误！！');
    	}
    });
    
    //根据单价与数量计算总价
    $("[linkage='money']").on("blur",function(){
    	var price = $("#input_goods_price_purchase_order_edit").val() == null ? 0: $("#input_goods_price_purchase_order_edit").val();
    	var count = $("#input_goods_count_purchase_order_edit").val() == null ? 0:$("#input_goods_count_purchase_order_edit").val();
    	var sum = price * count;
    	$("#input_goods_sum_purchase_order_edit").val(sum);
    });
    
	//获取供应商列表数据
	function getSuppliers(){
		var select = $("#input_supplier_name_purchase_order_edit");
		var url = select.attr("url");
		$.post(url,
				{},
				function(result,status){
					var html = "<option value=''>请选择订单的供应商</option>";
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
	
	//获取仓库列表数据
	function getStorages(){
		var select = $("#input_storage_name_purchase_order_edit");
		var url = select.attr("url");
		$.post(url,
				{},
				    function(result,status){
					   var html = "<option value=''>请选择订单的入库仓库</option>";
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
	
	//获取商品规格列表数据
	function getSpecifications(){
		var select = $("#input_goods_specification_purchase_order_edit");
		var url = select.attr("url");
		$.post(url,
				{},
				function(result,status){
					var html = "<option value=''>请选择订单的商品规格</option>";
					select.empty();
					if(result != null) {
						for(i = 0; i <result.length; i++){
							var option = result[i];
							html = html +"<option value=" +  option.gspecificationId +  " gspecificationId= " + option.gspecificationId + ">" + option.name + "</option>"
						}
					}
					select.html(html);
				}
		);
	}
	
	//获取商品列表数据
	function getGoodses(){
		var select = $("#input_goods_name_purchase_order_edit");
		var url = select.attr("url");
		$.post(url,
				{},
				function(result,status){
					var html = "<option value=''>请选择订单的商品名称</option>";
					select.empty();
					if(result != null) {
						for(i = 0; i <result.length; i++){
							var option = result[i];
							html = html +"<option value=" +  option.gid +  " gid= " + option.gid + ">" + option.name + "</option>"
						}
					}
					select.html(html);
				}
		);
	}
    
});

