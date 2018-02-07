
package com.jz.sm.framework.control.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.view.PWDUpdatePanel;

/**
 * 
* �������
* @author ��ҷ�
* @date 2015��5��2�� ����8:20:51
* @Description  ����ʵ����,���������޸ĸ�����Ϣ���������,
*             �Զ�����һ���޸������
 */
public class Adapater extends MouseAdapter {
	 private MisUser loginUser = null;
	 public Adapater(MisUser loginUser) {
		 this.loginUser = loginUser;
	 }
	 /**
		 * 
		  * ����ע��
		  *@return ��
		  *@author ��ҷ�
		  *@Time 2015��5��2������8:22:13
		  *@Description  ����һ���޸������
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
