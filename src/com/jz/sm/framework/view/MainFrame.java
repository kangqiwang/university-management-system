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
* 类的描述
* @author 王攀登
* @date 2015年4月28日 下午3:18:06
* @Description   继承了JFrame,实现了监听,有构建登陆界面的容器,组件等属性
* 			        画页面的方法,一系列有关业务逻辑的方法
 */
public class MainFrame  extends JFrame implements ActionListener{
	private  JPanel bodyPanel = null;
	private JPanel northPanel = null;
	private JPanel welcomePanel = null;
	private JPanel leftPanel = null;
	private JPanel southPanel = null;
	private Thread thread=null;//线程对象
	private JMenuBar menuBar = null;//菜单容器
	private JMenu helpMenu = null;//显示帮助菜单
	private JMenuItem helpContentItem = null;//子菜单内容
	private JMenuItem helpAboutItem = null; 
	private JToolBar infoToolBar = null;
	private JLabel userNameLabel = null;
	private JLabel userNameTextLabel = null;
	private JButton exitButton = null;//退出系统
	private JButton reLogoButton = null;//修改密码
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
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月28日下午3:20:13
	  *@Description  通过在内部类里调用线程的方法,动态的在界面上显示时间
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
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月28日下午3:20:13
	  *@Description  判断登录的用户是不是第一次登录系统
	 */
	private void check(String lastLoginTime){
		this.welcomePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel usernamePanel = new JPanel();
		usernamePanel.setOpaque(false);
		JLabel userNameText = new JLabel("  您好");
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
			JLabel lastTimeLabel = new JLabel("您上一次登录的时间是：");
			JLabel lastTimetextLabel=new JLabel(this.lastLoginTime);
			lastTimePanel.add(lastTimeLabel);
			lastTimePanel.add(lastTimetextLabel);
		}else {
			JLabel lastTimeLabel = new JLabel("您第一次登录系统：");
			lastTimePanel.add(lastTimeLabel);
		}
		gbc.gridx=10;
		gbc.gridy=10;
		this.welcomePanel.add(lastTimePanel,gbc);
		
	}
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月28日下午3:29:13
	  *@Description  动态的从数据库menu表中取出数据,转为java对象存到集合类中
	 */
	
	private  void  creatMenu(){
		/*用来作为判断动态添加菜单成功与否的标志*/
		boolean flag = false;
		List<MenuBean> list = null; 
		//调用dao层的查询方法，通过模糊查询
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
	  * 方法注释
	  *@return void 	
	  *@author 王攀登
	  *@Time 2015年4月28日下午3:36:13
	  *@Description  画主界面
	 */
	private void init(){
		ColorSet colorSet = new ColorSet();
		this.menuBar = new JMenuBar();
		this.menuBar.setBackground(colorSet.getBlue());
		this.menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorSet.getBlue()));
		this.helpMenu = new JMenu("帮助");
		this.helpContentItem = new JMenuItem("内容");
		this.helpContentItem.add(new JSeparator());
		this.helpAboutItem = new JMenuItem("关于");
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
		//中部
		this.welcomePanel = new ImgWelcomePanel();
		this.check(this.lastLoginTime);
		//南部
		BorderLayout southLayout=new BorderLayout();
		this. southPanel = new JPanel();
		this.southPanel.setBackground(colorSet.getBlue());
	    this.southPanel.setLayout(southLayout);
	    JLabel label1 = new JLabel(new ImageIcon("img/copyRight.jpg"));
		this.welcomeLabel = new JLabel("欢迎进入学校管理系统");
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
		//窗体属性设置
		this.setTitle("信息工程学院管理系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月28日 3:37:57
	* @Description  无
	 */
	public MainFrame(){
		
	}
	/**
	 * 
		构造方法的描述
	* @author 王攀登 
	* @date 2015年4月28日 3:37:57
	* @Description  初始化属性对象loginUser和lastLoginTime,调用私有的画页面方法
	 */
	public MainFrame(MisUser loginUser,String lastLoginTime){
		this.loginUser = loginUser;
		this.lastLoginTime = lastLoginTime;
		this.init();
	}
	/**
	 * @Description 实现监听接口的方法
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.exitButton) {
			int back = JOptionPane.showConfirmDialog(this, "你确定要退出吗？", "消息", JOptionPane.YES_NO_OPTION);
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
		//点击修改密码按钮，会弹出修改密码界面
		if (e.getSource() == this.updatePWDButton) {
			PWDUpdatePanel u=new PWDUpdatePanel(this.loginUser);
			u.setResizable(false);
			CommonUse.setComponentBounts(u, 500, 350);
			u.setSize(500, 350);
			u.setVisible(true);
		}
			
	}
	
	
}
