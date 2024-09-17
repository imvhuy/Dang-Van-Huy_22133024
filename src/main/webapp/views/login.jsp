
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.container {
	background: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 300px;
	text-align: center;
}

h2 {
	margin-top: 0;
	color: #333;
}

form {
	display: flex;
	flex-direction: column;
	gap: 10px;
}

input[type="text"], input[type="password"] {
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 10px;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.alert {
	color: red;
	margin-bottom: 15px;
}

.remember-me {
	display: flex;
	align-items: center;
	gap: 5px;
}

.register-link {
	margin-top: 15px;
	font-size: 14px;
}

.register-link a {
	color: #007BFF;
	text-decoration: none;
}

.register-link a:hover {
	text-decoration: underline;
}
</style>
</head>
<%
String username = "";
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("username")) {
			username = cookie.getValue();
			break;
		}
	}
}
%>
<body>
	<div class="container">
		<c:if test="${not empty alert}">
			<p class="alert">${alert}</p>
		</c:if>
		<h2>Login</h2>
		<form action="login" method="post">
			Username: <input type="text" name="username" required value = "<%= username %>"><br>
			Password: <input type="password" name="password" required><br>
			<label>
            <input type="checkbox" name="rememberMe"> Remember Me
        </label><br>
			<input type="submit" value="Login">
		</form>
		<form>
			<div class="register-link">
				<p> Don't have an account? <a href="${pageContext.request.contextPath}/register">Register here </a></p>
				<p>Forgot Password? <a href="${pageContext.request.contextPath}/forgot-password">Click here</a></p>
			</div>
		</form>
	</div>
</body>
</html>
