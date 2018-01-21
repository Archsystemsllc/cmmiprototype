
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>CreateTemplate</title>



<script src="resources/jquery-3.2.1.js"></script>





<script>
	var up = {}

	up.jQuery = $;

	var mappedItems = {};
	var svcUrlBase = 'http://localhost:8080';
	//http://cmstest-1.us-east-1.elasticbeanstalk.com
	//http://localhost:8080
</script>













<style>
.jumbotron {
	width: 50%;
	margin-top: 150px;
	margin-right: 350px;
	margin-left: 350px;
	padding: 5px 0px 5px 9px;
	color: #4d4d4d;
	background-color: #eee(180, 2%, 87%, 0.5);
}

.cms-font-color {
	font-family: 'Source Sans Pro', 'Helvetica Neue', 'Helvetica', 'Roboto',
		'Arial', sans-serif;
	color: #112e51;
	text-transform: capitalize;
	overflow: hidden;
	text-overflow: ellipsis;
	padding-right: 18px;
	font-size: 17px;
	font-weight: 500;
}

/*       html, body {

        margin: 0;

        padding: 0;

        height: 100%;

      }

      

      #whole{

        height: 100%;

        width:1500px;

	    overflow:hidden;

	    } */
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>

<body style="background: #DCDCDC;">

	<%-- <jsp:include page="admin_header.jsp"></jsp:include> --%>



	<jsp:include page="layout.jsp"></jsp:include>

	<script>
		(function($) { // jQuery wrapper for uPortal

			$(document)
					.ready(
							function() {

								$("#templateListDiv").show();

								$("#configSubmit").hide();

								$("#mainDiv").hide();

								$("#statusID").hide();

								$("#fieldStatus").hide();

								$("#resetBtn").show();

								getListTemplates();

								//   $('#whole').css('min-height', '100%');

								//  document.body.style.backgroundImage = "url('resources/images/image1CMS.jpg')";

								//	document.body.style.backgroundRepeat="no-repeat";

								//	document.body.style.backgroundSize="cover";

								//   http://localhost:8080

								//   http://cmstest-1.us-east-1.elasticbeanstalk.com

								function getListTemplates() {
									var username = "qamadmin";

									var password = "123456";

									$
											.ajax({
												type : 'GET',

												url : svcUrlBase
														+ '/newqamservices/api/listTemplates',

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

													var options = []; //$('#divTemplates #selectTemplates');

													//  var data=[];

													var data = JSON
															.stringify(response);

													//	console.log("Data : " + data);

													response
															.forEach(function(
																	item) {

																options
																		.push(
																				'<option value="', item.id, '">',
																				item.name,
																				'</option>');

															})

													$("#template_name").html(
															options.join(''));

												},

												error : function(error) {

													//	console.log("errror");

												}
											}); // ajax

								} // getListTemplates()

								$("#template_name")
										.change(
												function(event) {

													var AHCOPTIONS = {
														"nameOfInitiative" : 0,

														"orgName" : 1,

														"notes" : 2,

														"location" : 3,

														"streetAddress" : 4,

														"city" : 5,

														"state" : 6,

														"stateBase" : 7,

														"phase1" : 8,

														"phase2" : 9,

														"facebook" : 10,

														"Twitter" : 11,

														"youtube" : 12,

														"website" : 13,

														"categoryName" : 14,

														"msaName" : 15,

														"uniqueId" : 16,

														"mapDisplay" : 17
													};

													var beach = {
														"nameOfInitiative" : 0,

														"orgName" : 1,

														"notes" : 2,

														"location" : 3,

														"streetAddress" : 4,

														"city" : 5,

														"state" : 6,

														"stateBase" : 7,

														"phase1" : 8
													};

													/* 													$("#slectNewDiv").children(
													 'option').remove(); */

													if ($(
															"#template_name option:selected")
															.val() == 190) {

													//	console.log("190");

														$("#mainDiv").show();
														$("#slectNewDiv")
																.show();
														$("#NewMergedDiv")
																.hide();

														$("#configureEntry")
																.hide();
														$("#template_name")
																.attr(
																		'disabled',
																		'disabled');

														$
																.each(
																		AHCOPTIONS,
																		function(
																				key,
																				value) {
																			$(
																					"#slectNewDiv")
																					.append(
																							new Option(
																									key,
																									value));
																		});

													}

													else {
													//	console.log("191");
														$("#mainDiv").show();

														$("#NewMergedDiv")
																.hide();
														$("#slectNewDiv")
																.show();

														$("#configureEntry")
																.hide();
														$("#template_name")
																.attr(
																		'disabled',
																		'disabled');

														$
																.each(
																		beach,
																		function(
																				key,
																				value) {

																			$(
																					"#slectNewDiv")
																					.append(
																							new Option(
																									key,
																									value));

																		});

													}

												});

								$("#resetBtn")
										.click(
												function() {

													window.location.href = svcUrlBase
															+ '/newcmshealth/createtemplate';

												});

								$("#templateSubmit")
										.click(
												function() {

													$("#slectNewDiv").show();

													$(
															"#slectNewDiv #NewMergedDiv")
															.hide();

													$("#resetBtn").show();

													var username = "qamadmin";

													var password = "123456";

													var templatecreate = {};

													templatecreate.name = $(
															"#template_name")
															.val();

													//console.log(templatecreate.name);

													var formData = new FormData();

													formData.append("name", $(
															"#template_name")
															.val())

													if (templatecreate.name != null
															&& templatecreate.name != '') {

														$
																.ajax({
																	type : 'POST',

																	url : svcUrlBase
																			+ '/newqamservices/api/listHealthDataTemplateConfigs',

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

																		// console.log('succes!!' );

																		//	console.log(response);

																		templatenameid = response.id;

																		//      globalResponseid = response.id

																		getListTemplates();

																		//   $('#statusID').html("Your Template has been created with id : " + globalResponseid);

																		$(
																				"#configSubmit")
																				.show();

																		$(
																				"#mainDiv")
																				.show();

																		$(
																				"#statusID")
																				.show();

																	},

																	error : function(
																			error) {

																		//	console.log("errror");

																	}
																});

													} else {

														getListTemplates();

													}

												}); // #templateSubmit.click

								/*       $("#addNewField").click(function () {
								
								    	 $("#slectNewDiv").append(new Option($("#newExtraField").val(),$("#newExtraField").val()));
								
								      }); */

								$("#movingField")
										.click(
												function() {

													$("#NewMergedDiv").show();

													$("#configureEntry").show();

													$("#configSubmit").show();

													$("#configuredColumns")
															.hide();

													$("#slectNewDiv").hide();

													$("#movingField").hide();

													var movingItems = {};

													var selectedLength = $("#slectNewDiv :selected").length;

													if (selectedLength > 0) {

														$
																.each(
																		$("#slectNewDiv option:selected"),
																		function() {

																			var $this = $(this);

																			var value = $(
																					this)
																					.val();

																			$(
																					"#movingNewDiv")
																					.append(
																							new Option(
																									$this
																											.text(),
																									value));

																			//	console.log("New Value: " + value);

																		})

													}

												});

								$("#ConcatinateField")
										.click(
												function() {

													var localmappedItems = {};
													mappedItems = {};//for revereseclock purpose

													var value = $(
															"#movingNewDiv :selected")
															.val();

													//		console.log("Value : " + value);

													var selectedLength = $("#movingNewDiv :selected").length;

													//		console.log(selectedLength);

													var concatinateVal = '';

													var displayItems = [];

													mappedItems["templateId"] = parseInt(
															$(
																	"#template_name option:selected")
																	.val(), 10);

													$
															.each(
																	$("#movingNewDiv option"),
																	function() {//:not(:selected)

																		var $this = $(this);

																		mappedItems[$this
																				.text()] = parseInt(
																				$(
																						this)
																						.val(),
																				10);

																		//		console.log("$this" + $(this).val());

																	});

													if (selectedLength >= 2) {

														var tempArray = [];

														$
																.each(
																		$("#movingNewDiv option:selected"),
																		function() {

																			var $this = $(this);

																			concatinateVal += $this
																					.text();
																			var tempDisplay = {};
																			tempDisplay[$this
																					.text()] = $(
																					this)
																					.val();
																			displayItems
																					.push(tempDisplay);

																			//		console.log("this.text : " + $this.text());

																			//		console.log("this.value : " + $(this).val());

																			//  console.log("object value : " + JSON.stringify(obj));

																			//		console.log("Value :" + JSON.stringify($this));

																			var intergerVal = parseInt(
																					$this
																							.val(),
																					10);

																			tempArray
																					.push(intergerVal);

																		})

														mappedItems["mergedCol1"] = concatinateVal
																+ ":"
																+ tempArray
																		.join(",");

														//	console.log("localMappedItems :" + JSON.stringify(mappedItems));

														localmappedItems[concatinateVal] = tempArray
																.join(",");

														//	console.log("localMappedItems :" + JSON.stringify(localmappedItems));

													}

													//		console.log("The selected item" + $("#template_name option:selected").val());

													//		console.log("All mapped items " + JSON.stringify(mappedItems));

													/*   if($("#movingNewDiv :not(:selected)").length>0){
													
														  console.log("It's working")
													
													  } */

													if (selectedLength == 1) {

														alert("Merge supports more than 1 item");

														/*  $("#movingNewDiv option:selected").each(function (){
														
														//  var item = $("#movingNewDiv option:selected").text();
														
														  var $this =$(this);
														
														//  console.log(item);
														
														//  mappedItems[item]=item;
														
														  localmappedItems[$this.text()] = $this.text(); 
														
														  
														
														 }) */

													}

													//	$("#movingNewDiv").find("option:selected").remove().end();

													var keysLength = Object
															.keys(localmappedItems).length;

													//	console.log(keysLength);

													/* 					Object.keys(displayItems).forEach(function(index, item) {
													
													 console.log("index_item" +index, item);
													 $("#requestNewDiv").append(new Option(index, item));
													
													 }) */

													//	console.log("Display_ITEMS:"+ JSON.stringify(displayItems));
													$
															.each(
																	displayItems,
																	function(
																			key,
																			value) {

																		//	console.log("KEY_VALUE" +key, value);
																		//	console.log(JSON.stringify(key));
																		//	console.log("object_key" + Object.keys(value)[0], value[Object.keys(value)[0]]);
																		$(
																				"#requestNewDiv")
																				.append(
																						new Option(
																								Object
																										.keys(value)[0],
																								value[Object
																										.keys(value)[0]]));

																	});

													//  for(int i=0;i<keysLength;i++){

													// $("#requestNewDiv").append(Object.keys(mappedItems)[i],Object.keys(mappedItems)[i]);

													//  }

													//		console.log(JSON.stringify(localmappedItems));

													/*    	 $("#slectNewDiv option:selected").each(function () {
													
													   		  var $this = $(this);
													
													   		  if($this.length == 2){
													
													   			 console.log(); 
													
													   		  }
													
													   		  else if($this.length == 1) {
													
													   			  
													
													   		  }
													
													   		  console.log($this.text());
													
													   		  
													
													   		  
													
													   	  })  */

													// $("#slectNewDiv").append(new Option($("#newExtraField").val(),$("#newExtraField").val()));
												});

								$("#AddColumns")
										.click(
												function() {

													var localmappedItems = {};

													var sL = $("#movingNewDiv :selected").length;

													//	console.log(sL);

													if (sL == 1) {

														$(
																"#movingNewDiv option:selected")
																.each(
																		function() {

																			//  var item = $("#movingNewDiv option:selected").text();

																			var $this = $(this);

																			//  console.log(item);

																			//  mappedItems[item]=item;

																			localmappedItems[$this
																					.text()] = $this
																					.text();

																		})

														$("#movingNewDiv")
																.find(
																		"option:selected")
																.remove().end();

													}

													var keysLength = Object
															.keys(localmappedItems).length;

													//	console.log(keysLength);

													Object
															.keys(
																	localmappedItems)
															.forEach(
																	function(
																			item,
																			index) {

																		$(
																				"#requestNewDiv")
																				.append(
																						new Option(
																								item,
																								item));

																	})

												});

								$("#ReverseField").click(function() {

									//	$("#requestNewDiv").find("option:selected").remove().end();
									$("#requestNewDiv").empty();
								});

								$("#configSubmit")
										.click(
												function() {

													//  console.log(globalResponseid);

													//  var formData = new FormData();

													var details = $(
															'#slectNewDiv')
															.val();

													//	console.log(details);

													//  var totalDetails = document.getElementById("FileUpload").files.length;

													var username = "qamadmin";

													var password = "123456";

													// formData.append("templateId", globalResponseid)

													/*         for (var i = 0; i < details.length; i++) {
													
													          var file = details[i];
													
													          formData.append(file,i);
													
													        } */

													//	console.log(JSON.stringify(mappedItems));
													$
															.ajax({
																type : 'POST',

																url : svcUrlBase
																		+ '/newqamservices/api/createHealthDataTemplateConfig',

																//   enctype:'multipart/form-data',

																data : $
																		.param(mappedItems),

																//contentType: x-www-form-urlencoded,

																processData : false,

																headers : {
																	"Authorization" : "Basic "
																			+ btoa(username
																					+ ":"
																					+ password),

																	'Content-Type' : 'application/x-www-form-urlencoded'
																},

																success : function(
																		response) {

																	//		console.log(response.id);

																	//		console.log('succes!!');

																	$(
																			'#fieldStatus')
																			.html(
																					"Template "
																							+ response.templateName
																							+ " has been configured ");

																	$(
																			"#fieldStatus")
																			.show();

																	//	console.log("resposnse is ", JSON.stringify(response))

																},

																error : function(
																		error) {

																	//	console.log("errror");

																}
															}); // ajax

												}); // #configSubmit.click

							}); // document.ready()

		}(up.jQuery));
	</script>





	<div id="whole"
		style="width: 100%; height: 100%; min-height: calc(75vh - 50px);">





		<div id="templateCreation" class="jumbotron jumbotron-fluid"
			align="center"
			style="border-radius: 6px; padding: 0 0 0 0; margin-top: 5%;">





			<div id="templateListDiv" align="center" class="ui-widget"
				style="padding-top: 0px">

				<div class="panel panel-default">

					<div class="panel-heading cms-font-color">Create to Configure</div>

					<div class="panel-body" style="background: #d4bebe00">



						<label id="template_ID" style="display: inline-block"
							class="cms-font-color">Select Template Name </label> <select
							id="template_name" style="display: inline-block; width: 50%"
							class="cms-font-color" name="attributeNames" size="2">

							<option></option>

						</select> <span title="Select a template to configure"
							style="background: white; display: inline-block; border-radius: 50%; width: 23px; height: 23px; position: absolute; font-weight: bold; margin: 13px 0 40px 10px; padding-top: 2px">?</span>

						<br> <br>

					</div>

					<div id="mainDiv" align="left" class="panel-body"
						style="background: #d4bebe00">

						<div class="row">

							<p id="configuredColumns"
								style="margin-left: 60px; font-weight: bold"
								class="cms-font-color">

								Configured Columns: <span
									title="Select Columns to include for future uploads"
									style="background: white; display: inline; border-radius: 50%; width: 23px; text-align: center; height: 23px; position: absolute; font-weight: bold; font-size: 17px; margin: 4px 0 0 5px; float: right">?</span>
							<p>



								<select id="slectNewDiv" class="cms-font-color"
									name="attributeNames"
									style="height: 30%; width: 40%; margin: 0 60px 0 90px; display: inline-block; float: left; overflow-x: auto; overflow-y: auto"
									size="9" multiple="multiple">

								</select>
							<p id="configureEntry" style="margin-left: 5%; font-weight: bold"
								class="cms-font-color">

								Create unique ID<span
									title="Select columns to Merge to create a unique ID"
									style="background: white; display: inline; border-radius: 50%; width: 23px; text-align: center; height: 23px; position: absolute; font-weight: bold; font-size: 17px; margin: 3px 0 0 5px; float: right">?</span>
							<p>
							<div id="NewMergedDiv" class="rows form-group center">

								<div class="col-md-5">

									<select id="movingNewDiv" name="attributeNames" size="9"
										multiple="multiple" class="form-control">

									</select>

								</div>

								<div class="col-md-2 text-center" style="padding-top: 10px;">

									<button id="ConcatinateField" class="btn btn-default">>></button>
									<br> <br> <br> <br>
									<button id="ReverseField" class="btn btn-default"><<</button>

								</div>


								<div class="col-md-5">

									<select id="requestNewDiv" name="attributeNames" size="9"
										multiple="multiple" class="form-control">

									</select>

								</div>



							</div>

							<br> <br>

							<!-- style ="display:inline-block; margin-top:170px" -->

						</div>

						<br>

						<div class="row">



							<div align=center class="col-md-6">

								<button id="movingField" class="btn btn-default pull-right">Configure</button>

								<button id="configSubmit" class="btn btn-default pull-right">Submit</button>

							</div>

							<div class="col-md-6 pull-left">

								<button id="resetBtn" class="btn btn-default">Reset</button>

							</div>

						</div>
						<br>

						<div align="center" id="fieldStatus"></div>

						<br>

					</div>

				</div>

			</div>

		</div>

	</div>





</body>

<jsp:include page="footer.jsp"></jsp:include></html>

