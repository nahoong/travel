<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
/******************************
Flexbox Layout
*******************************/

.header, .nav {
  display: -webkit-flex;
  display: flex;
  -webkit-flex-direction: column;
  flex-direction: column;
}

.header {
  justify-content: space-between;
}

.nav {
  -webkit-flex: 1;
  flex: 1;
  -webkit-justify-content: space-around;
  justify-content: space-around;
}

@media all and (min-width: 640px) {
  .header, .nav {
    -webkit-flex-direction: row;
    flex-direction: row;
  }
}

@media all and (min-width: 1030px) {
  .nav {
    -webkit-flex: none;
    flex: none;
  }
}


/******************************
Treehouse Styling
*******************************/

body {
  margin: 0;
  font-family: Helvetica;
  background-color: pink;
  background-size: cover;
}

.header {
  padding: 20px 0;
  margin: 0 auto;
}
.ct-btn {
	display: inline-block;
	margin: 0;
	padding: .0em .75em;
	border-radius: .25em;
	box-sizing: content-box;
	-moz-box-sizing: content-box;
	background: transparent;
	outline: 0;
	vertical-align: middle;
	font-family: inherit;
	font-size: 15px;
	text-decoration: none;
	white-space: nowrap;
	cursor: pointer
}
.ct-btn.white {
	color: #666;
	border: 1px solid #ebebeb;
	border-bottom-color: #c6c6c6;
	box-shadow: 0 2px 2px rgba(0, 0, 0, 0.04);
	background: #fff;
	background: linear-gradient(to bottom, #ffffff 40%, #f6f6f6 100%);
 filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#f6f6f6', GradientType=0 );/*IE*/
}
/* 일반적인 버튼의 상황 */
.ct-btn.white,
.ct-btn.white:link,
.ct-btn.white:visited {
	color: #666;
	border: 1px solid #ebebeb;
	border-bottom-color: #c6c6c6;
	box-shadow: 0 2px 2px rgba(0, 0, 0, 0.04);
	background: #fff;
	background: linear-gradient(to bottom, #ffffff 40%, #f6f6f6 100%);
 filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#f6f6f6', GradientType=0 );/*IE*/
}
 
/* 마우스오버 */
.ct-btn.white:focus,
.ct-btn.white:hover {
	background: #f4f4f4;
	background: linear-gradient(to bottom, #fafafa 0%, #fff 100%);
 filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fafafa', endColorstr='#ffffff', GradientType=0 );/*IE*/
}
 
/* 눌려졌거나 선택 된 상황 */
.ct-btn.white:active,
.ct-btn.white.active {
	text-shadow: 0 1px 0px #fff;
	border-color: #ebebeb;
	border-top-color: #ddd;
	background: #f4f4f4;
	box-shadow: none
}

.logo {
  background: transparent url('./logo/gongcycl.png') center center no-repeat;
  width: 195px;
  background-size: contain;
  text-indent: 100%;
  white-space: nowrap;
  overflow: hidden;
}

.nav {
  list-style: none;
}


.nav li {
  margin: 12px 0 12px 28px;
}

.nav li a {
  text-decoration: none;
  color: #fff;
  font-size: 12px;
  text-transform: uppercase;
}

.nav li a:hover {
  color: rgba(255,255,255,0.7);
}

.nav li:HOVER a {
  background: rgba(255,255,255,0.3);
  border-radius: 2px;
  transition: 200ms ease-in-out;
  padding: 8px 16px 7px;
}

.nav li:HOVER a:hover {
  background: rgba(255,255,255,0.5);
  color: #fff;
}

@media all and (min-width: 1030px) {
  .header {
    width: 1030px;
    min-width: 768px;
  }
}
#Menu{
display:none;
position:absolute;
text-align:left;
}
#m ul li:hover ul {
 display: block;
}
#m ul ul ul {
float:none;
list-style-type:none;
}


