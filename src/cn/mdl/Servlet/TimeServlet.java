package cn.mdl.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/time")
public class TimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String format = sdf.format(new Date());
        Cookie cookie=new Cookie("lastTime",format);
        cookie.setMaxAge(30*60);
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);

        //获取Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies==null){
            response.getWriter().write("欢迎vip玩家第一次登录！！！");
        }
        for (Cookie cookie1 : cookies) {
            if (cookie1.getName().equals("lastTime")){
                response.getWriter().write("您上一次登录的时间是："+cookie.getValue());
            }
        }

    }
}
