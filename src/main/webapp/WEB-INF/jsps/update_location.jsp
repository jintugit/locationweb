<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location | update</title>
</head>
<body>
	<h2>Location | Update location</h2>
	<form action="updateData" method="post">
		<pre>
				Id<input type="text" name="id" value="${location.id }">
				Name<input type="text" name="name" value="${location.name }">
				Code<input type="text" name="codes" value="${location.codes }">
				Type:
				urban<input type="radio" value="urban" name="type"/>
				rural<input type="radio" value="rural" name="type"/>
				<input type="submit" value="update">			
		</pre>
	</form>
	${msg }
</body>
</html>