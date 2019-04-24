$(document).ready(function() {
    var validator = $("#create_goods_form").validate({rules : {
		goods_name_input_create : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		goods_manager_producer_input_create : {
			required : true,
			minlength : 2,
			maxlength:11
		},
		goods_price_input_create : {
			required : true,
			number:true,
			maxlength:11,
			minlength :1
		},
		goods_photo_input_create : {
			required : false
		},
		goods_specification_input_create : {
			required : true,
			url:false
		},
		goods_gtype_input_create : {
			required : true,
			url:false
		},
		goods_description_input_create : {
			required : true,
			minlength : 2,
			maxlength:11
		}
	},
		messages : {
			goods_name_input_create : {
				required : "请输入商品名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			goods_manager_producer_input_create : {
				required : "请输入商品生产商名称",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			},
			goods_price_input_create : {
				required : "请商品价格",
				number:"请填写正确的数字金额",
				maxlength: "请输入2-11位的字符",
				minlength : "请输入1-11位的字符",
			},
			goods_photo_input_create : {
				required : "",
			},
			goods_specification_input_create : {
				required : "请选择商品规格",
			},
			goods_gtype_input_create : {
				required : "请选择商品类型",
			},
			goods_description_input_create : {
				required : "请输入商品描述",
				minlength : "请输入2-11位的字符",
				maxlength : "请输入2-11位的字符"
			}
		}
	});
    
    setUpResetForm("#creategoodsesModal", validator);
    getGoodsType();
    getGoodsSpecification();
    
    $("#summit_goods_create").click(function(){

    	if(validateForm(validator)){
            // jquery 表单提交   
    		var url = $("#creategoodsesModal").attr("url");
    		var name = $("#goods_name_input_create").val();
    		var producer = $("#goods_manager_producer_input_create").val();
    		var price = $("#goods_price_input_create").val();
    		var gtype_id = $("#goods_gtype_input_create").val();
    		var gspecification_id = $("#goods_specification_input_create").val();
    		var description = $("#goods_description_input_create").val();
    		// 创建
    		var form_data = new FormData();
    		// 获取文件
    		var file = $('#goods_photo_input_create')[0].files[0];
    		form_data.append("name", name);
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
  					if(data.isSucceed) {
  						$('#creategoodsesModal').modal('hide');
  						showSuccess('创建成功！');
						$('#goods_manage_table').bootstrapTable('refresh');
  					}else{
  						showError('创建失败！');
  					}
     	          },  
     	          error: function (returndata) {  
  					showError('创建失败！');
     	          }  
     	     });  
     		
     		
    	}else{
    		showError('参数有误！！');
    	}
    });
    
    
	
    //加载商品类型
    function getGoodsType(){
			var url = $("#goods_gtype_input_create").attr("url");
			  $.post(url,{},function(result){
				  var array = result;
				  var firstItem = $("#select_goods_gtype_first");
				  var html = "<option value='' id='select_goods_gtype_first'>请选择商品类型</option>";
				  for(var i = 0; i < array.length; i++){
					  html = html + "<option value='" + array[i].gtypeId + "'>" +array[i].name + "</option>"
				  }
				  $("#goods_gtype_input_create").text("");
				  $("#goods_gtype_input_create").append(html);
			  });
    }
    
    //加载商品规格
    function getGoodsSpecification(){
    	var url = $("#goods_specification_input_create").attr("url");
    	$.post(url,{},function(result){
    		var array = result;
    		var html = "<option value='' id='select_goods_specification_first'>请选择商品规格</option>";
    		for(var i = 0; i < array.length; i++){
    			html = html + "<option value='" + array[i].gspecificationId + "'>" +array[i].name + "</option>"
    		}
    		$("#goods_specification_input_create").text("");
    		$("#goods_specification_input_create").append(html);
    	});
    }
    	
});

