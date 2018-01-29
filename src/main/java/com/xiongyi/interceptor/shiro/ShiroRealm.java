package com.xiongyi.interceptor.shiro;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;



/**
 * @author GUXIONG
 *
 */
public class ShiroRealm extends AuthorizingRealm {

	/*
	 * ��¼��Ϣ���û���֤��Ϣ��֤(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		 String username = (String)token.getPrincipal();  				//�õ��û��� 
	     String password = new String((char[])token.getCredentials()); 	//�õ�����
	     if(null != username && null != password){
	    	 return new SimpleAuthenticationInfo(username, password, getName());
	     }else{
	    	 return null;
	     }
	}
	
	/*
	 * ��Ȩ��ѯ�ص�����, ���м�Ȩ�����������û�����Ȩ��Ϣʱ����,������Ӧ�ó����о����û��ķ��ʿ��Ƶķ���(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		System.out.println("========2");
		return null;
	}

}
