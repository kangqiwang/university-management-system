package com.jz.sm.framework.control.action.teacher;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.control.action.org.ColorSet;
import com.jz.sm.framework.model.dao.impl.CourseDAOImp;
import com.jz.sm.framework.model.dao.impl.ICourseDAO;
import com.jz.sm.framework.model.dao.impl.ITeacherDAO;
import com.jz.sm.framework.model.dao.impl.TeacherDAOImp;
import com.jz.sm.framework.model.entity.Course;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.Teacher;

public class TeacherCreateAction implements ActionFunction,ActionListener{
	private JTabbedPane tabbedPane = null;
	private JPanel addteacherPanel = null;//���ӽ�ʦ���
	private JPanel addteacherHelpPanel = null;//���ӽ�ʦ���������
	private JLabel nameLabel = null;//��ʦ����
	private JTextField nameTextField = null;
	private JLabel sexLabel = null;//��ʦ�Ա�
	private JTextField sexTextField = null;
	private JLabel ageLabel = null;//��ʦ����
	private JTextField ageTextField = null;
	private JLabel courseNameLabel = null;//�γ�ID �γ�����
	private JComboBox courseNameComboBox = null;
	private JButton addOrgTypeButton = null;//���Ӱ�ť
	private JButton clearButton = null;//��հ�ť
	private JTextArea helpTextArea = null;
	
	/**
	 * �õ�course�������е�courseID
	 * @return
	 */
	private String[] getCourseName() {
		String[] allCourseId = null;
		ICourseDAO courseDAO = new CourseDAOImp();
		List<Course> list = courseDAO.findAll();
		allCourseId = new String[list.size()];
		for(int i = 0;i < list.size();i++) {
			allCourseId[i] = list.get(i).getCourseName();
		}
		return allCourseId;
	}
	/**
	 * 
	* �������
	* @author ��ҷ�
	* @date 2015��5��2�� ����15:21:16
	* @Description �ô����Ĳ�����workPanel�����ʼ��,����һ���й����ӻ��������Ϣ�����
	 */
	@Override
	public void execute(JPanel workPanel,JPanel leftPanel,MisUser loginUser) {
		ColorSet colorSet = new ColorSet();
		workPanel.removeAll();
		workPanel.repaint();
		workPanel.setLayout(new BorderLayout());
		this.tabbedPane = new JTabbedPane();
		this.tabbedPane.setBackground(colorSet.getWhite());
		this.addteacherPanel = new JPanel();
		this.addteacherPanel.setBackground(colorSet.getWhite());
		
		this.nameLabel = new JLabel("��ʦ������");
		this.sexLabel = new JLabel("��ʦ�Ա�");
		this.ageLabel = new JLabel("��ʦ���䣺");
		this.courseNameLabel = new JLabel("�γ����ƣ�");
		
		this.nameTextField = new JTextField(40);
		this.sexTextField = new JTextField(40);
		this.ageTextField = new JTextField(40);
		this.courseNameComboBox = new JComboBox(this.getCourseName());
		
		this.addOrgTypeButton = new JButton("����");
		this.addOrgTypeButton.addActionListener(this);
		this.clearButton = new JButton("���");
		this.clearButton.addActionListener(this);
		
		
		Box box0 = Box.createVerticalBox();
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		Box box3 = Box.createHorizontalBox();
		Box box4 = Box.createHorizontalBox();
		Box box5 = Box.createHorizontalBox();
		
		box1.add(this.nameLabel);
		box1.add(this.nameTextField);
		
		box2.add(this.sexLabel);
		box2.add(this.sexTextField);
		
		box3.add(this.ageLabel);
		box3.add(this.ageTextField);
		
		box4.add(this.courseNameLabel);
		box4.add(this.courseNameComboBox);
		
		box5.add(this.addOrgTypeButton);
		box5.add(Box.createHorizontalStrut(15));
		box5.add(this.clearButton);
		
		box0.add(Box.createVerticalStrut(45));
		box0.add(box1);
		box0.add(Box.createVerticalStrut(15));
		box0.add(box2);
		box0.add(Box.createVerticalStrut(15));
		box0.add(box3);
		box0.add(Box.createVerticalStrut(15));
		box0.add(box4);
		box0.add(Box.createVerticalStrut(35));
		box0.add(box5);
		
		this.addteacherPanel.add(box0);
		
		this.tabbedPane.add("���ӽ�ʦ",this.addteacherPanel);
		
		this.addteacherHelpPanel = new JPanel();
		this.addteacherHelpPanel.setBackground(colorSet.getWhite());
		this.addteacherHelpPanel.setLayout(new GridBagLayout());
		this.helpTextArea = new JTextArea(10,30);
		this.helpTextArea.setText("        ���ӽ�ʦ����д��ʦ�Ļ�����Ϣ���������ӣ����ɽ�ҳ���ϵ����ݷ�װΪһ�����󣬲��ύ�����ݿ⡣���н�ʦ�����Ϳγ̱�Ų���Ϊ�ա�������գ����ɻص���ʼ״̬��");
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);
		JScrollPane scrollPane2 = new JScrollPane(this.helpTextArea);
		this.addteacherHelpPanel.add(scrollPane2);
		this.tabbedPane.add("���ӽ�ʦ����",this.addteacherHelpPanel);
		workPanel.add(this.tabbedPane,BorderLayout.CENTER);
	}
	/**
	 * 
	* �������
	* @author ��ҷ�
	* @date 2015��5��2�� ����15:23:51
	* @Description  ������Ӱ�ť����������ڴ�����û����������,����dao�㣬
	*             ���浽���ݿ�orgType���У���֮,�����հ�ť���������������ϵ�����ָ�����̬
	*             
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.addOrgTypeButton) {
			String name = this.nameTextField.getText();
			String sex = this.sexTextField.getText();
			String age = this.ageTextField.getText();
			String courseName = this.courseNameComboBox.getSelectedItem().toString();
			ICourseDAO courseDAO = new CourseDAOImp();
			String courseId = courseDAO.findByName(courseName);
			if(name != null && courseId != null) {
				if(name.length() > 0 && courseId.length() > 0) {
					Teacher teacher = new Teacher(name, sex, age, courseId);
					ITeacherDAO teacherDAO = new TeacherDAOImp();
					boolean flag = teacherDAO.add(teacher);
					if(flag) {
						JOptionPane.showMessageDialog(null, "�����ɹ�");
					} else {
						JOptionPane.showMessageDialog(null, "�������ɹ�");
					}
				} else {
					JOptionPane.showMessageDialog(null, "��ʦ��������Ϊ��");
					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, "��ʦ��������Ϊ��");
				return;
			}
			
		} else if(e.getSource() == this.clearButton) {
			this.nameTextField.setText("");
			this.sexTextField.setText("");
			this.ageTextField.setText("");
			this.courseNameComboBox.setSelectedIndex(0);
		}
		
	}

}
