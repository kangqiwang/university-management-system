package com.jz.sm.framework.control.action.student;



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

import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.control.action.org.ColorSet;
import com.jz.sm.framework.model.dao.impl.IStudentDAO;
import com.jz.sm.framework.model.dao.impl.StudentDAOImpl;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.model.entity.Student;

public class StudentModifyAction implements ActionFunction, ActionListener {
	
	private JPanel workPanel = null;
	private JTabbedPane contentTabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	
	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private String[] bodyTableColumns = {"ѧ��", "ѧ������", "ѧ���Ա�", "��������", "�绰", "����", "��ѧʱ��", "ѧ������", "�༶���"};
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
	  *@Description  �����ݿ�shoolmis_new��student����
	  *            ���м�¼,תΪstudent����ʵ��,�ٽ���Ӧ������ֵ�浽��ά������
	  *				�����ض�ά����
	 */
	private String[][] getAllData() {
		String[][] rowsData = null;
		IStudentDAO studentDAO = new StudentDAOImpl();
		List<Student> list = studentDAO.findByLike(new Student());//ȫ��
		rowsData = new String[list.size()][9];
		for(int i = 0;i < list.size();i++) {
			rowsData[i][0] = list.get(i).getStudentId();
			rowsData[i][1] = list.get(i).getStudentName();
			rowsData[i][2] = list.get(i).getStudentSex();
			rowsData[i][3] = list.get(i).getStudentBirthday();
			rowsData[i][4] = list.get(i).getStudentTel();
			rowsData[i][5] = list.get(i).getStudentAddress();
			rowsData[i][6] = list.get(i).getStudentInDate();
			rowsData[i][7] = list.get(i).getStudentMemo();
			rowsData[i][8] = list.get(i).getClassId();
		}
		return rowsData;
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
		this.modifyButton = new JButton("�޸�");
		this.modifyButton.addActionListener(this);
		this.refreshButton = new JButton("ˢ��");
		this.refreshButton.addActionListener(this);
		buttonPanel.add(this.modifyButton);
		buttonPanel.add(this.refreshButton);
		this.bodyPanel.add(buttonPanel,BorderLayout.SOUTH);
		this.contentTabbedPane.add("�޸�ѧ����Ϣ",this.bodyPanel);
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
		this.helpTextArea.setText("        ѧ����Ϣ���޸��У�����ѡ��һ�����ݺ��ٵ����޸ģ����޸ĳɹ���ᵯ���޸ĳɹ�����Ϣ����Ӧ��ҳ���ˢ�£����ݿ��еļ�¼Ҳ���޸ġ����⣬���޸�ҳ��û�б��ر�ʱ����Ȼ���Դ����ԭ����ԭ��¼��");
		this.helpTextArea.setEditable(false);
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		gbc.gridx = 5;
		gbc.gridy = 10;
		this.helpPanel.add(scrollPane,gbc);
		this.contentTabbedPane.add("�޸�ѧ����Ϣ����", this.helpPanel);
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
		private StudentModifyAction modifyAction = null;//StudentModifyAction��Ķ���
		private Student student = null;//Student����ʵ��
		
		private JLabel studentIdLabel = null;
		private JTextField studentIdTextField = null;
		private JLabel studentNameLabel = null;
		private JTextField studentNameTextField = null;
		private JLabel studentSexLabel = null;
		private JTextField studentSexTextField = null;
		private JLabel studentBirthdayLabel = null;
		private JTextField studentBirthdayTextField = null;
		private JLabel studentTelLabel = null;
		private JTextField studentTelTextField = null;
		private JLabel studentAddressLabel = null;
		private JTextField studentAddressTextField = null;
		private JLabel studentInDateLabel = null;
		private JTextField studentInDateTextField = null;
		private JLabel classIdLabel = null;
		private JTextField classIdTextField = null;
		private JLabel studentMemoLabel = null;
		private JTextArea studentMemoArea = null;
		private JButton saveButton = null;//���水ť
		private JButton restoreButton = null;//��ԭ��ť
		/**
		 * 
		  * ����ע��
		  *@return һ��Student����ʵ��
		  *@author ��ҷ�
		  *@Time 2015��5��3������15:35:16
		  *@Description  ��id��Ϊ��ѯ����,��ѯ���ݿ��еļ�¼,����ڸò�õ���֮��Ӧ��OrgType����ʵ��
		 */
		private Student getStudent(String id) {
			Student student = null;
			IStudentDAO studentDAO = new StudentDAOImpl();
			student = studentDAO.findById(id);
			return student;
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
			
			this.studentIdLabel = new JLabel("ѧ�ţ�");
			gbc.gridx = 0;
			gbc.gridy = 0;
			container.add(this.studentIdLabel,gbc);
			
			this.studentIdTextField = new JTextField(20);
			this.studentIdTextField.setText(this.student.getStudentId());
			gbc.gridx = 1;
			gbc.gridy = 0;
			container.add(this.studentIdTextField,gbc);
			
			this.studentNameLabel = new JLabel("������");
			gbc.gridx = 0;
			gbc.gridy = 1;
			container.add(this.studentNameLabel,gbc);
			
			this.studentNameTextField = new JTextField(20);
			this.studentNameTextField.setText(this.student.getStudentName());
			gbc.gridx = 1;
			gbc.gridy = 1;
			container.add(this.studentNameTextField,gbc);
			
			this.studentSexLabel = new JLabel("�Ա�");
			gbc.gridx = 0;
			gbc.gridy = 2;
			container.add(this.studentSexLabel,gbc);
			
			this.studentSexTextField = new JTextField(20);
			this.studentSexTextField.setText(this.student.getStudentSex());
			gbc.gridx = 1;
			gbc.gridy = 2;
			container.add(this.studentSexTextField,gbc);
			
			this.studentBirthdayLabel = new JLabel("���գ�");
			gbc.gridx = 0;
			gbc.gridy = 3;
			container.add(this.studentBirthdayLabel,gbc);
			
			this.studentBirthdayTextField = new JTextField(20);
			this.studentBirthdayTextField.setText(this.student.getStudentBirthday());
			gbc.gridx = 1;
			gbc.gridy = 3;
			container.add(this.studentBirthdayTextField,gbc);
			
			this.studentTelLabel = new JLabel("�绰��");
			gbc.gridx = 0;
			gbc.gridy = 4;
			container.add(this.studentTelLabel,gbc);
			
			this.studentTelTextField = new JTextField(20);
			this.studentTelTextField.setText(this.student.getStudentTel());
			gbc.gridx = 1;
			gbc.gridy = 4;
			container.add(this.studentTelTextField,gbc);
			
			this.studentAddressLabel = new JLabel("���᣺");
			gbc.gridx = 0;
			gbc.gridy = 5;
			container.add(this.studentAddressLabel,gbc);
			
			this.studentAddressTextField = new JTextField(20);
			this.studentAddressTextField.setText(this.student.getStudentAddress());
			gbc.gridx = 1;
			gbc.gridy = 5;
			container.add(this.studentAddressTextField,gbc);
			
			this.studentInDateLabel = new JLabel("��ѧʱ�䣺");
			gbc.gridx = 0;
			gbc.gridy = 6;
			container.add(this.studentInDateLabel,gbc);
			
			this.studentInDateTextField = new JTextField(20);
			this.studentInDateTextField.setText(this.student.getStudentInDate());
			gbc.gridx = 1;
			gbc.gridy = 6;
			container.add(this.studentInDateTextField,gbc);
			
			this.classIdLabel = new JLabel("�༶��ţ�");
			gbc.gridx = 0;
			gbc.gridy = 7;
			container.add(this.classIdLabel,gbc);
			
			this.classIdTextField = new JTextField(20);
			this.classIdTextField.setText(this.student.getClassId());
			gbc.gridx = 1;
			gbc.gridy = 7;
			container.add(this.classIdTextField,gbc);
			
			this.studentMemoLabel = new JLabel("ѧ��������");
			gbc.gridx = 0;
			gbc.gridy = 8;
			container.add(this.studentMemoLabel,gbc);
			
			this.studentMemoArea = new JTextArea(10, 20);
			this.studentMemoArea.setText(this.student.getStudentMemo());
			JScrollPane scrollPane = new JScrollPane(this.studentMemoArea);
			gbc.gridx = 1;
			gbc.gridy = 8;
			container.add(scrollPane,gbc);
			
			JPanel buttonPanel = new JPanel();
			this.saveButton = new JButton("����");
			this.saveButton.addActionListener(this);
			this.restoreButton = new JButton("��ԭ");
			this.restoreButton.addActionListener(this);
			buttonPanel.add(this.saveButton);
			buttonPanel.add(this.restoreButton);
			gbc.gridx = 1;
			gbc.gridy = 9;
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
		public ModifyDialog(StudentModifyAction modifyAction,String id) {
			this.modifyAction = modifyAction;
			this.student = this.getStudent(id);
			this.init();
		}
		/**
		 * 
		* ��������������
		* @author ��ҷ�
		* @date 2015��5��3�� ����15:40:51
		* @Description  ����޸Ľ����ϵı��水ť����������ڴ�����û��޸ĺ������,תΪOrgTypeʵ��,����dao��
		*               ���浽���ݿ�student���У���֮,�����ԭ��ť���������Ὣ�޸�ǰ�����ݻָ�
		*             
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == this.saveButton) {
				String studentId = this.studentIdTextField.getText();
				String studentName = this.studentNameTextField.getText();
				String studentMemo = this.studentMemoArea.getText();
				String studentSex = this.studentSexTextField.getText();
				String studentBirthday = this.studentBirthdayTextField.getText();
				String studentTel = this.studentTelTextField.getText();
				String studentAddress = this.studentAddressTextField.getText();
				String studentInDate = this.studentInDateTextField.getText();
				String classId = this.classIdTextField.getText();
				
				Student student = new Student(studentId, studentName, studentSex, studentBirthday, studentTel, studentAddress, studentInDate, studentMemo, classId);
				IStudentDAO studentDAO = new StudentDAOImpl();
				boolean flag = studentDAO.modify(student);
				if(flag) {
					JOptionPane.showMessageDialog(this, "�޸ĳɹ�");
					this.modifyAction.refreshTable();
				} else {
					JOptionPane.showMessageDialog(this, "�޸�ʧ��");
				}
			} else if(e.getSource() == this.restoreButton) {
				this.studentNameTextField.setText("");
				this.studentMemoArea.setText("");
				this.studentSexTextField.setText("");
				this.studentBirthdayTextField.setText("");
				this.studentTelTextField.setText("");
				this.studentAddressTextField.setText("");
				this.studentInDateTextField.setText("");
				this.classIdTextField.setText("");
			}
		}
		
	}

}
