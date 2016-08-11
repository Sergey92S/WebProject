<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding</title>
</head>
<body>
	<br />Your adding operation is success!!!
	<br />
	<hr />
	${user}, Now you have more money on your account!
	<hr />
	Links for user...
	<br /> Debug info - session = ${sessionScope}
	<a
		href="FrontController?command=logout&option=userReturn&user=${user}&userType=${userType}&result=${result}">Return
		to Main Page</a>
</body>
</html>