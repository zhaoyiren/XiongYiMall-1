package com.xiongyi.controller.system.createcode;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiongyi.controller.base.BaseController;
import com.xiongyi.entity.Page;
import com.xiongyi.service.createcode.CreateCodeManager;
import com.xiongyi.util.AppUtil;
import com.xiongyi.util.DateUtil;
import com.xiongyi.util.DelAllFile;
import com.xiongyi.util.FileDownload;
import com.xiongyi.util.FileZip;
import com.xiongyi.util.Freemarker;
import com.xiongyi.util.Jurisdiction;
import com.xiongyi.util.PageData;
import com.xiongyi.util.PathUtil;



/**
 * @author GUXIONG
 * @description CreateCodeController ����������
 *
 */
@Controller
@RequestMapping(value="/createCode")
public class CreateCodeController extends BaseController {
	
	String menuUrl = "createcode/list.do"; //�˵���ַ(Ȩ����)
	@Resource(name="createcodeService")
	private CreateCodeManager createcodeService;
	
	/**�б�
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//��������
		if(null != keywords && !"".equals(keywords)){
			keywords = keywords.trim();
			pd.put("keywords", keywords);
		}
		page.setPd(pd);
		List<PageData>	varList = createcodeService.list(page);	//�г�CreateCode�б�
		mv.setViewName("system/createcode/createcode_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//��ťȨ��
		return mv;
	}
	
	/**ȥ����������ҳ��(���뵯��)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goProductCode")
	public ModelAndView goProductCode() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String CREATECODE_ID = pd.getString("CREATECODE_ID");
		if(!"add".equals(CREATECODE_ID)){
			pd = createcodeService.findById(pd);
			mv.addObject("pd", pd);
			mv.addObject("msg", "edit");
		}else{
			mv.addObject("msg", "add");
		}
		mv.setViewName("system/createcode/productCode");
		return mv;
	}
	
	/**���ɴ���
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/proCode")
	public void proCode(HttpServletResponse response) throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){} 		//У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"ִ�д���������");
		PageData pd = new PageData();
		pd = this.getPageData();
		save(pd);	//���浽���ݿ�
		/* ============================================================================================= */
		String TITLE = pd.getString("TITLE");  						//˵��				========����0
		String packageName = pd.getString("packageName");  			//����				========����1
		String objectName = pd.getString("objectName");	   			//����				========����2
		String tabletop = pd.getString("tabletop");	   				//��ǰ׺				========����3
		tabletop = null == tabletop?"":tabletop.toUpperCase();		//��ǰ׺ת��д
		String zindext = pd.getString("zindex");	   	   			//��������
		int zindex = 0;
		if(null != zindext && !"".equals(zindext)){
			zindex = Integer.parseInt(zindext);
		}
		List<String[]> fieldList = new ArrayList<String[]>();   	//���Լ���			========����4
		for(int i=0; i< zindex; i++){
			fieldList.add(pd.getString("field"+i).split(",fh,"));	//���Էŵ���������
		}
		Map<String,Object> root = new HashMap<String,Object>();		//��������ģ��
		root.put("fieldList", fieldList);
		root.put("TITLE", TITLE);									//˵��
		root.put("packageName", packageName);						//����
		root.put("objectName", objectName);							//����
		root.put("objectNameLower", objectName.toLowerCase());		//����(ȫСд)
		root.put("objectNameUpper", objectName.toUpperCase());		//����(ȫ��д)
		root.put("tabletop", tabletop);								//��ǰ׺	
		root.put("nowDate", new Date());							//��ǰ����
		
		DelAllFile.delFolder(PathUtil.getClasspath()+"admin/ftl"); //���ɴ���ǰ,�����֮ǰ���ɵĴ���
		/* ============================================================================================= */
		
		String filePath = "admin/ftl/code/";						//���·��
		String ftlPath = "generatorCode";								//ftl·��
		
