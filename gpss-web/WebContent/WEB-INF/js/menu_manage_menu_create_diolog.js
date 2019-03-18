$(document).ready(function() {
	  var validator = $("#create_menu_form").validate({rules : {
		  menu_name_input_create : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			menu_url_input_create : {
				required : true,
//				url:true
			}
		},
			messages : {
				menu_name_input_create : {
					required : "请输入菜单名称",
					minlength : "请输入2-11位的字符",
					maxlength : "请输入2-11位的字符"
				},
				menu_url_input_create  : {
					required : "请输入url",
//					url: "请输入格式正确的url地址"
				}
			}
		});
	    
	setUpResetForm("#createMenuModal", validator);
    
    $("#summit_menu_create").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#createMenuModal").attr("url");
    		var param_url = $("#menu_url_input_create").val();
    		var name = $("#menu_name_input_create").val();
    		var parentId = $("#createMenuModal").attr("parentId")
     		$.post(url,  {
				name : name,
				url : param_url,
				parentId: parentId
     		},function(data,status){
					if(data.isSucceed) {
						$('#createMenuModal').modal('hide');
						toastr.success('创建成功');
						window.location.reload();
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

