
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CreateTemplate</title>

<script src="resources/jquery-3.2.1.js"></script>


<script>
var up={}
up.jQuery  = $;
var mappedItems = {};
</script>


  <link rel="stylesheet" href="resources/css/uswds.css" />
  <link rel="stylesheet" href="resources/css/uswds.min.css" />
  <link rel="stylesheet" href="resources/css/uswds.min.css.map" />
  
  
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
<script>
(function($) {  // jQuery wrapper for uPortal
    $(document).ready(function () {
      $("#templateListDiv").show();
   //   $("#configSubmit").hide();
    //  $("#mainDiv").hide();
    //  $("#statusID").hide();
     // $("#fieldStatus").hide();
      
      document.body.style.backgroundImage = "url('resources/images/image1.jpg')";
    	document.body.style.backgroundRepeat="no-repeat";
    	document.body.style.backgroundSize="cover";


      function getListTemplates() {
        var username="qamadmin";
        var password="123456";
        $.ajax({
            type:'GET',
            url:'http://localhost:8080/qamservices/api/listTemplates',
                   enctype:'multipart/form-data',
                   contentType: false,
                   processData: false,
            headers:{  "Authorization": "Basic " + btoa(username+":"+password)},
            success: function(response) {
                   // console.log('succes!!' );
              var options =[]; //$('#divTemplates #selectTemplates');
              var data=[];
              var data=JSON.stringify(response);
              response.forEach(function(item) {
                options.push('<option value="', item.id, '">', item.id, '</option>');
              })

              $("#divTemplates #selectTemplates").html(options.join(''));

            },
            error: function (error) {
              console.log("errror");
            }
        });  // ajax
      }  // getListTemplates()

      $("#templateSubmit").click(function () {
        var username="qamadmin";
        var password="123456";
        var templatecreate ={};
        templatecreate.name=$("#template_name").val();
        //console.log(templatecreate.name);
        var formData=new FormData();
        formData.append("name",$("#template_name").val())
        if (templatecreate.name!=null && templatecreate.name!='') {
          $.ajax({
              type: 'POST',
              url: 'http://localhost:8080/qamservices/api/createTemplate',
              enctype:'multipart/form-data',
              data:formData,
              contentType: false,
              processData: false,
              headers:{  "Authorization": "Basic " + btoa(username+":"+password)},
              success: function(response) {
                // console.log('succes!!' );
                console.log(response);
                templatenameid = response.id;
                globalResponseid = response.id
                getListTemplates();
             //   $('#statusID').html("Your Template has been created with id : " + globalResponseid);
                $("#configSubmit").show();
                $("#mainDiv").show();
                $("#statusID").show();
              },
              error: function (error) {
                console.log("errror");
              }
          });
        }
        else{
          getListTemplates();  
        }
      });  // #templateSubmit.click
      
/*       $("#addNewField").click(function () {
    	 $("#slectNewDiv").append(new Option($("#newExtraField").val(),$("#newExtraField").val()));
      }); */
      
  
      $("#moveField").click(function () {
    	  localmappedItems = {};
    	  var selectedLength = $("#slectNewDiv :selected").length;
    	  console.log(selectedLength);
    	  var concatinateVal= '';
    	  if(selectedLength == 2){
    		  var tempArray = [];
    		  $("#slectNewDiv option:selected").each(function () {
    			  var $this = $(this);
    			  concatinateVal += $this.text() + ' ';
    			  tempArray.push($this.text());
    		  })
    		  mappedItems[concatinateVal] = tempArray;
    		  localmappedItems[concatinateVal] = tempArray;
    	  }
    	  if(selectedLength == 1){
    		  var item = $("#slectNewDiv option:selected").text();
    		  console.log(item);
    		  mappedItems[item]=item;
    		  localmappedItems[item] = item;
    	  }
    	  var keysLength = Object.keys(localmappedItems).length;
    	  console.log(keysLength);
    	  Object.keys(localmappedItems).forEach(function(item,index){
    		  $("#requestNewDiv").append(new Option(item,item)); 
    	  })
    	//  for(int i=0;i<keysLength;i++){
    	 // $("#requestNewDiv").append(Object.keys(mappedItems)[i],Object.keys(mappedItems)[i]);
    	//  }
    	  console.log(JSON.stringify(localmappedItems));

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
      

      $("#configSubmit").click(function () {
        console.log(globalResponseid);
        var formData = new FormData();
        var details = $('#slectNewDiv').val();
        console.log(details);
        //  var totalDetails = document.getElementById("FileUpload").files.length;
        var username="qamadmin";
        var password="123456";
        formData.append("templateId", globalResponseid)
        for (var i = 0; i < details.length; i++) {
          var file = details[i];
          formData.append(file,i);
        }
console.log(JSON.stringify(mappedItems));
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/qamservices/api/createHealthDataTemplateConfig',
            //   enctype:'multipart/form-data',
            data:mappedItems,
            contentType: false,
            processData: false,
            headers:{  "Authorization": "Basic " + btoa(username+":"+password)},
            success: function(response) {
            	console.log(response.id);
              console.log('succes!!');
              $('#fieldStatus').html("Template " +response.id + " has been configured ");
              $("#fieldStatus").show();
              console.log("resposnse is ", JSON.stringify(response))
            },
            error: function (error) {
              console.log("errror");
            }
        });  // ajax
      });  // #configSubmit.click
    });  // document.ready()
  }(up.jQuery));
</script>
<div id="whole">
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
        <option value="categoryName">categoryName</option>
        <option value="msaName">msaName</option>
        <option value="uniqueId">uniqueId</option>
        <option value="mapDisplay">mapDisplay</option>
      </select> 
      		<br>
      		
      		<button id="moveField" class="btn btn-default">Concatenate</button>
      		<br>
      		
      <select id="requestNewDiv" name="attributeNames" size="5"
                                                     multiple="multiple">
      </select> 
      <br>
      
      		<!-- Add extra Field
      		<br>
         <input type ="text" id="newExtraField">
         <button id="addNewField" class="btn btn-default">addnewfield</button> -->
         
		 <br>
      <div align="center" id="fieldStatus"></div>
      <br>
      <div>
        <button id="configSubmit" class="btn btn-default">ConfigSubmit</button>
      </div>
    </div>
  </div>
</body>
</html>

