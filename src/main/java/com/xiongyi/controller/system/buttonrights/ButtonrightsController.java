package com.xiongyi.controller.system.buttonrights;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.xiongyi.entity.Role;
import com.xiongyi.service.buttonrights.ButtonrightsManager;
import com.xiongyi.service.role.RoleManager;
import com.xiongyi.service.xybutton.XybuttonManager;
import com.xiongyi.util.AppUtil;
import com.xiongyi.util.Jurisdiction;
import com.xiongyi.util.PageData;


/**
 * @author GUXIONG
 * @description ��ťȨ��
 *
 */
@Controller
@RequestMapping(value="/buttonrights")
public class ButtonrightsController extends BaseController {
	
	String menuUrl = "buttonrights/list.do"; //�˵���ַ(Ȩ����)
	@Resource(name="buttonrightsService")
	private ButtonrightsManager buttonrightsService;
	@Resource(name="roleService")
	private RoleManager roleService;
	@Resource(name="xybuttonService")
	private XybuttonManager xybuttonService;
	
	/**�б�
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"�б�Buttonrights");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		if(pd.getString("ROLE_ID") == null || "".equals(pd.getString("ROLE_ID").trim())){
			pd.put("ROLE_ID", "1");										//Ĭ���г���һ���ɫ(��ʼ���ϵͳ�û��ͻ�Ա�鲻��ɾ��)
		}
		PageData fpd = new PageData();
		fpd.put("ROLE_ID", "0");
		List<Role> roleList = roleService.listAllRolesByPId(fpd);			//�г���(ҳ��������е�һ����)
		List<Role> roleList_z = roleService.listAllRolesByPId(pd);			//�г������¼ܽ�ɫ
		List<PageData> buttonlist = xybuttonService.listAll(pd);			//�г����а�ť
		List<PageData> roleFhbuttonlist = buttonrightsService.listAll(pd);	//�г����н�ɫ��ť��������
		pd = roleService.findObjectById(pd);								//ȡ�õ���Ľ�ɫ��(���ŵ�)
		mv.addObject("pd", pd);
		mv.addObject("roleList", roleList);
		mv.addObject("roleList_z", roleList_z);
		mv.addObject("buttonlist", buttonlist);
		mv.addObject("roleFhbuttonlist", roleFhbuttonlist);
		mv.addObject("QX",Jurisdiction.getHC());	//��ťȨ��
		mv.setViewName("system/buttonrights/buttonrights_list");
		return mv;
	}
	
	/**�����ť���������
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/upRb")
	@ResponseBody
	public Object updateRolebuttonrightd()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"���䰴ťȨ��");
		Map<String,String> map = new HashMap<String,String>();
		PageData pd = new PageData();
		pd = this.getPageData();
		String errInfo = "success";
		if(null != buttonrightsService.findById(pd)){	//�жϹ������Ƿ������� ��:ɾ��/��:����
			buttonrightsService.delete(pd);		//ɾ��
		}else{
			pd.put("RB_ID", this.get32UUID());	//����
			buttonrightsService.save(pd);		//����
		}
		map.put("result", errInfo);
		return AppUtil.returnObject(new PageData(), map);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
