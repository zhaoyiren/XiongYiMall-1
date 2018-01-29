package com.xiongyi.service.xybutton.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiongyi.dao.DaoSupport;
import com.xiongyi.entity.Page;
import com.xiongyi.service.xybutton.XybuttonManager;
import com.xiongyi.util.PageData;

/**
 * @author GUXIONG
 * @description ��ť���� 
 */
@Service("xybuttonService")
public class XybuttonService implements XybuttonManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**����
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public void save(PageData pd)throws Exception{
		dao.save("XybuttonMapper.save", pd);
	}
	
	/**ɾ��
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public void delete(PageData pd)throws Exception{
		dao.delete("XybuttonMapper.delete", pd);
	}
	
	/**�޸�
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public void edit(PageData pd)throws Exception{
		dao.update("XybuttonMapper.edit", pd);
	}
	
	/**�б�
	 * @param page
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("XybuttonMapper.datalistPage", page);
	}
	
	/**�б�(ȫ��)
	 * @param pd
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("XybuttonMapper.listAll", pd);
	}
	
	/**ͨ��id��ȡ����
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("XybuttonMapper.findById", pd);
	}
	
	/**����ɾ��
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	@Override
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("XybuttonMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

