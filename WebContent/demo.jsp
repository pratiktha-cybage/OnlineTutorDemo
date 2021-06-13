<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
	<div class="container" style="height: 100vh">
		<div class="row justify-content-center align-items-center" style="height: 100vh">
			<div class="col-6">					
				<img class="img-fluid" alt="temp" src="Resources/2.jpg" style="width:70vw ">
				
			</div>
			<div class="col-6">
				<form action="UploadDownloadFileServlet" method="post" enctype="multipart/form-data">
					<div class="input-group">
						  <div class="custom-file">
						    <input type="file" class="custom-file-input was-validated " id="inputGroupFile1" name="file" multiple="multiple" aria-describedby="inputGroupFileAddon04" required>
						    <label class="custom-file-label" for="inputGroupFile1">Choose file</label>
						  </div>
						 </div>
					<br>								
					<input type="submit" value="Upload" >
				</form>
			</div>
			
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript">
		function removeContent(ele){
			let row = ele.parentNode.parentNode;
			console.log(row);
			row.remove();
		}
		function addContent(ele){
			let rows = document.querySelectorAll("tr");			
			let contentRow = document.querySelector("#contentRow").cloneNode(true);
			let contentParentRaw = document.querySelector("#contentRowParent");
			let parent = document.querySelector("#theTable");
			let rowId = Math.abs(7-rows.length+2);
			contentRow.style.display="";
			
			contentRow.id = "contentRow"+rowId;
			let content = contentRow.children[1].children[0].children[0].children[0];
			content.id = "insertGroupFile"+rowId;
			
			
			//parent.insertBefore(contentRaw,contentParentRaw.nextSibling);
			$("#contentRowParent").after(contentRow);
		}
		
		$('.custom-file-input').on('change',function(e){
            //get the file name
            
            var fileName = e.target.files[0].name;
	        this.parentNode.children[1].innerText = fileName;
	        console.log(fileName);
	        console.log( this.parentNode.children[1]);
        });
		
		/*$('#myform').submit(function(event) {
			event.preventDefault();
			
			var form = $('form')[0]; 
			var formData = new FormData(form);
			
			$.ajax({
			    type: "POST",
			    url: "/contentServlet",
			    data: formData,
			    //use contentType, processData for sure.
			    contentType: false,
			    processData: false,
			    
			    success: function(msg) {
			        console.log("success");
			    },
			    error: function() {
			        
			    }
			});
		});*/
			
		function submitData(){
			var formData = new FormData();
			var filesLength=document.getElementById('inputGroupFile1').files.length;
			for(var i=0;i<filesLength;i++){
				formData.append("file[]", document.getElementById('inputGroupFile1').files[i]);
			}
			
		}
	</script>
</body>
</html>