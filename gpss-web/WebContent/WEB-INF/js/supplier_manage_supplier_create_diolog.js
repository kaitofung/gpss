$(document).ready(function() {
	
	   //自定义手机号验证
    jQuery.validator.addMethod("isphoneNum", function(value, element) {
        var length = value.length;
        var mobile = /^1[3|5|8]{1}[0-9]{9}$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写您的手机号码");
    
    var validator = $("#create_supplier_form").validate({
		rules : {
			supplier_name_input_create : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			supplier_contacts_input_create : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			supplier_mobile_input_create : {
				required : true,
				maxlength:11,
	            isphoneNum:true
			},
			supplier_address_input_create : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			supplier_description_input_create : {
				required : true,
				minlength : 2,
				maxlength:11
			}
		},
		messages : {
			supplier_name_input_create : {
				required : "请输入供应商名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			supplier_contacts_input_create : {
				required : "请输入供应商联系人名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			supplier_mobile_input_create : {
				required : "请输入手机号码",
				maxlength: "请输入11位的手机号码",
                isphoneNum: "请输入正确的手机号码"
			},
			supplier_address_input_create : {
				required : "请输入供应商地址",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			supplier_description_input_create : {
				required : "请输入供应商地址",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			}
		}
	});
    
    
    //验证表单
    function validateForm(){
    	// 在键盘按下并释放及提交后验证提交表单
    	return validator.form();
    }

    
    //供应商表单提交逻辑
    $("#summit_supplier_create").click(function(){
    	if(validateForm()){
            // jquery 表单提交   
    		var url = $("#createSuppliersModal").attr("url");
    		var name = $("#supplier_name_input_create").val();
    		var contacts_name = $("#supplier_contacts_input_create").val();
    		var address = $("#supplier_address_input_create").val();
    		var mobile = $("#supplier_mobile_input_create").val();
    		var description = $("#supplier_description_input_create").val();
     		$.post(url,  {
				name : name,
				address : address,
				contacts_name : contacts_name,
				mobile : mobile,
				description : description,
				mobile : mobile
			},function(data,status){
					console.log( data);
					console.log(status);
					if(data.isSucceed) {
						$('#createSuppliersModal').modal('hide');
						toastr.success('创建成功');
					}
			    }
			);
    	}else{
    		console.log("参数有误！！");
    	}
    });
    	
    
    //模态框关闭时候，清除里面的表单数据
    $('#createSuppliersModal').on('hidden.bs.modal', function () {
    	validator.resetForm();
    });
	    
});

