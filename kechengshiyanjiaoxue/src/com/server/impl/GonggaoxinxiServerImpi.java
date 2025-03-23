package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GonggaoxinxiMapper;
import com.entity.Gonggaoxinxi;
import com.server.GonggaoxinxiServer;
@Service
public class GonggaoxinxiServerImpi implements GonggaoxinxiServer {
   @Resource
   private GonggaoxinxiMapper gdao;
	@Override
	public int add(Gonggaoxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Gonggaoxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Gonggaoxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Gonggaoxinxi> getsygonggaoxinxi1(Map<String, Object> map) {
		return gdao.getsygonggaoxinxi1(map);
	}
	public List<Gonggaoxinxi> getsygonggaoxinxi2(Map<String, Object> map) {
		return gdao.getsygonggaoxinxi2(map);
	}
	public List<Gonggaoxinxi> getsygonggaoxinxi3(Map<String, Object> map) {
		return gdao.getsygonggaoxinxi3(map);
	}
	
	@Override
	public Gonggaoxinxi quchongGonggaoxinxi(Map<String, Object> account) {
		return gdao.quchongGonggaoxinxi(account);
	}

	@Override
	public List<Gonggaoxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Gonggaoxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Gonggaoxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

