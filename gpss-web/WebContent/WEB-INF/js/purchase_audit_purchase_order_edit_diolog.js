$(document).ready(function() {
	getOrderStatuses();
	  var validator = $("#edit_purchase_order_form_audit").validate({rules : {
		  input_order_status_purchase_order_audit_edit : {
				required : true,
				url : false
			},
			input_appendix_purchase_order_audit_edit : {
				required : true,
				maxlength:500
			}
		},
			messages : {
				input_order_status_purchase_order_audit_edit  : {
					required : "请选择订单状态"
				},
				input_appendix_purchase_order_audit_edit  : {
					required : "请输入订单备注",
					maxlength: "请输入最多500位字符"
				}
			}
		});
	    
	setUpResetForm("#editPurchaseOrderAuditModal", validator);
    
	
	//获取订单状态列表的数据
	function getOrderStatuses(){
		var select = $("#input_order_status_purchase_order_audit_edit");
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
    $("#summit_purchase_order_edit_audit").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#editPurchaseOrderAuditModal").attr("url");
    		var auditedContent = $("#input_appendix_purchase_order_audit_edit").val();
    		var poid = $("#editPurchaseOrderAuditModal").attr("poid");
    		var auditStatus = $("#input_order_status_purchase_order_audit_edit").val();
    		var storageCount = $("#editPurchaseOrderAuditModal").attr("num");
    		var gid = $("#editPurchaseOrderAuditModal").attr("gid");
    		var storageId = $("#editPurchaseOrderAuditModal").attr("storageId");
    		var gspecificationId = $("#editPurchaseOrderAuditModal").attr("gspecificationId");
    		var auditStatusName = $("#input_order_status_purchase_order_audit_edit").find("option:selected").text();
    		$.post(url,  {
     			poid : poid,
     			storageId : storageId,
     			purchaseOrderGid : gid,
     			purchaseOrderGspecificationId : gspecificationId,
     			num : storageCount,
				auditedContent : auditedContent,
				auditStatus : auditStatus,
				auditStatusName : auditStatusName
     		},function(data,status){
					if(data.isSucceed) {
						$('#editPurchaseOrderAuditModal').modal('hide');
						$('#purchase_order_table_audit').bootstrapTable('refresh');
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

