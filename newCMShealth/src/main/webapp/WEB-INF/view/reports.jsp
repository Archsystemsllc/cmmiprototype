
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="resources/jquery-3.2.1.js"></script>

<script>
var up={}
up.jQuery  = $;
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>REPORT</title>


<style>
.jumbotron {
	width: 90%;
	margin-top: 50px;
	margin-right: 100px;
	margin-left: 100px;
	padding: 50px 0px 50px 90px;
	color: #3d3d3d;
	background-color: hsla(180, 2%, 87%, 0.5);
}
</style>
</head>
<body>
<jsp:include page="admin_header.jsp"></jsp:include>

	<script>
(function($) {  // jQuery wrapper for uPortal
    	$(document).ready(function () {

    	
    		var templates = [];
          // load templates
          getListTemplates();
          var itemName = "";
          var selectedOption = "";
          var selectedTemplate = "";
          
            document.body.style.backgroundImage = "url('resources/images/image1CMS.jpg')";
        	document.body.style.backgroundRepeat="no-repeat";
        	document.body.style.backgroundSize="cover";
        	
            $("#uploadStatus").show();
             
          
        });  // document.ready()

        function showAndHide(selecteditem){
          console.log(selecteditem);
        }

      }(up.jQuery));
    </script>
	<div id="whole">
		<div id=jumbo class="jumbotron jumbotron-fluid">

			<div id="upload">

				<h2 style="text-align: center; border: 0px; padding: 0px">Uploads Report</h2>
				<br /> <br />

				<div>
				

<table><tr><td>Reports are TBD</td></tr></table>
				
				</div>
				<br> 
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>


