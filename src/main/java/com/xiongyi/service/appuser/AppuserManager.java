package com.xiongyi.service.appuser;

import java.util.List;

import com.xiongyi.entity.Page;
import com.xiongyi.util.PageData;





/**
 * @author GUXIONG
 * @description ��Ա�ӿ���
 */
public interface AppuserManager {
	
	/**�г�ĳ��ɫ�µ����л�Ա
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listAllAppuserByRorlid(PageData pd) throws Exception;
	
	/**��Ա�б�
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listPdPageUser(Page page)throws Exception;
	
	/**ͨ���û�����ȡ����
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByUsername(PageData pd)throws Exception;
	
	/**ͨ�������ȡ����
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByEmail(PageData pd)throws Exception;
	
	/**ͨ����Ż�ȡ����
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByNumber(PageData pd)throws Exception;
	
	/**�����û�
	 * @param pd
	 * @throws Exception
	 */
	public void saveU(PageData pd)throws Exception;
	
	/**ɾ���û�
	 * @param pd
	 * @throws Exception
	 */
	public void deleteU(PageData pd)throws Exception;
	
	/**�޸��û�
	 * @param pd
	 * @throws Exception
	 */
	public void editU(PageData pd)throws Exception;
	
	/**ͨ��id��ȡ����
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByUiId(PageData pd)throws Exception;
	
	/**ȫ����Ա
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listAllUser(PageData pd)throws Exception;
	
	/**����ɾ���û�
	 * @param USER_IDS
	 * @throws Exception
	 */
	public void deleteAllU(String[] USER_IDS)throws Exception;
	
	/**��ȡ����
	 * @param pd
	 * @throws Exception
	 */
	public PageData getAppUserCount(String value)throws Exception;
	
}

