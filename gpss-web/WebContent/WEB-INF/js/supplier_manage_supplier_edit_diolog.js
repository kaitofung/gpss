$(document).ready(function() {
	   //自定义手机号验证
    jQuery.validator.addMethod("isphoneNum", function(value, element) {
        var length = value.length;
        var mobile = /^1[3|5|8]{1}[0-9]{9}$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写您的手机号码");
    
    var validator = $("#edit_supplier_form").validate({
		rules : {
			supplier_name_input_edit : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			supplier_contacts_input_edit : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			supplier_mobile_input_edit : {
				required : true,
				maxlength:11,
	            isphoneNum:true
			},
			supplier_address_input_edit : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			supplier_description_input_edit : {
				required : true,
				minlength : 2,
				maxlength:11
			}
		},
		messages : {
			supplier_name_input_edit : {
				required : "请输入供应商名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			supplier_contacts_input_edit : {
				required : "请输入供应商联系人名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			supplier_mobile_input_edit : {
				required : "请输入手机号码",
				maxlength: "请输入11位的手机号码",
                isphoneNum: "请输入正确的手机号码"
			},
			supplier_address_input_edit : {
				required : "请输入供应商地址",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			supplier_description_input_edit : {
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
    $("#summit_supplier_edit").click(function(){
    	if(validateForm()){
            // jquery 表单提交   
    		var url = $("#editSuppliersModal").attr("url");
    		var name = $("#supplier_name_input_edit").val();
    		var contacts_name = $("#supplier_contacts_input_edit").val();
    		var address = $("#supplier_address_input_edit").val();
    		var mobile = $("#supplier_mobile_input_edit").val();
    		var description = $("#supplier_description_input_edit").val();
    		var sid = $("#editSuppliersModal").attr("sid");
     		$.post(url,  {
				name : name,
				sid : sid,
				address : address,
				contacts_name : contacts_name,
				description : description,
				mobile : mobile
			},function(data,status){
					console.log( data);
					console.log(status);
					if(data.isSucceed) {
						$('#editSuppliersModal').modal('hide');
						toastr.success('编辑成功');
						$("[col-supplier-name_sid="+sid+"]").empty().text(name);
						$("[col-supplier-mobile_sid="+sid+"]").empty().text(mobile);
						$("[col-supplier-address_sid="+sid+"]").empty().text(address);
						$("[col-supplier-contacts_name_sid="+sid+"]").empty().text(contacts_name);
						$("[col-supplier-updatetime_sid="+sid+"]").empty().text(dateFormat(new Date()));
					}
			    }
			);
    	}else{
    		console.log("参数有误！！");
    	}
    });
    	
    
    //模态框关闭时候，清除里面的表单数据
    $('#editSuppliersModal').on('hidden.bs.modal', function () {
    	validator.resetForm();
    });
	    
});

