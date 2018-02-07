package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.OrgType;
/**
 * 
* �ӿڵ�����
* @author ���ʵ�
* @date 2015��4��22�� ����9:52:30
* @Description ���ʵ����OrgType��ƵĽӿ�,���ɸ�����ҵ���߼���ƵĶ��󻯲����ķ���.
 */
public interface IOrgTypeDAO {
	
	
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������9:53:50
	  *@Description ���󻯵����ӵĳ��󷽷�
	 */
	public boolean add(OrgType orgType);
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:56:06
	  *@Description ���󻯵��Ƴ��ĳ��󷽷�
	 */
	public boolean remove(String  orgTypeId);
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:56:15
	  *@Description ���󻯵��޸�һ��OrgTypeʵ���ĳ��󷽷�
	 */
	public boolean modify(OrgType orgType);
	/**
	 * 
	  * ����ע��
	  *@return OrgType 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:57:05
	  *@Description ���󻯵Ĳ�ѯ�ĳ��󷽷�,ͨ���û�id��ѯ
	 */
	public OrgType findById(String orgTypeId);
	/**
	 * 
	  * ����ע��
	  *@return List<OrgType> 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:57:24
	  *@Description ���󻯵Ĳ�ѯ�ĳ��󷽷�,ͨ��һ��orgType�����ʵ������ģ����ѯ
	 */
	public List<OrgType>  findByLike(OrgType orgType);
	
}
