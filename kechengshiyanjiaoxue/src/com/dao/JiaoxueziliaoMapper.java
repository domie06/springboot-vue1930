package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiaoxueziliao;

public interface JiaoxueziliaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiaoxueziliao record);

    int insertSelective(Jiaoxueziliao record);

    Jiaoxueziliao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiaoxueziliao record);
	
    int updateByPrimaryKey(Jiaoxueziliao record);
	public Jiaoxueziliao quchongJiaoxueziliao(Map<String, Object> faburen);
	public List<Jiaoxueziliao> getAll(Map<String, Object> map);
	public List<Jiaoxueziliao> getsyjiaoxueziliao1(Map<String, Object> map);
	public List<Jiaoxueziliao> getsyjiaoxueziliao3(Map<String, Object> map);
	public List<Jiaoxueziliao> getsyjiaoxueziliao2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiaoxueziliao> getByPage(Map<String, Object> map);
	public List<Jiaoxueziliao> select(Map<String, Object> map);
//	所有List
}

