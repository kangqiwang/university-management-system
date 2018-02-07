package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.Student;
/**
 * 
* 接口的描述
* @author 王攀登
* @date 2015年4月21日上午10:56:24
* @Description 针对实体类Student设计的接口,若干个根据业务逻辑设计的对象化操作的方法.
 */
public interface IStudentDAO {
	/**
	 * 
	  * 方法注释
	  *@return List<Student> 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:57:24
	  *@Description 对象化的查询的抽象方法,通过一个student对象的实例进行模糊查询
	 */
	public List<Student> findByLike(Student student);
	
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:56:06
	  *@Description 对象化的移除的抽象方法
	 */
	public boolean remove(String studentId);
	
	/**
	 * 
	  * 方法注释
	  *@return Student 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:57:05
	  *@Description 对象化的查询的抽象方法,通过用户studentId查询
	 */
	public Student findById(String studentId);
	
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午9:53:50
	  *@Description 对象化的增加的抽象方法
	 */
	public boolean add(Student student);
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:56:15
	  *@Description 对象化的修改一个Student实例的抽象方法
	 */
	public boolean modify(Student student);
}