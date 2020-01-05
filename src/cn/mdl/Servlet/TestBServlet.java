package cn.mdl.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(urlPatterns = "/b")
public class TestBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies==null){
                response.getWriter().write("<h1>未找到Cookie</h1>");

        }
        for (Cookie cookie : cookies) {
            if (cookie!=null){
                String decode = URLDecoder.decode(cookie.getValue(),"utf-8");
                response.getWriter().write(cookie.getName()+":"+decode);
                response.getWriter().write("<br>");
            }
        }
    }
}
