package com.jz.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jz.sm.framework.model.entity.Org;
import com.jz.sm.framework.model.util.DBUtil;
/**
 * 
* 类的描述
* @author 王攀登
* @date 2015年4月21日 上午11:10:03
* @Description  OrgDAOImpl实现了 IOrgDAO接口,实现了所有的抽象方法
 */

public class OrgDAOImpl implements IOrgDAO{
	/**
	 * 
	  * 方法注释
	  *@return MisUser 	
	  *@author 王攀登
	  * @date 2015年4月21日 上午11:12:03
	  *@Description   先得到要查询对象的所有属性值,然后转为sql语句,调用数据层的查询方法,
	  *             会返回查询数据库中的多条记录,将返回的记录转为多个Org实例,存到集合中
	  *            
	 */
	@Override
	public List<Org> findByLike(Org org) {
		List<Org> list = new ArrayList<Org>();
		String id = org.getOrgId();
		String name = org.getOrgName();
		String memo = org.getOrgMemo();
		String orgTypeId = org.getOrgTypeId();
		DBUtil db = new DBUtil();
		String select = "select * from org where 1 = 1";
		String where = "";
		if(id != null && id.length() > 0) {
			where = where + " and orgId like '%"+ id +"%'";
		}
		if(name != null && name.length() > 0) {
			where = where + " and orgName like '%"+ name +"%'";
		}
		if(memo != null && memo.length() > 0) {
			where = where + " and orgMemo like '%"+ memo +"%'";
		}
		if(orgTypeId != null && orgTypeId.length() > 0) {
			where = where + " and orgTypeId like '%"+ orgTypeId +"%'";
		}
		String sql = select + where;
		System.out.println(sql);
		ResultSet rs = db.query(sql);
		try {
			while(rs.next()) {
				Org org2 = new Org(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4));
				list.add(org2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
