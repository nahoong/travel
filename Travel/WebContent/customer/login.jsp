<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/login.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
<% 
   String id=(String)session.getAttribute("id"); 
   String init=request.getParameter("init");
   
   if(id == null && init==null) {
%>
   <script>
      $(function(){
         
      });
   </script>


<%   }  %>

</head>
<body>

   <div class="login">
   <h1>Login</h1>
    <form method="post" id="form1" action="../login.customer">
       <input type="text" name="id" placeholder="Username" required="required" id="id"/>
        <input type="password" name="pw" placeholder="Password" required="required" id="pw"/>
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
    </form>
</div>
</body>
</html>