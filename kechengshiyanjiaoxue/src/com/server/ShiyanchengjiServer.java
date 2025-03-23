package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shiyanchengji;

public interface ShiyanchengjiServer {

  public int add(Shiyanchengji po);

  public int update(Shiyanchengji po);
  
  public int updatelb(Shiyanchengji po);
  
  public int delete(int id);

  public List<Shiyanchengji> getAll(Map<String,Object> map);
  public List<Shiyanchengji> getsyshiyanchengji1(Map<String,Object> map);
  public List<Shiyanchengji> getsyshiyanchengji2(Map<String,Object> map);
  public List<Shiyanchengji> getsyshiyanchengji3(Map<String,Object> map);
  public Shiyanchengji quchongShiyanchengji(Map<String, Object> acount);

  public Shiyanchengji getById( int id);

  public List<Shiyanchengji> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shiyanchengji> select(Map<String, Object> map);
}
//	所有List
