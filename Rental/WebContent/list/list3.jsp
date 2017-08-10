<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="kdata.project.dto.*" %>
 <%@ page import="java.util.List" %>
 <%@ page import="java.sql.SQLException"%>
  <!DOCTYPE html>
  <html>
    <head>
      <meta charset="UTF-8">
      <title>Responsive List</title>
        
    </head>

   <link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
    <link href="<%=request.getContextPath()%>/css/list.css" rel="stylesheet" type='text/css'>
    <body>
      <%@ include file="../common/menu.jsp" %>
<br>
<br>
<br>
<br>
<h1>경주용 자전거</h1>
<h3>선수할거아니면 ㅋ</h3>
<%
 List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("list");

      for (ProductDTO p:list) {
    	 
         %>
 <%   if(p.getProd_class().equals("레이싱")){ %>
  <a class="button teach-me">
  <span class="item"><img src="<%=request.getContextPath()%>/profile/<%=p.getFilename()%>" style="width:304px;height:228px;">
  <%=p.getProd_name() %>
  </span>
  <span class="meta category"><%=p.getProd_place() %></span>
  <i class="clock"></i>
  <span class="meta expiry"><%=p.getCus_id()   %> </span>
  <span class="meta cost"><%=p.getProd_price() %> </span>
  <i class="chevron"></i>
</a>
<% } %>
<% } %>
</body>
</html>