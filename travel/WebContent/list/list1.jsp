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
<style>

</style>
   <link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
    <link href="<%=request.getContextPath()%>/css/list.css" rel="stylesheet" type='text/css'>
    <body>
      <%@ include file="../common/menu.jsp" %>
<br>
<br>
<br>
<br>
<h1>나들이</h1>
<h3>편하게 타는 자전거임</h3>
<%
 List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("list");

      for (ProductDTO p:list) {
    	 
         %>
 <%   if(p.getProd_class().equals("나들이")){ %>
  <a class="button teach-me" href="<%=request.getContextPath()%>/detail.customer?name=<%=p.getProd_name()%>&class=<%=p.getProd_class()%>&filename=<%=p.getFilename()%>&price=<%=p.getProd_price()%>&place=<%=p.getProd_place()%>&num=<%=p.getProd_num()%>">
  <span class="item"><img src="<%=request.getContextPath()%>/profile/<%=p.getFilename()%>" style="width:304px;height:228px;">
  바이크 성명 : <%=p.getProd_name() %>
  </span>
  <span class="meta category">대여 가능 지역 : <%=p.getProd_place() %></span>
  <i class="clock"></i>
  <span class="meta expiry">사용자 ID : <%=p.getCus_id()   %> </span>
  <span class="meta cost">일일 렌트 가격 : <%=p.getProd_price() %> </span>
  <i class="chevron"></i>
</a>
<% } %>
<% } %>
</body>
</html>