package com.jz.sm.framework.model.entity;


/**
 * 
* �������
* @author ���ʵ� 
* @date 2015��4��21�� ����10:50:11
* @Description �����ݿ�schoolmis_new�е�org
* 				  ���е��ֶλ�����java��
 */
public class Org {
	private String orgId = null;
	private String orgName = null;//��������
	private String orgMemo = null;//������ע
	private String orgTypeId = null;
	
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��21�� ����10:51:40
	* @Description  ��
	 */
	public Org() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��21�� ����10:52:52
	* @Description ��Org���ÿ�����Խ��г�ʼ��
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
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:54:29
	  *@Description ���� ����id����ֵ
	 */
	public String getOrgId() {
		return orgId;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:54:52
	  *@Description �Ի���id���Գ�ʼ��
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:55:20
	  *@Description ���� ��������orgName����ֵ
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:55:52
	  *@Description �Ի����������Գ�ʼ��
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:56:20
	  *@Description ���� ������עorgMemo����ֵ
	 */
	public String getOrgMemo() {
		return orgMemo;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:56:52
	  *@Description �Ի�����ע���Գ�ʼ��
	 */
	public void setOrgMemo(String orgMemo) {
		this.orgMemo = orgMemo;
	}
	/**
	 * 
	  * ����ע��
	  *@return String 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:58:22
	  *@Description ���� �������
	 */
	public String getOrgTypeId() {
		return orgTypeId;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��21������10:58:52
	  *@Description �Ի������id���Գ�ʼ��
	 */
	public void setOrgTypeId(String orgTypeId) {
		this.orgTypeId = orgTypeId;
	}
	/**
	 * *@author ���ʵ�
	  *@Time 2015��4��21������10:59:12
	 * @Description ������ĵ�ַ����һ�ι�ϣ����
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
	 * @author ���ʵ�
	 *@Time 2015��4��21������11:01:52
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
	 *@author ���ʵ�
	 *@Time 2015��4��21������11:02:52
	 * @Description ��ӡ�������Ϣ
	 * 
	 */
	@Override
	public String toString() {
		return "Org [orgId=" + orgId + ", orgName="
				+ orgName + ", orgMemo=" + orgMemo + ", orgTypeId=" + orgTypeId
				+ "]";
	}
	
	
}
