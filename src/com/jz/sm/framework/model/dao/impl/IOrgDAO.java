package com.jz.sm.framework.model.dao.impl;

import java.util.List;


import com.jz.sm.framework.model.entity.Org;
/**
 * 
* �ӿڵ�����
* @author ���ʵ�
* @date 2015��4��21�� ����11:03:30
* @Description ���ʵ����Org��ƵĽӿ�,���ɸ�����ҵ���߼���ƵĶ��󻯲����ķ���.
 */
public interface IOrgDAO {
	
	/**
	 * 
	  * ����ע��
	  *@return List<Org> 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������11:04:24
	  *@Description ���󻯵Ĳ�ѯ�ĳ��󷽷�,ͨ��һ��org����ʵ������ģ����ѯ
	 */
	public List<Org> findByLike(Org org);
}
