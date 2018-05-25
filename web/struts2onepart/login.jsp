<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/25
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆页面</title>
</head>
<body>
<s:form action="loginAction" method="POST">
    <s:textfield name="userName" label="用户名" requiredPosition="left" />
    <s:password name="password" label="密码"  requiredPosition="left"/>
    <s:submit value="登陆" key="submit"/>
</s:form>
</body>
</html>
