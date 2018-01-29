package com.xiongyi.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.xiongyi.entity.Page;
import com.xiongyi.util.Logger;
import com.xiongyi.util.PageData;
import com.xiongyi.util.UuidUtil;

/**
 * @author GUXIONG
 *
 */
public class BaseController {
	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * new PageData����
	 * @return
	 */
	public PageData getPageData() {
		return new PageData(this.getRequest());
	}
	
	/**
	 * �õ�ModelAndView����
	 * @return
	 */
	public ModelAndView getModelAndView() {
		return new ModelAndView();
	}

	/**�õ�request����
	 * @return
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	/**�õ�32λ��uuid
	 * @return
	 */
	public String get32UUID(){
		return UuidUtil.get32UUID();
	}
	
	/**�õ���ҳ�б����Ϣ
	 * @return
	 */
	public Page getPage(){
		return new Page();
	}
	
	public static void logBefore(Logger logger, String interfaceName){
		logger.info("");
		logger.info("start");
		logger.info(interfaceName);
	}
	
	public static void logAfter(Logger logger){
		logger.info("end");
		logger.info("");
	}

}
