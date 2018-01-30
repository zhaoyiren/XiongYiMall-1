package com.xiongyi.controller.information.pictures;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xiongyi.controller.base.BaseController;
import com.xiongyi.entity.Page;
import com.xiongyi.service.information.pictures.PicturesManager;
import com.xiongyi.util.AppUtil;
import com.xiongyi.util.Const;
import com.xiongyi.util.DateUtil;
import com.xiongyi.util.DelAllFile;
import com.xiongyi.util.FileUpload;
import com.xiongyi.util.Jurisdiction;
import com.xiongyi.util.PageData;
import com.xiongyi.util.PathUtil;
import com.xiongyi.util.Tools;

/**
 * @author GUXIONG
 * @description ͼƬ����
 */
@Controller
@RequestMapping(value="/pictures")
public class PicturesController extends BaseController {
	
	String menuUrl = "pictures/list.do"; //�˵���ַ(Ȩ����)
	@Resource(name="picturesService")
	private PicturesManager picturesService;
	
	/**�б�
	 * @param page
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String KEYW = pd.getString("keyword");	//��������
		if(null != KEYW && !"".equals(KEYW)){
			pd.put("KEYW", KEYW.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = picturesService.list(page);	//�г�Pictures�б�
		mv.setViewName("information/pictures/pictures_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//��ťȨ��
		return mv;
	}
	
	/**����
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public Object save(
			@RequestParam(required=false) MultipartFile file
			) throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"����ͼƬ");
		Map<String,String> map = new HashMap<String,String>();
		String  ffile = DateUtil.getDays(), fileName = "";
		PageData pd = new PageData();
		if(Jurisdiction.buttonJurisdiction(menuUrl, "add")){
			if (null != file && !file.isEmpty()) {
				String filePath = PathUtil.getServerPath(getRequest()) + "\\" + ffile;		//�ļ��ϴ�·��
				fileName = FileUpload.fileUp(file, filePath, this.get32UUID());				//ִ���ϴ�
			}else{
				System.out.println("�ϴ�ʧ��");
			}
			pd.put("PICTURES_ID", this.get32UUID());			//����
			pd.put("TITLE", "ͼƬ");								//����
			pd.put("NAME", fileName);							//�ļ���
			pd.put("PATH", ffile + "/" + fileName);				//·��
			pd.put("CREATETIME", Tools.date2Str(new Date()));	//����ʱ��
			pd.put("MASTER_ID", "1");							//������
			pd.put("BZ", "ͼƬ�����ϴ�");						//��ע
			//Watermark.setWatemark(PathUtil.getClassResources() + Const.FILEPATHIMG + ffile + "/" + fileName);//��ˮӡ
			picturesService.save(pd);
		}
		map.put("result", "ok");
		return AppUtil.returnObject(pd, map);
	}
	
	/**ɾ��
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"ɾ��ͼƬ");
		PageData pd = new PageData();
		if(Jurisdiction.buttonJurisdiction(menuUrl, "del")){
			pd = this.getPageData();
			DelAllFile.delFolder(PathUtil.getClasspath()+ Const.FILEPATHIMG + pd.getString("PATH")); //ɾ��ͼƬ
			picturesService.delete(pd);
		}
		out.write("success");
		out.close();
	}
	
	/**�޸�
	 * @param request
	 * @param file
	 * @param tpz
	 * @param PICTURES_ID
	 * @param TITLE
	 * @param MASTER_ID
	 * @param BZ
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(
			HttpServletRequest request,
			@RequestParam(value="tp",required=false) MultipartFile file,
			@RequestParam(value="tpz",required=false) String tpz,
			@RequestParam(value="PICTURES_ID",required=false) String PICTURES_ID,
			@RequestParam(value="TITLE",required=false) String TITLE,
			@RequestParam(value="MASTER_ID",required=false) String MASTER_ID,
			@RequestParam(value="BZ",required=false) String BZ
			) throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //У��Ȩ��
		logBefore(logger, Jurisdiction.getUsername()+"�޸�ͼƬ");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		if(Jurisdiction.buttonJurisdiction(menuUrl, "edit")){
			pd.put("PICTURES_ID", PICTURES_ID);		//ͼƬID
			pd.put("TITLE", TITLE);					//����
			pd.put("MASTER_ID", MASTER_ID);			//����ID
			pd.put("BZ", BZ);						//��ע
			if(null == tpz){tpz = "";}
			String  ffile = DateUtil.getDays(), fileName = "";
			if (null != file && !file.isEmpty()) {
				String filePath = PathUtil.getClasspath() + Const.FILEPATHIMG + ffile;	//�ļ��ϴ�·��
				fileName = FileUpload.fileUp(file, filePath, this.get32UUID());			//ִ���ϴ�
				pd.put("PATH", ffile + "/" + fileName);									//·��
				pd.put("NAME", fileName);
			}else{
				pd.put("PATH", tpz);
			}
			//Watermark.setWatemark(PathUtil.getClasspath() + Const.FILEPATHIMG + ffile + "/" + fileName);//��ˮӡ
			picturesService.edit(pd);				//ִ���޸����ݿ�
		}
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**ȥ����ҳ��
	 * @return
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd() throws Exception{
		logBefore(logger, "ȥ����Picturesҳ��");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("information/pictures/pictures_add");
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**ȥ�޸�ҳ��
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit() throws Exception{
		logBefore(logger, "ȥ�޸�Picturesҳ��");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = picturesService.findById(pd);	//����ID��ȡ
		mv.setViewName("information/pictures/pictures_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	/**����ɾ��
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception {
		logBefore(logger, "����ɾ��Pictures");
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		if(Jurisdiction.buttonJurisdiction(menuUrl, "del")){
			List<PageData> pdList = new ArrayList<PageData>();
			List<PageData> pathList = new ArrayList<PageData>();
			String DATA_IDS = pd.getString("DATA_IDS");
			if(null != DATA_IDS && !"".equals(DATA_IDS)){
				String ArrayDATA_IDS[] = DATA_IDS.split(",");
				pathList = picturesService.getAllById(ArrayDATA_IDS);
				for(int i=0;i<pathList.size();i++){
					DelAllFile.delFolder(PathUtil.getClasspath()+ Const.FILEPATHIMG + pathList.get(i).getString("PATH"));//ɾ��ͼƬ
				}
				picturesService.deleteAll(ArrayDATA_IDS);
				pd.put("msg", "ok");
			}else{
				pd.put("msg", "no");
			}
			pdList.add(pd);
			map.put("list", pdList);
			}
		return AppUtil.returnObject(pd, map);
	}
	
	/**ɾ��ͼƬ
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deltp")
	public void deltp(PrintWriter out) throws Exception {
		logBefore(logger, "ɾ��ͼƬ");
		PageData pd = new PageData();
		pd = this.getPageData();
		String PATH = pd.getString("PATH");													 		//ͼƬ·��
		DelAllFile.delFolder(PathUtil.getClasspath()+ Const.FILEPATHIMG + pd.getString("PATH")); 	//ɾ��ͼƬ
		if(PATH != null){
			picturesService.delTp(pd);																//ɾ�����ݿ���ͼƬ����
		}	
		out.write("success");
		out.close();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
