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
    
    <title>My JSP 'addGoods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
  <form class="cmxform" id="signupForm" method="post" action="AddGoods" style="margin-top: 10px">
            <div class="image">
		    <input id="imgs" name="images" class="projectfile"  type="file">
	       </div>
	       <div class="info">
	       <div class="select">
		       <label>类型:</label> <select name="type">
		    <l:forEach items="${types}" var="type">
		    <option  value="${type.tid}">${type.tname}</option>
		    </l:forEach>
		    </select><br>
		    </div>
		  <label>   名字:</label> <input type="text" name="gname"><br>
		  <label>  数量:</label>  <input type="text" name="number" ><br>
		  <label>   价格:</label> <input type="text" name="price" ><br>
		  <label>  详情:</label> <input type="text" name="note" ><br>
		 <input type="submit" value="添加" >
		 </div>
	</form>	
     </div>
  <script src="js/uploadImg.js" type="text/javascript"></script>
  </body>
</html>
