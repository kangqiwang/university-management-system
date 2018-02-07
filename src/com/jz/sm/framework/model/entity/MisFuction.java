
package com.jz.sm.framework.model.entity;


/**
 * 
* 类的描述
* @author 王攀登 
* @date 2015年4月26日 上午10:25:11
* @Description 将数据库schoolmis_new中的misFuction
* 				  表缓存在java中
 */

public class MisFuction   {
	private String functionId = null;
	private String functionName = null;//功能名称
	private String functionClass = null;//完成此功能的类
	private String functionMemo = null;//功能备注
	private String menuId = null;		//与该功能相对应的菜单
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月26日 上午10:27:40
	* @Description  无
	 */
	public MisFuction(){
		
	}
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月26日 上午10:27:52
	* @Description 对MisFuction类的每个属性进行初始化
	 */
	
	public MisFuction(String functionId, String functionName,
			String functionClass, String functionMemo, String menuId) {
		super();
		this.functionId = functionId;
		this.functionName = functionName;
		this.functionClass = functionClass;
		this.functionMemo = functionMemo;
		this.menuId = menuId;
	}
	//公有的属性访问器
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getFunctionClass() {
		return functionClass;
	}
	public void setFunctionClass(String functionClass) {
		this.functionClass = functionClass;
	}
	public String getFunctionMemo() {
		return functionMemo;
	}
	public void setFunctionMemo(String functionMemo) {
		this.functionMemo = functionMemo;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	/**
	 *@author 王攀登
	 *@Time 2015年4月26日上午10:30:52
	 * @Description 打印对象的信息
	 * 
	 */
	@Override
	public String toString() {
		return "MisFuction [functionId=" + functionId + ", functionName="
				+ functionName + ", functionClass=" + functionClass
				+ ", functionMemo=" + functionMemo + ", menuId=" + menuId + "]";
	}
	/**
	 * *@author 王攀登
	  *@Time 2015年4月26日上午10:31:12
	 * @Description 将对象的地址进行一次哈希运算
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((functionClass == null) ? 0 : functionClass.hashCode());
		result = prime * result
				+ ((functionId == null) ? 0 : functionId.hashCode());
		result = prime * result
				+ ((functionMemo == null) ? 0 : functionMemo.hashCode());
		result = prime * result
				+ ((functionName == null) ? 0 : functionName.hashCode());
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		return result;
	}
	/**
	 * @author 王攀登
	 *@Time 2015年4月26日上午10:33:52
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
		MisFuction other = (MisFuction) obj;
		if (functionClass == null) {
			if (other.functionClass != null)
				return false;
		} else if (!functionClass.equals(other.functionClass))
			return false;
		if (functionId == null) {
			if (other.functionId != null)
				return false;
		} else if (!functionId.equals(other.functionId))
			return false;
		if (functionMemo == null) {
			if (other.functionMemo != null)
				return false;
		} else if (!functionMemo.equals(other.functionMemo))
			return false;
		if (functionName == null) {
			if (other.functionName != null)
				return false;
		} else if (!functionName.equals(other.functionName))
			return false;
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.menuId))
			return false;
		return true;
	}

		

	
	
	
	
}
