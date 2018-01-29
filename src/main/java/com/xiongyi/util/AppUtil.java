package com.xiongyi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.util.JSONPObject;

/** �ӿڲ���У��
 * @author:	BZQ
 * �޸����ڣ�2015/11/2
 */
public class AppUtil  {
	
	protected static Logger logger = Logger.getLogger(AppUtil.class);
	
	/**�������Ƿ�����
	 * @param method
	 * @param pd
	 * @return
	 */
	public static boolean checkParam(String method, PageData pd){
		boolean result = false;
		
		int falseCount = 0;
		String[] paramArray = new String[20];
		String[] valueArray = new String[20];
		String[] tempArray  = new String[20];  //��ʱ����
		
		if(method=="registered"){// ע��
			paramArray = Const.APP_REGISTERED_PARAM_ARRAY;  //����
			valueArray = Const.APP_REGISTERED_VALUE_ARRAY;  //��������
			
		}else if(method=="getAppuserByUsernmae"){//�����û�����ȡ��Ա��Ϣ
			paramArray = Const.APP_GETAPPUSER_PARAM_ARRAY;  
			valueArray = Const.APP_GETAPPUSER_VALUE_ARRAY;
		}
		int size = paramArray.length;
		for(int i=0;i<size;i++){
			String param = paramArray[i];
			if(!pd.containsKey(param)){
				tempArray[falseCount] = valueArray[i]+"--"+param;
				falseCount += 1;
			}
		}
		if(falseCount>0){
			logger.error(method+"�ӿڣ�����Э����ȱ�� "+falseCount+"�� ����");
			for(int j=1;j<=falseCount;j++){
				logger.error("   ��"+j+"����"+ tempArray[j-1]);
			}
		} else {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * ���÷�ҳ�Ĳ���
	 * @param pd
	 * @return
	 */
	public static PageData setPageParam(PageData pd){
		String page_now_str = pd.get("page_now").toString();
		int pageNowInt = Integer.parseInt(page_now_str)-1;
		String page_size_str = pd.get("page_size").toString(); //ÿҳ��ʾ��¼��
		int pageSizeInt = Integer.parseInt(page_size_str);
		String page_now = pageNowInt+"";
		String page_start = (pageNowInt*pageSizeInt)+"";
		pd.put("page_now", page_now);
		pd.put("page_start", page_start);
		return pd;
	}
	
	/**����list�е�distance
	 * @param list
	 * @param pd
	 * @return
	 */
	public static List<PageData>  setListDistance(List<PageData> list, PageData pd){
		List<PageData> listReturn = new ArrayList<PageData>();
		String user_longitude = "";
		String user_latitude = "";
		try{
			user_longitude = pd.get("user_longitude").toString(); //"117.11811";
			user_latitude  = pd.get("user_latitude").toString();  //"36.68484";
		} catch(Exception e){
			logger.error("ȱʧ����--user_longitude��user_longitude");
			logger.error("lost param��user_longitude and user_longitude");
		}
		PageData pdTemp = new PageData();
		int size = list.size();
		for(int i=0;i<size;i++){
			pdTemp = list.get(i);
			String longitude = pdTemp.get("longitude").toString();
			String latitude = pdTemp.get("latitude").toString();
			String distance = MapDistance.getDistance(
						user_longitude,	user_latitude,
						longitude,		latitude
					);
			pdTemp.put("distance", distance);
			pdTemp.put("size", distance.length());
			listReturn.add(pdTemp);
		}
		return listReturn;
	}
	
	/**
	 * @param pd
	 * @param map
	 * @return
	 */
	public static Object returnObject(PageData pd, Map map){
		if(pd.containsKey("callback")){
			String callback = pd.get("callback").toString();
			return new JSONPObject(callback, map);
		}else{
			return map;
		}
	}
}
