$(document).ready(function() {
    var validator = $("#edit_goods_param_form").validate({rules : {
		goods_param_name_input_edit : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		goods_param_type_input_edit : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		goods_param_description_input_edit : {
			required : true,
			minlength : 2,
			maxlength:11
		}
	},
		messages : {
			goods_param_name_input_edit : {
				required : "请输入商品规格名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			goods_param_type_input_edit : {
				required : "请输入商品类型名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			goods_param_description_input_edit : {
				required : "请输入商品规格描述",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			}
		}
	});
    
    setUpResetForm("#editgoods_paramesModal", validator);
    
    $("#summit_goods_param_edit").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#editgoods_paramesModal").attr("url");
    		var name = $("#goods_param_name_input_edit").val();
    		var gspecificationType = $("#goods_param_type_input_edit").val();
    		var description = $("#goods_param_description_input_edit").val();
    		var gspecificationId = $("#editgoods_paramesModal").attr("gspecificationId");
    		// 编辑
    		var form_data = new FormData();
    		form_data.append("name", name);
    		form_data.append("gspecificationType", gspecificationType);
    		form_data.append("description", description);
    		form_data.append("gspecificationId", gspecificationId);
     	     $.ajax({  
     	          url: url ,  
     	          type: 'POST',  
     	          data: form_data,  
     	          async: false,  
     	          cache: false,  
     	          contentType: false,  
     	          processData: false,  
     	          success: function (data, status) {  
  					if(data.isSucceed) {
  						$('#editgoods_paramesModal').modal('hide');
  						$('#goods_param_manage_table').bootstrapTable('refresh');
  						showSuccess('编辑成功！');
  					}else{
  						showError('编辑失败！');
  					}
     	          },  
     	          error: function (returndata) {  
  					showError('编辑失败！');
     	          }  
     	     });  
     		
    	}else{
    		showError('参数有误！！');
    	}
    });
	
});

