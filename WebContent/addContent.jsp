<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="ErrorPage.jsp" %>
    <
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Content</title>
<script type="text/javascript" src="addCourse.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%@ include file="header.jsp" %>
	<div class="container" style="height: 100vh">
		<div class="row justify-content-center align-items-center" style="height: 100vh">
			<div class="col-6">
				<img class="img-fluid" alt="temp" src="Source/2.jpg" style="width:70vw ">
				
			</div>
			<div class="col-6">
				<form class="form was-validated" action="addCourseContentServlet.java" method="post"  >
				<table  class="table-border" >
					<tr>
						<td class="text-weight-bold">
							Course id :
						</td>
						<td >
							<input class="form control mb-2"  disabled="disabled">
						</td>
					</tr>
				<tr>
						<td>
							Course Name : 
						</td>
						<td >
							<input class="form control mb-2"  disabled="disabled">
						</td>
					</tr>
					<tr>
						<td>
							Lecture No:
						</td>
						<td>
							<input class="form-control mb-2 is-valid" required="required" type="text" pattern="^[0-9]*$" name="lectureNo" />
						</td>
					</tr>
					<tr>
						<td>
							Lecture Heading:
						</td>
						<td>
							<input class="form-control mb-2 is-valid" required="required" type="text" pattern="^[a-zA-Z ]*$" name="lectureName" />
						</td>
					</tr>
					<tr>
						<td>
							Add URL :
						</td>
						<td>
							<input class="form-control mb-2 is-valid" required="required" type="text" pattern="^(https?\:\/\/)?(www\.youtube\.com|youtu\.?be)\/.+$" name="url" />
						</td>
						
					</tr>
					<tr>
						<td>
							 Description : 
						</td>
						<td>
							<textarea class="form-control mb-2 is-valid" required="required" type="text"  name="lecDesc"></textarea>
						</td>
					<tr>
					<tr class="row">
						<td >
							<input class="btn btn-outline-primary" type="submit"  value="Add Lecture"  >
						</td>
						<td>
							<a class="btn btn-outline-primary" href="tutorHome.jsp">Done </a>
						</td>
					</tr>
				
			</table>
		</form>
	</div>
	</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>