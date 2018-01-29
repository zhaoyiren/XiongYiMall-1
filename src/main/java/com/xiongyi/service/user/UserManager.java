package com.xiongyi.service.user;

import java.util.List;

import com.xiongyi.entity.Page;
import com.xiongyi.entity.User;
import com.xiongyi.util.PageData;




/**
 * @author GUXIONG
 * @description �û��ӿ���
 */
public interface UserManager {
	
	/**��¼�ж�
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData getUserByNameAndPwd(PageData pd)throws Exception;
	
	/**���µ�¼ʱ��
	 * @param pd
	 * @throws Exception
	 */
	public void updateLastLogin(PageData pd)throws Exception;
	
	/**ͨ���û�ID��ȡ�û���Ϣ�ͽ�ɫ��Ϣ
	 * @param USER_ID
	 * @return
	 * @throws Exception
	 */
	public User getUserAndRoleById(String USER_ID) throws Exception;
	
	/**ͨ��USERNAEME��ȡ����
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByUsername(PageData pd)throws Exception;
	
	/**�г�ĳ��ɫ�µ������û�
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listAllUserByRoldId(PageData pd) throws Exception;
	
	/**�����û�IP
	 * @param pd
	 * @throws Exception
	 */
	public void saveIP(PageData pd)throws Exception;
	
	/**�û��б�
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listUsers(Page page)throws Exception;
	
	/**ͨ�������ȡ����
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByUE(PageData pd)throws Exception;
	
	/**ͨ����Ż�ȡ����
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByUN(PageData pd)throws Exception;
	
	/**ͨ��id��ȡ����
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**�޸��û�
	 * @param pd
	 * @throws Exception
	 */
	public void editU(PageData pd)throws Exception;
	
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
	
	/**����ɾ���û�
	 * @param USER_IDS
	 * @throws Exception
	 */
	public void deleteAllU(String[] USER_IDS)throws Exception;
	
	/**�û��б�(ȫ��)
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listAllUser(PageData pd)throws Exception;
	
	/**��ȡ����
	 * @param pd
	 * @throws Exception
	 */
	public PageData getUserCount(String value)throws Exception;
	
}
