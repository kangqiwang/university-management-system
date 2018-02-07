package com.jz.sm.framework.model.dao.impl;

 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jz.sm.framework.model.entity.OrgType;
import com.jz.sm.framework.model.util.DBUtil;
/**
 * 
* �������
* @author ���ʵ�
* @date 2015��4��22�� ����11:01:03
* @Description  OrgTypeDAOImp��ʵ���� IOrgTypeDAO�ӿ�,ʵ�������еĳ��󷽷�
 */
public class OrgTypeDAOImp implements IOrgTypeDAO {

	@Override
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:01:10
	  *@Description ��orgType�����һ��ʵ��תΪsql�������ݲ㣬�ӵ����ݿ���,
	  *             �������Ϊ��,��ӳɹ�,��֮,ʧ��
	 */
	public boolean add(OrgType orgType) {
		  
		    boolean flag = false;
			//1.�õ�ʵ���������ֵ
			String id = orgType.getOrgTypeId();
			String name = orgType.getOrgTypeName();
			String  memo = orgType.getOrgTypeMemo();
		   
			//2.ƴsql
			String sql = "insert into orgType (orgTypeId,orgTypeName,orgTypeMemo)"
					+ "values('"+id+"','"+name+"','"+memo+"')";
			//��ӡ����->�����ݿ��￴sql����Ƿ���ȷ
			
			DBUtil dbUtil = new DBUtil();
			//3.���ù��̻����ݿ�����ķ���
			int n = dbUtil.update(sql);
			if(n>0){
				flag = true;
			}
			
			//�ر���Դ
			dbUtil.close();
			
			return flag;
			
	}

	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:02:03
	  *@Description ��orgTypeIdתΪsql,�������ݿ��,�Ȳ�ѯ�Ƿ����������,������,��ɾ���˶���,û�оͷ���
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
				System.out.println("ɾ����");
				flag = true;
			}else {
				System.out.println("ɾ��ʧ��");
			}
			
			
		} else {
			System.out.println("û�б��Ϊ"+id+"�������");
			
		}
		dbUtil.close();
		return flag;
	}
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:04:03
	  *@Description ��orgType����ʵ��תΪsql,�������ݿ��,�Ȳ�ѯ�Ƿ����������,
	  *             ������,���޸Ĵ˶��������ݿ����Ӧ��һ����¼,��֮,����ö���
	  *             �����ӷ���,����һ������ʵ�����൱�����ݿ��е�һ����¼��
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
				System.out.println("�޸ĳɹ�");
				flag = true;
			}else {
				System.out.println("�޸�ʧ��");
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
	  * ����ע��
	  *@return OrgType 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:10:20
	  *@Description ͨ��orgTypeId����תΪsql���,�������ݲ�ķ���,��ѯ���ݿ��е�һ����¼,
	  *				�����صļ�¼תΪorgType����
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
			
			System.out.println("û�б��Ϊ"+orgTypeId+"�������");
		}
		return orgType;
	}
	/**
	 * 
	  * ����ע��
	  *@return List<OrgType> 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:12:03
	  *@Description   �ȵõ�Ҫ��ѯ�������������ֵ,Ȼ��תΪsql���,�������ݲ�Ĳ�ѯ����,
	  *             �᷵�ز�ѯ���ݿ��еĶ�����¼,�����صļ�¼תΪ���orgTypeʵ��,�浽������
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
		finally{//�ر���Դ
			dbUtil.close();
		}
		
		
		return list;
	}

}
