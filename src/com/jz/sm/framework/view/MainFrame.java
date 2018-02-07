package com.jz.sm.framework.view;

import java.awt.BorderLayout; 
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import com.jz.sm.framework.control.action.org.ColorSet;
import com.jz.sm.framework.control.listener.ItemListener;
import com.jz.sm.framework.model.dao.impl.IMenuDAO;
import com.jz.sm.framework.model.dao.impl.IMisUserDAO;
import com.jz.sm.framework.model.dao.impl.MenuBeanDAOImp;
import com.jz.sm.framework.model.dao.impl.MisUserDAOImp;
import com.jz.sm.framework.model.entity.MenuBean;
import com.jz.sm.framework.model.entity.MisUser;

/**
 * 
* �������
* @author ���ʵ�
* @date 2015��4��28�� ����3:18:06
* @Description   �̳���JFrame,ʵ���˼���,�й�����½���������,���������
* 			        ��ҳ��ķ���,һϵ���й�ҵ���߼��ķ���
 */
public class MainFrame  extends JFrame implements ActionListener{
	private  JPanel bodyPanel = null;
	private JPanel northPanel = null;
	private JPanel welcomePanel = null;
	private JPanel leftPanel = null;
	private JPanel southPanel = null;
	private Thread thread=null;//�̶߳���
	private JMenuBar menuBar = null;//�˵�����
	private JMenu helpMenu = null;//��ʾ�����˵�
	private JMenuItem helpContentItem = null;//�Ӳ˵�����
	private JMenuItem helpAboutItem = null; 
	private JToolBar infoToolBar = null;
	private JLabel userNameLabel = null;
	private JLabel userNameTextLabel = null;
	private JButton exitButton = null;//�˳�ϵͳ
	private JButton reLogoButton = null;//�޸�����
	private  JLabel stateLabel = null;
	private JButton  updatePWDButton = null;
	private JButton  resetButton = null;
	private MisUser loginUser = null;
	private JLabel welcomeLabel = null;
	private JLabel timeLabel = null;
	private JLabel Label = null;
	private JPanel body = null;

