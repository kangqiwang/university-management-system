package com.jz.sm.framework.model.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
* 类的描述
* @author 王攀登 
* @date 2015年5月16日 上午12:16:48
* @Description  从一个sql.txt文件中读取里面的java连接sqlserver的相关驱动
*              类名，数据库名，用户名，密码，放进字符串数组中
 */
public class SqlRead {
	
	/**
	 * 
	  * 方法注释
	  *@return String[] 	
	  *@author王攀登
	  *@Time 2015年5月16日上午12:22:00
	  *@Description  用字符流读取数据库配置数据库的相关信息
	 */
	public static String [] init() {
		BufferedReader reader = null;
		String [] s=new String [4];
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("./sql.txt")));
			String info = null;
			//缓冲流一行一行读
			for (int i = 0; i < 4; i++) {
				info = reader.readLine();
				s[i] = info;
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		finally{//关闭字符流资源对象
			
			try{
				if (reader != null) {
					reader.close();
					reader = null;
				}
			} catch (IOException e) {
				
			}
		}
		return s;
	}
	
}
