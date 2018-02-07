package com.jz.sm.framework.control.action.enroll;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
  * �������
  *@return void 	
  *@Description  ��Ҫ�����Ĺ������䣬��̬����һ��ͼƬ·����ʹͼƬ�ܳ�������Ƭ���������ϡ�
 */
public class WelcomePanel extends JPanel {


	private ImageIcon imageIcon = null;
	
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@Description  �ṩһ������ͼƬ����
	 */
	public WelcomePanel(String path) {
		this.imageIcon = new ImageIcon(path);
		
	}
	
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��5��15������3:29:13
	  *@Description  ��һ��������˵��ͼƬ��������Ҫ���������λ�á�
	 */
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(this.imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
		
	}
}
