package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.Teacher;
/**
 * 
* 接口的描述
* @author 王攀登
* @date 2015年4月22日 上午9:52:30
* @Description 针对实体类Teacher设计的接口,若干个根据业务逻辑设计的对象化操作的方法.
 */
public interface ITeacherDAO {
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午9:53:50
	  *@Description 对象化的增加的抽象方法
	 */
	public boolean add(Teacher teacher);
	/**
	 * 
	  * 方法注释
	  *@return List<Teacher> 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:57:24
	  *@Description 对象化的查询的抽象方法,通过一个Teacher对象的实例进行模糊查询
	 */

	public List<Teacher> findByLike(Teacher teacher); 

	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:56:06
	  *@Description 对象化的移除的抽象方法
	 */
	public boolean remove(String id);
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:56:15
	  *@Description 对象化的修改一个OrgType实例的抽象方法
	 */
	public boolean modify(Teacher teacher);
}
