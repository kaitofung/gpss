$(document).ready(function() {
	  var validator = $("#edit_storage_record_form").validate({rules : {
		  storage_record_price_input_edit : {
				required : true,
				number:true
			}
		},
			messages : {
				storage_record_price_input_edit : {
					required : "请输入预设售价",
					number : "请输入数字类型"
				}
			}
		});
	    
	setUpResetForm("#editStorageRecordModal", validator);
    
    
    //提交
    $("#summit_storage_record_edit").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#editStorageRecordModal").attr("url");
    		var preditedPrice = $("#storage_record_price_input_edit").val();
    		var srid = $("#editStorageRecordModal").attr("srid");
    		$.post(url,  {
    			srid : srid,
    			preditedPrice : preditedPrice
    		},function(data,status){
					if(data.isSucceed) {
						$('#editStorageRecordModal').modal('hide');
						$('#storage_record_manage_table').bootstrapTable('refresh');
						toastr.success('编辑成功');
					} else{
						toastr.error('编辑失败');
					}
			    }
			);
     		
    	}else{
    		showError('参数有误！！');
    	}
    });
    
    	
});

