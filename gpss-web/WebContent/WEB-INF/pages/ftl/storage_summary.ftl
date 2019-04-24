<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">     
<html>     
<head>     
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>usersInfo</title>     
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

</head>     
<body>    
	<div class="col-md-12">
          <!-- Custom Tabs -->
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#tab_storage_record" data-toggle="tab" aria-expanded="true">库存记录</a></li>
              <li class=""><a href="#tab_2" data-toggle="tab" aria-expanded="false">库存统计</a></li>
            </ul>
            <div class="tab-content">
              <div class="tab-pane active" id="tab_storage_record">
               <#include "/storage_record.ftl"> 
              </div>
              <!-- /.tab-pane -->
              <div class="tab-pane" id="tab_2">
                nothing
              </div>
              <!-- /.tab-pane -->
          
            </div>
            <!-- /.tab-content -->
          </div>
          <!-- nav-tabs-custom -->
        </div> 
</body>     
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"></script>
</html>  