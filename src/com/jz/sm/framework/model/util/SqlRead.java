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
* �������
* @author ���ʵ� 
* @date 2015��5��16�� ����12:16:48
* @Description  ��һ��sql.txt�ļ��ж�ȡ�����java����sqlserver���������
*              ���������ݿ������û��������룬�Ž��ַ���������
 */
public class SqlRead {
	
	/**
	 * 
	  * ����ע��
	  *@return String[] 	
	  *@author���ʵ�
	  *@Time 2015��5��16������12:22:00
	  *@Description  ���ַ�����ȡ���ݿ��������ݿ�������Ϣ
	 */
	public static String [] init() {
		BufferedReader reader = null;
		String [] s=new String [4];
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("./sql.txt")));
			String info = null;
			//������һ��һ�ж�
			for (int i = 0; i < 4; i++) {
				info = reader.readLine();
				s[i] = info;
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		finally{//�ر��ַ�����Դ����
			
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
