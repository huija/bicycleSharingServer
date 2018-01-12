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
    <title>修改管理员通知</title>
    <!--静态包含,只输出合并后的jsp,动态包含还要运行下被包含jsp-->
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
                                <div class="widget-title am-fl">更改管理员通知</div>
                                <div class="widget-function am-fr">
                                </div>
                            </div>
                            <div class="widget-body am-fr">
                                <form class="am-form tpl-form-line-form" action="${pageContext.request.contextPath}/admin-admin-editadminmessage-execute" method="post">
                                    <input type="hidden" name="adminMessageId" value="${requestScope.adminMessage.adminMessageId }"/>
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">标题 <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" max="20" class="tpl-form-input" id="user-name" placeholder="请输入标题文字" name="title" value="${requestScope.adminMessage.adminMessageTitle}">
                                            <small>请填写标题文字20字以内。</small>
                                        </div>
                                    </div>
                                    <div class="am-form-group">
                                        <label for="user-intro" class="am-u-sm-3 am-form-label">文章内容</label>
                                        <div class="am-u-sm-9">
                                            <textarea class="" rows="10" id="user-intro" placeholder="请输入文章内容" name="content">${requestScope.adminMessage.adminMessageContent}</textarea>
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
