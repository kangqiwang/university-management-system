package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.Course;
/**
 * 
* �ӿڵ�����
* @author ���ʵ�
* @date 2015��4��22�� ����9:52:30
* @Description ���ʵ����Course��ƵĽӿ�,���ɸ�����ҵ���߼���ƵĶ��󻯲����ķ���.
 */

public interface ICourseDAO {
	
	public List<Course> findAll();
	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:57:05
	  *@Description ���󻯵Ĳ�ѯ�ĳ��󷽷�,ͨ��name��ѯ
	 */
	public String findByName(String name);
}
