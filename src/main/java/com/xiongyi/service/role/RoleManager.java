package com.xiongyi.service.role;

import java.util.List;

import com.xiongyi.entity.Role;
import com.xiongyi.util.PageData;



/**
 * @author GUXIONG
 * @description ��ɫ�ӿ���
 */
public interface RoleManager {
	
	/**�г������¼���ɫ
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<Role> listAllRolesByPId(PageData pd) throws Exception;
	
	/**ͨ��id����
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findObjectById(PageData pd) throws Exception;
	
	/**���
	 * @param pd
	 * @throws Exception
	 */
	public void add(PageData pd) throws Exception;
	
	/**�����޸�
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd) throws Exception;
	
	/**ɾ����ɫ
	 * @param ROLE_ID
	 * @throws Exception
	 */
	public void deleteRoleById(String ROLE_ID) throws Exception;
	
	/**����ǰ��ɫ���Ӳ˵�Ȩ��
	 * @param role
	 * @throws Exception
	 */
	public void updateRoleRights(Role role) throws Exception;
	
	/**ͨ��id����
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public Role getRoleById(String ROLE_ID) throws Exception;
	
	/**��ȫ���ӽ�ɫ�Ӳ˵�Ȩ��
	 * @param pd
	 * @throws Exception
	 */
	public void setAllRights(PageData pd) throws Exception;
	
	/**Ȩ��(��ɾ�Ĳ�)
	 * @param msg ������ɾ�Ĳ�
	 * @param pd
	 * @throws Exception
	 */
	public void saveB4Button(String msg,PageData pd) throws Exception;

}
