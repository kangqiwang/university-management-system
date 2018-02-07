
package com.jz.sm.framework.model.entity;


/**
 * 
* �������
* @author ���ʵ� 
* @date 2015��4��22�� ����9:01:11
* @Description �����ݿ�schoolmis_new�е�orgType
* 				  ������java��
 */
public class OrgType   {
	private String orgTypeId = null;//���������
	private String orgTypeName = null;//�����������
	private String orgTypeMemo = null;//��ע
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��22�� ����9:02:40
	* @Description  ��
	 */
	
	public OrgType(){
		
	}

	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��22�� ����9:02:52
	* @Description ��OrgType���ÿ�����Խ��г�ʼ��
	 */
	public OrgType(String orgTypeId, String orgTypeName, String orgTypeMemo) {
		super();
		this.orgTypeId = orgTypeId;
		this.orgTypeName = orgTypeName;
		this.orgTypeMemo = orgTypeMemo;
	}
	/**
	 *@author ���ʵ�
	 *@Time 2015��4��22������9:03:52
	 * @Description ��ӡ�������Ϣ
	 * 
	 */
	@Override
	public String toString() {
		return "OrgType [orgTypeId=" + orgTypeId + ", orgTypeName="
				+ orgTypeName + ", orgTypeMemo=" + orgTypeMemo + "]";
	}

	/**
	 * *@author ���ʵ�
	  *@Time 2015��4��22������9:04:52
	 * @Description ������ĵ�ַ����һ�ι�ϣ����
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
	 * @author ���ʵ�
	 *@Time 2015��4��22������9:05:52
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
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��22������09:06:29
	  *@Description ���� �������id����ֵ
	 */
	public String getOrgTypeId() {
		return orgTypeId;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��22������09:07:29
	  *@Description ��orgTypeId���Գ�ʼ��
	 */
	public void setOrgTypeId(String orgTypeId) {
		this.orgTypeId = orgTypeId;
	}
	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��22������09:08:02
	  *@Description ���� �����������
	 */
	public String getOrgTypeName() {
		return orgTypeName;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��22������09:08:29
	  *@Description ��orgTypeName���Գ�ʼ��
	 */
	public void setOrgTypeName(String orgTypeName) {
		this.orgTypeName = orgTypeName;
	}
	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��22������09:09:29
	  *@Description ���� �������ע
	 */
	public String getOrgTypeMemo() {
		return orgTypeMemo;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��22������09:10:29
	  *@Description ��orgTypeMemo���Գ�ʼ��
	 */
	public void setOrgTypeMemo(String orgTypeMemo) {
		this.orgTypeMemo = orgTypeMemo;
	}
	
	
	
	
}
