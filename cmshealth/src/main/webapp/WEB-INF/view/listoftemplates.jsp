<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="resources/jquery-3.2.1.js"></script>


</head>
<body>
<h2 align="center" style="color:White" > List Templates </h2>
	<div id="templateListDiv" class="ui-widget" align="center" style="padding-top:40px;">
 	 	<label id ="template_ID" >Enter Template Name
 	 	 </label>
 	 	 <input type = "text" id="template_name" />
 	 	 <button id="templateSubmit" class="btn btn-default">Submit</button>
  		
  		

</body>

<script>

var templatenameid = {};
$(document).ready(function () {

		
	 
        $("#templateSubmit").click(function () {
 
			var username="qamadmin";
			var password="123456";
			var templatecreate ={};
			templatecreate.name=$("#template_name").val();
			console.log(templatecreate.name);
			var formData=new FormData();
			formData.append("name",$("#template_name").val())

            

            $.ajax({
               type: 'POST',
               url: 'http://cmstest.us-east-1.elasticbeanstalk.com/api/createTemplate',
               enctype:'multipart/form-data',
               data:formData,
             //  dataType:'json',
               contentType: false,
               processData: false,
			  headers:{  "Authorization": "Basic " + btoa(username+":"+password)},

			   success: function (response) {
                    alert('succes!!' );
				console.log("resposnse is " + response)
				var temp = {}
				temp = JSON.stringify(response);
				
				console.log("templog"+temp);
				templatenameid = temp['id'];
				console.log(temp.name);
                },
                error: function (error) {
                    alert("errror");
                }
            });
        });
    });
</script>

</html>