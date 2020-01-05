package cn.mdl.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/a")
public class TestAServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String value="郭德纲";
        value = URLEncoder.encode(value,"utf-8");
        Cookie cookie=new Cookie("username",value);
        cookie.setMaxAge(30*60);
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);

        Cookie cookie1=new Cookie("upwd","sa123");
        cookie1.setMaxAge(30*60);
        cookie1.setPath(request.getContextPath());
        response.addCookie(cookie1);

        //获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookie!=null&&cookie1!=null){
            for (Cookie cookie2 : cookies) {
                if (cookie2!=null){
                    String decode = URLDecoder.decode(cookie2.getValue(),"utf-8");
                   response.getWriter().write(cookie2.getName()+":"+decode);
                    response.getWriter().write("<br>");

                }
            }
        }
    }
}
