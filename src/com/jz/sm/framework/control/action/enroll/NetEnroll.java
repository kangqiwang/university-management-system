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
  * �������
  *@return void 	
  *@Description  ����һ��NetEnroll�࣬��ʵ��ActionFunction,ActionListener�ӿڡ�
 */
public class NetEnroll implements ActionFunction,ActionListener{
	//��������
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
	  * ��������
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��5��15������3:29:13
	  *@Description  ����һ��createBodyPanel()��������ҳ�档
	 */
	private void createBodyPanel() {
		//����panel��ɫ
		ColorSet colorSet=new ColorSet();
		//����һ��panel
		this.bodyPanel = new JPanel();
		//����panel����
		this.bodyPanel.setLayout(new BorderLayout());
		//����panel������ɫ
		this.bodyPanel.setBackground(colorSet.getWhite());
		//����һ��panel
		this.centerPanel = new  JPanel();
		//�����panel����bodypanel�ϣ�������ҳ��λ�á�
		this.bodyPanel.add(this.centerPanel,BorderLayout.CENTER);
		
		//����һ������ע���ǩ��������λ�ã���С��
		this.titleLabel = new JLabel("����ע��",JLabel.RIGHT);
		this.titleLabel.setPreferredSize(new Dimension(50,24));
		
		//����һ��ѧ    �ű�ǩ��������λ�ã���С��
		this.userIdLable = new JLabel("ѧ    �ţ�",JLabel.RIGHT);
		this.userIdLable.setPreferredSize(new Dimension(70,24));
		
		//����һ���û�������ǩ��������λ�ã���С��
		this.userNameLable = new JLabel("�û�������",JLabel.RIGHT);
		this.userNameLable.setPreferredSize(new Dimension(70,24));
		
		//����һ����    ���ǩ��������λ�ã���С��
		this.sexLable = new JLabel("��    ��",JLabel.RIGHT);
		this.sexLable.setPreferredSize(new Dimension(70,24));
		
		//����һ���������ڱ�ǩ��������λ�ã���С��
		this.timeLable = new JLabel("�������ڣ�",JLabel.RIGHT);
		this.timeLable.setPreferredSize(new Dimension(70,24));
		
		//����һ����    ����ǩ��������λ�ã���С��
		this.telLable = new JLabel("��    ����",JLabel.RIGHT);
		this.telLable.setPreferredSize(new Dimension(70,24));
		
		//����һ��ס    ַ��ǩ��������λ�ã���С��
		this.addressLable = new JLabel("ס    ַ��",JLabel.RIGHT);
		this.addressLable.setPreferredSize(new Dimension(70,24));
		
		//����һ����ѧʱ���ǩ��������λ�ã���С��
		this.dateLable = new JLabel("��ѧʱ�䣺",JLabel.RIGHT);
		this.dateLable.setPreferredSize(new Dimension(70,24));
		
		//����һ����    Ϣ��ǩ��������λ�ã���С��
		this.memoLable = new JLabel("��    Ϣ��",JLabel.RIGHT);
		this.memoLable.setPreferredSize(new Dimension(70,24));
		
		//����һ����ű�ǩ��������λ�ã���С��
		this.classIdLable = new JLabel("��ţ�",JLabel.RIGHT);
		this.classIdLable.setPreferredSize(new Dimension(70,24));
		
		//����һ������ı��򣬲�����λ�ã���С��
		this.userNameField = new JTextField();
		this.userNameField.setPreferredSize(new Dimension(150,24));
		
		//����һ���Ա��ı��򣬲�����λ�ã���С��
		this.sexField = new JTextField();
		this.sexField.setPreferredSize(new Dimension(150,24));
		
		//����һ�����������ı��򣬲�����λ�ã���С��
		this.timeField = new JTextField();
		this.timeField.setPreferredSize(new Dimension(150,24));
		
		//����һ��סַ�ı��򣬲�����λ�ã���С��
		this.addressField = new JTextField();
		this.addressField.setPreferredSize(new Dimension(150,24));
		
		//����һ����ѧʱ���ı��򣬲�����λ�ã���С��
		this.dateField = new JTextField();
		this.dateField.setPreferredSize(new Dimension(150,24));
		
		//����һ����Ϣ�ı��򣬲�����λ�ã���С��
		this.memoField = new JTextField();
		this.memoField.setPreferredSize(new Dimension(150,24));
		
		//����һ���û����ı��򣬲�����λ�ã���С��
		this.userIdField = new JTextField();
		this.userIdField.setPreferredSize(new Dimension(150,24));
		
		//����һ���绰�ı��򣬲�����λ�ã���С��
		this.telField = new JTextField();
		this.telField.setPreferredSize(new Dimension(150,24));
		
		//����һ������ı��򣬲�����λ�ã���С��
		this.classIdField = new JTextField();
		this.classIdField.setPreferredSize(new Dimension(150,24));
		
		//�������ӣ�һ����ֱ�ĺ��ӣ�10��ˮƽ�ĺ��ӡ�
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
		//��lable��fieldȫ����ӵ�������ȥ��
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
		
		//����0����ҳ�涥���ľ���
		box0.add(Box.createVerticalStrut(1));
		box0.add(box1);
		//���� 1�ͺ���2֮��ļ��
		box0.add(Box.createVerticalStrut(10));
		box0.add(box2);
		//����2�ͺ���3֮��ļ��
		box0.add(Box.createVerticalStrut(10));
		box0.add(box3);
		//����3�ͺ���4֮��ļ��
		box0.add(Box.createVerticalStrut(10));
		box0.add(box4);
		//����4�ͺ���5֮��ļ��
		box0.add(Box.createVerticalStrut(10));
		box0.add(box5);
		//����5�ͺ���6֮��ļ��
		box0.add(Box.createVerticalStrut(10));
		box0.add(box6);
		//����6�ͺ���7֮��ļ��
		box0.add(Box.createVerticalStrut(10));
		box0.add(box7);
		//����7�ͺ���8֮��ļ��
		box0.add(Box.createVerticalStrut(10));
		box0.add(box8);
		//����8�ͺ���9֮��ļ��
		box0.add(Box.createVerticalStrut(10));
		box0.add(box9);
		//����9�ͺ���10֮��ļ��
		box0.add(Box.createVerticalStrut(10));
		box0.add(box10);
		//��������ӵ�centerpanel��
		this.centerPanel.add(box0);
		
		//����һ��buttompanel
		this.bottomPanel = new JPanel();
		//����һ��ע��button������Ӽ�����
		this.addButton = new JButton("ע��");
		this.addButton.addActionListener(this);
		//��ע��button��ӵ�bottompanel�С�
		this.bottomPanel.add(this.addButton);
		//��bottonpanel��ӵ�bodypanel�У�������λ�á�
		this.bodyPanel.add(this.bottomPanel,BorderLayout.SOUTH);
		
	}
	
