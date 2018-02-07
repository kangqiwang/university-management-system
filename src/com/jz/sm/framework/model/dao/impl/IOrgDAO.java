package com.jz.sm.framework.model.dao.impl;

import java.util.List;


import com.jz.sm.framework.model.entity.Org;
/**
 * 
* 接口的描述
* @author 王攀登
* @date 2015年4月21日 上午11:03:30
* @Description 针对实体类Org设计的接口,若干个根据业务逻辑设计的对象化操作的方法.
 */
public interface IOrgDAO {
	
	/**
	 * 
	  * 方法注释
	  *@return List<Org> 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午11:04:24
	  *@Description 对象化的查询的抽象方法,通过一个org对象实例进行模糊查询
	 */
	public List<Org> findByLike(Org org);
}
