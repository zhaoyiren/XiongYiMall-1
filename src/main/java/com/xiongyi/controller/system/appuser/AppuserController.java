package com.xiongyi.controller.system.appuser;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiongyi.controller.base.BaseController;
import com.xiongyi.entity.Page;
import com.xiongyi.entity.Role;
import com.xiongyi.service.appuser.AppuserManager;
import com.xiongyi.service.role.RoleManager;
import com.xiongyi.util.AppUtil;
import com.xiongyi.util.Jurisdiction;
import com.xiongyi.util.MD5;
import com.xiongyi.util.ObjectExcelView;
import com.xiongyi.util.PageData;





/**
 * @author GUXIONG
 * @description AppuserController
 *
 */
@Controller
@RequestMapping(value="/happuser")
public class AppuserController extends BaseController {
	
	String menuUrl = "happuser/listUsers.do"; //�˵���ַ(Ȩ����)
	@Resource(name="appuserService")
	private AppuserManager appuserService;
	@Resource(name="roleService")
	private RoleManager roleService;
	
	/**��ʾ�û��б�
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/listUsers")
	public ModelAndView listUsers(Page page){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			String keywords = pd.getString("keywords");							//�������� �ؼ���
			if(null != keywords && !"".equals(keywords)){
				pd.put("keywords", keywords.trim());
			}
			page.setPd(pd);
			List<PageData>	userList = appuserService.listPdPageUser(page);		//�г���Ա�б�
			pd.put("ROLE_ID", "2");
			List<Role> roleList = roleService.listAllRolesByPId(pd);			//�г���Ա���ɫ
			mv.setViewName("system/appuser/appuser_list");
			mv.addObject("userList", userList);
			mv.addObject("roleList", roleList);
			mv.addObject("pd", pd);
			mv.addObject("QX",Jurisdiction.getHC());	//��ťȨ��
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**ȥ�����û�ҳ��
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/goAddU")
	public ModelAndView goAddU() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("ROLE_ID", "2");
		List<Role> roleList = roleService.listAllRolesByPId(pd);			//�г���Ա���ɫ
		mv.setViewName("system/appuser/appuser_edit");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		mv.addObject("roleList", roleList);
		return mv;
	}
	
	/**�����û�
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveU")
	public ModelAndView saveU() throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"������Ա");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USER_ID", this.get32UUID());	//ID
		pd.put("RIGHTS", "");					
		pd.put("LAST_LOGIN", "");				//����¼ʱ��
		pd.put("IP", "");						//IP
		pd.put("PASSWORD", MD5.md5(pd.getString("PASSWORD")));
		if(null == appuserService.findByUsername(pd)){
			appuserService.saveU(pd);			//�ж�����Ȩ��
			mv.addObject("msg","success");
		}else{
			mv.addObject("msg","failed");
		}
		mv.setViewName("save_result");
		return mv;
	}
	
	/**�ж��û����Ƿ����
	 * @return
	 */
	@RequestMapping(value="/hasU")
	@ResponseBody
	public Object hasU(){
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "success";
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(appuserService.findByUsername(pd) != null){
				errInfo = "error";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);				//���ؽ��
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**�ж������Ƿ����
	 * @return
	 */
	@RequestMapping(value="/hasE")
	@ResponseBody
	public Object hasE(){
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "success";
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(appuserService.findByEmail(pd) != null){
				errInfo = "error";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);				//���ؽ��
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**�жϱ����Ƿ����
	 * @return
	 */
	@RequestMapping(value="/hasN")
	@ResponseBody
	public Object hasN(){
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "success";
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(appuserService.findByNumber(pd) != null){
				errInfo = "error";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);				//���ؽ��
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**ɾ���û�
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteU")
	public void deleteU(PrintWriter out) throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"ɾ����Ա");
		PageData pd = new PageData();
		pd = this.getPageData();
		appuserService.deleteU(pd);
		out.write("success");
		out.close();
	}
	
	/**�޸��û�
	 * @param out
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/editU")
	public ModelAndView editU(PrintWriter out) throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"�޸Ļ�Ա");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		if(pd.getString("PASSWORD") != null && !"".equals(pd.getString("PASSWORD"))){
			pd.put("PASSWORD", MD5.md5(pd.getString("PASSWORD")));
		}
		appuserService.editU(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**ȥ�޸��û�ҳ��
	 * @return
	 */
	@RequestMapping(value="/goEditU")
	public ModelAndView goEditU(){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			pd.put("ROLE_ID", "2");
			List<Role> roleList = roleService.listAllRolesByPId(pd);//�г���Ա���ɫ
			pd = appuserService.findByUiId(pd);						//����ID��ȡ
			mv.setViewName("system/appuser/appuser_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			mv.addObject("roleList", roleList);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}
	
	/**����ɾ��
	 * @return
	 */
	@RequestMapping(value="/deleteAllU")
	@ResponseBody
	public Object deleteAllU() {
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"����ɾ����Ա");
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String USER_IDS = pd.getString("USER_IDS");
			if(null != USER_IDS && !"".equals(USER_IDS)){
				String ArrayUSER_IDS[] = USER_IDS.split(",");
				appuserService.deleteAllU(ArrayUSER_IDS);
				pd.put("msg", "ok");
			}else{
				pd.put("msg", "no");
			}
			pdList.add(pd);
			map.put("list", pdList);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);
		}
		return AppUtil.returnObject(pd, map);
	}
	
