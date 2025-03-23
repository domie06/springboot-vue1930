<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="code" scope="page" class="com.util.CheckCode" />
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<title>课程实验教学系统</title>
		<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
	function hsgchecklogin() {
			if(document.f11.username.value=="" || document.f11.pwd.value=="" || document.f11.pagerandom.value=="")
	{
		alert("请输入完整");
		return false;
	}
	if (document.f11.pagerandom.value != document.f11.yzm.value) {
			alert("验证码错误！");
			document.f11.pagerandom.focus();
			return false;
	}
	
	}
	</script>


	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	
	background-repeat: repeat-x;
	background-color: #0092E5;
}

.STYLE7 {color: #000000; font-size:9pt;}
.STYLE8 {color: #0092E5}
-->
</style>

<body>
		<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="1441" height="743" border="0" align="center" cellpadding="0" cellspacing="0" background="images/login.jpg" id="__01">
  <tr>
    <td height="366" colspan="3" ><table width="95%" height="304" border="0" cellpadding="0" cellspacing="0">
      
      <tr>
        <td height="304" valign="bottom"><div style="font-family:宋体; color:#ffffff; WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE: 26px; margin-top:5pt">
      <div align="center" class="STYLE8" >课程实验教学系统</div>
    </div></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td width="314" rowspan="2">&nbsp;</td>
    <td width="352" height="176"><table width="205" border="0" align="center" cellpadding="0" cellspacing="0">
     <form name="f11" id="f11" method="post" action="hsgloginyanzheng.jsp">
        <tr>
          <td width="55" height="30"><span class="STYLE7">用&nbsp;&nbsp;户:</span></td>
          <td height="30" colspan="2"><input name="username" type="text" id="username" style="width:100px; height:20px; border:solid 1px #000000; color:#666666"></td>
        </tr>
        <tr>
          <td height="30"><span class="STYLE7">密&nbsp;&nbsp;码:</span></td>
          <td height="30" colspan="2"><input name="pwd" type="password" id="pwd" style="width:100px; height:20px; border:solid 1px #000000; color:#666666"></td>
        </tr>
        <tr>
          <td height="30"><span class="STYLE7">权&nbsp;&nbsp;限:</span></td>
          <td height="30" colspan="2"><select name="cx" id="cx" style="width:100px; height:20px; border:solid 1px #000000; color:#666666">
            <option value="管理员">管理员</option>
			<option value="学生">学生</option>                              <option value="教师">教师</option>                              <!--quxanxiaxndexnglxu-->
          </select>
            <input name="login" type="hidden" id="login" value="1"></td>
        </tr>
        <tr>
          <td height="30"><span class="STYLE7">验证码:</span></td>
          <td width="54" height="30"><input name="pagerandom" type="text" id="pagerandom" style=" height:20px; border:solid 1px #000000; color:#666666; width:45px;" ></td>
          <td width="96"><%
								String yzm=code.getCheckCode();
								%>  <input type="hidden" name="yzm" id="yzm" value="<%=yzm %>" >
								   <%=yzm %></td>
        </tr>
		 
        <tr>
          <td height="30" colspan="3"><input type="submit" name="Submit" value="登陆" onClick="return hsgchecklogin();">
                <input type="reset" name="Submit2" value="重置"></td>
        </tr>
      </form>
    </table></td>
    <td width="336" rowspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
</body>


	</body>
</html>
