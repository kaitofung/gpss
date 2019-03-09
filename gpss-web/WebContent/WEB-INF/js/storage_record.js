$(document).ready(function(){
	var url = $('#storage_record_manage_table').attr("url");
	getStorages();
	getSpecifications();
	$('#storage_record_manage_table').bootstrapTable({
		method : 'get', // 服务器数据的请求方式 get or post
		url : url, // 服务器数据的加载地址
		striped : true, //是否显示行间隔色
		toolbar : "#toolbar", //toolbar
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, //是否显示分页（*）
		sortable : true, //是否启用排序
		//sortName : 'createTime',
		sidePagination : "server", //分页方式：storage_record客户端分页，server服务端分页（*）
		pageNumber : 1, //初始化加载第一页，默认第一页
		pageSize : 5, //每页的记录行数（*）
		pageList : [ 5, 25, 50, 100 ], //可供选择的每页的行数（*）
		strictSearch : true,
		minimumCountColumns : 2, //最少允许的列数
		clickToSelect : true, //是否启用点击选中行
		uniqusrid : "ID", //每一行的唯一标识，一般为主键列
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
				gname : $("#input_name_search_storage_record_manage").val(),
				gspecificationId : $("#input_name_gspecification_search_storage_record").val(),
				storageId : $("#input_name_search_storage_storage_record").val()
			};
		},
		onLoadSuccess : function(params) {
			setOnEditClickLister();
		},
		columns : [ {
			checkbox : true
		}, 
		{
			field : 'srid',
			title : 'ID'
		}, {
			field : 'gname',
			title : '商品名称'
		}, {
			field : 'gspecificationName',
			title : '商品规格'
		}, {
			field : 'storageName',
			title : '仓库名称',
			sortable : true
		}, 
		 {
			field : 'storageCount',
			title : '库存量',
			sortable : true
		},
		{
			field : 'salesCount',
			title : '销售量',
			sortable : true
		},
		{
			field : 'avgPurchasePrice',
			title : '平均进价',
			sortable : true
		},
		{
			field : 'preditedPrice',
			title : '预设售价',
			sortable : true
		},
		{
			field : 'storageSumValue',
			title : '库存总值',
			sortable : true
		},
		{
			field : 'salesSumValue',
			title : '销售总值',
			sortable : true
		},
		 {
			field : 'srid',
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
    	$("[btn_edit_storage_record_manage_srid]").click(function(){
    		var srid = $(this).attr("btn_edit_storage_record_manage_srid");
    		$("#editStorageRecordModal").attr("srid",srid);
    	});
    }
    
    
    
  //操作栏的格式化
    function actionFormatter(value, row, index) {
        var id = value;
        var result = "";
        result += "<a btn_edit_storage_record_manage_srid='" + id + "' data-toggle='modal' data-target='#editStorageRecordModal' href='javascript:;' class='btn btn-xs blue' onclick=\"onEditClick('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
        return result;
    }
    
    //最后更新时间栏格式化
    function updatedTimeFormatter(value, row, index) {
    	var time = value;
    	var result = dateFormat(time);
    	return result;
    }
    
	//获取仓库列表数据
	function getStorages(){
		var select = $("#input_name_search_storage_storage_record");
		var url = select.attr("url");
		$.post(url,
				{},
				    function(result,status){
					   var html = "<option value>请选择要查询的仓库</option>";
					   select.empty();
					   if(result != null) {
						   for(i = 0; i <result.length; i++){
							   var option = result[i];
							   html = html +"<option value=" +  option.sid +  " sid= " + option.sid + ">" + option.name + "</option>"
						   }
					   }
					   select.html(html);
				   }
		);
	}
	
	
	//获取商品规格列表数据
	function getSpecifications(){
		var select = $("#input_name_gspecification_search_storage_record");
		var url = select.attr("url");
		$.post(url,
				{},
				function(result,status){
					var html = "<option value=''>请选择订单的商品规格</option>";
					select.empty();
					if(result != null) {
						for(i = 0; i <result.length; i++){
							var option = result[i];
							html = html +"<option value=" +  option.gspecificationId +  " gspecificationId= " + option.gspecificationId + ">" + option.name + "</option>"
						}
					}
					select.html(html);
				}
		);
	}
    

	// 搜索方法
	function search() {
		$('#storage_record_manage_table').bootstrapTable('refresh');
	}
	// 重置方法
	function refresh() {
		$(".form")[0].reset();
		search();
	}
	
	$("#btn_search_storage_record").click(function(){
		$('#storage_record_manage_table').bootstrapTable('refresh');
	});
	
	$("#btn_delete_storage_record_manage").click(function(){
		var items = $('#storage_record_manage_table').bootstrapTable("getSelections");
		var srids = new Array();
		for(i = 0; i < items.length; i ++){
			srids[i] = (items[i].srid) ;
		}
		var url = $("#btn_delete_storage_record_manage").attr("url");
		$.post(url,
		   {
			   srids: srids,
			   dataType:"json", 
		   },
		    function(status,result){
			   if(status.isSucceed == true) {
					$('#storage_record_manage_table').bootstrapTable('refresh');
					toastr.success('删除成功');
			   }else {
				   toastr.error('删除失败');
			   }
		   }
		);
		
	});
	
});


