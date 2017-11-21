<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>

<script src="resources/jquery-3.2.1.js"></script>
<script src="resources/home.js" type="text/javascript"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" />
<link
	href="https://fonts.googleapis.com/css?family=Cookie|Fredericka+the+Great"
	rel="stylesheet">

<style>
.jumbotron {
	width: 50%;
	margin-top: 150px;
	margin-right: 350px;
	margin-left: 350px;
	padding: 50px 0px 50px 90px;
	color: #3d3d3d;
	background-color: hsla(180, 2%, 87%, 0.5);
}
</style>
</head>
<body>
	<div id="whole">
		<nav class="navbar navbar-inverse navbar-fixed-top navbar-right">
		<div class="container">
			<div class="row">
				<div id="main" class="btn-group btn-group-justified">
					<a class="btn btn-primary home">Home</a> <a id="newupload"
						href="#upload" class="btn btn-primary uploads">Upload-documents</a>
					<a href="#" class="btn btn-primary contact-us">Contact Us</a> <a
						id="createTemp" href="#createtemplate"
						class="btn btn-primary uploads">Create-Template</a>

				</div>
			</div>
		</div>
		</nav>
		<div id=jumbo class="jumbotron jumbotron-fluid">

			<div id="upload">

				<h3>Upload file</h3>
				<br />
				<br />
				<div  id="divTemplates">
					<font size="4">Select Template ID : </font><select id="selectTemplates"></select>
				</div>
				<br>
				<label class="custom-file"> <input type="file"
					id="FileUpload" name="file" /><br /> <span
					class="custom-file-control"></span>
					<p class="butt">
						<button type="submit" id="Submit" value="Submit"
							class="btn btn-default">Submit</button>
					</p>
					<div id="uploadStatus"></div>
					
				</label>
			</div>
		</div>


		<div id="templateCreation" class="jumbotron jumbotron-fluid"
			align="center">
			<div id="templateListDiv" align="center" class="ui-widget"
				style="padding-top: 40px;">
				<label id="template_ID">Enter Template Name </label> <input
					type="text" id="template_name" /> <br>
				<button id="templateSubmit" class="btn btn-default">Submit</button>
			</div>
			<br>
			<div align="center" id="statusID"></div>


			<br>
			<div id="mainDiv">
				<h3>Select fields</h3>
				<select id="slectNewDiv" name="attributeNames" size="5"
					multiple="multiple">
					<option value="nameOfInitiative">nameOfInitiative</option>
					<option value="orgName">orgName</option>
					<option value="notes">notes</option>
					<option value="location">location</option>
					<option value="streetAddress">streetAddress</option>
					<option value="city">city</option>
					<option value="state">state</option>
					<option value="stateBase">stateBase</option>
					<option value="phase1">phase1</option>
					<option value="phase2">phase2</option>
					<option value="facebook">facebook</option>
					<option value="Twitter">Twitter</option>
					<option value="youtube">youtube</option>
					<option value="website">website</option>
					<option value="msaName">msaName</option>
					<option value="uniqueId">uniqueId</option>
					<option value="mapDisplay">mapDisplay</option>
				</select> <br>
				<div align="center" id="fieldStatus"></div>
				<br>
				<div>
					<button id="configSubmit" class="btn btn-default">ConfigSubmit</button>
				</div>
			</div>

		</div>
</body>
</html>

