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

import com.entity.Shiyanxiangmu;
import com.server.ShiyanxiangmuServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShiyanxiangmuController {
	@Resource
	private ShiyanxiangmuServer shiyanxiangmuService;


   
	@RequestMapping("addShiyanxiangmu.do")
	public String addShiyanxiangmu(HttpServletRequest request,Shiyanxiangmu shiyanxiangmu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shiyanxiangmu.setAddtime(time.toString().substring(0, 19));
		shiyanxiangmuService.add(shiyanxiangmu);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shiyanxiangmuList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shiyanxiangmuList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShiyanxiangmu.do")
	public String doUpdateShiyanxiangmu(int id,ModelMap map,Shiyanxiangmu shiyanxiangmu){
		shiyanxiangmu=shiyanxiangmuService.getById(id);
		map.put("shiyanxiangmu", shiyanxiangmu);
		return "shiyanxiangmu_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shiyanxiangmuDetail.do")
	public String shiyanxiangmuDetail(int id,ModelMap map,Shiyanxiangmu shiyanxiangmu){
		shiyanxiangmu=shiyanxiangmuService.getById(id);
		map.put("shiyanxiangmu", shiyanxiangmu);
		return "shiyanxiangmu_detail";
	}
//	前台详细
	@RequestMapping("syxmDetail.do")
	public String syxmDetail(int id,ModelMap map,Shiyanxiangmu shiyanxiangmu){
		shiyanxiangmu=shiyanxiangmuService.getById(id);
		map.put("shiyanxiangmu", shiyanxiangmu);
		return "shiyanxiangmudetail";
	}
//	
	@RequestMapping("updateShiyanxiangmu.do")
	public String updateShiyanxiangmu(int id,ModelMap map,Shiyanxiangmu shiyanxiangmu,HttpServletRequest request,HttpSession session){
		shiyanxiangmuService.update(shiyanxiangmu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shiyanxiangmuList.do";
	}

//	分页查询
	@RequestMapping("shiyanxiangmuList.do")
	public String shiyanxiangmuList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiyanxiangmu shiyanxiangmu, String xiangmubianhao, String shiyanmingcheng, String yanjiuketi, String yuqichengguo, String shiyanshijian1,String shiyanshijian2, String xiangmujianjie, String zhidaolaoshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xiangmubianhao==null||xiangmubianhao.equals("")){pmap.put("xiangmubianhao", null);}else{pmap.put("xiangmubianhao", xiangmubianhao);}		if(shiyanmingcheng==null||shiyanmingcheng.equals("")){pmap.put("shiyanmingcheng", null);}else{pmap.put("shiyanmingcheng", shiyanmingcheng);}		if(yanjiuketi==null||yanjiuketi.equals("")){pmap.put("yanjiuketi", null);}else{pmap.put("yanjiuketi", yanjiuketi);}		if(yuqichengguo==null||yuqichengguo.equals("")){pmap.put("yuqichengguo", null);}else{pmap.put("yuqichengguo", yuqichengguo);}		if(shiyanshijian1==null||shiyanshijian1.equals("")){pmap.put("shiyanshijian1", null);}else{pmap.put("shiyanshijian1", shiyanshijian1);}		if(shiyanshijian2==null||shiyanshijian2.equals("")){pmap.put("shiyanshijian2", null);}else{pmap.put("shiyanshijian2", shiyanshijian2);}		if(xiangmujianjie==null||xiangmujianjie.equals("")){pmap.put("xiangmujianjie", null);}else{pmap.put("xiangmujianjie", xiangmujianjie);}		if(zhidaolaoshi==null||zhidaolaoshi.equals("")){pmap.put("zhidaolaoshi", null);}else{pmap.put("zhidaolaoshi", zhidaolaoshi);}		
		int total=shiyanxiangmuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiyanxiangmu> list=shiyanxiangmuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiyanxiangmu_list";
	}
	
	@RequestMapping("shiyanxiangmuList2.do")
	public String shiyanxiangmuList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiyanxiangmu shiyanxiangmu, String xiangmubianhao, String shiyanmingcheng, String yanjiuketi, String yuqichengguo, String shiyanshijian1,String shiyanshijian2, String xiangmujianjie, String zhidaolaoshi,HttpServletRequest request){
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
		if(xiangmubianhao==null||xiangmubianhao.equals("")){pmap.put("xiangmubianhao", null);}else{pmap.put("xiangmubianhao", xiangmubianhao);}		if(shiyanmingcheng==null||shiyanmingcheng.equals("")){pmap.put("shiyanmingcheng", null);}else{pmap.put("shiyanmingcheng", shiyanmingcheng);}		if(yanjiuketi==null||yanjiuketi.equals("")){pmap.put("yanjiuketi", null);}else{pmap.put("yanjiuketi", yanjiuketi);}		if(yuqichengguo==null||yuqichengguo.equals("")){pmap.put("yuqichengguo", null);}else{pmap.put("yuqichengguo", yuqichengguo);}		if(shiyanshijian1==null||shiyanshijian1.equals("")){pmap.put("shiyanshijian1", null);}else{pmap.put("shiyanshijian1", shiyanshijian1);}		if(shiyanshijian2==null||shiyanshijian2.equals("")){pmap.put("shiyanshijian2", null);}else{pmap.put("shiyanshijian2", shiyanshijian2);}		if(xiangmujianjie==null||xiangmujianjie.equals("")){pmap.put("xiangmujianjie", null);}else{pmap.put("xiangmujianjie", xiangmujianjie);}		
		
		int total=shiyanxiangmuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiyanxiangmu> list=shiyanxiangmuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiyanxiangmu_list2";
	}	
	
	@RequestMapping("syxmList.do")
	public String syxmList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiyanxiangmu shiyanxiangmu, String xiangmubianhao, String shiyanmingcheng, String yanjiuketi, String yuqichengguo, String shiyanshijian1,String shiyanshijian2, String xiangmujianjie, String zhidaolaoshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xiangmubianhao==null||xiangmubianhao.equals("")){pmap.put("xiangmubianhao", null);}else{pmap.put("xiangmubianhao", xiangmubianhao);}		if(shiyanmingcheng==null||shiyanmingcheng.equals("")){pmap.put("shiyanmingcheng", null);}else{pmap.put("shiyanmingcheng", shiyanmingcheng);}		if(yanjiuketi==null||yanjiuketi.equals("")){pmap.put("yanjiuketi", null);}else{pmap.put("yanjiuketi", yanjiuketi);}		if(yuqichengguo==null||yuqichengguo.equals("")){pmap.put("yuqichengguo", null);}else{pmap.put("yuqichengguo", yuqichengguo);}		if(shiyanshijian1==null||shiyanshijian1.equals("")){pmap.put("shiyanshijian1", null);}else{pmap.put("shiyanshijian1", shiyanshijian1);}		if(shiyanshijian2==null||shiyanshijian2.equals("")){pmap.put("shiyanshijian2", null);}else{pmap.put("shiyanshijian2", shiyanshijian2);}		if(xiangmujianjie==null||xiangmujianjie.equals("")){pmap.put("xiangmujianjie", null);}else{pmap.put("xiangmujianjie", xiangmujianjie);}		if(zhidaolaoshi==null||zhidaolaoshi.equals("")){pmap.put("zhidaolaoshi", null);}else{pmap.put("zhidaolaoshi", zhidaolaoshi);}		
		int total=shiyanxiangmuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiyanxiangmu> list=shiyanxiangmuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiyanxiangmulist";
	}
	
	@RequestMapping("deleteShiyanxiangmu.do")
	public String deleteShiyanxiangmu(int id,HttpServletRequest request){
		shiyanxiangmuService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shiyanxiangmuList.do";
	}
	
	
}
