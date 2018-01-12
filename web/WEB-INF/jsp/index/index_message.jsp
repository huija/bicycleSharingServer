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
    <title>管理员通知详情</title>
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
                                <div class="widget-title am-fl">查看管理员通知</div>
                                <div class="widget-function am-fr">
                                </div>
                            </div>
                            <div class="widget-body am-fr">
                                <form class="am-form tpl-form-line-form" action="${pageContext.request.contextPath}/admin-admin-editadminmessage-execute" method="post">
                                    <input type="hidden" name="adminMessageId" value="${requestScope.adminMessage.adminMessageId }"/>
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">标题</label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" value="${requestScope.adminMessage.adminMessageTitle}" disabled="disabled">
                                        </div>
                                    </div>
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">发布时间</label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input"  value='<fmt:formatDate value="${requestScope.adminMessage.adminMessageTime }"/>' disabled="disabled">
                                        </div>
                                    </div>
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">发布者编号 </label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input"  value="${adminMessage.adminId }" disabled="disabled">
                                        </div>
                                    </div>
                                    <div class="am-form-group">
                                        <label for="user-intro" class="am-u-sm-3 am-form-label">文章内容</label>
                                        <div class="am-u-sm-9">
                                            <textarea class="" rows="10"  disabled="disabled">${requestScope.adminMessage.adminMessageContent}</textarea>
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
