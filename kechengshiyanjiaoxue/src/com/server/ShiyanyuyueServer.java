package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shiyanyuyue;

public interface ShiyanyuyueServer {

  public int add(Shiyanyuyue po);

  public int update(Shiyanyuyue po);
  
  
  
  public int delete(int id);

  public List<Shiyanyuyue> getAll(Map<String,Object> map);
  public List<Shiyanyuyue> getsyshiyanyuyue1(Map<String,Object> map);
  public List<Shiyanyuyue> getsyshiyanyuyue2(Map<String,Object> map);
  public List<Shiyanyuyue> getsyshiyanyuyue3(Map<String,Object> map);
  public Shiyanyuyue quchongShiyanyuyue(Map<String, Object> acount);

  public Shiyanyuyue getById( int id);

  public List<Shiyanyuyue> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shiyanyuyue> select(Map<String, Object> map);
}
//	所有List
