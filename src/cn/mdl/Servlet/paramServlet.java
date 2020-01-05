package cn.mdl.Servlet;

import cn.mdl.Pojo.User;
import cn.mdl.Service.ServiceImpl.UserServiceImpl;
import cn.mdl.Service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@WebServlet(urlPatterns = "/param")
public class paramServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserService userService=new UserServiceImpl();
        Map<String,String[]> paramMap=request.getParameterMap();
        String birthday = request.getParameter("birthday");
        String[] chks = request.getParameterValues("chk");
        User user=new User();
        //时间转换器
        if (birthday!=null) {
            DateConverter dateConverter = new DateConverter();
            dateConverter.setPatterns(new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"});
            ConvertUtils.register(dateConverter, Date.class);
        }

        try {//map集合里的内容存到实体类种
            BeanUtils.populate(user,paramMap);
            user.setChk(Arrays.toString(chks));
            if (userService.findUser(user.getUserName())) {
                if (userService.addUser(user)) {
                    response.getWriter().print("<h1>恭喜注册成功！3秒后自动跳转到主页!</h1>");
                    response.setHeader("refresh", "3;url="+request.getContextPath()+"/Login.jsp");
                }
            else{
                response.sendRedirect(request.getContextPath()+"/info2.html");
            }
            }
            else{
                response.getWriter().write(" <script>");
                response.getWriter().write(" alert(\"用户名已被注册！！\");");
                response.getWriter().write(" </script>");
               response.getWriter().write("<a href='"+request.getContextPath()+"/register.jsp'>返回注册</a>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
