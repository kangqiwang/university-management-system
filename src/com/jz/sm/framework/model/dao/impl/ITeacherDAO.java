package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.Teacher;
/**
 * 
* �ӿڵ�����
* @author ���ʵ�
* @date 2015��4��22�� ����9:52:30
* @Description ���ʵ����Teacher��ƵĽӿ�,���ɸ�����ҵ���߼���ƵĶ��󻯲����ķ���.
 */
public interface ITeacherDAO {
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������9:53:50
	  *@Description ���󻯵����ӵĳ��󷽷�
	 */
	public boolean add(Teacher teacher);
	/**
	 * 
	  * ����ע��
	  *@return List<Teacher> 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:57:24
	  *@Description ���󻯵Ĳ�ѯ�ĳ��󷽷�,ͨ��һ��Teacher�����ʵ������ģ����ѯ
	 */

	public List<Teacher> findByLike(Teacher teacher); 

	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:56:06
	  *@Description ���󻯵��Ƴ��ĳ��󷽷�
	 */
	public boolean remove(String id);
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:56:15
	  *@Description ���󻯵��޸�һ��OrgTypeʵ���ĳ��󷽷�
	 */
	public boolean modify(Teacher teacher);
}
