package com.jz.sm.framework.control.action.student;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
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
import com.jz.sm.framework.model.dao.impl.IStudentDAO;
import com.jz.sm.framework.model.dao.impl.StudentDAOImpl;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.Student;

public class StudentQueryAction implements ActionFunction, ActionListener {
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	private JLabel studentNameLable = null;
	private JTextField studentNameField = null;
	private JButton findButton = null;
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"学号", "学生姓名", "学生性别", "出生年月", "电话", "籍贯", "入学时间", "学生描述", "班级编号"};
	private String[][] bodyTableRows = null;
	private JScrollPane scrollPane = null;
	private JButton detailButton = null;
	private JTextArea helpTextArea = null;
	/**
	 * 
	  * 方法注释
	  *@return 存放数据库记录的二维数组
	  *@author 田芬芬
	  *@Time 2015年5月4日下午14:20:16
	  *@Description  将数据库shoolmis_new中student表中
	  *            所有记录,转为对象实例,再将对应的属性值存到二维数组中
	  *				，返回二维数组
	 */
	private String[][] getAllData(Student student) {
		String[][] rowsData = null;
		IStudentDAO studentDAO = new StudentDAOImpl();
		List<Student> list = studentDAO.findByLike(student);
		rowsData = new String[list.size()][9];
		for(int i = 0;i < list.size();i++) {
			rowsData[i][0] = list.get(i).getStudentId();
			rowsData[i][1] = list.get(i).getStudentName();
			rowsData[i][2] = list.get(i).getStudentSex();
			rowsData[i][3] = list.get(i).getStudentBirthday();
			rowsData[i][4] = list.get(i).getStudentTel();
			rowsData[i][5] = list.get(i).getStudentAddress();
			rowsData[i][6] = list.get(i).getStudentInDate();
			rowsData[i][7] = list.get(i).getStudentMemo();
			rowsData[i][8] = list.get(i).getClassId();
		}
		return rowsData;
	}
	/**
	 * 
	  * 方法注释
	  *@return 无
	  *@author 田芬芬
	  *@Time 2015年5月4日下午14:22:16
	  *@Description 在bodyPanel面板上显示查询机构类别信息的相关组件
	 */
	private void createBodyPanel() {
		ColorSet colorSet = new ColorSet();
		this.bodyPanel = new JPanel(new BorderLayout());
		this.bodyPanel.setBackground(colorSet.getWhite());
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		northPanel.setBackground(colorSet.getWhite());
		this.studentNameLable = new JLabel("学生姓名");
		this.studentNameField = new JTextField(20);
		this.findButton = new JButton("查找");
		this.findButton.addActionListener(this);
		northPanel.add(this.studentNameLable);
		northPanel.add(this.studentNameField);
		northPanel.add(this.findButton);
		this.bodyPanel.add(northPanel,BorderLayout.NORTH);
		
		this.bodyTableRows = this.getAllData(new Student());
		this.bodyTableModel = new DefaultTableModel(this.bodyTableRows, this.bodyTableColumns);
		this.bodyTable = new JTable(bodyTableModel);
		this.scrollPane = new JScrollPane(this.bodyTable);
		this.bodyPanel.add(this.scrollPane,BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		southPanel.setBackground(colorSet.getWhite());
		this.detailButton = new JButton("详情");
		this.detailButton.addActionListener(this);
		southPanel.add(this.detailButton);
		this.bodyPanel.add(southPanel,BorderLayout.SOUTH);
		
		this.contentTabbedPane.add("查询学生", this.bodyPanel);
	}
	/**
	 * 
	  * 方法注释
	  *@return 无
	  *@author 田芬芬
	  *@Time 2015年5月4日下午14:23:16
	  *@Description  在helpPanel面板显示文本域
	 */
	private void createHelpPanel() {
		ColorSet colorSet = new ColorSet();
		this.helpPanel = new JPanel(new  GridBagLayout());
		this.helpPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.helpTextArea = new JTextArea(10, 30);
		this.helpTextArea.setText("        学生查询：当搜索目标不明确时，可以通过模糊查询搜素关键字的同义字提高搜索的精确性，"
				+ "同时，可以通过选择一条数据后点击详情而得到所选记录的详细信息。");
		this.helpTextArea.setEditable(false);
		//字体，风格，字号
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);//设置TextArea中的文本自动换行
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("查询学生帮助",this.helpPanel);
	}
	/**
	 * 
	* 监听方法的描述
	* @author 田芬芬
	* @date 2015年5月4日 下午14:24:51
	* @Description  把标签面板加到workPanel上
	* 
	 */
	
	@Override
	public void execute(JPanel workPanel,JPanel leftPanel,MisUser loginUser) {
		this.workPanel = workPanel;
		this.workPanel.removeAll();
		this.workPanel.repaint();
		this.workPanel.setLayout(new BorderLayout());
		
		this.contentTabbedPane = new JTabbedPane();
		this.createBodyPanel();
		this.createHelpPanel();
		this.workPanel.add(this.contentTabbedPane,BorderLayout.CENTER);
	}
	/**
	 * 
	* 监听方法的描述
	* @author 田芬芬
	* @date 2015年5月4日 下午14:30:51
	* @Description  如果查询界面上的查询按钮被点击，会将查询到的记录显示在workPanel面板上
	* 				如果选中了一行,并且点击了详情,会弹出另一个界面,显示该机构类别的详细信息
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.findButton) {
			String name = this.studentNameField.getText();
			this.bodyTable.removeAll();
			this.bodyTable.repaint();
			this.bodyTableRows = this.getAllData(new Student("", name, "", "","", "", "", "", ""));
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
	* @date 2015年5月4日 下午15:19:51
	* @Description 是内部类 ，创建了一个显示某一个机构类别的详细信息的界面
	*      
	 */
	public class DetailDialog extends JDialog{
		private Student student = null;
		
		private JLabel studentIdLabel = null;
		private JTextField studentIdTextField = null;
		private JLabel studentNameLabel = null;
		private JTextField studentNameTextField = null;
		private JLabel studentSexLabel = null;
		private JTextField studentSexTextField = null;
		private JLabel studentBirthdayLabel = null;
		private JTextField studentBirthdayTextField = null;
		private JLabel studentTelLabel = null;
		private JTextField studentTelTextField = null;
		private JLabel studentAddressLabel = null;
		private JTextField studentAddressTextField = null;
		private JLabel studentInDateLabel = null;
		private JTextField studentInDateTextField = null;
		private JLabel classIdLabel = null;
		private JTextField classIdTextField = null;
		private JLabel studentMemoLabel = null;
		private JTextArea studentMemoArea = null;
		/**
		 * 
		  * 方法注释
		  *@return 一个student对象实例
		  *@author 田芬芬
		  *@Time 2015年5月4日下午15:20:16
		  *@Description  用id作为查询条件,查询数据库中的记录,最后在该层得到与之对应的OrgType对象实例
		 */
		private Student getStudent(String id) {
			IStudentDAO studentDAO = new StudentDAOImpl();
			Student student = studentDAO.findById(id);
			return student;
		}
		
		/**
		 * 
		  * 方法注释
		  *@return 无
		  *@author 田芬芬
		  *@Time 2015年5月4日下午15:24:16
		  *@Description  在container面板显示查询相关信息需要的组件
		 */
		private void init() {
			Container container = this.getContentPane();
			container.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			
			this.studentIdLabel = new JLabel("学号：");
			gbc.gridx = 0;
			gbc.gridy = 0;
			container.add(this.studentIdLabel,gbc);
			
			this.studentIdTextField = new JTextField(20);
			this.studentIdTextField.setText(this.student.getStudentId());
			this.studentIdTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 0;
			container.add(this.studentIdTextField,gbc);
			
			this.studentNameLabel = new JLabel("姓名：");
			gbc.gridx = 0;
			gbc.gridy = 1;
			container.add(this.studentNameLabel,gbc);
			
			this.studentNameTextField = new JTextField(20);
			this.studentNameTextField.setText(this.student.getStudentName());
			this.studentNameTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 1;
			container.add(this.studentNameTextField,gbc);
			
			this.studentSexLabel = new JLabel("性别：");
			gbc.gridx = 0;
			gbc.gridy = 2;
			container.add(this.studentSexLabel,gbc);
			
			this.studentSexTextField = new JTextField(20);
			this.studentSexTextField.setText(this.student.getStudentSex());
			this.studentSexTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 2;
			container.add(this.studentSexTextField,gbc);
			
			this.studentBirthdayLabel = new JLabel("生日：");
			gbc.gridx = 0;
			gbc.gridy = 3;
			container.add(this.studentBirthdayLabel,gbc);
			
			this.studentBirthdayTextField = new JTextField(20);
			this.studentBirthdayTextField.setText(this.student.getStudentBirthday());
			this.studentBirthdayTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 3;
			container.add(this.studentBirthdayTextField,gbc);
			
			this.studentTelLabel = new JLabel("电话：");
			gbc.gridx = 0;
			gbc.gridy = 4;
			container.add(this.studentTelLabel,gbc);
			
			this.studentTelTextField = new JTextField(20);
			this.studentTelTextField.setText(this.student.getStudentTel());
			this.studentTelTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 4;
			container.add(this.studentTelTextField,gbc);
			
			this.studentAddressLabel = new JLabel("籍贯：");
			gbc.gridx = 0;
			gbc.gridy = 5;
			container.add(this.studentAddressLabel,gbc);
			
			this.studentAddressTextField = new JTextField(20);
			this.studentAddressTextField.setText(this.student.getStudentAddress());
			this.studentAddressTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 5;
			container.add(this.studentAddressTextField,gbc);
			
			this.studentInDateLabel = new JLabel("入学时间：");
			gbc.gridx = 0;
			gbc.gridy = 6;
			container.add(this.studentInDateLabel,gbc);
			
			this.studentInDateTextField = new JTextField(20);
			this.studentInDateTextField.setText(this.student.getStudentInDate());
			this.studentInDateTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 6;
			container.add(this.studentInDateTextField,gbc);
			
			this.classIdLabel = new JLabel("班级编号：");
			gbc.gridx = 0;
			gbc.gridy = 7;
			container.add(this.classIdLabel,gbc);
			
			this.classIdTextField = new JTextField(20);
			this.classIdTextField.setText(this.student.getClassId());
			this.classIdTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 7;
			container.add(this.classIdTextField,gbc);
			
			this.studentMemoLabel = new JLabel("学生描述：");
			gbc.gridx = 0;
			gbc.gridy = 8;
			container.add(this.studentMemoLabel,gbc);
			
			this.studentMemoArea = new JTextArea(10, 20);
			this.studentMemoArea.setText(this.student.getStudentMemo());
			this.studentMemoArea.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(this.studentMemoArea);
			gbc.gridx = 1;
			gbc.gridy = 8;
			container.add(scrollPane,gbc);
		}
		/**
		 * 
			构造方法的描述
		* @author 田芬芬
		* @date 2015年5月4日 下午14:28:57
		* @Description  无
		 */
		public DetailDialog() {
			// TODO Auto-generated constructor stub
		}
		/**
		 * 
			构造方法的描述
		* @author 田芬芬
		* @date 2015年5月4日 下午14:33:57
		* @Description  用传来的参数对orgType的对象初始化
		 */
		public DetailDialog(String id) {
			this.student = this.getStudent(id);
			this.init();
		}
		
	}
}
