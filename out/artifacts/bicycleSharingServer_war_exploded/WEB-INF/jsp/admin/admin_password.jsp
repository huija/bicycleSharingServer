<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2017/7/26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>高级管理员验证</title>
    <%@include file="../common/head.jsp" %>
</head>

<body data-type="login">
    <script src="${pageContext.request.contextPath }/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <div class="tpl-login">
            <div class="tpl-login-content">
                <form autocomplete="off" class="am-form tpl-form-line-form" action="admin-admin-password-execute" method="post">
                    <div class="am-form-group">
                    	<p style="font-size:20px;color:#b5b5b5; text-align: center;">请输入高级管理员权限码</p>
                        <input type="password" class="tpl-form-input" name="password">
                    </div>
                   <br>
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