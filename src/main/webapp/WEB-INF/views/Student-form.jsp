<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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

<title align="center">Save Student</title>
</head>

<body>

	<div class="container">

		<h3 align="center">Student Directory</h3>
		<hr>

		<h4 align="left" class="h4 mb-4">Student</h4>

		<form action="/StudentManagementSystem/student/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${student.id}" />

			<label>Student Name:</label>
				<input type="text" name="name" value="${student.name}"
					class="form-control mb-4 col-4" placeholder="Name" size="45">
					
			<label>Student Department:</label>
				<input type="text" name="department" value="${student.department}"
					class="form-control mb-4 col-4" placeholder="Department" size="45">


			<label>Student Country</label>
				<input type="text" name="country" value="${student.country}"
					class="form-control mb-4 col-4" placeholder="Country" size="45">




			<button type="submit" class="savebtn">Save</button>

		</form>

		<hr>
		<a href="/StudentManagementSystem/student/list">Back to student List</a>

	</div>
</body>

</html>


