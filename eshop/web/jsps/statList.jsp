<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>statList.jsp</title>
  </head>
  <body>
  <a href="<c:url value='/admin/statYesterday' />">昨天网站PV</a><br>
  <a href="<c:url value='/admin/stat/3day' />">最近三天网站PV</a><br>
  <a href="<c:url value='/admin/stat/week' />">近一周PV</a><br>
  <a href="<c:url value='/admin/stat/month' />">近一个月PV</a><br>
  </body>
</html>
