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
* 类的描述
* @Description  当系统设置的子菜单个人信息修改功能按钮被点击,按钮右边的面板会出现相关的操作界面
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
	  * 方法注释
	  *@return 无
	  *@Description 在bodyPanel面板上显示修改个人信息的所需的相关组件
	 */
	private void createBodyPanel() {
		ColorSet colorSet = new ColorSet();
		this.bodyPanel = new JPanel();
		this.bodyPanel.setLayout(new GridBagLayout());
		this.bodyPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.titleLabel = new JLabel("添加一个普通用户");
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.bodyPanel.add(this.titleLabel,gbc);
		
		this.userIdLable = new JLabel("用户编号：");
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.bodyPanel.add(this.userIdLable,gbc);
		
		this.userIdField = new JTextField(40);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.bodyPanel.add(this.userIdField,gbc);
		
		this.userNameLable = new JLabel("用户姓名：");
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.bodyPanel.add(this.userNameLable,gbc);
		
		this.userNameField = new JTextField(40);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.bodyPanel.add(this.userNameField,gbc);
		
		this.passwordLable = new JLabel("密        码：");
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.bodyPanel.add(this.passwordLable,gbc);
		
		this.passwordField = new JPasswordField(40);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.bodyPanel.add(this.passwordField,gbc);
		
		this.memoLable = new JLabel("用户描述：");
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.bodyPanel.add(this.memoLable,gbc);
		
		this.memoArea = new JTextArea(5, 40);
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.bodyPanel.add(this.memoArea,gbc);
		
		this.addressLable = new JLabel("地址代号：");
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.bodyPanel.add(this.addressLable,gbc);
		
		this.addressField = new JTextField(40);
		gbc.gridx = 1;
		gbc.gridy = 5;
		this.bodyPanel.add(this.addressField,gbc);
		
		JPanel buttonPanel = new JPanel();
		this.addButton = new JButton("增加");
		this.addButton.addActionListener(this);
		this.clearButton = new JButton("清空");
		this.clearButton.addActionListener(this);
		buttonPanel.add(this.addButton);
		buttonPanel.add(this.clearButton);
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.bodyPanel.add(buttonPanel,gbc);
		
		this.contentTabbedPane.add("增加用户",this.bodyPanel);
	}
	/**
	 * 
	  * 方法注释
	  *@return 无
	  *@Description  在helpPanel面板显示文本域
	 */
	private void createHelpPanel() {
		ColorSet colorSet = new ColorSet();
		this.helpPanel = new JPanel();
		this.helpPanel.setLayout(new GridBagLayout());
		this.helpPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.helpTextArea = new JTextArea(10, 30);
		this.helpTextArea.setText("增加用户中：只有超级管理员可以增加普通用户的权限,即只能添加普通用户，其中用户编号，用户姓名和用户密码均不能为空。");
		this.helpTextArea.setEditable(false);
		//字体，风格，字号
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);//设置TextArea中的文本自动换行
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("增加用户帮助",this.helpPanel);
	}
	/**
	 * 
	  * 方法注释
	  *@Description  把标签面板加到workPanel上
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
	* 监听方法的描述
	* @Description  如果增加用户右边的界面上的增加按钮被点击,将在此面板用户修改后的数据,
	*             转为OrgType实例,传到dao，最后存到数据库orgType表中；反之,如果
	*             清空按钮被点击，则页面会将回到增加前的状态
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
					JOptionPane.showMessageDialog(null, "增加用户成功");
				} else {
					JOptionPane.showMessageDialog(null, "增加用户失败");
				}
			} else {
				JOptionPane.showMessageDialog(null, "用户编号，姓名或密码不能为空");
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
