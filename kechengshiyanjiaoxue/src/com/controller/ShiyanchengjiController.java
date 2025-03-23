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

import com.entity.Shiyanchengji;
import com.server.ShiyanchengjiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShiyanchengjiController {
	@Resource
	private ShiyanchengjiServer shiyanchengjiService;


   
	@RequestMapping("addShiyanchengji.do")
	public String addShiyanchengji(HttpServletRequest request,Shiyanchengji shiyanchengji,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shiyanchengji.setAddtime(time.toString().substring(0, 19));
		shiyanchengjiService.add(shiyanchengji);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shiyanchengjiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shiyanchengjiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShiyanchengji.do")
	public String doUpdateShiyanchengji(int id,ModelMap map,Shiyanchengji shiyanchengji){
		shiyanchengji=shiyanchengjiService.getById(id);
		map.put("shiyanchengji", shiyanchengji);
		return "shiyanchengji_updt";
	}
	
	
	
	@RequestMapping("doUpdateShiyanchengjilb.do")
	public String doUpdateShiyanchengjilb(int id,ModelMap map,Shiyanchengji shiyanchengji){
		shiyanchengji=shiyanchengjiService.getById(id);
		map.put("shiyanchengji", shiyanchengji);
		return "shiyanchengji_updtlb";
	}
	
@RequestMapping("updateShiyanchengjilb.do")
	public String updateShiyanchengjilb(int id,ModelMap map,Shiyanchengji shiyanchengji){
		shiyanchengjiService.updatelb(shiyanchengji);
		return "redirect:shiyanchengjiList.do";
	}
	
//	后台详细
	@RequestMapping("shiyanchengjiDetail.do")
	public String shiyanchengjiDetail(int id,ModelMap map,Shiyanchengji shiyanchengji){
		shiyanchengji=shiyanchengjiService.getById(id);
		map.put("shiyanchengji", shiyanchengji);
		return "shiyanchengji_detail";
	}
//	前台详细
	@RequestMapping("sycjDetail.do")
	public String sycjDetail(int id,ModelMap map,Shiyanchengji shiyanchengji){
		shiyanchengji=shiyanchengjiService.getById(id);
		map.put("shiyanchengji", shiyanchengji);
		return "shiyanchengjidetail";
	}
//	
	@RequestMapping("updateShiyanchengji.do")
	public String updateShiyanchengji(int id,ModelMap map,Shiyanchengji shiyanchengji,HttpServletRequest request,HttpSession session){
		shiyanchengjiService.update(shiyanchengji);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shiyanchengjiList.do";
	}

//	分页查询
	@RequestMapping("shiyanchengjiList.do")
	public String shiyanchengjiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiyanchengji shiyanchengji, String xiangmubianhao, String shiyanmingcheng, String shiyanshijian, String zhidaolaoshi, String xuehao, String xingming, String shiyanbaogao, String shiyanxinde, String xueshengchengji, String laoshihuifu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xiangmubianhao==null||xiangmubianhao.equals("")){pmap.put("xiangmubianhao", null);}else{pmap.put("xiangmubianhao", xiangmubianhao);}		if(shiyanmingcheng==null||shiyanmingcheng.equals("")){pmap.put("shiyanmingcheng", null);}else{pmap.put("shiyanmingcheng", shiyanmingcheng);}		if(shiyanshijian==null||shiyanshijian.equals("")){pmap.put("shiyanshijian", null);}else{pmap.put("shiyanshijian", shiyanshijian);}		if(zhidaolaoshi==null||zhidaolaoshi.equals("")){pmap.put("zhidaolaoshi", null);}else{pmap.put("zhidaolaoshi", zhidaolaoshi);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shiyanbaogao==null||shiyanbaogao.equals("")){pmap.put("shiyanbaogao", null);}else{pmap.put("shiyanbaogao", shiyanbaogao);}		if(shiyanxinde==null||shiyanxinde.equals("")){pmap.put("shiyanxinde", null);}else{pmap.put("shiyanxinde", shiyanxinde);}		if(xueshengchengji==null||xueshengchengji.equals("")){pmap.put("xueshengchengji", null);}else{pmap.put("xueshengchengji", xueshengchengji);}		if(laoshihuifu==null||laoshihuifu.equals("")){pmap.put("laoshihuifu", null);}else{pmap.put("laoshihuifu", laoshihuifu);}		
		int total=shiyanchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiyanchengji> list=shiyanchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiyanchengji_list";
	}
	
	@RequestMapping("shiyanchengjiList3.do")
	public String shiyanchengjiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiyanchengji shiyanchengji, String xiangmubianhao, String shiyanmingcheng, String shiyanshijian, String zhidaolaoshi, String xuehao, String xingming, String shiyanbaogao, String shiyanxinde, String xueshengchengji, String laoshihuifu,HttpServletRequest request){
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
		if(xiangmubianhao==null||xiangmubianhao.equals("")){pmap.put("xiangmubianhao", null);}else{pmap.put("xiangmubianhao", xiangmubianhao);}		if(shiyanmingcheng==null||shiyanmingcheng.equals("")){pmap.put("shiyanmingcheng", null);}else{pmap.put("shiyanmingcheng", shiyanmingcheng);}		if(shiyanshijian==null||shiyanshijian.equals("")){pmap.put("shiyanshijian", null);}else{pmap.put("shiyanshijian", shiyanshijian);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shiyanbaogao==null||shiyanbaogao.equals("")){pmap.put("shiyanbaogao", null);}else{pmap.put("shiyanbaogao", shiyanbaogao);}		if(shiyanxinde==null||shiyanxinde.equals("")){pmap.put("shiyanxinde", null);}else{pmap.put("shiyanxinde", shiyanxinde);}		if(xueshengchengji==null||xueshengchengji.equals("")){pmap.put("xueshengchengji", null);}else{pmap.put("xueshengchengji", xueshengchengji);}		if(laoshihuifu==null||laoshihuifu.equals("")){pmap.put("laoshihuifu", null);}else{pmap.put("laoshihuifu", laoshihuifu);}		
		
		int total=shiyanchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiyanchengji> list=shiyanchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiyanchengji_list3";
	}	@RequestMapping("shiyanchengjiList2.do")
	public String shiyanchengjiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiyanchengji shiyanchengji, String xiangmubianhao, String shiyanmingcheng, String shiyanshijian, String zhidaolaoshi, String xuehao, String xingming, String shiyanbaogao, String shiyanxinde, String xueshengchengji, String laoshihuifu,HttpServletRequest request){
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
		if(xiangmubianhao==null||xiangmubianhao.equals("")){pmap.put("xiangmubianhao", null);}else{pmap.put("xiangmubianhao", xiangmubianhao);}		if(shiyanmingcheng==null||shiyanmingcheng.equals("")){pmap.put("shiyanmingcheng", null);}else{pmap.put("shiyanmingcheng", shiyanmingcheng);}		if(shiyanshijian==null||shiyanshijian.equals("")){pmap.put("shiyanshijian", null);}else{pmap.put("shiyanshijian", shiyanshijian);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shiyanbaogao==null||shiyanbaogao.equals("")){pmap.put("shiyanbaogao", null);}else{pmap.put("shiyanbaogao", shiyanbaogao);}		if(shiyanxinde==null||shiyanxinde.equals("")){pmap.put("shiyanxinde", null);}else{pmap.put("shiyanxinde", shiyanxinde);}		if(xueshengchengji==null||xueshengchengji.equals("")){pmap.put("xueshengchengji", null);}else{pmap.put("xueshengchengji", xueshengchengji);}		if(laoshihuifu==null||laoshihuifu.equals("")){pmap.put("laoshihuifu", null);}else{pmap.put("laoshihuifu", laoshihuifu);}		
		
		int total=shiyanchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiyanchengji> list=shiyanchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiyanchengji_list2";
	}	
	
	@RequestMapping("sycjList.do")
	public String sycjList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiyanchengji shiyanchengji, String xiangmubianhao, String shiyanmingcheng, String shiyanshijian, String zhidaolaoshi, String xuehao, String xingming, String shiyanbaogao, String shiyanxinde, String xueshengchengji, String laoshihuifu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xiangmubianhao==null||xiangmubianhao.equals("")){pmap.put("xiangmubianhao", null);}else{pmap.put("xiangmubianhao", xiangmubianhao);}		if(shiyanmingcheng==null||shiyanmingcheng.equals("")){pmap.put("shiyanmingcheng", null);}else{pmap.put("shiyanmingcheng", shiyanmingcheng);}		if(shiyanshijian==null||shiyanshijian.equals("")){pmap.put("shiyanshijian", null);}else{pmap.put("shiyanshijian", shiyanshijian);}		if(zhidaolaoshi==null||zhidaolaoshi.equals("")){pmap.put("zhidaolaoshi", null);}else{pmap.put("zhidaolaoshi", zhidaolaoshi);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shiyanbaogao==null||shiyanbaogao.equals("")){pmap.put("shiyanbaogao", null);}else{pmap.put("shiyanbaogao", shiyanbaogao);}		if(shiyanxinde==null||shiyanxinde.equals("")){pmap.put("shiyanxinde", null);}else{pmap.put("shiyanxinde", shiyanxinde);}		if(xueshengchengji==null||xueshengchengji.equals("")){pmap.put("xueshengchengji", null);}else{pmap.put("xueshengchengji", xueshengchengji);}		if(laoshihuifu==null||laoshihuifu.equals("")){pmap.put("laoshihuifu", null);}else{pmap.put("laoshihuifu", laoshihuifu);}		
		int total=shiyanchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiyanchengji> list=shiyanchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiyanchengjilist";
	}
	
	@RequestMapping("deleteShiyanchengji.do")
	public String deleteShiyanchengji(int id,HttpServletRequest request){
		shiyanchengjiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shiyanchengjiList.do";
	}
	
	
}
