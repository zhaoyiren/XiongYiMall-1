package com.xiongyi.util;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.xiongyi.entity.Menu;



/**
 * @author GUXIONG
 * @description Ȩ�޴���
 */
public class Jurisdiction {

	/**
	 * ����Ȩ�޼���ʼ����ťȨ��(���ư�ť����ʾ ��ɾ�Ĳ�)
	 * @param menuUrl  �˵�·��
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean hasJurisdiction(String menuUrl){
		//�ж��Ƿ�ӵ�е�ǰ����˵���Ȩ�ޣ��ڲ�����,��ֹͨ��url���������˵�Ȩ�ޣ�
		/**
		 * ���ݵ���Ĳ˵���xxx.doȥ�˵��е�URLȥƥ�䣬��ƥ�䵽�˴˲˵����ж��Ƿ��д˲˵���Ȩ�ޣ�û�еĻ���ת��404ҳ��
		 * ���ݰ�ťȨ�ޣ���Ȩ��ť(��ǰ��Ĳ˵��ͽ�ɫ�и���ť��Ȩ��ƥ��)
		 */
		String USERNAME = getUsername();	//��ȡ��ǰ��¼��loginname
		Session session = getSession();
		List<Menu> menuList = (List<Menu>)session.getAttribute(USERNAME + Const.SESSION_allmenuList); //��ȡ�˵��б�
		return readMenu(menuList,menuUrl,session,USERNAME);
	}
	
	/**У��˵�Ȩ�޲���ʼ��ťȨ������ҳ�水ť��ʾ���(�ݹ鴦��)
	 * @param menuList:������ܲ˵�(���ò˵�ʱ��.doǰ��Ĳ�Ҫ�ظ�)
	 * @param menuUrl:���ʵ�ַ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean readMenu(List<Menu> menuList,String menuUrl,Session session,String USERNAME){
		for(int i=0;i<menuList.size();i++){
			if(menuList.get(i).getMENU_URL().split(".do")[0].equals(menuUrl.split(".do")[0])){ //���ʵ�ַ��˵���ַѭ��ƥ�䣬���ƥ�䵽�ͽ�һ����֤�����ûƥ�䵽�Ͳ�����(�����ǽӿ����ӻ���������)
				if(!menuList.get(i).isHasMenu()){				//�ж����޴˲˵�Ȩ��
					return false;
				}else{											//��ť�ж�
					Map<String, String> map = (Map<String, String>)session.getAttribute(USERNAME + Const.SESSION_QX);//��ťȨ��(��ɾ�Ĳ�)
					map.remove("add");
					map.remove("del");
					map.remove("edit");
					map.remove("cha");
					String MENU_ID =  menuList.get(i).getMENU_ID();
					Boolean isAdmin = "admin".equals(USERNAME);
					map.put("add", (RightsHelper.testRights(map.get("adds"), MENU_ID)) || isAdmin?"1":"0");
					map.put("del", RightsHelper.testRights(map.get("dels"), MENU_ID) || isAdmin?"1":"0");
					map.put("edit", RightsHelper.testRights(map.get("edits"), MENU_ID) || isAdmin?"1":"0");
					map.put("cha", RightsHelper.testRights(map.get("chas"), MENU_ID) || isAdmin?"1":"0");
					session.removeAttribute(USERNAME + Const.SESSION_QX);
					session.setAttribute(USERNAME + Const.SESSION_QX, map);	//���·��䰴ťȨ��
					return true;
				}
			}else{
				readMenu(menuList.get(i).getSubMenu(),menuUrl,session,USERNAME);//�����Ų����Ӳ˵�
			}
		}
		return true;
	}
	
	/**
	 * ��ťȨ��(������У��)
	 * @param menuUrl  �˵�·��
	 * @param type  ����(add��del��edit��cha)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean buttonJurisdiction(String menuUrl, String type){
		//�ж��Ƿ�ӵ�е�ǰ����˵���Ȩ�ޣ��ڲ�����,��ֹͨ��url���������˵�Ȩ�ޣ�
		/**
		 * ���ݵ���Ĳ˵���xxx.doȥ�˵��е�URLȥƥ�䣬��ƥ�䵽�˴˲˵����ж��Ƿ��д˲˵���Ȩ�ޣ�û�еĻ���ת��404ҳ��
		 * ���ݰ�ťȨ�ޣ���Ȩ��ť(��ǰ��Ĳ˵��ͽ�ɫ�и���ť��Ȩ��ƥ��)
		 */
		String USERNAME = getUsername();	//��ȡ��ǰ��¼��loginname
		Session session = getSession();
		List<Menu> menuList = (List<Menu>)session.getAttribute(USERNAME + Const.SESSION_allmenuList); //��ȡ�˵��б�
		readMenuButton(menuList,menuUrl,session,USERNAME,type);
		return true;
	}
	
	/**У�鰴ťȨ��(�ݹ鴦��)
	 * @param menuList:������ܲ˵�(���ò˵�ʱ��.doǰ��Ĳ�Ҫ�ظ�)
	 * @param menuUrl:���ʵ�ַ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean readMenuButton(List<Menu> menuList,String menuUrl,Session session,String USERNAME, String type){
		for(int i=0;i<menuList.size();i++){
			if(menuList.get(i).getMENU_URL().split(".do")[0].equals(menuUrl.split(".do")[0])){ //���ʵ�ַ��˵���ַѭ��ƥ�䣬���ƥ�䵽�ͽ�һ����֤�����ûƥ�䵽�Ͳ�����(�����ǽӿ����ӻ���������)
				if(!menuList.get(i).isHasMenu()){				//�ж����޴˲˵�Ȩ��
					return false;
				}else{											//��ť�ж�
					Map<String, String> map = (Map<String, String>)session.getAttribute(USERNAME + Const.SESSION_QX);//��ťȨ��(��ɾ�Ĳ�)
					String MENU_ID =  menuList.get(i).getMENU_ID();
					Boolean isAdmin = "admin".equals(USERNAME);
					if("add".equals(type)){
						return ((RightsHelper.testRights(map.get("adds"), MENU_ID)) || isAdmin);
					}else if("del".equals(type)){
						return ((RightsHelper.testRights(map.get("dels"), MENU_ID)) || isAdmin);
					}else if("edit".equals(type)){
						return ((RightsHelper.testRights(map.get("edits"), MENU_ID)) || isAdmin);
					}else if("cha".equals(type)){
						return ((RightsHelper.testRights(map.get("chas"), MENU_ID)) || isAdmin);
					}
				}
			}else{
				readMenuButton(menuList.get(i).getSubMenu(),menuUrl,session,USERNAME,type);//�����Ų����Ӳ˵�
			}
		}
		return true;
	}
	
	/**��ȡ��ǰ��¼���û���
	 * @return
	 */
	public static String getUsername(){
		return getSession().getAttribute(Const.SESSION_USERNAME).toString();
	}
	
	/**��ȡ��ǰ��ťȨ��(��ɾ�Ĳ�)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getHC(){
		return (Map<String, String>)getSession().getAttribute(getUsername() + Const.SESSION_QX);
	}
	
	/**shiro�����session
	 * @return
	 */
	public static Session getSession(){
		//Subject currentUser = SecurityUtils.getSubject();  
		return SecurityUtils.getSubject().getSession();
	}
}
