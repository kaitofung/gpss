<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usersInfo</title>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"></script>


<!-- jquery.treegrid -->
<link
	href="https://cdn.bootcss.com/jquery-treegrid/0.2.0/css/jquery.treegrid.min.css"
	rel="stylesheet">
<script src="../js/jquery.treegrid.min.js"></script>

<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>
<body id="bodyy">
<div id="xxx" xx="qqq">
<div xx="xxx" aa="2" >
	<div >
	<div xxq="xxx" aa="lalalalala" id="xxx" class="ppp">
		
	</div>
	<div>
			
	</div>
</div>
	<table id="tb_menu_manage" url="${context}/system_manage/menus"></table>
	
</body>
<!-- jquery.treegrid.extension -->
<script src="../js/jquery.treegrid.extension.js"></script>
<script>
	console.log($("[xx='qqq'] [xxq='xxx']").attr("aa"));
	$(document).ready(function() {
		var url = $('#tb_menu_manage').attr("url");
		$('#tb_menu_manage').treegridData({
			id : 'mid',
			parentColumn : 'parentId',
			type : "GET", //请求数据的ajax类型
			url : url, //请求数据的ajax的url
			ajaxParams : {}, //请求数据的ajax的data属性
			expandColumn : null,//在哪一列上面显示展开按钮
			striped : true, //是否各行渐变色
			bordered : true, //是否显示边框
			expandAll : true, //是否全部展开
			columns : [ {
				title : '菜单名称',
				field : 'name'
			}, {
				title : '地址',
				field : 'url'
			},
			{
				title : '节点',
				field : 'parentId',
				formatter : nodeFormatter
			},{
				title : '操作',
				field : 'parentId',
				formatter : actionFormatter
			},
			]
		});
		
		  //操作栏的格式化
	    function actionFormatter(value, row, index) {
	    	 var editbtn = "";
	    	 var createbtn = "";
	    	 var deletebtn = "";
	     		 editbtn = "<button  data-toggle='modal' data-target='#editgoodsesModal' edit_btn_gid='"+ "" + "' type='button' class='edited-goods-btn btn btn-default btn-info btn-xs fa fa-edit 'style='margin: 2px'>编辑</button>";
	     		 deletebtn = "<button  data-toggle='modal' data-target='#editgoodsesModal' edit_btn_gid='"+ "" + "' type='button' class='edited-goods-btn btn btn-default btn-danger btn-xs fa fa-remove 'style='margin: 2px'>删除</button>";
	    		 if(value == null || value == 1){
	    		 createbtn = "<button  data-toggle='modal' data-target='#editgoodsesModal' edit_btn_gid='"+ "" + "' type='button' class='edited-goods-btn btn btn-default btn-danger btn-xs fa fa-plus 'style='margin: 2px'>添加</button>";
	    	 } 
		        var result = "";
	    		result += editbtn;
	    		result += deletebtn;
	    		result += createbtn;
		        return result;
	    }
		  
		  //节点栏的格式化
	    function nodeFormatter(value, row, index) {
	        var msg = value == null? "否": "是";
	        var result = "";
	        result += msg;
	        return result;
	       
	    }
		
	});
</script>
</html>
