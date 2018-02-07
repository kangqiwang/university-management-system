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
	private JPanel addteacherPanel = null;//增加教师面板
	private JPanel addteacherHelpPanel = null;//增加教师面板帮助面板
	private JLabel nameLabel = null;//教师姓名
	private JTextField nameTextField = null;
	private JLabel sexLabel = null;//教师性别
	private JTextField sexTextField = null;
	private JLabel ageLabel = null;//教师年龄
	private JTextField ageTextField = null;
	private JLabel courseNameLabel = null;//课程ID 课程名称
	private JComboBox courseNameComboBox = null;
	private JButton addOrgTypeButton = null;//增加按钮
	private JButton clearButton = null;//清空按钮
	private JTextArea helpTextArea = null;
	
	/**
	 * 得到course表中所有的courseID
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
	* 类的描述
	* @author 田芬芬
	* @date 2015年5月2日 下午15:21:16
	* @Description 用传来的参数对workPanel对象初始化,创建一个有关增加机构类别信息的面板
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
		
		this.nameLabel = new JLabel("教师姓名：");
		this.sexLabel = new JLabel("教师性别：");
		this.ageLabel = new JLabel("教师年龄：");
		this.courseNameLabel = new JLabel("课程名称：");
		
		this.nameTextField = new JTextField(40);
		this.sexTextField = new JTextField(40);
		this.ageTextField = new JTextField(40);
		this.courseNameComboBox = new JComboBox(this.getCourseName());
		
		this.addOrgTypeButton = new JButton("增加");
		this.addOrgTypeButton.addActionListener(this);
		this.clearButton = new JButton("清空");
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
		
		this.tabbedPane.add("增加教师",this.addteacherPanel);
		
		this.addteacherHelpPanel = new JPanel();
		this.addteacherHelpPanel.setBackground(colorSet.getWhite());
		this.addteacherHelpPanel.setLayout(new GridBagLayout());
		this.helpTextArea = new JTextArea(10,30);
		this.helpTextArea.setText("        增加教师，填写教师的基本信息，单击增加，即可将页面上的内容封装为一个对象，并提交到数据库。其中教师姓名和课程编号不能为空。单击清空，即可回到初始状态。");
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);
		JScrollPane scrollPane2 = new JScrollPane(this.helpTextArea);
		this.addteacherHelpPanel.add(scrollPane2);
		this.tabbedPane.add("增加教师帮助",this.addteacherHelpPanel);
		workPanel.add(this.tabbedPane,BorderLayout.CENTER);
	}
	/**
	 * 
	* 类的描述
	* @author 田芬芬
	* @date 2015年5月2日 下午15:23:51
	* @Description  如果增加按钮被点击，将在此面板用户输入的数据,传到dao层，
	*             最后存到数据库orgType表中；反之,如果清空按钮被点击，则让面板上的组件恢复到初态
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
						JOptionPane.showMessageDialog(null, "新增成功");
					} else {
						JOptionPane.showMessageDialog(null, "新增不成功");
					}
				} else {
					JOptionPane.showMessageDialog(null, "教师姓名不能为空");
					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, "教师姓名不能为空");
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
