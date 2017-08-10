   <%@ page import="kdata.project.dto.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script>
$(function() {
	<%
	ProductDTO p = (ProductDTO)request.getAttribute("product");

%>


   var $rentNum;
   
   //페이지 들어가자마자 댓글 보이게-------------------------------------------------
      console.log("dfd");
      $.ajax({
         url : "./selectcomments.customer?num=<%=p.getProd_num()%>",
         dataType : "json",
         success : function(data) {
            //console.log(aaa);
            
             var str = "<table><tr><td> 아이디 <td> 희망 대여 시작일 <td> 희망 대여 종료일 <td> 신청 내용</tr>";
            $.each(data, function(index, item){
               str = str + "<tr><td> "+item.id+"</td>";
               str = str +      "<td>"+item.startday+"</td>";
               str = str +      "<td>"+item.endday+"</td>";
               str = str +      "<td>"+item.context+"</td>";
               str = str +    "<td><input type='button' value='X' id='delete'></td>";
               str = str + "</tr>";
            });   
            str = str + "</table>";
            
            $("#list").html(str); 
         },
         error : function() {
            console.log("error");
         }
      });
   
   //댓글쓰기-------------------------------------------------
   $("#submit").on("click",function(){
      $.ajax({
         url : "./writecomments.customer?num=<%=p.getProd_num()%>&id=<%=p.getCus_id()%>",
         data : {"startday": $("#startday").val(),"endday": $("#endday").val(),"context":$("#context").val()},
         dataType : "json",
         success : function(data) {
            console.log(data);
            
            var str = "<table><tr><td> 아이디 <td> 희망 대여 시작일 <td> 희망 대여 종료일 <td> 신청 내용</tr>";
            $.each(data, function(index, item){
               str = str + "<tr><td> "+item.id+"</td>";
               str = str +      "<td>"+item.startday+"</td>";
               str = str +      "<td>"+item.endday+"</td>";
               str = str +      "<td>"+item.context+"</td>";
               str = str +    "<td><input type='button' value='X' id='delete'></td>";
               str = str + "</tr>";
            });   
            str = str + "</table>";
            
            $("#list").html(str);
         },
         error : function() {
            console.log("error");
         }
      });
   });
   
   //댓글삭제-------------------------------------------------
   $("#list").on("click","#delete",function() {
      console.log($(this).parent().parent().find("td:first-child").attr('num') )
      $.ajax({
        
        
        url : "../deletecomments.customer?num=<%=p.getProd_num()%>",
        data : {"rentNum": $(this).parent().parent().find("td:first-child").attr('num')},

        dataType : "json",
        success : function(data){
           console.log("sss");
           
           var str = "<table><tr><td> 아이디 <td> 희망 대여 시작일 <td> 희망 대여 종료일 <td> 신청 내용</tr>";
           $.each(data, function(index, item){
              str = str + "<tr><td>"+item.id+"</td>";
              str = str +      "<td>"+item.startday+"</td>";
              str = str +      "<td>"+item.endday+"</td>";
              str = str +      "<td> "+item.context+"</td>";
              str = str +    "<td><input type='button' value='X' id='delete'></td>";
              str = str + "</tr>";
           });   
           str = str + "</table>";
           
           $("#list").html(str);

        },
        error : function(){
           console.log("sss");
        }
     }) 
  })  
   
});
</script>
</head>
<body>


<div>
    <div class="pic">
        <img src="<%=request.getContextPath()%>/profile/<%=p.getFilename()%>" alt="" style="width:900px;">
        <div class="caption">

            <h4 class="name">제목 : <%=p.getProd_name() %></h4>
             <h4 class="name">글번호 : <%=p.getProd_num() %></h4>
            <h4 class="class">품목 :  <%=p.getProd_class() %></h4>
            <h4 class="price">대여가격 :<%=p.getProd_price() %> </h4>
            <h4 class="place">대여장소 :<%=p.getProd_place() %> </h4>
        </div>
    </div>
</div>
   
<fieldset>
   <legend>댓글 쓰기</legend>
   <span>희망 대여 신청일 : <input type="date" name="startday" id="startday" pattern="MM-dd">   </span>
   <span>희망 대여 종료일 : <input type="date" name="endday" id="endday" pattern="MM-dd">   </span><br>
   <span>신청 내용 : <input type="text" name="context" id="context">   </span>
   <span><input type="submit" value="등록"  id="submit"></span>
</fieldset>

<fieldset>
   <legend>댓글 내용</legend>
   <div id="list">

   </div>
</fieldset>

</body>
</html>