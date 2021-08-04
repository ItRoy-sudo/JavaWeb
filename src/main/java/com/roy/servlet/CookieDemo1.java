package com.roy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInput;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @Author: Roy
 * @Date: 2021/8/4 2:35 下午
 * @Description: 理解Cookie
 */
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //获取请求的cookie数组
        Cookie[] cookies = req.getCookies();
        //检验网站cookie的标志位
        boolean cookieFlag = false;
        //判断该cookie是否存在，如果不存在则表示第一次（还包括cookie失效后）访问；否则为非第一次访问
        if(cookies!=null){
            //判断cookie是否正确
            for (Cookie c:cookies){
                if(c.getName().equals("lastLoginDateTime")){    //取出键为键为lastLoginDateTime的cookie
                    cookieFlag = true;
                    long lastLoginDateTime = Long.parseLong(c.getValue());
                    Date date = new Date(lastLoginDateTime);
                    out.write("你上次访问网站的时间："+date.toLocaleString());
                }
            }
            if(!cookieFlag){
                out.write("这是你第一次访问本站，将为你生成cookie！");
                //生成一个cookie，键为lastLoginDateTime（最近一次登录时间），值为一个字符串
                Cookie cookie = new Cookie("lastLoginDateTime", System.currentTimeMillis() + "");
                //如果需要生成一个中文的cookie，最好先进行一个编码转化
//                Cookie cookie1 = new Cookie("name", URLEncoder.encode("洛伊", "utf-8"));
                //删除cookie
//                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }else{  //因为网站默认会有已存在的一些cookie（比如打开浏览器会有的cookie之类）
            out.write("OMG！竟然一个cookie都没有");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
