$(document).ready(function() {
	getSuppliers();
	getStorages();
	getGoodses();
	getClients();
	getSpecifications();
	  var validator = $("#create_sales_order_form").validate({rules : {
		  input_goods_name_sales_order_create : {
				required : true,
				url : false
			},
			input_client_name_sales_order_create : {
				required : true,
				url : false
			},
			input_supplier_name_sales_order_create : {
				required : true,
				url : false
			},
			input_goods_specification_sales_order_create : {
				required : true,
				url : false
			},
			input_storage_name_sales_order_create : {
				required : true,
				url : false
			},
			input_goods_count_sales_order_create : {
				required : true,
				number:true,
				maxlength:200
			},
			input_goods_price_sales_order_create : {
				required : true,
				number:true,
				maxlength:200
			},
			input_appendix_sales_order_create : {
				required : true,
				maxlength:500
			}
		},
			messages : {
				input_goods_name_sales_order_create : {
					required : "请选择商品名称"
				},
				input_client_name_sales_order_create : {
					required : "请选择客户名称"
				},
				input_supplier_name_sales_order_create  : {
					required : "请选择供应商"
				},
				input_goods_specification_sales_order_create  : {
					required : "请选择商品规格"
				},
				input_storage_name_sales_order_create  : {
					required : "请选择入库仓库"
				},
				input_goods_count_sales_order_create  : {
					required : "请输入商品数量",
					maxlength: "请输入最多15位"
				},
				input_goods_price_sales_order_create  : {
					required : "请输入商品的价格",
					number : "请输入数字类型",
					maxlength: "请输入最多15位"
				},
				input_appendix_sales_order_create  : {
					required : "请输入订单备注",
					maxlength: "请输入最多500位字符"
				}
			}
		});
	    
	setUpResetForm("#createSalesModal", validator);
    
    
    //提交
    $("#summit_sales_order_create").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#createSalesModal").attr("url");
    		var salesOrderGid = $("#input_goods_name_sales_order_create").val();
    		var salesOrderGspecificationId = $("#input_goods_specification_sales_order_create").val();
    		var supplierId = $("#input_supplier_name_sales_order_create").val();
    		var storageId = $("#input_storage_name_sales_order_create").val();
    		var num = $("#input_goods_count_sales_order_create").val();
    		var price = $("#input_goods_price_sales_order_create").val();
    		var cid = $("#input_client_name_sales_order_create").val();
    		var appendix = $("#input_appendix_sales_order_create").val();
    		var createrId = $("#createSalesModal").attr("createrId");
     		$.post(url,  {
     			salesOrderGid : salesOrderGid,
     			salesOrderGspecificationId : salesOrderGspecificationId,
     			supplierId : supplierId,
     			storageId : storageId,
     			salesOrderStoreId : storageId,
     			cid : cid,
     			num : num,
				price : price,
				appendix : appendix,
				createrId : createrId
     		},function(data,status){
					console.log( data);
					console.log(status);
					if(data.isSucceed) {
						$('#createSalesModal').modal('hide');
						$('#sales_order_table').bootstrapTable('refresh');
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
    	var price = $("#input_goods_price_sales_order_create").val() == null ? 0: $("#input_goods_price_sales_order_create").val();
    	var count = $("#input_goods_count_sales_order_create").val() == null ? 0:$("#input_goods_count_sales_order_create").val();
    	var sum = price * count;
    	$("#input_goods_sum_sales_order_create").val(sum);
    });
    
	//获取供应商列表数据
	function getSuppliers(){
		var select = $("#input_supplier_name_sales_order_create");
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
		var select = $("#input_storage_name_sales_order_create");
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
		var select = $("#input_goods_specification_sales_order_create");
		var url = select.attr("url");
		log(url);
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
		var select = $("#input_goods_name_sales_order_create");
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
	
	//获取订单客户名称列表数据
	function getClients(){
		var select = $("#input_client_name_sales_order_create");
		var url = select.attr("url");
		$.post(url,
				{},
				function(result,status){
					var html = "<option value=''>请选择订单的客户名称</option>";
					select.empty();
					if(result != null) {
						for(i = 0; i <result.length; i++){
							var option = result[i];
							html = html +"<option value=" +  option.cid +  " cid= " + option.cid + ">" + option.name + "</option>"
						}
					}
					select.html(html);
				}
		);
	}
    
});

