package com.jz.sm.framework.control.action.teacher;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
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
import com.jz.sm.framework.model.dao.impl.IOrgTypeDAO;
import com.jz.sm.framework.model.dao.impl.ITeacherDAO;
import com.jz.sm.framework.model.dao.impl.OrgTypeDAOImp;
import com.jz.sm.framework.model.dao.impl.TeacherDAOImp;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.OrgType;
import com.jz.sm.framework.model.entity.Teacher;

public class TeacherDeleteAction implements ActionFunction,ActionListener{
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"教师编号","教师姓名","教师性别","教师年龄","课程编号"};
	private String[][] bodyTableRows = null;
	private JScrollPane bodyScrollPane = null;
	private JButton deleteButton = null;
	private JButton refreshButton = null;
	
	private JTextArea helpTextArea = null;
	
	/**
	 * 
	* 类的描述
	* @author 田芬芬
	* @date 2015年5月2日 下午15:34:16
	* @Description 刷新bodyPanel面板上的存有数据库orgType表记录的可操作性的表格
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
	  *@Time 2015年5月2日下午15:37:16
	  *@Description 在bodyPanel面板上显示删除机构类别信息的相关组件
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
		this.bodyScrollPane = new JScrollPane(this.bodyTable);
		this.bodyPanel.add(this.bodyScrollPane,BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(colorSet.getWhite());
		this.deleteButton = new JButton("删除");
		this.deleteButton.addActionListener(this);
		this.refreshButton = new JButton("刷新");
		this.refreshButton.addActionListener(this);
		buttonPanel.add(this.deleteButton);
		buttonPanel.add(this.refreshButton);
		this.bodyPanel.add(buttonPanel,BorderLayout.SOUTH);
		
		this.contentTabbedPane.add("删除教师", this.bodyPanel);
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
		this.helpTextArea.setText("        删除教师中：必须选中一条记录后才能删除，确认删除后，数据库中将无此条记录。");
		this.helpTextArea.setEditable(false);
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);//设置TextArea中的文本自动换行
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("删除教师帮助", this.helpPanel);
	}
	/**
	 * 
	* 类的描述
	* @author 田芬芬
	* @date 2015年5月2日 下午15:43:16
	* @Description 用传来的参数对workPanel对象和MisUser对象初始化,创建一个有关删除机构类别信息的面板
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
	* @Description  如果删除按钮被点击，将在此面板用户输入的数据,转为OrgType实例,删除数据库中与之对应的一条记录
	*              反之,如果刷新按钮被点击，则会将删除后的数据库orgType表中的所有记录全部显示在该面板的表格中
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
					ITeacherDAO teacherDAO = new TeacherDAOImp();
					boolean flag = teacherDAO.remove(id);
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
