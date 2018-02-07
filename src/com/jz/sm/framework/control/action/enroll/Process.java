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
  * �������
  *@return void 	
  *@Description  ʵ�ָ���Ҫ�����Ĺ����������ͼƬ
 */

public class Process implements ActionFunction , ActionListener{
	//����˽������
	private JPanel workPanel = null;
	private JPanel bodyPanel = null;

	
	/**
	 * 
	  * ��������
	  *@return void 	
	  *@Description  ͨ�������������welcomePanel����࣬���������һ��ͼƬ·��
	 */
	private void createBodyPanel() {
		//����ͼƬ·��
		this.bodyPanel = new WelcomePanel("img/wel.jpg");
	}
	
	/**
	 * 
	  * ��������
	  *@return void 	
	  *@Description  ʵ��actionfuntion������execute��������Ҫ������workPanel��������������ͼƬ·�������������ڹ��������ĳ��λ�á�
	 */
	
	@Override
	public void execute(JPanel workPanel,JPanel leftPanel, MisUser loginUser) {
		//�ڲ���֮ǰ���Ȱ�ҳ�����
		workPanel.removeAll();
		workPanel.repaint();
		//��Ҫ�����Ĺ������䴫���������������ò���
		this.workPanel = workPanel;
		this.workPanel.setLayout(new BorderLayout());
		//�����������������ͼƬ·��
		this.createBodyPanel();
		//��bodyPanel�ӵ����������ϣ�����������ҳ��λ�á�
		this.workPanel.add(this.bodyPanel,BorderLayout.CENTER);

	}

	
	/**
	 * 
	  * ��������
	  *@return void 	
	  *@Description  ʵ��actiionlistener�ļ���������
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
