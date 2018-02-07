package com.jz.sm.framework.model.entity;

/**
 * 
* �������
* @author ���ʵ� 
* @date 2015��4��22�� ����9:01:11
* @Description �����ݿ�schoolmis_new�е�student
* 				  ������java��
 */
public class Student {
	private String studentId = null;//ѧ�����
	private String studentName = null;//ѧ������
	private String studentSex = null;//�Ա�
	private String studentBirthday = null;//����
	private String studentTel = null;//�绰
	private String studentAddress = null;//סַ
	private String studentInDate = null;//��ѧ����
	private String studentMemo = null;//��ע
	private String classId = null;//�༶���
	
	/**
	 * 
	* @author ���ʵ� 
	* @date 2015��4��22�� ����9:02:40
	* @Description  ��ӡ������Ϣ
	 */
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName="
				+ studentName + ", studentSex=" + studentSex
				+ ", studentBirthday=" + studentBirthday + ", studentTel="
				+ studentTel + ", studentAddress=" + studentAddress
				+ ", studentInDate=" + studentInDate + ", studentMemo="
				+ studentMemo + ", classId=" + classId + "]";
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
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		result = prime * result
				+ ((studentAddress == null) ? 0 : studentAddress.hashCode());
		result = prime * result
				+ ((studentBirthday == null) ? 0 : studentBirthday.hashCode());
		result = prime * result
				+ ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result
				+ ((studentInDate == null) ? 0 : studentInDate.hashCode());
		result = prime * result
				+ ((studentMemo == null) ? 0 : studentMemo.hashCode());
		result = prime * result
				+ ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result
				+ ((studentSex == null) ? 0 : studentSex.hashCode());
		result = prime * result
				+ ((studentTel == null) ? 0 : studentTel.hashCode());
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
		Student other = (Student) obj;
		if (classId == null) {
			if (other.classId != null)
				return false;
		} else if (!classId.equals(other.classId))
			return false;
		if (studentAddress == null) {
			if (other.studentAddress != null)
				return false;
		} else if (!studentAddress.equals(other.studentAddress))
			return false;
		if (studentBirthday == null) {
			if (other.studentBirthday != null)
				return false;
		} else if (!studentBirthday.equals(other.studentBirthday))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (studentInDate == null) {
			if (other.studentInDate != null)
				return false;
		} else if (!studentInDate.equals(other.studentInDate))
			return false;
		if (studentMemo == null) {
			if (other.studentMemo != null)
				return false;
		} else if (!studentMemo.equals(other.studentMemo))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (studentSex == null) {
			if (other.studentSex != null)
				return false;
		} else if (!studentSex.equals(other.studentSex))
			return false;
		if (studentTel == null) {
			if (other.studentTel != null)
				return false;
		} else if (!studentTel.equals(other.studentTel))
			return false;
		return true;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSex() {
		return studentSex;
	}
	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}
	public String getStudentBirthday() {
		return studentBirthday;
	}
	public void setStudentBirthday(String studentBirthday) {
		this.studentBirthday = studentBirthday;
	}
	public String getStudentTel() {
		return studentTel;
	}
	public void setStudentTel(String studentTel) {
		this.studentTel = studentTel;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentInDate() {
		return studentInDate;
	}
	public void setStudentInDate(String studentInDate) {
		this.studentInDate = studentInDate;
	}
	public String getStudentMemo() {
		return studentMemo;
	}
	public void setStudentMemo(String studentMemo) {
		this.studentMemo = studentMemo;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��22�� ����9:02:40
	* @Description  ��
	 */
	
	public Student() {
		
	}
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��22�� ����9:02:52
	* @Description ��Teacher���ÿ�����Խ��г�ʼ��
	 */

	public Student(String studentId, String studentName, String studentSex,
			String studentBirthday, String studentTel, String studentAddress,
			String studentInDate, String studentMemo, String classId) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentSex = studentSex;
		this.studentBirthday = studentBirthday;
		this.studentTel = studentTel;
		this.studentAddress = studentAddress;
		this.studentInDate = studentInDate;
		this.studentMemo = studentMemo;
		this.classId = classId;
	}

	
}
