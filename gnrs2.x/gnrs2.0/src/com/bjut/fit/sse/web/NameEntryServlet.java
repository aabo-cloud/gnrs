package com.bjut.fit.sse.web;

import com.bjut.fit.sse.pojo.NameEntry;
import com.bjut.fit.sse.pojo.Page;
import com.bjut.fit.sse.service.NameEntryService;
import com.bjut.fit.sse.service.impl.NameEntryServiceImpl;
import com.bjut.fit.sse.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * 解析名字
 * 先找到目的网络附近连接的核心网络（路由器）
 * 下一步解析链路质量
 */


@WebServlet(value = "/manager/nameEntryServlet")
public class NameEntryServlet extends BaseServlet {

    private static final long serialVersionUID = 8495522608959220647L;

    private NameEntryService nameEntryService = new NameEntryServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数pageNo和pageSize
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        // 调用service.page
        Page<NameEntry> page = nameEntryService.page(pageNo, pageSize);
        // 设置首页的url地址
        page.setUrl("manager/nameEntryServlet?action=page");
        // 保存数据到request域对象中
        request.setAttribute("page", page);
        // 请求转发到web/pages/manager/xxx.jsp
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);

    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取请求参数
        // 2 调用
        List<NameEntry> nameEntries = nameEntryService.queryNameEntries();
        // 3 保存数据到Request域中
        request.setAttribute("nameEntries", nameEntries);
        // 4 请求转发/pages/manager/xxx.jsp 页面
        // 请求转发地址必须以斜杠打头 http://ip:port/工程路径/
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);

    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取请求参数
//        String readableName = request.getParameter("readableName");
//        String ip = request.getParameter("ip");

        NameEntry nameEntry = WebUtils.copyParamToBean(new NameEntry(), request.getParameterMap());

        // 保存到数据库
        nameEntryService.register(nameEntry);

        // 跳转到注册成功页面
        request.getRequestDispatcher("/pages/name_entry/register_success.jsp").forward(request, response);
        // 失败还应该有回显，但是现在还没想好
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取请求参数
//        String readableName = request.getParameter("readableName");
//        String ip = request.getParameter("ip");

        NameEntry nameEntry = WebUtils.copyParamToBean(new NameEntry(), request.getParameterMap());

        // 保存到数据库
        nameEntryService.register(nameEntry);

        // 跳转到注册成功页面

        response.sendRedirect(request.getContextPath() + "/manager/nameEntryServlet?action=list");

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1 获取请求参数
        String guid = request.getParameter("guid");
        // 2 调用service
        nameEntryService.deleteNameEntryByGuid(guid);
        // 3 重定向到列表页面
        response.sendRedirect(request.getContextPath() + "/manager/nameEntryServlet?action=list");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        NameEntry nameEntry = WebUtils.copyParamToBean(new NameEntry(request.getParameter("guid")), request.getParameterMap());
        NameEntry nameEntry = WebUtils.copyParamToBean(new NameEntry(), request.getParameterMap());
        nameEntryService.updateNameEntry(nameEntry);
        response.sendRedirect(request.getContextPath() + "/manager/nameEntryServlet?action=list");
    }

    protected void getNameEntry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guid = request.getParameter("guid");
        NameEntry nameEntry = nameEntryService.findNameEntryByGuid(guid);
        request.setAttribute("nameEntry", nameEntry);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

}
