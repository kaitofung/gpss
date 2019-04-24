$(document).ready(function() {
    var validator = $("#create_storage_form").validate({rules : {
		storage_name_input_create : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		storage_manager_name_input_create : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		storage_mobile_input_create : {
			required : true,
			maxlength:11,
            isphoneNum:true
		},
		storage_address_input_create : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		storage_description_input_create : {
			required : true,
			minlength : 2,
			maxlength:11
		}
	},
		messages : {
			storage_name_input_create : {
				required : "请输入仓库名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			storage_manager_name_input_create : {
				required : "请输入仓库管理员名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			storage_mobile_input_create : {
				required : "请输入手机号码",
				maxlength: "请输入11位的手机号码",
                isphoneNum: "请输入正确的手机号码"
			},
			storage_address_input_create : {
				required : "请输入仓库地址",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			storage_description_input_create : {
				required : "请输入仓库描述",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			}
		}
	});
    
    setUpResetForm("#createStoragesModal", validator);
    
    //供应商表单提交逻辑
    $("#summit_storage_create").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#createStoragesModal").attr("url");
    		var name = $("#storage_name_input_create").val();
    		var ename = $("#storage_manager_name_input_create").val();
    		var address = $("#storage_address_input_create").val();
    		var mobile = $("#storage_mobile_input_create").val();
    		var description = $("#storage_description_input_create").val();
     		$.post(url,  {
				name : name,
				address : address,
				ename : ename,
				description : description,
				mobile : mobile
			},function(data,status){
					if(data.isSucceed) {
						$('#createStoragesModal').modal('hide');
						showSuccess('创建成功！');
						$('#storage_manage_table').bootstrapTable('refresh');
					}else{
						showError('创建失败！');
						$('#createStoragesModal').modal('hide');
					}
			    }
			);
    	}else{
    		showError('参数有误！！');
    	}
    });
    	
});

