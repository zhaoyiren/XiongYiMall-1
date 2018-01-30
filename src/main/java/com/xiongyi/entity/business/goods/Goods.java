package com.xiongyi.entity.business.goods;

/** 
 * 说明： 商品表
 * 创建人：XY
 * 创建时间：2018-01-27
 * @version
 */
 public class Goods {
 
		private String GOODSNAME;	//商品名称
		private String GOODSCODE;	//商品编号
		private String GOODSPICTURE;	//商品封面图
		//新加变量开始
		private String GOODSTYPE;	//商品类型
		private String GOODSSTATE; //商品状态
		//新加变量结束		
		private String PUBLISHDATE;	//上货时间
		private String DOWNPUBLISHDATE;	//下架时间
	
	
	public String getGOODSNAME() {
		return GOODSNAME;
	}
	public void setGOODSNAME(String GOODSNAME) {
		this.GOODSNAME = GOODSNAME;
	}
	public String getGOODSCODE() {
		return GOODSCODE;
	}
	public void setGOODSCODE(String GOODSCODE) {
		this.GOODSCODE = GOODSCODE;
	}
	public String getGOODSPICTURE() {
		return GOODSPICTURE;
	}
	public void setGOODSPICTURE(String GOODSPICTURE) {
		this.GOODSPICTURE = GOODSPICTURE;
	}
	public String getGOODSTYPE() {
		return GOODSTYPE;
	}
	public void setGOODSTYPE(String gOODSTYPE) {
		GOODSTYPE = gOODSTYPE;
	}
	public String getGOODSSTATE() {
		return GOODSSTATE;
	}
	public void setGOODSSTATE(String gOODSSTATE) {
		GOODSSTATE = gOODSSTATE;
	}
	public String getPUBLISHDATE() {
		return PUBLISHDATE;
	}
	public void setPUBLISHDATE(String PUBLISHDATE) {
		this.PUBLISHDATE = PUBLISHDATE;
	}
	public String getDOWNPUBLISHDATE() {
		return DOWNPUBLISHDATE;
	}
	public void setDOWNPUBLISHDATE(String DOWNPUBLISHDATE) {
		this.DOWNPUBLISHDATE = DOWNPUBLISHDATE;
	}
 
 }