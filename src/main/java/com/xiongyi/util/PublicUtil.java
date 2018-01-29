package com.xiongyi.util;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * @author GUXIONG
 * @description IP����
 *
 */
public class PublicUtil {
	
	public static void main(String[] args) {
		System.out.println("������ip=" + PublicUtil.getIp());
	}
	
	public static String getPorjectPath(){
		String nowpath = "";
		nowpath=System.getProperty("user.dir")+"/";
		
		return nowpath;
	}
	
	/**
	 * ��ȡ�������ʵ�ַ
	 * @return
	 */
	public static String getIp(){
		String ip = "";
		try {
			InetAddress inet = InetAddress.getLocalHost();
			ip = inet.getHostAddress();
			//System.out.println("������ip=" + ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return ip;
	}
	
}