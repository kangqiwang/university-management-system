package com.jz.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jz.sm.framework.model.entity.MenuBean;
import com.jz.sm.framework.model.util.DBUtil;

/**
 * 
* 类的描述
* @author 王攀登
* @date 2015年4月20日 中午14:01:03
* @Description  MenuBeanDAOImp类实现了IMenuDAO接口,实现了所有的抽象方法
 */

public class MenuBeanDAOImp implements IMenuDAO{
	/**
	 * 
	  * 方法注释
	  *@return List<MenuBean> 	
	  *@author 王攀登
	  * @date 2015年4月20日 中午14:05:03
	  *@Description   将上层传来的sql传到数据层，并调用数据层的查询方法
	  *				然后将返回的多条记录转为多个对象,加到集合类中
	  *            
	 */
	public List<MenuBean> queryById(String sql) {
		List<MenuBean> list = null;
		
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		list = new ArrayList<MenuBean>();
		//遍历rs,把元素加集合
		try {
			while (rs.next()){
				MenuBean temp = new MenuBean();
				temp.setMenuId(rs.getString(1));
				temp.setMenuName(rs.getString(2));
				temp.setMenuMemo(rs.getString(3));
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			dbUtil.close();
		}
		
		return list;
	}

	
}