	private String lastLoginTime = null;
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��28������3:20:13
	  *@Description  ͨ�����ڲ���������̵߳ķ���,��̬���ڽ�������ʾʱ��
	 */
	private void   getDate(){
		thread = new Thread(){
			public void run(){
				while (true) {				
					Date d = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String str = sdf.format(d);
					timeLabel.setText(str);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
				}
			}
						
		};
					
		thread.start();
		
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��28������3:20:13
	  *@Description  �жϵ�¼���û��ǲ��ǵ�һ�ε�¼ϵͳ
	 */
	private void check(String lastLoginTime){
		this.welcomePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel usernamePanel = new JPanel();
		usernamePanel.setOpaque(false);
		JLabel userNameText = new JLabel("  ����");
		JLabel userName = new JLabel(this.loginUser.getUserName());
		System.out.println(this.loginUser.getUserName());
	    usernamePanel.add(userName);
	    usernamePanel.add(userNameText);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.welcomePanel.add(usernamePanel,gbc);
		JTextArea textArea = new JTextArea(10, 10);
		textArea.setEditable(false);
		textArea.setOpaque(false);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.welcomePanel.add(textArea,gbc);
		
		JPanel  lastTimePanel = new JPanel();
		lastTimePanel.setOpaque(false);
		
		if (lastLoginTime != null) {
			JLabel lastTimeLabel = new JLabel("����һ�ε�¼��ʱ���ǣ�");
			JLabel lastTimetextLabel=new JLabel(this.lastLoginTime);
			lastTimePanel.add(lastTimeLabel);
			lastTimePanel.add(lastTimetextLabel);
		}else {
			JLabel lastTimeLabel = new JLabel("����һ�ε�¼ϵͳ��");
			lastTimePanel.add(lastTimeLabel);
		}
		gbc.gridx=10;
		gbc.gridy=10;
		this.welcomePanel.add(lastTimePanel,gbc);
		
	}
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��28������3:29:13
	  *@Description  ��̬�Ĵ����ݿ�menu����ȡ������,תΪjava����浽��������
	 */
	
	private  void  creatMenu(){
		/*������Ϊ�ж϶�̬��Ӳ˵��ɹ����ı�־*/
		boolean flag = false;
		List<MenuBean> list = null; 
		//����dao��Ĳ�ѯ������ͨ��ģ����ѯ
		IMenuDAO menuDAO=new MenuBeanDAOImp();
		String sql1 = "select * from menu where menuId like '__' ";
		list=new ArrayList<MenuBean>();
		list = menuDAO.queryById(sql1);
		
		for (MenuBean menuBean : list) {
			JMenu  temp = new JMenu();
			temp.setText(menuBean.getMenuName());
			String sql2="select * from menu where menuId like '"+menuBean.getMenuId()+"__'";
			List<MenuBean> list2 = new ArrayList<MenuBean>();
			list2=menuDAO.queryById(sql2);
			for (MenuBean menuBean2 : list2) {
				JMenuItem   tempItem = new JMenuItem();
				tempItem.setActionCommand(menuBean2.getMenuId());
				tempItem.setText(menuBean2.getMenuName());
				tempItem.addActionListener(new ItemListener(this,this.loginUser));
				tempItem.add(new JSeparator());
				
				temp.add(tempItem);
				
			}
			
			this.menuBar.add(temp);
			
			
		}
		
		
	}
	
	/**
	 * 
	  * ����ע��
	  *@return void 	
	  *@author ���ʵ�
	  *@Time 2015��4��28������3:36:13
	  *@Description  ��������
	 */
	private void init(){
		ColorSet colorSet = new ColorSet();
		this.menuBar = new JMenuBar();
		this.menuBar.setBackground(colorSet.getBlue());
		this.menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorSet.getBlue()));
		this.helpMenu = new JMenu("����");
		this.helpContentItem = new JMenuItem("����");
		this.helpContentItem.add(new JSeparator());
		this.helpAboutItem = new JMenuItem("����");
		this.helpAboutItem.add(new JSeparator());
		this.helpMenu.add(this.helpContentItem);
		this.helpMenu.add(this.helpAboutItem);	
		this.creatMenu();
		this.menuBar.add(this.helpMenu);
		this.bodyPanel = (JPanel)this.getContentPane();
		BorderLayout borderLayout=new BorderLayout();
		this.bodyPanel.setLayout(borderLayout);
		this.northPanel = new JPanel(new BorderLayout());
		this.northPanel.setBackground(colorSet.getBlue());
		JPanel imgepanel = new JPanel(new BorderLayout());
		JLabel titileImg = new JLabel(new ImageIcon("img/logo.jpg"));
		imgepanel.add(titileImg,BorderLayout.CENTER);
	    FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);
	    this.infoToolBar = new JToolBar();
	    this.infoToolBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorSet.getBlue()));
	    this.infoToolBar.setBackground(new ColorSet().getBlue());
	    this.infoToolBar.setLayout(flowLayout);
	    this.infoToolBar.setFloatable(false);
		this.updatePWDButton = new JButton(new ImageIcon("img/updatePwd.jpg"));
	    this.updatePWDButton.setFocusPainted(false);
	    this.updatePWDButton.setBackground(colorSet.getBlue());
	    this.updatePWDButton.addActionListener(this);
	    this.exitButton = new JButton( new ImageIcon("img/exit.jpg"));
	    this.exitButton.setFocusPainted(false); 
	    this.exitButton.setBackground(colorSet.getBlue());
	    this.infoToolBar.setBackground(colorSet.getBlue());
	    this.exitButton.addActionListener(this);
	    this.infoToolBar.add(this.updatePWDButton);
	    this.infoToolBar.add(this.exitButton);
	    JPanel toolBarpanel = new JPanel(new BorderLayout());
	    toolBarpanel.setBackground(colorSet.getBlue());
	    toolBarpanel.add(this.menuBar,BorderLayout.NORTH);
	    toolBarpanel.add(this.infoToolBar,BorderLayout.EAST);
	    this.northPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorSet.getBlue()));
	    this.northPanel.add(imgepanel,BorderLayout.NORTH);
	    this.northPanel.add(toolBarpanel,BorderLayout.SOUTH);
		//�в�
		this.welcomePanel = new ImgWelcomePanel();
		this.check(this.lastLoginTime);
		//�ϲ�
		BorderLayout southLayout=new BorderLayout();
		this. southPanel = new JPanel();
		this.southPanel.setBackground(colorSet.getBlue());
	    this.southPanel.setLayout(southLayout);
	    JLabel label1 = new JLabel(new ImageIcon("img/copyRight.jpg"));
		this.welcomeLabel = new JLabel("��ӭ����ѧУ����ϵͳ");
		this.timeLabel = new JLabel();
		this.getDate();
		this.southPanel.add(welcomeLabel,BorderLayout.WEST);
		this.southPanel.add(timeLabel,BorderLayout.EAST);
		this.southPanel.add(label1,BorderLayout.SOUTH);
	    
		this.bodyPanel.add(this.northPanel,BorderLayout.NORTH);
		this.bodyPanel.add(this.welcomePanel,BorderLayout.CENTER);
		this.bodyPanel.add(this. southPanel,BorderLayout.SOUTH);
		ImageIcon icon = new ImageIcon("img/title.jpg");
		this.setIconImage(icon.getImage());
		//������������
		this.setTitle("��Ϣ����ѧԺ����ϵͳ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��28�� 3:37:57
	* @Description  ��
	 */
	public MainFrame(){
		
	}
	/**
	 * 
		���췽��������
	* @author ���ʵ� 
	* @date 2015��4��28�� 3:37:57
	* @Description  ��ʼ�����Զ���loginUser��lastLoginTime,����˽�еĻ�ҳ�淽��
	 */
	public MainFrame(MisUser loginUser,String lastLoginTime){
		this.loginUser = loginUser;
		this.lastLoginTime = lastLoginTime;
		this.init();
	}
	/**
	 * @Description ʵ�ּ����ӿڵķ���
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.exitButton) {
			int back = JOptionPane.showConfirmDialog(this, "��ȷ��Ҫ�˳���", "��Ϣ", JOptionPane.YES_NO_OPTION);
			if (back == JOptionPane.YES_OPTION) {
				this.dispose();
				LoginFrame loginFrame=new LoginFrame();
				loginFrame.setResizable(false);
				CommonUse.setComponentBounts(loginFrame, 500, 350);
				loginFrame.setSize(500, 350);
				loginFrame.setVisible(true);
			
			}else {
				return;
			}
			
		}
		//����޸����밴ť���ᵯ���޸��������
		if (e.getSource() == this.updatePWDButton) {
			PWDUpdatePanel u=new PWDUpdatePanel(this.loginUser);
			u.setResizable(false);
			CommonUse.setComponentBounts(u, 500, 350);
			u.setSize(500, 350);
			u.setVisible(true);
		}
			
	}
	
	
}
