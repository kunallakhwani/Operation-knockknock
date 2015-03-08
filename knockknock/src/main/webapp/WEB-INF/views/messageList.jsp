<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message List</title>
</head>
<body>
	<h3>List of messages</h3>
	<c:forEach var="msg" items="${messages}">
		<div class="message">
			Title: <c:out value="${msg.title}"></c:out><br/>
			Message: <c:out value="${msg.message}"></c:out><br/>
		</div>
	</c:forEach>
</body>
</html>