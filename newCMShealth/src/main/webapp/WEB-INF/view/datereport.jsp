<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/jquery-3.2.1.js"></script>
<script src="resources/jquery-ui/jquery-1.12.4.js"></script>
<script src="resources/jquery-ui/jquery.dataTables.min.js"></script>
<script src="resources/jquery-ui/dataTables.bootstrap.min.js"></script>
<link href="resources/css/bootstrap.min.css"
	rel="stylesheet">

<script>
var up={}
up.jQuery  = $;
var svcUrlBase = 'http://localhost:8080';
//http://cmstest-1.us-east-1.elasticbeanstalk.com
//http://localhost:8080
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>REPORT</title>


<style>
.jumbotron {
	width: 90%;
	margin-top: 50px;
	margin-right: 100px;
	margin-left: 100px;
	padding: 50px 0px 50px 90px;
	color: #3d3d3d;
	background-color: #ccdeea;
}

.cms-font-color  {
    font-family: 'Source Sans Pro', 'Helvetica Neue', 'Helvetica', 'Roboto', 'Arial', sans-serif;
    color:#112e51;
    text-transform: capitalize;
    overflow: hidden;
    text-overflow: ellipsis;
    padding-right: 18px;
    font-size: 17px;
    font-weight: 500;
}

td {
  white-space: normal !important; 
  word-wrap: break-word;  
}

</style>
</head>
<body style="height:100%;background:#DCDCDC;">
<%-- <jsp:include page="admin_header.jsp"></jsp:include> --%>
<jsp:include page="layout.jsp"></jsp:include>

<!--   http://localhost:8080
   http://cmstest-1.us-east-1.elasticbeanstalk.com 191/01-20-2018
 -->
	<script>
	$.noConflict();
	var table = $('#report1').DataTable();
    		console.log("enterd");
    	    function getContents(inDate) {
    	        var username="qamadmin";
    	        var password="123456";
    	      // alert(inDate.templateName);//TODO: Time permitting get the actual IDs from the DB
    	       var tpid=0;
    	      if(inDate.templateName == "AHC Template"){
    	    	  tpid=190;
    	      }else if(inDate.templateName ==  "BPCI Template"){
    	    	  tpid=191;
    	      }
    	    	  
    	    	  
    	     
    	        $.ajax({
    	            type:'POST',
    	           url:svcUrlBase+'/newqamservices/api/listHealthContent/'+tpid+'/'+inDate.processedDate,    
    	           // url:svcUrlBase+'/newqamservices/api/listHealthContent/190/01-20-2018',
    	                   enctype:'multipart/form-data',
    	                   contentType: false,
    	                   processData: false,
    	            headers:{  "Authorization": "Basic " + btoa(username+":"+password)},
    	            success: function(response) {
    	                   // console.log('succes!!' );
    	              var options =[]; //$('#divTemplates #selectTemplates');
    	            //  var data=[];
    	            var itemsLength = response.length;
    	              var data=JSON.stringify(response);


    	            //  console.log("Data : "+data);
    	              $.each(response,function(index,item) {
    	            //	  console.log(JSON.stringify(item));

    	            	  $("#reports1 tbody").append("<tr>" + 
    	            			  "<td>"+item.id+"</td>"+ 
    	            			  "<td>"+item.templateId+"</td>"+
    	            			  "<td>"+item.processedDate+"</td>"+
    	            			  "</tr>");

    	              })

/*     	                      $("#newreport").show();
    	                    	  $("#report").hide();
    	                    	   */
    	                    	  $('#reports1').DataTable({
    	                         "processing": true
    	                       });
    	                    	  
    	          //    $("#template_name").html(options.join(''));

    	            },
    	            error: function (error) {
    	              console.log("errror");
    	            }
    	        });  // ajax
    	      }
    		
    	
 
      
     // $("#reports_filter")
      
    </script>
	<div id="whole">
		<div id=jumbo class="jumbotron jumbotron-fluid" style="background: #fff;">

			<div id="upload" style="width: 90%;">

				<h2 style="text-align: center; border: 0px; padding: 0px;" class="cms-font-color">Uploads Report</h2>
				<br /> <br />

				
<div>
<table id="reports1" class="table table-striped table-bordered cms-font-color" cellspacing="0" width="100%">
 <thead>
 
  <tr>
     <th>id</th>
     <th>templateId</th>
     <th>processedDate</th>
  </tr>
 </thead>

 
 <tbody></tbody>
 </table>
				
				</div>
				<br> 
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>


