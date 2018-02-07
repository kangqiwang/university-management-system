package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.Course;
/**
 * 
* 接口的描述
* @author 王攀登
* @date 2015年4月22日 上午9:52:30
* @Description 针对实体类Course设计的接口,若干个根据业务逻辑设计的对象化操作的方法.
 */

public interface ICourseDAO {
	
	public List<Course> findAll();
	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:57:05
	  *@Description 对象化的查询的抽象方法,通过name查询
	 */
	public String findByName(String name);
}
