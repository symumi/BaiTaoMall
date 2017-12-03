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

<title>商品详情</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript" src="js/validator-login.js"></script>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<script type="text/javascript">
	function putGoods() {
		var httpRequest = new XMLHttpRequest();
		httpRequest.open("POST", "servlet/PutGoodsServlet", true);
		httpRequest.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf-8");
		httpRequest.send("gid=" + document.getElementById("gid").value
				+ "&num=" + document.getElementById("num").value);
		httpRequest.onreadystatechange = function() {
			if (httpRequest.readyState == 4 && httpRequest.status == 200) {
				alert("加入购物车成功");
			}
		}
	}
	function validate(numEle, max) {
		numEle.value = numEle.value.replace(/\D/g, '');
		if (numEle.value == '' || numEle.value <= '0') {
			numEle.value = '1';
		}
		if (numEle.value >= max) {
			numEle.value = max;
		}
		update(gid, numEle.value, numEle, index)
	}
	function changeNum(op) {
		var numEle = document.getElementById("num");
		var newnum = numEle.value;
		if (op == "+") {
			if (newnum < ${goods.number})
				newnum++;
			else
				newnum = goods.number;
		} else if (op == "-") {
			if (newnum > 0)
				newnum--;
			else
				newnum = 0;
		}
		numEle.value = newnum;
	}
</script>
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
	<div style="margin:150px;">
		<div class="goodsinfo">
			<input type="hidden" name="gid" id="gid" value="${goods.gid }">
			<img style="margin-top:24px;float:left;" src="${goods.gphoto }"
				width="480px" height="350px"><br>
			<div style="float:left">
				<hr size=350px width="1" color="#ff6a05"
					style="box-shadow:1px 1px 1px #dddddd">
			</div>
			<div>
				<a class="text1" style="font-size:18;font-weight:bold">${goods.gname }</a><br>
				<a class="text1"> ${goods.note}</a> <br> <a class="text1"
					style="font-size:16;font-weight:bold;color:red">￥${goods.price}</a><br>
				<a class="text1"> 剩余库存:${goods.number }</a><br>
				<div style="margin:30px auto;" class="gw_num">
					<div class="gw_num">
						<em class="jian" onclick="changeNum('-');">-</em> <input
							type="text" value="1" class="num" name="num" id="num"
							onkeyup="validate(this,${goods.number });"
							onafterupdate="validate(this,${goods.number });" /> <em
							class="add" onclick="changeNum('+');">+</em>
					</div>
				</div>
				<button style="width:100px;height:40px" type="button" class="button"
					onclick="if(${empty lf}) alert('加入购物车失败，请先登录');else putGoods();">加入购物车</button>
			</div>
		</div>
	</div>
	<div>
		<div style="height:40px;width:50%;margin:0 auto;">
			<a
				style="height:50px;line-height:40px;font-size:20;color:red;font-weight:bold;text-shadow: #dddddd 5px 5px 5px;">用户评论</a>
		</div>
		<div id="comm" class="comm">
			<c:forEach items="${uclist}" var="uc">
				<c:if test="${!empty uc.comment}">
					<div class="comment">
						<a class="textname">${uc.username}:</a><a class="text">${uc.comment}</a>
						<hr size=41px width="1" color="#eeeeee"
							style="margin:-40px 477px;">
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>
