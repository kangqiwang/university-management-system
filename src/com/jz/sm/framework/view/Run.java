package com.jz.sm.framework.view;

/**
* �������
* @author �׺��� 
* @date 2015��4��27�� ����3:10:17
* @Description  ��ϵͳ���е����,����
 */
public class Run {
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author �׺���
	  *@Time 2015��4��27������3:10:58
	  *@Description ������
	 */
	public static void main(String[] args) {
		//�õ�½���������Ļ����
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setResizable(false);
		CommonUse.setComponentBounts(loginFrame, 500, 350);
		loginFrame.setSize(500, 350);
		loginFrame.setVisible(true);
	}

}
