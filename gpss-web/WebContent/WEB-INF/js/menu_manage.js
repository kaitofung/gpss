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
			onLoadFinish : setOnLoadFinishLister(),
			columns : [ {
				title : '菜单名称',
				field : 'name'
			}, 
			{
				title : '地址',
				field : 'url'
			},
			{
				title : '节点',
				field : 'parentId',
				formatter : nodeFormatter
			},{
				title : '操作',
				field : 'mid',
				formatter : actionFormatter
			},
			]
		});
		
		
		  //操作栏的格式化
	    function actionFormatter(value, row) {
	    	var mid = value;
	    	 var editbtn = "";
	    	 var createbtn = "";
	    	 var deletebtn = "";
	    	 if("菜单" != row.name) {
	    		 editbtn = "<button  data-toggle='modal' data-target='#editMenuModal' edit_btn_mid='"+ mid + "' type='button' class=' btn btn-default btn-info btn-xs fa fa-edit 'style='margin: 2px'>编辑</button>";
	    		 deletebtn = "<button menuUrl='"+row.url+"' menuName='"+row.name+"' data-toggle='modal' data-target='#removeMenuModal' remove_btn_mid='"+ mid + "' type='button' class=' btn btn-default btn-danger btn-xs fa fa-remove 'style='margin: 2px'>删除</button>";
	    	 }
	    		 if(row.url == null || row.url ==""){
	    		 createbtn = "<button  menu_level='" + row.menuLevel + "' create_btn_parentId='" + row.mid + "' data-toggle='modal' data-target='#createMenuModal' create_btn_mid='"+ "" + "' type='button' class=' btn btn-default btn-primary btn-xs fa fa-plus 'style='margin: 2px'>添加</button>";
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
	    
	    //选中栏
	    function checkboxFormatter(value, row, index) {
	    	var result = "<input type='checkbox' mid='" + value + "' ></input>";
	    	return result;
	    }
	    
	    function setOnEditClickLister() {
	    	  $('body').on('click','[edit_btn_mid]',function(){
	    		var mid = $(this).attr("edit_btn_mid");
	    		$("#editMenuModal").attr("mid",mid);
	          });
	    }
	    
	    function setOnCreateClickLister() {
	    	$('body').on('click','[create_btn_parentId]',function(){
	    		var parentId = $(this).attr("create_btn_parentId");
	    		var menu_level = $(this).attr("menu_level");
	    		$("#createMenuModal").attr("menuLevel",menu_level);
	    		$("#createMenuModal").attr("parentId",parentId);
	    	});
	    }
	    
	    function setOnRemoveClickLister() {
	    	$('body').on('click','[remove_btn_mid]',function(){
	    		var mid = $(this).attr("remove_btn_mid");
	    		var name = $(this).attr("menuName");
	    		var menuURL = $(this).attr("menuURL");
	    		var content = "要删除菜单 ：(" + name + ")  " + menuURL ;
	    		$("#body_modal_remove_menu").empty();
	    		$("#body_modal_remove_menu").text(content);
	    		var mid = $(this).attr("remove_btn_mid");
	    		$("#removeMenuModal").attr("mid",mid);
	    	});
	    }
	    
	    function setOnLoadFinishLister() {
	    	setOnEditClickLister();
	    	setOnCreateClickLister();
	    	setOnRemoveClickLister();
	    }
		
	});