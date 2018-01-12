<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2017/7/26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!--引入jstl-->
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>管理员注册</title>
    <%@include file="../common/head.jsp" %>
</head>

<body data-type="login">
    <script src="${pageContext.request.contextPath }/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <div class="tpl-login">
            <div class="tpl-login-content">
                <div class="tpl-login-title">注册管理员</div>
                <span class="tpl-login-content-info">
                  创建一个新的管理员
              </span>
				<form autocomplete="off" class="am-form tpl-form-line-form" action="admin-admin-register-execute" method="post">
                    <div class="am-form-group">
                        <input type="text" class="tpl-form-input" placeholder="管理员名" name="name">

                    </div>
                    <div class="am-form-group">
                        <input type="email" class="tpl-form-input" placeholder="邮箱" name="email">
                    </div>
                    <div class="am-form-group">
                        <input type="password" class="tpl-form-input" placeholder="请输入密码" name="password">
                    </div>
                    <div class="am-form-group">
                        <input type="password" class="tpl-form-input" placeholder="再次输入密码" name="password2">
                    </div>
                    <div class="am-form-group">
                        <button type="submit" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">提交</button>
                    </div>
                    <div class="am-form-group" style="text-align: center;">
						<a href="admin-index-index-show" style="color: #666; font-size: 14px;">返回控制台</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/app.js"></script>
</body>

</html>