package com.jz.sm.framework.control.action.enroll;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
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
import com.jz.sm.framework.model.dao.impl.IStudentDAO;
import com.jz.sm.framework.model.dao.impl.StudentDAOImpl;
import com.jz.sm.framework.model.dao.impl.MisUserDAOImp;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.Student;

/**
 * 
  * 类的描述
  *@return void 	
  *@Description  定义一个NetEnroll类，并实现ActionFunction,ActionListener接口。
 */
public class NetEnroll implements ActionFunction,ActionListener{
	//声明对象
	private JPanel workPanel = null;
	private JPanel bodyPanel = null;
	private JPanel centerPanel = null;
	private JPanel bottomPanel = null;
	
	private JLabel titleLabel = null;
	private JLabel userIdLable = null;
	private JTextField userIdField = null;
	private JLabel userNameLable = null;
	private JTextField userNameField = null;
	private JLabel sexLable = null;
	private JTextField sexField = null;
	private JLabel timeLable = null;
	private JTextField timeField = null;
	private JLabel telLable = null;
	private JTextField telField = null;
	private JLabel addressLable = null;
	private JTextField addressField = null;
	private JLabel dateLable = null;
	private JTextField dateField = null;
	private JLabel memoLable = null;
	private JTextField memoField = null;
	private JLabel classIdLable = null;
	private JTextField classIdField = null;
	
	private JButton bottomButton = null;
	private JButton addButton = null;

