package com.jz.sm.framework.control.action.enroll;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

import javax.swing.JPanel;

import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.model.entity.MisUser;

/**
 * 
  * 类的描述
  *@return void 	
  *@Description  实现给所要操作的工作区间添加图片
 */

public class Process implements ActionFunction , ActionListener{
	//对象私有声明
	private JPanel workPanel = null;
	private JPanel bodyPanel = null;

	
	/**
	 * 
	  * 方法描述
	  *@return void 	
	  *@Description  通过这个方法调用welcomePanel这个类，并给这个类一个图片路径
	 */
	private void createBodyPanel() {
		//加载图片路径
		this.bodyPanel = new WelcomePanel("img/wel.jpg");
	}
	
	/**
	 * 
	  * 方法描述
	  *@return void 	
	  *@Description  实现actionfuntion这个类的execute方法，把要操作的workPanel传过来，并加载图片路径，让它出现在工作区间的某个位置。
	 */
	
	@Override
	public void execute(JPanel workPanel,JPanel leftPanel, MisUser loginUser) {
		//在操作之前，先把页面清空
		workPanel.removeAll();
		workPanel.repaint();
		//把要操作的工作区间传过来，并给他设置布局
		this.workPanel = workPanel;
		this.workPanel.setLayout(new BorderLayout());
		//调用这个方法，加载图片路径
		this.createBodyPanel();
		//将bodyPanel加到操作区间上，并设置所在页面位置。
		this.workPanel.add(this.bodyPanel,BorderLayout.CENTER);

	}

	
	/**
	 * 
	  * 方法描述
	  *@return void 	
	  *@Description  实现actiionlistener的监听方法。
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
