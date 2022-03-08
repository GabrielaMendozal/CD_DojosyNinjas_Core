<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Dojo</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	</head>
	<body>
		<h1>
			New Dojo
		</h1>
		<form:form method="POST" action="/registrado" modelAttribute= "dojo">
			<div class= "mb-3">
				<form:label  path= "name" for="name">
					Name:
				</form:label>
				<form:input path="name" type="text" name="name" id="name" />
				<form:errors path="name" />
			</div>
			<button type="submit" class="btn btn-primary">
				Create
			</button>
		</form:form>
	</body>
</html>