<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Here</title>
<c:if test="${not empty error}">
	<div class="error">${error}</div>
</c:if>
<script type="text/javascript">
	function validateRegister() {

		var x1 = document.getElementById('password').value;
		var x2 = document.getElementById('password_confirm').value;
		var msg=document.getElementById('errorMsg');
		if (x1 != x2) {

			msg.innerHTML="Password and Confirm Password do not match";
/* 			alert("Password and Confirm Password do not match"); */
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<h3>Register Here!!</h3>
	<div>
		<form name="register" onsubmit='return validateRegister()'
			action="${pageContext.request.contextPath}/user/register"
			method="POST">
			Enter Username<input type="text" id="username" name="username">
			<br /> <br /> Enter Password<input type="password" id="password"
				name="password"> <br /> <br /> Re enter Password<input
				type="password" id="password_confirm" name="password_confirm">
				<label id="errorMsg"></label>
			<br /> <br /> <input type="submit" name="submit"> <br />
			
		</form>
	</div>
</body>
</html>