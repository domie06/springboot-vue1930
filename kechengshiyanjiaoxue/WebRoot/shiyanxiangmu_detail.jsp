<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>实验项目详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  实验项目详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>项目编号：</td><td width='39%'>${shiyanxiangmu.xiangmubianhao}</td>     <td width='11%'>实验名称：</td><td width='39%'>${shiyanxiangmu.shiyanmingcheng}</td></tr><tr>     <td width='11%'>研究课题：</td><td width='39%'>${shiyanxiangmu.yanjiuketi}</td>     <td width='11%'>预期成果：</td><td width='39%'>${shiyanxiangmu.yuqichengguo}</td></tr><tr>     <td width='11%'>实验时间：</td><td width='39%'>${shiyanxiangmu.shiyanshijian}</td>     <td width='11%'>项目简介：</td><td width='39%'>${shiyanxiangmu.xiangmujianjie}</td></tr><tr>     <td width='11%'>指导老师：</td><td width='39%'>${shiyanxiangmu.zhidaolaoshi}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

