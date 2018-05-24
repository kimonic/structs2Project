<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/24
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<font color="red">
    <s:property value="name"/>,您好!<br>欢迎来到本站!
</font>

request范围内的变量值:<%=request.getAttribute("info")%><br><br>
session范围内的变量值:<%=session.getAttribute("info")%><br><br>
application范围内的变量值:<%=application.getAttribute("info")%><br><br>
<div>
    <h2>ognl操作普通属性</h2>
    属性name的值:<s:property value="name"/><br>
    学号:<s:property value="student.id"/><br>
    也可以使用---学号:<s:property value="student['id']"/><br>
    姓名:<s:property value="student.name"/><br>
    say()方法:<s:property value="student.say()"/><br>
    request中的info的值:<s:property value="#request['info']"/><br>


</div>
</body>
</html>
