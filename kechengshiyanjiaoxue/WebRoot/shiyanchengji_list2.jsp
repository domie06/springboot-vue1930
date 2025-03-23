<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>实验成绩查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">实验成绩列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="shiyanchengjiList2.do" name="myform" method="post">
									查询   项目编号：<input name="xiangmubianhao" type="text" id="xiangmubianhao" style='border:solid 1px #000000; color:#666666' size="12" />  实验名称：<input name="shiyanmingcheng" type="text" id="shiyanmingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  实验时间：<input name="shiyanshijian" type="text" id="shiyanshijian" style='border:solid 1px #000000; color:#666666' size="12" />  学号：<input name="xuehao" type="text" id="xuehao" style='border:solid 1px #000000; color:#666666' size="12" />  姓名：<input name="xingming" type="text" id="xingming" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>项目编号</td>    <td align='center'>实验名称</td>    <td align='center'>实验时间</td>    <td align='center'>指导老师</td>    <td align='center'>学号</td>    <td align='center'>姓名</td>    <td  width='90' align='center'>实验报告</td>        <td align='center'>学生成绩</td>        
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.xiangmubianhao}</td>    <td>${u.shiyanmingcheng}</td>    <td>${u.shiyanshijian}</td>    <td>${u.zhidaolaoshi}</td>    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td width='90' align='center'><a href='${u.shiyanbaogao}' target='_blank'>下载</a></td>        <td>${u.xueshengchengji}</td>        
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateShiyanchengji.do?id=${u.id }">编辑</a>  <a href="deleteShiyanchengji.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="shiyanchengjiDetail.do?id=${u.id }">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from shiyanchengji where xuehao='"+(String)request.getSession().getAttribute("username")+"'  ";
				if(request.getParameter("xiangmubianhao")=="" ||request.getParameter("xiangmubianhao")==null ){}else{String nxiangmubianhao=new String(request.getParameter("xiangmubianhao").getBytes("8859_1"));if(nxiangmubianhao.contains("?")){nxiangmubianhao=request.getParameter("xiangmubianhao");}sql=sql+" and xiangmubianhao like '%"+nxiangmubianhao+"%'";}if(request.getParameter("shiyanmingcheng")=="" ||request.getParameter("shiyanmingcheng")==null ){}else{String nshiyanmingcheng=new String(request.getParameter("shiyanmingcheng").getBytes("8859_1"));if(nshiyanmingcheng.contains("?")){nshiyanmingcheng=request.getParameter("shiyanmingcheng");}sql=sql+" and shiyanmingcheng like '%"+nshiyanmingcheng+"%'";}if(request.getParameter("shiyanshijian")=="" ||request.getParameter("shiyanshijian")==null ){}else{String nshiyanshijian=new String(request.getParameter("shiyanshijian").getBytes("8859_1"));if(nshiyanshijian.contains("?")){nshiyanshijian=request.getParameter("shiyanshijian");}sql=sql+" and shiyanshijian like '%"+nshiyanshijian+"%'";}if(request.getParameter("xuehao")=="" ||request.getParameter("xuehao")==null ){}else{String nxuehao=new String(request.getParameter("xuehao").getBytes("8859_1"));if(nxuehao.contains("?")){nxuehao=request.getParameter("xuehao");}sql=sql+" and xuehao like '%"+nxuehao+"%'";}if(request.getParameter("xingming")=="" ||request.getParameter("xingming")==null ){}else{String nxingming=new String(request.getParameter("xingming").getBytes("8859_1"));if(nxingming.contains("?")){nxingming=request.getParameter("xingming");}sql=sql+" and xingming like '%"+nxingming+"%'";}
			sql+=" order by id desc";
double xueshengchengjiz=0;
							double zgfxueshengchengji=0;double zdfxueshengchengji=10000;
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						xueshengchengjiz=xueshengchengjiz+Float.valueOf(RS_result.getString("xueshengchengji")).floatValue();
						
						if(Float.valueOf(RS_result.getString("xueshengchengji")).floatValue()>zgfxueshengchengji){zgfxueshengchengji=Float.valueOf(RS_result.getString("xueshengchengji")).floatValue();}						if(Float.valueOf(RS_result.getString("xueshengchengji")).floatValue()<zdfxueshengchengji){zdfxueshengchengji=Float.valueOf(RS_result.getString("xueshengchengji")).floatValue();}						
			 }
			%>
		共计学生成绩:<%=xueshengchengjiz%>； 其中最高学生成绩：<%=zgfxueshengchengji%>；最低学生成绩：<%=zdfxueshengchengji%>；平均学生成绩：<%out.print(Math.round(1000*(xueshengchengjiz/i))/1000.0);%>；
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="shiyanchengjiList2.do?page=1" >首页</a>
             <a href="shiyanchengjiList2.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="shiyanchengjiList2.do?page=${page.page+1 }">下一页</a>
			<a href="shiyanchengjiList2.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
