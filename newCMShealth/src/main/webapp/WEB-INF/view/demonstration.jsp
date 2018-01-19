
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="resources/jquery-3.2.1.js"></script>

<script>
var up={}
up.jQuery  = $;
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>UPLOAD</title>


<style>
.jumbotron {
	width: 90%;
	margin-top: 50px;
	margin-right: 100px;
	margin-left: 100px;
	padding: 50px 0px 50px 90px;
	color: #3d3d3d;
	background-color: hsla(180, 2%, 87%, 0.5);

    .cms-font-color  {
    font-family: 'Source Sans Pro', 'Helvetica Neue', 'Helvetica', 'Roboto', 'Arial', sans-serif;
    color: #112e51;
    text-transform: capitalize;
    overflow: hidden;
    text-overflow: ellipsis;
    padding-right: 18px;
    font-size: 17px;
    font-weight: 500;
}
}
</style>
</head>
<body style="height:100%;background:#DCDCDC">
<%-- <jsp:include page="admin_header.jsp"></jsp:include> --%>
<jsp:include page="layout.jsp"></jsp:include>

	<script>
(function($) {  // jQuery wrapper for uPortal
    	$(document).ready(function () {

    	
    		var templates = [];
          // load templates
          getListTemplates();
          var itemName = "";
          var selectedOption = "";
          var selectedTemplate = "";
          
     //       document.body.style.backgroundImage = "url('resources/images/image1CMS.jpg')";
       // 	document.body.style.backgroundRepeat="no-repeat";
        //	document.body.style.backgroundSize="cover";
        	
            $("#uploadStatus").show();
             
          
        });  // document.ready()

        function showAndHide(selecteditem){
          console.log(selecteditem);
        }

      }(up.jQuery));
    </script>
	<div id="whole">
		<div id=jumbo class="jumbotron jumbotron-fluid" style="background:#fff">

			<div id="upload" style="width: 90%;">
<br>
<a href="/newcmshealth/ahcfile">ahcfile</a>
<br>
				<h2 style="text-align: center; border: 0px; padding: 0px" class="cms-font-color">Microservice and Software Component Demonstration</h2>
				<br /> <br />

				<div>
				

<p class="cms-font-color">The purpose of the Arch demonstration is to show an example of a microservice that provides powerful capabilities to an enterprise. The key advantages of the Arch Team Microservices approach are listed below.
<br>
<ul>
<li>-	Microservice that is not just a web service and a client within a monolithic application.</li>
<li>-	Microservice that can be accessed by multiple external clients.</li>
<li>-	Client application can be written in different software languages.</li>
<li>-	Client applications can be in separate cloud or datacenter environments.</li>
<li>-	Client applications can be low-code applications leveraging microservices for business logic and data transactions.</li>
<li>-	The Microservice can access multiple data sources (such as RF, IC, CCW, IDR and MDM) and other services so that it can provide a wide range of capabilities in an enterprise environment such as synchronizing database transactions.</li>
<li>-	Microservices are manageable through the CI/CD pipeline and provide a module to track and ensure enterprise scale features (performance, security, SOLID transactions) are realized and maintained.</li>
</ul>
<br>
The use case for the demonstration is a very simplified feature that is designed to be a very basic file upload with some simple configuration choices to the user. It has enough features to show the Microservice performing a few significant operations from two diverse clients, one in Salesforce and one is a basic Java application.

In the figure below we see the Slaesforce client application and an RF client application calling the file upload microservice. 
</p>
<img alt="" src="resources/images/demoMsArch.png">
				
				</div>
				<br> 
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include></body>
</html>


