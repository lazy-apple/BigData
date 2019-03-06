<%--
  Created by IntelliJ IDEA.
  User: LaZY
  Date: 2019/3/6
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/doLogin" method="post">
    用户名：<input type="text" name="name"><br>
    密码：  <input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
