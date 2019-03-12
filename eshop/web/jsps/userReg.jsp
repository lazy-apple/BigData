<%--
  Created by IntelliJ IDEA.
  User: LaZY
  Date: 2019/3/6
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<c:url value='/doReg'/>" method="post">
        用户名：    <input type="text" name="name"><br>
        密码：      <input type="password" name="password"><br>
        确认密码：  <input type="password" name="confirmPass"><c:out value="${requestScope['error.password.nosame']}"/><br>
        邮箱：      <input type="text" name="email"><c:out value="${requestScope['error.email.registed']}"/><br>
        昵称：      <input type="text" name="nickName"><br>
        <input type="submit" value="注册">
    </form>

</body>
</html>
