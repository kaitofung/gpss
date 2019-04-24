$(document).ready(function(){

	var url = $('#client_manage_table').attr("url");
	$('#client_manage_table').bootstrapTable({
		method : 'get', // 服务器数据的请求方式 get or post
		url : url, // 服务器数据的加载地址
		striped : true, //是否显示行间隔色
		toolbar : "#toolbar", //toolbar
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
				name : $("#input_name_search_client_manage").val(),
			};
		},
		onLoadSuccess : function(params) {
			setOnEditClickLister();
		},
		columns : [ {
			checkbox : true
		}, 
		{
			field : 'cid',
			title : '客户ID'
		}, {
			field : 'name',
			title : '客户姓名'
		}, {
			field : 'phoneNum',
			title : '员工电话'
		}, {
			field : 'address',
			title : '客户地址',
			sortable : false
		}, {
			field : 'description',
			sortable : false,
			title : '客户描述'
		} , {
			field : 'updatedTime',
			sortable : false,
			title : '最后更新时间',
			formatter: updatedTimeFormatter
		} , {
			field : 'cid',
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
    	$("[btn_edit_client_manage_cid]").click(function(){
    		var cid = $(this).attr("btn_edit_client_manage_cid");
    		$("#editClientModal").attr("cid",cid);
    	});
    }
    
    
    
  //操作栏的格式化
    function actionFormatter(value, row, index) {
        var id = value;
        var result = "";
        result += "<a btn_edit_client_manage_cid='" + id + "' data-toggle='modal' data-target='#editClientModal' href='javascript:;' class='btn btn-xs blue' onclick=\"onEditClick('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
        return result;
    }
    
    //最后更新时间栏格式化
    function updatedTimeFormatter(value, row, index) {
    	var time = value;
    	var result = dateFormat(time);
    	return result;
    }
    

	// 搜索方法
	function search() {
		$('#client_manage_table').bootstrapTable('refresh');
	}
	// 重置方法
	function refresh() {
		$(".form")[0].reset();
		search();
	}
	
	$("#btn_search_client").click(function(){
		$('#client_manage_table').bootstrapTable('refresh');
	});
	
	$("#btn_delete_client_manage").click(function(){
		var items = $('#client_manage_table').bootstrapTable("getSelections");
		var cids = new Array();
		for(i = 0; i < items.length; i ++){
			cids[i] = (items[i].cid) ;
		}
		var url = $("#btn_delete_client_manage").attr("url");
		$.post(url,
		   {
			   cids: cids,
			   dataType:"json", 
		   },
		    function(status,result){
			   if(status.isSucceed == true) {
					$('#client_manage_table').bootstrapTable('refresh');
					toastr.success('删除成功');
			   }else {
				   toastr.error('删除失败');
			   }
		   }
		);
		
	});
	
	//分页获取商品信息
	var gspecificationType = "";
	var pageSize = $("#select_page_size_goods_param_manage").val();
	var count = parseInt($("#url_holder_goods_param_manage").attr("all_data_count"));
	var tempTotalPages = parseInt(count / pageSize);
	var totalPages = count % pageSize ==0 ? tempTotalPages : tempTotalPages + 1;
	setPaginator(totalPages,1);
	search();
	setCheckListner("#cb_goods_param_manage_all","[id^=cb_goods_param_manage_]");
    initDelete();
    getGoodsSpecificationTypes();
	//设置分页
	function setPaginator(totalPages, currentPage){
		$.jqPaginator('#pagination_goods_parames', {
		    totalPages: totalPages,
		    visiblePages: 10,
		    currentPage: currentPage,
		    prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
		    next: '<li class="next"><a href="javascript:;">下一页</a></li>',
		    page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
		    onPageChange: function (num, type) {
		    	getgoods_parames(num);
		    }
		}); 
	}
	
	function getGoodsSpecificationTypes(){
		var url = $("#input_goods_parames_search_goods_param_manage").attr("url");
		  $.post(url,{},function(result){
			  var html ="<option value=''>请选择参数类别</option>";
			  for(var i=0; i < result.length; i++){
				  html = html + "<option value='" + result[i] + "'>" + result[i] + "</option>"
			  }
			  $("#input_goods_parames_search_goods_param_manage").text("").append(html);
		  });
	}
	
	//根据页码查询数据
	function getgoods_parames(num){
		$("#cb_goods_param_manage_all").prop("checked",false);
    	var url = $("#url_holder_goods_param_manage").attr("url")
    	+"?pageSize=" + pageSize 
    	+ "&currentPage=" + num
    	+ "&gspecificationType=" + gspecificationType;
        $.ajax({  
            url: url,  
            success: function(data) {
            	var html = '';  
            	if(data == null || "" == data) {
            		html +=
                    	"<tr>"
                    		+"<td colspan='8' style='text-align: center'>暂无数据！</td>"
                    +	"</tr>";
            	}
                for(var i=0; i<data.length; i++) {  
                	html +=
                	"<tr tr_goods_param_manage_gspecificationId= '" + data[i].gspecificationId + "' >"
                		+"<td><input cb_goods_param_manage_gspecificationId='" + data[i].gspecificationId + "' id='cb_goods_param_manage_" + data[i].gspecificationId + "'  type='checkbox'/></td>"
                		+"<td>" + data[i].gspecificationId + "</td>"
                		+"<td col-goods_param-name_gspecificationId='" + data[i].gspecificationId + "'>" + data[i].name + "</td>"
                		+"<td col-goods_param-gspecificationType_gspecificationId='" + data[i].gspecificationId + "'>" + data[i].gspecificationType + "</td>"
                		+"<td col-goods_param-description_gspecificationId='" + data[i].gspecificationId + "'>" + data[i].description + "</td>"
                		+"<td>" 
                			+ "<button  data-toggle='modal' data-target='#editgoods_paramesModal' edit_btn_gspecificationId='"+ data[i].gspecificationId + "' type='button' class='edited-goods_param-btn btn btn-default btn-info btn-xs fa fa-edit 'style='margin: 2px'>编辑</button>" 
                	   + "</td>"
                +	"</tr>" 
                }  
                $('.itemContainer_goods_parames').empty().append(html); 
                initEdit();
            },  
        });  
	}
	
	//选择每页显示数据数量
	$("#select_page_size_goods_param_manage").change(function(){
		pageSize =$("#select_page_size_goods_param_manage").val();
		doSearch();
	});
	
	//根据输入页码进行跳页
	$("#btn_goto_goods_parames_goods_param-manage").click(function(){
		var page = parseInt($("#goto_page_goods_param-manage").val());
		setPaginator(totalPages, page);
	});
	
	//根据关键字搜索仓库
	function search(){
		$("#btn_search_goods_parames").click(function(){
			doSearch();
		});
	}
	
	//搜索的具体逻辑
	function doSearch(){
		gspecificationType = $("#input_goods_parames_search_goods_param_manage").val();
		var url = $("#btn_search_goods_parames").attr("url");
		  $.post(url,{gspecificationType:gspecificationType},function(result){
			  count = result;
			  if(count == 0){
				  $("#pagination_goods_parames").attr("class","pagination hidden");
				  var html = "";
	          	  html +=
	               "<tr>"
	          		  +"<td colspan='8' style='text-align: center'>暂无数据！</td>"
          		  +"</tr>";
	          	  $('.itemContainer_goods_parames').empty().append(html); 
			  }else{
				  $("#pagination_goods_parames").attr("class","pagination");
			  }
			  var tempTotalPages = parseInt(count / pageSize);
			  var totalPages = count % pageSize ==0 ? tempTotalPages : tempTotalPages + 1;
			  setPaginator(totalPages,1);
		  });
	}
	
	//删除商品规格信息
	function initDelete(){
		$("#btn_delete_goods_parames").click(function(){
			var array = new Array();
			var count = 0;
			for(i = 0; i <$("[cb_goods_param_manage_gspecificationId]").length; i++) {
				var item = $("[cb_goods_param_manage_gspecificationId]").get(i);
				if($(item).prop("checked") == true){
					array[count++] = $(item).attr("cb_goods_param_manage_gspecificationId");
				}
			}
			var url = $("#btn_delete_goods_parames").attr("url");
			$.post(url,
			   {
				   gspecificationIds: array,
				   dataType:"json", 
			   },
			    function(status,result){
				   if(status.isSucceed == true) {
						for(i = 0; i <$("[tr_goods_param_manage_gspecificationId]").length; i++) {
							for(j = 0; j < array.length; j ++){
								var row = $("[tr_goods_param_manage_gspecificationId]").get(i);
								var gspecificationId = $(row).attr("tr_goods_param_manage_gspecificationId");
								if(array[j] == gspecificationId){
									$("[tr_goods_param_manage_gspecificationId='" + gspecificationId + "']").remove();
								}
							}
						}
						toastr.success('删除成功');
						doSearch();
				   }else {
					   toastr.error('删除失败');
				   }
			   }
			);
		});
	}
	
	//编辑商品信息
	function initEdit(){
		$(".edited-goods_param-btn").click(function(){
			var gspecificationId = $(this).attr("edit_btn_gspecificationId");
			$("#editgoods_paramesModal").attr("gspecificationId",gspecificationId);
		});
	}
	
	
	

});


