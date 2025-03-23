package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiaoxueziliaoMapper;
import com.entity.Jiaoxueziliao;
import com.server.JiaoxueziliaoServer;
@Service
public class JiaoxueziliaoServerImpi implements JiaoxueziliaoServer {
   @Resource
   private JiaoxueziliaoMapper gdao;
	@Override
	public int add(Jiaoxueziliao po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiaoxueziliao po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiaoxueziliao> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiaoxueziliao> getsyjiaoxueziliao1(Map<String, Object> map) {
		return gdao.getsyjiaoxueziliao1(map);
	}
	public List<Jiaoxueziliao> getsyjiaoxueziliao2(Map<String, Object> map) {
		return gdao.getsyjiaoxueziliao2(map);
	}
	public List<Jiaoxueziliao> getsyjiaoxueziliao3(Map<String, Object> map) {
		return gdao.getsyjiaoxueziliao3(map);
	}
	
	@Override
	public Jiaoxueziliao quchongJiaoxueziliao(Map<String, Object> account) {
		return gdao.quchongJiaoxueziliao(account);
	}

	@Override
	public List<Jiaoxueziliao> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiaoxueziliao> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiaoxueziliao getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

