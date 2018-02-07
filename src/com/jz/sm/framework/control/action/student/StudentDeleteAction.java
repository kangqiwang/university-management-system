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
	private String[] bodyTableColumns = {"ѧ��", "ѧ������", "ѧ���Ա�", "��������", "�绰", "����", "��ѧʱ��", "ѧ������", "�༶���"};
	private String[][] bodyTableRows = null;
	private JScrollPane scrollPane = null;
	private JButton deleteButton = null;
	private JButton refreshButton = null;
	
	private JTextArea helpTextArea = null;
	
	/**
	 * 
	* �������
	* @author ��ҷ�
	* @date 2015��5��2�� ����15:34:16
	* @Description ˢ��bodyPanel����ϵĴ������ݿ�student���¼�Ŀɲ����Եı��
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
	  * ����ע��
	  *@return ������ݿ��¼�Ķ�ά����
	  *@author ��ҷ�
	  *@Time 2015��5��2������15:36:16
	  *@Description  �����ݿ�shoolmis_new��student����
	  *            ���м�¼,תΪStudent����ʵ��,�ٽ���Ӧ������ֵ�浽��ά������
	  *				�����ض�ά����
	 */
	private String[][] getAllData() {
		String[][] rowsData = null;
		IStudentDAO studentDAO = new StudentDAOImpl();
		List<Student> list = studentDAO.findByLike(new Student());//ȫ��
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
	  * ����ע��
	  *@return ��
	  *@author ��ҷ�
	  *@Time 2015��5��2������15:37:16
	  *@Description ��bodyPanel�������ʾɾ��ѧ����Ϣ��������
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
		this.deleteButton = new JButton("ɾ��");
		this.deleteButton.addActionListener(this);
		this.refreshButton = new JButton("ˢ��");
		this.refreshButton.addActionListener(this);
		buttonPanel.add(this.deleteButton);
		buttonPanel.add(this.refreshButton);
		this.bodyPanel.add(buttonPanel,BorderLayout.SOUTH);
		
		this.contentTabbedPane.add("ɾ��ѧ��", this.bodyPanel);
	}
	/**
	 * 
	  * ����ע��
	  *@return ��
	  *@author ��ҷ�
	  *@Time 2015��5��2������15:40:16
	  *@Description  ��helpPanel�����ʾ�ı���
	 */
	private void createHelpPane() {
		ColorSet colorSet = new ColorSet();
		this.helpPanel = new JPanel(new GridBagLayout());
		this.helpPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.helpTextArea = new JTextArea(10, 30);
		this.helpTextArea.setText("        ɾ��ѧ���У�����ѡ��һ����¼�����ɾ����ȷ��ɾ�������ݿ��н��޴�����¼��");
		this.helpTextArea.setEditable(false);
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);//����TextArea�е��ı��Զ�����
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("ɾ��ѧ������", this.helpPanel);
	}
	/**
	 * 
	* �������
	* @author ��ҷ�
	* @date 2015��5��2�� ����15:43:16
	* @Description �ô����Ĳ�����workPanel�����MisUser�����ʼ��,����һ���й�ɾ��ѧ����Ϣ�����
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
	* ��������������
	* @author ��ҷ�
	* @date 2015��5��2�� ����15:49:51
	* @Description  ���ɾ����ť����������ڴ�����û����������,תΪStudentʵ��,ɾ�����ݿ�����֮��Ӧ��һ����¼
	*              ��֮,���ˢ�°�ť���������Ὣɾ��������ݿ�student���е����м�¼ȫ����ʾ�ڸ����ı����
	*             
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.deleteButton){
			int n = this.bodyTable.getSelectedRowCount();
			if(n == 1) {
				String id = this.bodyTableModel.getValueAt(this.bodyTable.getSelectedRow(), 0).toString();
				int m = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��Ҫɾ��", "ɾ����Ϣ", JOptionPane.YES_NO_OPTION);
				if(m == JOptionPane.YES_OPTION) {
					IStudentDAO studentDAO = new StudentDAOImpl();
					boolean flag = studentDAO.remove(id);
					if(flag) {
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						this.refreshTable();
					}
				} 
			} else {
				JOptionPane.showMessageDialog(null, "��ѡ��һ������");
			}
		} else if(e.getSource() == this.refreshButton) {
			this.refreshTable();
		}
	}
	

}
