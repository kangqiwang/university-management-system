package com.jz.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jz.sm.framework.model.entity.MisFuction;
import com.jz.sm.framework.model.util.DBUtil;

/**
 * 
* 类的描述
* @author 王攀登
* @date 2015年4月25日 上午10:01:03
* @Description  MisFuctionDAOImp实现了 IMisFuctionDAO接口,实现了所有的抽象方法
 */
public class MisFuctionDAOImp implements IMisFuctionDAO{
	/**
	 * 
	  * 方法注释
	  *@return List<MisFuction> 	
	  *@author 王攀登
	  * @date 2015年4月25日 上午10:02:20
	  *@Description 通过menuId属性转为sql语句的查询条件,调用数据层的方法,查询数据库中的多条记录,
	  *				将返回的记录转为多个misFuction对象,加到集合类中
	  *            
	 */
	@Override
	public List<MisFuction> findByMenuId(String menuId) {
		List<MisFuction> list = new ArrayList<MisFuction>();
		String sql = "select *from misFunction"
				+ " where menuId='"+menuId+"'";
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		try {
			while (rs.next()) {
				//创建实体类的对象
				MisFuction temp = new MisFuction();
				temp.setFunctionId(rs.getString(1));
				temp.setFunctionName(rs.getString(2));
				temp.setFunctionClass(rs.getString(3));
				temp.setFunctionMemo(rs.getString(4));
				temp.setMenuId(rs.getString(5));
				//给集合添加元素
				list.add(temp);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{//关闭资源
			dbUtil.close();
		}
		
		
		
		return list;
	}
	/**
	 * 
	  * 方法注释
	  *@return List<MisFuction> 	
	  *@author 王攀登
	  * @date 2015年4月25日 上午10:04:20
	  *@Description 通过roleId和menuId属性转为sql语句的查询条件,调用数据层的方法,查询数据库中的多条记录,
	  *				将返回的记录转为多个misFuction对象,加到集合类中
	  *            
	 */
	@Override
	public List<MisFuction> findByMenuIdAndRoleId(String menuId,String roleId) {
		List<MisFuction> list = new ArrayList<MisFuction>();
		String sql = "select *from misfunction "
				+ "where menuId = '"+menuId+"' and functionId in "
						+ "(select functionId from auth where roleId ='"+roleId+"')";
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		try {
			while (rs.next()) {
				MisFuction temp = new MisFuction
						(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5)
						);
				list.add(temp);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			dbUtil.close();
		}
		
		return list;
	}
	/**
	 * 
	  * 方法注释
	  *@return MisFuction 	
	  *@author 王攀登
	  * @date 2015年4月25日 上午10:05:20
	  *@Description 通过实体类的functionId属性转为sql语句的查询条件,调用数据层的方法,查询数据库中的多条记录,
	  *				将返回的记录转为多个misFuction对象,加到集合类中
	  *            
	 */
	@Override
	public MisFuction findById(String functionId) {
		MisFuction temp = null;
		String sql = "select * from misFunction where functionId = '"+ functionId +"'";
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		try {
			while (rs.next()) {
				temp = new MisFuction();
				temp.setFunctionId(rs.getString(1));
				temp.setFunctionName(rs.getString(2));
				temp.setFunctionClass(rs.getString(3));
				temp.setFunctionMemo(rs.getString(4));
				temp.setMenuId(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			dbUtil.close();
		}
		return temp;
	}
	
	
	
}
