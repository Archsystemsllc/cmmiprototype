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
				 
				 There are three primary scenarios:<br>
				 1. Configuring a template.<br>
				 2. Uploading a file using a template for writing data.<br>
				 3. Retrieving reports for file uploads status and content written from uploads.<br>
				 		 
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
				<br>
				<B>3. RETRIEVING REPORTS</B><br>
				<br>
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