package com.roy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Roy
 * @Date: 2021/8/3 4:41 下午
 * @Description: HttpServletResponse实现重定向
 */
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重定向需要指明完整路径，即localhost:8080后的路径

        //方式一：通过setHeader和setStatus直接编写响应头信息和状态码来实现
//        resp.setHeader("Location","/hello/servletObj3");
//        resp.setStatus(302);
        //方式二：通过sendRedirect实现
        resp.sendRedirect("/hello/servletObj3");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
