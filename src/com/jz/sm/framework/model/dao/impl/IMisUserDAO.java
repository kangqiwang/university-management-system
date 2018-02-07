package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.OrgType;

/**
 * 
* 接口的描述
* @author 王攀登
* @date 2015年4月19日 上午10:52:30
* @Description 针对实体类misUser设计的接口,若干个根据业务逻辑设计的对象化操作的方法.
 */
public interface IMisUserDAO {
	
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:53:50
	  *@Description 对象化的增加的抽象方法
	 */
	public boolean add(MisUser misUser);
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@exception @return
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:56:02
	  *@Description 对象化的移除的抽象方法
	 */
	
	public boolean remove(String  misUserId);
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:57:15
	  *@Description 对象化的修改一个misUser实例的抽象方法
	 */
	public boolean modify(MisUser misUser);
	/**
	 * 
	  * 方法注释
	  *@return MisUser 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:58:20
	  *@Description 对象化的查询的抽象方法,通过用户id查询
	 */
	public MisUser findById(String UserId);
	/**
	 * 
	  * 方法注释
	  *@return List<MisUser>  	
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:59:24
	  *@Description 对象化的查询的抽象方法,通过一个misUser实例进行模糊查询
	 */
	public List<MisUser>  findByLike(MisUser misUser);
	
	
}
