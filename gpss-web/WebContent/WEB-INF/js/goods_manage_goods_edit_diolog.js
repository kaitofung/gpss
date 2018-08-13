$(document).ready(function() {
    var validator = $("#edit_goods_form").validate({rules : {
		goods_name_input_edit : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		goods_manager_producer_input_edit : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		goods_price_input_edit : {
			required : true,
			number:true,
			maxlength:11,
			minlength :1
		},
		goods_photo_input_edit : {
			required : false
		},
		goods_specification_input_edit : {
			required : true,
			url:false
		},
		goods_gtype_input_edit : {
			required : true,
			url:false
		},
		goods_description_input_edit : {
			required : true,
			minlength : 2,
			maxlength:11
		}
	},
		messages : {
			goods_name_input_edit : {
				required : "请输入商品名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			goods_manager_producer_input_edit : {
				required : "请输入商品生产商名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			goods_price_input_edit : {
				required : "请商品价格",
				number:"请填写正确的数字金额",
				maxlength: "请输入2-11位的字符",
				minlength : "请输入1-11位的字符",
			},
			goods_photo_input_edit : {
				required : "",
			},
			goods_specification_input_edit : {
				required : "请选择商品规格",
			},
			goods_gtype_input_edit : {
				required : "请选择商品类型",
			},
			goods_description_input_edit : {
				required : "请输入商品描述",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			}
		}
	});
    
    setUpResetForm("#editgoodsesModal", validator);
    getGoodsType();
    getGoodsSpecification();
    
    $("#summit_goods_edit").click(function(){

    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#editgoodsesModal").attr("url");
    		var gid = $("#editgoodsesModal").attr("gid");
    		var name = $("#goods_name_input_edit").val();
    		var producer = $("#goods_manager_producer_input_edit").val();
    		var price = $("#goods_price_input_edit").val();
    		var gtype_id = $("#goods_gtype_input_edit").val();
    		var gspecification_id = $("#goods_specification_input_edit").val();
    		var description = $("#goods_description_input_edit").val();
    		// 创建
    		var form_data = new FormData();
    		// 获取文件
    		var file = $('#goods_photo_input_edit')[0].files[0];
    		form_data.append("name", name);
    		form_data.append("gid", gid);
    		form_data.append("producer", producer);
    		form_data.append("price", price);
    		form_data.append("gtype_id", gtype_id);
    		form_data.append("gspecification_id", gspecification_id);
    		form_data.append("description", description);
    		form_data.append("photox", file);
     	     $.ajax({  
     	          url: url ,  
     	          type: 'POST',  
     	          data: form_data,  
     	          async: false,  
     	          cache: false,  
     	          contentType: false,  
     	          processData: false,  
     	          success: function (data, status) {  
  					console.log( data);
  					console.log(status);
  					if(data.isSucceed) {
  						$('#editgoodsesModal').modal('hide');
  						showSuccess('编辑成功！');
  					}else{
  						showError('编辑失败！');
  					}
     	          },  
     	          error: function (returndata) {  
  					showError('编辑失败！');
     	          }  
     	     });  
     		
     		
    	}else{
    		showError('参数有误！！');
    	}
    });
    
    
	
    //加载商品类型
    function getGoodsType(){
			var url = $("#goods_gtype_input_edit").attr("url");
			  $.post(url,{},function(result){
				  var array = result;
				  var firstItem = $("#select_goods_gtype_first");
				  var html = "<option value='' id='select_goods_gtype_first'>请选择商品类型</option>";
				  for(var i = 0; i < array.length; i++){
					  html = html + "<option value='" + array[i].gtypeId + "'>" +array[i].name + "</option>"
				  }
				  $("#goods_gtype_input_edit").text("");
				  $("#goods_gtype_input_edit").append(html);
			  });
    }
    
    //加载商品规格
    function getGoodsSpecification(){
    	var url = $("#goods_specification_input_edit").attr("url");
    	$.post(url,{},function(result){
    		var array = result;
    		var html = "<option value='' id='select_goods_specification_first'>请选择商品规格</option>";
    		for(var i = 0; i < array.length; i++){
    			html = html + "<option value='" + array[i].gspecificationId + "'>" +array[i].name + "</option>"
    		}
    		$("#goods_specification_input_edit").text("");
    		$("#goods_specification_input_edit").append(html);
    	});
    }
    	
});

