package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShiyanxiangmuMapper;
import com.entity.Shiyanxiangmu;
import com.server.ShiyanxiangmuServer;
@Service
public class ShiyanxiangmuServerImpi implements ShiyanxiangmuServer {
   @Resource
   private ShiyanxiangmuMapper gdao;
	@Override
	public int add(Shiyanxiangmu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shiyanxiangmu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shiyanxiangmu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shiyanxiangmu> getsyshiyanxiangmu1(Map<String, Object> map) {
		return gdao.getsyshiyanxiangmu1(map);
	}
	public List<Shiyanxiangmu> getsyshiyanxiangmu2(Map<String, Object> map) {
		return gdao.getsyshiyanxiangmu2(map);
	}
	public List<Shiyanxiangmu> getsyshiyanxiangmu3(Map<String, Object> map) {
		return gdao.getsyshiyanxiangmu3(map);
	}
	
	@Override
	public Shiyanxiangmu quchongShiyanxiangmu(Map<String, Object> account) {
		return gdao.quchongShiyanxiangmu(account);
	}

	@Override
	public List<Shiyanxiangmu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shiyanxiangmu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shiyanxiangmu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

