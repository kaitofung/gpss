$(document).ready(function(){

	//分页获取仓库信息
	var name = "";
	var pageSize = $("#select_page_size_goods_manage").val();
	var count = parseInt($("#url_holder_goods_manage").attr("all_data_count"));
	var tempTotalPages = parseInt(count / pageSize);
	var totalPages = count % pageSize ==0 ? tempTotalPages : tempTotalPages + 1;
	setPaginator(totalPages,1);
	search();
	setCheckListner("#cb_goods_manage_all","[id^=cb_goods_manage_]");
    initDelete();
	
	//设置分页
	function setPaginator(totalPages, currentPage){
		$.jqPaginator('#pagination_goodses', {
		    totalPages: totalPages,
		    visiblePages: 10,
		    currentPage: currentPage,
		    prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
		    next: '<li class="next"><a href="javascript:;">上一页</a></li>',
		    page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
		    onPageChange: function (num, type) {
		    	getgoodses(num);
		    }
		}); 
	}
	
	//根据页码查询数据
	function getgoodses(num){
		$("#cb_goods_manage_all").prop("checked",false);
    	var url = $("#url_holder_goods_manage").attr("url")
    	+"?pageSize=" + pageSize 
    	+ "&currentPage=" + num
    	+ "&name=" + name;
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
                	"<tr tr_goods_manage_gid= '" + data[i].gid + "' >"
                		+"<td><input cb_goods_manage_gid='" + data[i].gid + "' id='cb_goods_manage_" + data[i].gid + "'  type='checkbox'/></td>"
                		+"<td>" + data[i].gid + "</td>"
                		+"<td col-goods-name_gid='" + data[i].gid + "'>" + data[i].name + "</td>"
                		+"<td col-goods-producer_gid='" + data[i].gid + "'>" + data[i].producer + "</td>"
                		+"<td col-goods-price_gid='" + data[i].gid + "'>" + data[i].price + "</td>"
                		+"<td col-goods-gtype_gid='" + data[i].gid + "'>" + data[i].gtype + "</td>"
                		+"<td col-goods-gspecification_name_gid='" + data[i].gid + "'>" + data[i].gspecification_name + "</td>"
                		+"<td col-goods-photo_gid='" + data[i].gid + "'><img style='width:100px;height:100px;' alt='无图' src='" + data[i].photo + "'></td>"
                		+"<td col-goods-description_gid='" + data[i].gid + "'>" + data[i].description + "</td>"
                		+"<td>" 
                			+ "<button  data-toggle='modal' data-target='#editgoodsesModal' edit_btn_gid='"+ data[i].gid + "' type='button' class='edited-goods-btn btn btn-default btn-info btn-xs fa fa-edit 'style='margin: 2px'>编辑</button>" 
                	   + "</td>"
                +	"</tr>" 
                }  
                $('.itemContainer_goodses').empty().append(html); 
                initEdit();
            },  
        });  
	}
	
	//选择每页显示数据数量
	$("#select_page_size_goods_manage").change(function(){
		pageSize =$("#select_page_size_goods_manage").val();
		doSearch();
	});
	
	//根据输入页码进行跳页
	$("#btn_goto_goodses_goods-manage").click(function(){
		var page = parseInt($("#goto_page_goods-manage").val());
		setPaginator(totalPages, page);
	});
	
	//根据关键字搜索仓库
	function search(){
		$("#btn_search_goodses").click(function(){
			doSearch();
		});
	}
	
	//搜索的具体逻辑
	function doSearch(){
		name = $("#input_goodses_search_goods_manage").val();
		var url = $("#btn_search_goodses").attr("url");
		  $.post(url,{name:name},function(result){
			  count = result;
			  if(count == 0){
				  $("#pagination_goodses").attr("class","pagination hidden");
				  var html = "";
	          	  html +=
	               "<tr>"
	          		  +"<td colspan='8' style='text-align: center'>暂无数据！</td>"
          		  +"</tr>";
	          	  $('.itemContainer_goodses').empty().append(html); 
			  }else{
				  $("#pagination_goodses").attr("class","pagination");
			  }
			  var tempTotalPages = parseInt(count / pageSize);
			  var totalPages = count % pageSize ==0 ? tempTotalPages : tempTotalPages + 1;
			  setPaginator(totalPages,1);
		  });
	}
	
	//删除供应商信息
	function initDelete(){
		$("#btn_delete_goodses").click(function(){
			var array = new Array();
			var count = 0;
			for(i = 0; i <$("[cb_goods_manage_gid]").length; i++) {
				var item = $("[cb_goods_manage_gid]").get(i);
				if($(item).prop("checked") == true){
					array[count++] = $(item).attr("cb_goods_manage_gid");
				}
			}
			var url = $("#btn_delete_goodses").attr("url");
			$.post(url,
			   {
				   gids: array,
				   dataType:"json", 
			   },
			    function(status,result){
				   if(status.isSucceed == true) {
						for(i = 0; i <$("[tr_goods_manage_gid]").length; i++) {
							for(j = 0; j < array.length; j ++){
								var row = $("[tr_goods_manage_gid]").get(i);
								var gid = $(row).attr("tr_goods_manage_gid");
								if(array[j] == gid){
									$("[tr_goods_manage_gid='" + gid + "']").remove();
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
		$(".edited-goods-btn").click(function(){
			var gid = $(this).attr("edit_btn_gid");
			$("#editgoodsesModal").attr("gid",gid);
		});
	}
	

	

});


