package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shiyanxiangmu;

public interface ShiyanxiangmuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shiyanxiangmu record);

    int insertSelective(Shiyanxiangmu record);

    Shiyanxiangmu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shiyanxiangmu record);
	
    int updateByPrimaryKey(Shiyanxiangmu record);
	public Shiyanxiangmu quchongShiyanxiangmu(Map<String, Object> zhidaolaoshi);
	public List<Shiyanxiangmu> getAll(Map<String, Object> map);
	public List<Shiyanxiangmu> getsyshiyanxiangmu1(Map<String, Object> map);
	public List<Shiyanxiangmu> getsyshiyanxiangmu3(Map<String, Object> map);
	public List<Shiyanxiangmu> getsyshiyanxiangmu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shiyanxiangmu> getByPage(Map<String, Object> map);
	public List<Shiyanxiangmu> select(Map<String, Object> map);
//	所有List
}

