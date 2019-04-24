$(document).ready(function() {
	  var validator = $("#edit_client_form").validate({rules : {
			client_name_input_edit : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			client_mobile_input_edit : {
				required : true,
				maxlength:11,
	            isphoneNum:true
			},
			client_contacts_input_edit : {
				required : true,
				maxlength:11
			},
			client_description_input_edit : {
				required : true,
				maxlength:200
			},
			client_address_input_edit : {
				required : true,
				maxlength:15
			}
		},
			messages : {
				client_name_input_edit : {
					required : "请输入客户名称",
					minlength : "请输入2-11位的字符",
					maxlength : "请输入2-11位的字符"
				},
				client_mobile_input_edit  : {
					required : "请输入手机号码",
					maxlength: "请输入11位的手机号码",
	                isphoneNum: "请输入正确的手机号码"
				},
				client_address_input_edit  : {
					required : "请输入客户地址",
					maxlength: "请输入最多15位的字符"
				},
				client_description_input_edit  : {
					required : "请输入客户描述",
					maxlength: "请输入最多15位的字符"
				},
				client_contacts_input_edit  : {
					required : "请输入客户联系人",
					maxlength: "请输入最多15位的字符"
				},
			}
		});
	    
	setUpResetForm("#editClientModal", validator);
    
    
    //提交
    $("#summit_client_edit").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#editClientModal").attr("url");
    		var name = $("#client_name_input_edit").val();
    		var mobile = $("#client_mobile_input_edit").val();
    		var description = $("#client_description_input_edit").val();
    		var address = $("#client_address_input_edit").val();
    		var contacts = $("#client_contacts_input_edit").val();
    		var updater = $("#editClientModal").attr("updater");
    		var cid = $("#editClientModal").attr("cid");
     		$.post(url,  {
				name : name,
				phoneNum : mobile,
				description : description,
				address : address,
				contacts : contacts,
				cid : cid,
				updater : updater
     		},function(data,status){
					if(data.isSucceed) {
						$('#editClientModal').modal('hide');
						$('#client_manage_table').bootstrapTable('refresh');
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

