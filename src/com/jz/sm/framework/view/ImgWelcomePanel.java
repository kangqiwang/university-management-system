package com.jz.sm.framework.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
* �������
* @author ���ʵ�
* @date 2015��4��28�� ����15:35:11
* @Description  ����������ӱ���ͼƬ
 */

public class ImgWelcomePanel extends JPanel{
	private ImageIcon imageIcon = null;
	
	public ImgWelcomePanel(){
		this.imageIcon = new ImageIcon("img/welcome.jpg");
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(this.imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	
}
