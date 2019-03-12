<%--
  Created by IntelliJ IDEA.
  User: LaZY
  Date: 2019/3/5
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--没有的话无法输出信息--%>
<%@ page session="true" %>>
<html>
<head>
    <title>home</title>
</head>
<body>
<c:if test="${sessionScope.name == null}">    <%--不要有空格--%>
    <c:out value="${requestScope.error}"/><br>
</c:if>
<c:if test="${sessionScope.name != null}">
    欢迎：<c:out value="${sessionScope.name}"/><br>
</c:if>
<a href="<c:url value='/toLogin'/>">登录</a><br>
<a href="<c:url value='/pageReg'/>">注册用户</a>
</body>
</html>
