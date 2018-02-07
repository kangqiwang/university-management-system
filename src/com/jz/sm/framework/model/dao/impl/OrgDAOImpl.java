package com.jz.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jz.sm.framework.model.entity.Org;
import com.jz.sm.framework.model.util.DBUtil;
/**
 * 
* �������
* @author ���ʵ�
* @date 2015��4��21�� ����11:10:03
* @Description  OrgDAOImplʵ���� IOrgDAO�ӿ�,ʵ�������еĳ��󷽷�
 */

public class OrgDAOImpl implements IOrgDAO{
	/**
	 * 
	  * ����ע��
	  *@return MisUser 	
	  *@author ���ʵ�
	  * @date 2015��4��21�� ����11:12:03
	  *@Description   �ȵõ�Ҫ��ѯ�������������ֵ,Ȼ��תΪsql���,�������ݲ�Ĳ�ѯ����,
	  *             �᷵�ز�ѯ���ݿ��еĶ�����¼,�����صļ�¼תΪ���Orgʵ��,�浽������
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
