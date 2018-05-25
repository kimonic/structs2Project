<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/23
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%--index.jsp--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--Java学习路线：html-css-js-jq-javase-数据库-jsp-servlet-
  Struts2-hibernate-mybatis-spring4-springmvc-ssh-ssm--%>
  <a href="first.action">跳转struts2</a><br>
  <a href="UserAction!add">添加用户信息</a><br>
  <a href="UserAction!update">更新用户信息</a><br>
  <a href="testAction.action">map类型的request,session,application</a><br>
  <a href="OGNLAction.action">OGNL测试</a><br>
  <a href="sleepAction.action">拦截器测试</a><br>
  <a href="registerAction.action">用户注册测试</a><br>
  <a href="/struts2onepart/login.jsp">用户注册验证测试</a><br>
  <h2>用户注册</h2>
  <s:form action="registerAction" method="POST" >
      <s:textfield label="用户名" name="name" requiredPosition="left" required="true"/>
      <s:password name="password" label="密码" required="true" requiredPosition="left"/>
      <%--使用value=""设置s:radio的默认值,key值为字符串时主要要在""里面加''包裹key值--%>
      <%--https://blog.csdn.net/enjoyinwind/article/details/6407578--%>
      <s:radio list="#{1:'男',0:'女'}" label="性别"  value="0"
               name="sex" required="true" requiredPosition="lesft"/>
      <s:select list="{'请选择省份','吉林','广东','山东','河南'}" name="province" label="省份"/>
      <s:checkboxlist list="{'足球','羽毛球','乒乓球','篮球'}" name="hobby" label="爱好"/>
      <s:textarea name="description"  cols="30" rows="5" label="描述"/>
      <s:submit value="注册"/>
      <s:reset value="重置"/>
  </s:form>
  </body>
</html>
