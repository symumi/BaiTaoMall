<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>用户注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">

<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript" src="js/validator.js"></script>
<script type="text/javascript" src="js/validator-login.js"></script>
<style>
.error {
	font-size: 10;
	color: black;
}
</style>
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

	<div class="signborder">
		<div align="center" style="height: 100px;margin:10px auto;">
			<img src="image/battle.bmp">
		</div>
		<form id="signupForm" action="SignServlet" method="post">
			<div class="signtext" style="margin:30px">
				<a>用户名: </a><input id="username" type="text" name="username" /><br>
				<br> <a>密码: </a><input id="spassword" type="password"
					name="password" onblur="checkpas1();" required="true" /><br>
				<br> <a>确认密码:</a><input id="repeatpassword" type="password"
					name="repeatpassword" required="true" onChange="checkpas();" /> <br>
				<span class="tip" style="font-size:10;color: black;">两次输入的密码不一致</span>
				<br> <a>邮箱: </a> <input id="txtEmail" type="text" name="email" />
				<br> <span id="spinfo" style="font-size:10;color: black;"></span>
				<br /> <br> <br>
				<button type="submit" class="search-button" style="margin-top:0px"
					onclick="checkpas2();">注册</button>
			</div>
		</form>
	</div>
</body>

</html>