<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<script>
	var up = {}
	up.jQuery = $;
	var svcUrlBase = 'http://localhost:8080';
	//http://cmstest-1.us-east-1.elasticbeanstalk.com
	//http://localhost:8080
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Downloads</title>
<link rel="shortcut icon" type="image/x-icon"
	href="./resources/images/adda_ico.png" />

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
<!--overflow: hidden; -->
.cms-font-color {
	font-family: 'Source Sans Pro', 'Helvetica Neue', 'Helvetica', 'Roboto',
		'Arial', sans-serif;
	color: #112e51;
	text-transform: capitalize;
	
	text-overflow: ellipsis;
	padding-right: 18px;
	font-size: 17px;
	font-weight: 500;
}
<!--    border: 1px solid black; width:100%;-->
 table{
	border: 1px solid black;
    border-width:medium;
    border-collapse: unset;
}
<!-- td {
, th, td 
	white-space: normal !important;
	word-wrap: break-word;
		border: 1px solid black;
    border-width:medium;
}-->
</style>
</head>
<body style="height: 100%; background: #DCDCDC;">
	<%-- <jsp:include page="admin_header.jsp"></jsp:include> --%>
	<jsp:include page="layout.jsp"></jsp:include> 

	<!--   http://localhost:8080
   http://cmstest-1.us-east-1.elasticbeanstalk.com 191/01-20-2018
 -->

	<div id="whole">
		<div id=jumbo class="jumbotron jumbotron-fluid"
			style="background: #fff;">

			<div id="upload" style="width: 90%;">


 <!--colspan="2"

 
 -->
				<div id=download width="100%">
					<table id="downloadfiles" width="100%" "
						class="cms-font-color">
						<tr ><td style="text-align:center"  colspan="2" >
							<b>IDOS Demonstration Template Downloads </b>
						</td></tr>						
						<tr>
							<td>AHC TEMPLATE</td>
							<td><a href="/newcmshealth/ahcfile">AHC Template</a></td>
						</tr>
						<tr>
							<td>BPCI TEMPLATE</td>
							<td><a href="/newcmshealth/bpcifile">BPCI Template</a></td>
						</tr>						
					</table>
				</div>
				<br>
				<h1 style="text-align: center; border: 0px; padding: 0px;"
					class="cms-font-color">Instructions</h1>
				<br /> <br />				
				<p>The concept of operation for the demonstration is that the user works with one of the two available templates.
				The features only represent a limited scenario and are purely for a demonstration. An assumption built into the 
				demonstration that there is an (unseen) ability to create templates and two have been created so far. 
				 
				 There are four primary scenarios:<br>
				 1. Configuring a template.<br>
				 2. Uploading a file using a template for writing data.<br>
				 3. Retrieving reports for file uploads status and content written from uploads.<br>
				 4. Upload a file using a template for writing data from Salesforce.
				 		 
				</p>
				<p>
				<br>
				<B>1. CONFIGURING  A TEMPLATE</B><br>
				<ul>
				<li>After opening the Configure Template page select a template from the drop-down.</li>
				<li>A list of all available fields that exist in the template spreadsheet and can be uploaded and saved is shown.
				Select the fields that the project will want to save to the database for file uploads.</li>
				<li> Two lists will then show. One is the selected fields and the other list is for the 
				user to indicate fileds from the original selections to use to concatenate to create a Unique ID field. 
				Select the fileds desired and copy them over using the arrows.</li>
				<li>Select submit to save the template configuration. There is always only one configuration for 
				each template. It is meant to be set-up once and used many times.</li>
				</ul>				 
				<br>
				<B>2. UPLOADING A FILE</B><br>
				<ul>
				<li>Ensure you are using one of the two templates that you have downloaded and stored on your local 
				file system from the download links above. The content is example data and can be replaced if desired
				 but it is not necessary for the demonstration.</li>
				<li>Simply upload the document and Submit. A message will return giving a count of rows succeeeded and failed.</li>
				</ul>				
				<br>
				<B>3. RETRIEVING REPORTS</B><br>
				<ul>
				<li>Open the Reports page to view a report of all downloads and there status. You can verify that the Salesforce 
				uploads (see instructions below) have been posted to the common database by way of the upload microservices by
				 alternating templates between the Salesforce client application and this Java client application and reviewing 
				 the report for the last two uploads and noticing that the templates are different.
				</li>
				<li>
				There is also a "drill down" report available that will show all the contents uploaded per template from the date 
				selected when the link in the date field is clicked.
				</li>
				</ul>
				<br>
				<B>4. UPLOAD FROM SALESFORCE</B><br>
				<ul>
				<li>
				Log-in to Salesforce.com as archtest@archsystemsinc.com using test@123 as the password.
				</li>
				<li>
				Simply select one of the templates from the drop down and then upload the appropriate file 
				(one of the two templates as described above) and submit. The configuration part is not active and any selections will have no effect.
				</li>
				<li>
				Raw data is returned and displayed unprocessed to the Salesforce client. As with the template configuration 
				reports were not completed for the Salesforce client. The purpose of the demonstration i satisfied by the 
				common use of the upload microservcie fro external end-points.
				</li>
				<li>
				Review the Report in this client to see the upload succeeeded through the file upload microservice.
				</li>
				</p>
				
				<br>
				<!-- For more information please click <a href = "/newcmshealth/demonstration">here</a> -->
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>



</html>