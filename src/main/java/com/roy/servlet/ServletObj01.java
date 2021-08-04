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
 * @Date: 2021/8/3 11:18 上午
 * @Description: Servlet对象1，理解ServletContext的共享数据
 */
public class ServletObj01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        ServletContext servletContext = this.getServletContext();
        String name = "洛伊";     //数据
        servletContext.setAttribute("username",name);   //将数据以键值对形式存入ServletContext中
        PrintWriter out = resp.getWriter();
        out.println("<h1>Servlet对象1往ServletContext写入的username为"+name+"</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
