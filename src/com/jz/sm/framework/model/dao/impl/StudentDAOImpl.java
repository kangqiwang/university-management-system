package com.jz.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jz.sm.framework.model.entity.Student;
import com.jz.sm.framework.model.util.DBUtil;

public class StudentDAOImpl implements IStudentDAO {
	/**
	 * 
	  * ����ע��
	  *@return List<Student> 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:12:03
	  *@Description   �ȵõ�Ҫ��ѯ�������������ֵ,Ȼ��תΪsql���,�������ݲ�Ĳ�ѯ����,
	  *             �᷵�ز�ѯ���ݿ��еĶ�����¼,�����صļ�¼תΪ���orgTypeʵ��,�浽������
	  *            
	 */
	@Override
	public List<Student> findByLike(Student student) {
		String s1 = "select * from student where ";
		String s2 = "";
		String s3 = null;
		String sql = null;
		
		String studentId = student.getStudentId();
		String classId = student.getClassId();
		String studentMemo = student.getStudentMemo();
		String studentAddress = student.getStudentAddress();
		String studentBirthday = student.getStudentBirthday();
		String studentInDate = student.getStudentInDate();
		String studentTel = student.getStudentTel();
		String studentName = student.getStudentName();
		String studentSex = student.getStudentSex();
		
		
		if(studentId != null&&studentId.length() >= 0){
			s2 = s2+" studentId like '%"+studentId+"%'";
		}
		if(classId!=null&&classId.length()>=0){
			s2 = s2+" and classId like '%"+classId+"%'";
		}
		if(studentMemo!=null&&studentMemo.length()>=0){
			s2 = s2+" and studentMemo like '%"+studentMemo+"%'";
		}
		if(studentAddress!=null&&studentAddress.length()>=0){
			s2 = s2+" and studentAddress like '%"+studentAddress+"%'";
		}
		if(studentBirthday!=null&&studentBirthday.length()>=0){
			s2 = s2+" and studentBirthday like '%"+studentBirthday+"%'";
		}
		if(studentInDate!=null&&studentInDate.length()>=0){
			s2 = s2+" and studentInDate like '%"+studentInDate+"%'";
		}
		if(studentTel!=null&&studentTel.length()>=0){
			s2 = s2+" and studentTel like '%"+studentTel+"%'";
		}
		if(studentName!=null&&studentName.length()>=0){
			s2 = s2+" and studentName like '%"+studentName+"%'";
		}
		if(studentSex!=null&&studentSex.length()>=0){
			s2 = s2+" and studentSex like '%"+studentSex+"%'";
		}
		
		if (s2.length()>0) {
			 s3 = s1+s2;
			if (s3.contains(" and")) {
				 sql = s3.replace("where and","where "); 	
			}	
		}else {
			sql=s1.replace("where", " ");	
		}
		DBUtil dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		List<Student> list = new ArrayList<Student>();
		try {
			while (rs.next()) {
				Student temp = new Student();
				temp.setStudentId(rs.getString(1));
				temp.setStudentName(rs.getString(2));
				temp.setStudentSex(rs.getString(3));
				temp.setStudentBirthday(rs.getString(4));
				temp.setStudentTel(rs.getString(5));
				temp.setStudentAddress(rs.getString(6));
				temp.setStudentInDate(rs.getString(7));
				temp.setStudentMemo(rs.getString(8));
				temp.setClassId(rs.getString(9));
			
				list.add(temp);	
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
	  *@Description ��studentIdתΪsql,�������ݿ��,�Ȳ�ѯ�Ƿ����������,������,��ɾ���˶���,û�оͷ���
	  *            
	 */
	@Override
	public boolean remove(String studentId) {
		DBUtil  dbUtil = new DBUtil();
		boolean flag = false;
		String id = studentId;
		Student temp = this.findById(id);
		
		if(temp != null){
			String sql2 = "delete from student where studentId='"+id+"'";
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
	  *@return OrgType 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:10:20
	  *@Description ͨ��studentId����תΪsql���,�������ݲ�ķ���,��ѯ���ݿ��е�һ����¼,
	  *				�����صļ�¼תΪstudent����
	  *            
	 */
	@Override
	public Student findById(String studentId) {
		Student  student = null;
		String sql = "select * from student where studentId='"+studentId+"'";
		DBUtil  dbUtil = new DBUtil();
		ResultSet rs = dbUtil.query(sql);
		if(rs != null){
			try {
				while(rs.next()){
					student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				dbUtil.close();
			}
			
			
		}
		else {
			
			System.out.println("û�б��Ϊ"+studentId+"�������");
		}
		return student;
	}
	
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:01:10
	  *@Description ��Student�����һ��ʵ��תΪsql�������ݲ㣬�ӵ����ݿ���,
	  *             �������Ϊ��,��ӳɹ�,��֮,ʧ��
	 */
	@Override
	public boolean add(Student student) {
		boolean flag = false;
		int n=-1;
		String id = student.getStudentId();
		String name = student.getStudentName();
		String sex = student.getStudentSex();
		String birthday = student.getStudentBirthday();
		String tel = student.getStudentTel();
		String address = student.getStudentAddress();
		String date = student.getStudentInDate();
		String memo = student.getStudentMemo();
		String classId = student.getClassId();
		
		Student back=this.findById(id);
		if (back == null) {
			//�ֲ��ַ�������
			String sql="insert into  student (studentId,studentName,studentSex,studentBirthday,studentTel,studentAddress,studentInDate,studentMemo,classId)"
					+ "values('"+id+"','"+name+"','"+sex+"','"+birthday+"','"+tel+"','"+address+"','"+date+"','"+memo+"','"+classId+"')";
			//���²������ݿ�
			System.out.println(sql);
			DBUtil dbUtil=new DBUtil();
			n = dbUtil.update(sql);
			if(n > 0) {
				flag = true;
			}
		}else {
			System.out.println("���ݿ����д˼�¼");
		}
		return flag;
	}
	
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author ���ʵ�
	  * @date 2015��4��22�� ����11:04:03
	  *@Description ��Student����ʵ��תΪsql,�������ݿ��,�Ȳ�ѯ�Ƿ����������,
	  *             ������,���޸Ĵ˶��������ݿ����Ӧ��һ����¼,��֮,����ö���
	  *             �����ӷ���,����һ������ʵ�����൱�����ݿ��е�һ����¼��
	  *            
	 */
	@Override
	public boolean modify(Student student) {
		boolean flag = false;
		DBUtil dbUtil = new DBUtil();
		String id = student.getStudentId();
		String name = student.getStudentName();
		String sex = student.getStudentSex();
		String birthday = student.getStudentBirthday();
		String tel = student.getStudentTel();
		String address = student.getStudentAddress();
		String date = student.getStudentInDate();
		String memo = student.getStudentMemo();
		String classId = student.getClassId();
		Student student2 = this.findById(id);
		if(student2 != null){
			 
			String  sql = "update student set studentName='"+name+"',studentSex='"+sex+"' , studentBirthday='"+birthday+"',studentTel='"+tel+"',studentAddress='"+address+"',studentInDate='"+date+"',studentMemo='"+memo+"',classId='"+classId+"'"
					+ "where studentId='"+id+"'";
			int n = dbUtil.update(sql);
			if(n>0){
				System.out.println("�޸ĳɹ�");
				flag = true;
			}else {
				System.out.println("�޸�ʧ��");
			}
		}
		else {
			flag = this.add(student);
			flag = true;
		}
		
		dbUtil.close();
		return flag;
	}
}

