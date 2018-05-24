<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/24
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--使用s:标签时注意导包,<%@ taglib prefix="s" uri="/struts-tags" %>--%>
<h2>用户注册</h2>
<s:form action="greeting" method="POST">
    <s:textfield name="name" label="用户名"/>
    <s:password name="user.password" label="密码"/>
    <%--value++默认选项,list++可选择列表--%>
    <s:radio name="user.sex" list="#{1:'男',0:'女'}" label="性别" value="0"/>
    <s:submit value="注册"/>

</s:form>

</body>
</html>
