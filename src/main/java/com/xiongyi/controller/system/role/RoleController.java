package com.xiongyi.controller.system.role;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiongyi.controller.base.BaseController;
import com.xiongyi.entity.Menu;
import com.xiongyi.entity.Role;
import com.xiongyi.service.appuser.AppuserManager;
import com.xiongyi.service.menu.MenuManager;
import com.xiongyi.service.role.RoleManager;
import com.xiongyi.service.user.UserManager;
import com.xiongyi.util.AppUtil;
import com.xiongyi.util.Jurisdiction;
import com.xiongyi.util.PageData;
import com.xiongyi.util.RightsHelper;
import com.xiongyi.util.Tools;

import net.sf.json.JSONArray;

/**
 * @author GUXIONG
 * @description ��ɫȨ�޹���
 *
 */
@Controller
@RequestMapping(value="/role")
public class RoleController extends BaseController {
	
	String menuUrl = "role.do"; //�˵���ַ(Ȩ����)
	@Resource(name="menuService")
	private MenuManager menuService;
	@Resource(name="roleService")
	private RoleManager roleService;
	@Resource(name="userService")
	private UserManager userService;
	@Resource(name="appuserService")
	private AppuserManager appuserService;
	
	/** ����Ȩ����ҳ
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping
	public ModelAndView list()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(pd.getString("ROLE_ID") == null || "".equals(pd.getString("ROLE_ID").trim())){
				pd.put("ROLE_ID", "1");										//Ĭ���г���һ���ɫ(��ʼ���ϵͳ�û��ͻ�Ա�鲻��ɾ��)
			}
			PageData fpd = new PageData();
			fpd.put("ROLE_ID", "0");
			List<Role> roleList = roleService.listAllRolesByPId(fpd);		//�г���(ҳ��������е�һ����)
			List<Role> roleList_z = roleService.listAllRolesByPId(pd);		//�г������¼ܽ�ɫ
			pd = roleService.findObjectById(pd);							//ȡ�õ���Ľ�ɫ��(���ŵ�)
			mv.addObject("pd", pd);
			mv.addObject("roleList", roleList);
			mv.addObject("roleList_z", roleList_z);
			mv.addObject("QX",Jurisdiction.getHC());	//��ťȨ��
			mv.setViewName("system/role/role_list");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**ȥ����ҳ��
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/toAdd")
	public ModelAndView toAdd(){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			mv.addObject("msg", "add");
			mv.setViewName("system/role/role_edit");
			mv.addObject("pd", pd);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**����������ɫ
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView add()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"������ɫ");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			String parent_id = pd.getString("PARENT_ID");		//�����ɫid
			pd.put("ROLE_ID", parent_id);			
			if("0".equals(parent_id)){
				pd.put("RIGHTS", "");							//�˵�Ȩ��
			}else{
				String rights = roleService.findObjectById(pd).getString("RIGHTS");
				pd.put("RIGHTS", (null == rights)?"":rights);	//��˵�Ȩ��
			}
			pd.put("ROLE_ID", this.get32UUID());				//����
			pd.put("ADD_QX", "0");	//��ʼ����Ȩ��Ϊ��
			pd.put("DEL_QX", "0");	//ɾ��Ȩ��
			pd.put("EDIT_QX", "0");	//�޸�Ȩ��
			pd.put("CHA_QX", "0");	//�鿴Ȩ��
			roleService.add(pd);
		} catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("msg","failed");
		}
		mv.setViewName("save_result");
		return mv;
	}
	
	/**����༭
	 * @param ROLE_ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/toEdit")
	public ModelAndView toEdit( String ROLE_ID )throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			pd.put("ROLE_ID", ROLE_ID);
			pd = roleService.findObjectById(pd);
			mv.addObject("msg", "edit");
			mv.addObject("pd", pd);
			mv.setViewName("system/role/role_edit");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**�����޸�
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"�޸Ľ�ɫ");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			roleService.edit(pd);
			mv.addObject("msg","success");
		} catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("msg","failed");
		}
		mv.setViewName("save_result");
		return mv;
	}
	
	/**ɾ����ɫ
	 * @param ROLE_ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object deleteRole(@RequestParam String ROLE_ID)throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"ɾ����ɫ");
		Map<String,String> map = new HashMap<String,String>();
		PageData pd = new PageData();
		String errInfo = "";
		try{
			pd.put("ROLE_ID", ROLE_ID);
			List<Role> roleList_z = roleService.listAllRolesByPId(pd);		//�г��˲��ŵ������¼�
			if(roleList_z.size() > 0){
				errInfo = "false";											//�¼�������ʱ��ɾ��ʧ��
			}else{
				List<PageData> userlist = userService.listAllUserByRoldId(pd);			//�˽�ɫ�µ��û�
				List<PageData> appuserlist = appuserService.listAllAppuserByRorlid(pd);	//�˽�ɫ�µĻ�Ա
				if(userlist.size() > 0 || appuserlist.size() > 0){						//�˽�ɫ�ѱ�ʹ�þͲ���ɾ��
					errInfo = "false2";
				}else{
				roleService.deleteRoleById(ROLE_ID);	//ִ��ɾ��
				errInfo = "success";
				}
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**
	 * ��ʾ�˵��б�ztree(�˵���Ȩ�˵�)
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/menuqx")
	public ModelAndView listAllMenu(Model model,String ROLE_ID)throws Exception{
		ModelAndView mv = this.getModelAndView();
		try{
			Role role = roleService.getRoleById(ROLE_ID);			//���ݽ�ɫID��ȡ��ɫ����
			String roleRights = role.getRIGHTS();					//ȡ������ɫ�˵�Ȩ��
			List<Menu> menuList = menuService.listAllMenuQx("0");	//��ȡ���в˵�
			menuList = this.readMenu(menuList, roleRights);			//���ݽ�ɫȨ�޴���˵�Ȩ��״̬(�ݹ鴦��)
			JSONArray arr = JSONArray.fromObject(menuList);
			String json = arr.toString();
			json = json.replaceAll("MENU_ID", "id").replaceAll("PARENT_ID", "pId").replaceAll("MENU_NAME", "name").replaceAll("subMenu", "nodes").replaceAll("hasMenu", "checked");
			model.addAttribute("zTreeNodes", json);
			mv.addObject("ROLE_ID",ROLE_ID);
			mv.setViewName("system/role/menuqx");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**�����ɫ�˵�Ȩ��
	 * @param ROLE_ID ��ɫID
	 * @param menuIds �˵�ID����
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/saveMenuqx")
	public void saveMenuqx(@RequestParam String ROLE_ID,@RequestParam String menuIds,PrintWriter out)throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"�޸Ĳ˵�Ȩ��");
		PageData pd = new PageData();
		try{
			if(null != menuIds && !"".equals(menuIds.trim())){
				BigInteger rights = RightsHelper.sumRights(Tools.str2StrArray(menuIds));//�ò˵�ID��Ȩ����
				Role role = roleService.getRoleById(ROLE_ID);	//ͨ��id��ȡ��ɫ����
				role.setRIGHTS(rights.toString());
				roleService.updateRoleRights(role);				//���µ�ǰ��ɫ�˵�Ȩ��
				pd.put("rights",rights.toString());
			}else{
				Role role = new Role();
				role.setRIGHTS("");
				role.setROLE_ID(ROLE_ID);
				roleService.updateRoleRights(role);				//���µ�ǰ��ɫ�˵�Ȩ��(û���κι�ѡ)
				pd.put("rights","");
			}
				pd.put("ROLE_ID", ROLE_ID);
				roleService.setAllRights(pd);					//���´˽�ɫ�����ӽ�ɫ�Ĳ˵�Ȩ��
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
	}

	/**�����ɫ��ť��Ȩҳ��(��ɾ�Ĳ�)
	 * @param ROLE_ID�� ��ɫID
	 * @param msg�� ������ɾ�Ĳ�
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/b4Button")
	public ModelAndView b4Button(@RequestParam String ROLE_ID,@RequestParam String msg,Model model)throws Exception{
		ModelAndView mv = this.getModelAndView();
		try{
			List<Menu> menuList = menuService.listAllMenuQx("0"); //��ȡ���в˵�
			Role role = roleService.getRoleById(ROLE_ID);		  //���ݽ�ɫID��ȡ��ɫ����
			String roleRights = "";
			if("add_qx".equals(msg)){
				roleRights = role.getADD_QX();	//����Ȩ��
			}else if("del_qx".equals(msg)){
				roleRights = role.getDEL_QX();	//ɾ��Ȩ��
			}else if("edit_qx".equals(msg)){
				roleRights = role.getEDIT_QX();	//�޸�Ȩ��
			}else if("cha_qx".equals(msg)){
				roleRights = role.getCHA_QX();	//�鿴Ȩ��
			}
			menuList = this.readMenu(menuList, roleRights);		//���ݽ�ɫȨ�޴���˵�Ȩ��״̬(�ݹ鴦��)
			JSONArray arr = JSONArray.fromObject(menuList);
			String json = arr.toString();
			json = json.replaceAll("MENU_ID", "id").replaceAll("PARENT_ID", "pId").replaceAll("MENU_NAME", "name").replaceAll("subMenu", "nodes").replaceAll("hasMenu", "checked");
			model.addAttribute("zTreeNodes", json);
			mv.addObject("ROLE_ID",ROLE_ID);
			mv.addObject("msg", msg);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		mv.setViewName("system/role/b4Button");
		return mv;
	}
	
	/**���ݽ�ɫȨ�޴���Ȩ��״̬(�ݹ鴦��)
	 * @param menuList��������ܲ˵�
	 * @param roleRights�����ܵ�Ȩ���ַ���
	 * @return
	 */
	public List<Menu> readMenu(List<Menu> menuList,String roleRights){
		for(int i=0;i<menuList.size();i++){
			menuList.get(i).setHasMenu(RightsHelper.testRights(roleRights, menuList.get(i).getMENU_ID()));
			this.readMenu(menuList.get(i).getSubMenu(), roleRights);					//�ǣ������Ų����Ӳ˵�
		}
		return menuList;
	}
	
	/**
	 * �����ɫ��ťȨ��
	 */
	/**
	 * @param ROLE_ID
	 * @param menuIds
	 * @param msg
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/saveB4Button")
	public void saveB4Button(@RequestParam String ROLE_ID,@RequestParam String menuIds,@RequestParam String msg,PrintWriter out)throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"�޸�"+msg+"Ȩ��");
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			if(null != menuIds && !"".equals(menuIds.trim())){
				BigInteger rights = RightsHelper.sumRights(Tools.str2StrArray(menuIds));
				pd.put("value",rights.toString());
			}else{
				pd.put("value","");
			}
			pd.put("ROLE_ID", ROLE_ID);
			roleService.saveB4Button(msg,pd);
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
	}
	
}