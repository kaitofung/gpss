$(document).ready(function() {
	    
    
    $("#summit_menu_remove").click(function(){
            // jquery 表单提交   
    		var url = $("#removeMenuModal").attr("url");
    		var mid = $("#removeMenuModal").attr("mid");
     		$.post(url,  {
				mid : mid
     		},function(data,status){
					if(data.isSucceed) {
						$('#removeMenuModal').modal('hide');
						toastr.success('删除成功');
						window.location.reload();
					} else{
						toastr.error('删除失败');
					}
			    }
			);
     		
    });
    
    	
});

