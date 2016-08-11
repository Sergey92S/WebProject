<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Welcome user</title>
</head>
<body>
	<h3>Welcome, user</h3>
	<hr />
	${user}, hello!
	<hr />
	<form name="creditcardForm" method="POST" action="creditcard">
		<input type="hidden" name="command" value="creditcard" /> If you have
		not have a credit card you can create it by filling this fields and
		clicking the button below <br /> <br />
		<table>
			<tr>
				<td>Name(visa):</td>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<td>Security Code(1111):</td>
				<td><input type="text" name="securitycode" value="" /></td>
			</tr>
			<tr>
				<td>Count(10000):</td>
				<td><input type="text" name="count" value="" /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="Create a Credit Card" />
	</form>
	<br />
	<hr />
	<form name="addingForm" method="POST" action="adding">
		<input type="hidden" name="command" value="adding" /> If you have a
		credit card you can add your account by filling this fields and
		clicking the button below <br /> <br />
		<table>
			<tr>
				<th>Name</th>
				<th>Security Code</th>
				<th>Count</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${result}" var="accounts">
				<tr>
					<td><c:out value="${accounts.getName()}" /></td>
					<td><c:out value="${accounts.getSecuritycode()}" /></td>
					<td><c:out value="${accounts.getCount()}" /></td>
					<td><c:out value="${accounts.getStatus()}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<td>Security Code:</td>
				<td><input type="text" name="securitycode" value="" /></td>
			</tr>
			<tr>
				<td>Sum:</td>
				<td><input type="text" name="sum" value="" /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="Adding your account" />
	</form>
	<br />
	<hr />
	<br /> ${errorCheckAccountPassMessage}
	<br /> ${errorSecurityCodePassMessage}
	<br /> ${errorCreditCardPassMessage}
	<br /> Links for user...
	<br /> Debug info - session = ${sessionScope}
	<a
		href="FrontController?action=logout&command=logout&option=logout&user=${user}&userType=${userType}">Logout</a>
</body>
</html>