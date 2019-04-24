	
	$(document).ready(function() {
		 	$.validator.setDefaults({
				submitHandler : function(form) {
					var url = $("#user_data_form").attr("url");
					var uid = $("#user_data_form").attr("uid");
					var password = $("#password").val();
					var newPassword = $("#newPassword").val();
					var newPasswordAgain = $("#newPasswordAgain").val();
					$.post(
							url,
							{
								uid : uid,
								password  : password,
								newPassword : newPassword,
								newPasswordAgain : newPasswordAgain
							},
							function(data, status) {
								if(data.isSuccessful) {
									toastr.success('修改成功');
								} else {
									toastr.error('修改失败');
								}
							});
//					form.submit();
				}
			});

			// 在键盘按下并释放及提交后验证提交表单
			$("#user_data_form").validate({
				rules : {
					password : {
						required : true,
						minlength : 6,
						maxlength:16
					},
					newPassword : {
						required : true,
						minlength : 6,
						maxlength:16
					},
					newPasswordAgain : {
						required : true,
						minlength : 6,
						maxlength:16,
						validateSamePassword:true
					}
				},
				messages : {
					password : {
						required : "请输入原密码",
						minlength : "请输入至少6位字符",
						maxlength : "输入字符最多16位"
					},
					newPassword : {
						required : "请输入新密码",
						minlength : "请输入至少6位字符",
						maxlength : "输入字符最多16位"
					},
					newPasswordAgain : {
						required : "请再次输入新密码",
						minlength : "请输入至少6位字符",
						maxlength : "输入字符最多16位",
						validateSamePassword : "两次输入的新密码不一致"
					}
				}
			});
			
		    
		    //自定义验证两次新密码输入
		    jQuery.validator.addMethod("validateSamePassword", function(value, element) {
		    	var newPassword = $("#newPassword").val();
		    	var newPasswordAgain = $("#newPasswordAgain").val();
		    	return newPassword == newPasswordAgain;
		    }, "两次输入的新密码不一致");

		
		
	});



