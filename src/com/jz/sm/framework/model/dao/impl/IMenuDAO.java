package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.MenuBean;



/**
 * 
* �ӿڵ�����
* @author ���ʵ�
* @date 2015��4��24�� ����16:44:30
* @Description ���ʵ����MenuBean��ƵĽӿ�,���ɸ�����ҵ���߼���ƵĶ��󻯲����ķ���.
 */

public interface IMenuDAO {
	/**
	 * 
	  * ����ע��
	  *@return List<MisFuction> 	
	  *@author ���ʵ�
	  *@Time 2015��4��24������16:46:30
	  *@Description ֱ��ͨ��sql����ѯ
	 */
	public  List<MenuBean>  queryById(String sql);
	
	
}
