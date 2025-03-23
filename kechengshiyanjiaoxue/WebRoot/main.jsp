<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>主页面</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/productlist.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>

<body class="withvernav">
<div class="bodywrapper">
    <div class="topheader">
        <div class="left">
            <h1 class="logo"><span>课程实验教学系统</span></h1>
            <span class="slogan"></span>
          
            
            <br clear="all" />
        </div><!--left-->
        
        <div class="right">
        	<div class="notification">
			<font color="white">当前用户：<%=request.getSession().getAttribute("username")%>&nbsp;&nbsp;权限：<%=request.getSession().getAttribute("cx")%></font>
                     	</div>  <a href="logout.jsp" onclick="return confirm('确定要退出？')">&nbsp;&nbsp;<font color="white">退出</font></a> 
           <!--userinfo-->
            
            <div class="userinfodrop">            	<div class="avatar">
                	<a href=""><img src="images/thumbs/avatarbig.png" alt="" /></a>
                    <div class="changetheme">
                    	Change theme: <br />
                    	<a class="default"></a>
                        <a class="blueline"></a>
                        <a class="greenline"></a>
                        <a class="contrast"></a>                    </div>
                </div><!--avatar-->
<div class="userdata">
                	<h4>更换肤色</h4>
                    <span class="email">请选择左侧彩色小方按钮</span>                </div><!--userdata-->
            </div><!--userinfodrop-->
        </div><!--right-->
    </div>
    <!--topheader-->
    
    
    <div class="header">
    	<ul class="headermenu">
        	<li><a href="sy.jsp" target="main"><span class="icon icon-flatscreen"></span>显示桌面</a></li>
            <li><a href="allusersList.do" target="main"><span class="icon icon-pencil"></span>管理员用户</a></li>
          <!--  <li><a href="messages.html"><span class="icon icon-message"></span>使用帮助</a></li>
            <li><a href="reports.html"><span class="icon icon-chart"></span>Reports</a></li>-->
        </ul>
        
        <div class="headerwidget">
        	<div class="earnings">
            
                	<h4>当前时间</h4>
                    <h2>
					
					<script>
function tick() {
var ye,mo,da
var hours, minutes, seconds, xfile;
var intHours, intMinutes, intSeconds;
var today;
today = new Date();
ye = today.getFullYear();
mo = today.getMonth()+1;
if (mo < 10) {
mo = "0"+mo;
}
da = today.getDate();
if (da < 10) {
da = "0"+da;
}
intHours = today.getHours();
intMinutes = today.getMinutes();
intSeconds = today.getSeconds();
if (intHours == 0) {
hours = "12:";
xfile = "PM";//午夜
} else if (intHours < 12) {
hours = intHours+":";
xfile = "AM";//上午
} else if (intHours == 12) {
hours = "12:";
xfile = "PM";//正午
} else {
intHours = intHours - 12
hours = intHours + ":";
xfile = "PM";//下午
}
if (intHours < 10) {
hours = "0"+intHours+":";
}
if (intMinutes < 10) {
minutes = "0"+intMinutes+":";
} else {
minutes = intMinutes+":";
}
if (intSeconds < 10) {
seconds = "0"+intSeconds+" ";
} else {
seconds = intSeconds+" ";
}
var color, size, face, out;
	var text = "black";
	var font_size = 1;
    var font_face = "Arial";
	color = (text)? text : "black";
	size = (font_size)? font_size : 1;
	face = (font_face)? font_face : "Arial";
timeString = "<font style='font-size:14px;'>";
timeString += ye+"-"+mo+"-"+da+"  ";
timeString += hours+minutes+seconds+" "+xfile+"&nbsp;&nbsp;&nbsp;";

Clock.innerHTML = timeString;
window.setTimeout("tick();", 100);
}
window.onload = tick;
</script>
<font id="Clock"
      
      align=center>	  </font></h2>
            </div><!--earnings-->
        </div><!--headerwidget-->
    </div>
    <!--header-->
   
   <%
	
	if (request.getSession().getAttribute("cx").equals("超级管理员") || request.getSession().getAttribute("cx").equals("普通管理员"))
	{
		%>
		<%@ include file="left.jsp"%>
		<%
	}
	if(request.getSession().getAttribute("cx").equals("教师")  )
	{
		%>
		<%@ include file="left2.jsp"%>
		<%
	}
	if(request.getSession().getAttribute("cx").equals("学生")  )
	{
		%>
		<%@ include file="left3.jsp"%>
		<%
	}
	
	%><!--leftmenu-->
        
    <div class="centercontent">
    <iframe name="main"  src="sy.jsp" runat="server" id="contents"  style="height:83%; vertical-align: middle; text-align: center;" width="100%" marginheight="5" marginwidth="5"></iframe>
	</div>
    <!-- centercontent -->
    
    
</div><!--bodywrapper-->

</body>
</html>
