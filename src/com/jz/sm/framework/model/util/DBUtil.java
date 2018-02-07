package com.jz.sm.framework.model.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * 
* 类的描述
* @author 王攀登
* @date 2015年4月19日 上午9:36:39
* @Description  DBUtil是数据库工具类，封装jdbc对象
 */
public class DBUtil {
	
	private  Connection conn=null;//数据库连接对象
	private Statement  sta=null;  //数据库执行对象
	private  ResultSet rs=null;	  //结果集对象
	
	/**
	 * 
	 * 方法注释
	 *@return Connection 	
	 *@exception 类加载异常 和sql异常
	 *@author 王攀登
	 *@Time 2015年4月19日上午9:52:39
	 *@Description 私有的java连接sqlserver数据库的方法
	 */
	private  Connection getConnection(){
		Connection myconn=null;
		
		try {
			String [] temp = SqlRead.init();
			String driverClass = temp[0];
			String connectionUrl = temp[1];
			String dbUser = temp[2];
			String dbPassword = temp[3];
			//加载连接sqlserver所需的驱动类
			Class.forName(driverClass);
			//得到连接
			myconn = DriverManager.getConnection(connectionUrl, dbUser, dbPassword);				
			
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return myconn;
	}
	
	/**
	 *@author 王攀登
	 *@Time 2015年4月19日上午9:52:39
	 *@Description:调用getConnection()方法后，得到的Connection对象
	 *               通过循环将得到Connection对象加到集合对象list中
	 */
	public DBUtil(){
		
		this.conn = this.getConnection();
	}
	/**
	  * 方法注释
	  *@return int 	
	  *@exception  sql异常
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:04:06
	  *@Description 公有的java更新数据库的方法,可以通过改变字符串类型变量sql的不同值
	  *             对数据库进行增加,删除,修改
	 */
	public int update (String sql){
		int n = -1;
		try {
			//3.创建数据库执行对象
			this.sta = this.conn.createStatement();
			//调用statement的实例方法
			n = this.sta.executeUpdate(sql);
			if (n>0) {
				System.out.println("更新了"+n+"条记录");
			}else {
				System.err.println("没有更新记录");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;//返回0,没修改
	}
	/**
	 * 
	  * 方法注释
	  *@return ResultSet 	
	  *@exception 可能发生sql异常
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:16:10
	  *@Description 公有的对数据库进行查询的方法
	 */
	public ResultSet query(String sql){
		try {
			//再调用connection 的实例方法
			 this.sta = this.conn.createStatement();
			 this.rs = this.sta.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.rs;
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@exception  sql异常
	  *@author 王攀登
	  *@Time 2015年4月19日上午10:17:52
	  *@Description 关闭java连接，操作数据库相关的资源
	 */
	public void close(){
		//this.conn=this.list.get(2);
		try {
			//从小到大关闭对象
			if(this.rs != null){
				rs.close();
				rs = null;
			}
			if(this.sta!=null){
				sta.close();
				sta = null;
			}
			if(this.conn!=null){
				conn.close();
				conn = null;
			}
		 } catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
