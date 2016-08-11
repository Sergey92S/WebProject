<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h3>Welcome, user</h3>
	<br />Your registration is success!!!
	<br />
	<hr />
	${user}, Now you have user`s opportunities!
	<hr />
	Links for user...
	<br /> Debug info - session = ${sessionScope}
	<a
		href="FrontController?command=logout&option=logout&user=${user}&userType=${userType}&result=${result}">Logout</a>
</body>
</html>