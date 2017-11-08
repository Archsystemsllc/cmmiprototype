
    $(document).ready(function () {
	$("#upload").hide();
	$("#jumbo").hide();
	$("#templateListDiv").hide();
	$("#configSubmit").hide();
	$("#mainDiv").hide();
	$("#divTemplates").hide();
	$("#templateCreation").hide();
	$("#statusID").hide();
	$("#fieldStatus").hide();
	
	
	document.body.style.backgroundImage = "url('resources/images/image1.jpg')";
	document.body.style.backgroundRepeat="no-repeat";
	document.body.style.backgroundSize="cover";
		
	 $('#newupload').click(function(event) {
		 getListTemplates();
		 $("#upload").show(); 
		 $("#jumbo").show();
		 $("#templateListDiv").hide();
			$("#templateListDiv").hide();
			$("#configSubmit").hide();
			$("#mainDiv").hide();
			$("#divTemplates").show();
			$("#templateCreation").hide();
			$("#statusID").hide();
			$("#fieldStatus").hide();
			
	 });
	 
	 $('#createTemp').click(function(event) {
		 $("#upload").hide(); 
		 $("#jumbo").hide();
		 $("#templateListDiv").show();
		 $("#configSubmit").hide();
			$("#mainDiv").hide();
			$("#divTemplates").hide();
			$("#templateCreation").show();
			$("#statusID").hide();
			$("#fieldStatus").hide();
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
               url: 'http://localhost:8080/qamservices/api/uploadHealthData/1',
               enctype:'multipart/form-data',
			   data:formData,
               contentType: false,
               processData: false,
			  headers:{  "Authorization": "Basic " + btoa(username+":"+password)},

			   success: function (response) {
                  //  alert('succes!!');
                var responseString =  ""; 
				//console.log("resposnse is ", JSON.stringify(response));
				$.each(response, function(idex,item) {
					console.log(item.id, item.status);
					
					//var htmlTable = item.id;
			        //var html = htmlTable.outerHTML;
					responseString = responseString + "ITEM ID : " + item.id + "  " +  "Status : " + item.status + "<br>";
			        
			       // alert(html);
				})
				$("#uploadStatus").html(responseString);
                },
                error: function (error) {
                    alert("errror");
                }
            });
        });
        
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
        					
        					 $("#configSubmit").show();
        						$("#mainDiv").show();
        						$("#divTemplates").show();
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
                            $('#fieldStatus').html("Template " +globalResponseid + " has been configured ");
                            $("#fieldStatus").show();
                		console.log("resposnse is ", JSON.stringify(response))
                        },
                        error: function (error) {
                            console.log("errror");
                        }
                    });
                });
    });

	function showAndHide(selecteditem){
	  console.log(selecteditem);
		 
	  }


