<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Welcome admin</title>
</head>
<body>
	<h3>Welcome, admin</h3>
	<hr />
	${user}, hello!
	<hr />
	<form name="unblockForm" method="POST" action="unblock">
		<input type="hidden" name="command" value="unblock" /> If you want to
		unblock somebody's account you can choose one of the following
		Security Codes: <br /> <br />
		<table>
			<tr>
				<th>Login</th>
				<th>Count</th>
				<th>Status</th>
				<th>Credit Card</th>
				<th>Security Code</th>
			</tr>
			<c:forEach items="${result}" var="accounts">
				<tr>
					<td><c:out value="${accounts.getLogin()}" /></td>
					<td><c:out value="${accounts.getCount()}" /></td>
					<td><c:out value="${accounts.getStatus()}" /></td>
					<td><c:out value="${accounts.getCreditcard()}" /></td>
					<td><c:out value="${accounts.getSecuritycode()}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br />Security Code(1111): <input type="text" name="securitycode"
			value="" /><br /> <br /> <input type="submit"
			value="Unblock the chosen account" />
	</form>
	<hr />
	<br /> ${errorAccountPassMessage}
	<br /> ${errorValidationPassMessage}
	<br /> Links for admin...
	<br /> Debug info - session = ${sessionScope}
	<a
		href="FrontController?command=logout&option=logout&user=${user}&userType=${userType}">Logout</a>
</body>
</html>