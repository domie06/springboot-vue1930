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

import com.entity.Jiaoxueziliao;
import com.server.JiaoxueziliaoServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JiaoxueziliaoController {
	@Resource
	private JiaoxueziliaoServer jiaoxueziliaoService;


   
	@RequestMapping("addJiaoxueziliao.do")
	public String addJiaoxueziliao(HttpServletRequest request,Jiaoxueziliao jiaoxueziliao,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jiaoxueziliao.setAddtime(time.toString().substring(0, 19));
		jiaoxueziliaoService.add(jiaoxueziliao);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jiaoxueziliaoList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jiaoxueziliaoList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJiaoxueziliao.do")
	public String doUpdateJiaoxueziliao(int id,ModelMap map,Jiaoxueziliao jiaoxueziliao){
		jiaoxueziliao=jiaoxueziliaoService.getById(id);
		map.put("jiaoxueziliao", jiaoxueziliao);
		return "jiaoxueziliao_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jiaoxueziliaoDetail.do")
	public String jiaoxueziliaoDetail(int id,ModelMap map,Jiaoxueziliao jiaoxueziliao){
		jiaoxueziliao=jiaoxueziliaoService.getById(id);
		map.put("jiaoxueziliao", jiaoxueziliao);
		return "jiaoxueziliao_detail";
	}
//	前台详细
	@RequestMapping("jxzlDetail.do")
	public String jxzlDetail(int id,ModelMap map,Jiaoxueziliao jiaoxueziliao){
		jiaoxueziliao=jiaoxueziliaoService.getById(id);
		map.put("jiaoxueziliao", jiaoxueziliao);
		return "jiaoxueziliaodetail";
	}
//	
	@RequestMapping("updateJiaoxueziliao.do")
	public String updateJiaoxueziliao(int id,ModelMap map,Jiaoxueziliao jiaoxueziliao,HttpServletRequest request,HttpSession session){
		jiaoxueziliaoService.update(jiaoxueziliao);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jiaoxueziliaoList.do";
	}

//	分页查询
	@RequestMapping("jiaoxueziliaoList.do")
	public String jiaoxueziliaoList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoxueziliao jiaoxueziliao, String bianhao, String mingcheng, String leibie, String jianjie, String fujian, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=jiaoxueziliaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoxueziliao> list=jiaoxueziliaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoxueziliao_list";
	}
	
	@RequestMapping("jiaoxueziliaoList2.do")
	public String jiaoxueziliaoList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoxueziliao jiaoxueziliao, String bianhao, String mingcheng, String leibie, String jianjie, String fujian, String faburen,HttpServletRequest request){
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
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}		
		
		int total=jiaoxueziliaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoxueziliao> list=jiaoxueziliaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoxueziliao_list2";
	}	
	
	@RequestMapping("jxzlList.do")
	public String jxzlList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoxueziliao jiaoxueziliao, String bianhao, String mingcheng, String leibie, String jianjie, String fujian, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=jiaoxueziliaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoxueziliao> list=jiaoxueziliaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoxueziliaolist";
	}
	
	@RequestMapping("deleteJiaoxueziliao.do")
	public String deleteJiaoxueziliao(int id,HttpServletRequest request){
		jiaoxueziliaoService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jiaoxueziliaoList.do";
	}
	
	
}
