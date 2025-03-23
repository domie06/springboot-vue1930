<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>实验成绩详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  实验成绩详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>项目编号：</td><td width='39%'>${shiyanchengji.xiangmubianhao}</td>     <td width='11%'>实验名称：</td><td width='39%'>${shiyanchengji.shiyanmingcheng}</td></tr><tr>     <td width='11%'>实验时间：</td><td width='39%'>${shiyanchengji.shiyanshijian}</td>     <td width='11%'>指导老师：</td><td width='39%'>${shiyanchengji.zhidaolaoshi}</td></tr><tr>     <td width='11%'>学号：</td><td width='39%'>${shiyanchengji.xuehao}</td>     <td width='11%'>姓名：</td><td width='39%'>${shiyanchengji.xingming}</td></tr><tr>     <td width='11%'>实验报告：</td><td width='39%'><a href="${shiyanchengji.shiyanbaogao}">点此下载</a></td>     <td width='11%'>实验心得：</td><td width='39%'>${shiyanchengji.shiyanxinde}</td></tr><tr>     <td width='11%'>学生成绩：</td><td width='39%'>${shiyanchengji.xueshengchengji}</td>     <td width='11%'>老师回复：</td><td width='39%'>${shiyanchengji.laoshihuifu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

