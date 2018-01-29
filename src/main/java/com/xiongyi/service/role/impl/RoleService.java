package com.xiongyi.service.role.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiongyi.dao.DaoSupport;
import com.xiongyi.entity.Role;
import com.xiongyi.service.role.RoleManager;
import com.xiongyi.util.PageData;


/**
 * @author GUXIONG
 * @description ��ɫ
 */
@Service("roleService")
public class RoleService implements RoleManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**�г������¼���ɫ
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Role> listAllRolesByPId(PageData pd) throws Exception {
		return (List<Role>) dao.findForList("RoleMapper.listAllRolesByPId", pd);
	}
	
	/**ͨ��id����
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageData findObjectById(PageData pd) throws Exception {
		return (PageData)dao.findForObject("RoleMapper.findObjectById", pd);
	}
	
	/**���
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public void add(PageData pd) throws Exception {
		dao.save("RoleMapper.insert", pd);
	}
	
	/**�����޸�
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public void edit(PageData pd) throws Exception {
		dao.update("RoleMapper.edit", pd);
	}
	
	/**ɾ����ɫ
	 * @param ROLE_ID
	 * @throws Exception
	 */
	@Override
	public void deleteRoleById(String ROLE_ID) throws Exception {
		dao.delete("RoleMapper.deleteRoleById", ROLE_ID);
	}
	
	/**����ǰ��ɫ���Ӳ˵�Ȩ��
	 * @param role
	 * @throws Exception
	 */
	@Override
	public void updateRoleRights(Role role) throws Exception {
		dao.update("RoleMapper.updateRoleRights", role);
	}
	
	/**ͨ��id����
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@Override
	public Role getRoleById(String ROLE_ID) throws Exception {
		return (Role) dao.findForObject("RoleMapper.getRoleById", ROLE_ID);
	}
	
	/**��ȫ���ӽ�ɫ�Ӳ˵�Ȩ��
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public void setAllRights(PageData pd) throws Exception {
		dao.update("RoleMapper.setAllRights", pd);
	}
	
	/**Ȩ��(��ɾ�Ĳ�)
	 * @param msg ������ɾ�Ĳ�
	 * @param pd
	 * @throws Exception
	 */
	@Override
	public void saveB4Button(String msg,PageData pd) throws Exception {
		dao.update("RoleMapper."+msg, pd);
	}

}
