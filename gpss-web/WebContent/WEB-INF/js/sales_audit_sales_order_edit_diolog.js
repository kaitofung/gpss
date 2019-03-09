$(document).ready(function() {
	getOrderStatuses();
	  var validator = $("#edit_sales_order_form").validate({rules : {
		  input_order_status_sales_order_audit_edit : {
				required : true,
				url : false
			},
			input_appendix_sales_order_audit_edit : {
				required : true,
				maxlength:500
			}
		},
			messages : {
				input_order_status_sales_order_audit_edit  : {
					required : "请选择订单状态"
				},
				input_appendix_sales_order_audit_edit  : {
					required : "请输入订单备注",
					maxlength: "请输入最多500位字符"
				}
			}
		});
	    
	setUpResetForm("#editSalesOrderAuditModal", validator);
    
	
	//获取订单状态列表的数据
	function getOrderStatuses(){
		var select = $("#input_order_status_sales_order_audit_edit");
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
    
    //提交
    $("#summit_sales_order_edit").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#editSalesOrderAuditModal").attr("url");
    		var auditedContent = $("#input_appendix_sales_order_audit_edit").val();
    		var soid = $("#editSalesOrderAuditModal").attr("soid");
    		var auditStatus = $("#input_order_status_sales_order_audit_edit").val();
     		$.post(url,  {
     			soid : soid,
				auditedContent : auditedContent,
				auditStatus : auditStatus
     		},function(data,status){
					if(data.isSucceed) {
						$('#editSalesOrderAuditModal').modal('hide');
						$('#sales_order_table').bootstrapTable('refresh');
						toastr.success('审核成功');
					} else{
						toastr.error('审核失败');
					}
			    }
			);
     		
    	}else{
    		showError('参数有误！！');
    	}
    });
    
    
    
});

