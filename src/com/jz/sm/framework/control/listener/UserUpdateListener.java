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
* 类的描述
* @author 田芬芬
* @date 2015年5月2日 上午9:10:51
* @Description  监听修改个人信息功能按钮,当按钮被点击,显示修改信息面板
 */

public class UserUpdateListener implements ActionFunction,ActionListener{
	private JPanel workPanel = null;//中部区域
	private JPanel bodyPanel = null;
	private JPanel northPanel = null;//北部区域
	private JLabel northLabel = null;//显示修改个人信息的标签
	
	private JLabel userId = null;//用户昵称
	private JTextField idField = null;
	private JLabel userName = null;//用户姓名
	private JTextField nameField = null;
	private JLabel userPwd = null;//密码
	private JTextField pwdField = null;
	private JLabel userMemo = null;//用户备注
	private JTextField memoField = null;
	private JLabel role = null;//权限
	private JRadioButton guest = null;
	private JRadioButton admin = null;
	private JLabel address = null;
	private JTextField addressIdField = null;
	private MisUser loginUser = null;
	private JButton saveButton = null;//保存按钮
	private JButton resetButton = null;//重置按钮
	private Color whiteColor = null;

	/**
	 * 
	  * 方法注释
	  *@return     无
	  *@author     田芬芬
	  *@Time       2015年5月2日上午9:15:13
	  *@Description 画一个中部面板,显示有关修改个人信息的标签,按钮。
	 */
	private void init(){
		this.whiteColor = new Color(235, 243, 254);
		this.bodyPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.bodyPanel.setBackground(this.whiteColor);
		this.userId = new JLabel("昵    称：");
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.bodyPanel.add(this.userId,gbc);
		
		this.idField = new JTextField(this.loginUser.getUserId(), 12);
		this.idField.setEditable(false);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.bodyPanel.add(this.idField,gbc);
		
		this.userName = new JLabel("  姓    名：");
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.bodyPanel.add(this.userName,gbc);
		
		this.nameField = new JTextField(12);
		gbc.gridx = 3;
		gbc.gridy = 0;
		this.bodyPanel.add(this.nameField,gbc);
		
		this.userPwd = new JLabel("密    码：") ;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.bodyPanel.add(this.userPwd,gbc);
		
		this.pwdField = new JTextField(12);
		this.pwdField.addMouseListener(new Adapater(this.loginUser));
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.bodyPanel.add(this.pwdField,gbc);
		
		this.userMemo = new JLabel("  介    绍：");
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.bodyPanel.add(this.userMemo,gbc);
		
		this.memoField = new JTextField(12);
		gbc.gridx = 3;
		gbc.gridy = 1;
		this.bodyPanel.add(this.memoField,gbc);
		
		this.role = new JLabel("权    限：");
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.bodyPanel.add(this.role,gbc);
		
		
		FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);
		JPanel panel1 = new JPanel();
		panel1.setLayout(flowLayout);
		if ("guest".equals(this.loginUser.getRoleId())) {
			this.guest = new JRadioButton("普通用户",true);
			this.admin = new JRadioButton("超级管理员");
			
		}
		if ("admin".equals(this.loginUser.getRoleId())) {
			this.guest = new JRadioButton("普通用户");
			this.admin = new JRadioButton("超级管理员",true);
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
		this.saveButton = new JButton("保存");
		this.saveButton.addActionListener(this);
		this.resetButton = new JButton("重置");
		this.resetButton.addActionListener(this);
		buttonPanel.add(this.saveButton);
		buttonPanel.add(this.resetButton);
		gbc.gridx = 2;
		gbc.gridy = 6;
		this.bodyPanel.add(buttonPanel,gbc);
		
		
	}
	/**
	 * 
	  * 方法注释
	  *@return     无
	  *@author     田芬芬
	  *@Time       2015年5月2日上午9:18:13
	  *@Description 画一个北部面板,显示一个个人资料设置的标签。
	 */
	private void createNorthPanel(){
		this.northPanel = new JPanel();
		this.northPanel.setBackground(this.whiteColor);
		this.northLabel = new JLabel("个人资料设置");
		this.northPanel.add(this.northLabel);
		
	}
	
	/**
	 * 
	  * 方法注释
	  *@return     无
	  *@author     田芬芬
	  *@Time       2015年5月2日上午9:19:13
	  *@Description 初始化workPanel和loginUser，然后依次调用私有的画面板的2个方法
	  *             加在底层容器workPanel上,显示出来
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
	  * 方法注释
	  *@return 无
	  *@author 田芬芬
	  *@Time 2015年5月2日上午8:21:13
	  *@Description  当保存按钮被点击,将页面上的修改了的数据,传到数据库
	  *            替换掉该用户之前的字段值
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
					JOptionPane.showMessageDialog(null, "信息不为空");
					
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
