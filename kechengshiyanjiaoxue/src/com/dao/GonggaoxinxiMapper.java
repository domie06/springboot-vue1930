package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Gonggaoxinxi;

public interface GonggaoxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gonggaoxinxi record);

    int insertSelective(Gonggaoxinxi record);

    Gonggaoxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gonggaoxinxi record);
	
    int updateByPrimaryKey(Gonggaoxinxi record);
	public Gonggaoxinxi quchongGonggaoxinxi(Map<String, Object> faburen);
	public List<Gonggaoxinxi> getAll(Map<String, Object> map);
	public List<Gonggaoxinxi> getsygonggaoxinxi1(Map<String, Object> map);
	public List<Gonggaoxinxi> getsygonggaoxinxi3(Map<String, Object> map);
	public List<Gonggaoxinxi> getsygonggaoxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Gonggaoxinxi> getByPage(Map<String, Object> map);
	public List<Gonggaoxinxi> select(Map<String, Object> map);
//	所有List
}

