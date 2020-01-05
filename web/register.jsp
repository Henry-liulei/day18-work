<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/8
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script>
        function $(id) {
            return document.getElementById(id);
        }
        function check() {
            var ouserName = $("userName").value;
            var ouserPwd = $("userPwd").value;
            var oreUserPwd = $("reUserPwd").value;
            var oaddress = $("address").value;
            var obirthday = $("birthday").value;

            if (ouserName==''){
                alert("请输入用户名");
                return false;
            }
            if (ouserPwd==''){
                alert("请输入密码");
                return false;
            }
            if(ouserPwd!=oreUserPwd){
                alert("两次密码输入不一致");
                return  false
            }
            if (obirthday==''){
                alert("请输入生日日期");
                return false;
            }

            if (oaddress==''){
                alert("请输入家庭住址");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/param" method="post" onsubmit="return check()">
    <table border="1" cellspacing="0" cellpadding="8">
        <tr>
            <th colspan="2" scope="col">用户信息注册</th>
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
            <td>确认密码</td>
            <td><input name="reUserPwd" type="password" id="reUserPwd" /></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="sex" value="男" checked/> 男 <input
                    type="radio" name="sex" value="女" /> 女</td>
        </tr>
        <tr>
            <td>爱好</td>
            <td><input name="chk" type="checkbox" id="chk" value="书法" />
                书法 <input name="chk" type="checkbox" id="chk" value="舞蹈" /> 舞蹈 <input
                        name="chk" type="checkbox" id="chk" value="音乐" /> 音乐 <input
                        name="chk" type="checkbox" id="chk" value="绘画" /> 绘画 <input
                        name="chk" type="checkbox" id="chk" value="游泳" /> 游泳</td>
        </tr>
        <tr>
            <td>学历</td>
            <td><select name="sel" id="sel">
                <option value="-1" selected="selected">====请选择====</option>
                <option value="高中">高中</option>
                <option value="大专">大专</option>
                <option value="本科">本科</option>
            </select></td>
        </tr>
        <tr>
            <td>家庭住址</td>
            <td><textarea name="address" cols="50" rows="10" id="address"></textarea></td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="date" name="birthday" id="birthday" value=""></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" name="Submit" value="提交信息" /> <input
                    type="reset" name="Submit2" value="重置" /></td>
        </tr>
    </table>
</form>
</body>
</html>
