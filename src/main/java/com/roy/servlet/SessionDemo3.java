package com.roy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Roy
 * @Date: 2021/8/4 6:51 下午
 * @Description: 如何删除存放在Session的信息
 */
public class SessionDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        //获取请求的Session，如果没有在服务端有效的Session，则会创建一个存在于服务端的Session
        HttpSession session = req.getSession();
        //删除Session里存放的指定信息
//        session.removeAttribute("name");
//        out.write("删除Session里的键为name的数据！");
        //注销服务端存放的Session
        session.invalidate();
        out.write("注销服务端存放的Session");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