	/**
	 * 
	  * 方法描述
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年5月15日下午3:29:13
	  *@Description  定义一个createBodyPanel()方法，画页面。
	 */
	private void createBodyPanel() {
		//设置panel颜色
		ColorSet colorSet=new ColorSet();
		//创建一个panel
		this.bodyPanel = new JPanel();
		//设置panel布局
		this.bodyPanel.setLayout(new BorderLayout());
		//设置panel背景颜色
		this.bodyPanel.setBackground(colorSet.getWhite());
		//创建一个panel
		this.centerPanel = new  JPanel();
		//把这个panel加在bodypanel上，并设置页面位置。
		this.bodyPanel.add(this.centerPanel,BorderLayout.CENTER);
		
		//创建一个新生注册标签，并设置位置，大小。
		this.titleLabel = new JLabel("新生注册",JLabel.RIGHT);
		this.titleLabel.setPreferredSize(new Dimension(50,24));
		
		//创建一个学    号标签，并设置位置，大小。
		this.userIdLable = new JLabel("学    号：",JLabel.RIGHT);
		this.userIdLable.setPreferredSize(new Dimension(70,24));
		
		//创建一个用户姓名标签，并设置位置，大小。
		this.userNameLable = new JLabel("用户姓名：",JLabel.RIGHT);
		this.userNameLable.setPreferredSize(new Dimension(70,24));
		
		//创建一个性    别标签，并设置位置，大小。
		this.sexLable = new JLabel("性    别：",JLabel.RIGHT);
		this.sexLable.setPreferredSize(new Dimension(70,24));
		
		//创建一个出生日期标签，并设置位置，大小。
		this.timeLable = new JLabel("出生日期：",JLabel.RIGHT);
		this.timeLable.setPreferredSize(new Dimension(70,24));
		
		//创建一个电    话标签，并设置位置，大小。
		this.telLable = new JLabel("电    话：",JLabel.RIGHT);
		this.telLable.setPreferredSize(new Dimension(70,24));
		
		//创建一个住    址标签，并设置位置，大小。
		this.addressLable = new JLabel("住    址：",JLabel.RIGHT);
		this.addressLable.setPreferredSize(new Dimension(70,24));
		
		//创建一个入学时间标签，并设置位置，大小。
		this.dateLable = new JLabel("入学时间：",JLabel.RIGHT);
		this.dateLable.setPreferredSize(new Dimension(70,24));
		
		//创建一个信    息标签，并设置位置，大小。
		this.memoLable = new JLabel("信    息：",JLabel.RIGHT);
		this.memoLable.setPreferredSize(new Dimension(70,24));
		
		//创建一个班号标签，并设置位置，大小。
		this.classIdLable = new JLabel("班号：",JLabel.RIGHT);
		this.classIdLable.setPreferredSize(new Dimension(70,24));
		
		//创建一个班号文本域，并设置位置，大小。
		this.userNameField = new JTextField();
		this.userNameField.setPreferredSize(new Dimension(150,24));
		
		//创建一个性别文本域，并设置位置，大小。
		this.sexField = new JTextField();
		this.sexField.setPreferredSize(new Dimension(150,24));
		
		//创建一个出生日期文本域，并设置位置，大小。
		this.timeField = new JTextField();
		this.timeField.setPreferredSize(new Dimension(150,24));
		
		//创建一个住址文本域，并设置位置，大小。
		this.addressField = new JTextField();
		this.addressField.setPreferredSize(new Dimension(150,24));
		
		//创建一个入学时间文本域，并设置位置，大小。
		this.dateField = new JTextField();
		this.dateField.setPreferredSize(new Dimension(150,24));
		
		//创建一个信息文本域，并设置位置，大小。
		this.memoField = new JTextField();
		this.memoField.setPreferredSize(new Dimension(150,24));
		
		//创建一个用户名文本域，并设置位置，大小。
		this.userIdField = new JTextField();
		this.userIdField.setPreferredSize(new Dimension(150,24));
		
		//创建一个电话文本域，并设置位置，大小。
		this.telField = new JTextField();
		this.telField.setPreferredSize(new Dimension(150,24));
		
		//创建一个班号文本域，并设置位置，大小。
		this.classIdField = new JTextField();
		this.classIdField.setPreferredSize(new Dimension(150,24));
		
		//创建盒子，一个竖直的盒子，10个水平的盒子。
		Box box0 = Box.createVerticalBox();
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		Box box3 = Box.createHorizontalBox();
		Box box4 = Box.createHorizontalBox();
		Box box5 = Box.createHorizontalBox();
		Box box6 = Box.createHorizontalBox();
		Box box7 = Box.createHorizontalBox();
		Box box8 = Box.createHorizontalBox();
		Box box9 = Box.createHorizontalBox();
		Box box10 = Box.createHorizontalBox();
		//把lable和field全部添加到盒子里去。
		box1.add(this.titleLabel);
		
		box2.add(this.userIdLable);
		box2.add(this.userIdField);
		
		box3.add(this.userNameLable);
		box3.add(this.userNameField);
		
		box4.add(this.sexLable);
		box4.add(this.sexField);
		
		box5.add(this.timeLable);
		box5.add(this.timeField);
		
		box6.add(this.telLable);
		box6.add(this.telField);
		
		box7.add(this.addressLable);
		box7.add(this.addressField);
		
		box8.add(this.dateLable);
		box8.add(this.dateField);
		
		box9.add(this.memoLable);
		box9.add(this.memoField);
		
		box10.add(this.classIdLable);
		box10.add(this.classIdField);
		
		//盒子0距离页面顶部的距离
		box0.add(Box.createVerticalStrut(1));
		box0.add(box1);
		//盒子 1和盒子2之间的间距
		box0.add(Box.createVerticalStrut(10));
		box0.add(box2);
		//盒子2和盒子3之间的间距
		box0.add(Box.createVerticalStrut(10));
		box0.add(box3);
		//盒子3和盒子4之间的间距
		box0.add(Box.createVerticalStrut(10));
		box0.add(box4);
		//盒子4和盒子5之间的间距
		box0.add(Box.createVerticalStrut(10));
		box0.add(box5);
		//盒子5和盒子6之间的间距
		box0.add(Box.createVerticalStrut(10));
		box0.add(box6);
		//盒子6和盒子7之间的间距
		box0.add(Box.createVerticalStrut(10));
		box0.add(box7);
		//盒子7和盒子8之间的间距
		box0.add(Box.createVerticalStrut(10));
		box0.add(box8);
		//盒子8和盒子9之间的间距
		box0.add(Box.createVerticalStrut(10));
		box0.add(box9);
		//盒子9和盒子10之间的间距
		box0.add(Box.createVerticalStrut(10));
		box0.add(box10);
		//将盒子添加到centerpanel里
		this.centerPanel.add(box0);
		
		//创建一个buttompanel
		this.bottomPanel = new JPanel();
		//创建一个注册button，并添加监听。
		this.addButton = new JButton("注册");
		this.addButton.addActionListener(this);
		//将注册button添加到bottompanel中。
		this.bottomPanel.add(this.addButton);
		//将bottonpanel添加到bodypanel中，并设置位置。
		this.bodyPanel.add(this.bottomPanel,BorderLayout.SOUTH);
		
	}
	
