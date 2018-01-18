<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="resources/jquery-3.2.1.js"></script>
<title>Insert title here</title>
<script>
	var up = {}
	up.jQuery = $;
	var svcUrlBase = 'http://localhost:8080';

</script>
</head>

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
</style>
<body>
	<jsp:include page="layout.jsp"></jsp:include>
	<script>

(function($) {  // jQuery wrapper for uPortal
    	$(document).ready(function () {

    		getReports();
            function getReports() {
                var username="qamadmin";
                var password="123456";
                $.ajax({
                    type:'GET',
                    url:svcUrlBase+'/newqamservices/api/reporting',       
                           enctype:'multipart/form-data',
                           contentType: false,
                           processData: false,
                    headers:{  "Authorization": "Basic " + btoa(username+":"+password)},
                    success: function(response) {
                           // console.log('succes!!' );
                      var options =[]; //$('#divTemplates #selectTemplates');
                    //  var data=[];
                    var itemsLength = response.length;
                      var data=JSON.stringify(response);
                      console.log("Data : "+data);
                      $.each(response,function(index,item) {
                    	  console.log(JSON.stringify(item));
						var savedData = JSON.stringify(item);
						$(
						"#savedData")
						.html(savedData);
                      })


                  //    $("#template_name").html(options.join(''));

                    },
                    error: function (error) {
                      console.log("errror");
                    }
                });  // ajax
              } 

         
            
            function showAndHide(selecteditem){
              console.log(selecteditem);
            }

            
          
        });  // document.ready()

 
      }(up.jQuery));
    </script>
	<div id=jumbo class="jumbotron jumbotron-fluid"
		style="background: #fff;">
		<p id="savedData" class="cms-font-color"></p>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>