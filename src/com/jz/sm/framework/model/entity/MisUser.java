
package com.jz.sm.framework.model.entity;


/**
 * 
* 类的描述
* @author 王攀登 
* @date 2015年4月19日 上午10:25:11
* @Description 将数据库schoolmis_new中的misUser
* 				  表缓存在java中
 */
public class MisUser   {
	private String userId = null;
	private String userName = null;//用户姓名
	private String userPwd = null; //用户密码
	private String userMemo = null;//用户详情介绍
	private String roleId = null;  
	private String addressId = null;
	private String lastLoginTime = null;//上次登录时间
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月19日 上午10:27:40
	* @Description  无
	 */
	public MisUser(){
		
	}
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月19日 上午10:27:52
	* @Description 对misUser类的每个属性进行初始化
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
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:33:29
	  *@Description 返回 用户id属性值
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:38:52
	  *@Description 对userId属性初始化
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@exception @return
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:50:21
	  *@Description 返回 用户userName属性值
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@exception @param userId
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:53:52
	  *@Description 对userName属性初始化
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@exception @return
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:55:01
	  *@Description 返回 用户userPwd属性值
	 */
	public String getUserPwd() {
		return userPwd;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@exception userId
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:58:52
	  *@Description 对userPwd属性初始化
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:59:24
	  *@Description 返回 用户userMemo属性值
	 */
	public String getUserMemo() {
		return userMemo;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午11:05:10
	  *@Description 对userMemo属性初始化
	 */

	public void setUserMemo(String userMemo) {
		this.userMemo = userMemo;
	}

	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午11:10:24
	  *@Description 返回 用户roleId属性值
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@exception @param userId
	  *@author 王攀登
	  *@Time 2015年4月19日上午11:11:52
	  *@Description 对roleId属性初始化
	 */

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午11:12:29
	  *@Description 返回 用户addressId属性值
	 */
	public String getAddressId() {
		return addressId;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午11:13:52
	  *@Description 对addressId属性初始化
	 */

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午11:14:29
	  *@Description 返回 用户lastLoginTime属性值
	 */

	public String getLastLoginTime() {
		return lastLoginTime;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月19日上午11:16:52
	  *@Description 对lastLoginTime属性初始化
	 */

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	/**
	 * *@author 王攀登
	  *@Time 2015年4月19日上午11:17:12
	 * @Description 将对象的地址进行一次哈希运算
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
	 * @author 王攀登
	 *@Time 2015年4月19日上午11:28:52
	 * @Description 将引用不同,对象内容相同的看成同一个对象,与业务逻辑一致
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
	 *@author 王攀登
	 *@Time 2015年4月19日上午11:51:52
	 * @Description 打印对象的信息
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
