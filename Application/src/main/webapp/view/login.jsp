<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset = UTF-8" %>
<html>
<head>
    <title>My Web App</title>
</head>

<body>
<h3>${logged_name}</h3>
<h3>${Warning}</h3>
<form:form action="/login" method="post">
    <br/>
    User Name: <input type="text" name="userName"/>
    <br/><br/>
    Password: <input type="password" name="password"/>
    <br/><br/>
    <input type="submit" value="Login"/>
</form:form>
<h4>${a}</h4>
<h4>${b}</h4>
</body>
</html>