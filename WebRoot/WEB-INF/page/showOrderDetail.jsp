<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<title>订单详情</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">

</head>

<body>
	<header>
	<div style="height: 80px; width: 100%; margin: 0 auto">
		<c:if test="${lf==null}">
			<form id="LoginForm" action="LoginServlet" method="post">
				<a class="top_title">欢迎光临集大杂货铺, 请登录</a> <a style="margin-left:20px"
					class="top_title">用户名:</a><input style="height:20px;border:none"
					type="text" id="username" name="username" /> <a
					style="margin-left:20px" class="top_title">密码:</a><input
					style="height:20px;border:none" type="password" id="password"
					name="password" />
				<button class="button" type="submit">
					<b>登录</b>
				</button>
				<button class="button" type="button"
					onclick="window.location.href='sign.jsp'">
					<b>注册</b>
				</button>
				<a class="top_title" style="position:absolute;left:72%"
					href="GetTenGoodsServlet">首页</a> <a class="top_title"
					style="position:absolute;left:75%"
					onclick="if(${empty lf}) alert('请先登录');"
					href="servlet/GetOrderList">个人订单</a> <a
					style="position:absolute;left:80%" class="top_title"
					onclick="if(${empty lf}) alert('请先登录');" href="GetTenGoodsServlet">购物车</a>
			</form>

		</c:if>
		<c:if test="${lf!=null}">
			<a style="" class="top_title">欢迎 , ${user.uname} ,
				您上次登录时间是${lastlogintime} </a>
			<a class="top_title" style="margin-left:50px"
				href="LogoutServlet?uid=${user.uid}">注销</a>
			<a class="top_title" style="position:absolute;left:69%"
				href="GetTenGoodsServlet">首页</a>
			<a class="top_title" style="position:absolute;left:72%"
				href="servlet/GetOrderList">个人订单</a>
			<a class="top_title" style="position:absolute;left:77%"
				href="servlet/ShowShoppingcart">购物车</a>
		</c:if>
		<div id="time"
			style="color:white;margin-left: 90%;font-size:8px;margin-top:-22px">
			<script>
				document.getElementById('time').innerHTML = new Date()
						.toLocaleString()
						+ ' 星期' + '日一二三四五六'.charAt(new Date().getDay());
				setInterval(
						"document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星 期'+'日一二三四五六'.charAt(new Date().getDay());",
						1000);
			</script>
		</div>
	</div>
	</header>
	<div class="orderborder">
		<c:choose>
			<c:when test="${detail!=null }">
				<div>
					<div>
						<a class="ordertext" style="line-height:30px">订单号：${detail.aid }
							订单总价：${detail.totalprice }</a>
					</div>
					<div>
						<a class="ordertext" style="line-height:30px">收货地址：${detail.receiver }，${detail.phone }，${detail.address }</a>
					</div>
					<div>
						<c:forEach items="${detail.TGoods}" var="goods" varStatus="status">
							<div class="box1">
								<img src="${goods.gphoto }" width="140px" height="120px">
								<a class="ordertext"> 名称：${goods.gname }&nbsp;&nbsp;&nbsp; ￥<fmt:formatNumber
										type="number"
										value="${detail.number[status.index]*goods.price }"
										pattern="0.00" maxFractionDigits="2" />&nbsp;&nbsp;&nbsp;
									数量：${detail.number[status.index] }<br />
								</a>
								<c:choose>
									<c:when test="${!empty detail.comment[status.index] }">
										<a class="ordertext" style="line-height:50px;">您的评价：${detail.comment[status.index] }</a>
										<br />
									</c:when>
									<c:otherwise>
										<c:if test="${!empty detail.receivetime }">
											<c:choose>
												<c:when test="${!detail.isCancel }">
													<form action="servlet/PutComment" method="post">
														<input type="hidden" value="${detail.aid }" name="aid">
														<input type="hidden" value="${goods.gid }" name="gid">
														<input type="text" name="comment"> <input
															type="submit" value="评价商品">
													</form>
													<br />
												</c:when>
												<c:otherwise>
													<input type="text" value="无法评价该商品" readonly="readonly">
													<br />
												</c:otherwise>
											</c:choose>
										</c:if>
									</c:otherwise>
								</c:choose>
							</div>
						</c:forEach>
						<br />
					</div>
					<div>
						<a class="ordertext" style="line-height:30px;">创建时间：${detail.createtime }</a><br />
						<c:choose>
							<c:when test="${detail.isCancel==true }">
								<a class="ordertext" style="line-height:160px;">订单已取消</a>
								<br />
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${empty detail.paytime }">
										<br />
										<a class="ordertext"
											style="line-height:50px; color:red; font-size:16">您尚未支付，</a>
										<a class="ordertext"
											style="line-height:50px; color:blue; font-size:16"
											href="servlet/OperateOrder?method=3&aid=${detail.aid }">立即支付></a>
										<br />
									</c:when>
									<c:otherwise>
										<a class="ordertext" style="line-height:30px;">支付时间：${detail.paytime }</a>
										<br />
										<c:choose>
											<c:when test="${!empty detail.sendtime }">
												<c:choose>
													<c:when test="${!empty detail.receivetime }">
														<a class="ordertext" style="line-height:30px;">收货时间：${detail.receivetime }</a>
														<br />
													</c:when>
													<c:otherwise>
														<a class="ordertext" style="line-height:30px;color:blue;"
															href="servlet/OperateOrder?method=2&aid=${detail.aid }">确认收货</a>
														<br />
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:otherwise>
												<a class="ordertext" style="line-height:30px;">您的宝贝尚未发货</a>
												<br />
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:when>
			<c:otherwise>订单号错误，无此订单</c:otherwise>
		</c:choose>
	</div>
</body>

</html>