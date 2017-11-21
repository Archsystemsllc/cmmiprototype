<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="resources/jquery-3.2.1.js"></script>
<script src="resources/bootstrap-multiselect.js"></script>

</head>

<body>
	<h2 align="center" style="color: White">List Templates</h2>
	<div id="templateListDiv" class="ui-widget" align="center"
		style="padding-top: 40px;">
		<label id="template_ID">Enter Template Name </label> <input
			type="text" id="template_name" />
		<button id="templateSubmit" class="btn btn-default">Submit</button>
	</div>
	<br>
	<br>
	<div align="center" id ="statusID"></div>
	<div align="center" id="divTemplates">
		<select id="selectTemplates">

		</select>
	</div>


	<div align="center" id="mainDiv">
		<p> Please Select all the Template fields</p>
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
		</select>
<br><br>
		<div>
			<button id="configSubmit" class="btn btn-default">ConfigSubmit</button>
		</div>
	</div>





</body>

<script>
var globalResponseid = 0;
var templatenameid = {};
$(document).ready(function () {
function getListTemplates(){
	var username="qamadmin";
	var password="123456";
	
	$.ajax({
		type:'GET',
		url:'http://localhost:8080/qamservices/api/listTemplates',
           enctype:'multipart/form-data',
           contentType: false,
           processData: false,
		headers:{  "Authorization": "Basic " + btoa(username+":"+password)},
		success: function (response) {
           // console.log('succes!!' );
		var options =[]; //$('#divTemplates #selectTemplates');
		var data=[];
		var data=JSON.stringify(response);
		response.forEach(function(item){
			options.push('<option value="',
			          item.id, '">',
			          item.id, '</option>');
		})
	
		$("#divTemplates #selectTemplates").html(options.join(''));
			
		
        },
        error: function (error) {
            console.log("errror");
        }
	});
}

	 
        $("#templateSubmit").click(function () {
 
			var username="qamadmin";
			var password="123456";
			var templatecreate ={};
			templatecreate.name=$("#template_name").val();
			//console.log(templatecreate.name);
			var formData=new FormData();
			formData.append("name",$("#template_name").val())
			if(templatecreate.name!=null && templatecreate.name!=''){
				 $.ajax({
               type: 'POST',
               url: 'http://localhost:8080/qamservices/api/createTemplate',
               enctype:'multipart/form-data',
               data:formData,
               contentType: false,
               processData: false,
			  headers:{  "Authorization": "Basic " + btoa(username+":"+password)},

			   success: function (response) {
                   // console.log('succes!!' );
					templatenameid = response.id;
					globalResponseid = response.id
					getListTemplates();
					$('#statusID').html("Your Template has been created with id : " + globalResponseid);
					
				
                },
                error: function (error) {
                    console.log("errror");
                }
            });
				
			}
			else{
				getListTemplates();	
			}
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
        	for (var i = 0; i < details.length; i++)
            {
                var file = details[i];

                formData.append(file,i);
            }

            
            

            $.ajax({
               type: 'POST',
               url: 'http://localhost:8080/qamservices/api/createHealthDataTemplateConfig',
            //   enctype:'multipart/form-data',
        	   data:formData,
               contentType: false,
               processData: false,
        	  headers:{  "Authorization": "Basic " + btoa(username+":"+password)},

        	   success: function (response) {
                    console.log('succes!!');
        		console.log("resposnse is ", JSON.stringify(response))
                },
                error: function (error) {
                    console.log("errror");
                }
            });
        });
    });
    
    
    
    
    

    


</script>




</html>