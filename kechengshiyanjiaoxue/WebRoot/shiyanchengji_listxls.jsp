<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shiyanchengjihsgb" scope="page" class="com.bean.ShiyanchengjiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shiyanchengji.xls");
%>
<html>
  <head>
    <title>实验成绩</title>
  </head>

  <body >
 <%
			String sql="select * from shiyanchengji  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>项目编号</td>    <td align='center'>实验名称</td>    <td align='center'>实验时间</td>    <td align='center'>指导老师</td>    <td align='center'>学号</td>    <td align='center'>姓名</td>    <td  width='90' align='center'>实验报告</td>        <td align='center'>学生成绩</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shiyanchengjihsgb.getAllShiyanchengji(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xiangmubianhao}</td>    <td>${u.shiyanmingcheng}</td>    <td>${u.shiyanshijian}</td>    <td>${u.zhidaolaoshi}</td>    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td width='90' align='center'><a href='${u.shiyanbaogao}' target='_blank'>下载</a></td>        <td>${u.xueshengchengji}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