		/*����controller*/
		Freemarker.printFile("controllerTemplate.ftl", root, "controller/"+packageName+"/"+objectName.toLowerCase()+"/"+objectName+"Controller.java", filePath, ftlPath);
		
		/*����service*/
		Freemarker.printFile("serviceTemplate.ftl", root, "service/"+packageName+"/"+objectName.toLowerCase()+"/impl/"+objectName+"Service.java", filePath, ftlPath);
		
		/*����manager*/
		Freemarker.printFile("managerTemplate.ftl", root, "service/"+packageName+"/"+objectName.toLowerCase()+"/"+objectName+"Manager.java", filePath, ftlPath);
		
		/*����entity*/
		Freemarker.printFile("entityTemplate.ftl", root, "entity/"+packageName+"/"+objectName.toLowerCase()+"/"+objectName+".java", filePath, ftlPath);

		/*����mybatis xml*/
		Freemarker.printFile("mapperMysqlTemplate.ftl", root, "mybatis_mysql/"+packageName+"/"+objectName+"Mapper.xml", filePath, ftlPath);
		Freemarker.printFile("mapperOracleTemplate.ftl", root, "mybatis_oracle/"+packageName+"/"+objectName+"Mapper.xml", filePath, ftlPath);
		
		/*����SQL�ű�*/
		Freemarker.printFile("mysql_SQL_Template.ftl", root, "mysql���ݿ�ű�/"+tabletop+objectName.toUpperCase()+".sql", filePath, ftlPath);
		Freemarker.printFile("oracle_SQL_Template.ftl", root, "oracle���ݿ�ű�/"+tabletop+objectName.toUpperCase()+".sql", filePath, ftlPath);
		
		/*����jspҳ��*/
		Freemarker.printFile("jsp_list_Template.ftl", root, "jsp/"+packageName+"/"+objectName.toLowerCase()+"/"+objectName.toLowerCase()+"_list.jsp", filePath, ftlPath);
		Freemarker.printFile("jsp_edit_Template.ftl", root, "jsp/"+packageName+"/"+objectName.toLowerCase()+"/"+objectName.toLowerCase()+"_edit.jsp", filePath, ftlPath);
		
		
		//this.print("oracle_SQL_Template.ftl", root);  ����̨��ӡ
		
		/*���ɵ�ȫ������ѹ����zip�ļ�*/
		if(FileZip.zip(PathUtil.getClasspath()+"admin/ftl/code", PathUtil.getClasspath()+"admin/ftl/code.zip")){
			/*���ش���*/
			FileDownload.fileDownload(response, PathUtil.getClasspath()+"admin/ftl/code.zip", "code.zip");
		}
	}
	
	/**���浽���ݿ�
	 * @throws Exception
	 */
	public void save(PageData pd) throws Exception{
		pd.put("PACKAGENAME", pd.getString("packageName"));	//����
		pd.put("OBJECTNAME", pd.getString("objectName"));	//����
		pd.put("TABLENAME", pd.getString("tabletop")+",fh,"+pd.getString("objectName").toUpperCase());	//����
		pd.put("FIELDLIST", pd.getString("FIELDLIST"));		//���Լ���
		pd.put("CREATETIME", DateUtil.getTime());			//����ʱ��
		pd.put("TITLE", pd.getString("TITLE"));				//˵��
		pd.put("CREATECODE_ID", this.get32UUID());			//����
		createcodeService.save(pd);
	}
	
	/**ɾ��
	 * @param out
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"ɾ��CreateCode");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //У��Ȩ��
		PageData pd = new PageData();
		pd = this.getPageData();
		createcodeService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**
	 * ����ɾ��
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception {
		logBefore(logger, Jurisdiction.getUsername()+"����ɾ��CreateCode");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "dell")){return null;} //У��Ȩ��
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String DATA_IDS = pd.getString("DATA_IDS");
			if(null != DATA_IDS && !"".equals(DATA_IDS)){
				String ArrayDATA_IDS[] = DATA_IDS.split(",");
				createcodeService.deleteAll(ArrayDATA_IDS);
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
	
}