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

import com.entity.Shiyanyuyue;
import com.server.ShiyanyuyueServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShiyanyuyueController {
	@Resource
	private ShiyanyuyueServer shiyanyuyueService;


   
	@RequestMapping("addShiyanyuyue.do")
	public String addShiyanyuyue(HttpServletRequest request,Shiyanyuyue shiyanyuyue,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shiyanyuyue.setAddtime(time.toString().substring(0, 19));
		shiyanyuyueService.add(shiyanyuyue);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shiyanyuyueList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shiyanyuyueList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShiyanyuyue.do")
	public String doUpdateShiyanyuyue(int id,ModelMap map,Shiyanyuyue shiyanyuyue){
		shiyanyuyue=shiyanyuyueService.getById(id);
		map.put("shiyanyuyue", shiyanyuyue);
		return "shiyanyuyue_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shiyanyuyueDetail.do")
	public String shiyanyuyueDetail(int id,ModelMap map,Shiyanyuyue shiyanyuyue){
		shiyanyuyue=shiyanyuyueService.getById(id);
		map.put("shiyanyuyue", shiyanyuyue);
		return "shiyanyuyue_detail";
	}
//	前台详细
	@RequestMapping("syyyDetail.do")
	public String syyyDetail(int id,ModelMap map,Shiyanyuyue shiyanyuyue){
		shiyanyuyue=shiyanyuyueService.getById(id);
		map.put("shiyanyuyue", shiyanyuyue);
		return "shiyanyuyuedetail";
	}
//	
	@RequestMapping("updateShiyanyuyue.do")
	public String updateShiyanyuyue(int id,ModelMap map,Shiyanyuyue shiyanyuyue,HttpServletRequest request,HttpSession session){
		shiyanyuyueService.update(shiyanyuyue);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shiyanyuyueList.do";
	}

//	分页查询
	@RequestMapping("shiyanyuyueList.do")
	public String shiyanyuyueList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiyanyuyue shiyanyuyue, String xiangmubianhao, String shiyanmingcheng, String shiyanshijian, String zhidaolaoshi, String beizhu, String xuehao, String xingming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xiangmubianhao==null||xiangmubianhao.equals("")){pmap.put("xiangmubianhao", null);}else{pmap.put("xiangmubianhao", xiangmubianhao);}		if(shiyanmingcheng==null||shiyanmingcheng.equals("")){pmap.put("shiyanmingcheng", null);}else{pmap.put("shiyanmingcheng", shiyanmingcheng);}		if(shiyanshijian==null||shiyanshijian.equals("")){pmap.put("shiyanshijian", null);}else{pmap.put("shiyanshijian", shiyanshijian);}		if(zhidaolaoshi==null||zhidaolaoshi.equals("")){pmap.put("zhidaolaoshi", null);}else{pmap.put("zhidaolaoshi", zhidaolaoshi);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		int total=shiyanyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiyanyuyue> list=shiyanyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiyanyuyue_list";
	}
	
	@RequestMapping("shiyanyuyueList3.do")
	public String shiyanyuyueList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiyanyuyue shiyanyuyue, String xiangmubianhao, String shiyanmingcheng, String shiyanshijian, String zhidaolaoshi, String beizhu, String xuehao, String xingming, String issh,HttpServletRequest request){
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
		
		pmap.put("zhidaolaoshi", (String)request.getSession().getAttribute("username"));
		if(xiangmubianhao==null||xiangmubianhao.equals("")){pmap.put("xiangmubianhao", null);}else{pmap.put("xiangmubianhao", xiangmubianhao);}		if(shiyanmingcheng==null||shiyanmingcheng.equals("")){pmap.put("shiyanmingcheng", null);}else{pmap.put("shiyanmingcheng", shiyanmingcheng);}		if(shiyanshijian==null||shiyanshijian.equals("")){pmap.put("shiyanshijian", null);}else{pmap.put("shiyanshijian", shiyanshijian);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		
		int total=shiyanyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiyanyuyue> list=shiyanyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiyanyuyue_list3";
	}	@RequestMapping("shiyanyuyueList2.do")
	public String shiyanyuyueList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiyanyuyue shiyanyuyue, String xiangmubianhao, String shiyanmingcheng, String shiyanshijian, String zhidaolaoshi, String beizhu, String xuehao, String xingming, String issh,HttpServletRequest request){
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
		
		pmap.put("xuehao", (String)request.getSession().getAttribute("username"));
		if(xiangmubianhao==null||xiangmubianhao.equals("")){pmap.put("xiangmubianhao", null);}else{pmap.put("xiangmubianhao", xiangmubianhao);}		if(shiyanmingcheng==null||shiyanmingcheng.equals("")){pmap.put("shiyanmingcheng", null);}else{pmap.put("shiyanmingcheng", shiyanmingcheng);}		if(shiyanshijian==null||shiyanshijian.equals("")){pmap.put("shiyanshijian", null);}else{pmap.put("shiyanshijian", shiyanshijian);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		
		int total=shiyanyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiyanyuyue> list=shiyanyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiyanyuyue_list2";
	}	
	
	@RequestMapping("syyyList.do")
	public String syyyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiyanyuyue shiyanyuyue, String xiangmubianhao, String shiyanmingcheng, String shiyanshijian, String zhidaolaoshi, String beizhu, String xuehao, String xingming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xiangmubianhao==null||xiangmubianhao.equals("")){pmap.put("xiangmubianhao", null);}else{pmap.put("xiangmubianhao", xiangmubianhao);}		if(shiyanmingcheng==null||shiyanmingcheng.equals("")){pmap.put("shiyanmingcheng", null);}else{pmap.put("shiyanmingcheng", shiyanmingcheng);}		if(shiyanshijian==null||shiyanshijian.equals("")){pmap.put("shiyanshijian", null);}else{pmap.put("shiyanshijian", shiyanshijian);}		if(zhidaolaoshi==null||zhidaolaoshi.equals("")){pmap.put("zhidaolaoshi", null);}else{pmap.put("zhidaolaoshi", zhidaolaoshi);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		
		int total=shiyanyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiyanyuyue> list=shiyanyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiyanyuyuelist";
	}
	
	@RequestMapping("deleteShiyanyuyue.do")
	public String deleteShiyanyuyue(int id,HttpServletRequest request){
		shiyanyuyueService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shiyanyuyueList.do";
	}
	
	
}
