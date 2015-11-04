<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: pu
  Date: 2015/11/2 0002
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<h1>修改用户信息</h1>
    <form action="${pageContext.request.contextPath}/servlet/controller?op=editCustomer" method="post">
        <input type="hidden" name="id" value="${c.id}">
        <table border="1">
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name" value="${c.name}"></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><input type="radio" name="gender" value="male" ${c.gender=="male"?"checked='checked'":""}>男
                    <input type="radio" name="gender" value="female" ${c.gender=="female"?"checked='checked'":""}>女
                </td>
            </tr>
            <tr>
                <td>生日:</td>
                <td><input type="text" name="birthday" value="${c.birthday}"></td>
            </tr>
            <tr>
                <td>手机:</td>
                <td><input type="text" name="cellphone" value="${c.cellphone}"></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input type="text" name="email" value="${c.email}"></td>
            </tr>
            <tr>
                <td>爱好:</td>
                <td><input type="checkbox" name="hobbies" value="吃饭" ${fn:contains(c.hobby,"吃饭")?"checked='checked'":""}>吃饭
                <input type="checkbox" name="hobbies" value="睡觉" ${fn:contains(c.hobby,"吃饭")?"checked='checked'":""}>睡觉
                <input type="checkbox" name="hobbies" value="打豆豆" ${fn:contains(c.hobby,"吃饭")?"checked='checked'":""}>打豆豆</td>
            </tr>
            <tr>
                <td>类型:</td>
                <td><input type="radio" name="type" value="傻逼" ${c.type=="傻逼"?"checked='checked'":""}>傻逼
                    <input type="radio" name="type" value="傻吊" ${c.type=="傻吊"?"checked='checked'":""}>傻吊
                </td>
            </tr>
            <tr>
                <td>描述:</td>
                <td><textarea rows="3" cols="38" name="description">${c.description}</textarea></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
