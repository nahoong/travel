<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="../js/jquery-3.2.1.js"></script>
<script>
$(function(){
   var $idsuccess=0;
   var $pwsuccess=0;
   
   $("#cus_id").blur(function(){
        //alert("ggg");
        $.ajax({
           //json형태 {}
           url : "../idcheck.customer",
           data : {"id" : $("#cus_id").val()}, //앞이 key값 뒤가 value
           dataType : "text", //json,xml,text 셋 중 하나 선택
           success : function(data){
              if(data==1){
                 $("#msg").html("중복").css("color","red").css("font-size","70%").css("position","absolute");
                 console.log(data);
              }
              else if($("#cus_id").val()==""){
                 $("#msg").html("아이디 미입력.").css("color","black").css("font-size","70%").css("position","absolute");
              }
              else{
                 $("#msg").html("사용가능합니다.").css("color","blue").css("font-size","70%").css("position","fixed");
                 $idsuccess=1;
              }
           }, //성공하면 호출
           error : function(){
              console.log("error");
           } //실패하면 호출
        }); 
     });
   
    $("#cus_pw2").blur(function(){
        var password1 = $("#cus_pw").val();
        var password2 = $(this).val();
       if(password1== password2 & $("#cus_pw").val()!=""){
          $("#pwmsg").html("비밀번호 일치").css("color","blue").css("font-size","70%").css("position","fixed");
             $pwsuccess=1;
       }
       else if($("#cus_pw").val()==""){
          $("#pwmsg").html("비밀번호 미입력").css("color","black").css("font-size","70%").css("position","fixed");
       }
       else if($(this).val()==""){
          $("#pwmsg").html("비밀번호 미확인").css("color","red").css("font-size","70%").css("position","fixed");
       }
       
       else{
          $("#pwmsg").html("비밀번호 불일치").css("color","red").css("font-size","70%").css("position","fixed");
       }
    });
    
    $("#form1").on("submit",function(e){
       if($idsuccess==1 && $pwsuccess==1)
          $("#form1").submit();
       else{
          e.preventDefault();
          $("#submitmsg").html("잘못된 항목이 있습니다.")
       }
    })
})

</script>
<style>
@charset "utf-8";


html, body, form, fieldset, legend, ol, li {
   margin: 9px;
   padding: 0;
   }

body {
   background: #ffffff;
   color: #111111;
   font-family: 맑은고딕,굴림,돋움;
   text-align:center;
   display: flex;
  align-items: center;
  justify-content: center
      
}
#form {
   padding: 30px;
}

form {
    background: #ffffff;
   -moz-border-radius: 5px;
   -webkit-border-radius: 5px;
   -khtml-border-radius: 5px;
   border-radius: 5px;
   counter-reset: fieldsets;
   text-align:center;
   padding: 100px;
   width: 475px;   
   
}

      
form fieldset {
   border: solid;
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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>
</head>
<body>
<div id="form">
<a href="../home.jsp" style=""><img src="../logo/gongcycle1.png"></a>
<form action="../register.customer" id="form1">
<fieldset>
<legend style="font-size:200% ">회원가입</legend>
<ol>
  <li>
    <label for="userid">아이디</label>
    <input id="cus_id" name="id" type="text" value="test">
    <span id="msg"></span>
  </li>
  <li>
    <label for="pwd">비밀번호</label>
    <input id="cus_pw" name="pw" type="password">
  </li>
  <li>
     <label for="pwd2">비밀번호 확인</label>
     <input id="cus_pw2" name="pw2" type="password">
     <span id="pwmsg"></span>
  </li>
  <li>
    <label for="fullname">이름</label>
    <input id="cus_name" name="name" type="text" placeholder="5자미만 공백없이" >
  </li>
  <li> 
     <label for="gender">성별</label>
     <input type="radio" id="cus_gender" name="gender" value="M" checked>Male
    <input type="radio" id="cus_gender" name="gender" value="F">Female<br>
  </li>
  <li>
    <label for="tel">연락처</label>
    <input id="cus_call1" name="call1" type="tel" autocomplete="off" size="3" maxlength="3"> -
    <input id="cus_call2" name="call2" type="tel" autocomplete="off" size="4" maxlength="4"> -
    <input id="cus_call3" name="call3" type="tel" autocomplete="off" size="4" maxlength="4">
  </li>
  <li>
     <label for="add">주소</label>
     <input type="text" id="sample6_postcode" placeholder="우편번호" readonly>
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text"  name="add1" id="sample6_address" placeholder="주소" readonly>
<input type="text" name="add2"id="sample6_address2" placeholder="상세주소">


     
  </li>  
  </ol>
</fieldset>

  <button type="submit"> 제출 </button> 
  <span id="submitmsg"></span>

</form>
</div>

</body>
</html>