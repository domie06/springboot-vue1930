package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shiyanyuyue;

public interface ShiyanyuyueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shiyanyuyue record);

    int insertSelective(Shiyanyuyue record);

    Shiyanyuyue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shiyanyuyue record);
	
    int updateByPrimaryKey(Shiyanyuyue record);
	public Shiyanyuyue quchongShiyanyuyue(Map<String, Object> xuehao);
	public List<Shiyanyuyue> getAll(Map<String, Object> map);
	public List<Shiyanyuyue> getsyshiyanyuyue1(Map<String, Object> map);
	public List<Shiyanyuyue> getsyshiyanyuyue3(Map<String, Object> map);
	public List<Shiyanyuyue> getsyshiyanyuyue2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shiyanyuyue> getByPage(Map<String, Object> map);
	public List<Shiyanyuyue> select(Map<String, Object> map);
//	所有List
}

