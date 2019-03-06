<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>editUser.jsp</title>
</head>
<body>
<form action="/admin/updateUser" method="post">
    <input type="hidden" name="id" value="<c:out value="${user.id}" />">
    Username :<input type="text" name="name" value="<c:out value="${user.name}" />"><br>
    Password :<input type="password" name="password" value="<c:out value="${user.password}" />"><c:out value="${requestScope['error.password.nosame']}"/><br>
    ConfirmPass :<input type="password" name="confirmPass"><br>
    Email :<input type="text" name="email" value="<c:out value="${user.email}" />"><c:out value="${requestScope['error.email.registed']}"/><br>
    NickName:<input type="text" name="nickName" value="<c:out value="${user.nickName}" />"><br>
    <input type="submit">
</form>
</body>
</html>