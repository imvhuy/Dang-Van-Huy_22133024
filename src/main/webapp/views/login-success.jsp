<%@page import="com.javaweb.controllers.WaitingController"%>
<%@page import="com.javaweb.models.UserModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Success</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
        text-align: center;
    }
    .container {
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        background: #fff;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    h1 {
        color: #333;
    }
    p {
        font-size: 1.2em;
        color: #555;
    }
</style>
</head>
<body>
  <div class="container">
      <h1>Login Success</h1>
      <p>You are successfully logged in!</p>
      <%
          UserModel account = (UserModel) request.getAttribute("account");
          out.print("<p>Welcome, " + account.getFullName() + "</p>");
      %>
  </div>
  		<c:otherwise>
			<div class="col-sm-6">
				<ul class="list-inline right-topbar pull-right">
				 <li>
                        <button class="button" onclick="window.location.href='${pageContext.request.contextPath }/member/myaccount'">My account</button> |
                        <button method= "get" class="button" onclick="window.location.href='${pageContext.request.contextPath }/logout'">Logout</button>
                    </li>	 
				</ul>
			</div>
		</c:otherwise>
</body>
</html>
