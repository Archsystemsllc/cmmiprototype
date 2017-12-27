
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="resources/jquery-3.2.1.js"></script>
<link href="resources/css/bootstrap.min.css"
	rel="stylesheet">

<script>
var up={}
up.jQuery  = $;
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
	background-color: hsla(180, 2%, 87%, 0.5);
}
</style>
</head>
<body>
<jsp:include page="admin_header.jsp"></jsp:include>

	<script>
(function($) {  // jQuery wrapper for uPortal
    	$(document).ready(function () {

    		getReports();
          
            document.body.style.backgroundImage = "url('resources/images/image1CMS.jpg')";
        	document.body.style.backgroundRepeat="no-repeat";
        	document.body.style.backgroundSize="cover";
        	          
            
            function getReports() {
                var username="qamadmin";
                var password="123456";
                $.ajax({
                    type:'GET',
                    url:'http://localhost:8080/newqamservices/api/reporting',       
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
                      console.log("Data : "+data);
                      $.each(response,function(index,item) {
                    	  console.log(JSON.stringify(item));

                    	  $("#reports tbody").append("<tr>" + "<td>"+item.id+"</td>"+ "<td>"+item.fileName+"</td>"+"<td>"+item.templateName+"</td>"+
                    			  "<td>"+item.status+"</td>"+
                    			  "<td>"+item.message+"</td>"+
                    			  "<td>"+item.processedDate+"</td>"+
                    			  "</tr>");

                      })

                  //    $("#template_name").html(options.join(''));

                    },
                    error: function (error) {
                      console.log("errror");
                    }
                });  // ajax
              } 
            
            function showAndHide(selecteditem){
              console.log(selecteditem);
            }

            
          
        });  // document.ready()

        
 
      }(up.jQuery));
    </script>
	<div id="whole">
		<div id=jumbo class="jumbotron jumbotron-fluid">

			<div id="upload">

				<h2 style="text-align: center; border: 0px; padding: 0px">Uploads Report</h2>
				<br /> <br />

				<div>
				



<table id="reports">
 <thead>
 
  <tr>
     <th>id</th>
     <th>fileName</th>
     <th>templateName</th>
     <th>status</th>
     <th>message</th>
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


