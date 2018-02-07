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
* 类的描述
* @Description  当查询机构类别功能按钮被点击,按钮右边的面板会出现相关的操作界面
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
	private String[] bodyTableColumns = {"机构类别代号","机构类别名称","机构类别描述"};
	private String[][] bodyTableRows = null;
	private JScrollPane scrollPane = null;
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
	  * 方法注释
	  *@Description 在bodyPanel面板上显示查询机构类别信息的相关组件
	 */
	private void createBodyPanel() {
		ColorSet colorSet = new ColorSet();
		this.bodyPanel = new JPanel(new BorderLayout());
		this.bodyPanel.setBackground(colorSet.getWhite());
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		northPanel.setBackground(colorSet.getWhite());
		this.orgTypeNameLable = new JLabel("机构类别名称：",JLabel.RIGHT);
		this.orgTypeNameField = new JTextField(20);
		this.findButton = new JButton("查  找");
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
		this.detailButton = new JButton("详  情");
		this.detailButton.addActionListener(this);
		southPanel.add(this.detailButton);
		this.bodyPanel.add(southPanel,BorderLayout.SOUTH);
		
		this.contentTabbedPane.add("查询机构类别", this.bodyPanel);
	}
	/**
	 * 
	  * 方法注释
	  *@return 无
	  *@Description  在helpPanel面板显示文本域
	 */
	private void createHelpPanel() {
		ColorSet colorSet = new ColorSet();
		this.helpPanel = new JPanel(new  GridBagLayout());
		this.helpPanel.setBackground(colorSet.getWhite());
		GridBagConstraints gbc = new GridBagConstraints();
		this.helpTextArea = new JTextArea(10, 30);
		this.helpTextArea.setText("        机构信息类别查询：当搜索目标不明确时，可以通过模糊查询搜素关键字的同义字提高搜索的精确性，"
				+ "同时，可以通过选择一条数据后点击详情而得到所选记录的详细信息。");
		this.helpTextArea.setEditable(false);
		//字体，风格，字号
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);//设置TextArea中的文本自动换行
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("查询机构类别帮助",this.helpPanel);
	}
	/**
	 * 
	* 监听方法的描述
	* @Description  把标签面板加到workPanel上
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
	* 监听方法的描述
	* @Description  如果查询界面上的查询按钮被点击，会将查询到的记录显示在workPanel面板上
	* 				如果选中了一行,并且点击了详情,会弹出另一个界面,显示该机构类别的详细信息
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
				detailDialog.setTitle("信息工程学院管理系统->详情");
				detailDialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "请选择一条记录");
				return;
			}
		}
	}
	/**
	 * 
	* 类的描述
	* @Description 是内部类 ，创建了一个显示某一个机构类别的详细信息的界面
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
		  * 方法注释
		  *@return 一个OrgType对象实例
		  *@Description  用id作为查询条件,查询数据库中的记录,最后在该层得到与之对应的OrgType对象实例
		 */
		private OrgType getOrgType(String id) {
			IOrgTypeDAO orgTypeDAO = new OrgTypeDAOImp();
			OrgType orgType = orgTypeDAO.findById(id);
			return orgType;
		}
		
		/**
		 * 
		  * 方法注释
		  *@return 无
		  *@Description  在container面板显示查询相关信息需要的组件
		 */
		private void init() {
			Container container = this.getContentPane();
			container.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			
			this.orgTypeIdLabel = new JLabel("机构类别代号：",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 0;
			container.add(this.orgTypeIdLabel,gbc);
			
			this.orgTypeIdTextField = new JTextField(20);
			this.orgTypeIdTextField.setText(this.orgType.getOrgTypeId());
			this.orgTypeIdTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 0;
			container.add(this.orgTypeIdTextField,gbc);
			
			this.orgTypeNameLabel = new JLabel("机构类别名称：",JLabel.RIGHT);
			gbc.gridx = 0;
			gbc.gridy = 1;
			container.add(this.orgTypeNameLabel,gbc);
			
			this.orgTypeNameTextField = new JTextField(20);
			this.orgTypeNameTextField.setText(this.orgType.getOrgTypeName());
			this.orgTypeNameTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 1;
			container.add(this.orgTypeNameTextField,gbc);
			
			this.orgTypeMemoLabel = new JLabel("机构类别描述：",JLabel.RIGHT);
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
			构造方法的描述
		* @Description  无
		 */
		public DetailDialog() {
			// TODO Auto-generated constructor stub
		}
		/**
		 * 
			构造方法的描述
		* @Description  用传来的参数对orgType的对象初始化
		 */
		public DetailDialog(String id) {
			this.orgType = this.getOrgType(id);
			this.init();
		}
		
	}

}
