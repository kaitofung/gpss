	function sub() {  
        // jquery 表单提交   
		var url = $("#editUserModal").attr("url");
		var updaterId = $("#editUserModal").attr("updater");
		var eid = $("#editUserModal").attr("eid");
		var realName = $("#real_name").val();
		var etypeid = $("#employee_type").val();
		var birthday = $("#birthday").val();
		var mobile = $("#mobile").val();
//		console.log( updaterId);
//		console.log( etypeid);
//		console.log( eid);

//		  $.post(url,{
//			  	eid : eid,
//				updaterId : updaterId,
//				realName : realName,
//				etypeid : 1,
//				birthday : birthday,
//				mobile : mobile
//				},
//				function(result){
//			  count = result;
//			  
//		  });
		
		$.post(url,  {
			eid : eid,
			updaterId : updaterId,
			realName : realName,
			etypeid : 1,
			birthday : birthday,
			mobile : mobile
		},function(data,status){
				console.log( data);
				console.log(status);
				if(data.isSuccessful) {
					$('#editUserModal').modal('hide');
					toastr.success('操作成功');
				}
		    }
		);
        return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转   
    }
	
	
	$("#data_modify_form").validate({
        submitHandler:function(form){
            form.submit();
        }    
    });

$(document).ready(function() {
	/**
	 * 提交修改资料
	 */
	$("#summit_data").click(function() {

	});
	
	
	$('.form_date').datetimepicker({
		language : 'ZH',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0
	});

	$(".form_date").datetimepicker({   
	      dateFormat: 'yy-mm-dd hh:ii',  
	      language: 'zh-CN',
	      autoclose:true
	  });  

	  $('.form_date').datetimepicker().on('changeDate',function(ev){
			this.focus();
			this.blur();
	  });

	  

		// 在键盘按下并释放及提交后验证提交表单
		$("#data_modify_form").validate({
			rules : {
				real_name : {
					required : true,
					minlength : 5,
					maxlength:11
				},
				employee_type : {
					required : true
				},
				dtp_input2 : {
					required : true,
					date:true
				},
				mobile : {
				    required: true,
	                maxlength:11,
	                isphoneNum:true
				}
			},
			messages : {
				real_name : {
					required : "请输入真实姓名",
					minlength : "真实姓名最少5个字符组成",
					maxlength : "真实姓名最多11个字符组成"
				},
				employee_type : {
					required : "请选择员工类型"
				},
				dtp_input2 : {
					required : "请选择生日日期",
					date: "生日日期必须为日期型"
				},
				mobile : {
					required : "请输入手机号码",
					maxlength: "请输入11位的手机号码",
	                isphoneNum: "请输入正确的手机号码"
				}
			}
		});
		
		   //自定义手机号验证
	    jQuery.validator.addMethod("isphoneNum", function(value, element) {
	        var length = value.length;
	        var mobile = /^1[3|5|8]{1}[0-9]{9}$/;
	        return this.optional(element) || (length == 11 && mobile.test(value));
	    }, "请正确填写您的手机号码");

	
	
});