package com.jz.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jz.sm.framework.model.entity.Course;
import com.jz.sm.framework.model.util.DBUtil;
/**
 * 
* �������
* @author ���ʵ�
* @date 2015��4��23�� ����11:01:03
* @Description  CourseDAOImp��ʵ���� ICourseDAO�ӿ�,ʵ�������еĳ��󷽷�
 */
public class CourseDAOImp implements ICourseDAO{
	/**
	 * 
	  * ����ע��
	  *@return List<Course>  	
	  *@author ���ʵ�
	  * @date 2015��4��23�� ����11:01:10
	  *@Description ��ѯ���еĿγ�
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
	 * ���ݿγ����Ƶõ��γ̱��
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
