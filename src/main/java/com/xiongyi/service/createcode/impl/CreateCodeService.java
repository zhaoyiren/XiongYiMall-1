package com.xiongyi.service.createcode.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiongyi.dao.DaoSupport;
import com.xiongyi.entity.Page;
import com.xiongyi.service.createcode.CreateCodeManager;
import com.xiongyi.util.PageData;



/**
 * @author GUXIONG
 * @description CreateCodeService 代码生成器
 */
@Service("createcodeService")
public class CreateCodeService implements CreateCodeManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public void save(PageData pd)throws Exception{
		dao.save("CreateCodeMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public void delete(PageData pd)throws Exception{
		dao.delete("CreateCodeMapper.delete", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("CreateCodeMapper.datalistPage", page);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("CreateCodeMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	@Override
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("CreateCodeMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

