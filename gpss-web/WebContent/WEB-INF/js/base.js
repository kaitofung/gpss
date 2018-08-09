   /**
    * 重置模态框的内容
    * @param modalName 模态框id
    * @param validator 需要重置的validator对象
    * @returns
    */
	function setUpResetForm(modalId, validator){
		$(modalId).on('hidden.bs.modal', function () {
			validator.resetForm();
		});
    }
	
	  //验证表单
    function validateForm(validator){
    	// 在键盘按下并释放及提交后验证提交表单
    	return validator.form();
    }
    
    //打印日志
    function log(info){
    	console.log(info);
    }
    
    //以吐司形式展示失败信息
    function showError(info){
    	 toastr.error(info);
    }
    
    //以吐司形式展示成功信息
    function showSuccess(info){
    	toastr.success(info);
    }
    
	   //自定义手机号验证
    jQuery.validator.addMethod("isphoneNum", function(value, element) {
        var length = value.length;
        var mobile = /^1[3|5|8]{1}[0-9]{9}$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写您的手机号码");
    
    
	//设置表格全选实现
	function setCheckListner(checkedAllId, checkboxs){
		$(checkedAllId).change(function(checked){
			$(checkboxs).prop("checked",$(this).prop("checked"));
		});
		
	}