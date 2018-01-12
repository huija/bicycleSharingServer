<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2017/7/31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>单车租借记录</title>
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
                                <div class="widget-title  am-cf">租借记录列表</div>
                            </div>
                            <div class="widget-body  am-fr">
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                    <div class="am-form-group"></div>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                    <div class="am-form-group tpl-table-list-select">
                                    </div>
                                </div>
                            <%--    <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                    <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                        <input type="text" class="am-form-field ">
                                        <span class="am-input-group-btn">
            								<button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>
          								</span>
                                    </div>
                                </div>--%>
                                <div class="am-u-sm-12">
                                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black ">
                                        <thead>
                                            <tr>
                                                <th>序号</th>
                                                <th>单车编号</th>
                                                <th>用户编号</th>
                                                <th>租借时间</th>
                                                <th>归还时间时间</th>
                                                <th>开始经度</th>
                                                <th>开始纬度</th>
                                                <th>结束经度</th>
                                                <th>结束纬度</th>
                                                <th>花费</th>
                                                <th>余额</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${requestScope.pageBorrows }" var="borrows">
                                            <tr class="gradeX">
                                                <td class="am-text-middle">${borrows.borrowId }</td>
                                                <td class="am-text-middle">${borrows.bicycleId }</td>
                                                <td class="am-text-middle">${borrows.userId}</td>
                                                <td class="am-text-middle">
                                                	<fmt:formatDate value="${borrows.borrowStartTime }" type="both"/>
                                                </td>
                                                <td class="am-text-middle">
                                                	<fmt:formatDate value="${borrows.borrowEndTime }" type="both"/>
                                                </td>
                                                <td class="am-text-middle">${borrows.borrowStartX}</td>
                                                <td class="am-text-middle">${borrows.borrowStartY}</td>
                                                <td class="am-text-middle">${borrows.borrowEndX}</td>
                                                <td class="am-text-middle">${borrows.borrowEndY}</td>
                                                <td class="am-text-middle">${borrows.cost}</td>
                                                <td class="am-text-middle">${borrows.remaining}</td>
                                                <td class="am-text-middle">
                                                    <div class="tpl-table-black-operation">
                                                        <a href="${pageContext.request.contextPath }/admin-borrow-delete-execute/${borrows.borrowId}" class="tpl-table-black-operation-del">
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
                                            <li><a href="${pageContext.request.contextPath }/admin-borrow-list-show?page=${requestScope.pagePoint - 1 }">«</a></li>
                                            <li><a>当前第${requestScope.pagePoint }页(共${requestScope.pageMax }页)</a></li>
                                            <li><a href="#!" id="skipBtn"> 跳转到&nbsp;<input type="text" name="pagePoint" style="width:20px;height: 14px; color:black; font-size: 10px;">&nbsp;页</a></li>
                                            <li><a href="${pageContext.request.contextPath }/admin-borrow-list-show?page=${requestScope.pagePoint + 1 }">»</a></li>
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
    		window.location = "${pageContext.request.contextPath}/admin-borrow-list-show?page=" + page;
    	});
    	$("#skipBtn > input").on("click", function() {
    		return false;
    	});
    })
    
    </script>
</body>

</html>