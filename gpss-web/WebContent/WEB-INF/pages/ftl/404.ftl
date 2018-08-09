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
<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
</head>

<body style="background: url(../images/bg.jpg) no-repeat;">
	<h1>404</h1>
	<a href="${base}/user/adminsystem">回到首页</a>
	<script type="text/javascript">
		$("#catpchaImg").click(function() {
		
			$("#catpchaImg").attr("src","${base}/user/captcha?p=" + Math.random()) 
		});
	</script>
</body>
</html>
