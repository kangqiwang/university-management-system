package com.jz.sm.framework.control.action.teacher;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import com.jz.sm.framework.control.action.org.OrgTypeModifyAction;
import com.jz.sm.framework.control.action.org.OrgTypeModifyAction.ModifyDialog;
import com.jz.sm.framework.control.action.org.OrgTypeQueryAction.DetailDialog;
import com.jz.sm.framework.model.dao.impl.IOrgTypeDAO;
import com.jz.sm.framework.model.dao.impl.ITeacherDAO;
import com.jz.sm.framework.model.dao.impl.OrgTypeDAOImp;
import com.jz.sm.framework.model.dao.impl.TeacherDAOImp;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.OrgType;
import com.jz.sm.framework.model.entity.Teacher;

public class TeacherQueryAction implements ActionFunction,ActionListener{
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"教师编号","教师姓名","教师性别","教师年龄","课程编号"};
	private String[][] bodyTableRows = null;
	private JScrollPane bodyScrollPane = null;
	private JLabel teacherNameLable = null;
	private JTextField teacherNameField = null;
	private JButton findButton = null;//查询
	private JButton detailButton = null;//详情
	private JTextArea helpTextArea = null;
	private void refreshTable() {
		this.bodyTable.removeAll();
		this.bodyTable.repaint();
		this.bodyTableRows = this.getAllData(new Teacher());
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
	private String[][] getAllData(Teacher teacher) {
		String[][] data = null;
		ITeacherDAO teacherDAO = new TeacherDAOImp();
		List<Teacher> list = teacherDAO.findByLike(teacher);
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
		this.bodyPanel.setBackground(colorSet.getWhite());
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		northPanel.setBackground(colorSet.getWhite());
		this.teacherNameLable = new JLabel("教师姓名：");
		this.teacherNameField = new JTextField(20);
		this.findButton = new JButton("查找");
		this.findButton.addActionListener(this);
		northPanel.add(this.teacherNameLable);
		northPanel.add(this.teacherNameField);
		northPanel.add(this.findButton);
		this.bodyPanel.add(northPanel,BorderLayout.NORTH);
		
		this.bodyTableModel = new DefaultTableModel(this.getAllData(new Teacher()), this.bodyTableColumns);
		this.bodyTable = new JTable(bodyTableModel);
		this.bodyScrollPane = new JScrollPane(this.bodyTable);
		this.bodyPanel.add(this.bodyScrollPane,BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		southPanel.setBackground(colorSet.getWhite());
		this.detailButton = new JButton("详  情");
		this.detailButton.addActionListener(this);
		southPanel.add(this.detailButton);
		this.bodyPanel.add(southPanel,BorderLayout.SOUTH);
		this.contentTabbedPane.add("查询教师信息 ",this.bodyPanel);
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
		this.contentTabbedPane.add("查询教师信息帮助", this.helpPanel);
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
		if(e.getSource() == this.findButton) {
			String name = this.teacherNameField.getText();
			this.bodyTable.removeAll();
			this.bodyTable.repaint();
			this.bodyTableRows = this.getAllData(new Teacher("", name, "", "", ""));
			this.bodyTableModel = new DefaultTableModel(this.bodyTableRows, this.bodyTableColumns);
			this.bodyTable.setModel(bodyTableModel);
		} else if(e.getSource() == this.detailButton) {
			int n = this.bodyTable.getSelectedRowCount();
			if(n == 1) {
				String id = this.bodyTableModel.getValueAt(this.bodyTable.getSelectedRow(), 0).toString();
				DetailDialog detailDialog = new DetailDialog(id);
				detailDialog.setSize(600, 550); 
				detailDialog.setLocationRelativeTo(null);
				ImageIcon icon = new ImageIcon("img/title.jpg");
				detailDialog.setIconImage(icon.getImage());
				detailDialog.setTitle("信息工程学院管理系统->详情");
				detailDialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "请选择一条记录");
				return;
			}
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
		public class DetailDialog extends JDialog{
		private Teacher teacher = null;	
		
		private JLabel idLabel = null;//教师编号
		private JTextField idTextField = null;
		private JLabel nameLabel = null;//教师姓名
		private JTextField nameTextField = null;
		private JLabel sexLabel = null;//教师性别
		private JTextField sexTextField = null;
		private JLabel ageLabel = null;//教师年龄
		private JTextField ageTextField= null;
		private JLabel courseIdLabel = null;//课程ID
		private JTextField courseTextField = null;
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
			this.nameTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 1;
			container.add(this.nameTextField,gbc);
			
			this.sexLabel = new JLabel("教师性别：");
			gbc.gridx = 0;
			gbc.gridy = 2;
			container.add(this.sexLabel,gbc);
			
			this.sexTextField = new JTextField(40);
			this.sexTextField.setText(this.teacher.getTeacher_sex());
			this.sexTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 2;
			container.add(this.sexTextField,gbc);
			
			this.ageLabel = new JLabel("教师年龄：");
			gbc.gridx = 0;
			gbc.gridy = 3;
			container.add(this.ageLabel,gbc);
			
			this.ageTextField = new JTextField(40);
			this.ageTextField.setText(this.teacher.getTeacher_age());
			this.ageTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 3;
			container.add(this.ageTextField,gbc);
			
			this.courseIdLabel = new JLabel("课程编号：");
			gbc.gridx = 0;
			gbc.gridy = 4;
			container.add(this.courseIdLabel,gbc);
			
			this.courseTextField = new JTextField(40);
			this.courseTextField.setText(this.teacher.getCourseId());
			this.courseTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 4;
			container.add(this.courseTextField,gbc);
			
		}		
		/**
		 * 
			构造方法的描述
		* @author 田芬芬
		* @date 2015年5月3日 下午14:32:57
		* @Description  无
		 */
		public DetailDialog() {
			// TODO Auto-generated constructor stub
		}
		/**
		 * 
			构造方法的描述
		* @author 田芬芬
		* @date 2015年5月3日 下午14:33:57
		* @Description  用传来的参数对modifyAction的对象初始化
		 */
		public DetailDialog(String id) {
			this.teacher = this.getTeacher(id);
			this.init();
		}
	} 
}
