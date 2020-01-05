<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/6
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (session.getAttribute("name")!=null){
%>
<h1>首页</h1>
<h3>欢迎尊贵的VIP用户：【<%= session.getAttribute("name")%>】</h3>
<a href="<%= request.getContextPath()%>/out">切换用户</a>
<%} else{%>
<h3>您还没有登录，请先登录后再访问，<a href="Login.jsp">返回登录</a>></h3>>
<%}%>
</body>
</html>
