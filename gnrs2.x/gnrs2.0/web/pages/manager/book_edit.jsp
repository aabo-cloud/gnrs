<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑名字</title>

	<%--
		静态包含 base标签,js文件,css样式
	--%>
	<%@include file="/pages/common/header.jsp"%>


	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>

		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>

			<%-- 静态包含 manager模块的菜单 --%>
			<%@ include file="/pages/common/manager_menu.jsp"%>


		</div>
		
		<div id="main">
			<form action="manager/nameEntryServlet">
				<input type="hidden" name="action" value="${ empty param.guid ? "add" : "update" }">
				<%--<input type="hidden" name="guid" value="${ requestScope.nameEntry.guid }">--%>
				<table>
					<tr>
						<td>可读名</td>
						<td>guid</td>
						<td>ip</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="readableName" type="text" value="${requestScope.nameEntry.readableName}"/></td>
						<%--<td><input name="guid" type="text" value="${requestScope.nameEntry.guid}" disabled="disabled" /></td>--%>
						<td>
							<input name="guid" type="text" value="${requestScope.nameEntry.guid}" ${ empty param.guid ? "disabled=\"disabled\"" : "readonly=\"readonly\" unselectable=\"on\""}/>
						</td>
						<td><input name="ip" type="text" value="${requestScope.nameEntry.ip}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
		</div>


		<%--
            静态包含页脚内容
        --%>
		<%@ include file="/pages/common/footer.jsp"%>


</body>
</html>