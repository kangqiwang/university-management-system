package com.jz.sm.framework.model.entity;


/**
 * 
* 类的描述
* @author 王攀登 
* @date 2015年4月21日 上午10:50:11
* @Description 将数据库schoolmis_new中的org
* 				  表中的字段缓存在java中
 */
public class Org {
	private String orgId = null;
	private String orgName = null;//机构名称
	private String orgMemo = null;//机构备注
	private String orgTypeId = null;
	
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月21日 上午10:51:40
	* @Description  无
	 */
	public Org() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月21日 上午10:52:52
	* @Description 对Org类的每个属性进行初始化
	 */
	
	public Org(String orgId, String orgName, String orgMemo,
			String orgTypeId) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.orgMemo = orgMemo;
		this.orgTypeId = orgTypeId;
	}
	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:54:29
	  *@Description 返回 机构id属性值
	 */
	public String getOrgId() {
		return orgId;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:54:52
	  *@Description 对机构id属性初始化
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:55:20
	  *@Description 返回 机构名称orgName属性值
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:55:52
	  *@Description 对机构名称属性初始化
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:56:20
	  *@Description 返回 机构备注orgMemo属性值
	 */
	public String getOrgMemo() {
		return orgMemo;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:56:52
	  *@Description 对机构备注属性初始化
	 */
	public void setOrgMemo(String orgMemo) {
		this.orgMemo = orgMemo;
	}
	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:58:22
	  *@Description 返回 机构类别
	 */
	public String getOrgTypeId() {
		return orgTypeId;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月21日上午10:58:52
	  *@Description 对机构类别id属性初始化
	 */
	public void setOrgTypeId(String orgTypeId) {
		this.orgTypeId = orgTypeId;
	}
	/**
	 * *@author 王攀登
	  *@Time 2015年4月21日上午10:59:12
	 * @Description 将对象的地址进行一次哈希运算
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		result = prime * result + ((orgMemo == null) ? 0 : orgMemo.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime * result
				+ ((orgTypeId == null) ? 0 : orgTypeId.hashCode());
		return result;
	}
	/**
	 * @author 王攀登
	 *@Time 2015年4月21日上午11:01:52
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
		Org other = (Org) obj;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		if (orgMemo == null) {
			if (other.orgMemo != null)
				return false;
		} else if (!orgMemo.equals(other.orgMemo))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		if (orgTypeId == null) {
			if (other.orgTypeId != null)
				return false;
		} else if (!orgTypeId.equals(other.orgTypeId))
			return false;
		return true;
	}

	/**
	 *@author 王攀登
	 *@Time 2015年4月21日上午11:02:52
	 * @Description 打印对象的信息
	 * 
	 */
	@Override
	public String toString() {
		return "Org [orgId=" + orgId + ", orgName="
				+ orgName + ", orgMemo=" + orgMemo + ", orgTypeId=" + orgTypeId
				+ "]";
	}
	
	
}
