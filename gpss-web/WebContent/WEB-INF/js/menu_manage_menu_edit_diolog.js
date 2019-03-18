$(document).ready(function() {
	  var validator = $("#edit_menu_form").validate({rules : {
		  menu_name_input_edit : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			menu_url_input_edit : {
				required : true,
//				url:true
			}
		},
			messages : {
				menu_name_input_edit : {
					required : "请输入菜单名称",
					minlength : "请输入2-11位的字符",
					maxlength : "请输入2-11位的字符"
				},
				menu_url_input_edit  : {
					required : "请输入url",
//					url: "请输入格式正确的url地址"
				}
			}
		});
	    
	setUpResetForm("#editMenuModal", validator);
    
    $("#summit_menu_edit").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#editMenuModal").attr("url");
    		var param_url = $("#menu_url_input_edit").val();
    		var name = $("#menu_name_input_edit").val();
    		var mid = $("#editMenuModal").attr("mid")
     		$.post(url,  {
				name : name,
				url : param_url,
				mid: mid
     		},function(data,status){
					if(data.isSucceed) {
						$('#editMenuModal').modal('hide');
						toastr.success('编辑成功');
						window.location.reload();
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

