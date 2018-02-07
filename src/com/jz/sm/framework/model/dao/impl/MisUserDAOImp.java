package com.jz.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.OrgType;
import com.jz.sm.framework.model.util.DBUtil;
/**
 * 
* 类的描述
* @author 王攀登
* @date 2015年4月20日 上午11:01:03
* @Description  MisUserDAOImp实现了 IMisUserDAO接口,实现了所有的抽象方法
 */
public class MisUserDAOImp implements IMisUserDAO{
	
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  * @date 2015年4月20日 上午11:05:03
	  *@Description 将misUser对象的一个实例转为sql传到数据层，加到数据库中,
	  *             如果返回为真,添加成功,反之,失败
	 */
	@Override
	public boolean add(MisUser misUser) {
		boolean flag = false;
		int n = -1;
		/*id变量用来存放misUser的UserId的属性值*/
		String id = misUser.getUserId();
		/*name变量用来存放misUser的UserName的属性值*/
		String name = misUser.getUserName();
		/*password变量用来存放misUser的UserPwd的属性值*/
		String password = misUser.getUserPwd();
		/*memo变量用来存放misUser的UserMemo的属性值*/
		String memo = misUser.getUserMemo();
		/*roleId变量用来存放misUser的RoleId的属性值*/
		String roleId = misUser.getRoleId();
		/*addressId变量用来存放misUser的AddressId的属性值*/
		String addressId = misUser.getAddressId();
		/*lastLoginTime变量用来存放misUser的LastLoginTime的属性值*/
		String lastLoginTime = misUser.getLastLoginTime();
		MisUser back = this.findById(id);
		if (back == null) {
			//局部字符串变量
			String sql = "insert into  misUser (userId,userName,userPwd,userMemo,roleId,addressId,lastLoginTime)"
					+ "values('"+id+"','"+name+"','"+password+"','"+memo+"','"+roleId+"','"+addressId+"','"+lastLoginTime+"')";
			//向下操作数据库
			DBUtil dbUtil = new DBUtil();
			n = dbUtil.update(sql);
			if(n > 0) {
				flag = true;
			}
		}else {
			System.out.println("数据库已有此记录");
		}
		return flag;
	}
	
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  * @date 2015年4月20日 上午11:20:03
	  *@Description 将misUserId转为sql,传到数据库层,先查询是否有这个对象,若果有,则删除此对象,没有就返回
	  *            
	 */
	@Override
	public boolean remove(String misUserId) {
		boolean flag = false;
		int n = -1;
		DBUtil dbUtil = new DBUtil();
		MisUser back = this.findById(misUserId);
		if (back != null) {
			String sql = "delete from misUser where userId= '"+misUserId+"'";
			n = dbUtil.update(sql);
		}else {
			System.out.println("数据库没有此记录");
		}
		return flag;
	}
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  * @date 2015年4月20日 上午11:30:03
	  *@Description 将misUser对象实例转为sql,传到数据库层,先查询是否有这个对象,
	  *             若果有,则修改此对象与数据库相对应的一条记录,反之,则调用对象化
	  *             的增加方法,增加一个对象实例（相当于数据库中的一条记录）
	  *            
	 */
	@Override
	public boolean modify(MisUser misUser) {
		boolean flag = false;
		DBUtil dbUtil = new DBUtil();
		int n;
		String id = misUser.getUserId();
		String name = misUser.getUserName();
		String password = misUser.getUserPwd();
		String memo = misUser.getUserMemo();
		String roleId = misUser.getRoleId();
		String addressId = misUser.getAddressId();
		String lastLoginTime = misUser.getLastLoginTime();
		MisUser back = this.findById(id);
		if (back != null) {
		
			String sql = "update  misUser set"
					+ " userName ='"+name+"'"
					+ ",userPwd  ='"+password+"'"
					+ ",userMemo ='"+memo+"'"
					+ ",roleId   ='"+roleId+"'"
					+ ",addressId ='"+addressId+"'"
					+ ",lastLoginTime ='"+lastLoginTime+"'"
					+ "where userId = '"+id+"'";
			//调用下层的方法
			n = dbUtil.update(sql);
			flag = true;
			
		}else {
			//插入
			flag = this.add(misUser);
		}
		return flag;
	}
	/**
	 * 
	  * 方法注释
	  *@return MisUser 	
	  *@author 王攀登
	  * @date 2015年4月20日 上午11:34:20
	  *@Description 通过UserId属性转为sql语句,调用数据层的方法,查询数据库中的一条记录,
	  *				将返回的记录转为misUser对象
	  *            
	 */
	@Override
	public MisUser findById(String UserId) {
		String sql ="select *from MisUser  where userId='"+UserId+"'";
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		MisUser misUser = null;
		try {
			while (rs.next()){
				misUser = new MisUser();
				misUser.setUserId(rs.getString(1));
				misUser.setUserName(rs.getString(2));
				misUser.setUserPwd(rs.getString(3));
				misUser.setUserMemo(rs.getString(4));
				misUser.setRoleId(rs.getString(5));
				misUser.setAddressId(rs.getString(6));
				misUser.setLastLoginTime(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			dbUtil.close();
		}
		return misUser;
	}
	/**
	 * 
	  * 方法注释
	  *@return List<MisUser> 	
	  *@author 王攀登
	  * @date 2015年4月20日 上午11:45:03
	  *@Description   先得到要查询对象的所有属性值,然后转为sql语句,调用数据层的查询方法,
	  *             会返回查询数据库中的多条记录,将返回的记录转为多个misUser实例,存到集合中
	  *            
	 */
	@Override
	public List<MisUser> findByLike(MisUser misUser) {
		List<MisUser> list = null;
		String id = misUser.getUserId();
		String name = misUser.getUserName();
		String password = misUser.getUserPwd();
		String memo = misUser.getUserMemo();
		String roleId = misUser.getRoleId();
		String addressId = misUser.getAddressId();
		String lastLoginTime = misUser.getLastLoginTime();
		String s1 = "select *from misUser";
		String s2 = "";
		String s3 = null;
		if (id != null&&id.length() >= 0) {
			s2 = s2+" userId like '%"+id+"%'";
		}
		if (name != null&&name.length() >= 0) {
	
			s2 = s2+" and userName like '%"+name+"%'";
		}
		if (password != null&&password.length() >= 0) {
			
			s2 = s2+" and userPwd like '%"+password+"%'";
			
		}
		if (memo != null&&memo.length() >= 0) {
			
			s2 = s2+" and userMemo like '%"+memo+"%'";
		}
		if (roleId != null&&roleId.length() >= 0) {
		
			s2 = s2+" and roleId like '%"+roleId+"%'";
		}
		if (addressId != null&&addressId.length() >= 0) {
			
			s2 = s2+" and addressId like '%"+addressId+"%'";
			
		}
		if (lastLoginTime!=null&&lastLoginTime.length()>=0) {
			
			s2 = s2+" and lastLoginTime like '%"+lastLoginTime+"%'";
			
		}
		if (s2.startsWith(" and")) {
			s2 = s2.replaceFirst(" and", " ");
		}
		String sql = s1+" where" +s2;
		DBUtil dbUtil = new DBUtil();
		list = new ArrayList<MisUser>();
		ResultSet rs = dbUtil.query(sql);
		try {
			while (rs.next()) {
				MisUser temp = new MisUser();
				temp.setUserId(rs.getString(1));
				temp.setUserName(rs.getString(2));
				temp.setUserPwd(rs.getString(3));
				temp.setUserMemo(rs.getString(4));
				temp.setRoleId(rs.getString(5));
				temp.setAddressId(rs.getString(6));
				temp.setLastLoginTime(rs.getString(7));
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

	
}