	/**������Ա��Ϣ��excel
	 * @return
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel(){
		logBefore(logger, Jurisdiction.getUsername()+"������Ա����");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			if(Jurisdiction.buttonJurisdiction(menuUrl, "cha")){	
				String keywords = pd.getString("keywords");
				if(null != keywords && !"".equals(keywords)){
					pd.put("keywords", keywords.trim());
				}
				String lastLoginStart = pd.getString("lastLoginStart");
				String lastLoginEnd = pd.getString("lastLoginEnd");
				if(lastLoginStart != null && !"".equals(lastLoginStart)){
					pd.put("lastLoginStart", lastLoginStart+" 00:00:00");
				}
				if(lastLoginEnd != null && !"".equals(lastLoginEnd)){
					pd.put("lastLoginEnd", lastLoginEnd+" 00:00:00");
				} 
				Map<String,Object> dataMap = new HashMap<String,Object>();
				List<String> titles = new ArrayList<String>();
				titles.add("�û���"); 		//1
				titles.add("���");  		//2
				titles.add("����");			//3
				titles.add("�ֻ���");		//4
				titles.add("���֤��");		//5
				titles.add("�ȼ�");			//6
				titles.add("����");			//7
				titles.add("�����¼");		//8
				titles.add("����ʱ��");		//9
				titles.add("�ϴε�¼IP");	//10
				dataMap.put("titles", titles);
				List<PageData> userList = appuserService.listAllUser(pd);
				List<PageData> varList = new ArrayList<PageData>();
				for(int i=0;i<userList.size();i++){
					PageData vpd = new PageData();
					vpd.put("var1", userList.get(i).getString("USERNAME"));		//1
					vpd.put("var2", userList.get(i).getString("NUMBER"));		//2
					vpd.put("var3", userList.get(i).getString("NAME"));			//3
					vpd.put("var4", userList.get(i).getString("PHONE"));		//4
					vpd.put("var5", userList.get(i).getString("SFID"));			//5
					vpd.put("var6", userList.get(i).getString("ROLE_NAME"));	//6
					vpd.put("var7", userList.get(i).getString("EMAIL"));		//7
					vpd.put("var8", userList.get(i).getString("LAST_LOGIN"));	//8
					vpd.put("var9", userList.get(i).getString("END_TIME"));		//9
					vpd.put("var10", userList.get(i).getString("IP"));			//10
					varList.add(vpd);
				}
				dataMap.put("varList", varList);
				ObjectExcelView erv = new ObjectExcelView();
				mv = new ModelAndView(erv,dataMap);
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
	
}
