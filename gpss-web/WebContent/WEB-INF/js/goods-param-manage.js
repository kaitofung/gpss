$(document).ready(function(){
	getGoodsSpecificationTypes();
	var url = $('#goods_param_manage_table').attr("url");
	$('#goods_param_manage_table').bootstrapTable({
		method : 'get', // 服务器数据的请求方式 get or post
		url : url, // 服务器数据的加载地址
		striped : true, //是否显示行间隔色
		toolbar : "#goods_param_manage_toolbar", //toolbar
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, //是否显示分页（*）
		sortable : false, //是否启用排序
		//sortName : 'createTime',
		sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, //初始化加载第一页，默认第一页
		pageSize : 5, //每页的记录行数（*）
		pageList : [ 5, 25, 50, 100 ], //可供选择的每页的行数（*）
		strictSearch : true,
		minimumCountColumns : 2, //最少允许的列数
		clickToSelect : true, //是否启用点击选中行
		uniqucid : "ID", //每一行的唯一标识，一般为主键列
		cardView : false,
		detailView : true, //是否显示详细视图
		detailFormatter : detailFormatter,
		smartDisplay : false,
		showRefresh : true, // 显示刷新按钮
		//showToggle : true,
		//showColumns : true,
		search : false, //此设置为客户端搜索，意义不大
		strictSearch : false,//设置为 true启用全匹配搜索，否则为模糊搜索。
		sortOrder : "asc",
		queryParams : function(params) {
			return {
				pageSize : params.limit,
				currentPage : params.offset / params.limit + 1,
				gspecificationType : $("#input_goods_parames_search_goods_param_manage").val(),
			};
		},
		onLoadSuccess : function(params) {
			setOnEditClickLister();
		},
		columns : [ {
			checkbox : true
		}, 
		{
			field : 'gspecificationId',
			title : '商品规格ID'
		}, {
			field : 'name',
			title : '规格名称'
		}, {
			field : 'gspecificationType',
			title : '规格类别'
		}, {
			field : 'description',
			title : '规格描述',
			sortable : false
		}, {
			field : 'gspecificationId',
			title : '操作',
			formatter: actionFormatter
		} ]
	});
	
    function detailFormatter(index, row) {
        var html = [];
        $.each(row, function (key, value) {
            html.push('<p><b>' + key + ':</b> ' + value + '</p>');
        });
        return html.join('');
    }
    
    function setOnEditClickLister() {
    	$("[edit_btn_gspecificationId]").click(function(){
    		var gspecificationId = $(this).attr("edit_btn_gspecificationId");
    		$("#editgoods_paramesModal").attr("gspecificationId",gspecificationId);
    	});
    }
    
  //操作栏的格式化
    function actionFormatter(value, row, index) {
        var id = value;
        var result = "";
        result += "<button  data-toggle='modal' data-target='#editgoods_paramesModal' edit_btn_gspecificationId='"+ id + "' type='button' class='edited-goods_param-btn btn btn-default btn-info btn-xs fa fa-edit 'style='margin: 2px'>编辑</button>";
        return result;
    }

	// 搜索方法
	function search() {
		$('#goods_param_manage_table').bootstrapTable('refresh');
	}
	// 重置方法
	function refresh() {
		$(".form")[0].reset();
		search();
	}
	
	$("#btn_search_goods_parames").click(function(){
		refreshPage();
	});
	
	function refreshPage() {
		$('#goods_param_manage_table').bootstrapTable('refresh');
		getGoodsSpecificationTypes();
	}
	
	$("#btn_delete_goods_parames").click(function(){
		var items = $('#goods_param_manage_table').bootstrapTable("getSelections");
		var gspecificationIds = new Array();
		for(i = 0; i < items.length; i ++){
			gspecificationIds[i] = (items[i].gspecificationId) ;
		}
		var url = $("#btn_delete_goods_parames").attr("url");
		$.post(url,
		   {
			gspecificationIds: gspecificationIds,
			   dataType:"json", 
		   },
		    function(status,result){
			   if(status.isSucceed == true) {
				   refreshPage();
				   toastr.success('删除成功');
			   }else {
				   toastr.error('删除失败');
			   }
		   }
		);
		
	});
	
	function getGoodsSpecificationTypes(){
	var url = $("#input_goods_parames_search_goods_param_manage").attr("url");
	  $.post(url,{},function(result){
		  var html ="<option value>请选择参数类别</option>";
		  for(var i=0; i < result.length; i++){
			  html = html + "<option value='" + result[i] + "'>" + result[i] + "</option>"
		  }
		  $("#input_goods_parames_search_goods_param_manage").text("").append(html);
	  });
}
	
});


