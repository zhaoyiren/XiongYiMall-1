package com.xiongyi.service.buttonrights.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiongyi.dao.DaoSupport;
import com.xiongyi.service.buttonrights.ButtonrightsManager;
import com.xiongyi.util.PageData;


/**
 * @author GUXIONG
 * @description ��ťȨ��
 */
@Service("buttonrightsService")
public class ButtonrightsService implements ButtonrightsManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**����
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public void save(PageData pd)throws Exception{
		dao.save("ButtonrightsMapper.save", pd);
	}
	
	/**ͨ��(��ɫID�Ͱ�ťID)��ȡ����
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public PageData findById(PageData pd) throws Exception {
		return (PageData)dao.findForObject("ButtonrightsMapper.findById", pd);
	}
	
	/**ɾ��
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public void delete(PageData pd)throws Exception{
		dao.delete("ButtonrightsMapper.delete", pd);
	}
	
	/**�б�(ȫ��)
	 * @param pd
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("ButtonrightsMapper.listAll", pd);
	}
	
	/**�б�(ȫ��)�����Ӱ�ť��,�����ȫȨ�ޱ�ʶ
	 * @param pd
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<PageData> listAllBrAndQxname(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("ButtonrightsMapper.listAllBrAndQxname", pd);
	}

}

