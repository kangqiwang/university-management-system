package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.Student;
/**
 * 
* �ӿڵ�����
* @author ���ʵ�
* @date 2015��4��21������10:56:24
* @Description ���ʵ����Student��ƵĽӿ�,���ɸ�����ҵ���߼���ƵĶ��󻯲����ķ���.
 */
public interface IStudentDAO {
	/**
	 * 
	  * ����ע��
	  *@return List<Student> 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:57:24
	  *@Description ���󻯵Ĳ�ѯ�ĳ��󷽷�,ͨ��һ��student�����ʵ������ģ����ѯ
	 */
	public List<Student> findByLike(Student student);
	
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:56:06
	  *@Description ���󻯵��Ƴ��ĳ��󷽷�
	 */
	public boolean remove(String studentId);
	
	/**
	 * 
	  * ����ע��
	  *@return Student 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:57:05
	  *@Description ���󻯵Ĳ�ѯ�ĳ��󷽷�,ͨ���û�studentId��ѯ
	 */
	public Student findById(String studentId);
	
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������9:53:50
	  *@Description ���󻯵����ӵĳ��󷽷�
	 */
	public boolean add(Student student);
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:56:15
	  *@Description ���󻯵��޸�һ��Studentʵ���ĳ��󷽷�
	 */
	public boolean modify(Student student);
}