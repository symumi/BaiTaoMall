<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'getOrderList.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<h1><a href="GetType">返回首页</a></h1>
	<c:forEach items="${details }" var="detail">
		<div>
			订单号：${detail.aid } 创建时间：${detail.createtime }
			<c:forEach items="${detail.TGoods }" var="goods">
				<div>
					<img src="${goods.gphoto }" width="140px" height="100px">${goods.gname }</div>
			</c:forEach>
			<c:choose>
				<c:when test="${empty detail.carriage }">
					<form action="servlet/SendGoods" method="post">
						<input type="hidden" value="${detail.aid }" name="aid"> <select
							name="carriage">
							<option value="申通">申通</option>
							<option value="圆通">圆通</option>
							<option value="韵达">韵达</option>
							<option value="顺丰">顺丰</option>
							<option value="中通">中通</option>
							<option value="如风达">如风达</option>
						</select> <input type="submit" value="确定发货">
					</form>
				</c:when>
				<c:otherwise>
					<label>已发货，发货方式：${detail.carriage }</label>
				</c:otherwise>
			</c:choose>
		</div>
	</c:forEach>
</body>
</html>
