<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>教学资料详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  教学资料详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${jiaoxueziliao.bianhao}</td>     <td width='11%'>名称：</td><td width='39%'>${jiaoxueziliao.mingcheng}</td></tr><tr>     <td width='11%'>类别：</td><td width='39%'>${jiaoxueziliao.leibie}</td>     <td width='11%'>简介：</td><td width='39%'>${jiaoxueziliao.jianjie}</td></tr><tr>     <td width='11%'>附件：</td><td width='39%'><a href="${jiaoxueziliao.fujian}">点此下载</a></td>     <td width='11%'>发布人：</td><td width='39%'>${jiaoxueziliao.faburen}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

