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
 * @Date: 2021/8/4 4:34 下午
 * @Description: 理解Session并往Session里存入信息
 */
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //获取请求的Session，如果没有在服务端有效的Session，则会创建一个存在于服务端的Session
        HttpSession session = req.getSession();
        //从Session里拿出Id
        String sessionId = session.getId();
        //如果客户端没有加入会话（即该有效的Session从未使用过一次），返回true；否则返回false
        if (session.isNew()){
            out.write("session创建成功，ID："+sessionId);
        }else{
            out.write("session已经在服务器中存在了，ID："+sessionId+"<br>");
            //往Session里存信息
            session.setAttribute("name","洛伊");
            out.write("SessionDemo1往session存入一个信息，name:洛伊");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
