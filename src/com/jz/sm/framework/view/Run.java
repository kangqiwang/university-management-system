package com.jz.sm.framework.view;

/**
* 类的描述
* @author 易海门 
* @date 2015年4月27日 下午3:10:17
* @Description  该系统运行的入口,主类
 */
public class Run {
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 易海门
	  *@Time 2015年4月27日下午3:10:58
	  *@Description 主函数
	 */
	public static void main(String[] args) {
		//让登陆框出现在屏幕中央
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setResizable(false);
		CommonUse.setComponentBounts(loginFrame, 500, 350);
		loginFrame.setSize(500, 350);
		loginFrame.setVisible(true);
	}

}
