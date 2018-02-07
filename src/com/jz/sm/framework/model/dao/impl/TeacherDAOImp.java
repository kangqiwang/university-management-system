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
* 类的描述
* @author 王攀登
* @date 2015年4月21日 上午11:10:03
* @Description  TeacherDAOImp实现了 ITeacherDAO接口,实现了所有的抽象方法
 */
public class TeacherDAOImp implements ITeacherDAO{
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:01:10
	  *@Description 将Teacher对象的一个实例转为sql传到数据层，加到数据库中,
	  *             如果返回为真,添加成功,反之,失败
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
	  * 方法注释
	  *@return List<OrgType> 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:12:03
	  *@Description   先得到要查询对象的所有属性值,然后转为sql语句,调用数据层的查询方法,
	  *             会返回查询数据库中的多条记录,将返回的记录转为多个Teacher实例,存到集合中
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
	  *@Description 将id转为sql,传到数据库层,先查询是否有这个对象,若果有,则删除此对象,没有就返回
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
	  *@return boolean 	
	  *@author 王攀登
	  * @date 2015年4月22日 上午11:04:03
	  *@Description 将Teacher对象实例转为sql,传到数据库层,先查询是否有这个对象,
	  *             若果有,则修改此对象与数据库相对应的一条记录,反之,则调用对象化
	  *             的增加方法,增加一个对象实例（相当于数据库中的一条记录）
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
				System.out.println("修改成功");
				flag = true;
			}else {
				System.out.println("修改失败");
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
