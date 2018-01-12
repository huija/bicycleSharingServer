<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2017/8/7
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../common/tag.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>用户反馈列表</title>
    <%@include file="../common/head.jsp" %>
</head>

<body data-type="widgets">
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
                            <div class="widget-title  am-cf">用户反馈列表</div>
                        </div>
                        <div class="widget-body  am-fr">
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                <div class="am-form-group tpl-table-list-select">
                                </div>
                            </div>
                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black ">
                                    <thead>
                                    <tr>
                                        <th>用户反馈标题</th>
                                        <th>用户反馈内容</th>
                                        <th>单车编号</th>
                                        <th>反馈时间</th>
                                        <th>反馈状态</th>
                                        <th>修改状态</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.pageUserFeedbacks }" var="userFeedbacks">
                                        <td class="am-text-middle">${userFeedbacks.feedbackTitle }</td>
                                        <td class="am-text-middle">${userFeedbacks.feedbackContent }</td>
                                        <td class="am-text-middle">${userFeedbacks.bicycleId }</td>
                                        <td class="am-text-middle">
                                            <fmt:formatDate value="${userFeedbacks.feedbackTime }" type="both"/>
                                        </td>
                                        <td class="am-text-middle">${userFeedbacks.feedbackStatement }</td>
                                        <td class="am-text-middle">
                                            <div class="tpl-table-black-operation">
                                                <a href="${pageContext.request.contextPath}/admin-userFeedback-resolved-execute/${userFeedbacks.feedbackId}">
                                                    <i class="am-icon-book"></i> 已读
                                                </a>
                                                <a href="admin-userFeedback-removeuser-execute/${userFeedbacks.feedbackId}"
                                                   class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <c:if test="${requestScope.pagePoint != null}">
                                <div class="am-u-lg-12 am-cf" style="font-size:14px;">
                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                                            <li><a href="${pageContext.request.contextPath }/admin-feedback-list-show?page=${requestScope.pagePoint - 1 }">«</a></li>
                                            <li><a>当前第${requestScope.pagePoint }页(共${requestScope.pageMax }页)</a></li>
                                            <li><a href="#!" id="skipBtn"> 跳转到&nbsp;<input type="text" name="pagePoint" style="width:20px;height: 14px; color:black; font-size: 10px;">&nbsp;页</a></li>
                                            <li><a href="${pageContext.request.contextPath }/admin-feedback-list-show?page=${requestScope.pagePoint + 1 }">»</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </c:if>
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
<script type="text/javascript">
    $("#skipBtn").on("click", function() {
        var point = $("#skipBtn input").val();
        if (point == "") {
            return false;
        }
        var url = "${pageContext.request.contextPath}/admin-feedback-list-show?page=" + point;
        window.location = url;
        return false;
    })
    $("#skipBtn input").on("click", function() {
        return false;
    })
</script>
</body>

</html>
