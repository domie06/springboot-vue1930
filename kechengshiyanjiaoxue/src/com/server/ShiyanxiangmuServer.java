package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shiyanxiangmu;

public interface ShiyanxiangmuServer {

  public int add(Shiyanxiangmu po);

  public int update(Shiyanxiangmu po);
  
  
  
  public int delete(int id);

  public List<Shiyanxiangmu> getAll(Map<String,Object> map);
  public List<Shiyanxiangmu> getsyshiyanxiangmu1(Map<String,Object> map);
  public List<Shiyanxiangmu> getsyshiyanxiangmu2(Map<String,Object> map);
  public List<Shiyanxiangmu> getsyshiyanxiangmu3(Map<String,Object> map);
  public Shiyanxiangmu quchongShiyanxiangmu(Map<String, Object> acount);

  public Shiyanxiangmu getById( int id);

  public List<Shiyanxiangmu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shiyanxiangmu> select(Map<String, Object> map);
}
//	所有List
