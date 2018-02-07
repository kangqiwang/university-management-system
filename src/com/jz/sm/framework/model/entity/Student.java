package com.jz.sm.framework.model.entity;

/**
 * 
* 类的描述
* @author 王攀登 
* @date 2015年4月22日 上午9:01:11
* @Description 将数据库schoolmis_new中的student
* 				  表缓存在java中
 */
public class Student {
	private String studentId = null;//学生编号
	private String studentName = null;//学生姓名
	private String studentSex = null;//性别
	private String studentBirthday = null;//生日
	private String studentTel = null;//电话
	private String studentAddress = null;//住址
	private String studentInDate = null;//入学日期
	private String studentMemo = null;//备注
	private String classId = null;//班级编号
	
	/**
	 * 
	* @author 王攀登 
	* @date 2015年4月22日 上午9:02:40
	* @Description  打印对象信息
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
	 * *@author 王攀登
	  *@Time 2015年4月22日上午9:04:52
	 * @Description 将对象的地址进行一次哈希运算
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
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月22日 上午9:02:40
	* @Description  无
	 */
	
	public Student() {
		
	}
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月22日 上午9:02:52
	* @Description 对Teacher类的每个属性进行初始化
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
