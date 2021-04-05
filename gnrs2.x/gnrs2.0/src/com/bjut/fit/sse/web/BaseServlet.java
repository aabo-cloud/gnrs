package com.bjut.fit.sse.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {

    private static final long serialVersionUID = 8770940769827131801L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            // 获取action相应的业务方法
            Method method = getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 调用action相应的业务方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
