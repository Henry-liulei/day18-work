<%@ page import="cn.mdl.Pojo.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
        List<User> users = (List<User>) request.getAttribute("omg");
        %>
      <table border=\"1\" cellspacing=\"0\" cellpadding=\"8\">
        <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>性别</th>
        <th>爱好</th>
        <th>学历</th>
        <th>住址</th>
        <th>操作</th>
        </tr>

    <c:forEach items="${list}" var="user">
          <tr>
         <td>${user.id}</td>
          <td>${user.userName}</td>
          <td>${user.sex}</td>
          <td>${user.chk}</td>
          <td>${user.sel}</td>
          <td>${user.address}</td>
              <td><a href="#">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/del?id=${user.id}">删除</a></td>
          </tr>
    </c:forEach>
</table>
  </body>
</html>
