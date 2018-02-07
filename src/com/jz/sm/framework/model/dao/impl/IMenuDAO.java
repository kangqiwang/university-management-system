package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.MenuBean;



/**
 * 
* 接口的描述
* @author 王攀登
* @date 2015年4月24日 下午16:44:30
* @Description 针对实体类MenuBean设计的接口,若干个根据业务逻辑设计的对象化操作的方法.
 */

public interface IMenuDAO {
	/**
	 * 
	  * 方法注释
	  *@return List<MisFuction> 	
	  *@author 王攀登
	  *@Time 2015年4月24日下午16:46:30
	  *@Description 直接通过sql语句查询
	 */
	public  List<MenuBean>  queryById(String sql);
	
	
}
