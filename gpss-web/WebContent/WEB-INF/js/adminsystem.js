/**
 * 
 */


$(document).ready(function(){
	/**
	 * 系统左侧菜单被点击的选项卡
	 */
	$(".list-sub-item").click(function() {
		var btn_name = this.text;
		var count = parseInt($(".closed-tab-component").attr("count")) + 1;	
		$(".closed-tab-component").attr("count", count);
		var id = count;
		var url = $(this).attr("url");
		var item = {'id':id,'name':btn_name,'url':url,'closable':true};
		if($(".closed-tab-component").attr(btn_name) == null){
			$(".closed-tab-component").attr(btn_name, btn_name);
			closableTab.addTab(item);
		}else{
			closableTab.swithTab(item);
		}
	});
	
//	$.validator.setDefaults({
//		submitHandler : function() {
//			alert("提交事件!");
//		}
//	});
//	$().ready(function() {
//		// 在键盘按下并释放及提交后验证提交表单
//		$("#data_modify_form").validate({
//			rules : {
//				name : {
//					required : true,
//					minlength : 2
//				},
//				lastname : "required",
//				username : {
//					required : true,
//					minlength : 2
//				},
//				password : {
//					required : true,
//					minlength : 5
//				},
//				confirm_password : {
//					required : true,
//					minlength : 5,
//					equalTo : "#password"
//				},
//				email : {
//					required : true,
//					email : true
//				},
//				topic : {
//					required : "#newsletter:checked",
//					minlength : 2
//				},
//				agree : "required"
//			},
//			messages : {
//				firstname : "请输入您的名字",
//				lastname : "请输入您的姓氏",
//				username : {
//					required : "请输入用户名",
//					minlength : "用户名必需由两个字母组成"
//				},
//				password : {
//					required : "请输入密码",
//					minlength : "密码长度不能小于 5 个字母"
//				},
//				confirm_password : {
//					required : "请输入密码",
//					minlength : "密码长度不能小于 5 个字母",
//					equalTo : "两次密码输入不一致"
//				},
//				email : "请输入一个正确的邮箱",
//				agree : "请接受我们的声明",
//				topic : "请选择两个主题"
//			}
//		})
//	});
});
