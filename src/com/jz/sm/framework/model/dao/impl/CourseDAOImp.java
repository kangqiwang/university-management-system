package com.jz.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jz.sm.framework.model.entity.Course;
import com.jz.sm.framework.model.util.DBUtil;
/**
 * 
* 类的描述
* @author 王攀登
* @date 2015年4月23日 上午11:01:03
* @Description  CourseDAOImp类实现了 ICourseDAO接口,实现了所有的抽象方法
 */
public class CourseDAOImp implements ICourseDAO{
	/**
	 * 
	  * 方法注释
	  *@return List<Course>  	
	  *@author 王攀登
	  * @date 2015年4月23日 上午11:01:10
	  *@Description 查询所有的课程
	 */
	public List<Course> findAll() {
		List<Course> list = new ArrayList<Course>();
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from course";
		ResultSet rs = dbUtil.query(sql);
		try {
			while(rs.next()) {
				Course course = new Course(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据课程名称得到课程编号
	 */
	@Override
	public String findByName(String name) {
		String courseId  = null;
		DBUtil dbUtil = new DBUtil();
		String sql = "select courseId from course where courseName = '"+ name +"'";
		ResultSet rs = dbUtil.query(sql);
		try {
			while(rs.next()) {
				courseId = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseId;
	}
}
