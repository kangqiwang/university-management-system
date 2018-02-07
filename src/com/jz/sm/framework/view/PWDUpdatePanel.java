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
* 类的描述
* @author 易海门
* @date 2015年4月28日 下午15:45:11
* @Description  继承了JFrame,实现了监听,有构建登陆界面的容器,组件等属性
* 			        画页面的方法,一系列有关业务逻辑的方法,弹出修改密码的界面
 */
public class PWDUpdatePanel extends JFrame implements ActionListener{
	
	private JLabel oldPWDLabel = null;//旧密码标签
	private JPasswordField oldPWDField = null;
	private JLabel newPWDLabel = null;//新密码标签
	private JPasswordField newPWDField = null; 
	private JLabel renewPWDLabel = null;//确认新密码
	private JPasswordField renewPWDField = null; 
	private JButton save = null;//保存按钮
	private JButton reset = null;//重置按钮
	private MisUser loginUser=null; //用户对象
	private JPanel centerPanel = null;
    private JPanel bottomPanel = null;
	
	/**
	 * 
	  * 方法注释
	  *@return boolean 	
	  *@author 易海门
	  *@Time 2015年4月28日下午15:50:13
	  *@Description  修改登录用户的misUser实例,对应数据库修改一条记录
	 */
	private boolean updatePWD(MisUser misUser){
		boolean flag = false;
		IMisUserDAO temp = new MisUserDAOImp();
		flag = temp.modify(misUser);
		return flag;
	}

	/**
	 * 
	  * 方法注释
	  *@return void 	
	  *@author 易海门
	  *@Time 2015年4月28日下午16:01:13
	  *@Description  画修改密码这个界面
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
		

    	this.oldPWDLabel = new JLabel("当前密码：",JLabel.RIGHT);
    	this.oldPWDLabel.setPreferredSize(new Dimension(80, 24));
    	this.newPWDLabel = new JLabel("新密码：", JLabel.RIGHT);
		this.newPWDLabel.setPreferredSize(new Dimension(80, 24));
		this.renewPWDLabel = new JLabel("确认新密码：", JLabel.RIGHT);
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
		this.save = new  JButton("保   存");
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
		this.setTitle("信息工程学院管理系统->修改密码");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	/**
	 * 
		构造方法的描述
	* @author  易海门
	* @date 2015年4月28日下午16:01:13
	* @Description 将loginUser对象传参数,传进来,最后调用画页面的方法
	 */
	public PWDUpdatePanel(MisUser loginUser) {
		this.loginUser = loginUser;
		this.init();
	}
	
	/**
	 * 
		构造方法的描述
	* @author 王攀登
	* @date 2015年4月28日下午16:10:13
	* @Description 实现监听者接口的方法
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*用来存放当前密码*/
		String oldPassWord = new String(this.oldPWDField.getPassword());
		/*用来存放新密码*/
		String newPassWord = new String(this.newPWDField.getPassword());
		/*用来存放验证密码*/
		String checkPassWord = new String(this.renewPWDField.getPassword());
		
		//处理密码修改业务
		if (oldPassWord != null&&newPassWord != null&&checkPassWord != null) {
			if (oldPassWord.length()>0) {
		
				if (newPassWord.length()>0&&checkPassWord.length()>0) {
					
					if (oldPassWord.equals(this.loginUser.getUserPwd())) {
						
						if (newPassWord.equals(checkPassWord)) {
							
							this.loginUser.setUserPwd(newPassWord);
							if (this.updatePWD(this.loginUser)) {
								JOptionPane.showMessageDialog(null, "密码修改成功");
							}else {
								JOptionPane.showMessageDialog(null, "密码修改失败");
								return;
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "两次输入的密码不一致");
							return;
						}
							
					}else {
						JOptionPane.showMessageDialog(null, "旧密码有误");
						this.oldPWDField.setText("");
						return;
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "密码不为空！");
					return;
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "请输入旧密码");
				return;
			}
		}else {
			return;
		}
		
		
		
	}
	
}
