package com.jz.sm.framework.control.action.student;



import java.awt.BorderLayout;
import java.awt.Color;
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
import com.jz.sm.framework.model.dao.impl.IStudentDAO;
import com.jz.sm.framework.model.dao.impl.StudentDAOImpl;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.Student;

public class StudentModifyAction implements ActionFunction, ActionListener {
	
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"学号", "学生姓名", "学生性别", "出生年月", "电话", "籍贯", "入学时间", "学生描述", "班级编号"};
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
	  *@Description  将数据库shoolmis_new中student表中
	  *            所有记录,转为student对象实例,再将对应的属性值存到二维数组中
	  *				，返回二维数组
	 */
	private String[][] getAllData() {
		String[][] rowsData = null;
		IStudentDAO studentDAO = new StudentDAOImpl();
		List<Student> list = studentDAO.findByLike(new Student());//全查
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
		this.modifyButton = new JButton("修改");
		this.modifyButton.addActionListener(this);
		this.refreshButton = new JButton("刷新");
		this.refreshButton.addActionListener(this);
		buttonPanel.add(this.modifyButton);
		buttonPanel.add(this.refreshButton);
		this.bodyPanel.add(buttonPanel,BorderLayout.SOUTH);
		this.contentTabbedPane.add("修改学生信息",this.bodyPanel);
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
		this.helpTextArea.setText("        学生信息的修改中：必须选中一条数据后再单击修改，若修改成功则会弹出修改成功的消息，相应的页面会刷新，数据库中的记录也会修改。此外，当修改页面没有被关闭时，仍然可以打击还原来还原记录。");
		this.helpTextArea.setEditable(false);
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("修改学生信息帮助", this.helpPanel);
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
				modifyDialog.setTitle("信息工程学院管理系统->修改机构类别");
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
		private StudentModifyAction modifyAction = null;//StudentModifyAction类的对象
		private Student student = null;//Student对象实例
		
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
		private JButton saveButton = null;//保存按钮
		private JButton restoreButton = null;//还原按钮
		/**
		 * 
		  * 方法注释
		  *@return 一个Student对象实例
		  *@author 田芬芬
		  *@Time 2015年5月3日下午15:35:16
		  *@Description  用id作为查询条件,查询数据库中的记录,最后在该层得到与之对应的OrgType对象实例
		 */
		private Student getStudent(String id) {
			Student student = null;
			IStudentDAO studentDAO = new StudentDAOImpl();
			student = studentDAO.findById(id);
			return student;
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
			ColorSet colorSet=new ColorSet();
			Container container = this.getContentPane();
			container.setLayout(new GridBagLayout());
			container.setBackground(colorSet.getWhite());
			GridBagConstraints gbc = new GridBagConstraints();
			
			this.studentIdLabel = new JLabel("学号：");
			gbc.gridx = 0;
			gbc.gridy = 0;
			container.add(this.studentIdLabel,gbc);
			
			this.studentIdTextField = new JTextField(20);
			this.studentIdTextField.setText(this.student.getStudentId());
			gbc.gridx = 1;
			gbc.gridy = 0;
			container.add(this.studentIdTextField,gbc);
			
			this.studentNameLabel = new JLabel("姓名：");
			gbc.gridx = 0;
			gbc.gridy = 1;
			container.add(this.studentNameLabel,gbc);
			
			this.studentNameTextField = new JTextField(20);
			this.studentNameTextField.setText(this.student.getStudentName());
			gbc.gridx = 1;
			gbc.gridy = 1;
			container.add(this.studentNameTextField,gbc);
			
			this.studentSexLabel = new JLabel("性别：");
			gbc.gridx = 0;
			gbc.gridy = 2;
			container.add(this.studentSexLabel,gbc);
			
			this.studentSexTextField = new JTextField(20);
			this.studentSexTextField.setText(this.student.getStudentSex());
			gbc.gridx = 1;
			gbc.gridy = 2;
			container.add(this.studentSexTextField,gbc);
			
			this.studentBirthdayLabel = new JLabel("生日：");
			gbc.gridx = 0;
			gbc.gridy = 3;
			container.add(this.studentBirthdayLabel,gbc);
			
			this.studentBirthdayTextField = new JTextField(20);
			this.studentBirthdayTextField.setText(this.student.getStudentBirthday());
			gbc.gridx = 1;
			gbc.gridy = 3;
			container.add(this.studentBirthdayTextField,gbc);
			
			this.studentTelLabel = new JLabel("电话：");
			gbc.gridx = 0;
			gbc.gridy = 4;
			container.add(this.studentTelLabel,gbc);
			
			this.studentTelTextField = new JTextField(20);
			this.studentTelTextField.setText(this.student.getStudentTel());
			gbc.gridx = 1;
			gbc.gridy = 4;
			container.add(this.studentTelTextField,gbc);
			
			this.studentAddressLabel = new JLabel("籍贯：");
			gbc.gridx = 0;
			gbc.gridy = 5;
			container.add(this.studentAddressLabel,gbc);
			
			this.studentAddressTextField = new JTextField(20);
			this.studentAddressTextField.setText(this.student.getStudentAddress());
			gbc.gridx = 1;
			gbc.gridy = 5;
			container.add(this.studentAddressTextField,gbc);
			
			this.studentInDateLabel = new JLabel("入学时间：");
			gbc.gridx = 0;
			gbc.gridy = 6;
			container.add(this.studentInDateLabel,gbc);
			
			this.studentInDateTextField = new JTextField(20);
			this.studentInDateTextField.setText(this.student.getStudentInDate());
			gbc.gridx = 1;
			gbc.gridy = 6;
			container.add(this.studentInDateTextField,gbc);
			
			this.classIdLabel = new JLabel("班级编号：");
			gbc.gridx = 0;
			gbc.gridy = 7;
			container.add(this.classIdLabel,gbc);
			
			this.classIdTextField = new JTextField(20);
			this.classIdTextField.setText(this.student.getClassId());
			gbc.gridx = 1;
			gbc.gridy = 7;
			container.add(this.classIdTextField,gbc);
			
			this.studentMemoLabel = new JLabel("学生描述：");
			gbc.gridx = 0;
			gbc.gridy = 8;
			container.add(this.studentMemoLabel,gbc);
			
			this.studentMemoArea = new JTextArea(10, 20);
			this.studentMemoArea.setText(this.student.getStudentMemo());
			JScrollPane scrollPane = new JScrollPane(this.studentMemoArea);
			gbc.gridx = 1;
			gbc.gridy = 8;
			container.add(scrollPane,gbc);
			
			JPanel buttonPanel = new JPanel();
			this.saveButton = new JButton("保存");
			this.saveButton.addActionListener(this);
			this.restoreButton = new JButton("还原");
			this.restoreButton.addActionListener(this);
			buttonPanel.add(this.saveButton);
			buttonPanel.add(this.restoreButton);
			gbc.gridx = 1;
			gbc.gridy = 9;
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
		public ModifyDialog(StudentModifyAction modifyAction,String id) {
			this.modifyAction = modifyAction;
			this.student = this.getStudent(id);
			this.init();
		}
		/**
		 * 
		* 监听方法的描述
		* @author 田芬芬
		* @date 2015年5月3日 下午15:40:51
		* @Description  如果修改界面上的保存按钮被点击，将在此面板用户修改后的数据,转为OrgType实例,传到dao，
		*               最后存到数据库student表中；反之,如果还原按钮被点击，则会将修改前的数据恢复
		*             
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == this.saveButton) {
				String studentId = this.studentIdTextField.getText();
				String studentName = this.studentNameTextField.getText();
				String studentMemo = this.studentMemoArea.getText();
				String studentSex = this.studentSexTextField.getText();
				String studentBirthday = this.studentBirthdayTextField.getText();
				String studentTel = this.studentTelTextField.getText();
				String studentAddress = this.studentAddressTextField.getText();
				String studentInDate = this.studentInDateTextField.getText();
				String classId = this.classIdTextField.getText();
				
				Student student = new Student(studentId, studentName, studentSex, studentBirthday, studentTel, studentAddress, studentInDate, studentMemo, classId);
				IStudentDAO studentDAO = new StudentDAOImpl();
				boolean flag = studentDAO.modify(student);
				if(flag) {
					JOptionPane.showMessageDialog(this, "修改成功");
					this.modifyAction.refreshTable();
				} else {
					JOptionPane.showMessageDialog(this, "修改失败");
				}
			} else if(e.getSource() == this.restoreButton) {
				this.studentNameTextField.setText("");
				this.studentMemoArea.setText("");
				this.studentSexTextField.setText("");
				this.studentBirthdayTextField.setText("");
				this.studentTelTextField.setText("");
				this.studentAddressTextField.setText("");
				this.studentInDateTextField.setText("");
				this.classIdTextField.setText("");
			}
		}
		
	}

}
