package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShiyanchengjiMapper;
import com.entity.Shiyanchengji;
import com.server.ShiyanchengjiServer;
@Service
public class ShiyanchengjiServerImpi implements ShiyanchengjiServer {
   @Resource
   private ShiyanchengjiMapper gdao;
	@Override
	public int add(Shiyanchengji po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shiyanchengji po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Shiyanchengji po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shiyanchengji> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shiyanchengji> getsyshiyanchengji1(Map<String, Object> map) {
		return gdao.getsyshiyanchengji1(map);
	}
	public List<Shiyanchengji> getsyshiyanchengji2(Map<String, Object> map) {
		return gdao.getsyshiyanchengji2(map);
	}
	public List<Shiyanchengji> getsyshiyanchengji3(Map<String, Object> map) {
		return gdao.getsyshiyanchengji3(map);
	}
	
	@Override
	public Shiyanchengji quchongShiyanchengji(Map<String, Object> account) {
		return gdao.quchongShiyanchengji(account);
	}

	@Override
	public List<Shiyanchengji> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shiyanchengji> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shiyanchengji getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

