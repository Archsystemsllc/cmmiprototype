<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>

<script src="resources/jquery-3.2.1.js"></script>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"/>
<link href="https://fonts.googleapis.com/css?family=Cookie|Fredericka+the+Great" rel="stylesheet">
<script>
    $(document).ready(function () {
	$("#upload").hide();
	$("#jumbo").hide();
	document.body.style.backgroundImage = "url('resources/images/image1.jpg')";
		
	 $('#newupload').click(function(event) {
		 $("#upload").show(); 
		 $("#jumbo").show();
	 });
	 
        $("#Submit").click(function () {
            var formData = new FormData();
            var totalFiles = document.getElementById("FileUpload").files.length;
			var username="qamadmin";
			var password="123456";

            for (var i = 0; i < totalFiles; i++)
            {
                var file = document.getElementById("FileUpload").files[i];

                formData.append("file", file);
            }
            
            

            $.ajax({
               type: 'POST',
               url: 'http://cmstest.us-east-1.elasticbeanstalk.com/api/uploadHealthData/1',
               enctype:'multipart/form-data',
			   data:formData,
               contentType: false,
               processData: false,
			  headers:{  "Authorization": "Basic " + btoa(username+":"+password)},

			   success: function (response) {
                    alert('succes!!');
				console.log("resposnse is ", JSON.stringify(response))
                },
                error: function (error) {
                    alert("errror");
                }
            });
        });
    });

	function showAndHide(selecteditem){
	  console.log(selecteditem);
		 
	  }


</script>
<style>
   .jumbotron {
      width: 50%;
      margin-top: 150px;
      margin-right: 350px;
      margin-left: 350px;
      padding: 50px 0px 50px 90px;
      color: #3d3d3d;
     background-color:hsla(180, 2%, 87%,0.5);
</style>
</head>
		<body>
			<div id="whole">
				<nav class="navbar navbar-inverse navbar-fixed-top navbar-right">
					  <div class="container">
						   <div class="row">
							    <div id="main" class="btn-group btn-group-justified">
							    <a class="btn btn-primary home">Home</a>
							    <a id = "newupload" href="#upload" class="btn btn-primary uploads">Upload-documents</a>
							    <a href="#" class="btn btn-primary contact-us">Contact Us</a>
							  </div>
						  </div>
					   </div>
			   </nav> 
			   <div id = jumbo class = "jumbotron jumbotron-fluid">
			   
					<div id ="upload">
					
					<h3>Upload file</h3>
					<br/><br/>
							 <label class="custom-file">
						     <input type="file" id ="FileUpload" name="file" /><br/>
						     <span class="custom-file-control"></span>
						     <p class="butt">
						     <button type="submit" id="Submit" value="Submit" class="btn btn-default">Submit</button>
						     </p>
					   </label>
				   </div>
				</div>
		 </body>
</html>

