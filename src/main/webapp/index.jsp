<%--
  Created by IntelliJ IDEA.
  User: pu
  Date: 2015/11/1 0001
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:forward page="${pageContext.request.contextPath}/servlet/controller">
    <jsp:param name="op" value="showAllCustomers"></jsp:param>
</jsp:forward>
</body>
</html>
