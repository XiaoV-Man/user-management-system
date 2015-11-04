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

<form action="${pageContext.request.contextPath}/servlet/controller?op=delMulti" method="post">
    <table width="88%">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/addCustomers.jsp">添加</a>
                <a href="javascript:delMulti()">删除</a>
            </td>
        </tr>
        <tr>
            <td>
                <c:if test="${empty page.records}">
                    没有客户信息
                </c:if>
                <c:if test="${!empty page.records}">
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
                        <c:forEach items="${page.records}" var="c">
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
                                    <a href="${pageContext.request.contextPath}/servlet/controller?op=editUI&id=${c.id}">修改</a>
                                    <a href="javascript:delone(${c.id})">删除</a>
                                </td>
                            </tr>

                        </c:forEach>
                    </table>
                    第${page.currentPageNum}页/共${page.totalPages}页
                    <a href="${pageContext.request.contextPath}/servlet/controller?op=showAllCustomers&num=1">首页</a>
                    <a href="${pageContext.request.contextPath}/servlet/controller?op=showAllCustomers&num=${page.prePageNum}">上一页</a>
                    <a href="${pageContext.request.contextPath}/servlet/controller?op=showAllCustomers&num=${page.nextPageNum}">下一页</a>
                    <a href="${pageContext.request.contextPath}/servlet/controller?op=showAllCustomers&num=${page.totalPages}">尾页</a>
                </c:if>
            </td>
        </tr>
    </table>
</form>
</body>
<script type="text/javascript">
    function delone(customerId) {
        var flag = window.confirm("确定删除吗?")
        if (flag) {
            window.location.href = "${pageContext.request.contextPath}/servlet/controller?op=delOne&id=" + customerId;
        }
    }
    function delMulti() {
        var selected = false;
        var idsObj = document.getElementsByName("ids")
        for (var i = 0; i < idsObj.length; i++) {
            if (idsObj[i].checked) {
                selected = true;
                break;
            }
        }
        if (!selected) {
            alert("请选择要删除的记录");
            return;
        } else {
            var flag = window.confirm("确定删除吗?");
            if (flag) {
                document.forms[0].submit();
            }
        }
    }
</script>
</html>
