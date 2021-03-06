package com.xiongyi.controller.business.goods;

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
import com.xiongyi.entity.Dictionaries;
import com.xiongyi.entity.Page;
import com.xiongyi.util.AppUtil;
import com.xiongyi.util.Const;
import com.xiongyi.util.DateUtil;
import com.xiongyi.util.DelAllFile;
import com.xiongyi.util.FileUpload;
import com.xiongyi.util.ObjectExcelView;
import com.xiongyi.util.PageData;
import com.xiongyi.util.PathUtil;
import com.xiongyi.util.Jurisdiction;
import com.xiongyi.service.business.goods.GoodsManager;
import com.xiongyi.service.dictionaries.DictionariesManager;

/** 
 * 说明：商品表
 * 创建人：XY
 * 创建时间：2018-01-27
 */
@Controller
@RequestMapping(value="/goods")
public class GoodsController extends BaseController {
	
	String menuUrl = "goods/list.do"; //菜单地址(权限用)
	@Resource(name="goodsService")
	private GoodsManager goodsService;
	
	@Resource(name="dictionariesService")
	private DictionariesManager dictionariesService;
	
	//数据字典中商品类型ID
	private static final String PARENTId = "38f53490f8bf4feb95ebaa9e8a69668a";
	
	//数据字典中商品状态ID
	private static final String GOODSSTATUSPARENTID = "3f5cdd1da9724fb5b736ffe2c5e2b5e4";
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(
			HttpServletRequest request,
			@RequestParam(value="tp",required=false) MultipartFile file,
			@RequestParam(value="GOODSNAME",required=false) String GOODSNAME,
			@RequestParam(value="GOODSCODE",required=false) String GOODSCODE,
			@RequestParam(value="GOODSTYPE",required=false) String GOODSTYPE
			) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Goods");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		
		String  ffile = DateUtil.getDays(), fileName = "";
		if (null != file && !file.isEmpty()) {
			String filePath = PathUtil.getServerPath(getRequest()) + "\\" + ffile;		//文件上传路径
			fileName = FileUpload.fileUp(file, filePath, this.get32UUID());				//执行上传
		} else {
			System.out.println("上传失败");
		}
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("GOODS_ID", this.get32UUID());	//主键
		pd.put("GOODSNAME", GOODSNAME);	//商品名称		
		pd.put("GOODSCODE",GOODSCODE);	//商品编码		
		pd.put("GOODSTYPE", GOODSTYPE);	//商品类型		
		pd.put("GOODSPICTURE", ffile + "/" + fileName);	//图片路径
		goodsService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Goods");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		goodsService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**上架
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/up")
	public void up(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"上架Goods");
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData pageData = goodsService.findById(pd);
		pageData.put("GOODSSTATE", "ced0ab752c5c4e3c87b311c6f1cfc7de");
		pageData.put("PUBLISHDATE", DateUtil.getTime());
		goodsService.edit(pageData);
		out.write("success");
		out.close();
	}
	
	/**下架
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/down")
	public void down(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"上架Goods");
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData pageData = goodsService.findById(pd);
		pageData.put("GOODSSTATE", "c10f36e143514126806d6422306c490d");
		pageData.put("DOWNPUBLISHDATE", DateUtil.getTime());
		goodsService.edit(pageData);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(
			HttpServletRequest request,
			@RequestParam(value="tp",required=false) MultipartFile file,
			@RequestParam(value="tpz",required=false) String tpz,
			@RequestParam(value="GOODS_ID",required=false) String GOODS_ID,
			@RequestParam(value="GOODSNAME",required=false) String GOODSNAME,
			@RequestParam(value="GOODSCODE",required=false) String GOODSCODE,
			@RequestParam(value="GOODSTYPE",required=false) String GOODSTYPE
			) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Goods");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		if(null == tpz){tpz = "";}
		String  ffile = DateUtil.getDays(), fileName = "";
		if (null != file && !file.isEmpty()) {
			String filePath = PathUtil.getServerPath(getRequest()) + "\\" + ffile;	//文件上传路径
			fileName = FileUpload.fileUp(file, filePath, this.get32UUID());			//执行上传
			pd.put("GOODSPICTURE", ffile + "/" + fileName);									//路径
		}else{
			pd.put("GOODSPICTURE", tpz);
		}
		
		pd.put("GOODS_ID", GOODS_ID);	//商品ID
		pd.put("GOODSNAME", GOODSNAME);	//商品名称		
		pd.put("GOODSCODE",GOODSCODE);	//商品编码		
		pd.put("GOODSTYPE", GOODSTYPE);	//商品类型		
		goodsService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Goods");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		String publishDate = pd.getString("PUBLISHDATE");	//上架时间检索
		String downPublishDate = pd.getString("DOWNPUBLISHDATE");		//下架时间检索
		String goodsType = pd.getString("GOODSTYPE");	//商品类型检索
		String goodsState = pd.getString("GOODSSTATE");	//商品状态检索
		if(publishDate != null && !"".equals(publishDate)){
			pd.put("publishDate", publishDate+" 00:00:00");
		}
		if(downPublishDate != null && !"".equals(downPublishDate)){
			pd.put("downPublishDate", downPublishDate+" 00:00:00");
		} 
		if(goodsType != null && !"".equals(goodsType)) {
			pd.put("goodsType", goodsType);
		}
		if(goodsState != null && !"".equals(goodsState)) {
			pd.put("goodsState", goodsState);
		}
		page.setPd(pd);
		List<PageData> beforeVarList = goodsService.list(page);
		List<PageData>	varList = null;	//列出Goods列表
		for (PageData pageData : beforeVarList) {
			PageData dictionary = new PageData();
			dictionary.put("DICTIONARIES_ID", pageData.getString("GOODSTYPE"));
			
			PageData statusDictionary = new PageData();
			statusDictionary.put("DICTIONARIES_ID", pageData.getString("GOODSSTATE"));
			
			//根据商品表中商品类型查出对应数据字典中的实体
			PageData dictionaries = dictionariesService.findById(dictionary);
			//将页面中展示的ID转换成对应数据字典实体的名称
			pageData.put("GOODSTYPE", dictionaries.getString("NAME"));
			
			//根据商品表中商品状态查出对应数据字典中的实体
			PageData statusDictionaries = dictionariesService.findById(statusDictionary);
			//将页面中展示的ID转换成对应数据字典实体的名称
			pageData.put("GOODSSTATE", statusDictionaries.getString("NAME"));
			
			varList = new ArrayList<PageData>();
			//添加到Goods列表中
			varList.add(pageData);
		}
		//通过商品类型父ID查询出子节点
		List<Dictionaries> goodsTypeList = dictionariesService.listSubDictByParentId(PARENTId);
		mv.addObject("goodsTypeList", goodsTypeList);
		//通过商品状态父ID查询出子节点
		List<Dictionaries> goodsStatusList = dictionariesService.listSubDictByParentId(GOODSSTATUSPARENTID);
		mv.addObject("goodsStatusList", goodsStatusList);
		mv.setViewName("business/goods/goods_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		//通过父ID查询出子节点
		List<Dictionaries> goodsTypeList = dictionariesService.listSubDictByParentId(PARENTId);
		mv.addObject("goodsTypeList", goodsTypeList);
		mv.setViewName("business/goods/goods_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = goodsService.findById(pd);	//根据ID读取
		//商品类型ID
		String parentId = "38f53490f8bf4feb95ebaa9e8a69668a";
		//通过父ID查询出子节点
		List<Dictionaries> goodsTypeList = dictionariesService.listSubDictByParentId(parentId);
		mv.addObject("goodsTypeList", goodsTypeList);
		mv.setViewName("business/goods/goods_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Goods");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			goodsService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	/**删除图片
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deltp")
	public void deltp(PrintWriter out) throws Exception {
		logBefore(logger, "删除图片");
		PageData pd = new PageData();
		pd = this.getPageData();
		
		String GOODSPICTURE = pd.getString("GOODSPICTURE");													 		//图片路径
		DelAllFile.delFolder(PathUtil.getClasspath()+ Const.FILEPATHIMG + GOODSPICTURE); 	//删除图片
		if(GOODSPICTURE != null){
			PageData findById = goodsService.findById(pd);
			findById.put("GOODSPICTURE", "");
			goodsService.edit(findById);
		}	
		out.write("success");
		out.close();
	}
	
	 /**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Goods到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("商品名称");	//1
		titles.add("商品编号");	//2
		titles.add("商品封面图");	//3
		titles.add("上货时间");	//4
		titles.add("下架时间");	//5
		dataMap.put("titles", titles);
		List<PageData> varOList = goodsService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("GOODSNAME"));	//1
			vpd.put("var2", varOList.get(i).getString("GOODSCODE"));	//2
			vpd.put("var3", varOList.get(i).getString("GOODSPICTURE"));	//3
			vpd.put("var4", varOList.get(i).getString("PUBLISHDATE"));	//4
			vpd.put("var5", varOList.get(i).getString("DOWNPUBLISHDATE"));	//5
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
		ObjectExcelView erv = new ObjectExcelView();
		mv = new ModelAndView(erv,dataMap);
		return mv;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
