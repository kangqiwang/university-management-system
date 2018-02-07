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
	private String[] bodyTableColumns = {"��ʦ���","��ʦ����","��ʦ�Ա�","��ʦ����","�γ̱��"};
	private String[][] bodyTableRows = null;
	private JScrollPane bodyScrollPane = null;
	private JButton deleteButton = null;
	private JButton refreshButton = null;
	
	private JTextArea helpTextArea = null;
	
	/**
	 * 
	* �������
	* @author ��ҷ�
	* @date 2015��5��2�� ����15:34:16
	* @Description ˢ��bodyPanel����ϵĴ������ݿ�orgType���¼�Ŀɲ����Եı��
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
	  *@Description  �����ݿ�shoolmis_new��org����
	  *            ���м�¼,תΪOrg����ʵ��,�ٽ���Ӧ������ֵ�浽��ά������
	  *				�����ض�ά����
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
	  * ����ע��
	  *@return ��
	  *@author ��ҷ�
	  *@Time 2015��5��2������15:37:16
	  *@Description ��bodyPanel�������ʾɾ�����������Ϣ��������
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
		this.deleteButton = new JButton("ɾ��");
		this.deleteButton.addActionListener(this);
		this.refreshButton = new JButton("ˢ��");
		this.refreshButton.addActionListener(this);
		buttonPanel.add(this.deleteButton);
		buttonPanel.add(this.refreshButton);
		this.bodyPanel.add(buttonPanel,BorderLayout.SOUTH);
		
		this.contentTabbedPane.add("ɾ����ʦ", this.bodyPanel);
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
		this.helpTextArea.setText("        ɾ����ʦ�У�����ѡ��һ����¼�����ɾ����ȷ��ɾ�������ݿ��н��޴�����¼��");
		this.helpTextArea.setEditable(false);
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);//����TextArea�е��ı��Զ�����
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("ɾ����ʦ����", this.helpPanel);
	}
	/**
	 * 
	* �������
	* @author ��ҷ�
	* @date 2015��5��2�� ����15:43:16
	* @Description �ô����Ĳ�����workPanel�����MisUser�����ʼ��,����һ���й�ɾ�����������Ϣ�����
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
	* @Description  ���ɾ����ť����������ڴ�����û����������,תΪOrgTypeʵ��,ɾ�����ݿ�����֮��Ӧ��һ����¼
	*              ��֮,���ˢ�°�ť���������Ὣɾ��������ݿ�orgType���е����м�¼ȫ����ʾ�ڸ����ı����
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
					ITeacherDAO teacherDAO = new TeacherDAOImp();
					boolean flag = teacherDAO.remove(id);
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
