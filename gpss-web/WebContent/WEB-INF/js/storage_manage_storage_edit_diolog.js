$(document).ready(function() {
	
    var validator = $("#edit_storage_form").validate({
		rules : {
			storage_name_input_edit : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			storage_address_input_edit : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			storage_description_input_edit : {
				required : true,
				minlength : 2,
				maxlength:11
			}
		},
		messages : {
			storage_name_input_edit : {
				required : "请输入仓库名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			storage_address_input_edit : {
				required : "请输入仓库地址",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			storage_description_input_edit : {
				required : "请输入仓库描述",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			}
		}
	});
    
    //模态框关闭时候，清除里面的表单数据
    setUpResetForm('#editStoragesModal', validator);
    
    //供应商表单提交逻辑
    $("#summit_storage_edit").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#editStoragesModal").attr("url");
    		var name = $("#storage_name_input_edit").val();
    		var address = $("#storage_address_input_edit").val();
    		var description = $("#storage_description_input_edit").val();
    		var sid = $("#editStoragesModal").attr("sid");
     		$.post(url,  {
				name : name,
				sid : sid,
				address : address,
				description : description
			},function(data,status){
					if(data.isSucceed) {
						$('#editStoragesModal').modal('hide');
						toastr.success('编辑成功');
						$('#storage_manage_table').bootstrapTable('refresh');
					} else{
						toastr.error('编辑失败');
					}
			    }
			);
    	}else{
    	}
    });
	    
});

