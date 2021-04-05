<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>名字管理</title>

	<%--
		静态包含 base标签,js文件,css样式
	--%>
	<%@include file="/pages/common/header.jsp"%>
	<script type="text/javascript">
		// 页面加载完成之后
		$(function () {
			// 给删除的a标签绑定单击事件
			$("a.deleteBook").click(function () {
				// 在事件响应的function函数中,有一个this对象.这个this对象 是当前正在响应事件的dom对象.
				var name = $(this).parent().parent().find("td:first").text();
				/**
				 * confirm()它是javaScript语言中提供的一个确认提示框,
				 * 参数就是确认提示框 的确认内容 <br/>
				 * 有两个按钮,一个确认,一个取消 <br/>
				 * 当用户点击确定返回true,点击取消返回false.<br/>
				 */
				return confirm("你确定要删除 [" + name + "] 吗?");
				// 可以阻止元素的默认行为
				// return false;
			});
		});
	</script>

</head>
<body>
	
	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif" >
		<span class="wel_word">名字管理系统</span>

		 <%--静态包含 manager模块的菜单 --%>
		<%@ include file="/pages/common/manager_menu.jsp"%>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>可读名</td>
				<td>guid</td>
				<td>ip</td>
				<td colspan="2">操作</td>
			</tr>
			<%--
				items 遍历的数据源
				var	当前遍历到的数据
			--%>
			<c:forEach items="${requestScope.page.items}" var="nameEntry">
				<tr>
					<td>${nameEntry.readableName}</td>
					<td>${nameEntry.guid}</td>
					<td>${nameEntry.ip}</td>
					<td><a href="manager/nameEntryServlet?action=getNameEntry&guid=${nameEntry.guid}&pageNo=${requestScope.page.pageNo}">修改</a></td>

					<td><a class="deleteBook"
							href="manager/nameEntryServlet?action=delete&guid=${nameEntry.guid}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>



			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加名字</a></td>
			</tr>
		</table>


		<%--静态包含分页条--%>
		<%@ include file="/pages/common/page_nav.jsp"%>

	</div>


	<%--
		静态包含页脚内容
	--%>
	<%@ include file="/pages/common/footer.jsp"%>


</body>
</html>