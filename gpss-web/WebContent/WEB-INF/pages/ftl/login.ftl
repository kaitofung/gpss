<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,user-scalable=no">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="../iconfont/style.css" type="text/css" rel="stylesheet">
<link href="../css/login.css" type="text/css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
</head>

<body style="background: url(../images/bg.jpg) no-repeat;">
	<div class="container wrap1" style="height: 450px;">
		<h2 class="mg-b20 text-center">gpssss登录</h2>
		<div
			class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
			<p class="text-center font16">用户登录</p>
			<form action="${base}/user/login" method="post">
				<div class="form-group mg-t20">
					<i class="icon-user icon_font"></i> <input type="text"
						class="login_input" id="uid" name="uid" placeholder="请输入用户名" value = "admin001"/>
				</div>
				<div class="form-group mg-t20">
					<i class="icon-lock icon_font"></i> <input type="password"
						class="login_input" id="password" name="password"
						placeholder="请输入密码" value="111111"/>
				</div>
				<div class="form-group mg-t20">
					<i class="icon-lock icon_font"></i> <input type="text"
						style="width: 60%" class="login_input" id="catpcha" name="catpcha"
						placeholder="请输入验证码" /> 
						<img id="catpchaImg" name="catpchaImg" style="width: 25%; height: 50%"
						alt="captcha" src="${base}/user/captcha" >
				</div>
				<div class="checkbox mg-b25">
					<label> <input type="checkbox" />记住我的登录信息
					</label>
				</div>
				<button style="" class="login_btn">登 录</button>
			</form>
		</div>
		<!--row end-->
	</div>
	<!--container end-->
	<script >
		$("#catpchaImg").click(function() {
		
			$("#catpchaImg").attr("src","${base}/user/captcha?p=" + Math.random()) 
		});
	</script>
</body>
</html>