</style>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="./js/jquery-3.2.1.js"></script>
<% 
String id=(String)session.getAttribute("id");
%>

<script>

   $(function(){
      var id="<%=id%>";
      
      $.ajax({
         success : function(){
            if(id=="null"){
            	$("#login").css("display","visible");
            	$("#sign").css("display","visible");
               $("#sign").html("<a href='./customer/register.jsp'>Sign In</a></li>");
               $("#login").html("<form action='customer/login.jsp' method='get'><input type='submit' value='Log in' class='ct-btn white'></input>"+
               "<input type='hidden' name='init' value='1'></form></li>");     
            }
            else{
            	$("#login").css("display","none");
            	$("#sign").css("display","none");
               $("#name").html(id+"님 환영합니다.").css("font-weight","bold").css("color","white");
               $("#logout").html("<a href='logout.customer'>Logout</a></li>");
            }
         }
            
      });      
   });
</script>
</head>
<body>

<header class="header">

  <h1 class="logo">Logo</h1>
     <div id="m">
  <ul class="nav">
    <li id="sign">
    <li id="login">
    <li id="logout">
    <li id="name">
  </ul>
   </div>
</header>

<center>
<br>
<br>
<br>
<br>
<div style="width:50%; padding:10px; text-shadow:none; border-style:solid; boder:1px"  >
		
		<a href="./about/gwanghuamoon.jsp">
		<div style='margin-bottom:0px; border-bottom:1px solid black;'>
			<img src='./photo/gwm.PNG' width=100% style=''>
			<div style='height:33px; background-color:#000; text-align:left; opacity:0.7;'>
				<p style='padding:9px; color:#fff;'>
					광화문					&nbsp;
					<input type='hidden' class='coordinate' value='37.576026&&126.9768428'>
					<span style='float:right; width:70px; text-align:right' class='distMeter'></span>
				</p>
			</div>
		</div>
		</a>
		
		<a href="../seoul/view.html?trans=kr&table_name=attraction&_category=&seq=874">
		<div style='margin-bottom:0px; border-bottom:1px solid black;'>
			<img src='../_file/board/201305/1369957353_070.png' width=100% style=''>
			<div style='height:33px; background-color:#000; text-align:left; opacity:0.7;'>
				<p style='padding:9px; color:#fff;'>
					인사동					&nbsp;
					<input type='hidden' class='coordinate' value='37.5717&&126.986'>
					<span style='float:right; width:70px; text-align:right' class='distMeter'></span>
				</p>
			</div>
		</div>
		</a>
		
		<a href="../seoul/view.html?trans=kr&table_name=attraction&_category=&seq=833">
		<div style='margin-bottom:0px; border-bottom:1px solid black;'>
			<img src='../_file/board/201308/1375773554_525.png' width=100% style=''>
			<div style='height:33px; background-color:#000; text-align:left; opacity:0.7;'>
				<p style='padding:9px; color:#fff;'>
					삼청동길					&nbsp;
					<input type='hidden' class='coordinate' value='37.584838&&126.981913'>
					<span style='float:right; width:70px; text-align:right' class='distMeter'></span>
				</p>
			</div>
		</div>
		</a>
		
		<a href="../seoul/view.html?trans=kr&table_name=attraction&_category=&seq=856">
		<div style='margin-bottom:0px; border-bottom:1px solid black;'>
			<img src='../_file/board/201309/1378290230_611.png' width=100% style=''>
			<div style='height:33px; background-color:#000; text-align:left; opacity:0.7;'>
				<p style='padding:9px; color:#fff;'>
					신사동 가로수길					&nbsp;
					<input type='hidden' class='coordinate' value='37.522688&&127.025272'>
					<span style='float:right; width:70px; text-align:right' class='distMeter'></span>
				</p>
			</div>
		</div>
		</a>
		
		<a href="../seoul/view.html?trans=kr&table_name=attraction&_category=&seq=793">
		<div style='margin-bottom:0px; border-bottom:1px solid black;'>
			<img src='../_file/board/201306/1370302798_260.png' width=100% style=''>
			<div style='height:33px; background-color:#000; text-align:left; opacity:0.7;'>
				<p style='padding:9px; color:#fff;'>
					남산(N서울타워)					&nbsp;
					<input type='hidden' class='coordinate' value='37.5511791&&126.9881809'>
					<span style='float:right; width:70px; text-align:right' class='distMeter'></span>
				</p>
			</div>
		</div>
		</a>
		
		<a href="../seoul/view.html?trans=kr&table_name=attraction&_category=&seq=795">
		<div style='margin-bottom:0px; border-bottom:1px solid black;'>
			<img src='../_file/board/201306/1370341134_207.png' width=100% style=''>
			<div style='height:33px; background-color:#000; text-align:left; opacity:0.7;'>
				<p style='padding:9px; color:#fff;'>
					남산야외식물원					&nbsp;
					<input type='hidden' class='coordinate' value='37.5427637&&126.9954579'>
					<span style='float:right; width:70px; text-align:right' class='distMeter'></span>
				</p>
			</div>
		</div>
		</a>
		
		<a href="../seoul/view.html?trans=kr&table_name=attraction&_category=&seq=776">
		<div style='margin-bottom:0px; border-bottom:1px solid black;'>
			<img src='../_file/board/201306/1370862669_808.png' width=100% style=''>
			<div style='height:33px; background-color:#000; text-align:left; opacity:0.7;'>
				<p style='padding:9px; color:#fff;'>
					경복궁					&nbsp;
					<input type='hidden' class='coordinate' value='37.5788408&&126.9770162'>
					<span style='float:right; width:70px; text-align:right' class='distMeter'></span>
				</p>
			</div>
		</div>
		</a>
		
		<a href="../seoul/view.html?trans=kr&table_name=attraction&_category=&seq=801">
		<div style='margin-bottom:0px; border-bottom:1px solid black;'>
			<img src='../_file/board/201306/1370045284_672.png' width=100% style=''>
			<div style='height:33px; background-color:#000; text-align:left; opacity:0.7;'>
				<p style='padding:9px; color:#fff;'>
					덕수궁					&nbsp;
					<input type='hidden' class='coordinate' value='37.5660945&&126.9749148'>
					<span style='float:right; width:70px; text-align:right' class='distMeter'></span>
				</p>
			</div>
		</div>
		</a>
		
		<a href="../seoul/view.html?trans=kr&table_name=attraction&_category=&seq=802">
		<div style='margin-bottom:0px; border-bottom:1px solid black;'>
			<img src='../_file/board/201306/1370045326_643.png' width=100% style=''>
			<div style='height:33px; background-color:#000; text-align:left; opacity:0.7;'>
				<p style='padding:9px; color:#fff;'>
					덕수궁 돌담길 					&nbsp;
					<input type='hidden' class='coordinate' value='37.5654775&&126.9766203'>
					<span style='float:right; width:70px; text-align:right' class='distMeter'></span>
				</p>
			</div>
		</div>
		</a>
		
		<a href="../seoul/view.html?trans=kr&table_name=attraction&_category=&seq=803">
		<div style='margin-bottom:0px; border-bottom:1px solid black;'>
			<img src='../_file/board/201306/1370045108_089.png' width=100% style=''>
			<div style='height:33px; background-color:#000; text-align:left; opacity:0.7;'>
				<p style='padding:9px; color:#fff;'>
					덕수궁 미술관(국립현대미술관)					&nbsp;
					<input type='hidden' class='coordinate' value='37.5658456&&126.9737396'>
					<span style='float:right; width:70px; text-align:right' class='distMeter'></span>
				</p>
			</div>
		</div>
		</a>

</div>
</center>






</body>
</html>