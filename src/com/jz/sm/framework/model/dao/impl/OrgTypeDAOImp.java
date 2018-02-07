package com.jz.sm.framework.model.dao.impl;

 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jz.sm.framework.model.entity.OrgType;
import com.jz.sm.framework.model.util.DBUtil;
/**
 * 
* 类的描述
* @author 王攀登
* @date 2015年4月22日 上午11:01:03
* @Description  OrgTypeDAOImp类实现了 IOrgTypeDAO接口,实现了所有的抽象方法
 */
public class OrgTypeDAOImp implements IOrgTypeDAO {

	@Override
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:01:10
	  *@Description 将orgType对象的一个实例转为sql传到数据层，加到数据库中,
	  *             如果返回为真,添加成功,反之,失败
	 */
	public boolean add(OrgType orgType) {
		  
		    boolean flag = false;
			//1.拿到实体类的属性值
			String id = orgType.getOrgTypeId();
			String name = orgType.getOrgTypeName();
			String  memo = orgType.getOrgTypeMemo();
		   
			//2.拼sql
			String sql = "insert into orgType (orgTypeId,orgTypeName,orgTypeMemo)"
					+ "values('"+id+"','"+name+"','"+memo+"')";
			//打印出来->在数据库里看sql语句是否正确
			
			DBUtil dbUtil = new DBUtil();
			//3.调用过程化数据库操作的方法
			int n = dbUtil.update(sql);
			if(n>0){
				flag = true;
			}
			
			//关闭资源
			dbUtil.close();
			
			return flag;
			
	}

	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:02:03
	  *@Description 将orgTypeId转为sql,传到数据库层,先查询是否有这个对象,若果有,则删除此对象,没有就返回
	  *            
	 */
	@Override
	public boolean remove(String orgTypeId) {
		DBUtil  dbUtil = new DBUtil();
		boolean flag = false;
		String id = orgTypeId;
		OrgType temp = this.findById(id);
		
		if(temp != null){
			String sql2= "delete from orgType where  orgTypeId='"+id+"'";
			int n = dbUtil.update(sql2);
			if(n>0){
				System.out.println("删除了");
				flag = true;
			}else {
				System.out.println("删除失败");
			}
			
			
		} else {
			System.out.println("没有编号为"+id+"的这个人");
			
		}
		dbUtil.close();
		return flag;
	}
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:04:03
	  *@Description 将orgType对象实例转为sql,传到数据库层,先查询是否有这个对象,
	  *             若果有,则修改此对象与数据库相对应的一条记录,反之,则调用对象化
	  *             的增加方法,增加一个对象实例（相当于数据库中的一条记录）
	  *            
	 */
	@Override
	public boolean modify(OrgType orgType) {
		boolean flag = false;
		DBUtil dbUtil = new DBUtil();
		String id = orgType.getOrgTypeId();
		String name = orgType.getOrgTypeName();
		String  memo = orgType.getOrgTypeMemo();
		OrgType orgtype2 = this.findById(id);
		if(orgtype2 != null){
			String  sql = "update orgType set orgTypeName='"+name+"',orgTypeMemo='"+memo+"'  "
					+ "where orgTypeId='"+id+"'";
			int n = dbUtil.update(sql);
			if(n>0){
				System.out.println("修改成功");
				flag = true;
			}else {
				System.out.println("修改失败");
			}
		}
		else {
			flag = this.add(orgType);
			flag = true;
		}
		
		dbUtil.close();
		return flag;
	}
	/**
	 * 
	  * 方法注释
	  *@return OrgType 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:10:20
	  *@Description 通过orgTypeId属性转为sql语句,调用数据层的方法,查询数据库中的一条记录,
	  *				将返回的记录转为orgType对象
	  *            
	 */
	@Override
	public OrgType findById(String orgTypeId) {
		OrgType  orgType = null;
		String sql = "select * from orgType where orgTypeId='"+orgTypeId+"'";
		DBUtil  dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		if(rs != null){
			try {
				while(rs.next()){
					orgType = new OrgType(rs.getString(1), rs.getString(2), rs.getString(3));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				dbUtil.close();
			}
			
			
		}
		else {
			
			System.out.println("没有编号为"+orgTypeId+"的这个人");
		}
		return orgType;
	}
	/**
	 * 
	  * 方法注释
	  *@return List<OrgType> 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:12:03
	  *@Description   先得到要查询对象的所有属性值,然后转为sql语句,调用数据层的查询方法,
	  *             会返回查询数据库中的多条记录,将返回的记录转为多个orgType实例,存到集合中
	  *            
	 */
	@Override
	public List<OrgType> findByLike(OrgType orgType) {
		String s1 = "select * from orgType where";
		String s2 = "";
		String s3 = null;
		String sql = null;
		String id = orgType.getOrgTypeId();
		String name = orgType.getOrgTypeName();
		String memo = orgType.getOrgTypeMemo();
		if(id != null&&id.length() >= 0 ){
			s2 = s2+" orgTypeId like '%"+id+"%'";
			
		}
		
		if(name != null&&name.length() >= 0){
			s2 = s2+" and orgTypeName like '%"+name+"%'";
		}
		if(memo != null&&memo.length() >= 0){
			s2 = s2+" and orgTypeMemo like '%"+memo+"%'";
		}
		if (s2.length()>0) {
			 s3 = s1+s2;
			if (s3.contains(" and")) {
				 sql = s3.replace("where and","where "); 	
			}	
		}else {
			sql = s1.replace("where", " ");	
		}
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		List<OrgType>  list = new ArrayList<OrgType>();
		try {
			while (rs.next()) {
				OrgType orgType1 = new OrgType();
				orgType1.setOrgTypeId(rs.getString(1));
				orgType1.setOrgTypeName(rs.getString(2));
				orgType1.setOrgTypeMemo(rs.getString(3));
				list.add(orgType1);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{//关闭资源
			dbUtil.close();
		}
		
		
		return list;
	}

}
