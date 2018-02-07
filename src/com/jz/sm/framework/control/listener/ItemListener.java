package com.jz.sm.framework.control.listener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.jz.sm.framework.control.action.org.ColorSet;
import com.jz.sm.framework.model.dao.impl.IMisFuctionDAO;
import com.jz.sm.framework.model.dao.impl.MisFuctionDAOImp;
import com.jz.sm.framework.model.entity.MisFuction;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.view.ImgWelcomePanel;
/**
 * 
* 类的描述
* @author 田芬芬
* @date 2015年5月2日 上午7:40:51
* @Description  监听主界面上的子菜单，如果子菜单被点击,中间区域,会被分隔成左边
*              和中间,左边会出现子菜单相对应的功能的按钮。
 */
public class ItemListener implements ActionListener {
	private JFrame mainFrame = null;//重量级容器
	private JPanel workPanel = null;//本界面中部区域
	private JPanel leftPanel = null;//分隔符左边的区域
	private JPanel leftTopPanel = null;//左边区域中的上部区域
	private MisUser loginUser = null;//登录用户对象
	
	
	/**
	 * 
	  * 方法注释
	  *@return 装有JButton的对象的集合对象
	  *@author 田芬芬
	  *@Time 2015年5月2日上午8:00:13
	  *@Description  将菜单id，和角色id作为参数,传给dao层,
	  *				dao会返回一个装有多个misFuction对象的集合对象,
	  *				将此集合对象转为装有JButton的对象的集合对象
	 */
	public List<JButton> getFuctionButton(String menuId,String roleId){
		List<JButton> buttonList = new ArrayList<JButton>();
		IMisFuctionDAO misFuctionDAO = new MisFuctionDAOImp();
		List<MisFuction> misFuctions = misFuctionDAO.findByMenuIdAndRoleId(menuId, roleId);
		for (MisFuction misFuction : misFuctions) {
			JButton temp = new JButton();
			temp.setText(misFuction.getFunctionName());
			temp.setActionCommand(misFuction.getFunctionId());
			temp.setBackground(new ColorSet().getBlue());
			temp.addActionListener((new FuctionButtonListener(this.mainFrame,this.loginUser)));
			buttonList.add(temp);
			
		}
		return buttonList;
	}
	/**
	 * 
	  * 方法注释
	  *@return 无
	  *@author 田芬芬
	  *@Time 2015年5月2日上午8:15:13
	  *@Description  监听方法,当任意一个子菜单被点击时,mainFraim主界面的中部区域
	  *				中间区域,会被分隔成左边 和中间,左边会出现子菜单相对应的功能的几个按钮。
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ColorSet colorSet = new ColorSet();
		JMenuItem tempItem = (JMenuItem)e.getSource();
		String menuId = tempItem.getActionCommand();
		JPanel bodyPanel = (JPanel)this.mainFrame.getContentPane();
		Component[] c1 = bodyPanel.getComponents();
		JPanel welcomePanel = (JPanel)c1[1];
		welcomePanel.removeAll();
		welcomePanel.repaint();
		welcomePanel.setLayout(new BorderLayout());
		this.leftPanel = new JPanel(new BorderLayout());
		this.leftPanel.setBackground(colorSet.getWhite());
		this.leftPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, colorSet.getBlue()));
		this.leftTopPanel = new JPanel(new GridLayout(6, 1));
		this.leftTopPanel.setBackground(colorSet.getWhite());
		List<JButton> list = this.getFuctionButton(menuId,this.loginUser.getRoleId());
		for (JButton jButton : list) {
			this.leftTopPanel.add(jButton);
		}
		this.leftPanel.add(this.leftTopPanel,BorderLayout.NORTH);
		this.workPanel = new JPanel();
		this.workPanel.setBackground(colorSet.getWhite());
		welcomePanel.add(this.workPanel,BorderLayout.CENTER);
		welcomePanel.add(this.leftPanel,BorderLayout.WEST);
		this.mainFrame.setVisible(true);
		
	}
	/**
	 * 
		构造方法的描述
	* @author 田芬芬
	* @date 2015年5月2日 上午8:17:57
	* @Description 无
	 */
	public ItemListener(){
		
	}
	/**
	 * 
		构造方法的描述
	* @author 田芬芬
	* @date  2015年5月2日 上午8:18:57
	* @Description  用穿件来的参数对mainFrame对象和MisUser对象初始化
	 */
	public ItemListener(JFrame mainFrame,MisUser loginUser){
		this.mainFrame = mainFrame;
		this.loginUser = loginUser;
		
	}
	
}
