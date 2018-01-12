<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2017/7/28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>单车列表</title>
    <%@include file="../common/head.jsp" %>
</head>

<body data-type="widgets">
<script src="assets/js/theme.js"></script>
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
                            <div class="widget-title  am-cf">单车列表</div>
                        </div>
                        <div class="widget-body  am-fr">
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                <div class="am-form-group">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="admin-bicycle-addbicycle-show" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                <div class="am-form-group tpl-table-list-select">
                                </div>
                            </div>
                            <!--按自行车状况搜索-->
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                <form action="${pageContext.request.contextPath }/admin-bicycle-searchbicycle-show" method="get">
                                    <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                        <input type="text" class="am-form-field" name="statement">
                                        <span class="am-input-group-btn">
            								<button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="submit"></button>
         								</span>
                                    </div>
                                </form>
                            </div>

                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black ">
                                    <thead>
                                    <tr>
                                        <th>单车编号</th>
                                        <th>位置经度</th>
                                        <th>位置纬度</th>
                                        <th>最终归还时间</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.pageBicycles}" var="bicycles">
                                        <tr class="gradeX">
                                            <td class="am-text-middle">${bicycles.bicycleId}</td>
                                            <td class="am-text-middle">${bicycles.bicycleCurrentX}</td>
                                            <td class="am-text-middle">${bicycles.bicycleCurrentY}</td>
                                            <td class="am-text-middle"><fmt:formatDate value="${bicycles.bicycleLastTime}" type="both"/></td>
                                            <td class="am-text-middle">${bicycles.bicycleStatement}</td>
                                            <td class="am-text-middle">
                                                <div class="tpl-table-black-operation">
                                                    <a href="${pageContext.request.contextPath }/admin-bicycle-editbicycle-show/${bicycles.bicycleId }">
                                                        <i class="am-icon-pencil"></i> 编辑
                                                    </a>
                                                    <a href="${pageContext.request.contextPath }/admin-bicycle-delete-execute/${bicycles.bicycleId }" class="tpl-table-black-operation-del">
                                                        <i class="am-icon-trash"></i> 删除
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    <!-- more data -->
                                    </tbody>
                                </table>
                            </div>
                            <c:if test="${requestScope.pagePoint != null}">
                                <div class="am-u-lg-12 am-cf" style="font-size:14px;">
                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                                            <li><a href="${pageContext.request.contextPath }/admin-bicycle-list-show?page=${requestScope.pagePoint - 1 }">«</a></li>
                                            <li><a>当前第${requestScope.pagePoint }页(共${requestScope.pageMax }页)</a></li>
                                            <li><a href="#!" id="skipBtn"> 跳转到&nbsp;<input type="text" name="pagePoint" style="width:20px;height: 14px; color:black; font-size: 10px;">&nbsp;页</a></li>
                                            <li><a href="${pageContext.request.contextPath }/admin-bicycle-list-show?page=${requestScope.pagePoint + 1 }">»</a></li>
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
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
<script type="text/javascript">

    $(function(){
        $("#skipBtn").on("click",function(){
            var page = $("#skipBtn>input").val();
            if(page == ""){
                page = 1;
            }
            window.location = "${pageContext.request.contextPath}/admin-bicycle-list-show?page=" + page;
        });
        $("#skipBtn > input").on("click", function() {
            return false;
        });
    })

</script>
</body>

</html>
