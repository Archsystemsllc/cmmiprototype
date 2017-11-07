
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CreateTemplate</title>

<script src="resources/jquery-3.2.1.js"></script>


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
jQuery.noConflict()(function($) {  // jQuery wrapper for uPortal
    $(document).ready(function () {
      $("#templateListDiv").show();
      $("#configSubmit").hide();
      $("#mainDiv").hide();
      $("#statusID").hide();
      $("#fieldStatus").hide();

      function getListTemplates() {
        var username="qamadmin";
        var password="123456";
        $.ajax({
            type:'GET',
            url:'http://cmstest.us-east-1.elasticbeanstalk.com/api/listTemplates',
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
              url: 'http://cmstest.us-east-1.elasticbeanstalk.com/api/createTemplate',
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
      });  // #templateSubmit.click

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

        $.ajax({
            type: 'POST',
            url: 'http://cmstest.us-east-1.elasticbeanstalk.com/api/createHealthDataTemplateConfig',
            //   enctype:'multipart/form-data',
            data:formData,
            contentType: false,
            processData: false,
            headers:{  "Authorization": "Basic " + btoa(username+":"+password)},
            success: function(response) {
              console.log('succes!!');
              $('#fieldStatus').html("Template " +globalResponseid + " has been configured ");
              $("#fieldStatus").show();
              console.log("resposnse is ", JSON.stringify(response))
            },
            error: function (error) {
              console.log("errror");
            }
        });  // ajax
      });  // #configSubmit.click
    });  // document.ready()
  });//(up.jQuery)
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
        <option value="msaName">msaName</option>
        <option value="uniqueId">uniqueId</option>
        <option value="mapDisplay">mapDisplay</option>
      </select> <br>
      <div align="center" id="fieldStatus"></div>
      <br>
      <div>
        <button id="configSubmit" class="btn btn-default">ConfigSubmit</button>
      </div>
    </div>
  </div>
</body>
</html>

