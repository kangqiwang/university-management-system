package com.jz.sm.framework.control.action.org;

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

import com.jz.sm.framework.model.dao.impl.IOrgTypeDAO;
import com.jz.sm.framework.model.dao.impl.OrgTypeDAOImp;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.OrgType;

/**
 * 
* �������
* @Description  ����ѯ��������ܰ�ť�����,��ť�ұߵ����������صĲ�������
 */
public class OrgTypeQueryAction implements ActionFunction,ActionListener{
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	private JLabel orgTypeNameLable = null;
	private JTextField orgTypeNameField = null;
	private JButton findButton = null;
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"����������","�����������","�����������"};
	private String[][] bodyTableRows = null;
	private JScrollPane scrollPane = null;
	private JButton detailButton = null;
	private JTextArea helpTextArea = null;
	/**
	 * 
	  * ����ע��
	  *@return ������ݿ��¼�Ķ�ά����
	  *@Description  �����ݿ�shoolmis_new��org����
	  *            ���м�¼,תΪOrg����ʵ��,�ٽ���Ӧ������ֵ�浽��ά������
	  *				�����ض�ά����
	 */
	private String[][] getAllData(OrgType orgType) {
		String[][] data = null;
		IOrgTypeDAO orgTypeDAO = new OrgTypeDAOImp();
		List<OrgType> list = orgTypeDAO.findByLike(orgType);
		data = new String[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			data[i][0] = list.get(i).getOrgTypeId();
			data[i][1] = list.get(i).getOrgTypeName();
			data[i][2] = list.get(i).getOrgTypeMemo();
		}
		return data;
	}
	/**
	 * 
	  * ����ע��
	  *@Description ��bodyPanel�������ʾ��ѯ���������Ϣ��������
	 */
	private void createBodyPanel() {
		ColorSet colorSet = new ColorSet();
		this.bodyPanel = new JPanel(new BorderLayout());
		this.bodyPanel.setBackground(colorSet.getWhite());
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		northPanel.setBackground(colorSet.getWhite());
		this.orgTypeNameLable = new JLabel("����������ƣ�",JLabel.RIGHT);
		this.orgTypeNameField = new JTextField(20);
		this.findButton = new JButton("��  ��");
		this.findButton.addActionListener(this);
		northPanel.add(this.orgTypeNameLable);
		northPanel.add(this.orgTypeNameField);
		northPanel.add(this.findButton);
		this.bodyPanel.add(northPanel,BorderLayout.NORTH);
		
		this.bodyTableRows = this.getAllData(new OrgType());
		this.bodyTableModel = new DefaultTableModel(this.bodyTableRows, this.bodyTableColumns);
		this.bodyTable = new JTable(bodyTableModel);
		this.scrollPane = new JScrollPane(this.bodyTable);
		this.bodyPanel.add(this.scrollPane,BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		southPanel.setBackground(colorSet.getWhite());
		this.detailButton = new JButton("��  ��");
		this.detailButton.addActionListener(this);
		southPanel.add(this.detailButton);
		this.bodyPanel.add(southPanel,BorderLayout.SOUTH);
		
		this.contentTabbedPane.add("��ѯ�������", this.bodyPanel);
	}
	/**
	 * 
	  * ����ע��
	  *@return ��
	  *@Description  ��helpPanel�����ʾ�ı���
	 */
	private void createHelpPanel() {
		ColorSet colorSet = new ColorSet();
		this.helpPanel = new JPanel(new  GridBagLayout());
		this.helpPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.helpTextArea = new JTextArea(10, 30);
		this.helpTextArea.setText("        ������Ϣ����ѯ��������Ŀ�겻��ȷʱ������ͨ��ģ����ѯ���عؼ��ֵ�ͬ������������ľ�ȷ�ԣ�"
				+ "ͬʱ������ͨ��ѡ��һ�����ݺ���������õ���ѡ��¼����ϸ��Ϣ��");
		this.helpTextArea.setEditable(false);
		//���壬����ֺ�
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);//����TextArea�е��ı��Զ�����
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("��ѯ����������",this.helpPanel);
	}
	/**
	 * 
	* ��������������
	* @Description  �ѱ�ǩ���ӵ�workPanel��
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
	* ��������������
	* @Description  �����ѯ�����ϵĲ�ѯ��ť��������Ὣ��ѯ���ļ�¼��ʾ��workPanel�����
	* 				���ѡ����һ��,���ҵ��������,�ᵯ����һ������,��ʾ�û���������ϸ��Ϣ
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.findButton) {
			String name = this.orgTypeNameField.getText();
			this.bodyTable.removeAll();
			this.bodyTable.repaint();
			this.bodyTableRows = this.getAllData(new OrgType("", name, ""));
			this.bodyTableModel = new DefaultTableModel(this.bodyTableRows, this.bodyTableColumns);
			this.bodyTable.setModel(bodyTableModel);
		} else if(e.getSource() == this.detailButton) {
			int n = this.bodyTable.getSelectedRowCount();
			if(n == 1) {
				String id = this.bodyTableModel.getValueAt(this.bodyTable.getSelectedRow(), 0).toString();
				DetailDialog detailDialog = new DetailDialog(id);
				detailDialog.setSize(600, 550); 
				detailDialog.setLocationRelativeTo(null);
				ImageIcon icon=new ImageIcon("img/title.jpg");
				detailDialog.setIconImage(icon.getImage());
				detailDialog.setTitle("��Ϣ����ѧԺ����ϵͳ->����");
				detailDialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "��ѡ��һ����¼");
				return;
			}
		}
	}
	/**
	 * 
	* �������
	* @Description ���ڲ��� ��������һ����ʾĳһ������������ϸ��Ϣ�Ľ���
	*      
	 */
	public class DetailDialog extends JDialog{
		private OrgType orgType = null;
		
		private JLabel orgTypeIdLabel = null;
		private JTextField orgTypeIdTextField = null;
		private JLabel orgTypeNameLabel = null;
		private JTextField orgTypeNameTextField = null;
		private JLabel orgTypeMemoLabel = null;
		private JTextArea orgTypeMemoArea = null;
		/**
		 * 
		  * ����ע��
		  *@return һ��OrgType����ʵ��
		  *@Description  ��id��Ϊ��ѯ����,��ѯ���ݿ��еļ�¼,����ڸò�õ���֮��Ӧ��OrgType����ʵ��
		 */
		private OrgType getOrgType(String id) {
			IOrgTypeDAO orgTypeDAO = new OrgTypeDAOImp();
			OrgType orgType = orgTypeDAO.findById(id);
			return orgType;
		}
		
		/**
		 * 
		  * ����ע��
		  *@return ��
		  *@Description  ��container�����ʾ��ѯ�����Ϣ��Ҫ�����
		 */
		private void init() {
			Container container = this.getContentPane();
			container.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			
			this.orgTypeIdLabel = new JLabel("���������ţ�",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 0;
			container.add(this.orgTypeIdLabel,gbc);
			
			this.orgTypeIdTextField = new JTextField(20);
			this.orgTypeIdTextField.setText(this.orgType.getOrgTypeId());
			this.orgTypeIdTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 0;
			container.add(this.orgTypeIdTextField,gbc);
			
			this.orgTypeNameLabel = new JLabel("����������ƣ�",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 1;
			container.add(this.orgTypeNameLabel,gbc);
			
			this.orgTypeNameTextField = new JTextField(20);
			this.orgTypeNameTextField.setText(this.orgType.getOrgTypeName());
			this.orgTypeNameTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 1;
			container.add(this.orgTypeNameTextField,gbc);
			
			this.orgTypeMemoLabel = new JLabel("�������������",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 2;
			container.add(this.orgTypeMemoLabel,gbc);
			
			this.orgTypeMemoArea = new JTextArea(10, 20);
			this.orgTypeMemoArea.setText(this.orgType.getOrgTypeMemo());
			this.orgTypeMemoArea.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(this.orgTypeMemoArea);
			gbc.gridx = 1;
			gbc.gridy = 2;
			container.add(scrollPane,gbc);
		}
		/**
		 * 
			���췽��������
		* @Description  ��
		 */
		public DetailDialog() {
			// TODO Auto-generated constructor stub
		}
		/**
		 * 
			���췽��������
		* @Description  �ô����Ĳ�����orgType�Ķ����ʼ��
		 */
		public DetailDialog(String id) {
			this.orgType = this.getOrgType(id);
			this.init();
		}
		
	}

}
