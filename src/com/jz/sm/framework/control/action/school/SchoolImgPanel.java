package com.jz.sm.framework.control.action.school;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
* �������
* @author ���ʵ�
* @date 2015��4��28�� ����15:38:11
* @Description  ����������ӱ���ͼƬ
 */
public class SchoolImgPanel extends JPanel{
	private ImageIcon imageIcon = null;
	
	public SchoolImgPanel(String path){
		this.imageIcon = new ImageIcon(path);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(this.imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	
}
