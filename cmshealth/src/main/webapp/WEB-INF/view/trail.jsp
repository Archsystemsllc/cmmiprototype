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

<div id = "userData">


</div>

<div id="template" style="display:none;">
    <div>
      <label id="newCol"></label>
        <input type="number" min="1" max="17" id="colID">
<!--         <button type="button" class="remove">Remove</button> -->
 
    </div>

</div>

<form id="form1">
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
    <button type="button" id="addAddress">Add Column</button>
    <div id="fields">        
    </div>
    <button type="button" id="Submit">Submit</button>
</form>

</body>

<script>

$(document).ready(function(){
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
      });
      
	
    $("#Submit").click(function(){
    var elems=$('#userData >');
    var fData= new FormData();
   
		console.log(elems);
		$.each(elems,function(index,item){
			console.log(item.id);
			var childelems=$('#'+item.id+' >');
			var lbl=$('#'+childelems[0].id+'').text();
			var val = $('#'+childelems[1].id+'').val();
			console.log(lbl,val);
			fData.append(lbl.toString(),val.toString());
/* 			$.each(childelems,function(idx,citem){
				if(idx == 0){
					formData.append()
					
				}
			}) */
		})
		
		
		console.log(fData.values);
		
		
		
		
   // console.log($("#template #colID").val());
    });
    
    $("#form1").on("click", ".remove", function(){
        $(this).parent().remove();
    });
});
</script>




</html>

