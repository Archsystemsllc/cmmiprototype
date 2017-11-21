
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

    	
    		var templates = [];
          // load templates
          getListTemplates();
          var itemName = "";
          var selectedOption = "";
          var selectedTemplate = "";
          
            document.body.style.backgroundImage = "url('resources/images/image1.jpg')";
        	document.body.style.backgroundRepeat="no-repeat";
        	document.body.style.backgroundSize="cover";
        	
          $("#Submit").click(function () {
            var formData = new FormData();
            var totalFiles = document.getElementById("FileUpload").files.length;
            var username="qamadmin";
            var password="123456";            

            for (var i = 0; i < totalFiles; i++) {
              var file = document.getElementById("FileUpload").files[i];
              formData.append("file", file);
            }
           	selectedOption = $('#divTemplates #selectTemplates option:selected').text();
           
            //alert(selectedOption)

            $.ajax({
              type: 'POST',
              url: 'http://localhost:8080/qamservices/api/uploadHealthData/'+ selectedOption,
              enctype:'multipart/form-data',
              data:formData,
              contentType: false,
              processData: false,
              headers:{  "Authorization": "Basic " + btoa(username+":"+password)},
              success: function (response) {
                  //console.log(response);
                  //console.log("Total Input:" +JSON.stringify(response.initialFileSize));
                  //console.log("Total Input:" +response.initialFileSize);
                  //console.log("OutPut Response"+ response.listOfHealthCommunity);
                  //console.log("OutPut Response"+ JSON.stringify(response.listOfHealthCommunity));
                //console.log("JSON RESPONSE" + JSON.stringify(response));
                var responseSize = response.initialFileSize;
                var responseString = "";
                var responseFalse= "";
                var selectedTemplate = templates[selectedOption-1];
                console.log(selectedTemplate);
                //console.log("resposnse is ", JSON.stringify(response));
                $.each(response.listOfHealthCommunity, function(idex,item) {
               //   console.log(item.id,item.status);
                  
              //    console.log(htmlTable.size);
                  //var html = htmlTable.outerHTML;
                if(item.status == true){
                //	console.log("True Statements"+item.status);
                responseString = responseString + item.status;
                  }
                else if(item.status == false){
                	
                //	console.log("False Statements"+item.status);
              	responseFalse = responseFalse + item.status;
                  }
                else{
                	
                	responseFalse = responseFalse + responseSize;
                	
                }
                
                })
                //console.log(htmlTable.length);
                $("#uploadStatus").show();
                $("#uploadStatus").html( "Template Name : " + selectedTemplate + "<br>" + "Total records Submitted : " + responseSize + "<br>" + "Successful records : " +  responseString.length/4 + "<br>" + "Failed records : "+ responseFalse.length  );
                
              },
              error: function (error) {
                alert("errror");
              }
            });  // ajax call
          }); // #Submit.click

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
                console.log(response);
                //var selectedOption = $('#divTemplates #selectTemplates option:selected').text();
               	
                
                var options =[]; 
                //$('#divTemplates #selectTemplates');
                
                var data=[];
                var data=JSON.stringify(response);
                
        
                
                response.forEach(function(item) {
                  options.push('<option value="',item.id, '">', item.id, '</option>');
                  templates.push(item.name);
                 
                  itemName= itemName + item.name;
                  //console.log(itemName);
                  
                });
                

                $("#divTemplates #selectTemplates").html(options.join(''));
              },
              error: function (error) {
                console.log("errror");
              }
            });  // ajax call

          }  //getListTemplates()
          

        });  // document.ready()

        function showAndHide(selecteditem){
          console.log(selecteditem);
        }

      }(up.jQuery));
    </script>
	<div id="whole">
		<div id=jumbo class="jumbotron jumbotron-fluid">

			<div id="upload">

				<h3>Upload file</h3>
				<br /> <br />
				<div id="divTemplates">
					<font size="4">Select Template ID : </font><select
						id="selectTemplates"></select>
				</div>
				<br> <label class="custom-file"> <input type="file"
					id="FileUpload" name="file" /><br /> <span
					class="custom-file-control"></span>
					<p class="butt">
						<button type="submit" id="Submit" value="Submit"
							class="btn btn-default">Submit</button>
					</p>
					<p id="uploadStatus"></p>

				</label>
			</div>
		</div>
	</div>
</body>
</html>


