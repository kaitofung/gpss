$(document).ready(function() {
	getRoles();
    var validator = $("#create_user_form").validate({rules : {
    	input_uid_user_manage : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		input_real_name_user_manage : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		input_nickName_user_manage : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		input_password_user_manage : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		input_role_user_manage : {
			required : true,
			url : false
		}
	},
		messages : {
			input_uid_user_manage : {
				required : "请输入用户id",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			input_password_user_manage : {
				required : "请输入用户密码",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			input_real_name_user_manage : {
				required : "请输入用户名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			input_nickName_user_manage : {
				required : "请输入用户昵称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			input_role_user_manage : {
				required : "请选择用户角色"
			}
		}
	});
    
    setUpResetForm("#createuserModal", validator);
    
    $("#summit_user_create").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#createuserModal").attr("url");
    		var uid = $("#input_uid_user_manage").val();
    		var realName = $("#input_real_name_user_manage").val();
    		var nickName = $("#input_nickName_user_manage").val();
    		var password = $("#input_password_user_manage").val();
    		var rid = $("#input_role_user_manage").val();
    		// 创建
    		var form_data = new FormData();
    		form_data.append("uid", uid);
    		form_data.append("realName", realName);
    		form_data.append("nickName", nickName);
    		form_data.append("password", password);
    		form_data.append("rid", rid);
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
  						$('#createuserModal').modal('hide');
  						showSuccess('创建成功！');
						$('#user_manage_table').bootstrapTable('refresh');
  					}else{
  						showError(data.resultMessage);
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
	
    
    //获取角色列表信息
    function getRoles(){
		var url = $("#input_role_user_manage").attr("url");
 		$.post(url,function(data,status){
				var html = "";
				$("#input_role_user_manage").empty();
				html = html + "<option value=''>请选择角色名称</option>";
				if(data != null) {
					for(i = 0; i < data.length; i ++) {
						var item = data[i];
					html = html 
					+ "<option value='" + item.rid + "' rid_user_manage='" + item.rid + "'>" + item.name + "</option>";
					}
					$("#input_role_user_manage").html(html);
				}
		    }
		);
	}

});

