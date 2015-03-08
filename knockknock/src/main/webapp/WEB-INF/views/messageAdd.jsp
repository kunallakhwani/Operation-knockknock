<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add message</title>
</head>
<body>
<h1>Post Message!</h1>
<form name="create-message" action="${pageContext.request.contextPath}/message/add" method="POST">
<input type="text" name="title"><br/><br/>
<textarea name="message" rows="5" cols="50"></textarea><br/><br/>

<input type="submit" name="submit">
</form>
</body>
</html>