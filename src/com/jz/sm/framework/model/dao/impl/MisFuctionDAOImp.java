package com.jz.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jz.sm.framework.model.entity.MisFuction;
import com.jz.sm.framework.model.util.DBUtil;

/**
 * 
* �������
* @author ���ʵ�
* @date 2015��4��25�� ����10:01:03
* @Description  MisFuctionDAOImpʵ���� IMisFuctionDAO�ӿ�,ʵ�������еĳ��󷽷�
 */
public class MisFuctionDAOImp implements IMisFuctionDAO{
	/**
	 * 
	  * ����ע��
	  *@return List<MisFuction> 	
	  *@author ���ʵ�
	  * @date 2015��4��25�� ����10:02:20
	  *@Description ͨ��menuId����תΪsql���Ĳ�ѯ����,�������ݲ�ķ���,��ѯ���ݿ��еĶ�����¼,
	  *				�����صļ�¼תΪ���misFuction����,�ӵ���������
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
				//����ʵ����Ķ���
				MisFuction temp = new MisFuction();
				temp.setFunctionId(rs.getString(1));
				temp.setFunctionName(rs.getString(2));
				temp.setFunctionClass(rs.getString(3));
				temp.setFunctionMemo(rs.getString(4));
				temp.setMenuId(rs.getString(5));
				//���������Ԫ��
				list.add(temp);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{//�ر���Դ
			dbUtil.close();
		}
		
		
		
		return list;
	}
	/**
	 * 
	  * ����ע��
	  *@return List<MisFuction> 	
	  *@author ���ʵ�
	  * @date 2015��4��25�� ����10:04:20
	  *@Description ͨ��roleId��menuId����תΪsql���Ĳ�ѯ����,�������ݲ�ķ���,��ѯ���ݿ��еĶ�����¼,
	  *				�����صļ�¼תΪ���misFuction����,�ӵ���������
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
	  * ����ע��
	  *@return MisFuction 	
	  *@author ���ʵ�
	  * @date 2015��4��25�� ����10:05:20
	  *@Description ͨ��ʵ�����functionId����תΪsql���Ĳ�ѯ����,�������ݲ�ķ���,��ѯ���ݿ��еĶ�����¼,
	  *				�����صļ�¼תΪ���misFuction����,�ӵ���������
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
