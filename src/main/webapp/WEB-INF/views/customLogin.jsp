<%--
  Created by IntelliJ IDEA.
  User: SH
  Date: 2022-05-16
  Time: 오전 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>커스텀 로그인 페이지</h1>
<form action="/login" method="post">
    <input name ="username">
    <input name ="password">
    <input type="checkbox" name="remember-me">로그인 기억하기
    <button>login</button>
</form>
</body>
</html>
