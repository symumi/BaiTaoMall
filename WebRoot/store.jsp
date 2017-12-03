<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>杂货铺</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<link rel="stylesheet" type="text/css" href="css/forType.css">
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
	<div style="width:100%;margin-top:30px;text-align:center">
		<a style="font-size:30px;color:#ff6a05;font-weight:bold;">集大杂货铺</a>
	</div>
	<div class="thisType" style="margin-top:30px;">
		<c:forEach items="${types}" var="type">
			<p class="theType">
				<a href="GetGoodsByType?tid=${type.tid}"
					class="thetext">${type.tname}</a>
			</p>
		</c:forEach>
	</div>
	<hr
		style="height:1px;width:80%;margin:0 auto;background-color:#dddddd;">
	<br>
	<c:set value="${0}" var="i" scope="page" />
	<c:set value="${3}" var="j" />
	<c:forEach items="${num }" var="theNum">

		<div class="box">
			<c:forEach items="${goods}" var="g" begin="${i}" end="${j}" step="1">
				<ul>
					<li>
						<div class="goods">
							<a href="GetGoodsInfo?gid=${g.gid}"> <img src="${g.gphoto }"
								width="158px" height="100px" />
							</a><br /> <a class="name1" href="GetGoodsInfo?gid=${g.gid}">
								${g.gname}</a>
							<p>￥${g.price}</p>
							<p>${g.note}</p>
						</div> <br>
						<hr
							style="height:1px;width:100%;margin:0 auto;background-color:#dddddd;">
					</li>
				</ul>
			</c:forEach>
		</div>
		<c:set value="${i+4 }" var="i"></c:set>
		<c:set value="${j+4 }" var="j"></c:set>

	</c:forEach>
</body>
</html>
