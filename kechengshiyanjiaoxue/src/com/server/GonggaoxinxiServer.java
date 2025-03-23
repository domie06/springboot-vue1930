package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Gonggaoxinxi;

public interface GonggaoxinxiServer {

  public int add(Gonggaoxinxi po);

  public int update(Gonggaoxinxi po);
  
  
  
  public int delete(int id);

  public List<Gonggaoxinxi> getAll(Map<String,Object> map);
  public List<Gonggaoxinxi> getsygonggaoxinxi1(Map<String,Object> map);
  public List<Gonggaoxinxi> getsygonggaoxinxi2(Map<String,Object> map);
  public List<Gonggaoxinxi> getsygonggaoxinxi3(Map<String,Object> map);
  public Gonggaoxinxi quchongGonggaoxinxi(Map<String, Object> acount);

  public Gonggaoxinxi getById( int id);

  public List<Gonggaoxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Gonggaoxinxi> select(Map<String, Object> map);
}
//	所有List
