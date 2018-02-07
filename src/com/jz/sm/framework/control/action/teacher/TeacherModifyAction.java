package com.jz.sm.framework.control.action.teacher;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.control.action.org.ColorSet;
import com.jz.sm.framework.model.dao.impl.ITeacherDAO;
import com.jz.sm.framework.model.dao.impl.TeacherDAOImp;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.Teacher;

public class TeacherModifyAction implements ActionFunction,ActionListener{
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"教师编号","教师姓名","教师性别","教师年龄","课程编号"};
	private String[][] bodyTableRows = null;
	private JScrollPane bodyScrollPane = null;
	private JButton modifyButton = null;
	private JButton refreshButton = null;
	private JTextArea helpTextArea = null;
	private void refreshTable() {
		this.bodyTable.removeAll();
		this.bodyTable.repaint();
		this.bodyTableRows = this.getAllData();
		this.bodyTableModel = new DefaultTableModel(this.bodyTableRows, this.bodyTableColumns);
		this.bodyTable.setModel(this.bodyTableModel);
	}
	
	/**
	 * 
	  * 方法注释
	  *@return 存放数据库记录的二维数组
	  *@author 田芬芬
	  *@Time 2015年5月3日下午14:36:16
	  *@Description  将数据库shoolmis_new中org表中
	  *            所有记录,转为Org对象实例,再将对应的属性值存到二维数组中
	  *				，返回二维数组
	 */
	private String[][] getAllData() {
		String[][] data = null;
		ITeacherDAO teacherDAO = new TeacherDAOImp();
		List<Teacher> list = teacherDAO.findByLike(new Teacher());
		data = new String[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			Teacher tempteacher = list.get(i);
			data[i][0] = tempteacher.getId_teacher();
			data[i][1] = tempteacher.getTeacher_name();
			data[i][2] = tempteacher.getTeacher_sex();
			data[i][3] = tempteacher.getTeacher_age();
			data[i][4] = tempteacher.getCourseId();
		}
		return data;
	}
	/**
	 * 
	  * 方法注释
	  *@return 无
	  *@author 田芬芬
	  *@Time 2015年5月3日下午14:39:16
	  *@Description 在bodyPanel面板上显示修改机构类别信息的相关组件
	 */
	private void createBodyPanel() {
		ColorSet colorSet = new ColorSet();
		this.bodyPanel = new JPanel(new BorderLayout());
		this.bodyTableModel = new DefaultTableModel(this.getAllData(), this.bodyTableColumns);
		this.bodyTable = new JTable(bodyTableModel);
		this.bodyScrollPane = new JScrollPane(this.bodyTable);
		this.bodyPanel.add(this.bodyScrollPane,BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(colorSet.getWhite());
		this.modifyButton = new JButton("修  改");
		this.modifyButton.addActionListener(this);
		this.refreshButton = new JButton("刷  新");
		this.refreshButton.addActionListener(this);
		buttonPanel.add(this.modifyButton);
		buttonPanel.add(this.refreshButton);
		this.bodyPanel.add(buttonPanel,BorderLayout.SOUTH);
		this.contentTabbedPane.add("修改教师信息 ",this.bodyPanel);
	}
	/**
	 * 
	  * 方法注释
	  *@return 无
	  *@author 田芬芬
	  *@Time 2015年5月3日下午15:16:16
	  *@Description  在helpPanel面板显示文本域
	 */
	private void createHelpPanel() {
		ColorSet colorSet = new ColorSet();
		this.helpPanel = new JPanel(new GridBagLayout());
		this.helpPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.helpTextArea = new JTextArea(10, 30);
		this.helpTextArea.setText("        教师信息的修改中：必须选中一条数据后再单击修改，若修改成功则会弹出修改成功的消息，相应的页面会刷新，数据库中的记录也会修改。此外，当修改页面没有被关闭时，仍然可以打击还原来还原记录。");
		this.helpTextArea.setEditable(false);
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("修改教师信息帮助", this.helpPanel);
	}
	/**
	 * 
	* 监听方法的描述
	* @author 田芬芬
	* @date 2015年5月3日 下午15:17:51
	* @Description  把标签面板加到workPanel上
	* 
	 */
	
	@Override
	public void execute(JPanel workPanel,JPanel leftPanel,MisUser loginUser) {
		ColorSet colorSet = new ColorSet();
		this.workPanel = workPanel;
		this.workPanel.removeAll();
		this.workPanel.repaint();
		this.workPanel.setLayout(new BorderLayout());
		this.contentTabbedPane = new JTabbedPane();
		this.contentTabbedPane.setBackground(colorSet.getWhite());
		this.createBodyPanel();
		this.createHelpPanel();
		this.workPanel.add(this.contentTabbedPane,BorderLayout.CENTER);
		
	}
	/**
	 * 
	* 监听方法的描述
	* @author 田芬芬
	* @date 2015年5月3日 下午15:18:51
	* @Description  如果修改界面上的保存按钮被点击，并且选中了一行,会弹出修改的界面
	* 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.modifyButton) {
			/*变量n用来存放所选行的个数*/
			int n = this.bodyTable.getSelectedRowCount();
			if(n == 1) {
				String id = this.bodyTableModel.getValueAt(this.bodyTable.getSelectedRow(), 0).toString();
				ModifyDialog modifyDialog = new ModifyDialog(this, id);
				modifyDialog.setSize( 600, 450);
				modifyDialog.setLocationRelativeTo(null);
				ImageIcon icon = new ImageIcon("img/title.jpg");
				modifyDialog.setIconImage(icon.getImage());
				modifyDialog.setTitle("信息工程学院管理系统->修改教师信息");
				modifyDialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "请选择一条数据");
			}
		} else if(e.getSource() == this.refreshButton) {
			this.refreshTable();
		}
	}
	/**
	 * 
	* 类的描述
	* @author 田芬芬
	* @date 2015年5月3日 下午15:19:51
	* @Description 是内部类 当选中一行并且点击了修改按钮,会弹出另一个界面,
	*             用来修改机构类别相关信息的组件
	 */
		public class ModifyDialog extends JDialog implements ActionListener {
		private TeacherModifyAction teacherModifyAction = null;
		private Teacher teacher = null;
		
		private JLabel idLabel = null;//教师编号
		private JTextField idTextField = null;
		private JLabel nameLabel = null;//教师姓名
		private JTextField nameTextField = null;
		private JLabel sexLabel = null;//教师性别
		private JTextField sexTextField = null;
		private JLabel ageLabel = null;//教师年龄
		private JTextField ageTextField = null;
		private JLabel courseIdLabel = null;//课程ID
		private JTextField courseTextField = null;
		private JButton saveButton = null;//保存按钮
		private JButton restoreButton = null;//还原按钮
		/**
		 * 
		  * 方法注释
		  *@return 一个OrgType对象实例
		  *@author 田芬芬
		  *@Time 2015年5月3日下午15:35:16
		  *@Description  用id作为查询条件,查询数据库中的记录,最后在该层得到与之对应的OrgType对象实例
		 */
		private Teacher getTeacher(String id) {
			Teacher teacher = null;
			ITeacherDAO teacherDAO = new TeacherDAOImp();
			List<Teacher> list = teacherDAO.findByLike(new Teacher(id, "", "", "", ""));
			teacher = list.get(0);
			return teacher;
		}
		
		/**
		 * 
	  * 方法注释
		  *@return 无
		  *@author 田芬芬
		  *@Time 2015年5月3日下午15:35:16
		  *@Description  在container面板显示修改相关信息的组件
		 */
		
		private void init() {
			Container container = this.getContentPane();
			container.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			
			this.idLabel = new JLabel("教师编号：");
			gbc.gridx = 0;
			gbc.gridy = 0;
			container.add(this.idLabel,gbc);
			
			this.idTextField = new JTextField(40);
			this.idTextField.setText(this.teacher.getId_teacher());
			this.idTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 0;
			container.add(this.idTextField,gbc);
			
			this.nameLabel = new JLabel("教师姓名：");
			gbc.gridx = 0;
			gbc.gridy = 1;
			container.add(this.nameLabel,gbc);
			
			this.nameTextField = new JTextField(40);
			this.nameTextField.setText(this.teacher.getTeacher_name());
			gbc.gridx = 1;
			gbc.gridy = 1;
			container.add(this.nameTextField,gbc);
			
			this.sexLabel = new JLabel("教师性别：");
			gbc.gridx = 0;
			gbc.gridy = 2;
			container.add(this.sexLabel,gbc);
			
			this.sexTextField = new JTextField(40);
			this.sexTextField.setText(this.teacher.getTeacher_sex());
			gbc.gridx = 1;
			gbc.gridy = 2;
			container.add(this.sexTextField,gbc);
			
			this.ageLabel = new JLabel("教师年龄：");
			gbc.gridx = 0;
			gbc.gridy = 3;
			container.add(this.ageLabel,gbc);
			
			this.ageTextField = new JTextField(40);
			this.ageTextField.setText(this.teacher.getTeacher_age());
			gbc.gridx = 1;
			gbc.gridy = 3;
			container.add(this.ageTextField,gbc);
			
			this.courseIdLabel = new JLabel("课程编号：");
			gbc.gridx = 0;
			gbc.gridy = 4;
			container.add(this.courseIdLabel,gbc);
			
			this.courseTextField = new JTextField(40);
			this.courseTextField.setText(this.teacher.getCourseId());
			gbc.gridx = 1;
			gbc.gridy = 4;
			container.add(this.courseTextField,gbc);
			
			JPanel buttonPanel = new JPanel();
			this.saveButton = new JButton("保存");
			this.saveButton.addActionListener(this);
			this.restoreButton = new JButton("还原");
			this.restoreButton.addActionListener(this);
			buttonPanel.add(this.saveButton);
			buttonPanel.add(this.restoreButton);
			gbc.gridx = 1;
			gbc.gridy = 5;
			container.add(buttonPanel,gbc);
			
			this.setTitle("修改");
		}
		/**
		 * 
			构造方法的描述
		* @author 田芬芬
		* @date 2015年5月3日 下午14:32:57
		* @Description  无
		 */
		public ModifyDialog() {
			// TODO Auto-generated constructor stub
		}
		/**
		 * 
			构造方法的描述
		* @author 田芬芬
		* @date 2015年5月3日 下午14:33:57
		* @Description  用传来的参数对modifyAction的对象初始化
		 */
		public ModifyDialog(TeacherModifyAction modifyAction,String id) {
			this.teacherModifyAction = modifyAction;
			this.teacher = this.getTeacher(id);
			this.init();
		}
		/**
		 * 
		* 监听方法的描述
		* @author 田芬芬
		* @date 2015年5月3日 下午15:40:51
		* @Description  如果修改界面上的保存按钮被点击，将在此面板用户修改后的数据,转为OrgType实例,传到dao，
		*               最后存到数据库orgType表中；反之,如果还原按钮被点击，则会将修改前的数据恢复
		*             
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == this.saveButton) {
				String id = this.idTextField.getText();
				String name = this.nameTextField.getText();
				String sex = this.sexTextField.getText();
				String age = this.ageTextField.getText();
				String courseId = this.courseTextField.getText();
				Teacher teacher = new Teacher(id, name, sex, age, courseId); 
				ITeacherDAO teacherDAO = new TeacherDAOImp();
				boolean flag = teacherDAO.modify(teacher);
				if(flag) {
					JOptionPane.showMessageDialog(this, "修改成功");
					this.teacherModifyAction.refreshTable();
				} else {
					JOptionPane.showMessageDialog(this, "修改失败");
				}
			} else if(e.getSource() == this.restoreButton) {
				this.nameTextField.setText(this.teacher.getTeacher_name());
				this.sexTextField.setText(this.teacher.getTeacher_sex());
				this.ageTextField.setText(this.teacher.getTeacher_age());
				this.courseTextField.setText(this.teacher.getCourseId());
			}
		}
	} 
}
