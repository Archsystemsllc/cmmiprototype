<html>
<head>

<script src="resources/jquery-3.2.1.js"></script>

<script>
	var up = {}
	up.jQuery = $;
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>UPLOAD</title>


<style>
.jumbotron-ext {
	width: 50%;
	margin-top: 150px;
	margin-right: 350px;
	margin-left: 350px;
	padding: 50px 0px 50px 90px;
	color: #3d3d3d;
	background: #ccdeea;
}

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
</style>
</head>
<body style="height:100%;background:#DCDCDC;">
	<%-- <jsp:include page="admin_header.jsp"></jsp:include> --%>
	<jsp:include page="layout.jsp"></jsp:include>

	<script>
		(function($) { // jQuery wrapper for uPortal
			$(document)
					.ready(
							function() {

								var templates = [];
								// load templates
								getListTemplates();
								var itemName = "";
								var selectedOption = "";
								var selectedTemplate = "";
								var tempid ="";
								var selectedTemplate1 = "";
								var tempid1 ="";



							//	document.body.style.backgroundImage = "url('resources/images/image1CMS.jpg')";
							//	document.body.style.backgroundRepeat = "no-repeat";
							//	document.body.style.backgroundSize = "cover";

								$("#Submit")
										.click(
												function() {
													var formData = new FormData();
													var totalFiles = document
															.getElementById("FileUpload").files.length;
													var username = "qamadmin";
													var password = "123456";

													for (var i = 0; i < totalFiles; i++) {
														var file = document
																.getElementById("FileUpload").files[i];
														formData.append("file",
																file);
													}
													selectedOption = $(
															'#divTemplates #selectTemplates option:selected')
															.text();
															//console.log(selectedOption);

															if(selectedOption=="AHC Template"){
																tempid = 190;
																//console.log("190: "+tempid);
															}
															if(selectedOption=="BPCI Template"){
																tempid = 191;
																//console.log("191 :"+ tempid);
															}

													//alert(selectedOption)



													$
															.ajax({
																type : 'POST',
																url : 'http://localhost:8080/newqamservices/api/uploadHealthData/'
																		+ tempid,
																enctype : 'multipart/form-data',
																data : formData,
																contentType : false,
																processData : false,
																headers : {
																	"Authorization" : "Basic "
																			+ btoa(username
																					+ ":"
																					+ password)
																},
																success : function(
																		response) {
																	//console.log(response);
																	//console.log("Total Input:" +JSON.stringify(response.initialFileSize));
																	//console.log("Total Input:" +response.initialFileSize);
																	//console.log("OutPut Response"+ response.listOfHealthCommunity);
																	//console.log("OutPut Response"+ JSON.stringify(response.listOfHealthCommunity));
																	//console.log("JSON RESPONSE" + JSON.stringify(response));
																	var responseSize = response.initialFileSize;
																	var responseString = "";
																	var responseFalse = "";
																	var selectedTemplate = templates[selectedOption - 1];
																	console
																			.log(selectedTemplate);
																	//console.log("resposnse is ", JSON.stringify(response));
																	$
																			.each(
																					response.listOfHealthCommunity,
																					function(
																							idex,
																							item) {
																						//   console.log(item.id,item.status);

																						//    console.log(htmlTable.size);
																						//var html = htmlTable.outerHTML;
																						if (item.status == true) {
																							//	console.log("True Statements"+item.status);
																							responseString = responseString
																									+ item.status;
																						} else if (item.status == false) {

																							//	console.log("False Statements"+item.status);
																							responseFalse = responseFalse
																									+ item.status;
																						} else {

																							responseFalse = responseFalse
																									+ responseSize;

																						}

																					})
																	//console.log(htmlTable.length);
																	$(
																			"#uploadStatus")
																			.show();
																	$(
																			"#uploadStatus")
																			.html("File has been uploaded")

																},
																error : function(
																		error) {
																	alert("errror");
																}
															}); // ajax call
												}); // #Submit.click

								function getListTemplates() {
									var username = "qamadmin";
									var password = "123456";

									$
											.ajax({
												type : 'GET',
												url : 'http://localhost:8080/newqamservices/api/listTemplates',
												enctype : 'multipart/form-data',
												contentType : false,
												processData : false,
												headers : {
													"Authorization" : "Basic "
															+ btoa(username
																	+ ":"
																	+ password)
												},
												success : function(response) {
													// console.log('succes!!' );
													console.log(response);
													//var selectedOption1 = $('#divTemplates #selectTemplates option:selected').text();
												
									

													var options = [];
													//$('#divTemplates #selectTemplates');

													var data = [];
													var data = JSON
															.stringify(response);

													response
															.forEach(function(
																	item) {
																options
																		.push(
																				'<option value="',item.id, '">',
																				item.name,
																				'</option>');
																templates
																		.push(item.name);

																itemName = itemName
																		+ item.name;
																//console.log(itemName);

															});

													$(
															"#divTemplates #selectTemplates")
															.html(
																	options
																			.join(''));
												},
												error : function(error) {
													console.log("errror");
												}
											}); // ajax call

								} //getListTemplates()

							}); // document.ready()

			function showAndHide(selecteditem) {
				console.log(selecteditem);
			}

		}(up.jQuery));
	</script>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<div id="whole" style="min-height: calc(75vh - 50px);">
					<div id=jumbo class="jumbotron jumbotron-fluid jumbotron-ext"
						style="margin-top: 5%;background:#fff">

						<div id="upload">

							<!-- <h3>Upload file</h3> -->
							<strong><div class="panel-heading cms-font-color">Upload File</div></strong> <br />
							<div id="divTemplates">
								<font size="4" class="cms-font-color">Select Template ID : </font><select
									id="selectTemplates"></select>
							</div>
							<br> <label class="custom-file"> <input type="file"
								id="FileUpload" name="file" /><br /> <span
								class="custom-file-control"></span>
								<p class="butt">
									<button type="submit" id="Submit" value="Submit"
										class="btn btn-default cms-font-color pull-left">Submit</button>
								</p>
                                </br></br>
								<p id="uploadStatus"class="cms-font-color"></p>

							</label>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>