	/**
	 * 
	  * ����������
	  *@return void 	
	  *@Description ��д�̳еĽӿڵķ��� 

	 */
	@Override
	public void execute(JPanel workPanel,JPanel leftPanel,MisUser loginUser) {
		//���»�ҳ��
		workPanel.removeAll();
		workPanel.repaint();
		//��Ҫ�����Ĺ������䴫�����������ò���
		this.workPanel = workPanel;
		this.workPanel.setLayout(new BorderLayout());
		//����ҳ��ķ���
		this.createBodyPanel();
		this.workPanel.add(this.bodyPanel);
	}
	
	/**
	 * 
	  * ����������
	  *@return void 	
	  *@Description  ʵ�ּ����ķ���
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String id =	this.userIdField.getText(); //��ȡѧ��
		String name = this.userNameField.getText();//��ȡ����
		String sex = this.sexField.getText();//��ȡ�Ա�
		String time = this.timeField.getText();//��ȡ��������
		String tel = this.telField.getText();//��ȡ�绰
		String address = this.addressField.getText();//��ȡסַ
		String date = this.dateField.getText();//��ȡ��ѧ����
		String memo = this.memoField.getText();//��ȡ��Ϣ
		String classId = this.classIdField.getText();//��ȡ���
		
    	Student student = new Student();//����һ��student��
		student.setStudentId(id);//����ѧ��
		student.setStudentName(name);//��������
		student.setStudentSex(sex);//�����Ա�
		student.setStudentBirthday(time);//���ó�������
		student.setStudentTel(tel);//���õ绰
		student.setStudentAddress(address);//����סַ
		student.setStudentInDate(date);//������ѧ����
		student.setStudentMemo(memo);//������Ϣ
		student.setClassId(classId);//���ð��
		
    	IStudentDAO dao = new StudentDAOImpl(); //�������࣬��������
    	//ʵ�ּ���
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
														JOptionPane.showMessageDialog(this.bodyPanel, "�������д�����¼������������");
														
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
														JOptionPane.showMessageDialog(this.bodyPanel, "�����ɹ���");
														return;
													}
												}else {
													JOptionPane.showMessageDialog(this.bodyPanel, "�༶�Ų���Ϊ�գ�");
													return;
												}
											}else {
												JOptionPane.showMessageDialog(this.bodyPanel, "��Ϣ����Ϊ�գ�");
												return;
											}
										}else {
											JOptionPane.showMessageDialog(this.bodyPanel, "��ѧʱ�䲻��Ϊ�գ�");
											return;
										}
									}else {
										JOptionPane.showMessageDialog(this.bodyPanel, "��ͥסַ����Ϊ�գ�");
										return;
									}
								}else {
									JOptionPane.showMessageDialog(this.bodyPanel, "�绰����Ϊ�գ�");
									return;
								}
							}else {
								JOptionPane.showMessageDialog(this.bodyPanel, "�������ڲ���Ϊ�գ�");
								return;
							}
						}else {
							JOptionPane.showMessageDialog(this.bodyPanel, "�Ա���Ϊ�գ�");
							return;
							
						}
					}else {
						JOptionPane.showMessageDialog(this.bodyPanel, "��������Ϊ�գ�");
						return;
						
					}
					
				}else {
					JOptionPane.showMessageDialog(this.bodyPanel,"ѧ�Ų���Ϊ��");
					return;
				}
			}else {
				return;
			}
			
		}
		
	  }
	}

