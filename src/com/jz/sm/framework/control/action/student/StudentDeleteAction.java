package com.jz.sm.framework.control.action.student;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;






import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.control.action.org.ColorSet;
import com.jz.sm.framework.model.dao.impl.IStudentDAO;
import com.jz.sm.framework.model.dao.impl.StudentDAOImpl;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.Student;

public class StudentDeleteAction implements ActionFunction, ActionListener {
	
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"学号", "学生姓名", "学生性别", "出生年月", "电话", "籍贯", "入学时间", "学生描述", "班级编号"};
	private String[][] bodyTableRows = null;
	private JScrollPane scrollPane = null;
	private JButton deleteButton = null;
	private JButton refreshButton = null;
	
	private JTextArea helpTextArea = null;
	
	/**
	 * 
	* 类的描述
	* @author 田芬芬
	* @date 2015年5月2日 下午15:34:16
	* @Description 刷新bodyPanel面板上的存有数据库student表记录的可操作性的表格
	 */
	private void refreshTable() {
		this.bodyTable.removeAll();
		this.bodyTable.repaint();
		this.bodyTableRows = this.getAllData();
		this.bodyTableModel = new DefaultTableModel(this.bodyTableRows, this.bodyTableColumns);
		this.bodyTable.setModel(bodyTableModel);
	}
	/**
	 * 
	  * 方法注释
	  *@return 存放数据库记录的二维数组
	  *@author 田芬芬
	  *@Time 2015年5月2日下午15:36:16
	  *@Description  将数据库shoolmis_new中student表中
	  *            所有记录,转为Student对象实例,再将对应的属性值存到二维数组中
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
	  *@Time 2015年5月2日下午15:37:16
	  *@Description 在bodyPanel面板上显示删除学生信息的相关组件
	 */
	private void createBodyPane() {
		ColorSet colorSet = new ColorSet();
		this.bodyPanel = new JPanel();
		this.bodyPanel.setLayout(new BorderLayout());
		this.bodyPanel.setBackground(colorSet.getWhite());
		this.bodyTableRows = this.getAllData();
		this.bodyTableModel = new DefaultTableModel(this.bodyTableRows, this.bodyTableColumns);
		this.bodyTable = new JTable(bodyTableModel);
		this.bodyTable.setBackground(colorSet.getWhite());
		this.scrollPane = new JScrollPane(this.bodyTable);
		this.bodyPanel.add(this.scrollPane,BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(colorSet.getWhite());
		this.deleteButton = new JButton("删除");
		this.deleteButton.addActionListener(this);
		this.refreshButton = new JButton("刷新");
		this.refreshButton.addActionListener(this);
		buttonPanel.add(this.deleteButton);
		buttonPanel.add(this.refreshButton);
		this.bodyPanel.add(buttonPanel,BorderLayout.SOUTH);
		
		this.contentTabbedPane.add("删除学生", this.bodyPanel);
	}
	/**
	 * 
	  * 方法注释
	  *@return 无
	  *@author 田芬芬
	  *@Time 2015年5月2日下午15:40:16
	  *@Description  在helpPanel面板显示文本域
	 */
	private void createHelpPane() {
		ColorSet colorSet = new ColorSet();
		this.helpPanel = new JPanel(new GridBagLayout());
		this.helpPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.helpTextArea = new JTextArea(10, 30);
		this.helpTextArea.setText("        删除学生中：必须选中一条记录后才能删除，确认删除后，数据库中将无此条记录。");
		this.helpTextArea.setEditable(false);
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);//设置TextArea中的文本自动换行
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("删除学生帮助", this.helpPanel);
	}
	/**
	 * 
	* 类的描述
	* @author 田芬芬
	* @date 2015年5月2日 下午15:43:16
	* @Description 用传来的参数对workPanel对象和MisUser对象初始化,创建一个有关删除学生信息的面板
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
		this.createBodyPane();
		this.createHelpPane();
		this.workPanel.add(this.contentTabbedPane,BorderLayout.CENTER);
	}
	/**
	 * 
	* 监听方法的描述
	* @author 田芬芬
	* @date 2015年5月2日 下午15:49:51
	* @Description  如果删除按钮被点击，将在此面板用户输入的数据,转为Student实例,删除数据库中与之对应的一条记录
	*              反之,如果刷新按钮被点击，则会将删除后的数据库student表中的所有记录全部显示在该面板的表格中
	*             
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.deleteButton){
			int n = this.bodyTable.getSelectedRowCount();
			if(n == 1) {
				String id = this.bodyTableModel.getValueAt(this.bodyTable.getSelectedRow(), 0).toString();
				int m = JOptionPane.showConfirmDialog(null, "是否确定要删除", "删除消息", JOptionPane.YES_NO_OPTION);
				if(m == JOptionPane.YES_OPTION) {
					IStudentDAO studentDAO = new StudentDAOImpl();
					boolean flag = studentDAO.remove(id);
					if(flag) {
						JOptionPane.showMessageDialog(null, "删除成功");
						this.refreshTable();
					}
				} 
			} else {
				JOptionPane.showMessageDialog(null, "请选中一条数据");
			}
		} else if(e.getSource() == this.refreshButton) {
			this.refreshTable();
		}
	}
	

}
