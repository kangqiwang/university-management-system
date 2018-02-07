package com.jz.sm.framework.model.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * 
* �������
* @author ���ʵ�
* @date 2015��4��19�� ����9:36:39
* @Description  DBUtil�����ݿ⹤���࣬��װjdbc����
 */
public class DBUtil {
	
	private  Connection conn=null;//���ݿ����Ӷ���
	private Statement  sta=null;  //���ݿ�ִ�ж���
	private  ResultSet rs=null;	  //���������
	
	/**
	 * 
	 * ����ע��
	 *@return Connection 	
	 *@exception ������쳣 ��sql�쳣
	 *@author ���ʵ�
	 *@Time 2015��4��19������9:52:39
	 *@Description ˽�е�java����sqlserver���ݿ�ķ���
	 */
	private  Connection getConnection(){
		Connection myconn=null;
		
		try {
			String [] temp = SqlRead.init();
			String driverClass = temp[0];
			String connectionUrl = temp[1];
			String dbUser = temp[2];
			String dbPassword = temp[3];
			//��������sqlserver�����������
			Class.forName(driverClass);
			//�õ�����
			myconn = DriverManager.getConnection(connectionUrl, dbUser, dbPassword);				
			
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return myconn;
	}
	
	/**
	 *@author ���ʵ�
	 *@Time 2015��4��19������9:52:39
	 *@Description:����getConnection()�����󣬵õ���Connection����
	 *               ͨ��ѭ�����õ�Connection����ӵ����϶���list��
	 */
	public DBUtil(){
		
		this.conn = this.getConnection();
	}
	/**
	  * ����ע��
	  *@return int 	
	  *@exception  sql�쳣
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:04:06
	  *@Description ���е�java�������ݿ�ķ���,����ͨ���ı��ַ������ͱ���sql�Ĳ�ֵͬ
	  *             �����ݿ��������,ɾ��,�޸�
	 */
	public int update (String sql){
		int n = -1;
		try {
			//3.�������ݿ�ִ�ж���
			this.sta = this.conn.createStatement();
			//����statement��ʵ������
			n = this.sta.executeUpdate(sql);
			if (n>0) {
				System.out.println("������"+n+"����¼");
			}else {
				System.err.println("û�и��¼�¼");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;//����0,û�޸�
	}
	/**
	 * 
	  * ����ע��
	  *@return ResultSet 	
	  *@exception ���ܷ���sql�쳣
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:16:10
	  *@Description ���еĶ����ݿ���в�ѯ�ķ���
	 */
	public ResultSet query(String sql){
		try {
			//�ٵ���connection ��ʵ������
			 this.sta = this.conn.createStatement();
			 this.rs = this.sta.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.rs;
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@exception  sql�쳣
	  *@author ���ʵ�
	  *@Time 2015��4��19������10:17:52
	  *@Description �ر�java���ӣ��������ݿ���ص���Դ
	 */
	public void close(){
		//this.conn=this.list.get(2);
		try {
			//��С����رն���
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
