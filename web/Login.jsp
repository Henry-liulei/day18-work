<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/5
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        img{
            cursor: pointer;
        }
    </style>
    <script>
        function $(id) {
            return document.getElementById(id);
        }
        function check() {
            var userName = $("userName").value;
            var userPwd=$("userPwd").value;
            if (userName==''){
                alert("用户名不能为空！！");
                return false;
            }
            if (userPwd==''){
                alert("密码不能为空！！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<%= session.getAttribute("ispass")%>
<form action="${pageContext.request.contextPath}/login" method="post" onsubmit="return check()">
    <table border="1" cellspacing="0" cellpadding="8">
        <tr>
            <th colspan="2" scope="col">用户登录</th>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input name="userName" type="text" id="userName" /></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input name="userPwd" type="password" id="userPwd" /></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="Code"><img src="${pageContext.request.contextPath}/checkcode" onclick="dianji()" id="imgs" alt="找不到图片？" title="点击获取下一张？"></td>
        </tr>
        <td><input type="submit" name="Submit" value="登录" />
        </td>
    </table>
    <p>亲、还没注册？<a href="register.html">立即注册</a></p>
</form>
</body>
<script>
    function dianji() {
        var imgs=document.getElementById("imgs");
        var time=new Date();
        var times=time.getTime();
        imgs.src="/day18_work/checkcode?dateTime="+times;
    }
</script>
</html>
