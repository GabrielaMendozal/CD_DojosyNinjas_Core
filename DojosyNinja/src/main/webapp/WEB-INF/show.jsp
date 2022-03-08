<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dojo Page</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	</head>
	<body>
		<div class="container">
				<div class="d-flex justify-content-between align-items-center pb-4">
					<h3>Ninjas</h3>
				</div>
				
				<div class="table-responsive">
					<table class="table table-hover">
					  <thead>
					    <tr>
					      <th scope="col">First Name</th>
					      <th scope="col">Last Name</th>
					      <th scope="col">Age</th>
					    </tr>
					  </thead>
					  <c:forEach var="dojo" items="${dojos}">
					  <tbody>
						  <td>${dojo.getFirstName()}</td>
						  <td>${dojo.getLastName()}</td>
						  <td>${dojo.getAge()}</td>
					  </tbody>
					  </c:forEach>
					</table>
				</div>
				
			</div>
	
	</body>
</html>