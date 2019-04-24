$(document).ready(function() {
	  var validator = $("#edit_employee_form").validate({rules : {
			employee_name_input_edit : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			employee_mobile_input_edit : {
				required : true,
				maxlength:11,
	            isphoneNum:true
			},
			input_birthday_edit_employee_manage : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			input_employee_type_edit_employee_manage : {
				required : true,
				url:false
			}
		},
			messages : {
				employee_name_input_edit : {
					required : "请输入员工姓名",
					minlength : "请输入2-11位的字符",
					maxlength : "请输入2-11位的字符"
				},
				employee_mobile_input_edit  : {
					required : "请输入手机号码",
					maxlength: "请输入11位的手机号码",
	                isphoneNum: "请输入正确的手机号码"
				},
				input_birthday_edit_employee_manage : {
					required : "请选择生日日期",
					minlength : "请输入2-11位的字符",
					maxlength : "请输入2-11位的字符"
				},
				input_employee_type_edit_employee_manage : {
					required : "请选择员工类型"
				}
			}
		});
	    
	setUpResetForm("#editEmployeeModal", validator);
    getEmployeeTypes();
    
    $("#summit_employee_edit").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#editEmployeeModal").attr("url");
    		var name = $("#employee_name_input_edit").val();
    		var mobile = $("#employee_mobile_input_edit").val();
    		var etypeid = $("#input_employee_type_edit_employee_manage").val();
    		var birthday = $("#input_birthday_edit_employee_manage").val().toString("yyyy-MM-dd");
    		var updater = $("#editEmployeeModal").attr("updater");
    		var eid = $("#editEmployeeModal").attr("eid");
     		$.post(url,  {
				name : name,
				mobile : mobile,
				birthday : new Date(birthday),
				updater : updater,
				eid : eid,
				etypeid : etypeid
     		},function(data,status){
					if(data.isSucceed) {
						$('#editEmployeeModal').modal('hide');
						$('#employee_manage_table').bootstrapTable('refresh');
						toastr.success('编辑成功');
					} else{
						toastr.error('编辑失败');
					}
			    }
			);
     		
    	}else{
    		showError('参数有误！！');
    	}
    });
    
    //加载员工类型
    function getEmployeeTypes(){
			var url = $("#input_employee_type_edit_employee_manage").attr("url");
			  $.post(url,{},function(data){
					var html = "";
					$("#input_employee_type_edit_employee_manage").empty();
					html = html + "<option value=''>请选择员工类别</option>";
					if(data != null) {
						for(i = 0; i < data.length; i ++) {
							var item = data[i];
						html = html 
						+ "<option value='" + item.etypeid + "' etypeid='" + item.etypeid + "'>" + item.name + "</option>";
						}
						$("#input_employee_type_edit_employee_manage").html(html);
					}
			  });
    }
    	
});

