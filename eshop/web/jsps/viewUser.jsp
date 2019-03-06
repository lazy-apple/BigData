<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>viewUser.jsp</title>
</head>
<body>
<table border="1">
    <tr>
        <td>ID</td>
        <td><c:out value="${user.id}"/></td>
    </tr>
    <tr>
        <td>Name</td>
        <td><c:out value="${user.name}"/></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><c:out value="${user.password}"/></td>
    </tr>
    <tr>
        <td>Email</td>
        <td><c:out value="${user.email}"/></td>
    </tr>
    <tr>
        <td>NickName</td>
        <td><c:out value="${user.nickName}"/></td>
    <tr>
        <td>regDate</td>
        <td><c:out value="${user.regDate}"/></td>
    </tr>
</table>
</body>
</html>