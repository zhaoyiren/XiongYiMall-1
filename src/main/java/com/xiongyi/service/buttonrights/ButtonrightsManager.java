package com.xiongyi.service.buttonrights;

import java.util.List;

import com.xiongyi.util.PageData;




/**
 * @author GUXIONG
 * @description ��ťȨ�� �ӿ�
 */
public interface ButtonrightsManager{

	/**����
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception;
	
	/**ͨ��(��ɫID�Ͱ�ťID)��ȡ����
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**ɾ��
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception;
	
	/**�б�(ȫ��)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAll(PageData pd)throws Exception;
	
	/**�б�(ȫ��)�����Ӱ�ť��,�����ȫȨ�ޱ�ʶ
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAllBrAndQxname(PageData pd)throws Exception;
	
}

