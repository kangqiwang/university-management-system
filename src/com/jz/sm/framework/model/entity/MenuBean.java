
package com.jz.sm.framework.model.entity;


/**
 * 
* �������
* @author ���ʵ�
* @date 2015��4��20�� ����12:00:06
* @Description  �����ݿ�schoolmis_new�е�Menu��
* 				  ������java��
 */
public class MenuBean   {
	
	private String menuId;//���˵���ʵ�ʴ���,Ӧ�����û�����,���������
	private String menuName;//�˵�������,��:ѧУ���
	private String menuMemo;//�˵���ע
	private String welcomePage;//�˵���ע
	
	/**
	 * 
		���췽��������
	* @author ���ʵ�
	* @date 2015��4��20�� ����12:10:27
	* @Description  ��
	 */
	public MenuBean(){
		
	}
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��20�� ����12:21:52
	* @Description ��MenuBean���ÿ�����Խ��г�ʼ��
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
	  * ����ע��
	  *@author ���ʵ�
	  *@Time 2015��4��20������12:33:29
	  *@Description ���� �˵�Id����ֵ
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��20������12:38:52
	  *@Description �� �˵�Id���Գ�ʼ��
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 
	  * ����ע��
	  *@author ���ʵ�
	  *@Time 2015��4��20������13:18:29
	  *@Description ���� �˵���������ֵ
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��20������13:28:52
	  *@Description �� �˵��������Գ�ʼ��
	 */	
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 
	  * ����ע��
	  *@author ���ʵ�
	  *@Time 2015��4��20������13:29:29
	  *@Description ���� �˵���ע����ֵ
	 */
	public String getMenuMemo() {
		return menuMemo;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��20������13:30:52
	  *@Description ��  �˵���ע���Գ�ʼ��
	 */
	public void setMenuMemo(String menuMemo) {
		this.menuMemo = menuMemo;
	}
	/**
	 * 
	  * ����ע��
	  *@author ���ʵ�
	  *@Time 2015��4��20������13:33:29
	  *@Description ���� welcomePage����ֵ
	 */
	public String getWelcomePage() {
		return welcomePage;
	}
	/**
	 * 
	  * ����ע��
	  *@author ���ʵ�
	  *@Time 2015��4��20������13:33:52
	  *@Description welcomePage��ʼ��
	 */
	public void setWelcomePage(String welcomePage) {
		this.welcomePage = welcomePage;
	}
	/**
	 * *@author ���ʵ�
	  *@Time 2015��4��20������13:34:12
	 * @Description ������ĵ�ַ����һ�ι�ϣ����
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
	 * @author ���ʵ�
	 *@Time 2015��4��20������13:45��52
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
	 *@author ���ʵ�
	 *@Time 2015��4��20������13:51:52
	 * @Description ��ӡ�������Ϣ
	 * 
	 */
	@Override
	public String toString() {
		return "MenuBean [menuId=" + menuId + ", menuName=" + menuName
				+ ", menuMemo=" + menuMemo + ", welcomePage=" + welcomePage
				+ "]";
	}
	
	
	
	
	
	
	
	
}
