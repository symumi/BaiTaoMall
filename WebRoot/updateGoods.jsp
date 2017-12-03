<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateGoods.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="css/forGoods.css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/canvas-to-blob.min.js" type="text/javascript"></script>
	<script src="js/fileinput.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/zh.js" type="text/javascript"></script>

  </head>
  
  <body>
  <h1><a href="GetType">返回首页</a></h1>
  
  <div class="goodsInfo">
  <form action="servlet/UpdateGoodsServlet" method="post">
  <div class="image">
   <input id="imgs" name="images" class="projectfile"  type="file">
   </div>
   <div class="info">
   <div class="select">
    类型<select name="type" >
    <l:forEach items="${types}" var="type">
    <l:if test="${type.tid==goods.TType.tid }">
    <option value="${type.tid}" selected="selected">${type.tname}</option>
    </l:if>
    <l:if test="${type.tid!=goods.TType.tid }">
    <option value="${type.tid}">${type.tname}</option>
    </l:if>
    </l:forEach>
    </select><br>
    </div>
    <label>   名字:</label><input type="text" name="gname" value="${goods.gname }"><br>
      <label>  数量:</label>  <input type="text" name="number" value="${goods.number }"><br>
    <label>   价格:</label><input type="text" name="price" value="${goods.price }"><br>
 <label>  详情:</label><input type="text" name="note" value="${goods.note }"><br>
    <input type="text" name="gid" style="visibility: hidden;" value="${goods.gid }" >
    <input type="submit" value="更改">
    <input type="reset" value="重置">
    </div>
    </form>
    </div>
      <script src="js/uploadImg.js" type="text/javascript"></script>
  </body>
</html>
