package com.xiongyi.entity;

import java.util.List;


/**
 * @author GUXIONG
 * @description �����ֵ�
 */
public class Dictionaries {

	private String NAME;			//����
	private String NAME_EN;			//Ӣ������
	private String BIANMA;			//����
	private String ORDER_BY;		//����	
	private String PARENT_ID;		//�ϼ�ID
	private String BZ;				//��ע
	private String TBSNAME;			//������
	private String DICTIONARIES_ID;	//����
	private String target;
	private Dictionaries dict;
	private List<Dictionaries> subDict;
	private boolean hasDict = false;
	private String treeurl;
	
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getNAME_EN() {
		return NAME_EN;
	}
	public void setNAME_EN(String nAME_EN) {
		NAME_EN = nAME_EN;
	}
	public String getBIANMA() {
		return BIANMA;
	}
	public void setBIANMA(String bIANMA) {
		BIANMA = bIANMA;
	}
	public String getORDER_BY() {
		return ORDER_BY;
	}
	public void setORDER_BY(String oRDER_BY) {
		ORDER_BY = oRDER_BY;
	}
	public String getPARENT_ID() {
		return PARENT_ID;
	}
	public void setPARENT_ID(String pARENT_ID) {
		PARENT_ID = pARENT_ID;
	}
	public String getBZ() {
		return BZ;
	}
	public void setBZ(String bZ) {
		BZ = bZ;
	}
	public String getTBSNAME() {
		return TBSNAME;
	}
	public void setTBSNAME(String tBSNAME) {
		TBSNAME = tBSNAME;
	}
	public String getDICTIONARIES_ID() {
		return DICTIONARIES_ID;
	}
	public void setDICTIONARIES_ID(String dICTIONARIES_ID) {
		DICTIONARIES_ID = dICTIONARIES_ID;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Dictionaries getDict() {
		return dict;
	}
	public void setDict(Dictionaries dict) {
		this.dict = dict;
	}
	public List<Dictionaries> getSubDict() {
		return subDict;
	}
	public void setSubDict(List<Dictionaries> subDict) {
		this.subDict = subDict;
	}
	public boolean isHasDict() {
		return hasDict;
	}
	public void setHasDict(boolean hasDict) {
		this.hasDict = hasDict;
	}
	public String getTreeurl() {
		return treeurl;
	}
	public void setTreeurl(String treeurl) {
		this.treeurl = treeurl;
	}
	
}
