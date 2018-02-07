
package com.jz.sm.framework.model.entity;


/**
 * 
* �������
* @author ���ʵ� 
* @date 2015��4��19�� ����10:25:11
* @Description �����ݿ�schoolmis_new�е�misUser
* 				  ������java��
 */
public class MisUser   {
	private String userId = null;
	private String userName = null;//�û�����
	private String userPwd = null; //�û�����
	private String userMemo = null;//�û��������
	private String roleId = null;  
	private String addressId = null;
	private String lastLoginTime = null;//�ϴε�¼ʱ��
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��19�� ����10:27:40
	* @Description  ��
	 */
	public MisUser(){
		
	}
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��19�� ����10:27:52
	* @Description ��misUser���ÿ�����Խ��г�ʼ��
	 */
	public MisUser(String userId, String userName, String userPwd,
			String userMemo, String roleId, String addressId,
			String lastLoginTime) {
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userMemo = userMemo;
		this.roleId = roleId;
		this.addressId = addressId;
		this.lastLoginTime = lastLoginTime;
	}
	
	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:33:29
	  *@Description ���� �û�id����ֵ
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:38:52
	  *@Description ��userId���Գ�ʼ��
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@exception @return
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:50:21
	  *@Description ���� �û�userName����ֵ
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@exception @param userId
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:53:52
	  *@Description ��userName���Գ�ʼ��
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@exception @return
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:55:01
	  *@Description ���� �û�userPwd����ֵ
	 */
	public String getUserPwd() {
		return userPwd;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@exception userId
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:58:52
	  *@Description ��userPwd���Գ�ʼ��
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:59:24
	  *@Description ���� �û�userMemo����ֵ
	 */
	public String getUserMemo() {
		return userMemo;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������11:05:10
	  *@Description ��userMemo���Գ�ʼ��
	 */

	public void setUserMemo(String userMemo) {
		this.userMemo = userMemo;
	}

	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������11:10:24
	  *@Description ���� �û�roleId����ֵ
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@exception @param userId
	  *@author ���ʵ�
	  *@Time 2015��4��19������11:11:52
	  *@Description ��roleId���Գ�ʼ��
	 */

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������11:12:29
	  *@Description ���� �û�addressId����ֵ
	 */
	public String getAddressId() {
		return addressId;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������11:13:52
	  *@Description ��addressId���Գ�ʼ��
	 */

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������11:14:29
	  *@Description ���� �û�lastLoginTime����ֵ
	 */

	public String getLastLoginTime() {
		return lastLoginTime;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��19������11:16:52
	  *@Description ��lastLoginTime���Գ�ʼ��
	 */

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	/**
	 * *@author ���ʵ�
	  *@Time 2015��4��19������11:17:12
	 * @Description ������ĵ�ַ����һ�ι�ϣ����
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result
				+ ((lastLoginTime == null) ? 0 : lastLoginTime.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userMemo == null) ? 0 : userMemo.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPwd == null) ? 0 : userPwd.hashCode());
		return result;
	}
	/**
	 * @author ���ʵ�
	 *@Time 2015��4��19������11:28:52
	 * @Description �����ò�ͬ,����������ͬ�Ŀ���ͬһ������,��ҵ���߼�һ��
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MisUser other = (MisUser) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (lastLoginTime == null) {
			if (other.lastLoginTime != null)
				return false;
		} else if (!lastLoginTime.equals(other.lastLoginTime))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userMemo == null) {
			if (other.userMemo != null)
				return false;
		} else if (!userMemo.equals(other.userMemo))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPwd == null) {
			if (other.userPwd != null)
				return false;
		} else if (!userPwd.equals(other.userPwd))
			return false;
		return true;
	}

	/**
	 *@author ���ʵ�
	 *@Time 2015��4��19������11:51:52
	 * @Description ��ӡ�������Ϣ
	 * 
	 */
	@Override
	public String toString() {
		return "MisUser [userId=" + userId + ", userName=" + userName
				+ ", userPwd=" + userPwd + ", userMemo=" + userMemo
				+ ", roleId=" + roleId + ", addressId=" + addressId
				+ ", lastLoginTime=" + lastLoginTime + "]";
	}

	
	
	
	
}
