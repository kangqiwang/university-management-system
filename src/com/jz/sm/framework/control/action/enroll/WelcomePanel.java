package com.jz.sm.framework.control.action.enroll;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
  * 类的描述
  *@return void 	
  *@Description  在要操作的工作区间，动态加载一个图片路径，使图片能呈现在这片工作区间上。
 */
public class WelcomePanel extends JPanel {


	private ImageIcon imageIcon = null;
	
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@Description  提供一个加载图片方法
	 */
	public WelcomePanel(String path) {
		this.imageIcon = new ImageIcon(path);
		
	}
	
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年5月15日下午3:29:13
	  *@Description  给一个方法，说明图片呈现在所要操作区间的位置。
	 */
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(this.imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
		
	}
}
