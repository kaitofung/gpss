$(document).ready(function(){

	//分页获取用户信息
	var pageSize = 5;
	var count = parseInt($("#url_holder").attr("all_data_count"));
	var tempTotalPages = count / pageSize;
	var totalPages = Math.round(count / pageSize);
	$.jqPaginator('#pagination', {
	    totalPages: totalPages,
	    visiblePages: 10,
	    currentPage: 1,
	    prev: '<li class="prev"><a href="javascript:;">Previous</a></li>',
	    next: '<li class="next"><a href="javascript:;">Next</a></li>',
	    page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
	    onPageChange: function (num, type) {
	    	var url = $("#url_holder").attr("url")+"?pageSize="
	    	+ 5 
	    	+ "&currentPage="
	    	+ num;
	        $.ajax({  
	            url: url,  
	            success: function(data) {  
	                var html = '';  
	                for(var i=0; i<data.length; i++) {  
	    		    	var btnName = "";
	    		    	var btnClass = "";
	    		    	var stateContent = "";
	    		    	if(data[i].locked == 1) {
	    		    		btnClass = "locked-btn btn btn-default btn-danger btn-xs fa  fa-unlock-alt";
	    		    		btnName = "解锁";
	    		    		stateContent = "已锁定";
	    		    	} else {
	    		    		btnClass = "locked-btn btn btn-default btn-warning btn-xs fa  fa-lock";
	    		    		btnName = "锁定";
	    		    		stateContent = "未锁定";
	    		    	}
	                	html +=
	                	"<tr>"
	                		+"<td><input type='checkbox'/></td>"
	                		+"<td  >" + data[i].uid + "</td>"
	                		+"<td>" + data[i].realName + "</td>"
	                		+"<td>" + data[i].eid + "</td>"
//	                		+"<td>" + data[i].updatedTime + "</td>"
	                		+"<td>" + dateFormat(data[i].updatedTime) + "</td>"
//	                		+"<td>" + $.format.date(data[i].updatedTime, 'yyyy-MM-dd') + "</td>"
	                		+"<td id='lockState_" + data[i].uid + "'>" + stateContent + "</td>"
	                		+"<td>" 
	                			+ "<button locked='"+ data[i].locked + "' btn_uid='"+ data[i].uid + "' type='button' class='" + btnClass + "' style='margin: 2px'>" + btnName + "</button>" 
	                			+ "<button data-toggle='modal' data-target='#editUserModal' edit_btn_eid='"+ data[i].eid + "' type='button' class='edited-btn btn btn-default btn-info btn-xs fa fa-edit 'style='margin: 2px'>编辑</button>" 
	                	   + "</td>"
	                +	"</tr>"
	                }  
	                $('.itemContainer').empty().append(html);  
	                lock();
	                edit();
	            },  
	        });  
	    }
	}); 
	
	//锁定用户/解锁用户
	function lock(){
		$(".locked-btn").click(function(){
			var url = $("#itemContainer").attr("url") + "/lock";
			var uid = $(this).attr("btn_uid");
			var locked = $(this).attr("locked");
			var lockState = locked == 0 ? 1 : 0;
			var clickBtn = $(this);
			var lockedStateContent = $("#lockState_"+uid);
		    $.post(url,
		    {
		        uid:uid,
		        locked:lockState
		    },
		        function(data,status){
		    	console.log(data);
		    	if(!data.isSucceed) {
		    		toastr.success('操作失败');
		    		return;
		    	}
		    	toastr.success('操作成功');
		    	var btnName = "";
		    	var btnClass = "";
		    	var stateContent = "";
		    	if(lockState == 1) {
		    		btnClass = "locked-btn btn btn-default btn-danger btn-xs fa  fa-unlock-alt";
		    		btnName = "解锁";
		    		stateContent = "已锁定";
		    	} else {
		    		btnClass = "locked-btn btn btn-default btn-warning btn-xs fa  fa-lock";
		    		btnName = "锁定";
		    		stateContent = "未锁定";
		    	}
		    	clickBtn.attr("class",btnClass);
		    	clickBtn.attr("locked",lockState);
		    	clickBtn.empty().append(btnName);
		    	lockedStateContent.empty().append(stateContent);
		    });
		});
	}
	
	function edit(){
		$(".edited-btn").click(function(){
			var eid = $(this).attr("edit_btn_eid");
			$("#editUserModal").attr("eid",eid);
		});
	}
	/*$('#myModal').on('shown.bs.modal', function () {
		$(this).attr("uid",);
	})*/
	


});


