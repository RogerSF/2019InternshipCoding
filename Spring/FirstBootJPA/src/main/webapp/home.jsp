<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addAlien"> <!-- redirect to /addAlien?aid=XX&aname=XXX -->
	<input type="text" name="aid"><br>
	<input type="text" name="aname"><br>
	<input type="text" name="tech"><br>
	<input type="submit"><br>
</form>

<form action="getAlien">
	<input type="text" name="aid"><br>
	<input type="submit"><br>
</form>

</body>
</html>