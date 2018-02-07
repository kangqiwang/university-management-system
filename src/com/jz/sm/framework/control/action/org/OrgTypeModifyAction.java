package com.jz.sm.framework.control.action.org;

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

import com.jz.sm.framework.model.dao.impl.IOrgTypeDAO;
import com.jz.sm.framework.model.dao.impl.OrgTypeDAOImp;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.OrgType;

/**
 * 
* �������
* @author ��ҷ�
* @date 2015��5��3�� ����14:19:51
* @Description  ���޸Ļ�������ܰ�ť�����,��ť�ұߵ����������صĲ�������
 */
public class OrgTypeModifyAction implements ActionFunction, ActionListener {
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"����������","�����������","�����������"};
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
	  * ����ע��
	  *@return ������ݿ��¼�Ķ�ά����
	  *@author ��ҷ�
	  *@Time 2015��5��3������14:36:16
	  *@Description  �����ݿ�shoolmis_new��org����
	  *            ���м�¼,תΪOrg����ʵ��,�ٽ���Ӧ������ֵ�浽��ά������
	  *				�����ض�ά����
	 */
	private String[][] getAllData() {
		String[][] data = null;
		IOrgTypeDAO orgTypeDAO = new OrgTypeDAOImp();
		List<OrgType> list = orgTypeDAO.findByLike(new OrgType());
		data = new String[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			OrgType tempOrgType = list.get(i);
			data[i][0] = tempOrgType.getOrgTypeId();
			data[i][1] = tempOrgType.getOrgTypeName();
			data[i][2] = tempOrgType.getOrgTypeMemo();
		}
		return data;
	}
	/**
	 * 
	  * ����ע��
	  *@return ��
	  *@author ��ҷ�
	  *@Time 2015��5��3������14:39:16
	  *@Description ��bodyPanel�������ʾ�޸Ļ��������Ϣ��������
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
		this.modifyButton = new JButton("��  ��");
		this.modifyButton.addActionListener(this);
		this.refreshButton = new JButton("ˢ  ��");
		this.refreshButton.addActionListener(this);
		buttonPanel.add(this.modifyButton);
		buttonPanel.add(this.refreshButton);
		this.bodyPanel.add(buttonPanel,BorderLayout.SOUTH);
		this.contentTabbedPane.add("�޸Ļ������",this.bodyPanel);
	}
	/**
	 * 
	  * ����ע��
	  *@return ��
	  *@author ��ҷ�
	  *@Time 2015��5��3������15:16:16
	  *@Description  ��helpPanel�����ʾ�ı���
	 */
	private void createHelpPanel() {
		ColorSet colorSet = new ColorSet();
		this.helpPanel = new JPanel(new GridBagLayout());
		this.helpPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.helpTextArea = new JTextArea(10, 30);
		this.helpTextArea.setText("        ���������Ϣ���޸��У�����ѡ��һ�����ݺ��ٵ����޸ģ����޸ĳɹ���ᵯ���޸ĳɹ�����Ϣ����Ӧ��ҳ���ˢ�£����ݿ��еļ�¼Ҳ���޸ġ����⣬���޸�ҳ��û�б��ر�ʱ����Ȼ���Դ����ԭ����ԭ��¼��");
		this.helpTextArea.setEditable(false);
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("�޸Ļ���������", this.helpPanel);
	}
	/**
	 * 
	* ��������������
	* @author ��ҷ�
	* @date 2015��5��3�� ����15:17:51
	* @Description  �ѱ�ǩ���ӵ�workPanel��
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
	* ��������������
	* @author ��ҷ�
	* @date 2015��5��3�� ����15:18:51
	* @Description  ����޸Ľ����ϵı��水ť�����������ѡ����һ��,�ᵯ���޸ĵĽ���
	* 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.modifyButton) {
			/*����n���������ѡ�еĸ���*/
			int n = this.bodyTable.getSelectedRowCount();
			if(n == 1) {
				String id = this.bodyTableModel.getValueAt(this.bodyTable.getSelectedRow(), 0).toString();
				ModifyDialog modifyDialog = new ModifyDialog(this, id);
				modifyDialog.setSize( 600, 450);
				modifyDialog.setLocationRelativeTo(null);
				ImageIcon icon = new ImageIcon("img/title.jpg");
				modifyDialog.setIconImage(icon.getImage());
				modifyDialog.setTitle("��Ϣ����ѧԺ����ϵͳ->�޸Ļ������");
				modifyDialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "��ѡ��һ������");
			}
		} else if(e.getSource() == this.refreshButton) {
			this.refreshTable();
		}
	}
	/**
	 * 
	* �������
	* @author ��ҷ�
	* @date 2015��5��3�� ����15:19:51
	* @Description ���ڲ��� ��ѡ��һ�в��ҵ�����޸İ�ť,�ᵯ����һ������,
	*             �����޸Ļ�����������Ϣ�����
	 */
	public class ModifyDialog extends JDialog implements ActionListener {
		private OrgTypeModifyAction modifyAction = null;//OrgTypeModifyAction��Ķ���
		private OrgType orgType = null;//orgType����ʵ��
		private JLabel orgTypeIdLable  = null;//���������
		private JTextField orgTypeIdField = null;
		private JLabel orgTypeNameLable = null;//�����������
		private JTextField orgTypeNameField = null;
		private JLabel orgTypeMemoLable= null;//�������ע
		private JTextArea orgTypeMemoArea = null;
		private JScrollPane memoScrollPane = null;
		private JButton saveButton = null;//���水ť
		private JButton restoreButton = null;//��ԭ��ť
		/**
		 * 
		  * ����ע��
		  *@return һ��OrgType����ʵ��
		  *@author ��ҷ�
		  *@Time 2015��5��3������15:35:16
		  *@Description  ��id��Ϊ��ѯ����,��ѯ���ݿ��еļ�¼,����ڸò�õ���֮��Ӧ��OrgType����ʵ��
		 */
		private OrgType getOrgType(String id) {
			OrgType orgType = null;
			IOrgTypeDAO orgTypeDAO = new OrgTypeDAOImp();
			orgType = orgTypeDAO.findById(id);
			return orgType;
		}
		
		/**
		 * 
		  * ����ע��
		  *@return ��
		  *@author ��ҷ�
		  *@Time 2015��5��3������15:35:16
		  *@Description  ��container�����ʾ�޸������Ϣ�����
		 */
		
		private void init() {
			ColorSet colorSet=new ColorSet();
			Container container = this.getContentPane();
			container.setLayout(new GridBagLayout());
			container.setBackground(colorSet.getWhite());
			GridBagConstraints gbc = new GridBagConstraints();
			
			this.orgTypeIdLable = new JLabel("���������ţ�",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 0;
			container.add(this.orgTypeIdLable,gbc);
			
			this.orgTypeIdField = new JTextField(20);
			this.orgTypeIdField.setText(this.orgType.getOrgTypeId());
			this.orgTypeIdField.setEditable(false);//��Ϊ�����޸Ĵ��ţ����Խ����»�
			gbc.gridx = 1;
			gbc.gridy = 0;
			container.add(this.orgTypeIdField,gbc);
			
			this.orgTypeNameLable = new JLabel("����������ƣ�",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 1;
			container.add(this.orgTypeNameLable,gbc);
			
			this.orgTypeNameField = new JTextField(20);
			this.orgTypeNameField.setText(this.orgType.getOrgTypeName());
			gbc.gridx = 1;
			gbc.gridy = 1;
			container.add(this.orgTypeNameField,gbc);
			
			this.orgTypeMemoLable = new JLabel("�������������",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 2;
			container.add(this.orgTypeMemoLable,gbc);
			
			this.orgTypeMemoArea = new JTextArea(10, 20);
			this.orgTypeMemoArea.setText(this.orgType.getOrgTypeMemo());
			this.memoScrollPane = new JScrollPane(this.orgTypeMemoArea);
			gbc.gridx = 1;
			gbc.gridy = 2;
			container.add(this.memoScrollPane,gbc);
			
			JPanel buttonPanel = new JPanel();
			this.saveButton = new JButton("��  ��");
			this.saveButton.addActionListener(this);
			this.restoreButton = new JButton("��  ԭ");
			this.restoreButton.addActionListener(this);
			buttonPanel.add(this.saveButton);
			buttonPanel.add(this.restoreButton);
			gbc.gridx = 1;
			gbc.gridy = 3;
			container.add(buttonPanel,gbc);
			
			this.setTitle("�޸�");
		}
		/**
		 * 
			���췽��������
		* @author ��ҷ�
		* @date 2015��5��3�� ����14:32:57
		* @Description  ��
		 */
		public ModifyDialog() {
			// TODO Auto-generated constructor stub
		}
		/**
		 * 
			���췽��������
		* @author ��ҷ�
		* @date 2015��5��3�� ����14:33:57
		* @Description  �ô����Ĳ�����modifyAction�Ķ����ʼ��
		 */
		public ModifyDialog(OrgTypeModifyAction modifyAction,String id) {
			this.modifyAction = modifyAction;
			this.orgType = this.getOrgType(id);
			this.init();
		}
		/**
		 * 
		* ��������������
		* @author ��ҷ�
		* @date 2015��5��3�� ����15:40:51
		* @Description  ����޸Ľ����ϵı��水ť����������ڴ�����û��޸ĺ������,תΪOrgTypeʵ��,����dao��
		*               ���浽���ݿ�orgType���У���֮,�����ԭ��ť���������Ὣ�޸�ǰ�����ݻָ�
		*             
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == this.saveButton) {
				String id = this.orgTypeIdField.getText();
				String name = this.orgTypeNameField.getText();
				String memo = this.orgTypeMemoArea.getText();
				OrgType orgType = new OrgType(id, name, memo);
				IOrgTypeDAO orgTypeDAO = new OrgTypeDAOImp();
				boolean flag = orgTypeDAO.modify(orgType);
				if(flag) {
					JOptionPane.showMessageDialog(this, "�޸ĳɹ�");
					this.modifyAction.refreshTable();
				} else {
					JOptionPane.showMessageDialog(this, "�޸�ʧ��");
				}
			} else if(e.getSource() == this.restoreButton) {
				this.orgTypeNameField.setText(this.orgType.getOrgTypeName());
				this.orgTypeMemoArea.setText(this.orgType.getOrgTypeMemo());
			}
		}
		
	} 

}
