package com.jz.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jz.sm.framework.model.entity.OrgType;
import com.jz.sm.framework.model.entity.Teacher;
import com.jz.sm.framework.model.util.DBUtil;

/**
 * 
* �������
* @author ���ʵ�
* @date 2015��4��21�� ����11:10:03
* @Description  TeacherDAOImpʵ���� ITeacherDAO�ӿ�,ʵ�������еĳ��󷽷�
 */
public class TeacherDAOImp implements ITeacherDAO{
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:01:10
	  *@Description ��Teacher�����һ��ʵ��תΪsql�������ݲ㣬�ӵ����ݿ���,
	  *             �������Ϊ��,��ӳɹ�,��֮,ʧ��
	 */
	@Override
	public boolean add(Teacher teacher) {
		boolean flag = false;
		DBUtil dbUtil = new DBUtil();
		String id = teacher.getId_teacher();
		String name = teacher.getTeacher_name();
		String sex = teacher.getTeacher_sex();
		String age = teacher.getTeacher_age();
		String courseId = teacher.getCourseId();
		String sql = "insert into Teacher(teacher_name,teacher_sex,teacher_age,courseId)"
				+ "values ('"+name+"','"+sex+"','"+age+"','"+courseId+"')";
		int n = dbUtil.update(sql);
		if(n > 0) {
			flag = true;
		}
		return flag;
	}
	/**
	 * 
	  * ����ע��
	  *@return List<OrgType> 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:12:03
	  *@Description   �ȵõ�Ҫ��ѯ�������������ֵ,Ȼ��תΪsql���,�������ݲ�Ĳ�ѯ����,
	  *             �᷵�ز�ѯ���ݿ��еĶ�����¼,�����صļ�¼תΪ���Teacherʵ��,�浽������
	  *            
	 */
	@Override
	public List<Teacher> findByLike(Teacher teacher) {
		String s1 = "select * from teacher where";
		String s2 = "";
		String s3 = null;
		String sql = null;
		String id = teacher.getId_teacher();
		String name = teacher.getTeacher_name();
		String sex = teacher.getTeacher_sex();
		String age = teacher.getTeacher_age();
		String courseId = teacher.getCourseId();
		if(id != null&&id.length() >= 0){
			s2 = s2+" Id_teacher like '%"+id+"%'";
		}
		if(name!=null&&name.length() >= 0){
			s2 = s2+" and teacher_name like '%"+name+"%'";
		}
		if(sex != null&&sex.length() >= 0){
			s2 = s2+" and teacher_sex like '%"+sex+"%'";
		}
		if(age != null&&age.length() >= 0){
			s2 = s2+" and teacher_age like '%"+age+"%'";
		}
		if(courseId != null&&courseId.length() >= 0){
			s2 = s2+" and courseId like '%"+courseId+"%'";
		}
		if (s2.length()>0) {
			 s3 = s1+s2;
			if (s3.contains(" and")) {
				 sql = s3.replace("where and","where ");
			 	
			}	
		}else {
			sql = s1.replace("where", " ");	
		}
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		List<Teacher>  list = new ArrayList<Teacher>();
		try {
			while (rs.next()) {
				Teacher tempTeacher = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(tempTeacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{//�ر���Դ
			dbUtil.close();
		}
		return list;
	}
	
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:02:03
	  *@Description ��idתΪsql,�������ݿ��,�Ȳ�ѯ�Ƿ����������,������,��ɾ���˶���,û�оͷ���
	  *            
	 */
	@Override
	public boolean remove(String id) {
		DBUtil  dbUtil = new DBUtil();
		boolean flag = false;
		Teacher temp = null;
		List<Teacher> list = this.findByLike(new Teacher(id, "", "", "", ""));
		temp = list.get(0);
		if(temp!=null){
			String sql2 = "delete from teacher where  Id_teacher ='"+id+"'";
			int n = dbUtil.update(sql2);
			if(n>0){
				System.out.println("ɾ����");
				flag = true;
			}else {
				System.out.println("ɾ��ʧ��");
			}
			
			
		} else {
			System.out.println("û�б��Ϊ"+id+"�������");
			
		}
		dbUtil.close();
		return flag;
	}
	
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:04:03
	  *@Description ��Teacher����ʵ��תΪsql,�������ݿ��,�Ȳ�ѯ�Ƿ����������,
	  *             ������,���޸Ĵ˶��������ݿ����Ӧ��һ����¼,��֮,����ö���
	  *             �����ӷ���,����һ������ʵ�����൱�����ݿ��е�һ����¼��
	  *            
	 */
	@Override
	public boolean modify(Teacher teacher) {
		boolean flag = false;
		DBUtil dbUtil = new DBUtil();
		String id = teacher.getId_teacher();
		String name = teacher.getTeacher_name();
		String sex = teacher.getTeacher_sex();
		String age = teacher.getTeacher_age();
		String courseId = teacher.getCourseId();
		Teacher temp = null;
		List<Teacher> list = this.findByLike(new Teacher(id, "", "", "", ""));
		temp = list.get(0);
		if(temp != null){
			String  sql = "update teacher set teacher_name ='"+name+"',teacher_sex='"+sex+"' ,"
					+ "teacher_age='"+age+"',courseId='"+courseId+"' "
					+ "where Id_teacher ='"+id+"'";
			int n = dbUtil.update(sql);
			if(n>0){
				System.out.println("�޸ĳɹ�");
				flag = true;
			}else {
				System.out.println("�޸�ʧ��");
			}
		}
		else {
			flag = this.add(teacher);
			flag = true;
		}
		
		dbUtil.close();
		return flag;
	}

}
