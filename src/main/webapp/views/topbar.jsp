<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .right-topbar {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }
        .right-topbar li {
            display: inline;
            margin-left: 10px;
        }
        .button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
        }
        .button:hover {
            background-color: #0056b3;
        }
        .search-button {
            font-size: 20px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <c:choose>
        <c:when test="${sessionScope.account == null}">
            <div class="col-sm-6">
                <ul class="right-topbar pull-right">
                    <li>
                        <button class="button" onclick="window.location.href='${pageContext.request.contextPath }/login'">Đăng nhập</button> |
                        <button class="button" onclick="window.location.href='${pageContext.request.contextPath }/register'">Đăng ký</button>
                    </li>
                    <li><i class="search fa fa-search search-button"></i></li>
                </ul>
            </div>
        </c:when>
    </c:choose>
</body>
</html>
