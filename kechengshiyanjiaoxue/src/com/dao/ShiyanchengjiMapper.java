package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shiyanchengji;

public interface ShiyanchengjiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shiyanchengji record);

    int insertSelective(Shiyanchengji record);

    Shiyanchengji selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shiyanchengji record);
	int updateByPrimaryKeySelectivelb(Shiyanchengji record);
    int updateByPrimaryKey(Shiyanchengji record);
	public Shiyanchengji quchongShiyanchengji(Map<String, Object> xuehao);
	public List<Shiyanchengji> getAll(Map<String, Object> map);
	public List<Shiyanchengji> getsyshiyanchengji1(Map<String, Object> map);
	public List<Shiyanchengji> getsyshiyanchengji3(Map<String, Object> map);
	public List<Shiyanchengji> getsyshiyanchengji2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shiyanchengji> getByPage(Map<String, Object> map);
	public List<Shiyanchengji> select(Map<String, Object> map);
//	所有List
}

