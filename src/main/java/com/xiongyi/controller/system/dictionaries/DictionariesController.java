package com.xiongyi.controller.system.dictionaries;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiongyi.controller.base.BaseController;
import com.xiongyi.entity.Page;
import com.xiongyi.service.dictionaries.DictionariesManager;
import com.xiongyi.util.AppUtil;
import com.xiongyi.util.Jurisdiction;
import com.xiongyi.util.PageData;

import net.sf.json.JSONArray;



/**
 * @author GUXIONG
 * @description �����ֵ�
 */
@Controller
@RequestMapping(value="/dictionaries")
public class DictionariesController extends BaseController {
	
	String menuUrl = "dictionaries/list.do"; //�˵���ַ(Ȩ����)
	@Resource(name="dictionariesService")
	private DictionariesManager dictionariesService;
	
	/**����
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"����Dictionaries");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //У��Ȩ��
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("DICTIONARIES_ID", this.get32UUID());	//����
		dictionariesService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * ɾ��
	 * @param DICTIONARIES_ID
	 * @param
	 * @throws Exception 
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(@RequestParam String DICTIONARIES_ID) throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"ɾ��Dictionaries");
		Map<String,String> map = new HashMap<String,String>();
		PageData pd = new PageData();
		pd.put("DICTIONARIES_ID", DICTIONARIES_ID);
		String errInfo = "success";
		if(dictionariesService.listSubDictByParentId(DICTIONARIES_ID).size() > 0){//�ж��Ƿ����Ӽ����ǣ�������ɾ��
			errInfo = "false";
		}else{
			pd = dictionariesService.findById(pd);//����ID��ȡ
			if(null != pd.get("TBSNAME") && !"".equals(pd.getString("TBSNAME"))){
				String[] table = pd.getString("TBSNAME").split(",");
				for(int i=0;i<table.length;i++){
					pd.put("thisTable", table[i]);
					try {
						if(Integer.parseInt(dictionariesService.findFromTbs(pd).get("zs").toString())>0){//�ж��Ƿ�ռ�ã��ǣ�������ɾ��(ȥ�Ų�����ֵ���еı����ֶ�)
							errInfo = "false";
							break;
						}
					} catch (Exception e) {
							errInfo = "false2";
							break;
					}
				}
			}
		}
		if("success".equals(errInfo)){
			dictionariesService.delete(pd);	//ִ��ɾ��
		}
		map.put("result", errInfo);
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**�޸�
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"�޸�Dictionaries");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //У��Ȩ��
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		dictionariesService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**�б�
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"�б�Dictionaries");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");					//��������
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		String DICTIONARIES_ID = null == pd.get("DICTIONARIES_ID")?"":pd.get("DICTIONARIES_ID").toString();
		if(null != pd.get("id") && !"".equals(pd.get("id").toString())){
			DICTIONARIES_ID = pd.get("id").toString();
		}
		pd.put("DICTIONARIES_ID", DICTIONARIES_ID);					//�ϼ�ID
		page.setPd(pd);
		List<PageData>	varList = dictionariesService.list(page);	//�г�Dictionaries�б�
		mv.addObject("pd", dictionariesService.findById(pd));		//�����ϼ�������Ϣ
		mv.addObject("DICTIONARIES_ID", DICTIONARIES_ID);			//�ϼ�ID
		mv.setViewName("system/dictionaries/dictionaries_list");
		mv.addObject("varList", varList);
		mv.addObject("QX",Jurisdiction.getHC());					//��ťȨ��
		return mv;
	}
	
	/**
	 * ��ʾ�б�ztree
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/listAllDict")
	public ModelAndView listAllDict(Model model,String DICTIONARIES_ID)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			JSONArray arr = JSONArray.fromObject(dictionariesService.listAllDict("0"));
			String json = arr.toString();
			json = json.replaceAll("DICTIONARIES_ID", "id").replaceAll("PARENT_ID", "pId").replaceAll("NAME", "name").replaceAll("subDict", "nodes").replaceAll("hasDict", "checked").replaceAll("treeurl", "url");
			model.addAttribute("zTreeNodes", json);
			mv.addObject("DICTIONARIES_ID",DICTIONARIES_ID);
			mv.addObject("pd", pd);	
			mv.setViewName("system/dictionaries/dictionaries_ztree");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**ȥ����ҳ��
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String DICTIONARIES_ID = null == pd.get("DICTIONARIES_ID")?"":pd.get("DICTIONARIES_ID").toString();
		pd.put("DICTIONARIES_ID", DICTIONARIES_ID);					//�ϼ�ID
		mv.addObject("pds",dictionariesService.findById(pd));		//�����ϼ�������Ϣ
		mv.addObject("DICTIONARIES_ID", DICTIONARIES_ID);			//����ID����Ϊ�Ӽ�ID��
		mv.setViewName("system/dictionaries/dictionaries_edit");
		mv.addObject("msg", "save");
		return mv;
	}	
	
	 /**ȥ�޸�ҳ��
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String DICTIONARIES_ID = pd.getString("DICTIONARIES_ID");
		pd = dictionariesService.findById(pd);	//����ID��ȡ
		mv.addObject("pd", pd);					//������ͼ����
		pd.put("DICTIONARIES_ID",pd.get("PARENT_ID").toString());			//�����ϼ���Ϣ
		mv.addObject("pds",dictionariesService.findById(pd));				//�����ϼ�������Ϣ
		mv.addObject("DICTIONARIES_ID", pd.get("PARENT_ID").toString());	//�����ϼ�ID����Ϊ��ID��
		pd.put("DICTIONARIES_ID",DICTIONARIES_ID);							//��ԭ��ID
		mv.setViewName("system/dictionaries/dictionaries_edit");
		mv.addObject("msg", "edit");
		return mv;
	}	

	/**�жϱ����Ƿ����
	 * @return
	 */
	@RequestMapping(value="/hasBianma")
	@ResponseBody
	public Object hasBianma(){
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "success";
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(dictionariesService.findByBianma(pd) != null){
				errInfo = "error";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);				//���ؽ��
		return AppUtil.returnObject(new PageData(), map);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
