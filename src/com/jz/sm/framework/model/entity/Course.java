package com.jz.sm.framework.model.entity;
/**
 * 
* �������
* @author ���ʵ� 
* @date 2015��4��22�� ����9:01:11
* @Description �����ݿ�schoolmis_new�е�course
* 				  ������java��
 */
public class Course {
	private String courseId = null;//�γ̱��
	private String courseName = null;//�γ�����
	private String courseHour = null;//��ʱ
	private String courseMemo = null;//��ע
	private String specialtyId = null;//רҵ���
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��22�� ����9:02:40
	* @Description  ��
	 */
	public Course() {
		
	}
	
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��22�� ����9:02:52
	* @Description ��Course���ÿ�����Խ��г�ʼ��
	 */
	public Course(String courseId, String courseName, String courseHour,
			String courseMemo, String specialtyId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseHour = courseHour;
		this.courseMemo = courseMemo;
		this.specialtyId = specialtyId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseHour() {
		return courseHour;
	}

	public void setCourseHour(String courseHour) {
		this.courseHour = courseHour;
	}

	public String getCourseMemo() {
		return courseMemo;
	}

	public void setCourseMemo(String courseMemo) {
		this.courseMemo = courseMemo;
	}

	public String getSpecialtyId() {
		return specialtyId;
	}

	public void setSpecialtyId(String specialtyId) {
		this.specialtyId = specialtyId;
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
				+ ((courseHour == null) ? 0 : courseHour.hashCode());
		result = prime * result
				+ ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result
				+ ((courseMemo == null) ? 0 : courseMemo.hashCode());
		result = prime * result
				+ ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result
				+ ((specialtyId == null) ? 0 : specialtyId.hashCode());
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
		Course other = (Course) obj;
		if (courseHour == null) {
			if (other.courseHour != null)
				return false;
		} else if (!courseHour.equals(other.courseHour))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (courseMemo == null) {
			if (other.courseMemo != null)
				return false;
		} else if (!courseMemo.equals(other.courseMemo))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (specialtyId == null) {
			if (other.specialtyId != null)
				return false;
		} else if (!specialtyId.equals(other.specialtyId))
			return false;
		return true;
	}
	
	
}
