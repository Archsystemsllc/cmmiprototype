
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

				<h2 style="text-align: center; border: 0px; padding: 0px" class="cms-font-color">Microservice and Software Component Demonstration</h2>
				<br /> <br />

				<div>
				

<p class="cms-font-color">The Arch Team is providing an example demonstration to show some key aspects of our approach to rapid development and re-use while maintaining quality standards. 
The requirements are limited to a partial application for the demonstration. 
There is a File Upload service that is deployed in a microservice pattern so that it is accessible as
 an API and can be located on any platform providing a Java runtime and a remote service call. 
 The Upload service is aimed at a general-purpose capability to upload a spreadsheet and have the 
 contents written to a database. Two value added capabilities are the can specify an identifying 
 column for the upload by selecting columns in the spreadsheet to concatenate into the identifier 
 column and then also, the user can specify which columns from the spreadsheet to write to the DB. 
 The utility of the application is short of a production application to meet time constraints but 
 
 what is demonstrated is the usefulness of an enterprise microservice that is available from many 
 clients at the same time and has the quality, features, and soundness to operate in a large-scale 
 environment while reducing the size of the client applications by off-loading features. 
 The Arch Team believes this is a major part of missing architecture as the RF is implemented 
 currently and to turn towards this approach will be a significant part of making a reusable 
 framework much more practicable over what is primarily an application and front-end approach 
 in the existing RF design approach. </p>

<p>The Upload service incorporates several design patterns but most important in the demonstration
 is the Chain of Responsibility (COR) pattern used in conjunction with a variation of the Task 
 pattern called a LogMonitor.  The Upload COR loads a series of stages and executes each stage 
 when the chain is called to execute. There are three advantages to executing a COR: stages can 
 be added and removed from a COR either statically or dynamically, a COR can execute any stage 
 optionally when it does contain a stage, and because each stage is executed uniformly and with 
 a defined responsibility each stage can be monitored and reports provided as needed in logs or 
 monitoring consoles, for example. In the case of the Upload COR, we began development with a very 
 basic requirement of parsing a spreadsheet file and loading data into a DB with a configuration 
 option of the user specifying which columns from the spreadsheet to transfer to the DB. Input 
 from a business analyst that a typical usage pattern would be to add an ability to specify a 
 column for a unique id that would be a concatenation of existing columns the user would select. 
 This was a good example of the extensibility of the COR pattern because a Stage just needed to 
 be designed and added to the COR to execute and in addition, the Stage could execute optionally 
 if the user did not configure the unique id. Additionally, the LogMonitor records and reports 
 information from each stage in a formatted and efficient way that has several benefits to operating 
 in an enterprise environment. Information is collected across code structures such as iterations 
 that is not practicable in a line by line basis and valuable meta-data for system monitoring and 
 troubleshooting can be made available such a host and thread information that would provide an 
 immediate location an instance of an application that needs some attention in a production 
 environment, this will cut down on the investigation time in the event of a misbehaving application.
</p>
<p>Included in the COR is a Composition pattern that is assembling data to and from the DB. 
This is a significant improvement to Model and Data Transfer Objects in that the Composition 
pattern is a broader view of data across an enterprise where assembly of data in the middle tier 
is very powerful in that it frees the use of data from a single tight group associated within a 
single table a closely associated data set. In a Composition object data can be assembled across 
data sets and is optimal for any operation a system must perform. For example assembling provider 
and beneficiary data within a single object for providing data to a certain view that needs such 
collection of data but is not a report. Frequently, the most effective way to do this is in 
middleware and makes using a microservice in front of the data layer a more effective and less 
“chatty”. A service that pulls data in smaller sets as an application does but only provides a 
remote web service call is an example of something that should not make it through the service 
definition process.</p>
				
				</div>
				<br> 
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include></body>
</html>


