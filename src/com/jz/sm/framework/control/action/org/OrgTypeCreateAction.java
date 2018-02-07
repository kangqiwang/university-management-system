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
* �������
* @Description  �����ӻ�������ܰ�ť�����,��ť�ұߵ����������صĲ�������
 */
public class OrgTypeCreateAction implements ActionFunction,ActionListener{

	private JTabbedPane tabbedPane = null;
	private JPanel addorgTypePanel = null;//���ӻ���������
	private JPanel addorgTypeHelpPanel = null;//���ӻ������������
	private JLabel orgTypeIdLabel = null;//���������
	private JTextField orgTypeIdField = null;
	private JLabel orgTypeNameLabel = null;//�����������
	private JTextField orgTypeNameField = null;
	private JLabel orgTypeMemoLabel = null;//�������ע
	
	private JTextArea orgTypeMemoArea = null;
	private JButton addOrgTypeButton = null;//���Ӱ�ť
	private JButton clearButton = null;//��հ�ť
	private JTextArea helpTextArea = null;
	/**
	 * 
	* �������
	* @Description �ô����Ĳ�����workPanel�����ʼ��,����һ���й����ӻ��������Ϣ�����
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
		this.orgTypeIdLabel = new JLabel("���������ţ�",JLabel.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.addorgTypePanel.add(this.orgTypeIdLabel,gbc);
		
		this.orgTypeIdField = new JTextField(40);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.addorgTypePanel.add(this.orgTypeIdField,gbc);
		
		this.orgTypeNameLabel = new JLabel("����������ƣ�",JLabel.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.addorgTypePanel.add(this.orgTypeNameLabel,gbc);
		
		this.orgTypeNameField = new JTextField(40);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.addorgTypePanel.add(this.orgTypeNameField,gbc);
		
		this.orgTypeMemoLabel = new JLabel("�������ע��",JLabel.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.addorgTypePanel.add(this.orgTypeMemoLabel,gbc);
		
		this.orgTypeMemoArea = new JTextArea(10,40);
		JScrollPane scrollPane = new JScrollPane(this.orgTypeMemoArea);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.addorgTypePanel.add(scrollPane,gbc);
		
		JPanel buttonPanel = new JPanel();
		this.addOrgTypeButton = new JButton("��  ��");
		this.addOrgTypeButton.addActionListener(this);
		this.clearButton = new JButton("��  ��");
		this.clearButton.addActionListener(this);
		buttonPanel.add(this.addOrgTypeButton);
		buttonPanel.add(this.clearButton);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.addorgTypePanel.add(buttonPanel,gbc);
		
		this.tabbedPane.add("���ӻ������",this.addorgTypePanel);
		
		this.addorgTypeHelpPanel = new JPanel();
		this.addorgTypeHelpPanel.setBackground(colorSet.getWhite());
		this.addorgTypeHelpPanel.setLayout(new GridBagLayout());
		this.helpTextArea = new JTextArea(10,30);
		this.helpTextArea.setText("        ���ӻ�������У����������ţ�����������ƺͻ�������������Ϊ���������ͨ��������ӽ��������������ݿ��У�����ͨ�������ջص���ʼ״̬��");
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);
		JScrollPane scrollPane2 = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.addorgTypeHelpPanel.add(scrollPane2,gbc);
		this.tabbedPane.add("���ӻ���������",this.addorgTypeHelpPanel);
		workPanel.add(this.tabbedPane,BorderLayout.CENTER);
	}
	/**
	 * 
	* �������
	* @Description  ������Ӱ�ť����������ڴ�����û����������,����dao�㣬
	*             ���浽���ݿ�orgType���У���֮,�����հ�ť���������������ϵ�����ָ�����̬
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
						JOptionPane.showMessageDialog(null, "�����ɹ�");
					} else {
						JOptionPane.showMessageDialog(null, "�������ɹ�");
					}
				} else {
					JOptionPane.showMessageDialog(null, "�������ţ���𣬻���������Ϊ��");
					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, "�������ţ���𣬻���������Ϊ��");
				return;
			}
			
		} else if(e.getSource() == this.clearButton) {
			this.orgTypeIdField.setText("");
			this.orgTypeNameField.setText("");
			this.orgTypeMemoArea.setText("");
		}
		
	}
	

}
