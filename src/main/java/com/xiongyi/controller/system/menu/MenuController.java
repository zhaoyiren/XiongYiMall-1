package com.xiongyi.controller.system.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiongyi.controller.base.BaseController;
import com.xiongyi.entity.Menu;
import com.xiongyi.service.menu.MenuManager;
import com.xiongyi.util.AppUtil;
import com.xiongyi.util.Const;
import com.xiongyi.util.Jurisdiction;
import com.xiongyi.util.PageData;
import com.xiongyi.util.RightsHelper;

import net.sf.json.JSONArray;

/**
 * @author GUXIONG
 * @description �˵�����
 *
 */
@Controller
@RequestMapping(value="/menu")
public class MenuController extends BaseController {

	String menuUrl = "menu.do"; //�˵���ַ(Ȩ����)
	@Resource(name="menuService")
	private MenuManager menuService;
	
	/**
	 * ��ʾ�˵��б�
	 * @param model
	 * @return
	 */
	@RequestMapping
	public ModelAndView list()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			String MENU_ID = (null == pd.get("MENU_ID") || "".equals(pd.get("MENU_ID").toString()))?"0":pd.get("MENU_ID").toString();
			List<Menu> menuList = menuService.listSubMenuByParentId(MENU_ID);
			mv.addObject("pd", menuService.getMenuById(pd));	//���븸�˵�������Ϣ
			mv.addObject("MENU_ID", MENU_ID);
			mv.addObject("MSG", null == pd.get("MSG")?"list":pd.get("MSG").toString()); //MSG=change ��Ϊ�༭��ɾ������ת������
			mv.addObject("menuList", menuList);
			mv.addObject("QX",Jurisdiction.getHC());	//��ťȨ��
			mv.setViewName("system/menu/menu_list");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * ���������˵�ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toAdd")
	public ModelAndView toAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
			String MENU_ID = (null == pd.get("MENU_ID") || "".equals(pd.get("MENU_ID").toString()))?"0":pd.get("MENU_ID").toString();//���մ��������ϼ��˵�ID,����ϼ�Ϊ������ȡֵ��0��
			pd.put("MENU_ID",MENU_ID);
			mv.addObject("pds", menuService.getMenuById(pd));	//���븸�˵�������Ϣ
			mv.addObject("MENU_ID", MENU_ID);					//����˵�ID����Ϊ�Ӳ˵��ĸ��˵�ID��
			mv.addObject("MSG", "add");							//ִ��״̬ add Ϊ���
			mv.setViewName("system/menu/menu_edit");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}	
	
	/**
	 * ����˵���Ϣ
	 * @param menu
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add")
	public ModelAndView add(Menu menu)throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"����˵�");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			menu.setMENU_ID(String.valueOf(Integer.parseInt(menuService.findMaxId(pd).get("MID").toString())+1));
			menu.setMENU_ICON("menu-icon fa fa-leaf black");//Ĭ�ϲ˵�ͼ��
			menuService.saveMenu(menu); //����˵�
		} catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("msg","failed");
		}
		mv.setViewName("redirect:?MSG='change'&MENU_ID="+menu.getPARENT_ID()); //����ɹ���ת���б�ҳ��
		return mv;
	}
	
	/**
	 * ɾ���˵�
	 * @param MENU_ID
	 * @param out
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(@RequestParam String MENU_ID)throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"ɾ���˵�");
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "";
		try{
			if(menuService.listSubMenuByParentId(MENU_ID).size() > 0){//�ж��Ƿ����Ӳ˵����ǣ�������ɾ��
				errInfo = "false";
			}else{
				menuService.deleteMenuById(MENU_ID);
				errInfo = "success";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**
	 * ����༭�˵�ҳ��
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/toEdit")
	public ModelAndView toEdit(String id)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			pd.put("MENU_ID",id);				//���չ�����Ҫ�޸ĵ�ID
			pd = menuService.getMenuById(pd);	//��ȡ��ID�Ĳ˵�����
			mv.addObject("pd", pd);				//������ͼ����
			pd.put("MENU_ID",pd.get("PARENT_ID").toString());			//������ȡ���˵���Ϣ
			mv.addObject("pds", menuService.getMenuById(pd));			//���븸�˵�������Ϣ
			mv.addObject("MENU_ID", pd.get("PARENT_ID").toString());	//���븸�˵�ID����Ϊ�Ӳ˵��ĸ��˵�ID��
			mv.addObject("MSG", "edit");
			pd.put("MENU_ID",id);			//��ԭ���˵�ID
			mv.addObject("QX",Jurisdiction.getHC());	//��ťȨ��
			mv.setViewName("system/menu/menu_edit");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * ����༭
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(Menu menu)throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"�޸Ĳ˵�");
		ModelAndView mv = this.getModelAndView();
		try{
			menuService.edit(menu);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		mv.setViewName("redirect:?MSG='change'&MENU_ID="+menu.getPARENT_ID()); //����ɹ���ת���б�ҳ��
		return mv;
	}
	
	/**
	 * ����༭�˵�ͼ��ҳ��
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/toEditicon")
	public ModelAndView toEditicon(String MENU_ID)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			pd.put("MENU_ID",MENU_ID);
			mv.addObject("pd", pd);
			mv.setViewName("system/menu/menu_icon");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * ����˵�ͼ�� 
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/editicon")
	public ModelAndView editicon()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"�޸Ĳ˵�ͼ��");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			pd = menuService.editicon(pd);
			mv.addObject("msg","success");
		} catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("msg","failed");
		}
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * ��ʾ�˵��б�ztree(�˵�����)
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/listAllMenu")
	public ModelAndView listAllMenu(Model model,String MENU_ID)throws Exception{
		ModelAndView mv = this.getModelAndView();
		try{
			JSONArray arr = JSONArray.fromObject(menuService.listAllMenu("0"));
			String json = arr.toString();
			json = json.replaceAll("MENU_ID", "id").replaceAll("PARENT_ID", "pId").replaceAll("MENU_NAME", "name").replaceAll("subMenu", "nodes").replaceAll("hasMenu", "checked").replaceAll("MENU_URL", "url");
			model.addAttribute("zTreeNodes", json);
			mv.addObject("MENU_ID",MENU_ID);
			mv.setViewName("system/menu/menu_ztree");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * ��ʾ�˵��б�ztree(��չ����ļ��˵�)
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/otherlistMenu")
	public ModelAndView otherlistMenu(Model model,String MENU_ID)throws Exception{
		ModelAndView mv = this.getModelAndView();
		try{
			PageData pd = new PageData();
			pd.put("MENU_ID", MENU_ID);
			String MENU_URL = menuService.getMenuById(pd).getString("MENU_URL");
			if("#".equals(MENU_URL.trim()) || "".equals(MENU_URL.trim()) || null == MENU_URL){
				MENU_URL = "login_default.do";
			}
			String roleRights = Jurisdiction.getSession().getAttribute(Jurisdiction.getUsername() + Const.SESSION_ROLE_RIGHTS).toString();	//��ȡ����ɫ�˵�Ȩ��
			List<Menu> athmenuList = menuService.listAllMenuQx(MENU_ID);					//��ȡĳ�˵��������Ӳ˵�
			athmenuList = this.readMenu(athmenuList, roleRights);							//����Ȩ�޷���˵�
			JSONArray arr = JSONArray.fromObject(athmenuList);
			String json = arr.toString();
			json = json.replaceAll("MENU_ID", "id").replaceAll("PARENT_ID", "pId").replaceAll("MENU_NAME", "name").replaceAll("subMenu", "nodes").replaceAll("hasMenu", "checked").replaceAll("MENU_URL", "url").replaceAll("#", "");
			model.addAttribute("zTreeNodes", json);
			mv.addObject("MENU_URL",MENU_URL);		//��ID�˵�����
			mv.setViewName("system/menu/menu_ztree_other");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**���ݽ�ɫȨ�޻�ȡ��Ȩ�޵Ĳ˵��б�(�ݹ鴦��)
	 * @param menuList��������ܲ˵�
	 * @param roleRights�����ܵ�Ȩ���ַ���
	 * @return
	 */
	public List<Menu> readMenu(List<Menu> menuList,String roleRights){
		for(int i=0;i<menuList.size();i++){
			menuList.get(i).setHasMenu(RightsHelper.testRights(roleRights, menuList.get(i).getMENU_ID()));
			if(menuList.get(i).isHasMenu() && "1".equals(menuList.get(i).getMENU_STATE())){	//�ж��Ƿ��д˲˵�Ȩ�޲����Ƿ�����
				this.readMenu(menuList.get(i).getSubMenu(), roleRights);					//�ǣ������Ų����Ӳ˵�
			}else{
				menuList.remove(i);
				i--;
			}
		}
		return menuList;
	}
	
}
