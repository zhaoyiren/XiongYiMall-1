package com.xiongyi.service.information.pictures;

import java.util.List;

import com.xiongyi.entity.Page;
import com.xiongyi.util.PageData;

/**
 * @author GUXIONG
 * @description ͼƬ����ӿ�
 */
public interface PicturesManager {
	
	/**�б�
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PageData> list(Page page)throws Exception;
	
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
	
	/**ͨ��id��ȡ����
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**����ɾ��
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception;
	
	/**������ȡ
	 * @param ArrayDATA_IDS
	 * @return
	 * @throws Exception
	 */
	public List<PageData> getAllById(String[] ArrayDATA_IDS)throws Exception;
	
	/**ɾ��ͼƬ
	 * @param pd
	 * @throws Exception
	 */
	public void delTp(PageData pd)throws Exception;
	
}

