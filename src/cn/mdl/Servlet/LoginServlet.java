package cn.mdl.Servlet;

import cn.mdl.Pojo.User;
import cn.mdl.Service.ServiceImpl.UserServiceImpl;
import cn.mdl.Service.UserService;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserService userService=new UserServiceImpl();
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String code = request.getParameter("Code");
        HttpSession session = request.getSession();
        String vsCode = (String) session.getAttribute("vsCode");
        if (vsCode.equalsIgnoreCase(code)){
        try {
            if (userService.selectLogin(userName,userPwd)){
                List<User> list = userService.findAll();
                request.setAttribute("list",list);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                //session.setAttribute("name",userName);
              // request.getRequestDispatcher("/home.jsp").forward(request,response);
            }else{
                session.setAttribute("ispass","用户名或密码错误");
               response.sendRedirect(request.getContextPath()+"/Login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    else {//验证吗不对
        session.setAttribute("ispass","验证码不正确");
            response.sendRedirect(request.getContextPath()+"/Login.jsp");
        }
    }
}
