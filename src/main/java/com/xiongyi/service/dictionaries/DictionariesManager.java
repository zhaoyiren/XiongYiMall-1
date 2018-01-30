package com.xiongyi.service.dictionaries;

import java.util.List;

import com.xiongyi.entity.Dictionaries;
import com.xiongyi.entity.Page;
import com.xiongyi.util.PageData;



/**
 * @author GUXIONG
 * @description �����ֵ�ӿ���
 */
public interface DictionariesManager{

	/**����
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception;
	
	/**ɾ��
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception;
	
	/**�޸�
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception;
	
	/**�б�
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> list(Page page)throws Exception;
	
	/**ͨ��id��ȡ����
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;

	/**ͨ�������ȡ����
	 * @param pd
	 * @throws Exception
	 */
	public PageData findByBianma(PageData pd)throws Exception;
	
	/**
	 * ͨ��ID��ȡ���Ӽ��б�
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<Dictionaries> listSubDictByParentId(String parentId) throws Exception;
	
	/**
	 * ��ȡ�������ݲ����ÿ�����ݵ��Ӽ��б�(�ݹ鴦��)
	 * @param MENU_ID
	 * @return
	 * @throws Exception
	 */
	public List<Dictionaries> listAllDict(String parentId) throws Exception;
	
	/**�Ų�����Ƿ�ռ��
	 * @param pd
	 * @throws Exception
	 */
	public PageData findFromTbs(PageData pd)throws Exception;
	
}

