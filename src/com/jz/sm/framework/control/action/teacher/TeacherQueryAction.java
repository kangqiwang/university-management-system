package com.jz.sm.framework.control.action.teacher;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.control.action.org.ColorSet;
import com.jz.sm.framework.control.action.org.OrgTypeModifyAction;
import com.jz.sm.framework.control.action.org.OrgTypeModifyAction.ModifyDialog;
import com.jz.sm.framework.control.action.org.OrgTypeQueryAction.DetailDialog;
import com.jz.sm.framework.model.dao.impl.IOrgTypeDAO;
import com.jz.sm.framework.model.dao.impl.ITeacherDAO;
import com.jz.sm.framework.model.dao.impl.OrgTypeDAOImp;
import com.jz.sm.framework.model.dao.impl.TeacherDAOImp;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.OrgType;
import com.jz.sm.framework.model.entity.Teacher;

public class TeacherQueryAction implements ActionFunction,ActionListener{
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"��ʦ���","��ʦ����","��ʦ�Ա�","��ʦ����","�γ̱��"};
	private String[][] bodyTableRows = null;
	private JScrollPane bodyScrollPane = null;
	private JLabel teacherNameLable = null;
	private JTextField teacherNameField = null;
	private JButton findButton = null;//��ѯ
	private JButton detailButton = null;//����
	private JTextArea helpTextArea = null;
	private void refreshTable() {
		this.bodyTable.removeAll();
		this.bodyTable.repaint();
		this.bodyTableRows = this.getAllData(new Teacher());
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
	private String[][] getAllData(Teacher teacher) {
		String[][] data = null;
		ITeacherDAO teacherDAO = new TeacherDAOImp();
		List<Teacher> list = teacherDAO.findByLike(teacher);
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
	  *@Time 2015��5��3������14:39:16
	  *@Description ��bodyPanel�������ʾ�޸Ļ��������Ϣ��������
	 */
	private void createBodyPanel() {
		ColorSet colorSet = new ColorSet();
		this.bodyPanel = new JPanel(new BorderLayout());
		this.bodyPanel.setBackground(colorSet.getWhite());
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		northPanel.setBackground(colorSet.getWhite());
		this.teacherNameLable = new JLabel("��ʦ������");
		this.teacherNameField = new JTextField(20);
		this.findButton = new JButton("����");
		this.findButton.addActionListener(this);
		northPanel.add(this.teacherNameLable);
		northPanel.add(this.teacherNameField);
		northPanel.add(this.findButton);
		this.bodyPanel.add(northPanel,BorderLayout.NORTH);
		
		this.bodyTableModel = new DefaultTableModel(this.getAllData(new Teacher()), this.bodyTableColumns);
		this.bodyTable = new JTable(bodyTableModel);
		this.bodyScrollPane = new JScrollPane(this.bodyTable);
		this.bodyPanel.add(this.bodyScrollPane,BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		southPanel.setBackground(colorSet.getWhite());
		this.detailButton = new JButton("��  ��");
		this.detailButton.addActionListener(this);
		southPanel.add(this.detailButton);
		this.bodyPanel.add(southPanel,BorderLayout.SOUTH);
		this.contentTabbedPane.add("��ѯ��ʦ��Ϣ ",this.bodyPanel);
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
		this.helpTextArea.setText("        ��ʦ��Ϣ���޸��У�����ѡ��һ�����ݺ��ٵ����޸ģ����޸ĳɹ���ᵯ���޸ĳɹ�����Ϣ����Ӧ��ҳ���ˢ�£����ݿ��еļ�¼Ҳ���޸ġ����⣬���޸�ҳ��û�б��ر�ʱ����Ȼ���Դ����ԭ����ԭ��¼��");
		this.helpTextArea.setEditable(false);
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("��ѯ��ʦ��Ϣ����", this.helpPanel);
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
		if(e.getSource() == this.findButton) {
			String name = this.teacherNameField.getText();
			this.bodyTable.removeAll();
			this.bodyTable.repaint();
			this.bodyTableRows = this.getAllData(new Teacher("", name, "", "", ""));
			this.bodyTableModel = new DefaultTableModel(this.bodyTableRows, this.bodyTableColumns);
			this.bodyTable.setModel(bodyTableModel);
		} else if(e.getSource() == this.detailButton) {
			int n = this.bodyTable.getSelectedRowCount();
			if(n == 1) {
				String id = this.bodyTableModel.getValueAt(this.bodyTable.getSelectedRow(), 0).toString();
				DetailDialog detailDialog = new DetailDialog(id);
				detailDialog.setSize(600, 550); 
				detailDialog.setLocationRelativeTo(null);
				ImageIcon icon = new ImageIcon("img/title.jpg");
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
	* @author ��ҷ�
	* @date 2015��5��3�� ����15:19:51
	* @Description ���ڲ��� ��ѡ��һ�в��ҵ�����޸İ�ť,�ᵯ����һ������,
	*             �����޸Ļ�����������Ϣ�����
	 */
		public class DetailDialog extends JDialog{
		private Teacher teacher = null;	
		
		private JLabel idLabel = null;//��ʦ���
		private JTextField idTextField = null;
		private JLabel nameLabel = null;//��ʦ����
		private JTextField nameTextField = null;
		private JLabel sexLabel = null;//��ʦ�Ա�
		private JTextField sexTextField = null;
		private JLabel ageLabel = null;//��ʦ����
		private JTextField ageTextField= null;
		private JLabel courseIdLabel = null;//�γ�ID
		private JTextField courseTextField = null;
		/**
		 * 
		  * ����ע��
		  *@return һ��OrgType����ʵ��
		  *@author ��ҷ�
		  *@Time 2015��5��3������15:35:16
		  *@Description  ��id��Ϊ��ѯ����,��ѯ���ݿ��еļ�¼,����ڸò�õ���֮��Ӧ��OrgType����ʵ��
		 */
		private Teacher getTeacher(String id) {
			Teacher teacher = null;
			ITeacherDAO teacherDAO = new TeacherDAOImp();
			List<Teacher> list = teacherDAO.findByLike(new Teacher(id, "", "", "", ""));
			teacher = list.get(0);
			return teacher;
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
			Container container = this.getContentPane();
			container.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			
			this.idLabel = new JLabel("��ʦ��ţ�");
			gbc.gridx = 0;
			gbc.gridy = 0;
			container.add(this.idLabel,gbc);
			
			this.idTextField = new JTextField(40);
			this.idTextField.setText(this.teacher.getId_teacher());
			this.idTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 0;
			container.add(this.idTextField,gbc);
			
			this.nameLabel = new JLabel("��ʦ������");
			gbc.gridx = 0;
			gbc.gridy = 1;
			container.add(this.nameLabel,gbc);
			
			this.nameTextField = new JTextField(40);
			this.nameTextField.setText(this.teacher.getTeacher_name());
			this.nameTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 1;
			container.add(this.nameTextField,gbc);
			
			this.sexLabel = new JLabel("��ʦ�Ա�");
			gbc.gridx = 0;
			gbc.gridy = 2;
			container.add(this.sexLabel,gbc);
			
			this.sexTextField = new JTextField(40);
			this.sexTextField.setText(this.teacher.getTeacher_sex());
			this.sexTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 2;
			container.add(this.sexTextField,gbc);
			
			this.ageLabel = new JLabel("��ʦ���䣺");
			gbc.gridx = 0;
			gbc.gridy = 3;
			container.add(this.ageLabel,gbc);
			
			this.ageTextField = new JTextField(40);
			this.ageTextField.setText(this.teacher.getTeacher_age());
			this.ageTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 3;
			container.add(this.ageTextField,gbc);
			
			this.courseIdLabel = new JLabel("�γ̱�ţ�");
			gbc.gridx = 0;
			gbc.gridy = 4;
			container.add(this.courseIdLabel,gbc);
			
			this.courseTextField = new JTextField(40);
			this.courseTextField.setText(this.teacher.getCourseId());
			this.courseTextField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 4;
			container.add(this.courseTextField,gbc);
			
		}		
		/**
		 * 
			���췽��������
		* @author ��ҷ�
		* @date 2015��5��3�� ����14:32:57
		* @Description  ��
		 */
		public DetailDialog() {
			// TODO Auto-generated constructor stub
		}
		/**
		 * 
			���췽��������
		* @author ��ҷ�
		* @date 2015��5��3�� ����14:33:57
		* @Description  �ô����Ĳ�����modifyAction�Ķ����ʼ��
		 */
		public DetailDialog(String id) {
			this.teacher = this.getTeacher(id);
			this.init();
		}
	} 
}
