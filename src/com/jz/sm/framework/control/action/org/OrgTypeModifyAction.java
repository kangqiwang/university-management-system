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
* 类的描述
* @author 田芬芬
* @date 2015年5月3日 下午14:19:51
* @Description  当修改机构类别功能按钮被点击,按钮右边的面板会出现相关的操作界面
 */
public class OrgTypeModifyAction implements ActionFunction, ActionListener {
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"机构类别代号","机构类别名称","机构类别描述"};
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
	  *@Description  将数据库shoolmis_new中org表中
	  *            所有记录,转为Org对象实例,再将对应的属性值存到二维数组中
	  *				，返回二维数组
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
		this.modifyButton = new JButton("修  改");
		this.modifyButton.addActionListener(this);
		this.refreshButton = new JButton("刷  新");
		this.refreshButton.addActionListener(this);
		buttonPanel.add(this.modifyButton);
		buttonPanel.add(this.refreshButton);
		this.bodyPanel.add(buttonPanel,BorderLayout.SOUTH);
		this.contentTabbedPane.add("修改机构类别",this.bodyPanel);
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
		this.helpTextArea.setText("        机构类别信息的修改中：必须选中一条数据后再单击修改，若修改成功则会弹出修改成功的消息，相应的页面会刷新，数据库中的记录也会修改。此外，当修改页面没有被关闭时，仍然可以打击还原来还原记录。");
		this.helpTextArea.setEditable(false);
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("修改机构类别帮助", this.helpPanel);
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
		private OrgTypeModifyAction modifyAction = null;//OrgTypeModifyAction类的对象
		private OrgType orgType = null;//orgType对象实例
		private JLabel orgTypeIdLable  = null;//机构类别编号
		private JTextField orgTypeIdField = null;
		private JLabel orgTypeNameLable = null;//机构类别名称
		private JTextField orgTypeNameField = null;
		private JLabel orgTypeMemoLable= null;//机构类别备注
		private JTextArea orgTypeMemoArea = null;
		private JScrollPane memoScrollPane = null;
		private JButton saveButton = null;//保存按钮
		private JButton restoreButton = null;//还原按钮
		/**
		 * 
		  * 方法注释
		  *@return 一个OrgType对象实例
		  *@author 田芬芬
		  *@Time 2015年5月3日下午15:35:16
		  *@Description  用id作为查询条件,查询数据库中的记录,最后在该层得到与之对应的OrgType对象实例
		 */
		private OrgType getOrgType(String id) {
			OrgType orgType = null;
			IOrgTypeDAO orgTypeDAO = new OrgTypeDAOImp();
			orgType = orgTypeDAO.findById(id);
			return orgType;
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
			
			this.orgTypeIdLable = new JLabel("机构类别代号：",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 0;
			container.add(this.orgTypeIdLable,gbc);
			
			this.orgTypeIdField = new JTextField(20);
			this.orgTypeIdField.setText(this.orgType.getOrgTypeId());
			this.orgTypeIdField.setEditable(false);//因为不能修改代号，所以将其致灰
			gbc.gridx = 1;
			gbc.gridy = 0;
			container.add(this.orgTypeIdField,gbc);
			
			this.orgTypeNameLable = new JLabel("机构类别名称：",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 1;
			container.add(this.orgTypeNameLable,gbc);
			
			this.orgTypeNameField = new JTextField(20);
			this.orgTypeNameField.setText(this.orgType.getOrgTypeName());
			gbc.gridx = 1;
			gbc.gridy = 1;
			container.add(this.orgTypeNameField,gbc);
			
			this.orgTypeMemoLable = new JLabel("机构类别描述：",JLabel.RIGHT);
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
			this.saveButton = new JButton("保  存");
			this.saveButton.addActionListener(this);
			this.restoreButton = new JButton("还  原");
			this.restoreButton.addActionListener(this);
			buttonPanel.add(this.saveButton);
			buttonPanel.add(this.restoreButton);
			gbc.gridx = 1;
			gbc.gridy = 3;
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
		public ModifyDialog(OrgTypeModifyAction modifyAction,String id) {
			this.modifyAction = modifyAction;
			this.orgType = this.getOrgType(id);
			this.init();
		}
		/**
		 * 
		* 监听方法的描述
		* @author 田芬芬
		* @date 2015年5月3日 下午15:40:51
		* @Description  如果修改界面上的保存按钮被点击，将在此面板用户修改后的数据,转为OrgType实例,传到dao，
		*               最后存到数据库orgType表中；反之,如果还原按钮被点击，则会将修改前的数据恢复
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
					JOptionPane.showMessageDialog(this, "修改成功");
					this.modifyAction.refreshTable();
				} else {
					JOptionPane.showMessageDialog(this, "修改失败");
				}
			} else if(e.getSource() == this.restoreButton) {
				this.orgTypeNameField.setText(this.orgType.getOrgTypeName());
				this.orgTypeMemoArea.setText(this.orgType.getOrgTypeMemo());
			}
		}
		
	} 

}
