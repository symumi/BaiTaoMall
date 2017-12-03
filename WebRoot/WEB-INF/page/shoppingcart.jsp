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

<title>购物车</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" href="css/shoppingcart.css" />
<link rel="stylesheet" href="css/mystyle.css" />
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript" src="js/validator-login.js"></script>
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
	<form
		action="${pageContext.request.contextPath }/servlet/ConfirmOrderServlet"
		method="post">
		<table
			style="text-align: center;width: 70%;margin-top:80px;border: 1px solid #ff6a05;"
			align="center">
			<tr>
				<th width="5%"></th>
				<th>商品信息</th>
				<th width="10%">单价</th>
				<th width="20%">数量</th>
				<th width="15%">金额</th>
				<th width="10%">操作</th>
			</tr>
			<c:forEach items="${shoppingcart }" var="entry" varStatus="status">
				<tr height="100px" id="${status.index }" class="row">
					<td><input name="gid" type="checkbox" class="checkbox"
						value="${entry.key.gid }" onchange="checkboxChanged(this);" /></td>
					<td style="width: 140px"><input type="text"
						value="${entry.key.gid }" id="gid${status.index }" hidden="hidden" />
						<img height="100px" width="120px" style="float:left"
						src="${entry.key.gphoto }"> <a
						style="line-height:100px;font-size:15;font-weight: bold;">${entry.key.gname}</a></td>
					<td style="width: 25%">￥<label id="price${status.index }"
						class="price">${entry.key.price }</label>
					</td>
					<td style="width: 25%"><input type="button"
						id="decrease${status.index }" width="1px" value="-"
						onclick="changeNum('-',${status.index },${entry.key.number })" />

						<input type="text" id="num${status.index }"
						value="${entry.value }"
						style="display: inline-block;width: 50px;text-align: center;"
						onkeyup="validate(this,${status.index },${entry.key.number });"
						onafterupdate="validate(this,${status.index},${entry.key.number });">

						<input type="button" id="increase${status.index }" width="1px"
						value="+"
						onclick="changeNum('+',${status.index },${entry.key.number })" />
					</td>
					<td style="width: 15%"><label id="max${status.index }"
						hidden="hidden">${entry.key.number }</label> <label
						id="sum${status.index }" class="label"></label></td>
					<td><a href="javascript:void(0);"
						onclick="deleteGoods(this,${entry.key.gid });">删除</a></td>
				</tr>
			</c:forEach>
			<tr style="background: #e5e5e5;">
				<td><input id="all" class="checkbox" type="checkbox"
					onclick="selectAll(this.checked);" /></td>
				<td><a href="javascript:void(0);"
					onclick="var allCheckbox=document.getElementById('all');allCheckbox.checked=!allCheckbox.checked;selectAll();">全选</a>
				</td>
				<td><a href="javascript:void(0);"
					onclick="deleteSelectedGoods();">删除</a></td>
				<td colspan="2"><div align="right">
						合计（不含运费）：<label id="total" class="total"></label>&nbsp;&nbsp;
					</div></td>
				<td align="right">
					<button class="submit-btn" id="submit-btn" type="submit"
						style="font-size:16" disabled="true">结&nbsp;算</button>
				</td>
			</tr>
		</table>
	</form>
</body>

<script type="text/javascript" src="js/shoppingcart.js"></script>

</html>