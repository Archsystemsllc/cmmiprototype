
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
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet"
          href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" />
    <link
          href="https://fonts.googleapis.com/css?family=Cookie|Fredericka+the+Great"
          rel="stylesheet">
  </head>
  <body>
    <script>
(function($) {  // jQuery wrapper for uPortal
    	$(document).ready(function () {

        	
          // load templates
          getListTemplates();

          $("#Submit").click(function () {
            var formData = new FormData();
            var totalFiles = document.getElementById("FileUpload").files.length;
            var username="qamadmin";
            var password="123456";

            for (var i = 0; i < totalFiles; i++) {
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
                var responseString = "";
                //console.log("resposnse is ", JSON.stringify(response));
                $.each(response, function(idex,item) {
                  console.log(item.id, item.status);
                  //var htmlTable = item.id;
                  //var html = htmlTable.outerHTML;
                  responseString = responseString + "ITEM ID: " + item.id + " " + "Status: " + item.status + "<br>";
                })
                $("#uploadStatus").show();
                $("#uploadStatus").html(responseString);
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
              url:'http://cmstest.us-east-1.elasticbeanstalk.com/api/listTemplates',
              enctype:'multipart/form-data',
              contentType: false,
              processData: false,
              headers:{  "Authorization": "Basic " + btoa(username+":"+password)},
              success: function (response) {
                // console.log('succes!!' );
                var options =[]; //$('#divTemplates #selectTemplates');
                var data=[];
                var data=JSON.stringify(response);
                response.forEach(function(item) {
                  options.push('<option value="', item.id, '">', item.id, '</option>');
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

      })(up.jQuery);
    </script>
    <div id="whole">
      <div id=jumbo class="jumbotron jumbotron-fluid">

        <div id="upload">

          <h3>Upload file</h3>
          <br />
          <br />
          <div  id="divTemplates">
            <font size="4">Select Template ID : </font><select id="selectTemplates"></select>
          </div>
          <br>
          <label class="custom-file"> <input type="file"
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


