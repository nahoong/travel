<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../js/jquery.mobile-1.1.1.min.js"></script>
<script src="../js/swipe.js"></script>
<style>
#gallery {
	background:#fff;
	width:100%;
	margin:auto;
	padding:0px 0px;
}
#slider {
	padding:0px 5px;
}
#slider li div {
	margin: 0px;
	padding: 0px;
	border-radius: 0px;
	border-top: 1px #fff solid;
	background: #F7F9FA;

	color: #DDE1E4;
	font-size: 12px;
	text-align: center;
	text-shadow: 0 1px 1px #fff;
	color: #A4AEB7;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<center>
<script>

	
$("#viewPage").on("pageshow", function(event){
	alert("hihi");
	// slider
	if($('#gallery2')){
		var slider = new Swipe(document.getElementById('sliderseoul2'), {
			callback: function(e, pos) {

				var i = bullets.length;
				while (i--) {
				bullets[i].className = ' ';
				}
				bullets[pos].className = 'on';

			},
			speed: 400,
			auto: 3000,
		});
	}
});
$(document).ready(function(){

});


</script>
<div id='viewPage' class='container'>
<div id="HMY_header_title">
  <ul style="margin:0 auto;">
    <li>광화문</li>
  </ul>
</div>
<div id="HMY_Mcontent">
    <div id='gallery2' style='width:50%; clear:both'>
      <div id='sliderseoul2'>
        <ul>

          <li style='display:block'>
            <img src='../photo/ghm1.PNG' width=100%>
          </li>

          <li style='display:none'>
            <img src='../photo/ghm.PNG' width=100%>
          </li>

          <li style='display:none'>
            <img src='../photo/ghm2.PNG' width=100%>
          </li>

          <li style='display:none'>
            <img src='../photo/ghm3.PNG' width=100%>
          </li>
          
        </ul>
      </div>
    </div>

    <div id="HMY_Sdetile01" style='text-align:left'>



          <div id='content'>경복궁의 정문으로 태조 4년에 창건되었다. 원래는 정도전에 의해 사정문, 오문으로 불리다가 세종 7년 집현전 학사들이 지금의 이름인 광화문으로 개칭했다. 석축기단(石築基壇) 건축기법에 3개의 홍예문을 만들고, 그 위에 정면 3칸으로 된 문루를 2층까지 쌓았다. 2층 문루에서는 바로 앞 세종로가 한눈에 내려다보인다. 부정한 사람을 뿔로 들이받는다는 상상 속 동물 해태 두 마리가 광화문 좌우에 놓여있다. <br />
            <br /> 옛 유적들이 숙명적으로 화마를 피하지 못했듯, 광화문 역시 임진왜란 때 소실되어 방치되다가 흥선대원군 때 재건됐으나, 일제강점기와 6·25 남북전쟁을 거치며 대부분 무너져 내렸다. 이후 철근콘크리트 구조로 복원되면서 전통적인 모습을 많이 상실했으나, 2006년 다시 한 번 원형에 가깝게 대대적으로 복원했다. <br />
            <br /> 현재 광화문은 섬세한 수법의 디테일이 잘 살아 있으며 웅장한 규모에, 전체적으로 균형과 조화를 이룬 외관이 수려해 현재 전하는 궐문 중 가장 뛰어난 것으로 평가받고 있다.<br />
            <br />
          </div>



</div>
</div>
</div>

</center>
</body>
</html>