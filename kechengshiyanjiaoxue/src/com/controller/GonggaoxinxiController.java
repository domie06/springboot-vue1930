package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Gonggaoxinxi;
import com.server.GonggaoxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class GonggaoxinxiController {
	@Resource
	private GonggaoxinxiServer gonggaoxinxiService;


   
	@RequestMapping("addGonggaoxinxi.do")
	public String addGonggaoxinxi(HttpServletRequest request,Gonggaoxinxi gonggaoxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		gonggaoxinxi.setAddtime(time.toString().substring(0, 19));
		gonggaoxinxiService.add(gonggaoxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "gonggaoxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:gonggaoxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateGonggaoxinxi.do")
	public String doUpdateGonggaoxinxi(int id,ModelMap map,Gonggaoxinxi gonggaoxinxi){
		gonggaoxinxi=gonggaoxinxiService.getById(id);
		map.put("gonggaoxinxi", gonggaoxinxi);
		return "gonggaoxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("gonggaoxinxiDetail.do")
	public String gonggaoxinxiDetail(int id,ModelMap map,Gonggaoxinxi gonggaoxinxi){
		gonggaoxinxi=gonggaoxinxiService.getById(id);
		map.put("gonggaoxinxi", gonggaoxinxi);
		return "gonggaoxinxi_detail";
	}
//	前台详细
	@RequestMapping("ggxxDetail.do")
	public String ggxxDetail(int id,ModelMap map,Gonggaoxinxi gonggaoxinxi){
		gonggaoxinxi=gonggaoxinxiService.getById(id);
		map.put("gonggaoxinxi", gonggaoxinxi);
		return "gonggaoxinxidetail";
	}
//	
	@RequestMapping("updateGonggaoxinxi.do")
	public String updateGonggaoxinxi(int id,ModelMap map,Gonggaoxinxi gonggaoxinxi,HttpServletRequest request,HttpSession session){
		gonggaoxinxiService.update(gonggaoxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:gonggaoxinxiList.do";
	}

//	分页查询
	@RequestMapping("gonggaoxinxiList.do")
	public String gonggaoxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gonggaoxinxi gonggaoxinxi, String biaoti, String neirong, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=gonggaoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gonggaoxinxi> list=gonggaoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gonggaoxinxi_list";
	}
	
	@RequestMapping("gonggaoxinxiList2.do")
	public String gonggaoxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gonggaoxinxi gonggaoxinxi, String biaoti, String neirong, String faburen,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("faburen", (String)request.getSession().getAttribute("username"));
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		
		
		int total=gonggaoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gonggaoxinxi> list=gonggaoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gonggaoxinxi_list2";
	}	
	
	@RequestMapping("ggxxList.do")
	public String ggxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gonggaoxinxi gonggaoxinxi, String biaoti, String neirong, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=gonggaoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gonggaoxinxi> list=gonggaoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gonggaoxinxilist";
	}
	
	@RequestMapping("deleteGonggaoxinxi.do")
	public String deleteGonggaoxinxi(int id,HttpServletRequest request){
		gonggaoxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:gonggaoxinxiList.do";
	}
	
	
}
