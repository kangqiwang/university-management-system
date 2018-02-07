package com.jz.sm.framework.control.action.school;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.model.entity.MisUser;


/**
 * 
* �������
* @author ��ҷ�
* @date 2015��5��2�� ����8:19:51
* @Description  ����һ���࣬���̳��߳�thread
 */
public class sceneryTread extends Thread{
	
	//��������
	private JPanel workPanel = null;
	private JPanel centerPanel = null;
	private JPanel southPanel = null; 
	
	//��дrun����������
	@Override
	public void run() {
		
		File file = new File("./scenery"); //�����ļ��࣬����scenery�ļ���
    	File[] imgFiles = file.listFiles();
    	//�����ļ����е�ͼƬ������sleepʱ�䣬��̬����ͼƬ
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
	//��Ҫ������panel�õ�������workpanel
	public sceneryTread(JPanel workPanel) {
		this.workPanel = workPanel;
		this.workPanel.removeAll();
		this.workPanel.repaint();
		this.workPanel.setLayout(new BorderLayout());
	}
		
	
}
