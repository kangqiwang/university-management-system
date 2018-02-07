package com.jz.sm.framework.model.entity;

/**
 * 
* 类的描述
* @author 王攀登 
* @date 2015年4月22日 上午9:01:11
* @Description 将数据库schoolmis_new中的teacher
* 				  表缓存在java中
 */
public class Teacher {
	
	private String id_teacher = null;//教师编号
	private String teacher_name = null;//教师姓名
	private String teacher_sex = null;//教师性别
	private String teacher_age = null;//教师年龄
	private String courseId = null; //课程编号
	
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月22日 上午9:02:40
	* @Description  无
	 */
	public Teacher() {
		
	}
	
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月22日 上午9:02:52
	* @Description 对Teacher类的每个属性进行初始化
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
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月22日 上午9:02:52
	* @Description 对Teacher类的除了编号属性都进行初始化
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
	 * *@author 王攀登
	  *@Time 2015年4月22日上午9:04:52
	 * @Description 将对象的地址进行一次哈希运算
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
	 * *@author 王攀登
	  *@Time 2015年4月22日上午9:04:52
	 * @Description 打印对象信息
	 */

	@Override
	public String toString() {
		return "Teacher [id_teacher=" + id_teacher + ", teacher_name="
				+ teacher_name + ", teacher_sex=" + teacher_sex
				+ ", teacher_age=" + teacher_age + ", courseId=" + courseId
				+ "]";
	}
	
	
}
