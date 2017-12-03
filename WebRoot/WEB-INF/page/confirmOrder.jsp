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

<title>确认订单信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="css/confirmOrder.css">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript" src="js/china.js"></script>
<script type="text/javascript">
	$()
			.ready(
					function() {
						// 在键盘按下并释放及提交后验证提交表单
						$("#receiveForm")
								.validate(
										{
											rules : {
												receiver : {
													required : true,
													minlength : 2,
													maxlength : 20,
												},
												phone : {
													required : true,
													digits : true,
													minlength : 11,
													maxlength : 11
												},
												detail : {
													required : true,
													minlength : 4,
												},
											},
											messages : {
												receiver : {
													required : "送给谁呢?",
													minlength : $.validator
															.format("最少要输入 {0} 个字符"),
													maxlength : $.validator
															.format("最多可以输入 {0} 个字符(一个中文字算2个字符)")
												},
												phone : {
													required : "联系谁呢?",
													digits : "混入了奇怪的东西",
													length : $.validator
															.format("你电话不是11位么"),
													minlength : $.validator
															.format("你电话不是11位么"),
													maxlength : $.validator
															.format("你电话不是11位么")
												},
												detail : {
													required : "地方好大找不到哦",
													minlength : $.validator
															.format("再详细些吧"),
												}
											}
										});
					});
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
	<div class="orderborder">
		<form id="receiveForm"
			action="${pageContext.request.contextPath }/servlet/CreateOrderServlet"
			method="post">
			<table class="table1" style="border:1px solid #eeeeee;"
				align="center">
				<c:forEach items="${info }" var="entry">
					<tr>
						<td width="200px" height="150px"><input type="hidden"
							name="gids" value="${entry.key.gid }" /> <img
							src="${entry.key.gphoto }" width="200px" height="150px"></td>
						<td><a class="ordertext" style="line-height:150px">${entry.key.gname }</a></td>
						<td><input type="text" name="num" value="${entry.value }"
							align="center" style="border: none" readonly="readonly" size="1" /></td>
						<td><a class="ordertext" style="color:red">￥<fmt:formatNumber
									type="number" value="${entry.key.price*entry.value }"
									pattern="0.00" maxFractionDigits="2" /></a></td>
						</td>
					</tr>
				</c:forEach>
			</table>
			<table id="recieve" class="orderborder"
				style="border:1px solid #eeeeee;" align="center">
				<tr>
					<td colspan="4"><a
						style="font-size:17;font-weight:bold;color:red">收货信息</a>
				</tr>
				<tr>
					<td><a>收货地址：</a>
					<td><select id="province" onchange="provinceChanged();">
							<option value="0">==请选择省份==</option>
					</select>
					<td><select id="city" onchange="cityChanged();">
							<option value="0">==请选择城市==</option>
					</select>
					<td><select id="district" onchange="changeText('district');">
							<option value="0">==请选择区/县==</option>
					</select>
				</tr>
				<tr style="height:10px"></tr>
				<tr>
					<td colspan="4"><a>详细地址： <input type="hidden"
							name="province"> <input type="hidden" name="city">
							<input type="hidden" name="district"> <input id="detail"
							type="text" name="detail"></a>
				</tr>
				<tr style="height:10px"></tr>
				<tr>
					<td colspan="4"><a>收货人：<input id="receiver" type="text"
							name="receiver"></a>
				</tr>
				<tr style="height:10px"></tr>
				<tr>
					<td colspan="4"><a> 联系电话： <input id="phone" type="text"
							name="phone"></a>
				</tr>
				<tr style="height:10px"></tr>
				<tr>
					<td colspan="4">
						<div style="margin:0 auto;">
							<button type="submit" class="go-btn">提交订单</button>
						</div>
				</tr>
			</table>


		</form>

	</div>
</body>

</html>
