package com.jz.sm.framework.control.action.school;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
* 类的描述
* @author 王攀登
* @date 2015年4月28日 下午15:38:11
* @Description  向容器上添加背景图片
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
