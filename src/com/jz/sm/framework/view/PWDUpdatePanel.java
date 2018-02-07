package com.jz.sm.framework.view ;

import java.awt.BorderLayout ;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


import com.jz.sm.framework.control.action.org.ColorSet;
import com.jz.sm.framework.model.dao.impl.IMisUserDAO;
import com.jz.sm.framework.model.dao.impl.MisUserDAOImp;
import com.jz.sm.framework.model.entity.MisUser;


/**
 * 
* �������
* @author �׺���
* @date 2015��4��28�� ����15:45:11
* @Description  �̳���JFrame,ʵ���˼���,�й�����½���������,���������
* 			        ��ҳ��ķ���,һϵ���й�ҵ���߼��ķ���,�����޸�����Ľ���
 */
public class PWDUpdatePanel extends JFrame implements ActionListener{
	
	private JLabel oldPWDLabel = null;//�������ǩ
	private JPasswordField oldPWDField = null;
	private JLabel newPWDLabel = null;//�������ǩ
	private JPasswordField newPWDField = null; 
	private JLabel renewPWDLabel = null;//ȷ��������
	private JPasswordField renewPWDField = null; 
	private JButton save = null;//���水ť
	private JButton reset = null;//���ð�ť
	private MisUser loginUser=null; //�û�����
	private JPanel centerPanel = null;
    private JPanel bottomPanel = null;
	
	/**
	 * 
	  * ����ע��
	  *@return boolean 	
	  *@author �׺���
	  *@Time 2015��4��28������15:50:13
	  *@Description  �޸ĵ�¼�û���misUserʵ��,��Ӧ���ݿ��޸�һ����¼
	 */
	private boolean updatePWD(MisUser misUser){
		boolean flag = false;
		IMisUserDAO temp = new MisUserDAOImp();
		flag = temp.modify(misUser);
		return flag;
	}

	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author �׺���
	  *@Time 2015��4��28������16:01:13
	  *@Description  ���޸������������
	 */
	
	private void init() {
		JPanel bodyPanel = (JPanel)this.getContentPane();
		bodyPanel.setLayout(new BorderLayout());
		ColorSet colorSet = new ColorSet();
		bodyPanel.setBackground(colorSet.getWhite());
		
		this.centerPanel = new JPanel();
    	this.bottomPanel = new JPanel();
    	this.bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20,10));
    	bodyPanel.add(this.centerPanel, BorderLayout.CENTER);
    	bodyPanel.add(this.bottomPanel, BorderLayout.SOUTH);
		

    	this.oldPWDLabel = new JLabel("��ǰ���룺",JLabel.RIGHT);
    	this.oldPWDLabel.setPreferredSize(new Dimension(80, 24));
    	this.newPWDLabel = new JLabel("�����룺", JLabel.RIGHT);
		this.newPWDLabel.setPreferredSize(new Dimension(80, 24));
		this.renewPWDLabel = new JLabel("ȷ�������룺", JLabel.RIGHT);
		this.renewPWDLabel.setPreferredSize(new Dimension(80, 24));		
		this.oldPWDField = new JPasswordField();
	    this.oldPWDField.setPreferredSize(new Dimension(160, 24));
		this.newPWDField = new JPasswordField();
		this.newPWDField.setPreferredSize(new Dimension(160, 24));
		this.renewPWDField = new JPasswordField();
		this.renewPWDField.setPreferredSize(new Dimension(160, 24));
		Box box0 = Box.createVerticalBox();
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		Box box3 = Box.createHorizontalBox();
		Box box4 = Box.createHorizontalBox();
		
		
		box1.add(this.oldPWDLabel);
		box1.add(this.oldPWDField);
		
		box2.add(this.newPWDLabel);
		box2.add(this.newPWDField);
		
		box3.add(this.renewPWDLabel);
		box3.add(this.renewPWDField);
		this.save = new  JButton("��   ��");
		this.save.addActionListener(this);
		box4.add(this.save);
		box0.add(Box.createVerticalStrut(80));
		box0.add(box1);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box2);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box3);
		box0.add(Box.createVerticalStrut(30));
		box0.add(box4);
		this.centerPanel.add(box0);
		ImageIcon icon = new ImageIcon("img/title.jpg");
		this.setIconImage(icon.getImage());
		this.setTitle("��Ϣ����ѧԺ����ϵͳ->�޸�����");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	/**
	 * 
		���췽��������
	* @author  �׺���
	* @date 2015��4��28������16:01:13
	* @Description ��loginUser���󴫲���,������,�����û�ҳ��ķ���
	 */
	public PWDUpdatePanel(MisUser loginUser) {
		this.loginUser = loginUser;
		this.init();
	}
	
	/**
	 * 
		���췽��������
	* @author ���ʵ�
	* @date 2015��4��28������16:10:13
	* @Description ʵ�ּ����߽ӿڵķ���
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*������ŵ�ǰ����*/
		String oldPassWord = new String(this.oldPWDField.getPassword());
		/*�������������*/
		String newPassWord = new String(this.newPWDField.getPassword());
		/*���������֤����*/
		String checkPassWord = new String(this.renewPWDField.getPassword());
		
		//���������޸�ҵ��
		if (oldPassWord != null&&newPassWord != null&&checkPassWord != null) {
			if (oldPassWord.length()>0) {
		
				if (newPassWord.length()>0&&checkPassWord.length()>0) {
					
					if (oldPassWord.equals(this.loginUser.getUserPwd())) {
						
						if (newPassWord.equals(checkPassWord)) {
							
							this.loginUser.setUserPwd(newPassWord);
							if (this.updatePWD(this.loginUser)) {
								JOptionPane.showMessageDialog(null, "�����޸ĳɹ�");
							}else {
								JOptionPane.showMessageDialog(null, "�����޸�ʧ��");
								return;
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "������������벻һ��");
							return;
						}
							
					}else {
						JOptionPane.showMessageDialog(null, "����������");
						this.oldPWDField.setText("");
						return;
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "���벻Ϊ�գ�");
					return;
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "�����������");
				return;
			}
		}else {
			return;
		}
		
		
		
	}
	
}
