<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>名字注册页面</title>

    <%--
        静态包含 base标签,js文件,css样式
    --%>
    <%@include file="/pages/common/header.jsp"%>

    <script type="text/javascript">
        $(function () {
            // 给注册按钮绑定单击事件
            $("#sub_btn").click(function () {
                // 验证可读名：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取可读名输入框里的内容
                var readableNameText = $("#readableName").val();
                //2 创建正则表达式对象==>>必须由字母，数字下划线组成，并且长度为5到12位
                // var readableNamePatt = /^\w{5,12}$/;
                // //3 调用test()验证是否匹配
                // if (!readableNamePatt.test(readableNameText)) {
                //     //4 提示验证结果
                //     $("span.errorMsg").text("可读名不合法!");
                //     return false;
                // }

                // 验证ip：必须由数字和.构成，且符合ip地址格式
                //1 获取ip输入框里的内容
                var ipText = $("#ip").val();
                //2 创建正则表达式对象
                var ipPatt = /^((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)$/;
                //3 调用test()验证是否匹配
                if (!ipPatt.test(ipText)) {
                    //4 提示验证结果
                    $("span.errorMsg").text("ip地址不合法!");
                    return false;
                }
                $("span.errorMsg").text("");
            });
        });
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册名字</h1>
                    <span class="errorMsg"></span>
                </div>
                <div class="form">
                    <form action="nameEntryServlet" method="post">
                        <input type="hidden" value="register" name="action" id="action" />
                        <label>可读名：</label>
                        <input class="itxt" type="text" placeholder="请输入可读名" autocomplete="off" tabindex="1"
                               name="readableName" id="readableName"/>
                        <br/>
                        <br/>
                        <label>ip地址：</label>
                        <input class="itxt" type="text" placeholder="请输入ip地址" autocomplete="off" tabindex="1"
                               name="ip" id="ip"/>
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/pages/common/footer.jsp"%>

</body>
</html>