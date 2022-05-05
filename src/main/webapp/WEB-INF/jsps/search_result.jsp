<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Locations</title>
</head>
<body>
	<h2>List of locations</h2>
	<table>
		<tr>
			<th>Id</th>
			<th>Codes</th>
			<th>Name</th>
			<th>Type</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach items="${locations }" var="location">
			<tr>
				<td>${location.id }</td>
				<td>${location.codes }</td>
				<td>${location.name }</td>
				<td>${location.type }</td>
				<td><a href="delete?id=${location.id }">delete</a></td>
				<td><a href="update?id=${location.id }">update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>