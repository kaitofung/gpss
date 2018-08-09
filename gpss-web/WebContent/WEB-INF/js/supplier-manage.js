$(document).ready(function(){

	//分页获取供应商信息
	var name = "";
	var pageSize = $("#select_page_size_sm").val();
	var count = parseInt($("#url_holder_supplier_manage").attr("all_data_count"));
	var totalPages = Math.round(count / pageSize);
	setPaginator(totalPages,1);
	search();
	setCheckListner();
    initDelete();
	
	//设置分页
	function setPaginator(totalPages, currentPage){
		$.jqPaginator('#pagination_suppliers', {
		    totalPages: totalPages,
		    visiblePages: 10,
		    currentPage: currentPage,
		    prev: '<li class="prev"><a href="javascript:;">Previous</a></li>',
		    next: '<li class="next"><a href="javascript:;">Next</a></li>',
		    page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
		    onPageChange: function (num, type) {
		    	getSuppliers(num);
		    }
		}); 
	}
	
	//根据页码查询数据
	function getSuppliers(num){
		$("#cb_supplier_manager_all").prop("checked",false);
    	var url = $("#url_holder_supplier_manage").attr("url")
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
                	"<tr tr_sm_sid= '" + data[i].sid + "' >"
                		+"<td><input cb_sm_sid='" + data[i].sid + "' id='cb_supplier_manager_" + data[i].sid + "'  type='checkbox'/></td>"
                		+"<td>" + data[i].sid + "</td>"
                		+"<td col-supplier-name_sid='" + data[i].sid + "'>" + data[i].name + "</td>"
                		+"<td col-supplier-contacts_name_sid='" + data[i].sid + "'>" + data[i].contacts_name + "</td>"
                		+"<td col-supplier-mobile_sid='" + data[i].sid + "'>" + data[i].mobile + "</td>"
                		+"<td col-supplier-address_sid='" + data[i].sid + "'>" + data[i].address + "</td>"
                		+"<td col-supplier-updatetime_sid='" + data[i].sid + "'>" + dateFormat(data[i].updatetime) + "</td>"
                		+"<td>" 
                			+ "<button  data-toggle='modal' data-target='#editSuppliersModal' edit_btn_sid='"+ data[i].sid + "' type='button' class='edited-supplier-btn btn btn-default btn-info btn-xs fa fa-edit 'style='margin: 2px'>编辑</button>" 
                	   + "</td>"
                +	"</tr>"
                }  
                $('.itemContainer_suppliers').empty().append(html); 
                initEdit();
            },  
        });  
	}
	
	//选择每页显示数据数量
	$("#select_page_size_sm").change(function(){
		pageSize =$("#select_page_size_sm").val();
		doSearch();
	});
	
	//根据输入页码进行跳页
	$("#btn_goto_suppliers_sm").click(function(){
		var page = parseInt($("#goto_page_sm").val());
		setPaginator(totalPages, page);
	});
	
	//根据关键字搜索供应商
	function search(){
		$("#btn_search_suppliers").click(function(){
			doSearch();
		});
	}
	
	//搜索的具体逻辑
	function doSearch(){
		name = $("#input_suppliers_search_supplier_manage").val();
		var url = $("#btn_search_suppliers").attr("url");
		  $.post(url,{name:name},function(result){
			  count = result;
			  if(count == 0){
				  $("#pagination_suppliers").attr("class","pagination hidden");
				  var html = "";
	          	  html +=
	               "<tr>"
	          		  +"<td colspan='8' style='text-align: center'>暂无数据！</td>"
          		  +"</tr>";
	          	  $('.itemContainer_suppliers').empty().append(html); 
			  }else{
				  $("#pagination_suppliers").attr("class","pagination");
			  }
			  var totalPages = Math.round(count / pageSize);
			  setPaginator(totalPages,1);
		  });
	}
	
	//设置表格全选实现
	function setCheckListner(){
		var id = "#cb_supplier_manager_all";
		$(id).change(function(checked){
			$("[id^=cb_supplier_manager_]").prop("checked",$(this).prop("checked"));
		});
		
	}
	
	//删除供应商信息
	function initDelete(){
		$("#btn_delete_suppliers").click(function(){
			var array = new Array();
			var count = 0;
			for(i = 0; i <$("[cb_sm_sid]").length; i++) {
				var item = $("[cb_sm_sid]").get(i);
				if($(item).prop("checked") == true){
					array[count++] = $(item).attr("cb_sm_sid");
				}
			}
			var url = $("#btn_delete_suppliers").attr("url");
			$.post(url,
			   {
				   sids: array,
				   dataType:"json", 
			   },
			    function(status,result){
				   if(status.isSucceed == true) {
						for(i = 0; i <$("[tr_sm_sid]").length; i++) {
							for(j = 0; j < array.length; j ++){
								var row = $("[tr_sm_sid]").get(i);
								var sid = $(row).attr("tr_sm_sid");
								if(array[j] == sid){
									$("[tr_sm_sid='" + sid + "']").remove();
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
	
	//编辑供应商信息
	function initEdit(){
		$(".edited-supplier-btn").click(function(){
			var sid = $(this).attr("edit_btn_sid");
			$("#editSuppliersModal").attr("sid",sid);
		});
	}
	/*$('#myModal').on('shown.bs.modal', function () {
		$(this).attr("uid",);
	})*/
	


});


