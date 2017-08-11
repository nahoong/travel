<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>

<style>


#sse2
{

    background-color: #222;
    height: 38px;
    padding: 15px;
    border-radius: 6px;
    box-sizing: content-box;
}
#sses2
{
    margin:0 auto;
}
#sses2 ul 
{ 
    position: relative;
    list-style-type: none;
    float:left;
    padding:0;margin:0;
}
#sses2 li
{
    float:left;
    list-style-type: none;
    padding:0;margin:0;background-image:none;
}
/*CSS for background bubble*/
#sses2 li.highlight
{
    background:#036 url(mb2_2.gif) no-repeat center bottom;
    top:0px;
    height:30px;
    border-radius: 8px;
    -moz-border-radius: 8px;
    -webkit-border-radius: 8px;
    z-index: 1;
    position: absolute;
    overflow:hidden;
}
#sses2 li a
{
    height:30px;
    padding-top: 8px;
    margin: 0 20px;
    color: #fff;
    font: normal 19px arial;
    text-align: center;
    text-decoration: none;
    float: left;
    display: block;
    position: relative;
    z-index: 2;
}

.ct-btn {
	display: inline-block;
	margin: 1px 0;
	padding: .5em .25em;
	border-radius: .25em;
	box-sizing: content-box;
	-moz-box-sizing: content-box;
	background: transparent;
	outline: 0;
	vertical-align: middle;
	font-family: inherit;
	font-size: 17px;
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

</style>
<script>


/*! Visit www.menucool.com for source code, other menu scripts and web UI controls
*  Please keep this notice intact. Thank you. */

var sse2 = function () {
    var rebound = 20; //set it to 0 if rebound effect is not prefered
    var slip, k;
    return {
        buildMenu: function () {
            var m = document.getElementById('sses2');
            if (!m) return;
            var ul = m.getElementsByTagName("ul")[0];
            m.style.width = ul.offsetWidth + 1 + "px";
            var items = m.getElementsByTagName("li");
            var a = m.getElementsByTagName("a");

            slip = document.createElement("li");
            slip.className = "highlight";
            ul.appendChild(slip);

            var url = document.location.href.toLowerCase();
            k = -1;
            var nLength = -1;
            for (var i = 0; i < a.length; i++) {
                if (url.indexOf(a[i].href.toLowerCase()) != -1 && a[i].href.length > nLength) {
                    k = i;
                    nLength = a[i].href.length;
                }
            }

            if (k == -1 && /:\/\/(?:www\.)?[^.\/]+?\.[^.\/]+\/?$/.test) {
                for (var i = 0; i < a.length; i++) {
                    if (a[i].getAttribute("maptopuredomain") == "true") {
                        k = i;
                        break;
                    }
                }
                if (k == -1 && a[0].getAttribute("maptopuredomain") != "false")
                    k = 0;
            }
            if (k > -1) {
                slip.style.width = items[k].offsetWidth + "px";
                //slip.style.left = items[k].offsetLeft + "px";
                sse2.move(items[k]); //comment out this line and uncomment the line above to disable initial animation
            }
            else {
                slip.style.visibility = "hidden";
            }

            for (var i = 0; i < items.length - 1; i++) {
                items[i].onmouseover = function () {
                    if (k == -1) slip.style.visibility = "visible";
                    if (this.offsetLeft != slip.offsetLeft) {
                        sse2.move(this);
                    }
                }
            }

            m.onmouseover = function () {
                if (slip.t2)
                    slip.t2 = clearTimeout(slip.t2);
            };

            m.onmouseout = function () {
                if (k > -1 && items[k].offsetLeft != slip.offsetLeft) {
                    slip.t2 = setTimeout(function () { sse2.move(items[k]); }, 50);
                }
                if (k == -1) slip.t2 = setTimeout(function () { slip.style.visibility = "hidden"; }, 50);
            };
        },
        move: function (target) {
            clearInterval(slip.timer);
            var direction = (slip.offsetLeft < target.offsetLeft) ? 1 : -1;
            slip.timer = setInterval(function () { sse2.mv(target, direction); }, 15);
        },
        mv: function (target, direction) {
            if (direction == 1) {
                if (slip.offsetLeft - rebound < target.offsetLeft)
                    this.changePosition(target, 1);
                else {
                    clearInterval(slip.timer);
                    slip.timer = setInterval(function () {
                        sse2.recoil(target, 1);
                    }, 15);
                }
            }
            else {
                if (slip.offsetLeft + rebound > target.offsetLeft)
                    this.changePosition(target, -1);
                else {
                    clearInterval(slip.timer);
                    slip.timer = setInterval(function () {
                        sse2.recoil(target, -1);
                    }, 15);
                }
            }
            this.changeWidth(target);
        },
        recoil: function (target, direction) {
            if (direction == -1) {
                if (slip.offsetLeft > target.offsetLeft) {
                    slip.style.left = target.offsetLeft + "px";
                    clearInterval(slip.timer);
                }
                else slip.style.left = slip.offsetLeft + 2 + "px";
            }
            else {
                if (slip.offsetLeft < target.offsetLeft) {
                    slip.style.left = target.offsetLeft + "px";
                    clearInterval(slip.timer);
                }
                else slip.style.left = slip.offsetLeft - 2 + "px";
            }
        },
        changePosition: function (target, direction) {
            if (direction == 1) {
                //following +1 will fix the IE8 bug of x+1=x, we force it to x+2
                slip.style.left = slip.offsetLeft + Math.ceil(Math.abs(target.offsetLeft - slip.offsetLeft + rebound) / 10) + 1 + "px";
            }
            else {
                //following -1 will fix the Opera bug of x-1=x, we force it to x-2
                slip.style.left = slip.offsetLeft - Math.ceil(Math.abs(slip.offsetLeft - target.offsetLeft + rebound) / 10) - 1 + "px";
            }
        },
        changeWidth: function (target) {
            if (slip.offsetWidth != target.offsetWidth) {
                var diff = slip.offsetWidth - target.offsetWidth;
                if (Math.abs(diff) < 4) slip.style.width = target.offsetWidth + "px";
                else slip.style.width = slip.offsetWidth - Math.round(diff / 3) + "px";
            }
        }
    };
} ();

if (window.addEventListener) {
    window.addEventListener("load", sse2.buildMenu, false);
}
else if (window.attachEvent) {
    window.attachEvent("onload", sse2.buildMenu);
}
else {
    window["onload"] = sse2.buildMenu;
}

</script>
  <body>

  	<a href="<%=request.getContextPath()%>/home.jsp" style="position:absolute;"> <img src="<%=request.getContextPath()%>/logo/gongcycl.png" ></a>
<div id="sse2">
  <div id="sses2">
 	
    <ul>
    
   <li><a href="<%=request.getContextPath()%>/list.product?type=aa">나들이갈때호</a></li>
   <li><a href="<%=request.getContextPath()%>/list.product?type=bb">산악하이킹허</a></li>
   <li><a href="<%=request.getContextPath()%>/list.product?type=cc">레이씽씽홓홓</a></li>
   <%
   String id =(String)session.getAttribute("id");
   if(id != null)
   {
   %>
    <li><a href="<%=request.getContextPath()%>/product/product.jsp" style="color:yellow"> 등 록 </a></li>
 <%} %>
    </ul>
    
    <br>
    <br>
    <br>
    <br>
  </div>
</div>

  </body>

  </html>