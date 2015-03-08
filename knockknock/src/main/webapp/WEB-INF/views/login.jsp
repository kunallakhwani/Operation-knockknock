<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>
<body>
	<h3>Login</h3>
	<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="notify">${msg}</div>
		</c:if>
	<form name="login"
		action="${pageContext.request.contextPath}/j_spring_security_check"
		method="POST">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" id="j_username" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" id="j_password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>