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
* �������
* @author ���ʵ�
* @date 2015��4��20�� ����11:01:03
* @Description  MisUserDAOImpʵ���� IMisUserDAO�ӿ�,ʵ�������еĳ��󷽷�
 */
public class MisUserDAOImp implements IMisUserDAO{
	
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  * @date 2015��4��20�� ����11:05:03
	  *@Description ��misUser�����һ��ʵ��תΪsql�������ݲ㣬�ӵ����ݿ���,
	  *             �������Ϊ��,��ӳɹ�,��֮,ʧ��
	 */
	@Override
	public boolean add(MisUser misUser) {
		boolean flag = false;
		int n = -1;
		/*id�����������misUser��UserId������ֵ*/
		String id = misUser.getUserId();
		/*name�����������misUser��UserName������ֵ*/
		String name = misUser.getUserName();
		/*password�����������misUser��UserPwd������ֵ*/
		String password = misUser.getUserPwd();
		/*memo�����������misUser��UserMemo������ֵ*/
		String memo = misUser.getUserMemo();
		/*roleId�����������misUser��RoleId������ֵ*/
		String roleId = misUser.getRoleId();
		/*addressId�����������misUser��AddressId������ֵ*/
		String addressId = misUser.getAddressId();
		/*lastLoginTime�����������misUser��LastLoginTime������ֵ*/
		String lastLoginTime = misUser.getLastLoginTime();
		MisUser back = this.findById(id);
		if (back == null) {
			//�ֲ��ַ�������
			String sql = "insert into  misUser (userId,userName,userPwd,userMemo,roleId,addressId,lastLoginTime)"
					+ "values('"+id+"','"+name+"','"+password+"','"+memo+"','"+roleId+"','"+addressId+"','"+lastLoginTime+"')";
			//���²������ݿ�
			DBUtil dbUtil = new DBUtil();
			n = dbUtil.update(sql);
			if(n > 0) {
				flag = true;
			}
		}else {
			System.out.println("���ݿ����д˼�¼");
		}
		return flag;
	}
	
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  * @date 2015��4��20�� ����11:20:03
	  *@Description ��misUserIdתΪsql,�������ݿ��,�Ȳ�ѯ�Ƿ����������,������,��ɾ���˶���,û�оͷ���
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
			System.out.println("���ݿ�û�д˼�¼");
		}
		return flag;
	}
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  * @date 2015��4��20�� ����11:30:03
	  *@Description ��misUser����ʵ��תΪsql,�������ݿ��,�Ȳ�ѯ�Ƿ����������,
	  *             ������,���޸Ĵ˶��������ݿ����Ӧ��һ����¼,��֮,����ö���
	  *             �����ӷ���,����һ������ʵ�����൱�����ݿ��е�һ����¼��
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
			//�����²�ķ���
			n = dbUtil.update(sql);
			flag = true;
			
		}else {
			//����
			flag = this.add(misUser);
		}
		return flag;
	}
	/**
	 * 
	  * ����ע��
	  *@return MisUser 	
	  *@author ���ʵ�
	  * @date 2015��4��20�� ����11:34:20
	  *@Description ͨ��UserId����תΪsql���,�������ݲ�ķ���,��ѯ���ݿ��е�һ����¼,
	  *				�����صļ�¼תΪmisUser����
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
	  * ����ע��
	  *@return List<MisUser> 	
	  *@author ���ʵ�
	  * @date 2015��4��20�� ����11:45:03
	  *@Description   �ȵõ�Ҫ��ѯ�������������ֵ,Ȼ��תΪsql���,�������ݲ�Ĳ�ѯ����,
	  *             �᷵�ز�ѯ���ݿ��еĶ�����¼,�����صļ�¼תΪ���misUserʵ��,�浽������
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
