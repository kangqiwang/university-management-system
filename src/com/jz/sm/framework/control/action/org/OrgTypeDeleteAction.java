package com.jz.sm.framework.control.action.org;

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

import com.jz.sm.framework.model.dao.impl.IOrgTypeDAO;
import com.jz.sm.framework.model.dao.impl.OrgTypeDAOImp;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.OrgType;
/**
 * 
* �������
* @Description  ��ɾ����������ܰ�ť�����,��ť�ұߵ��������ɾ�������Ľ���
 */
public class OrgTypeDeleteAction implements ActionFunction,ActionListener{
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"����������","�����������","�����������"};
	private String[][] bodyTableRows = null;
	private JScrollPane scrollPane = null;
	private JButton deleteButton = null;
	private JButton refreshButton = null;
	
	private JTextArea helpTextArea = null;
	
	/**
	 * 
	* �������
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
	  *@Description  �����ݿ�shoolmis_new��org����
	  *            ���м�¼,תΪOrg����ʵ��,�ٽ���Ӧ������ֵ�浽��ά������
	  *				�����ض�ά����
	 */
	private String[][] getAllData() {
		String[][] rowsData = null;
		IOrgTypeDAO orgTypeDAO = new OrgTypeDAOImp();
		List<OrgType> list = orgTypeDAO.findByLike(new OrgType());//ȫ��
		rowsData = new String[list.size()][3];
		for(int i = 0;i < list.size();i++) {
			rowsData[i][0] = list.get(i).getOrgTypeId();
			rowsData[i][1] = list.get(i).getOrgTypeName();
			rowsData[i][2] = list.get(i).getOrgTypeMemo();
		}
		return rowsData;
	}
	/**
	 * 
	  * ����ע��
	  *@return ��
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
		this.scrollPane = new JScrollPane(this.bodyTable);
		this.bodyPanel.add(this.scrollPane,BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(colorSet.getWhite());
		this.deleteButton = new JButton("ɾ  ��");
		this.deleteButton.addActionListener(this);
		this.refreshButton = new JButton("ˢ  ��");
		this.refreshButton.addActionListener(this);
		buttonPanel.add(this.deleteButton);
		buttonPanel.add(this.refreshButton);
		this.bodyPanel.add(buttonPanel,BorderLayout.SOUTH);
		
		this.contentTabbedPane.add("ɾ���������", this.bodyPanel);
	}
	/**
	 * 
	  * ����ע��
	  *@return ��
	  *@Description  ��helpPanel�����ʾ�ı���
	 */
	private void createHelpPane() {
		ColorSet colorSet = new ColorSet();
		this.helpPanel = new JPanel(new GridBagLayout());
		this.helpPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.helpTextArea = new JTextArea(10, 30);
		this.helpTextArea.setText("        ɾ����������У�����ѡ��һ����¼�����ɾ����ȷ��ɾ�������ݿ��н��޴�����¼��");
		this.helpTextArea.setEditable(false);
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);//����TextArea�е��ı��Զ�����
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("ɾ������������", this.helpPanel);
	}
	/**
	 * 
	* �������
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
					IOrgTypeDAO orgTypeDAO = new OrgTypeDAOImp();
					boolean flag = orgTypeDAO.remove(id);
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
