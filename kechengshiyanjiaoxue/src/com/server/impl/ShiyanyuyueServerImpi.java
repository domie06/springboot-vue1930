package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShiyanyuyueMapper;
import com.entity.Shiyanyuyue;
import com.server.ShiyanyuyueServer;
@Service
public class ShiyanyuyueServerImpi implements ShiyanyuyueServer {
   @Resource
   private ShiyanyuyueMapper gdao;
	@Override
	public int add(Shiyanyuyue po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shiyanyuyue po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shiyanyuyue> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shiyanyuyue> getsyshiyanyuyue1(Map<String, Object> map) {
		return gdao.getsyshiyanyuyue1(map);
	}
	public List<Shiyanyuyue> getsyshiyanyuyue2(Map<String, Object> map) {
		return gdao.getsyshiyanyuyue2(map);
	}
	public List<Shiyanyuyue> getsyshiyanyuyue3(Map<String, Object> map) {
		return gdao.getsyshiyanyuyue3(map);
	}
	
	@Override
	public Shiyanyuyue quchongShiyanyuyue(Map<String, Object> account) {
		return gdao.quchongShiyanyuyue(account);
	}

	@Override
	public List<Shiyanyuyue> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shiyanyuyue> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shiyanyuyue getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

