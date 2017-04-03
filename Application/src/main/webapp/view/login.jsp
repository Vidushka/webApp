<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
<head>
    <title>My Web App</title>
</head>

<body>
<form:form action="/login" method="post">
    User Name: <input type="text" name="userName"/>
    <br/>
    Password: <input type="password" name="password"/>
    <br/>
    <input type="submit" value="Login"/>
</form:form>
</body>
</html>