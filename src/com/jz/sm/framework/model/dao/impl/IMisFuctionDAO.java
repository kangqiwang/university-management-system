package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.MisFuction;
/**
 * 
* 接口的描述
* @author 王攀登
* @date 2015年4月24日 上午10:44:30
* @Description 针对实体类MisFuction设计的接口,若干个根据业务逻辑设计的对象化操作的方法.
 */
public interface IMisFuctionDAO {
	/**
	 * 
	  * 方法注释
	  *@return List<MisFuction> 	
	  *@author 王攀登
	  *@Time 2015年4月24日上午10:44:36
	  *@Description 对象化的查询的抽象方法,通过menuId查询
	 */
	public List<MisFuction> findByMenuId(String menuId);
	/**
	 * 
	  * 方法注释
	  *@return List<MisFuction> 	
	  *@author 王攀登
	  *@Time 2015年4月24日上午10:46:36
	  *@Description 对象化的查询的抽象方法,通过 roleId和menuId查询
	 */
	public List<MisFuction> findByMenuIdAndRoleId(String menuId,String roleId);
	/**
	 * 
	  * 方法注释
	  *@return List<MisFuction> 	
	  *@author 王攀登
	  *@Time 2015年4月24日上午10:48:36
	  *@Description 对象化的查询的抽象方法,通过 functionId查询
	 */
	public MisFuction findById(String functionId);
	
}
