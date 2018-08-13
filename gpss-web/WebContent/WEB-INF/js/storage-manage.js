$(document).ready(function(){

	//分页获取仓库信息
	var name = "";
	var pageSize = $("#select_page_size_storage_manage").val();
	var count = parseInt($("#url_holder_storage_manage").attr("all_data_count"));
	var tempTotalPages = parseInt(count / pageSize);
	var totalPages = count % pageSize ==0 ? tempTotalPages : tempTotalPages + 1;
	setPaginator(totalPages,1);
	search();
	setCheckListner("#cb_storage_manage_all","[id^=cb_storage_manage_]");
    initDelete();
	
	//设置分页
	function setPaginator(totalPages, currentPage){
		$.jqPaginator('#pagination_storages', {
		    totalPages: totalPages,
		    visiblePages: 10,
		    currentPage: currentPage,
		    prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
		    next: '<li class="next"><a href="javascript:;">上一页</a></li>',
		    page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
		    onPageChange: function (num, type) {
		    	getStorages(num);
		    }
		}); 
	}
	
	//根据页码查询数据
	function getStorages(num){
		$("#cb_storage_manage_all").prop("checked",false);
    	var url = $("#url_holder_storage_manage").attr("url")
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
                	"<tr tr_storage_manage_sid= '" + data[i].sid + "' >"
                		+"<td><input cb_storage_manage_sid='" + data[i].sid + "' id='cb_storage_manage_" + data[i].sid + "'  type='checkbox'/></td>"
                		+"<td>" + data[i].sid + "</td>"
                		+"<td col-storage-name_sid='" + data[i].sid + "'>" + data[i].name + "</td>"
                		+"<td col-storage-ename_sid='" + data[i].sid + "'>" + data[i].ename + "</td>"
                		+"<td col-storage-mobile_sid='" + data[i].sid + "'>" + data[i].mobile + "</td>"
                		+"<td col-storage-address_sid='" + data[i].sid + "'>" + data[i].address + "</td>"
                		+"<td col-storage-description_sid='" + data[i].sid + "'>" + data[i].description + "</td>"
                		+"<td>" 
                			+ "<button  data-toggle='modal' data-target='#editStoragesModal' edit_btn_sid='"+ data[i].sid + "' type='button' class='edited-storage-btn btn btn-default btn-info btn-xs fa fa-edit 'style='margin: 2px'>编辑</button>" 
                	   + "</td>"
                +	"</tr>"
                }  
                $('.itemContainer_storages').empty().append(html); 
                initEdit();
            },  
        });  
	}
	
	//选择每页显示数据数量
	$("#select_page_size_storage_manage").change(function(){
		pageSize =$("#select_page_size_storage_manage").val();
		doSearch();
	});
	
	//根据输入页码进行跳页
	$("#btn_goto_storages_storage-manage").click(function(){
		var page = parseInt($("#goto_page_storage-manage").val());
		setPaginator(totalPages, page);
	});
	
	//根据关键字搜索仓库
	function search(){
		$("#btn_search_storages").click(function(){
			doSearch();
		});
	}
	
	//搜索的具体逻辑
	function doSearch(){
		name = $("#input_storages_search_storage_manage").val();
		var url = $("#btn_search_storages").attr("url");
		  $.post(url,{name:name},function(result){
			  console.log("符合关键字 ：" + count);
			  count = result;
			  if(count == 0){
				  $("#pagination_storages").attr("class","pagination hidden");
				  var html = "";
	          	  html +=
	               "<tr>"
	          		  +"<td colspan='8' style='text-align: center'>暂无数据！</td>"
          		  +"</tr>";
	          	  $('.itemContainer_storages').empty().append(html); 
			  }else{
				  $("#pagination_storages").attr("class","pagination");
			  }
			  var tempTotalPages = parseInt(count / pageSize);
			  var totalPages = count % pageSize ==0 ? tempTotalPages : tempTotalPages + 1;
			  setPaginator(totalPages,1);
		  });
	}
	
	//删除供应商信息
	function initDelete(){
		$("#btn_delete_storages").click(function(){
			var array = new Array();
			var count = 0;
			for(i = 0; i <$("[cb_storage_manage_sid]").length; i++) {
				var item = $("[cb_storage_manage_sid]").get(i);
				if($(item).prop("checked") == true){
					array[count++] = $(item).attr("cb_storage_manage_sid");
				}
			}
			var url = $("#btn_delete_storages").attr("url");
			$.post(url,
			   {
				   sids: array,
				   dataType:"json", 
			   },
			    function(status,result){
				   if(status.isSucceed == true) {
						for(i = 0; i <$("[tr_storage_manage_sid]").length; i++) {
							for(j = 0; j < array.length; j ++){
								var row = $("[tr_storage_manage_sid]").get(i);
								var sid = $(row).attr("tr_storage_manage_sid");
								if(array[j] == sid){
									$("[tr_storage_manage_sid='" + sid + "']").remove();
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
	
	//编辑仓库信息
	function initEdit(){
		$(".edited-storage-btn").click(function(){
			var sid = $(this).attr("edit_btn_sid");
			$("#editStoragesModal").attr("sid",sid);
		});
	}

});


