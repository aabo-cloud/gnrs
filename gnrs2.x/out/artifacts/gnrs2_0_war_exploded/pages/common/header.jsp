<%--
  Created by IntelliJ IDEA.
  User: ABBY&SOUL
  Date: 2021/2/22
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
//    request.getSchema()可以返回当前页面使用的协议，http 或是 https;
//    request.getContextPath()，得到工程名，前面有/
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
    pageContext.setAttribute("basePath", basePath);
%>

<%--
    设置base标签
--%>
<base href="${basePath}">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<link type="text/css" rel="stylesheet" href="static/css/style.css">
