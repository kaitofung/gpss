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

<table id="tb" ></table>
 
</body>     
<!-- jquery.treegrid.extension -->
<script src="../js/jquery.treegrid.extension.js"></script>
<script >
$(document).ready(function () {
    $('#tb').treegridData({
        id: 'Id',
        parentColumn: 'ParentId',
        type: "GET", //请求数据的ajax类型
        url: '/gpss-web/goods/TestMVC/GetData',   //请求数据的ajax的url
        ajaxParams: {}, //请求数据的ajax的data属性
        expandColumn: null,//在哪一列上面显示展开按钮
        striped: true,   //是否各行渐变色
        bordered: true,  //是否显示边框
        expandAll: false,  //是否全部展开
        columns: [
            {
                title: '机构名称',
                field: 'Name'
            },
            {
                title: '机构描述',
                field: 'Desc'
            }
        ]
    });
});
</script>
</html>  