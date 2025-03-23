package com.entity;

public class Shiyanxiangmu {
    private Integer id;
	private String xiangmubianhao;	private String shiyanmingcheng;	private String yanjiuketi;	private String yuqichengguo;	private String shiyanshijian;	private String xiangmujianjie;	private String zhidaolaoshi;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getXiangmubianhao() {
        return xiangmubianhao;
    }
    public void setXiangmubianhao(String xiangmubianhao) {
        this.xiangmubianhao = xiangmubianhao == null ? null : xiangmubianhao.trim();
    }	public String getShiyanmingcheng() {
        return shiyanmingcheng;
    }
    public void setShiyanmingcheng(String shiyanmingcheng) {
        this.shiyanmingcheng = shiyanmingcheng == null ? null : shiyanmingcheng.trim();
    }	public String getYanjiuketi() {
        return yanjiuketi;
    }
    public void setYanjiuketi(String yanjiuketi) {
        this.yanjiuketi = yanjiuketi == null ? null : yanjiuketi.trim();
    }	public String getYuqichengguo() {
        return yuqichengguo;
    }
    public void setYuqichengguo(String yuqichengguo) {
        this.yuqichengguo = yuqichengguo == null ? null : yuqichengguo.trim();
    }	public String getShiyanshijian() {
        return shiyanshijian;
    }
    public void setShiyanshijian(String shiyanshijian) {
        this.shiyanshijian = shiyanshijian == null ? null : shiyanshijian.trim();
    }	public String getXiangmujianjie() {
        return xiangmujianjie;
    }
    public void setXiangmujianjie(String xiangmujianjie) {
        this.xiangmujianjie = xiangmujianjie == null ? null : xiangmujianjie.trim();
    }	public String getZhidaolaoshi() {
        return zhidaolaoshi;
    }
    public void setZhidaolaoshi(String zhidaolaoshi) {
        this.zhidaolaoshi = zhidaolaoshi == null ? null : zhidaolaoshi.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
