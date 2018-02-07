package com.jz.sm.framework.view;

import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jz.sm.framework.model.dao.impl.IMisUserDAO;
import com.jz.sm.framework.model.dao.impl.MisUserDAOImp;
import com.jz.sm.framework.model.entity.MisUser;
/**
 * 
* �������
* @author �׺���
* @date 2015��4��27�� ����2:50:11
* @Description  �̳���JFrame,ʵ���˼���,�й�����½���������,���������
* 			        ��ҳ��ķ���,һϵ���й�ҵ���߼��ķ���
 */

public class LoginFrame  extends JFrame  implements ActionListener,KeyListener{
	private  JPanel bodyPanel=null;//����
	private JLabel  titleLabel=null;//��ʾ����ı�ǩ
	private JLabel userNameLabel=null;//��ʾ�û�������
	private JLabel passWordLabel=null;//��������
	private JTextField userNameTextField=null;
	private JPasswordField passwordField=null;
	private JButton loginButton=null;//��¼��ť
	private JButton  resetButton=null;//���ð�ť
	private MisUser  loginUser =null;//MisUser��Ķ���
	private String  lastLoginTime=null;//�û��ϴε�¼��ʱ��
	
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author �׺���
	  *@Time 2015��4��27������2:58:13
	  *@Description  �����û���¼��ҵ��
	 */
	private void login() {
		/*���ַ������������û������id��*/
		String  name=this.userNameTextField.getText();
		/*���ַ�������password�����û����������*/
		String password= new String(this.passwordField.getPassword()); 
		//�����¼ҵ������ȷ�����ֵ�½����
		if (name != null && password != null) {
			if (name.length() > 0 ) {
				if (password.length() > 0) {
					if (this.check(name, password)) {
						this.lastLoginTime=this.getLastLoginTime();
						MainFrame mainFrame=new MainFrame(this.loginUser,this.lastLoginTime);
						System.out.println(this.loginUser.getUserName());
						
						mainFrame.setSize(800, 600);
						mainFrame.setVisible(true);
						mainFrame.setResizable(false);
						CommonUse.setComponentBounts(mainFrame, 800, 600);
						this.dispose();
						this.saveLastLoginTime(this.loginUser);
					}else {
						JOptionPane.showMessageDialog(this, "�û������������!");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(this, "���벻��Ϊ��");
				}
			}else {
				JOptionPane.showMessageDialog(this, "�û�������Ϊ��");
				return;
			}
		}else {
			JOptionPane.showMessageDialog(this, "�û��������벻��Ϊ��!");
			return;
		}
	}
	
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author �׺���
	  *@Time 2015��4��27������2:58:13
	  *@Description  ����¼�û��ĵ�¼ʱ��ӽ������õ�,�����޸����ݿ���misUser��
	  *             lastLoginTime���ﵽ�滻��Ч��
	  *			   
	 */
	private void  saveLastLoginTime(MisUser misUser){
		
		//����һ�����ڶ��󣬽�����תΪ�ַ���
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate = sdf.format(d);
		misUser.setLastLoginTime(nowDate);
		//����dao���MisUserDAOImpʵ����ķ���
		IMisUserDAO misUserDAO = new MisUserDAOImp();
		misUserDAO.modify(misUser);
		
	}
	/**
	 * 
	  * ����ע��
	  *@return ���û����ϴε�¼ʱ��
	  *@author �׺���
	  *@Time 2015��4��27������2:59:13
	  *@Description  ����¼�û��ĵ�¼ʱ������ݿ�ȡ��,���ϴ���dao,
	  *             ����ֵ��ΪMisUser��lastLoginTime����ֵ
	  *			   
	 */
	private String getLastLoginTime(){
		String lastLoginTime = this.loginUser.getLastLoginTime();
		return lastLoginTime;
	}
	/**
	 * 
	  * ����ע��
	  *@return boolean
	  *@author �׺���
	  *@Time 2015��4��27������3:10:13
	  *@Description  ���û������id�����������ݿ��еĽ�����֤
	  *             
	  *			   
	 */
	public boolean check(String name ,String password){
		/*������Ϊ��֤����ɹ����ı�־*/
		boolean flag = false;
		MisUser temp = null;//����һ����ʱ���û�����
		IMisUserDAO misUserDAO = new MisUserDAOImp();
		temp=misUserDAO.findById(name);
		if (temp != null && password.equals(temp.getUserPwd())) {
			flag = true;
			this.loginUser = temp;//��temp�������ø��Ƹ�loginUser
		}
		
		return  flag;
	}
	/**
	 * 
	  * ����ע��
	  *@return boolean
	  *@author �׺���
	  *@Time 2015��4��27������3:12:13
	  *@Description  ����½ҳ��
	  *             
	  *			   
	 */
	
	private void init(){
		Container content=this.getContentPane();
		BorderLayout borderLayout=new BorderLayout();
		content.setLayout(borderLayout);
		//����һ����¼��壬�е�¼��ص����
		this.bodyPanel=new ImgLoginPanel();
		content.add(this.bodyPanel,BorderLayout.CENTER);
		this.titleLabel=new JLabel(new ImageIcon("img/font.jpg"));
		this.userNameLabel=new JLabel(new ImageIcon("img/ren1.jpg"), JLabel.RIGHT);
		this.userNameTextField=new JTextField();
		this.userNameTextField.setPreferredSize(new Dimension(170, 24));
		this.userNameTextField.addKeyListener(this);
		this.passWordLabel=new JLabel(new ImageIcon("img/pwd.jpg"), JLabel.CENTER);
		this.passwordField=new JPasswordField();
		this.passwordField.setPreferredSize(new Dimension(170, 24));
		this.passwordField.addKeyListener(this);
		this.loginButton=new JButton("��  ¼");
		this.loginButton.setPreferredSize(new Dimension(180, 26));
		this.loginButton.setBackground(new Color(124, 177, 212));
		this.loginButton.addActionListener(this);
		JPanel panel = new JPanel(new BorderLayout(20, 0));
		panel.add(loginButton,BorderLayout.CENTER);
		
		//����һ����ֱ�����box���ֹ���������3��ˮƽ
		Box box0 = Box.createVerticalBox();
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		Box box3 = Box.createHorizontalBox();
		
		//�ѵ�¼���������ڶ�Ӧ��ˮƽbox
		box1.add(this.userNameLabel);
		box1.add(this.userNameTextField);
		box2.add(this.passWordLabel);
		box2.add(this.passwordField);
		
		box3.add(Box.createHorizontalStrut(30));
		box3.add(panel);
		box0.add(Box.createVerticalStrut(160));
		box0.add(box1);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box2);
		box0.add(Box.createVerticalStrut(10));
		box0.add(box3);
		this.bodyPanel.add(box0);
		
		//���ô�����������
		ImageIcon icon=new ImageIcon("img/title.jpg");
		this.setIconImage(icon.getImage());
		this.setTitle("��Ϣ����ѧԺ����ϵͳ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * 
		���췽��������
	* @author �׺��� 
	* @date 2015��4��27�� ����3:15:57
	* @Description  ����˽�еĻ�ҳ�淽��
	 */
	public LoginFrame(){
		this.init();
	}
	/**
	 * @author �׺��� 
	* @date 2015��4��27�� ����3:15:57
	 * @Description ʵ�ּ����ӿڵķ���
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.loginButton) {
			this.login();
			
		}
		if (e.getSource()==this.resetButton) {
			this.userNameTextField.setText("");
			this.passwordField.setText("");
			
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	/**
	 * @author �׺��� 
	* @date 2015��4��27�� ����3:15:57
	 * @Description ʵ�ּ��̼����ӿڵķ���
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.login();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	
	
}
