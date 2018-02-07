package com.jz.sm.action.system;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.control.action.org.ColorSet;
import com.jz.sm.framework.model.dao.impl.IMisUserDAO;
import com.jz.sm.framework.model.dao.impl.MisUserDAOImp;
import com.jz.sm.framework.model.entity.MisUser;

/**
 * 
* �������
* @Description  ��ϵͳ���õ��Ӳ˵�������Ϣ�޸Ĺ��ܰ�ť�����,��ť�ұߵ����������صĲ�������
 */
public class UserCreateAction implements ActionFunction,ActionListener{

	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	private JLabel titleLabel = null;
	private JLabel userIdLable = null;
	private JTextField userIdField = null;
	private JLabel userNameLable = null;
	private JTextField userNameField = null;
	private JLabel passwordLable = null;
	private JPasswordField passwordField = null;
	private JLabel memoLable = null;
	private JTextArea memoArea = null;
	private JLabel addressLable = null;
	private JTextField addressField = null;
	private JButton addButton = null;
	private JButton clearButton = null;
	private JTextArea helpTextArea = null;
	
	/**
	 * 
	  * ����ע��
	  *@return ��
	  *@Description ��bodyPanel�������ʾ�޸ĸ�����Ϣ�������������
	 */
	private void createBodyPanel() {
		ColorSet colorSet = new ColorSet();
		this.bodyPanel = new JPanel();
		this.bodyPanel.setLayout(new GridBagLayout());
		this.bodyPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.titleLabel = new JLabel("���һ����ͨ�û�");
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.bodyPanel.add(this.titleLabel,gbc);
		
		this.userIdLable = new JLabel("�û���ţ�");
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.bodyPanel.add(this.userIdLable,gbc);
		
		this.userIdField = new JTextField(40);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.bodyPanel.add(this.userIdField,gbc);
		
		this.userNameLable = new JLabel("�û�������");
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.bodyPanel.add(this.userNameLable,gbc);
		
		this.userNameField = new JTextField(40);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.bodyPanel.add(this.userNameField,gbc);
		
		this.passwordLable = new JLabel("��        �룺");
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.bodyPanel.add(this.passwordLable,gbc);
		
		this.passwordField = new JPasswordField(40);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.bodyPanel.add(this.passwordField,gbc);
		
		this.memoLable = new JLabel("�û�������");
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.bodyPanel.add(this.memoLable,gbc);
		
		this.memoArea = new JTextArea(5, 40);
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.bodyPanel.add(this.memoArea,gbc);
		
		this.addressLable = new JLabel("��ַ���ţ�");
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.bodyPanel.add(this.addressLable,gbc);
		
		this.addressField = new JTextField(40);
		gbc.gridx = 1;
		gbc.gridy = 5;
		this.bodyPanel.add(this.addressField,gbc);
		
		JPanel buttonPanel = new JPanel();
		this.addButton = new JButton("����");
		this.addButton.addActionListener(this);
		this.clearButton = new JButton("���");
		this.clearButton.addActionListener(this);
		buttonPanel.add(this.addButton);
		buttonPanel.add(this.clearButton);
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.bodyPanel.add(buttonPanel,gbc);
		
		this.contentTabbedPane.add("�����û�",this.bodyPanel);
	}
	/**
	 * 
	  * ����ע��
	  *@return ��
	  *@Description  ��helpPanel�����ʾ�ı���
	 */
	private void createHelpPanel() {
		ColorSet colorSet = new ColorSet();
		this.helpPanel = new JPanel();
		this.helpPanel.setLayout(new GridBagLayout());
		this.helpPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.helpTextArea = new JTextArea(10, 30);
		this.helpTextArea.setText("�����û��У�ֻ�г�������Ա����������ͨ�û���Ȩ��,��ֻ�������ͨ�û��������û���ţ��û��������û����������Ϊ�ա�");
		this.helpTextArea.setEditable(false);
		//���壬����ֺ�
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);//����TextArea�е��ı��Զ�����
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("�����û�����",this.helpPanel);
	}
	/**
	 * 
	  * ����ע��
	  *@Description  �ѱ�ǩ���ӵ�workPanel��
	 */
	@Override
	public void execute(JPanel workPanel,JPanel leftPanel,MisUser loginUser) {
		this.workPanel = workPanel;
		this.workPanel.setLayout(new BorderLayout());
		this.contentTabbedPane = new JTabbedPane();
		this.createBodyPanel();
		this.createHelpPanel();
		this.workPanel.add(this.contentTabbedPane,BorderLayout.CENTER);
	}
	/**
	 * 
	* ��������������
	* @Description  ��������û��ұߵĽ����ϵ����Ӱ�ť�����,���ڴ�����û��޸ĺ������,
	*             תΪOrgTypeʵ��,����dao�����浽���ݿ�orgType���У���֮,���
	*             ��հ�ť���������ҳ��Ὣ�ص�����ǰ��״̬
		*             
	* 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.addButton) {
			String id = this.userIdField.getText();
			String name = this.userNameField.getText();
			String password = new String (this.passwordField.getPassword());
			String memo = this.memoArea.getText();
			String address = this.addressField.getText();
			if(id != null && id.length() > 0 && name != null && name.length() > 0 && password != null && password.length() > 0) {
				IMisUserDAO misUserDAO = new MisUserDAOImp();
				MisUser misUser = new MisUser(id, name, password, memo, "guess", address, "");
				boolean flag = misUserDAO.add(misUser);
				if(flag) {
					JOptionPane.showMessageDialog(null, "�����û��ɹ�");
				} else {
					JOptionPane.showMessageDialog(null, "�����û�ʧ��");
				}
			} else {
				JOptionPane.showMessageDialog(null, "�û���ţ����������벻��Ϊ��");
			}
		} else if(e.getSource() == this.clearButton) {
			this.userIdField.setText("");
			this.userNameField.setText("");
			this.passwordField.setText("");
			this.memoArea.setText("");
			this.addressField.setText("");
		}
	}
}
