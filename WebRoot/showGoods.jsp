<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showGoods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<link rel="stylesheet" type="text/css" href="css/forSeller.css">
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript" src="js/validator-login.js"></script>
  </head>
  
  <body>
   <div class="mainheader">
  <p class="theType"> <a href="GetType?jump=add">添加商品</a></p>
  <p class="theType"> <a href="servlet/GetAllOrder">查看未发货订单</a></p>
   <p class="theType"><a href="servlet/GetAllOrder?status=all">查看所有订单</a></p>
   </div>
    <c:set value="${0}" var="i" scope="page"/>
    <c:set value="${3}" var="j"/>
    <c:forEach items="${num }" var="theNum">
    <div class="box">
		<c:forEach items="${goods}" var="g" begin="${i}" end="${j}" step="1">
			<ul>
				<li>
					<div class="goods">
					<img src="${g.gphoto }" width="158px" height="100px" /><br />
					    <p>${g.gname}</p>
						<p>${g.price}</p>
						<p>${g.note}</p>
    <a href="servlet/GetTheGoodsServlet?goodsId=${g.gid }">修改</a>|
    <a href="servlet/DeleteGoodsServlet?goodsId=${g.gid }">删除</a>
					</div>
				</li>
			</ul>
		</c:forEach>
	</div>
	<c:set value="${i+4 }" var="i"></c:set>
	<c:set value="${j+4 }" var="j"></c:set>
	</c:forEach>
  </body>
</html>
