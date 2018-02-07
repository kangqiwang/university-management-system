package com.jz.sm.framework.control.action.student;



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


public class StudentCreateAction implements ActionFunction, ActionListener {
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

	private void createBodyPanel() {
		ColorSet colorSet=new ColorSet();
		this.bodyPanel = new JPanel();
		this.bodyPanel.setLayout(new BorderLayout());
		this.bodyPanel.setBackground(colorSet.getWhite());
		this.centerPanel = new  JPanel();
		this.bodyPanel.add(this.centerPanel,BorderLayout.CENTER);
		
	
		this.titleLabel = new JLabel("添加学生",JLabel.RIGHT);
		this.titleLabel.setPreferredSize(new Dimension(50,24));
		
		this.userIdLable = new JLabel("学    号：",JLabel.RIGHT);
		this.userIdLable.setPreferredSize(new Dimension(70,24));
		
		this.userNameLable = new JLabel("学生姓名：",JLabel.RIGHT);
		this.userNameLable.setPreferredSize(new Dimension(70,24));
		
		this.sexLable = new JLabel("性    别：",JLabel.RIGHT);
		this.sexLable.setPreferredSize(new Dimension(70,24));
		
		this.timeLable = new JLabel("出生日期：",JLabel.RIGHT);
		this.timeLable.setPreferredSize(new Dimension(70,24));

		this.telLable = new JLabel("电    话：",JLabel.RIGHT);
		this.telLable.setPreferredSize(new Dimension(70,24));
		
		this.addressLable = new JLabel("住    址：",JLabel.RIGHT);
		this.addressLable.setPreferredSize(new Dimension(70,24));
		
		this.dateLable = new JLabel("入学时间：",JLabel.RIGHT);
		this.dateLable.setPreferredSize(new Dimension(70,24));
		
		this.memoLable = new JLabel("信    息：",JLabel.RIGHT);
		this.memoLable.setPreferredSize(new Dimension(70,24));
		
		this.classIdLable = new JLabel("班号：",JLabel.RIGHT);
		this.classIdLable.setPreferredSize(new Dimension(70,24));
	
		this.userNameField = new JTextField();
		this.userNameField.setPreferredSize(new Dimension(150,24));
		
		this.sexField = new JTextField();
		this.sexField.setPreferredSize(new Dimension(150,24));
		
		this.timeField = new JTextField();
		this.timeField.setPreferredSize(new Dimension(150,24));
		
		this.addressField = new JTextField();
		this.addressField.setPreferredSize(new Dimension(150,24));
		
		this.dateField = new JTextField();
		this.dateField.setPreferredSize(new Dimension(150,24));
		
		this.memoField = new JTextField();
		this.memoField.setPreferredSize(new Dimension(150,24));
		
		this.userIdField = new JTextField();
		this.userIdField.setPreferredSize(new Dimension(150,24));
		
		this.telField = new JTextField();
		this.telField.setPreferredSize(new Dimension(150,24));
		
		this.classIdField = new JTextField();
		this.classIdField.setPreferredSize(new Dimension(150,24));
		
		
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
		
		box0.add(Box.createVerticalStrut(1));
		box0.add(box1);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box2);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box3);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box4);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box5);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box6);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box7);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box8);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box9);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box10);
		this.centerPanel.add(box0);
		
		this.bottomPanel = new JPanel();
		this.addButton = new JButton("添加");
		this.addButton.addActionListener(this);
		this.bottomPanel.add(this.addButton);
		this.bodyPanel.add(this.bottomPanel,BorderLayout.SOUTH);
		
	}
	
	@Override
	public void execute(JPanel workPanel,JPanel leftPanel,MisUser loginUser) {
		workPanel.removeAll();
		workPanel.repaint();
		this.workPanel = workPanel;
		this.workPanel.setLayout(new BorderLayout());
		this.createBodyPanel();
		this.workPanel.add(this.bodyPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id =	this.userIdField.getText();
		String name = this.userNameField.getText();
		String sex = this.sexField.getText();
		String time = this.timeField.getText();
		String tel = this.telField.getText();
		String address = this.addressField.getText();
		String date = this.dateField.getText();
		String memo = this.memoField.getText();
		String classId = this.classIdField.getText();
		
    	Student student = new Student();
		student.setStudentId(id);
		student.setStudentName(name);
		student.setStudentSex(sex);
		student.setStudentBirthday(time);
		student.setStudentTel(tel);
		student.setStudentAddress(address);
		student.setStudentInDate(date);
		student.setStudentMemo(memo);
		student.setClassId(classId);
    	IStudentDAO dao = new StudentDAOImpl();
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
