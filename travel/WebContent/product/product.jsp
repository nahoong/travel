<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
@charset "utf-8";


html, body, form, fieldset, legend, ol, li {
   margin: 9px;
   padding: 0;
   }

body {
   background: url('../logo/background0.png') top center no-repeat;
   background-size: cover;
   color: #111111;
   font-family: 맑은고딕,굴림,돋움;
   text-align:center;
   display: flex;
  align-items: center;
  justify-content: center
  
  
      
}

fieldset {
   border-style: solid;
   border-color: black;
}

#form {
   padding: 70px;
}

form {
    background: none;
   -moz-border-radius: 155px;
   -webkit-border-radius: 155px;
   -khtml-border-radius: 155px;
   border-radius: 155px;
   counter-reset: fieldsets;
   text-align:center;
   padding: 100px;
   width: 500px;   
   
}
form fieldset {
   border-style: groove;
   border-color: #cc3300;
   /* margin-bottom: 100px; */
}
      
form fieldset:last-of-type {
   margin-bottom: 0;
}
         
form legend {
   color: #cc3300;
   font-size: 16px;
   font-weight: bold;
   padding-bottom: 10px;
   text-shadow: 0 1px 1px #c0d576;
}
            
form > fieldset > legend:before {
   content: " ";
   counter-increment: fieldsets;
}
            
form fieldset fieldset legend {
   color: #111111;
   font-size: 13px;
   font-weight: normal;
   padding-bottom: 0;
}
         
form ol li {
   background: #b9cf6a;
   background: rgba(255,255,255,.3);
   border-color: #e3ebc3;
   border-color: rgba(255,255,255,.6);
   border-style: solid;
   border-width: 2px;
   -moz-border-radius: 5px;
   -webkit-border-radius: 5px;
   -khtml-border-radius: 5px;
   border-radius: 5px;
   line-height: 30px;
   list-style: none;
   padding: 5px 10px;
   margin-bottom: 2px;
}
                     
form ol ol li {
   background: none;
   border: none;
   float: left;
}
         
form label {
   float: left;
   font-size: 13px;
   width: 110px;
}
            
form fieldset fieldset label {
   background:none no-repeat left 50%;
   line-height:10px;
   padding: 0 0 0 30px;
   width: auto;
}
               
               
form fieldset fieldset label:hover {
   cursor: pointer;
}
   
form input:not([type=submit]):focus, {
   background: #eaeaea;
}
.logo {
  background: transparent url('../logo/logo0.png') center center no-repeat;
  width: 195px;
  background-size: contain;
  text-indent: 100%;
  white-space: nowrap;
  overflow: hidden;
}  
form button {
   background: #cc3300;
   border: solid;
   -moz-border-radius: 20px;
   -webkit-border-radius: 20px;
   -khtml-border-radius: 20px;
   border-radius: 20px;
   color: #ffffff;
   display: block;
   font: 16px 맑은고딕,굴림,돋움;
   letter-spacing: 1px;
   margin: auto;
   padding: 7px 25px;
   text-shadow: 0 1px 1px #000000;
   text-transform: uppercase;
}
               
form button:hover {
   background: #00ccff;
   cursor: pointer;
}

input[type=button] {
    background-color: #cc3300;
    border: solid;
    color: white;
    padding: 3px 1px;
    text-decoration: none;
    margin: 1px 1px;
    cursor: pointer;
    border-radius: 20px;
}
</style>

</head>
<body>
<a href="<%=request.getContextPath()%>/home.jsp"><img src="<%=request.getContextPath()%>/logo/gongcycle1.png"></a>
<form action="./register.product"  method="post"  enctype="multipart/form-data">

 <fieldset>
 제품품목  <select name='prod_class'>
    <option value='' selected>-- 선택 --</option>
    <option>나들이</option>
    <option>산악</option>
    <option>레이싱</option>
</select>
<br>
  제품명      <input type="text" name="prod_name" required="required"> <br>
  대여가격   <input type="text" name="prod_price" required="required"> <br>
  대여장소   <input type="text" name="prod_place" required="required">  <br>
 사진등록    <input type="file" name="file" value="file">  <br>
 <input type="submit" value="확인">
 </fieldset>
 </form>
</body>
</html>