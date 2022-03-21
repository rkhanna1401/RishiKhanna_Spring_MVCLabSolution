<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<style>  
body{  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: #293741;  
}  
.container {  
    padding: 50px;  
  background-color: lightblue;  
}  
hr {  
  border: 1px solid #f1f1f1;  
  margin-bottom: 25px;  
}  

.savebtn {  
  background-color: #4CAF50;  
  color: white;  
  padding: 16px 20px;  
  margin: 8px 0;  
  border: none;  
  cursor: pointer;  
  width: 10%;  
  opacity: 0.9;  
}  
.savebtn:hover {  
  opacity: 1;  
}  
</style>  

<title align="center">Student Directory</title>
</head>

<body>

	<div class="container">

		<h3>Student Directory</h3>
		<hr>

		<!-- Add a search form -->

		<form action="/StudentManagementSystem/student/search"
			class="form-inline">

			<!-- Add a button -->
			<a href="/StudentManagementSystem/student/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Student </a>

		</form>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>STUDENT_ID</th>
					<th>STUDENT_NAME</th>
					<th>STUDENT_DEPARTMENT</th>
					<th>STUDENT_COUNTRY</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${student}" var="temp">
					<tr>
						<td><c:out value="${temp.name}" /></td>
						<td><c:out value="${temp.department}" /></td>
						<td><c:out value="${temp.country}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/StudentManagementSystem/student/showFormForUpdate?id=${temp.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a
							href="/StudentManagementSystem/student/delete?id=${temp.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>



