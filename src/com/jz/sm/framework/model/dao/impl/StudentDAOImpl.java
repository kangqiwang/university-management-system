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
	  * 方法注释
	  *@return List<Student> 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:12:03
	  *@Description   先得到要查询对象的所有属性值,然后转为sql语句,调用数据层的查询方法,
	  *             会返回查询数据库中的多条记录,将返回的记录转为多个orgType实例,存到集合中
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
		finally{//关闭资源
			dbUtil.close();
		}
		
		
		return list;
	}
	
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:02:03
	  *@Description 将studentId转为sql,传到数据库层,先查询是否有这个对象,若果有,则删除此对象,没有就返回
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
				System.out.println("删除了");
				flag = true;
			}else {
				System.out.println("删除失败");
			}
			
			
		} else {
			System.out.println("没有编号为"+id+"的这个人");
			
		}
		dbUtil.close();
		return flag;
	}
	
	/**
	 * 
	  * 方法注释
	  *@return OrgType 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:10:20
	  *@Description 通过studentId属性转为sql语句,调用数据层的方法,查询数据库中的一条记录,
	  *				将返回的记录转为student对象
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
			
			System.out.println("没有编号为"+studentId+"的这个人");
		}
		return student;
	}
	
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:01:10
	  *@Description 将Student对象的一个实例转为sql传到数据层，加到数据库中,
	  *             如果返回为真,添加成功,反之,失败
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
			//局部字符串变量
			String sql="insert into  student (studentId,studentName,studentSex,studentBirthday,studentTel,studentAddress,studentInDate,studentMemo,classId)"
					+ "values('"+id+"','"+name+"','"+sex+"','"+birthday+"','"+tel+"','"+address+"','"+date+"','"+memo+"','"+classId+"')";
			//向下操作数据库
			System.out.println(sql);
			DBUtil dbUtil=new DBUtil();
			n = dbUtil.update(sql);
			if(n > 0) {
				flag = true;
			}
		}else {
			System.out.println("数据库已有此记录");
		}
		return flag;
	}
	
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:04:03
	  *@Description 将Student对象实例转为sql,传到数据库层,先查询是否有这个对象,
	  *             若果有,则修改此对象与数据库相对应的一条记录,反之,则调用对象化
	  *             的增加方法,增加一个对象实例（相当于数据库中的一条记录）
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
				System.out.println("修改成功");
				flag = true;
			}else {
				System.out.println("修改失败");
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

