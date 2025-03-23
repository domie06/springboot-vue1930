<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>学生信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  学生信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>学号：</td><td width='39%'>${xueshengxinxi.xuehao}</td>     <td width='11%'>密码：</td><td width='39%'>${xueshengxinxi.mima}</td></tr><tr>     <td width='11%'>姓名：</td><td width='39%'>${xueshengxinxi.xingming}</td>     <td width='11%'>性别：</td><td width='39%'>${xueshengxinxi.xingbie}</td></tr><tr>     <td width='11%'>专业：</td><td width='39%'>${xueshengxinxi.zhuanye}</td>     <td width='11%'>院系：</td><td width='39%'>${xueshengxinxi.yuanxi}</td></tr><tr>     <td width='11%'>备注：</td><td width='39%'>${xueshengxinxi.beizhu}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

