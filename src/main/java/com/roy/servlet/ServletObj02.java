package com.roy.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Roy
 * @Date: 2021/8/3 11:32 上午
 * @Description: Servlet对象2，理解ServletContext的共享数据
 */
public class ServletObj02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        ServletContext servletContext = this.getServletContext();
        String username = (String) servletContext.getAttribute("username");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Servlet对象2从ServletContext读取的username为"+username+"</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}