<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pu
  Date: 2015/11/2 0002
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户信息列表</title>
</head>
<body>
<h1>客户信息列表</h1>
    <table width="88%">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/addCustomers.jsp">添加</a>
                <a href="">删除</a>
            </td>
        </tr>
        <tr>
            <td>
                <c:if test="${empty co}">
                    没有客户信息
                </c:if>
                <c:if test="${!empty co}">
                    <table border="1" width="100%">
                        <tr>
                            <th>ID</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>生日</th>
                            <th>手机</th>
                            <th>邮箱</th>
                            <th>爱好</th>
                            <th>类型</th>
                            <th>描述</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${co}" var="c">
                            <tr>
                                <td><input type="checkbox" name="ids" value="${c.id}"></td>
                                <td>${c.name}</td>
                                <td>${c.gender=='male'?"帅锅":"妹子"}</td>
                                <td>${c.birthday}</td>
                                <td>${c.cellphone}</td>
                                <td>${c.email}></td>
                                <td>${c.hobby}</td>
                                <td>${c.type}</td>
                                <td>${c.description}</td>
                                <td>
                                    <a href="">修改</a>
                                    <a href="">删除</a>
                                </td>
                            </tr>

                        </c:forEach>
                    </table>
                </c:if>
            </td>
        </tr>
    </table>
</body>
</html>
