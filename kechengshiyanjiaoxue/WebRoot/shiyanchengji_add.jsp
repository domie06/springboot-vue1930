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
		<TITLE>添加实验记录</TITLE>
	    

 	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>      
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="shiyanchengji_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addShiyanchengji.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加实验成绩</td>
						</tr>
						<tr ><td width="200">项目编号：</td><td><input name='xiangmubianhao' type='text' id='xiangmubianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.xiangmubianhao.value='<%=connDbBean.readzd("shiyanyuyue","xiangmubianhao","id",request.getParameter("id"))%>';document.form1.xiangmubianhao.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">实验名称：</td><td><input name='shiyanmingcheng' type='text' id='shiyanmingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.shiyanmingcheng.value='<%=connDbBean.readzd("shiyanyuyue","shiyanmingcheng","id",request.getParameter("id"))%>';document.form1.shiyanmingcheng.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">实验时间：</td><td><input name='shiyanshijian' type='text' id='shiyanshijian' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.shiyanshijian.value='<%=connDbBean.readzd("shiyanyuyue","shiyanshijian","id",request.getParameter("id"))%>';document.form1.shiyanshijian.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">指导老师：</td><td><input name='zhidaolaoshi' type='text' id='zhidaolaoshi' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.zhidaolaoshi.value='<%=connDbBean.readzd("shiyanyuyue","zhidaolaoshi","id",request.getParameter("id"))%>';document.form1.zhidaolaoshi.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">学号：</td><td><input name='xuehao' type='text' id='xuehao' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly"  readonly='readonly' /></td></tr><script language="javascript">document.form1.xuehao.value='<%=connDbBean.readzd("shiyanyuyue","xuehao","id",request.getParameter("id"))%>';document.form1.xuehao.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("shiyanyuyue","xingming","id",request.getParameter("id"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">实验报告：</td><td><input name='shiyanbaogao' type='text' id='shiyanbaogao' size='50' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('shiyanbaogao')" style='border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelshiyanbaogao' /></td></tr>
		<tr ><td width="200">实验心得：</td><td><textarea name='shiyanxinde' cols='50' rows='5' id='shiyanxinde' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		<tr style='display:none'><td width="200">学生成绩：</td><td><input name='xueshengchengji' type='text' id='xueshengchengji' value='0' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr style='display:none' 0><td width="200">老师回复：</td><td><textarea name='laoshihuifu' cols='50' rows='5' id='laoshihuifu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var shiyanbaogaoobj = document.getElementById("shiyanbaogao"); if(shiyanbaogaoobj.value==""){document.getElementById("clabelshiyanbaogao").innerHTML="&nbsp;&nbsp;<font color=red>请输入实验报告</font>";return false;}else{document.getElementById("clabelshiyanbaogao").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  
