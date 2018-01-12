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
    <title>修改管理员信息</title>
    <%@include file="../common/head.jsp" %>
</head>

<body data-type="widgets">
    <script src="${pageContext.request.contextPath }/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
  		<!-- 加载顶部导航栏 -->
        <jsp:include page="../common/header.jsp"/>
        <!-- 加载侧边导航栏 -->
        <jsp:include page="../common/list.jsp"/>

       <!-- 内容区域 -->
        <div class="tpl-content-wrapper">
            <div class="row-content am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">修改管理员信息</div>
                                <div class="widget-function am-fr">
                                </div>
                            </div>
                            <div class="widget-body am-fr">
                                <form autocomplete="off" class="am-form tpl-form-line-form" action="${pageContext.request.contextPath }/admin-admin-editadmin-execute" method="post">
                                    <input type="hidden" name="id" value="${requestScope.admin.adminId }">
                                    <div class="am-form-group">
                                        <label class="am-u-sm-3 am-form-label">管理员名 </label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" name="name" value="${requestScope.admin.adminName }">
                                        </div>
                                    </div>
                                    <div class="am-form-group">
                                        <label class="am-u-sm-3 am-form-label">密码</label>
                                        <div class="am-u-sm-9">
                                            <input type="password" class="tpl-form-input" name="password" value="${requestScope.admin.adminPassword }">
                                        </div>
                                    </div>     
                                    <div class="am-form-group">
                                        <label class="am-u-sm-3 am-form-label">邮箱 </label>
                                        <div class="am-u-sm-9">
                                            <input type="email" class="tpl-form-input" name="email" value="${requestScope.admin.adminEmail }">
                                        </div>
                                    </div>
                                    <div class="am-form-group">
                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                            <button type="submit" class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/app.js"></script>
</body>

</html>
