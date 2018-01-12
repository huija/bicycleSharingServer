<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2017/7/26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>WOFI单车后台管理</title>
    <%@include file="../common/head.jsp" %>
    <!--地图引入-->
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script src="http://cache.amap.com/lbs/static/es5.min.js"></script>
    <script src="http://webapi.amap.com/maps?v=1.3&key=a5e29f343721cf6a5c29a9ea1ceaf709"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
    <!---->
</head>

<body data-type="index">
<div class="am-g tpl-g">
    <!-- 加载顶部导航栏 -->
    <jsp:include page="../common/header.jsp"/>
    <!-- 加载侧边导航栏 -->
    <jsp:include page="../common/list.jsp"/>

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span>
                        "WOFI单车"控制台主页
                    </div>
                </div>
            </div>
        </div>
        <div class="row-content am-cf">
            <div class="row  am-cf">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">实时数据信息</div>
                            <div class="widget-function am-fr">
                            </div>
                        </div>
                        <div class="widget-body am-fr">
                            <div class="am-fl">
                                <div class="widget-fluctuation-description-amount text-success" am-cf
                                     style="font-size: 14px;">
                                    今日用户充值金额: ${requestScope.rechargeCount} |今日已消费金额: ${requestScope.borrowCost }
                                    <br>
                                    当前使用中车辆: ${requestScope.bicycleCountUsing }
                                    <br>
                                    绿色车辆数: ${requestScope.bicycleCountGreen}|红色车辆数: ${requestScope.bicycleCountRed}
                                    <!-- <button class="widget-fluctuation-tpl-btn"><i class="am-icon-calendar"></i>更多记录</button> -->
                                </div>
                            </div>
                            <div class="am-fr am-cf">
                                <div class="widget-fluctuation-description-amount text-success" am-cf
                                     style="font-size: 18px;">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                    <div class="widget widget-primary am-cf">
                        <div class="widget-statistic-header">
                            当前总用户量
                        </div>
                        <div class="widget-statistic-body">
                            <div class="widget-statistic-value">
                                ${requestScope.userCount }
                            </div>
                        </div>
                        <div class="widget-statistic-description">
                            <a href="${pageContext.request.contextPath }/admin-user-list-show?page=1"
                               style="color:#9cdcf2;">点击查看用户列表与更多用户相关操作</a>
                        </div>
                        <span class="widget-statistic-icon am-icon-user"></span>
                    </div>
                </div>
                <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                    <div class="widget widget-purple am-cf">
                        <div class="widget-statistic-header">
                            当前单车总量
                        </div>
                        <div class="widget-statistic-body">
                            <div class="widget-statistic-value">
                                ${requestScope.bicycleCount }
                            </div>
                            <div class="widget-statistic-description">
                                <a href="${pageContext.request.contextPath }/admin-bicycle-list-show?page=1"
                                   style="color:#ded5e7;">点击查看单车列表与详细单车信息</a>
                            </div>
                            <span class="widget-statistic-icon am-icon-bicycle"></span>
                        </div>
                    </div>
                </div>
            </div>
            <!--车辆地图-->
            <%--      <li class="sidebar-nav-link">
                      <a href="javascript:;" class="sidebar-nav-sub-title">
                          <i class="am-icon-map sidebar-nav-link-logo"></i> 地图查看
                          <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                      </a>
                      <ul class="sidebar-nav sidebar-nav-sub">--%>
            <div class="row am-cf">
                <div class="am-u-sm-12 am-u-md-12">
                    <div class="widget am-cf">
                        <div id="container" style="width: auto;height: 500px;">
                            <script language="JavaScript" src="assets/js/map.js"></script>
                        </div>
                    </div>
                </div>
            </div>
            <%--   </ul>
           </li>--%>
        </div>
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-8 widget-margin-bottom-lg">
            <div class="widget am-cf widget-body-lg">
                <div class="widget-body  am-fr">
                    <div class="am-scrollable-horizontal ">
                        <table width="100%"
                               class="am-table am-table-compact am-text-nowrap tpl-table-black " id="">
                            <thead>
                            <tr>
                                <th>管理员通知</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.adminMessages }" end="5" var="adminMessage">
                                <tr class="gradeX">
                                    <td>${adminMessage.adminMessageTitle}</td>
                                    <td>
                                        <div class="tpl-table-black-operation">
                                            <a href="${pageContext.request.contextPath }/admin-index-message-show/${adminMessage.adminMessageId }">
                                                <i class="am-icon-list-alt"></i> 查看
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="row am-cf">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4 widget-margin-bottom-lg ">
                <div class="tpl-user-card am-text-center widget-body-lg">
                    <div class="tpl-user-card-title" style="font-size: 20px;">
                        员工证
                    </div>
                    <img class="achievement-image" src="${pageContext.request.contextPath }/adminPhoto/admin2.png"
                         alt="" width=80 height=80>
                    <div class="achievement-subheading">
                        <p style="font-size:18px; font-weight: bold;">${sessionScope.admin.adminName }</p>
                    </div>
                    <div class="achievement-description" style="text-align: left; margin-left: 20px;">
                        <p style="font-size:16px">管理员编号：${sessionScope.admin.adminId }</p>
                        <p style="font-size: 16px">联系邮箱：${sessionScope.admin.adminEmail }</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="${pageContext.request.contextPath }/assets/js/theme.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/app.js"></script>
</body>

</html>