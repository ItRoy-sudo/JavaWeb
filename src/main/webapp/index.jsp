<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
    <head>
        <title>登录</title>
    </head>
    <body>
    <h2>This is index.jsp!</h2>

        <%--${pageContext.request.contextPath}代表当前的项目--%>
        <form action="${pageContext.request.contextPath}/login" method="get">
            用户名：<input type="text" name="username"><br>
            密码：<input type="password" name="password"><br>
            爱好：
            <input type="checkbox" name="hobbies" value="看番">看番
            <input type="checkbox" name="hobbies" value="跑步">跑步
            <input type="checkbox" name="hobbies" value="写代码">写代码
            <br>
            <input type="submit">
        </form>
    </body>
</html>
