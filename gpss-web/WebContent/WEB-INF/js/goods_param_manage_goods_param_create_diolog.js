$(document).ready(function() {
    var validator = $("#create_goods_param_form").validate({rules : {
		goods_param_name_input_create : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		goods_param_type_input_create : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		goods_param_description_input_create : {
			required : true,
			minlength : 2,
			maxlength:11
		}
	},
		messages : {
			goods_param_name_input_create : {
				required : "请输入商品规格名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			goods_param_type_input_create : {
				required : "请输入商品类型名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			goods_param_description_input_create : {
				required : "请输入商品规格描述",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			}
		}
	});
    
    setUpResetForm("#creategoods_paramesModal", validator);
    
    $("#summit_goods_param_create").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#creategoods_paramesModal").attr("url");
    		var name = $("#goods_param_name_input_create").val();
    		var gspecificationType = $("#goods_param_type_input_create").val();
    		var description = $("#goods_param_description_input_create").val();
    		// 创建
    		var form_data = new FormData();
    		form_data.append("name", name);
    		form_data.append("gspecificationType", gspecificationType);
    		form_data.append("description", description);
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
  						$('#creategoods_paramesModal').modal('hide');
  						showSuccess('创建成功！');
						$('#goods_param_manage_table').bootstrapTable('refresh');
  					}else{
  						showError('创建失败！');
  					}
     	          },  
     	          error: function (returndata) {  
  					showError('创建失败！');
     	          }  
     	     });  
     		
    	}else{
    		showError('参数有误！！');
    	}
    });
	
});

