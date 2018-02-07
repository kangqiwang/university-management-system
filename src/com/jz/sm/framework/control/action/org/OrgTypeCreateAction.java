package com.jz.sm.framework.control.action.org;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jz.sm.framework.model.dao.impl.IOrgTypeDAO;
import com.jz.sm.framework.model.dao.impl.OrgTypeDAOImp;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.OrgType;
/**
 * 
* 类的描述
* @Description  当增加机构类别功能按钮被点击,按钮右边的面板会出现相关的操作界面
 */
public class OrgTypeCreateAction implements ActionFunction,ActionListener{

	private JTabbedPane tabbedPane = null;
	private JPanel addorgTypePanel = null;//增加机构类别面板
	private JPanel addorgTypeHelpPanel = null;//增加机构类别帮助面板
	private JLabel orgTypeIdLabel = null;//机构类别编号
	private JTextField orgTypeIdField = null;
	private JLabel orgTypeNameLabel = null;//机构类别名称
	private JTextField orgTypeNameField = null;
	private JLabel orgTypeMemoLabel = null;//机构类别备注
	
	private JTextArea orgTypeMemoArea = null;
	private JButton addOrgTypeButton = null;//增加按钮
	private JButton clearButton = null;//清空按钮
	private JTextArea helpTextArea = null;
	/**
	 * 
	* 类的描述
	* @Description 用传来的参数对workPanel对象初始化,创建一个有关增加机构类别信息的面板
	 */
	@Override
	public void execute(JPanel workPanel,JPanel leftPanel,MisUser loginUser) {
		ColorSet colorSet = new ColorSet();
		workPanel.removeAll();
		workPanel.repaint();
		workPanel.setLayout(new BorderLayout());
		this.tabbedPane = new JTabbedPane();
		this.tabbedPane.setBackground(colorSet.getWhite());
		this.addorgTypePanel = new JPanel();
		this.addorgTypePanel.setBackground(colorSet.getWhite());
		this.addorgTypePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.orgTypeIdLabel = new JLabel("机构类别代号：",JLabel.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.addorgTypePanel.add(this.orgTypeIdLabel,gbc);
		
		this.orgTypeIdField = new JTextField(40);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.addorgTypePanel.add(this.orgTypeIdField,gbc);
		
		this.orgTypeNameLabel = new JLabel("机构类别名称：",JLabel.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.addorgTypePanel.add(this.orgTypeNameLabel,gbc);
		
		this.orgTypeNameField = new JTextField(40);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.addorgTypePanel.add(this.orgTypeNameField,gbc);
		
		this.orgTypeMemoLabel = new JLabel("机构类别备注：",JLabel.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.addorgTypePanel.add(this.orgTypeMemoLabel,gbc);
		
		this.orgTypeMemoArea = new JTextArea(10,40);
		JScrollPane scrollPane = new JScrollPane(this.orgTypeMemoArea);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.addorgTypePanel.add(scrollPane,gbc);
		
		JPanel buttonPanel = new JPanel();
		this.addOrgTypeButton = new JButton("增  加");
		this.addOrgTypeButton.addActionListener(this);
		this.clearButton = new JButton("清  空");
		this.clearButton.addActionListener(this);
		buttonPanel.add(this.addOrgTypeButton);
		buttonPanel.add(this.clearButton);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.addorgTypePanel.add(buttonPanel,gbc);
		
		this.tabbedPane.add("增加机构类别",this.addorgTypePanel);
		
		this.addorgTypeHelpPanel = new JPanel();
		this.addorgTypeHelpPanel.setBackground(colorSet.getWhite());
		this.addorgTypeHelpPanel.setLayout(new GridBagLayout());
		this.helpTextArea = new JTextArea(10,30);
		this.helpTextArea.setText("        增加机构类别中：机构类别代号，机构类别名称和机构类别的描述均为必填项，可以通过点击增加将机构类别加入数据库中，可以通过点击清空回到初始状态。");
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);
		JScrollPane scrollPane2 = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.addorgTypeHelpPanel.add(scrollPane2,gbc);
		this.tabbedPane.add("增加机构类别帮助",this.addorgTypeHelpPanel);
		workPanel.add(this.tabbedPane,BorderLayout.CENTER);
	}
	/**
	 * 
	* 类的描述
	* @Description  如果增加按钮被点击，将在此面板用户输入的数据,传到dao层，
	*             最后存到数据库orgType表中；反之,如果清空按钮被点击，则让面板上的组件恢复到初态
	*             
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.addOrgTypeButton) {
			String id = this.orgTypeIdField.getText();
			String name = this.orgTypeNameField.getText();
			String memo = this.orgTypeMemoArea.getText();
			if(id != null && name != null && memo != null) {
				if(id.length() > 0 && name.length() > 0 && memo.length() > 0) {
					OrgType orgType = new OrgType(id, name, memo);
					IOrgTypeDAO orgTypeDAO = new OrgTypeDAOImp();
					boolean flag = orgTypeDAO.add(orgType);
					if(flag) {
						JOptionPane.showMessageDialog(null, "新增成功");
					} else {
						JOptionPane.showMessageDialog(null, "新增不成功");
					}
				} else {
					JOptionPane.showMessageDialog(null, "机构代号，类别，或描述不能为空");
					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, "机构代号，类别，或描述不能为空");
				return;
			}
			
		} else if(e.getSource() == this.clearButton) {
			this.orgTypeIdField.setText("");
			this.orgTypeNameField.setText("");
			this.orgTypeMemoArea.setText("");
		}
		
	}
	

}
