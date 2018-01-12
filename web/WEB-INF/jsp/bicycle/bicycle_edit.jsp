<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2017/7/28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>单车信息修改</title>
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
                            <div class="widget-title am-fl">修改单车</div>
                            <div class="widget-function am-fr">
                            </div>
                        </div>
                        <div class="widget-body am-fr">

                            <form autocomplete="off" class="am-form tpl-form-line-form" action="${pageContext.request.contextPath }/admin-bicycle-editbicycle-execute" method="post">
                                <input type="hidden" name="bicycleId" value="${requestScope.bicycle.bicycleId }">
                                <div class="am-form-group">
                                    <label for="bicycle-id" class="am-u-sm-3 am-form-label">单车编号</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" readonly="readonly" class="tpl-form-input" id="bicycle-id" placeholder="" name="id" value="${requestScope.bicycle.bicycleId}">
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="bicycle-x" class="am-u-sm-3 am-form-label">单车经度</label>
                                    <div class="am-u-sm-9">
                                        <input type="number" step="0.000001" max="180" min="0" class="tpl-form-input" id="bicycle-x" placeholder="" name="bicycleCurrentX" value="${requestScope.bicycle.bicycleCurrentX}">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="bicycle-y" class="am-u-sm-3 am-form-label">单车纬度</label>
                                    <div class="am-u-sm-9">
                                        <input type="number" step="0.000001" max="90" min="0" class="tpl-form-input" id="bicycle-y" placeholder="" name="bicycleCurrentY" value="${requestScope.bicycle.bicycleCurrentY}">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="bicycle-statement" class="am-u-sm-3 am-form-label">单车状态</label>
                                    <div class="am-u-sm-9">
                                        <input type="number" max="1" min="-1" class="tpl-form-input" id="bicycle-statement" placeholder="" name="bicycleStatement" value="${requestScope.bicycle.bicycleStatement }">
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

