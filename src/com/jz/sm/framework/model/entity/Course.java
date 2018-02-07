package com.jz.sm.framework.model.entity;
/**
 * 
* 类的描述
* @author 王攀登 
* @date 2015年4月22日 上午9:01:11
* @Description 将数据库schoolmis_new中的course
* 				  表缓存在java中
 */
public class Course {
	private String courseId = null;//课程编号
	private String courseName = null;//课程名字
	private String courseHour = null;//课时
	private String courseMemo = null;//备注
	private String specialtyId = null;//专业编号
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月22日 上午9:02:40
	* @Description  无
	 */
	public Course() {
		
	}
	
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月22日 上午9:02:52
	* @Description 对Course类的每个属性进行初始化
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
	 * *@author 王攀登
	  *@Time 2015年4月22日上午9:04:52
	 * @Description 将对象的地址进行一次哈希运算
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
