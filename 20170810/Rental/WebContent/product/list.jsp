<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="kdata.project.dto.*" %>
 <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
 <%
 List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("list");
%>
<style type="text/css">
table { border-style: solid; border: 1}
tr {border-style: solid; border: 1}
td {border-style: solid; border: 1}
</style>
</head>
<body>
<%for(int i=0; i<list.size(); i++)
   {%>
<table>
   <tr>
      <th> 회원사진 </th>
   </tr>
   <tr>
      <th> <img src="./profile/${list.get(i).getFilename() }"> </th>
   
   </tr>
   <tr>
      <th>제풍명
      <th>대여장소
      <th>제품가격
      <th>아이디
   </tr>
   <tr>
      <td><%=list.get(i).getProd_name() %> </td>
      <td><%=list.get(i).getProd_place() %> </td>
      <td><%=list.get(i).getProd_price() %> </td>
      <td><%=list.get(i).getCus_id()   %> </td>
   </tr>
   </table>
<% } %>

</body>
</html>