
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CreateTemplate</title>

<script src="resources/jquery-3.2.1.js"></script>

<script>
var up={}
up.jQuery  = $;
</script>

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
<script>
(function($) {  // jQuery wrapper for uPortal
    $(document).ready(function () {
      $("#templateListDiv").show();
     $("#configSubmit").hide();
     $("#mainDiv").hide();
      $("#statusID").hide();
      $("#fieldStatus").hide(); 
      
      
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
                templatenameid = response.id;
                globalResponseid = response.id
                getListTemplates();
                $('#statusID').html("Your Template has been created with id : " + globalResponseid);
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
        
        $("#form1").on("click", ".remove", function(){
            $(this).parent().remove();
        });
        
      });  // #templateSubmit.click
      
      
      $("#addAddress").click(function(){
      	console.log($("#slectNewDiv").val());
        var selectedData = $('#slectNewDiv').val();
        var tempHtml =[];
         $.each(selectedData, function(index,item){
  			tempHtml.push('<div class="divofchaild" id="',
  		item + 'div_'+index, '">','<label id="',
                  item + 'lbl_'+index, '"> ',item, '</label>&nbsp;&nbsp;',
                  '<input type="number" min="1" max="17" id="',
                  item + 'text_' +index+ '"', '>&nbsp;&nbsp;',
  		'<button class="remove" id="',
  		item + 'btn_'+index, '">remove</button>',
        '</div>' );
                  
  		})

      		$("#userData").html(tempHtml.join(''));



      		var details = $('#slectNewDiv').val();
          for (var i = 0; i < details.length; i++)
              {
              $('#newCol').html(details[i]);
            $("#fields").append($("#template").html());
            
            }
        });// #addColumn Click Function

      $("#configSubmit").click(function () {
  	    var elems=$('#userData >');
	    var formData= new FormData();
        console.log(globalResponseid);
    //    var formData = new FormData();
        var details = $('#slectNewDiv').val();
        console.log(details);
        //  var totalDetails = document.getElementById("FileUpload").files.length;
        var username="qamadmin";
        var password="123456";
        
        
        console.log(elems);
		$.each(elems,function(index,item){
			console.log(item.id);
			var childelems=$('#'+item.id+' >');
			var lbl=$('#'+childelems[0].id+'').text();
			var val = $('#'+childelems[1].id+'').val();
			console.log(lbl,val);
			formData.append(lbl,val);
		})
		alert("2");

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/qamservices/api/createHealthDataTemplateConfig',
            //   enctype:'multipart/form-data',
            data:formData,
            contentType: false,
            processData: false,
            headers:{  "Authorization": "Basic " + btoa(username+":"+password)},
            success: function(response) {
              console.log('succes!!');
              alert("success");
              $("#fieldStatus").show();
              $('#fieldStatus').html("Template " +globalResponseid + " has been configured ");
              alert("new resposnse is " + JSON.stringify(response));
           

             // console.log("resposnse is ", JSON.stringify(response))
            },
            error: function (error) {
              console.log("errror");
            }
        });  // ajax
        alert("done");
      });  // #configSubmit.click
      function showAndHide(selecteditem){
          console.log(selecteditem);
        }
      
      $("#form1").on("click", ".remove", function(){
          $(this).parent().remove();
      });
      
    });  // document.ready()
    

  }(up.jQuery));
</script>
<div id="whole">
  <div id="templateCreation" class="jumbotron jumbotron-fluid"
                             align="center">
    <div id="templateListDiv" align="center" class="ui-widget"
                                             style="padding-top: 40px;">
    <label>Please enter the details for Template Configuration</label>
                            <br><br>            
      <label id="template_ID">Enter Template Name </label> <input
             type="text" id="template_name" /> <br>
             <button id="templateSubmit" class="btn btn-default">Next</button>
    </div>
    
    


<div id="template" style="display:none;">
    <div>
      <label id="newCol"></label>
        <input type="number" min="1" max="17" id="colID">
<!--         <button type="button" class="remove">Remove</button> -->
 	 </div>
</div>
    
    
    <br>
    <div align="center" id="statusID"></div>
    <br>
    <div id="mainDiv">
      <h3>Select required fields </h3>
       <div id="form1">
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
      <button type="button" id="addAddress">Add Column</button>
<div id = "userData">
</div>
      <div align="center" id="fieldStatus"></div>
      <br>
      <div>
        <button id="configSubmit" class="btn btn-default">Submit</button>
      </div>
       </div> 
    </div>
   
  </div>
</body>
</html>

