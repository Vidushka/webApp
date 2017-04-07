<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
<head>
    <title>My Web App</title>
</head>
<body>
<h1>Hello ${userName} !!!</h1>
<h3>${loginStatus}</h3>
<a href="/login">Login</a>
<a href="/logout">Logout</a>
</body>
</html>