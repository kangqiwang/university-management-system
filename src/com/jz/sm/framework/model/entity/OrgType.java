
package com.jz.sm.framework.model.entity;


/**
 * 
* 类的描述
* @author 王攀登 
* @date 2015年4月22日 上午9:01:11
* @Description 将数据库schoolmis_new中的orgType
* 				  表缓存在java中
 */
public class OrgType   {
	private String orgTypeId = null;//机构类别编号
	private String orgTypeName = null;//机构类别名称
	private String orgTypeMemo = null;//备注
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月22日 上午9:02:40
	* @Description  无
	 */
	
	public OrgType(){
		
	}

	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月22日 上午9:02:52
	* @Description 对OrgType类的每个属性进行初始化
	 */
	public OrgType(String orgTypeId, String orgTypeName, String orgTypeMemo) {
		super();
		this.orgTypeId = orgTypeId;
		this.orgTypeName = orgTypeName;
		this.orgTypeMemo = orgTypeMemo;
	}
	/**
	 *@author 王攀登
	 *@Time 2015年4月22日上午9:03:52
	 * @Description 打印对象的信息
	 * 
	 */
	@Override
	public String toString() {
		return "OrgType [orgTypeId=" + orgTypeId + ", orgTypeName="
				+ orgTypeName + ", orgTypeMemo=" + orgTypeMemo + "]";
	}

	/**
	 * *@author 王攀登
	  *@Time 2015年4月22日上午9:04:52
	 * @Description 将对象的地址进行一次哈希运算
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orgTypeId == null) ? 0 : orgTypeId.hashCode());
		result = prime * result
				+ ((orgTypeMemo == null) ? 0 : orgTypeMemo.hashCode());
		result = prime * result
				+ ((orgTypeName == null) ? 0 : orgTypeName.hashCode());
		return result;
	}
	/**
	 * @author 王攀登
	 *@Time 2015年4月22日上午9:05:52
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
		OrgType other = (OrgType) obj;
		if (orgTypeId == null) {
			if (other.orgTypeId != null)
				return false;
		} else if (!orgTypeId.equals(other.orgTypeId))
			return false;
		if (orgTypeMemo == null) {
			if (other.orgTypeMemo != null)
				return false;
		} else if (!orgTypeMemo.equals(other.orgTypeMemo))
			return false;
		if (orgTypeName == null) {
			if (other.orgTypeName != null)
				return false;
		} else if (!orgTypeName.equals(other.orgTypeName))
			return false;
		return true;
	}
	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月22日上午09:06:29
	  *@Description 返回 机构类别id属性值
	 */
	public String getOrgTypeId() {
		return orgTypeId;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月22日上午09:07:29
	  *@Description 对orgTypeId属性初始化
	 */
	public void setOrgTypeId(String orgTypeId) {
		this.orgTypeId = orgTypeId;
	}
	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月22日上午09:08:02
	  *@Description 返回 机构类别名称
	 */
	public String getOrgTypeName() {
		return orgTypeName;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月22日上午09:08:29
	  *@Description 对orgTypeName属性初始化
	 */
	public void setOrgTypeName(String orgTypeName) {
		this.orgTypeName = orgTypeName;
	}
	/**
	 * 
	  * 方法注释
	  *@return String 	
	  *@author 王攀登
	  *@Time 2015年4月22日上午09:09:29
	  *@Description 返回 机构类别备注
	 */
	public String getOrgTypeMemo() {
		return orgTypeMemo;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月22日上午09:10:29
	  *@Description 对orgTypeMemo属性初始化
	 */
	public void setOrgTypeMemo(String orgTypeMemo) {
		this.orgTypeMemo = orgTypeMemo;
	}
	
	
	
	
}
