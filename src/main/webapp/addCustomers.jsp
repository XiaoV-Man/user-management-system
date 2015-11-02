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
    <title>添加用户信息</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/servlet/controller?op=addCustomers" method="post">
        <table border="1">
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><input type="radio" name="gender" value="male">男
                    <input type="radio" name="gender" value="female">女
                </td>
            </tr>
            <tr>
                <td>生日:</td>
                <td><input type="text" name="birthday"></td>
            </tr>
            <tr>
                <td>手机:</td>
                <td><input type="text" name="cellphone"></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>爱好:</td>
                <td><input type="checkbox" name="hobbies" value="吃饭">吃饭
                <input type="checkbox" name="hobbies" value="睡觉">睡觉
                <input type="checkbox" name="hobbies" value="打豆豆">打豆豆</td>
            </tr>
            <tr>
                <td>类型:</td>
                <td><input type="radio" name="type" value="傻逼">傻逼
                    <input type="radio" name="type" value="傻吊">傻吊
                </td>
            </tr>
            <tr>
                <td>描述:</td>
                <td><textarea rows="3" cols="38" name="description"></textarea></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
