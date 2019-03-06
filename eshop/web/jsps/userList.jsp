<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>userList.jsp</title>
</head>
<body>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>password</td>
        <td>nickName</td>
        <td>email</td>
        <td>regDate</td>
    </tr>
    <c:forEach items="${allUsers}" var="u">
        <tr>
            <td><c:out value="${u.id}" /></td>
            <td><c:out value="${u.name}" /></td>
            <td><c:out value="${u.password}" /></td>
            <td><c:out value="${u.nickName}" /></td>
            <td><c:out value="${u.email}" /></td>
            <td><c:out value="${u.regDate}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>