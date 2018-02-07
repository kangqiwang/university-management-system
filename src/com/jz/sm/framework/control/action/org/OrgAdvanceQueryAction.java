

package com.jz.sm.framework.control.action.org;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.jz.sm.framework.model.dao.impl.IOrgDAO;
import com.jz.sm.framework.model.dao.impl.OrgDAOImpl;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.Org;
/**
 * 
* 类的描述
* @Description  当机构信息功能按钮被点击,按钮右边的面板会出现相关的操作界面
 */
public class OrgAdvanceQueryAction implements ActionFunction,ActionListener {
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	
	private JPanel bodyNorthPanel = null;
	private JLabel orgIdLabel = null;
	private JLabel orgTypeIdLabel = null;
	private JLabel orgNameLabel = null;
	private JTextField orgIdTextField = null;
	private JTextField orgTypeIdTextField = null;
	private JTextField orgNameTextField = null;
	private JLabel kongLabel = null;
	private JButton findButton = null;
	
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"机构代号","机构名称","机构描述","所属机构类别"};
	private String[][] bodyTableRows = null;
	private JScrollPane scrollPane = null;
	private JPanel southPanel = null;
	private JButton detailButton = null;
	
	private JTextArea helpTextArea = null;
	
	/**
	 * 
	  * 方法注释
	  *@return 存放数据库记录的二维数组
	  *@Description  将数据库shoolmis_new中org表中
	  *            所有记录,转为Org对象实例,再将对应的属性值存到二维数组中
	  *				，返回二维数组
	 */
	private String[][] getAllData(Org org) {
		String[][] data = null;
		IOrgDAO orgDAO = new OrgDAOImpl();
		List<Org> list = orgDAO.findByLike(org);
		data = new String[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			data[i][0] = list.get(i).getOrgId();
			data[i][1] = list.get(i).getOrgName();
			data[i][2] = list.get(i).getOrgName();
			data[i][3] = list.get(i).getOrgTypeId();
		}
		return data;
	}
	/**
	 * 
	  * 方法注释
	  *@Description 在bodyPanel面板上显示机构信息检索的相关组件
	 */
	private void createBodyPanel() {
		ColorSet colorSet = new ColorSet();
		this.bodyPanel = new JPanel(new BorderLayout());
		this.bodyPanel.setBackground(colorSet.getWhite());
		this.bodyNorthPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.bodyNorthPanel.setBackground(colorSet.getWhite());
		this.orgIdLabel = new JLabel("机构代号：",JLabel.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.bodyNorthPanel.add(this.orgIdLabel,gbc);
		
		this.orgIdTextField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.bodyNorthPanel.add(this.orgIdTextField,gbc);
		
		this.orgNameLabel = new JLabel("机构名称：",JLabel.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.bodyNorthPanel.add(this.orgNameLabel,gbc);
		
		this.orgNameTextField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.bodyNorthPanel.add(this.orgNameTextField,gbc);
		
		this.orgTypeIdLabel = new JLabel("机构类别代号：",JLabel.RIGHT) ;
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.bodyNorthPanel.add(this.orgTypeIdLabel,gbc);
		
		this.orgTypeIdTextField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.bodyNorthPanel.add(this.orgTypeIdTextField,gbc);
		
		this.kongLabel = new JLabel("     ");
		gbc.gridx = 2;
		gbc.gridy = 2;
		this.bodyNorthPanel.add(this.kongLabel,gbc);
		
		this.findButton = new JButton("查  询");
		this.findButton.addActionListener(this);
		gbc.gridx = 3;
		gbc.gridy = 2;
		this.bodyNorthPanel.add(this.findButton,gbc);
		
		this.bodyPanel.add(this.bodyNorthPanel,BorderLayout.NORTH);
		
		this.bodyTableRows = this.getAllData(new Org());
		this.bodyTableModel = new DefaultTableModel(this.bodyTableRows, this.bodyTableColumns);
		this.bodyTable = new JTable(this.bodyTableModel);
		this.scrollPane = new JScrollPane(this.bodyTable);
		this.bodyPanel.add(this.scrollPane,BorderLayout.CENTER);
		
		this.southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.southPanel.setBackground(colorSet.getWhite());
		this.detailButton = new JButton("详  情");
		this.detailButton.addActionListener(this);
		this.southPanel.add(this.detailButton);
		this.bodyPanel.add(this.southPanel,BorderLayout.SOUTH);
		
		this.contentTabbedPane.add("机构信息检索",this.bodyPanel);
	}
	/**
	 * 
	  * 方法注释
	  *@return 无
	  *@Description  在helpPanel面板显示文本域
	 */
	private void createHelpPanel() {
		ColorSet colorSet = new ColorSet();
		this.helpPanel = new JPanel(new GridBagLayout());
		this.helpPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.helpTextArea = new JTextArea(10, 30);
		this.helpTextArea.setText("        机构信息检索：当搜索目标不明确时，可以通过模糊查询搜素关键字的同义字提高搜索的精确性，"
				+ "同时，可以通过选择一条数据后点击详情而得到所选记录的详细信息。");
		this.helpTextArea.setEditable(false);
		//字体，风格，字号
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);//设置TextArea中的文本自动换行
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("机构信息检索帮助",this.helpPanel);
	}
	/**
	 * 
	* 类的描述
	* @Description 用传来的参数对workPanel对象，MisUser对象初始化,
	*             将创建好的标签面板,加到workPanel
	 */
	@Override
	public void execute(JPanel workPanel,JPanel leftPanel,MisUser loginUser) {
		this.workPanel = workPanel;
		this.workPanel.setLayout(new BorderLayout());
		
		this.contentTabbedPane = new JTabbedPane();
		this.createBodyPanel();
		this.createHelpPanel();
		this.workPanel.add(this.contentTabbedPane,BorderLayout.CENTER);
	}

	/**
	 * 
	  * 方法注释
	  *@Time 2015年5月2日上午10:30:13
	  *@Description  监听方法,当机构信息检索功能按钮被点击时,按钮右边区域
	  *            出现处理该功能的面板
	  *				
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.findButton) {
			String orgId = this.orgIdTextField.getText();
			String orgName = this.orgNameTextField.getText();
			String orgTypeId = this.orgTypeIdTextField.getText();
			this.bodyTableRows = this.getAllData(new Org(orgId, orgName, "", orgTypeId));
			this.bodyTableModel = new DefaultTableModel(this.bodyTableRows, this.bodyTableColumns);
			this.bodyTable.setModel(this.bodyTableModel);
		} else if(e.getSource() == this.detailButton) {
			int n = this.bodyTable.getSelectedRowCount();
			if(n == 1) {
				String orgId = this.bodyTableModel.getValueAt(this.bodyTable.getSelectedRow(), 0).toString();
				DetailDialog detailDialog = new DetailDialog(orgId);
				detailDialog.setBounds(100, 100, 600, 450);
				detailDialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "请选择一条数据");
				return;
			}
		}
	}
	
	public class DetailDialog extends JDialog {
		private Org org = null;
		private JPanel bodyPanel = null;
		private JLabel orgIdLabel = null;
		private JLabel orgNameLabel = null;
		private JLabel orgMemoLabel = null;
		private JLabel orgTypeIdLabel = null;
		private JTextField orgIdTextField = null;
		private JTextField orgNameTextField = null;
		private JTextArea orgMemoTextArea = null;
		private JTextField orgTypeIdTextField = null;
		
		private Org getOrg(Org org) {
			IOrgDAO orgDAO = new OrgDAOImpl();
			List<Org> list = orgDAO.findByLike(org);
			Org org2 = null;
			for (int i = 0; i < list.size(); i++) {
				org2 = list.get(i);
			}
			return org2;
		}
		private void init() {
			this.bodyPanel = (JPanel)this.getContentPane();
			this.bodyPanel.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			
			this.orgIdLabel = new JLabel("机构代号：",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.bodyPanel.add(this.orgIdLabel,gbc);
			
			this.orgIdTextField = new JTextField(20);
			this.orgIdTextField.setText(this.org.getOrgId());
			this.orgIdTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.bodyPanel.add(this.orgIdTextField,gbc);
			
			this.orgNameLabel = new JLabel("机构名称：",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 1;
			this.bodyPanel.add(this.orgNameLabel,gbc);
			
			this.orgNameTextField = new JTextField(20);
			this.orgNameTextField.setText(this.org.getOrgName());
			this.orgNameTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 1;
			this.bodyPanel.add(this.orgNameTextField,gbc);
			
			this.orgMemoLabel = new JLabel("机构描述：",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 2;
			this.bodyPanel.add(this.orgMemoLabel,gbc);
			
			this.orgMemoTextArea = new JTextArea(8, 20);
			this.orgMemoTextArea.setText(this.org.getOrgMemo());
			this.orgMemoTextArea.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 2;
			this.bodyPanel.add(this.orgMemoTextArea,gbc);
			
			this.orgTypeIdLabel = new JLabel("机构类别代号：",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 3;
			this.bodyPanel.add(this.orgTypeIdLabel,gbc);
			
			this.orgTypeIdTextField = new JTextField(20);
			this.orgTypeIdTextField.setText(this.org.getOrgTypeId());
			this.orgTypeIdTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 3;
			this.bodyPanel.add(this.orgTypeIdTextField,gbc);
			
			this.setTitle("机构信息检索详情");
		}
		/**
		* 
		*     构造方法的描述
		* @Description  无
		*/
		
		public DetailDialog() {
			// TODO Auto-generated constructor stub
		}
		/**
		* 
		*     构造方法的描述
		* @Description  用传来的参数对org对象初始化,调用init方法
		*/
		
		public DetailDialog(String id) {
			this.org = this.getOrg(new Org(id, "", "", ""));
			this.init();
		}
	}

	
}
