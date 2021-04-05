<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/5
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page_nav">

    <%--http://localhost:8080/gnrs2.0/pages/manager/book_manager.jsp--%>
        <%--/gnrs2.0/pages/manager/book_manger.jsp--%>

    <%--
        不是第一页,才显示首页,上一页
    --%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${ requestScope.page.pageNo - 1 }">上一页</a>
    </c:if>

    <%--
        页码输出的开始
    --%>
    <c:choose>
        <c:when test="${ requestScope.page.pageTotal <= 5 }">
            <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${ i == requestScope.page.pageNo }">
                    [${i}]
                </c:if>
                <c:if test="${ i != requestScope.page.pageNo }">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <c:choose>
                <%--
                    第一种小情况是: 当前页码为前面3个, 1,2,3
                    页码的范围是 1 到 5 固定
                --%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:forEach begin="1" end="5" var="i">
                        <c:if test="${ i == requestScope.page.pageNo }">
                            [${i}]
                        </c:if>
                        <c:if test="${ i != requestScope.page.pageNo }">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <%--
                第二种小情况 : 当前页码为最后三个,8,9,10
                    页码的范围是 6 到 总页码
                --%>
                <c:when test="${ requestScope.page.pageNo >= requestScope.page.pageTotal - 2}">
                    <c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${ i == requestScope.page.pageNo }">
                            [${i}]
                        </c:if>
                        <c:if test="${ i != requestScope.page.pageNo }">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <%--
                第三种情况 : 中间的 4,5,6,7
                页码范围是 当前页码-2 到 当前页码+2
                --%>
                <c:otherwise>
                    <c:forEach begin="${requestScope.page.pageNo - 2}" end="${requestScope.page.pageNo + 2}" var="i">
                        <c:if test="${ i == requestScope.page.pageNo }">
                            [${i}]
                        </c:if>
                        <c:if test="${ i != requestScope.page.pageNo }">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
    <%--
        页码输出的结束
    --%>


    <%--
        不是最后一页,才显示,下一页,末页
    --%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${ requestScope.page.pageNo + 1 }">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageCount}条记录
    到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
    <input id="goToPage" type="button" value="确定">

    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            // 跳到指定页码单击事件
            $("#goToPage").click(function () {
                // 获取输入的页码
                var pageNo = $("#pn_input").val();

                if (pageNo >= 1 && pageNo <= ${requestScope.page.pageTotal}) {
                    // 在javaScript语言中,有一个location对象,它有属性href.
                    // href属性表示浏览器地址栏中的地址.这个属性可读可写
                    location.href = "${basePath}${requestScope.page.url}&pageNo=" + pageNo;
                } else {
                    alert("非法输入")
                }
            });
        });

    </script>

</div>