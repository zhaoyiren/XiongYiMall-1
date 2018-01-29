package com.xiongyi.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GUXIONG
 * @description ��γ�ȴ���
 *
 */
public class MapDistance {  
	  
    private static double EARTH_RADIUS = 6378.137;  
  
    private static double rad(double d) {  
        return d * Math.PI / 180.0;  
    }
    
    /**
     * ��������λ�õľ�γ�ȣ����������صľ��루��λΪKM��
     * ����ΪString����
     * @param lat1 �û�����
     * @param lng1 �û�γ��
     * @param lat2 �̼Ҿ���
     * @param lng2 �̼�γ��
     * @return
     */
    public static String getDistance(String lat1Str, String lng1Str, String lat2Str, String lng2Str) {
    	Double lat1 = Double.parseDouble(lat1Str);
    	Double lng1 = Double.parseDouble(lng1Str);
    	Double lat2 = Double.parseDouble(lat2Str);
    	Double lng2 = Double.parseDouble(lng2Str);
    	double patm = 2;
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double difference = radLat1 - radLat2;
        double mdifference = rad(lng1) - rad(lng2);
        double distance = patm * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / patm), patm)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(mdifference / patm), patm)));
        distance = distance * EARTH_RADIUS;
        String distanceStr = String.valueOf(distance);
        return distanceStr;
    }
    
    /**
	 * ��ȡ��ǰ�û�һ���������ڵľ�γ��ֵ
	 * ��λ�� return minLat 
	 * ��С���� minLng 
	 * ��Сγ�� maxLat 
	 * ��󾭶� maxLng 
	 * ���γ�� minLat
	 */
	public static Map getAround(String latStr, String lngStr, String raidus) {
		Map map = new HashMap();
		
		Double latitude = Double.parseDouble(latStr);// ��ֵ������
		Double longitude = Double.parseDouble(lngStr);// ��ֵ��γ��

		Double degree = (24901 * 1609) / 360.0; // ��ȡÿ��
		double raidusMile = Double.parseDouble(raidus);
		
		Double mpdLng = Double.parseDouble((degree * Math.cos(latitude * (Math.PI / 180))+"").replace("-", ""));
		Double dpmLng = 1 / mpdLng;
		Double radiusLng = dpmLng * raidusMile;
		//��ȡ��С����
		Double minLat = longitude - radiusLng;
		// ��ȡ��󾭶�
		Double maxLat = longitude + radiusLng;
		
		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		// ��ȡ��Сγ��
		Double minLng = latitude - radiusLat;
		// ��ȡ���γ��
		Double maxLng = latitude + radiusLat;
		
		map.put("minLat", minLat+"");
		map.put("maxLat", maxLat+"");
		map.put("minLng", minLng+"");
		map.put("maxLng", maxLng+"");
		
		return map;
	}
    
    public static void main(String[] args) {
    	//���Ϲ��ʻ�չ���ľ�γ�ȣ�117.11811  36.68484
    	//��ͻȪ��117.00999000000002  36.66123
    	System.out.println(getDistance("116.97265","36.694514","116.597805","36.738024"));
    	
    	System.out.println(getAround("117.11811", "36.68484", "13000"));
    	//117.01028712333508(Double), 117.22593287666493(Double), 
    	//36.44829619896034(Double), 36.92138380103966(Double)
    	
	}
    
}
