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
        <td>删除</td>
        <td>查看</td>
        <td>编辑</td>
    </tr>
    <c:forEach items="${allUsers}" var="u">
        <tr>
            <td><c:out value="${u.id}" /></td>
            <td><c:out value="${u.name}" /></td>
            <td><c:out value="${u.password}" /></td>
            <td><c:out value="${u.nickName}" /></td>
            <td><c:out value="${u.email}" /></td>
            <td><c:out value="${u.regDate}" /></td>

            <td><a href="<c:url value='/admin/delUser'/>?uid=<c:out value='${u.id}'/>">删除</a></td>
            <td><a href="<c:url value='/admin/viewUser'/>?uid=<c:out value='${u.id}'/>">查看</a></td>
            <td><a href="<c:url value='/admin/editUser'/>?uid=<c:out value='${u.id}'/>">编辑</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>