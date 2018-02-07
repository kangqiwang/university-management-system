package com.jz.sm.framework.model.dao.impl;

import java.util.List;

import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.OrgType;

/**
 * 
* �ӿڵ�����
* @author ���ʵ�
* @date 2015��4��19�� ����10:52:30
* @Description ���ʵ����misUser��ƵĽӿ�,���ɸ�����ҵ���߼���ƵĶ��󻯲����ķ���.
 */
public interface IMisUserDAO {
	
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:53:50
	  *@Description ���󻯵����ӵĳ��󷽷�
	 */
	public boolean add(MisUser misUser);
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@exception @return
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:56:02
	  *@Description ���󻯵��Ƴ��ĳ��󷽷�
	 */
	
	public boolean remove(String  misUserId);
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:57:15
	  *@Description ���󻯵��޸�һ��misUserʵ���ĳ��󷽷�
	 */
	public boolean modify(MisUser misUser);
	/**
	 * 
	  * ����ע��
	  *@return MisUser 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:58:20
	  *@Description ���󻯵Ĳ�ѯ�ĳ��󷽷�,ͨ���û�id��ѯ
	 */
	public MisUser findById(String UserId);
	/**
	 * 
	  * ����ע��
	  *@return List<MisUser>  	
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:59:24
	  *@Description ���󻯵Ĳ�ѯ�ĳ��󷽷�,ͨ��һ��misUserʵ������ģ����ѯ
	 */
	public List<MisUser>  findByLike(MisUser misUser);
	
	
}
