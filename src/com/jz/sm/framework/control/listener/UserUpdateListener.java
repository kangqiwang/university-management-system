package com.jz.sm.framework.control.listener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.model.dao.impl.IMisUserDAO;
import com.jz.sm.framework.model.dao.impl.MisUserDAOImp;
import com.jz.sm.framework.model.entity.MisUser;
/**
 * 
* �������
* @author ��ҷ�
* @date 2015��5��2�� ����9:10:51
* @Description  �����޸ĸ�����Ϣ���ܰ�ť,����ť�����,��ʾ�޸���Ϣ���
 */

public class UserUpdateListener implements ActionFunction,ActionListener{
	private JPanel workPanel = null;//�в�����
	private JPanel bodyPanel = null;
	private JPanel northPanel = null;//��������
	private JLabel northLabel = null;//��ʾ�޸ĸ�����Ϣ�ı�ǩ
	
	private JLabel userId = null;//�û��ǳ�
	private JTextField idField = null;
	private JLabel userName = null;//�û�����
	private JTextField nameField = null;
	private JLabel userPwd = null;//����
	private JTextField pwdField = null;
	private JLabel userMemo = null;//�û���ע
	private JTextField memoField = null;
	private JLabel role = null;//Ȩ��
	private JRadioButton guest = null;
	private JRadioButton admin = null;
	private JLabel address = null;
	private JTextField addressIdField = null;
	private MisUser loginUser = null;
	private JButton saveButton = null;//���水ť
	private JButton resetButton = null;//���ð�ť
	private Color whiteColor = null;

	/**
	 * 
	  * ����ע��
	  *@return     ��
	  *@author     ��ҷ�
	  *@Time       2015��5��2������9:15:13
	  *@Description ��һ���в����,��ʾ�й��޸ĸ�����Ϣ�ı�ǩ,��ť��
	 */
	private void init(){
		this.whiteColor = new Color(235, 243, 254);
		this.bodyPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.bodyPanel.setBackground(this.whiteColor);
		this.userId = new JLabel("��    �ƣ�");
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.bodyPanel.add(this.userId,gbc);
		
		this.idField = new JTextField(this.loginUser.getUserId(), 12);
		this.idField.setEditable(false);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.bodyPanel.add(this.idField,gbc);
		
		this.userName = new JLabel("  ��    ����");
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.bodyPanel.add(this.userName,gbc);
		
		this.nameField = new JTextField(12);
		gbc.gridx = 3;
		gbc.gridy = 0;
		this.bodyPanel.add(this.nameField,gbc);
		
		this.userPwd = new JLabel("��    �룺") ;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.bodyPanel.add(this.userPwd,gbc);
		
		this.pwdField = new JTextField(12);
		this.pwdField.addMouseListener(new Adapater(this.loginUser));
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.bodyPanel.add(this.pwdField,gbc);
		
		this.userMemo = new JLabel("  ��    �ܣ�");
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.bodyPanel.add(this.userMemo,gbc);
		
		this.memoField = new JTextField(12);
		gbc.gridx = 3;
		gbc.gridy = 1;
		this.bodyPanel.add(this.memoField,gbc);
		
		this.role = new JLabel("Ȩ    �ޣ�");
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.bodyPanel.add(this.role,gbc);
		
		
		FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);
		JPanel panel1 = new JPanel();
		panel1.setLayout(flowLayout);
		if ("guest".equals(this.loginUser.getRoleId())) {
			this.guest = new JRadioButton("��ͨ�û�",true);
			this.admin = new JRadioButton("��������Ա");
			
		}
		if ("admin".equals(this.loginUser.getRoleId())) {
			this.guest = new JRadioButton("��ͨ�û�");
			this.admin = new JRadioButton("��������Ա",true);
		}
		this.guest.setEnabled(false);
		this.admin.setEnabled(false);
		
		panel1.add(this.guest);
		panel1.add(this.admin);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.bodyPanel.add(panel1,gbc);
		
		FlowLayout flowLayout2 = new FlowLayout(FlowLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(flowLayout2);
		this.saveButton = new JButton("����");
		this.saveButton.addActionListener(this);
		this.resetButton = new JButton("����");
		this.resetButton.addActionListener(this);
		buttonPanel.add(this.saveButton);
		buttonPanel.add(this.resetButton);
		gbc.gridx = 2;
		gbc.gridy = 6;
		this.bodyPanel.add(buttonPanel,gbc);
		
		
	}
	/**
	 * 
	  * ����ע��
	  *@return     ��
	  *@author     ��ҷ�
	  *@Time       2015��5��2������9:18:13
	  *@Description ��һ���������,��ʾһ�������������õı�ǩ��
	 */
	private void createNorthPanel(){
		this.northPanel = new JPanel();
		this.northPanel.setBackground(this.whiteColor);
		this.northLabel = new JLabel("������������");
		this.northPanel.add(this.northLabel);
		
	}
	
	/**
	 * 
	  * ����ע��
	  *@return     ��
	  *@author     ��ҷ�
	  *@Time       2015��5��2������9:19:13
	  *@Description ��ʼ��workPanel��loginUser��Ȼ�����ε���˽�еĻ�����2������
	  *             ���ڵײ�����workPanel��,��ʾ����
	 */
	public void execute(JPanel workPanel,JPanel leftPanel,MisUser loginUser) {
		this.workPanel = workPanel;
		this.loginUser = loginUser;
		this.workPanel.removeAll();
		this.workPanel.repaint();
		this.workPanel.setLayout(new BorderLayout());
		this.init();
		this.createNorthPanel();
		this.workPanel.add(this.bodyPanel,BorderLayout.CENTER);
		this.workPanel.add(this.northPanel,BorderLayout.NORTH);
		
	}
	/**
	 * 
	  * ����ע��
	  *@return ��
	  *@author ��ҷ�
	  *@Time 2015��5��2������8:21:13
	  *@Description  �����水ť�����,��ҳ���ϵ��޸��˵�����,�������ݿ�
	  *            �滻�����û�֮ǰ���ֶ�ֵ
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String  name = this.nameField.getText();
		String  memo = this.memoField.getText();
		
		if (e.getSource() == this.saveButton) {
			if (name != null && memo != null) {
				
				if (name.length() > 0 && memo.length() > 0) {
					MisUser temp  = new MisUser();
					temp = this.loginUser;
					temp.setUserName(name);
					temp.setUserName(memo);
					IMisUserDAO misUserDAO = new MisUserDAOImp();
					misUserDAO.modify(temp);
					
				}else {
					JOptionPane.showMessageDialog(null, "��Ϣ��Ϊ��");
					
					return;
				}
				
		    }else {
			     return;
		    }
			
		}
		if (e.getSource() == this.resetButton) {
			this.nameField.setText("");
			this.memoField.setText("");
			
			
		}
	}
    
	
}
