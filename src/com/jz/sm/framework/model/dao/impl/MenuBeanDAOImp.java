package com.jz.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jz.sm.framework.model.entity.MenuBean;
import com.jz.sm.framework.model.util.DBUtil;

/**
 * 
* �������
* @author ���ʵ�
* @date 2015��4��20�� ����14:01:03
* @Description  MenuBeanDAOImp��ʵ����IMenuDAO�ӿ�,ʵ�������еĳ��󷽷�
 */

public class MenuBeanDAOImp implements IMenuDAO{
	/**
	 * 
	  * ����ע��
	  *@return List<MenuBean> 	
	  *@author ���ʵ�
	  * @date 2015��4��20�� ����14:05:03
	  *@Description   ���ϲ㴫����sql�������ݲ㣬���������ݲ�Ĳ�ѯ����
	  *				Ȼ�󽫷��صĶ�����¼תΪ�������,�ӵ���������
	  *            
	 */
	public List<MenuBean> queryById(String sql) {
		List<MenuBean> list = null;
		
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		list = new ArrayList<MenuBean>();
		//����rs,��Ԫ�ؼӼ���
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
