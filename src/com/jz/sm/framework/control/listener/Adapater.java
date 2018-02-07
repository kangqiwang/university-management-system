
package com.jz.sm.framework.control.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.view.PWDUpdatePanel;

/**
 * 
* 类的描述
* @author 田芬芬
* @date 2015年5月2日 上午8:20:51
* @Description  监听实现类,当鼠标进入修改个人信息密码输入框,
*             自动弹出一个修改密码框
 */
public class Adapater extends MouseAdapter {
	 private MisUser loginUser = null;
	 public Adapater(MisUser loginUser) {
		 this.loginUser = loginUser;
	 }
	 /**
		 * 
		  * 方法注释
		  *@return 无
		  *@author 田芬芬
		  *@Time 2015年5月2日下午8:22:13
		  *@Description  弹出一个修改密码框
		 */
	@Override
	public void mouseClicked(MouseEvent e) {
		 PWDUpdatePanel u = new PWDUpdatePanel(this.loginUser);
		 u.setBounds(50, 50, 500, 350);
		 u.setVisible(true);
		 u.setResizable(false);
		 u.setLocationRelativeTo(null);
	 }
	 
}
