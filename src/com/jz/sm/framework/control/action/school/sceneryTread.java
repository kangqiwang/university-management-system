package com.jz.sm.framework.control.action.school;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.model.entity.MisUser;


/**
 * 
* 类的描述
* @author 田芬芬
* @date 2015年5月2日 上午8:19:51
* @Description  创建一个类，并继承线程thread
 */
public class sceneryTread extends Thread{
	
	//声明对象
	private JPanel workPanel = null;
	private JPanel centerPanel = null;
	private JPanel southPanel = null; 
	
	//重写run（）方法。
	@Override
	public void run() {
		
		File file = new File("./scenery"); //声明文件类，加载scenery文件夹
    	File[] imgFiles = file.listFiles();
    	//遍历文件夹中的图片，设置sleep时间，动态遍历图片
    	while(true){
    		for(int i = 0; i < imgFiles.length; i++) {
    		
    		    this.centerPanel = new SchoolImgPanel(imgFiles[i].getPath()) ;
    		    this.workPanel.add(this.centerPanel,BorderLayout.CENTER);
    		    try {
				     sceneryTread.sleep(20);
			    } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
    		    this.centerPanel.removeAll();
    		}
    	}
		
		
	}
	private void init(){
		
	}
	//将要操作的panel拿到，交给workpanel
	public sceneryTread(JPanel workPanel) {
		this.workPanel = workPanel;
		this.workPanel.removeAll();
		this.workPanel.repaint();
		this.workPanel.setLayout(new BorderLayout());
	}
		
	
}
