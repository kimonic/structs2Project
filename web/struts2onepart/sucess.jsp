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
    <%--set设置属性时,如果其值为字符串,则必须添加'',否则无法获取值--%>
    <%--https://www.cnblogs.com/firstdream/archive/2012/03/14/2395776.html--%>
    <s:set var="test" value="'哈哈哈哈哈'"  scope="request" />
    <s:property default="没有获取到值" value="#request.test"/><br>
    <%--<br>获取值${requestScope.test}<br>--%>

    <ul>
        <li>用户名:<s:property value="name"/> </li>
        <li>密码:<s:property value="password"/> </li>
        <li>性别:<s:if test="sex==0">女</s:if><s:else>男</s:else> </li>
        <li>省份:<s:property value="province"/> </li>
        <li>爱好:<s:property value="hobby"/> </li>
        <li>描述:<s:property value="description"/> </li>
    </ul>

</div>
<div>
    <h2>用户登陆返回结果</h2>
    <s:property value="userName"/>,登陆成功!<br>
</div>
</body>
</html>
