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
* 类的描述
* @author 易海门
* @date 2015年4月27日 下午2:50:11
* @Description  继承了JFrame,实现了监听,有构建登陆界面的容器,组件等属性
* 			        画页面的方法,一系列有关业务逻辑的方法
 */

public class LoginFrame  extends JFrame  implements ActionListener,KeyListener{
	private  JPanel bodyPanel=null;//容器
	private JLabel  titleLabel=null;//显示标题的标签
	private JLabel userNameLabel=null;//显示用户名文字
	private JLabel passWordLabel=null;//密码文字
	private JTextField userNameTextField=null;
	private JPasswordField passwordField=null;
	private JButton loginButton=null;//登录按钮
	private JButton  resetButton=null;//重置按钮
	private MisUser  loginUser =null;//MisUser类的对象
	private String  lastLoginTime=null;//用户上次登录的时间
	
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 易海门
	  *@Time 2015年4月27日下午2:58:13
	  *@Description  处理用户登录的业务
	 */
	private void login() {
		/*用字符串变量接受用户输入的id号*/
		String  name=this.userNameTextField.getText();
		/*用字符串变量password接受用户输入的密码*/
		String password= new String(this.passwordField.getPassword()); 
		//处理登录业务，若正确，出现登陆界面
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
						JOptionPane.showMessageDialog(this, "用户名或密码错误!");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(this, "密码不能为空");
				}
			}else {
				JOptionPane.showMessageDialog(this, "用户名不能为空");
				return;
			}
		}else {
			JOptionPane.showMessageDialog(this, "用户名或密码不能为空!");
			return;
		}
	}
	
	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 易海门
	  *@Time 2015年4月27日下午2:58:13
	  *@Description  将登录用户的登录时间从界面上拿到,用来修改数据库中misUser表
	  *             lastLoginTime，达到替换的效果
	  *			   
	 */
	private void  saveLastLoginTime(MisUser misUser){
		
		//创建一个日期对象，将日期转为字符串
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate = sdf.format(d);
		misUser.setLastLoginTime(nowDate);
		//调用dao层的MisUserDAOImp实现类的方法
		IMisUserDAO misUserDAO = new MisUserDAOImp();
		misUserDAO.modify(misUser);
		
	}
	/**
	 * 
	  * 方法注释
	  *@return 该用户的上次登录时间
	  *@author 易海门
	  *@Time 2015年4月27日下午2:59:13
	  *@Description  将登录用户的登录时间从数据库取出,向上传给dao,
	  *             将该值设为MisUser的lastLoginTime属性值
	  *			   
	 */
	private String getLastLoginTime(){
		String lastLoginTime = this.loginUser.getLastLoginTime();
		return lastLoginTime;
	}
	/**
	 * 
	  * 方法注释
	  *@return boolean
	  *@author 易海门
	  *@Time 2015年4月27日下午3:10:13
	  *@Description  将用户输入的id和密码与数据库中的进行验证
	  *             
	  *			   
	 */
	public boolean check(String name ,String password){
		/*用来作为验证密码成功与否的标志*/
		boolean flag = false;
		MisUser temp = null;//声明一个临时的用户对象
		IMisUserDAO misUserDAO = new MisUserDAOImp();
		temp=misUserDAO.findById(name);
		if (temp != null && password.equals(temp.getUserPwd())) {
			flag = true;
			this.loginUser = temp;//将temp对象引用复制给loginUser
		}
		
		return  flag;
	}
	/**
	 * 
	  * 方法注释
	  *@return boolean
	  *@author 易海门
	  *@Time 2015年4月27日下午3:12:13
	  *@Description  画登陆页面
	  *             
	  *			   
	 */
	
	private void init(){
		Container content=this.getContentPane();
		BorderLayout borderLayout=new BorderLayout();
		content.setLayout(borderLayout);
		//创建一个登录面板，有登录相关的组件
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
		this.loginButton=new JButton("登  录");
		this.loginButton.setPreferredSize(new Dimension(180, 26));
		this.loginButton.setBackground(new Color(124, 177, 212));
		this.loginButton.addActionListener(this);
		JPanel panel = new JPanel(new BorderLayout(20, 0));
		panel.add(loginButton,BorderLayout.CENTER);
		
		//创建一个竖直方向的box布局管理器，和3个水平
		Box box0 = Box.createVerticalBox();
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		Box box3 = Box.createHorizontalBox();
		
		//把登录相关组件加在对应的水平box
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
		
		//设置窗体的相关属性
		ImageIcon icon=new ImageIcon("img/title.jpg");
		this.setIconImage(icon.getImage());
		this.setTitle("信息工程学院管理系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * 
		构造方法的描述
	* @author 易海门 
	* @date 2015年4月27日 下午3:15:57
	* @Description  调用私有的画页面方法
	 */
	public LoginFrame(){
		this.init();
	}
	/**
	 * @author 易海门 
	* @date 2015年4月27日 下午3:15:57
	 * @Description 实现监听接口的方法
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
	 * @author 易海门 
	* @date 2015年4月27日 下午3:15:57
	 * @Description 实现键盘监听接口的方法
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
