
package com.jz.sm.framework.model.entity;


/**
 * 
* 类的描述
* @author 王攀登
* @date 2015年4月20日 上午12:00:06
* @Description  将数据库schoolmis_new中的Menu表
* 				  表缓存在java中
 */
public class MenuBean   {
	
	private String menuId;//本菜单的实际代号,应该由用户输入,或程序生成
	private String menuName;//菜单的名称,如:学校简介
	private String menuMemo;//菜单备注
	private String welcomePage;//菜单备注
	
	/**
	 * 
		构造方法的描述
	* @author 王攀登
	* @date 2015年4月20日 上午12:10:27
	* @Description  无
	 */
	public MenuBean(){
		
	}
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月20日 上午12:21:52
	* @Description 对MenuBean类的每个属性进行初始化
	 */
	public MenuBean(String menuId, String menuName, String menuMemo,
			String welcomePage) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuMemo = menuMemo;
		this.welcomePage = welcomePage;
	}
	/**
	 * 
	  * 方法注释
	  *@author 王攀登
	  *@Time 2015年4月20日上午12:33:29
	  *@Description 返回 菜单Id属性值
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月20日上午12:38:52
	  *@Description 对 菜单Id属性初始化
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 
	  * 方法注释
	  *@author 王攀登
	  *@Time 2015年4月20日上午13:18:29
	  *@Description 返回 菜单名称属性值
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月20日上午13:28:52
	  *@Description 对 菜单名称属性初始化
	 */	
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 
	  * 方法注释
	  *@author 王攀登
	  *@Time 2015年4月20日上午13:29:29
	  *@Description 返回 菜单备注属性值
	 */
	public String getMenuMemo() {
		return menuMemo;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月20日上午13:30:52
	  *@Description 对  菜单备注属性初始化
	 */
	public void setMenuMemo(String menuMemo) {
		this.menuMemo = menuMemo;
	}
	/**
	 * 
	  * 方法注释
	  *@author 王攀登
	  *@Time 2015年4月20日上午13:33:29
	  *@Description 返回 welcomePage属性值
	 */
	public String getWelcomePage() {
		return welcomePage;
	}
	/**
	 * 
	  * 方法注释
	  *@author 王攀登
	  *@Time 2015年4月20日上午13:33:52
	  *@Description welcomePage初始化
	 */
	public void setWelcomePage(String welcomePage) {
		this.welcomePage = welcomePage;
	}
	/**
	 * *@author 王攀登
	  *@Time 2015年4月20日上午13:34:12
	 * @Description 将对象的地址进行一次哈希运算
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		result = prime * result
				+ ((menuMemo == null) ? 0 : menuMemo.hashCode());
		result = prime * result
				+ ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result
				+ ((welcomePage == null) ? 0 : welcomePage.hashCode());
		return result;
	}
	/**
	 * @author 王攀登
	 *@Time 2015年4月20日上午13:45：52
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
		MenuBean other = (MenuBean) obj;
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.menuId))
			return false;
		if (menuMemo == null) {
			if (other.menuMemo != null)
				return false;
		} else if (!menuMemo.equals(other.menuMemo))
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (welcomePage == null) {
			if (other.welcomePage != null)
				return false;
		} else if (!welcomePage.equals(other.welcomePage))
			return false;
		return true;
	}
	/**
	 *@author 王攀登
	 *@Time 2015年4月20日上午13:51:52
	 * @Description 打印对象的信息
	 * 
	 */
	@Override
	public String toString() {
		return "MenuBean [menuId=" + menuId + ", menuName=" + menuName
				+ ", menuMemo=" + menuMemo + ", welcomePage=" + welcomePage
				+ "]";
	}
	
	
	
	
	
	
	
	
}
