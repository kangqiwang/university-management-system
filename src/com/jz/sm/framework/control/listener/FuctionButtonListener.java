package com.jz.sm.framework.control.listener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.control.action.org.OrgTypeCreateAction;
import com.jz.sm.framework.model.dao.impl.IMisFuctionDAO;
import com.jz.sm.framework.model.dao.impl.MisFuctionDAOImp;
import com.jz.sm.framework.model.entity.MisFuction;
import com.jz.sm.framework.model.entity.MisUser;
/**
 * 
* 类的描述
* @author 田芬芬
* @date 2015年5月2日 上午8:19:51
* @Description  监听主界面上中部区域上左边的功能按钮，如果按钮被点击,按钮右边的区域,
*             会变成该功能对应的面板
*              例如,当增加机构类别按钮,被点击,按钮右边区域,变成关于增加机构类别的区域
 */
public class FuctionButtonListener implements ActionListener {
	private JFrame mainFrame = null;//底层容器对象
	private MisUser loginUser = null;//登录用户对象

	/**
	 * 
		构造方法的描述
	* @author 田芬芬
	* @date 2015年5月2日 上午8:20:57
	* @Description 无
	 */
	public FuctionButtonListener(){
		
	}
	/**
	* 
	*     构造方法的描述
	* @author 田芬芬
	* @date  2015年5月2日 上午8:21:57
	* @Description  用穿件来的参数对mainFrame对象和MisUser对象初始化
	*/
	
	public FuctionButtonListener(JFrame mainFrame,MisUser loginUser){
		this.mainFrame = mainFrame;
		this.loginUser = loginUser;
	}
	
	/**
	 * 
	  * 方法注释
	  *@return 无
	  *@author 田芬芬
	  *@Time 2015年5月2日上午8:22:13
	  *@Description  监听方法,当任意主界面上中部区域上左边的功能按钮被点击时,按钮右边区域
	  *            出现处理该功能的面板
	  *				
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	JButton button = (JButton)e.getSource();
	String  functionId = button.getActionCommand();
	JPanel bodyPanel = (JPanel)this.mainFrame.getContentPane();
	JPanel welcomPanel = (JPanel)bodyPanel.getComponent(1);
	JPanel workPanel = (JPanel)welcomPanel.getComponent(0);
	JPanel leftPanel = (JPanel)welcomPanel.getComponent(1);
	
	workPanel.removeAll();
	workPanel.repaint();
	IMisFuctionDAO misFuctionDAO = new MisFuctionDAOImp();
	MisFuction tempFunction = misFuctionDAO.findById(functionId);
	String functionClass = tempFunction.getFunctionClass();
	/**
	  *@author 田芬芬
	  *@Time 2015年5月2日上午8:25:02
	  *@Description  面向接口编程,java虚拟机动态的加载ActionFunction接口的实现类,
	  *			   找到该类后,拿到该类的实例,用接口对象调用在面板画的方法
	  *				
	 */
	ActionFunction actionFunction = null;
	Class actionClass = null;
	try {
		actionClass = getClass().getClassLoader().loadClass(functionClass);
		actionFunction = (ActionFunction)actionClass.newInstance();
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	} catch (InstantiationException e1) {
		e1.printStackTrace();
	} catch (IllegalAccessException e1) {
		e1.printStackTrace();
	}
	actionFunction.execute(workPanel,leftPanel,this.loginUser);
	this.mainFrame.setVisible(true);
	
	}
	
}
