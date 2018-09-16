$(document).ready(function() {
	  var validator = $("#create_employee_form").validate({rules : {
			employee_name_input_create : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			employee_mobile_input_create : {
				required : true,
				maxlength:11,
	            isphoneNum:true
			},
			input_birthday_create_employee_manage : {
				required : true,
				minlength : 2,
				maxlength:11
			},
			input_employee_type_create_employee_manage : {
				required : true,
				url:false
			}
		},
			messages : {
				employee_name_input_create : {
					required : "请输入员工姓名",
					minlength : "请输入2-11位的字符",
					maxlength : "请输入2-11位的字符"
				},
				employee_mobile_input_create  : {
					required : "请输入手机号码",
					maxlength: "请输入11位的手机号码",
	                isphoneNum: "请输入正确的手机号码"
				},
				input_birthday_create_employee_manage : {
					required : "请选择生日日期",
					minlength : "请输入2-11位的字符",
					maxlength : "请输入2-11位的字符"
				},
				input_employee_type_create_employee_manage : {
					required : "请选择员工类型"
				}
			}
		});
	    
	setUpResetForm("#createEmployeeModal", validator);
    getEmployeeTypes();
    
    $("#summit_employee_create").click(function(){
    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#createEmployeeModal").attr("url");
    		var name = $("#employee_name_input_create").val();
    		var mobile = $("#employee_mobile_input_create").val();
    		var etypeid = $("#input_employee_type_create_employee_manage").val();
    		var birthday = $("#input_birthday_create_employee_manage").val().toString("yyyy-MM-dd");
    		var updater = $("#createEmployeeModal").attr("updater");
     		$.post(url,  {
				name : name,
				mobile : mobile,
				birthday : new Date(birthday),
				updater : updater,
				etypeid : etypeid
     		},function(data,status){
					console.log( data);
					console.log(status);
					if(data.isSucceed) {
						$('#createEmployeeModal').modal('hide');
						$('#employee_manage_table').bootstrapTable('refresh');
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
    
    //加载员工类型
    function getEmployeeTypes(){
			var url = $("#input_employee_type_create_employee_manage").attr("url");
			  $.post(url,{},function(data){
					var html = "";
					$("#input_employee_type_create_employee_manage").empty();
					html = html + "<option value=''>请选择员工类别</option>";
					if(data != null) {
						for(i = 0; i < data.length; i ++) {
							var item = data[i];
						html = html 
						+ "<option value='" + item.etypeid + "' etypeid='" + item.etypeid + "'>" + item.name + "</option>";
						}
						$("#input_employee_type_create_employee_manage").html(html);
					}
			  });
    }
    	
});

