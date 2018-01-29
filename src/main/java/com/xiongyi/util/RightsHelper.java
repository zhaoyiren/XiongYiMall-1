package com.xiongyi.util;

import java.math.BigInteger;

/**
 * @author GUXIONG
 * @description Ȩ�޼��������
 */
public class RightsHelper {
	/**
	 * ����BigInteger��Ȩ�޽���2��Ȩ�ĺͼ���
	 * @param rights int��Ȩ�ޱ�������
	 * @return 2��Ȩ�ĺ�
	 */
	public static BigInteger sumRights(int[] rights){
		BigInteger num = new BigInteger("0");
		for(int i=0; i<rights.length; i++){
			num = num.setBit(rights[i]);
		}
		return num;
	}
	/**
	 * ����BigInteger��Ȩ�޽���2��Ȩ�ĺͼ���
	 * @param rights String��Ȩ�ޱ�������
	 * @return 2��Ȩ�ĺ�
	 */
	public static BigInteger sumRights(String[] rights){
		BigInteger num = new BigInteger("0");
		for(int i=0; i<rights.length; i++){
			num = num.setBit(Integer.parseInt(rights[i]));
		}
		return num;
	}
	
	/**
	 * �����Ƿ����ָ�������Ȩ��
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(BigInteger sum,int targetRights){
		return sum.testBit(targetRights);
	}
	
	/**
	 * �����Ƿ����ָ�������Ȩ��
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(String sum,int targetRights){
		if(Tools.isEmpty(sum))
			return false;
		return testRights(new BigInteger(sum),targetRights);
	}
	
	/**
	 * �����Ƿ����ָ�������Ȩ��
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(String sum,String targetRights){
		if(Tools.isEmpty(sum))
			return false;
		return testRights(new BigInteger(sum),targetRights);
	}
	
	/**
	 * �����Ƿ����ָ�������Ȩ��
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(BigInteger sum,String targetRights){
		return testRights(sum,Integer.parseInt(targetRights));
	}
}
