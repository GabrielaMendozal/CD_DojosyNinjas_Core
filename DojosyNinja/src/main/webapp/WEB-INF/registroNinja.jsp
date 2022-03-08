<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Ninja</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	</head>
	<body>
		<h1>
			New Ninja
		</h1>
		<form:form method="POST" action="/ninja/registrado" modelAttribute= "ninja">
			<div class= "mb-3">
				<form:label  path= "dojo" for="dojo">
					Dojo:
				</form:label>
				<form:select path="dojo" name="dojo" id="dojo">
					<c:forEach var="dojo" items="${listaDojos}">
						<form:option value="${dojo.id}">${dojo.name}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="dojo" />
			</div>
			<div class= "mb-3">
				<form:label  path= "firstName" for="firstName">
					First Name:
				</form:label>
				<form:input path="firstName" type="text" name="firstName" id="firstName" />
				<form:errors path="firstName" />
			</div>
			<div class= "mb-3">
				<form:label  path= "lastName" for="lastName">
					Last Name:
				</form:label>
				<form:input path="lastName" type="text" name="lastName" id="lastName" />
				<form:errors path="lastName" />
			</div>
			<div class= "mb-3">
				<form:label  path= "age" for="age">
					Age:
				</form:label>
				<form:input path="age" type="number" name="age" id="age" />
				<form:errors path="age" />
			</div>
			<button type="submit" class="btn btn-primary">
				Create
			</button>
		</form:form>