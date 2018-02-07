package com.jz.sm.framework.model.entity;

/**
 * 
* �������
* @author ���ʵ� 
* @date 2015��4��22�� ����9:01:11
* @Description �����ݿ�schoolmis_new�е�teacher
* 				  ������java��
 */
public class Teacher {
	
	private String id_teacher = null;//��ʦ���
	private String teacher_name = null;//��ʦ����
	private String teacher_sex = null;//��ʦ�Ա�
	private String teacher_age = null;//��ʦ����
	private String courseId = null; //�γ̱��
	
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��22�� ����9:02:40
	* @Description  ��
	 */
	public Teacher() {
		
	}
	
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��22�� ����9:02:52
	* @Description ��Teacher���ÿ�����Խ��г�ʼ��
	 */

	
	public Teacher(String id_teacher, String teacher_name, String teacher_sex,
			String teacher_age, String courseId) {
		super();
		this.id_teacher = id_teacher;
		this.teacher_name = teacher_name;
		this.teacher_sex = teacher_sex;
		this.teacher_age = teacher_age;
		this.courseId = courseId;
	}
	
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��22�� ����9:02:52
	* @Description ��Teacher��ĳ��˱�����Զ����г�ʼ��
	 */
	public Teacher( String teacher_name, String teacher_sex,
			String teacher_age, String courseId) {
		this.teacher_name = teacher_name;
		this.teacher_sex = teacher_sex;
		this.teacher_age = teacher_age;
		this.courseId = courseId;
	}

	
	
	public String getId_teacher() {
		return id_teacher;
	}

	public void setId_teacher(String id_teacher) {
		this.id_teacher = id_teacher;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_sex() {
		return teacher_sex;
	}

	public void setTeacher_sex(String teacher_sex) {
		this.teacher_sex = teacher_sex;
	}

	public String getTeacher_age() {
		return teacher_age;
	}

	public void setTeacher_age(String teacher_age) {
		this.teacher_age = teacher_age;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
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
				+ ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result
				+ ((id_teacher == null) ? 0 : id_teacher.hashCode());
		result = prime * result
				+ ((teacher_age == null) ? 0 : teacher_age.hashCode());
		result = prime * result
				+ ((teacher_name == null) ? 0 : teacher_name.hashCode());
		result = prime * result
				+ ((teacher_sex == null) ? 0 : teacher_sex.hashCode());
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
		Teacher other = (Teacher) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (id_teacher == null) {
			if (other.id_teacher != null)
				return false;
		} else if (!id_teacher.equals(other.id_teacher))
			return false;
		if (teacher_age == null) {
			if (other.teacher_age != null)
				return false;
		} else if (!teacher_age.equals(other.teacher_age))
			return false;
		if (teacher_name == null) {
			if (other.teacher_name != null)
				return false;
		} else if (!teacher_name.equals(other.teacher_name))
			return false;
		if (teacher_sex == null) {
			if (other.teacher_sex != null)
				return false;
		} else if (!teacher_sex.equals(other.teacher_sex))
			return false;
		return true;
	}
	
	/**
	 * *@author ���ʵ�
	  *@Time 2015��4��22������9:04:52
	 * @Description ��ӡ������Ϣ
	 */

	@Override
	public String toString() {
		return "Teacher [id_teacher=" + id_teacher + ", teacher_name="
				+ teacher_name + ", teacher_sex=" + teacher_sex
				+ ", teacher_age=" + teacher_age + ", courseId=" + courseId
				+ "]";
	}
	
	
}
