<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">     
<html>     
<head>     
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>usersInfo</title>     
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"></script>


<!-- jquery.treegrid -->
<link href="https://cdn.bootcss.com/jquery-treegrid/0.2.0/css/jquery.treegrid.min.css" rel="stylesheet">
<script src="../js/jquery.treegrid.min.js"></script>


<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

</head>     
<body>    

你好，${Session.user.name!"--用户"},欢迎进入Gpss后台管理系统
 
</body>     
<script >

$("#foucusInput").on("blur",function(){
	var url = "http://t.weather.sojson.com/api/weather/city/101030100";
	/* $.post(url,
			{},
			function(result,status){
				console.log(result);
			}
	); */
	console.log("写你的查询事件");
});
</script>
</html>  