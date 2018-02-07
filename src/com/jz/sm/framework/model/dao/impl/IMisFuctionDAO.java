package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.MisFuction;
/**
 * 
* �ӿڵ�����
* @author ���ʵ�
* @date 2015��4��24�� ����10:44:30
* @Description ���ʵ����MisFuction��ƵĽӿ�,���ɸ�����ҵ���߼���ƵĶ��󻯲����ķ���.
 */
public interface IMisFuctionDAO {
	/**
	 * 
	  * ����ע��
	  *@return List<MisFuction> 	
	  *@author ���ʵ�
	  *@Time 2015��4��24������10:44:36
	  *@Description ���󻯵Ĳ�ѯ�ĳ��󷽷�,ͨ��menuId��ѯ
	 */
	public List<MisFuction> findByMenuId(String menuId);
	/**
	 * 
	  * ����ע��
	  *@return List<MisFuction> 	
	  *@author ���ʵ�
	  *@Time 2015��4��24������10:46:36
	  *@Description ���󻯵Ĳ�ѯ�ĳ��󷽷�,ͨ�� roleId��menuId��ѯ
	 */
	public List<MisFuction> findByMenuIdAndRoleId(String menuId,String roleId);
	/**
	 * 
	  * ����ע��
	  *@return List<MisFuction> 	
	  *@author ���ʵ�
	  *@Time 2015��4��24������10:48:36
	  *@Description ���󻯵Ĳ�ѯ�ĳ��󷽷�,ͨ�� functionId��ѯ
	 */
	public MisFuction findById(String functionId);
	
}
