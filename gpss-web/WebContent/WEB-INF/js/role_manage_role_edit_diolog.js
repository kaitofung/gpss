$(document).ready(function() {
	  var validator = $("#edit_role_form").validate({rules : {
		  role_name_input_edit : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			role_description_input_edit : {
				required : true,
				minlength : 2,
				maxlength:11
			}
		},
			messages : {
				role_name_input_edit : {
					required : "请输入角色名称",
					minlength : "请输入2-11位的字符",
					maxlength : "请输入2-11位的字符"
				},
				role_description_input_edit  : {
					required : "请输入角色描述",
					minlength : "请输入2-11位的字符",
					maxlength : "请输入2-11位的字符"
				}
			}
		});
	    
	setUpResetForm("#editRoleModal", validator);
    
    
    //提交
    $("#summit_role_edit").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#editRoleModal").attr("url");
    		var name = $("#role_name_input_edit").val();
    		var description = $("#role_description_input_edit").val();
    		var rid = $("#editRoleModal").attr("rid");
     		$.post(url,  {
				name : name,
				description : description,
				rid : rid
     		},function(data,status){
					console.log( data);
					console.log(status);
					if(data.isSucceed) {
						$('#editRoleModal').modal('hide');
						$('#role_manage_table').bootstrapTable('refresh');
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
    
    	
});

