package com.xiongyi.service.menu.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiongyi.dao.DaoSupport;
import com.xiongyi.entity.Menu;
import com.xiongyi.service.menu.MenuManager;
import com.xiongyi.util.PageData;


/**
 * @author GUXIONG
 * @description MenuService �˵�����
 */
@Service("menuService")
public class MenuService implements MenuManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**
	 * ͨ��ID��ȡ����һ���˵�
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Menu> listSubMenuByParentId(String parentId) throws Exception {
		return (List<Menu>) dao.findForList("MenuMapper.listSubMenuByParentId", parentId);
	}
	
	/**
	 * ͨ���˵�ID��ȡ����
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageData getMenuById(PageData pd) throws Exception {
		return (PageData) dao.findForObject("MenuMapper.getMenuById", pd);
	}
	
	/**
	 * �����˵�
	 * @param menu
	 * @throws Exception
	 */
	@Override
	public void saveMenu(Menu menu) throws Exception {
		dao.save("MenuMapper.insertMenu", menu);
	}
	
	/**
	 * ȡ���ID
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageData findMaxId(PageData pd) throws Exception {
		return (PageData) dao.findForObject("MenuMapper.findMaxId", pd);
	}
	
	/**
	 * ɾ���˵�
	 * @param MENU_ID
	 * @throws Exception
	 */
	@Override
	public void deleteMenuById(String MENU_ID) throws Exception {
		dao.save("MenuMapper.deleteMenuById", MENU_ID);
	}
	
	/**
	 * �༭
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	@Override
	public void edit(Menu menu) throws Exception {
		 dao.update("MenuMapper.updateMenu", menu);
	}
	
	/**
	 * ����˵�ͼ�� 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageData editicon(PageData pd) throws Exception {
		return (PageData)dao.findForObject("MenuMapper.editicon", pd);
	}
	
	/**
	 * ��ȡ���в˵������ÿ���˵����Ӳ˵��б�(�˵�����)(�ݹ鴦��)
	 * @param MENU_ID
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Menu> listAllMenu(String MENU_ID) throws Exception {
		List<Menu> menuList = this.listSubMenuByParentId(MENU_ID);
		for(Menu menu : menuList){
			menu.setMENU_URL("menu/toEdit.do?MENU_ID="+menu.getMENU_ID());
			menu.setSubMenu(this.listAllMenu(menu.getMENU_ID()));
			menu.setTarget("treeFrame");
		}
		return menuList;
	}

	/**
	 * ��ȡ���в˵������ÿ���˵����Ӳ˵��б�(ϵͳ�˵��б�)(�ݹ鴦��)
	 * @param MENU_ID
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Menu> listAllMenuQx(String MENU_ID) throws Exception {
		List<Menu> menuList = this.listSubMenuByParentId(MENU_ID);
		for(Menu menu : menuList){
			menu.setSubMenu(this.listAllMenuQx(menu.getMENU_ID()));
			menu.setTarget("treeFrame");
		}
		return menuList;
	}
	
}
