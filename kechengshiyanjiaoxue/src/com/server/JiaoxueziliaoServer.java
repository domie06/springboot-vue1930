package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiaoxueziliao;

public interface JiaoxueziliaoServer {

  public int add(Jiaoxueziliao po);

  public int update(Jiaoxueziliao po);
  
  
  
  public int delete(int id);

  public List<Jiaoxueziliao> getAll(Map<String,Object> map);
  public List<Jiaoxueziliao> getsyjiaoxueziliao1(Map<String,Object> map);
  public List<Jiaoxueziliao> getsyjiaoxueziliao2(Map<String,Object> map);
  public List<Jiaoxueziliao> getsyjiaoxueziliao3(Map<String,Object> map);
  public Jiaoxueziliao quchongJiaoxueziliao(Map<String, Object> acount);

  public Jiaoxueziliao getById( int id);

  public List<Jiaoxueziliao> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiaoxueziliao> select(Map<String, Object> map);
}
//	所有List