	/**
	 * 
	  * 方法的描述
	  *@return void 	
	  *@Description 重写继承的接口的方法 

	 */
	@Override
	public void execute(JPanel workPanel,JPanel leftPanel,MisUser loginUser) {
		//重新画页面
		workPanel.removeAll();
		workPanel.repaint();
		//将要操作的工作区间传进来，并设置布局
		this.workPanel = workPanel;
		this.workPanel.setLayout(new BorderLayout());
		//调画页面的方法
		this.createBodyPanel();
		this.workPanel.add(this.bodyPanel);
	}
	
	/**
	 * 
	  * 方法的描述
	  *@return void 	
	  *@Description  实现监听的方法
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String id =	this.userIdField.getText(); //获取学号
		String name = this.userNameField.getText();//获取姓名
		String sex = this.sexField.getText();//获取性别
		String time = this.timeField.getText();//获取出生日期
		String tel = this.telField.getText();//获取电话
		String address = this.addressField.getText();//获取住址
		String date = this.dateField.getText();//获取入学日期
		String memo = this.memoField.getText();//获取信息
		String classId = this.classIdField.getText();//获取班号
		
    	Student student = new Student();//创建一个student类
		student.setStudentId(id);//设置学号
		student.setStudentName(name);//设置姓名
		student.setStudentSex(sex);//设置性别
		student.setStudentBirthday(time);//设置出生日期
		student.setStudentTel(tel);//设置电话
		student.setStudentAddress(address);//设置住址
		student.setStudentInDate(date);//设置入学日期
		student.setStudentMemo(memo);//设置信息
		student.setClassId(classId);//设置班号
		
    	IStudentDAO dao = new StudentDAOImpl(); //声明父类，创建子类
    	//实现监听
		if (e.getSource() == this.addButton) {
			if (id != null && name != null && sex != null && time  != null && tel != null && address != null && date != null && memo != null && classId != null) {
				if (id.length() > 0) {
					if (name.length() > 0) {
						if (sex.length() > 0) {
							if (time.length() > 0) {
								if (tel.length() > 0) {
									if (address.length() > 0) {
										if (date.length() > 0) {
											if (memo.length() > 0) {
												if (classId.length() > 0) {
													if (dao.findById(id) != null) {
														JOptionPane.showMessageDialog(this.bodyPanel, "库里已有此条记录！请重新输入");
														
														this.userIdField.setText("");
														this.userNameField.setText("");
														this.sexField.setText("");
														this.timeField.setText("");
														this.telField.setText("");
														this.addressField.setText("");
										                this.dateField.setText("");
														this.memoField.setText("");
														this.classIdField.setText("");
														return;
													}else {
														dao.add(student);
														JOptionPane.showMessageDialog(this.bodyPanel, "新增成功！");
														return;
													}
												}else {
													JOptionPane.showMessageDialog(this.bodyPanel, "班级号不能为空！");
													return;
												}
											}else {
												JOptionPane.showMessageDialog(this.bodyPanel, "信息不能为空！");
												return;
											}
										}else {
											JOptionPane.showMessageDialog(this.bodyPanel, "入学时间不能为空！");
											return;
										}
									}else {
										JOptionPane.showMessageDialog(this.bodyPanel, "家庭住址不能为空！");
										return;
									}
								}else {
									JOptionPane.showMessageDialog(this.bodyPanel, "电话不能为空！");
									return;
								}
							}else {
								JOptionPane.showMessageDialog(this.bodyPanel, "出生日期不能为空！");
								return;
							}
						}else {
							JOptionPane.showMessageDialog(this.bodyPanel, "性别不能为空！");
							return;
							
						}
					}else {
						JOptionPane.showMessageDialog(this.bodyPanel, "姓名不能为空！");
						return;
						
					}
					
				}else {
					JOptionPane.showMessageDialog(this.bodyPanel,"学号不能为空");
					return;
				}
			}else {
				return;
			}
			
		}
		
	  }
	}

