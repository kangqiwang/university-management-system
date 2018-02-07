package com.jz.sm.framework.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
* 类的描述
* @author 王攀登
* @date 2015年4月28日 下午15:42:11
* @Description  向容器上添加背景图片
 */
public class ImgBriefPanel extends JPanel{
	private ImageIcon imageIcon = null;
	
	public ImgBriefPanel(){
		this.imageIcon = new ImageIcon("img/brief.jpg");
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(this.imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	
}
