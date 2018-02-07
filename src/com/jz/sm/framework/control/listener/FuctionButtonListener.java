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
* �������
* @author ��ҷ�
* @date 2015��5��2�� ����8:19:51
* @Description  �������������в���������ߵĹ��ܰ�ť�������ť�����,��ť�ұߵ�����,
*             ���ɸù��ܶ�Ӧ�����
*              ����,�����ӻ������ť,�����,��ť�ұ�����,��ɹ������ӻ�����������
 */
public class FuctionButtonListener implements ActionListener {
	private JFrame mainFrame = null;//�ײ���������
	private MisUser loginUser = null;//��¼�û�����

	/**
	 * 
		���췽��������
	* @author ��ҷ�
	* @date 2015��5��2�� ����8:20:57
	* @Description ��
	 */
	public FuctionButtonListener(){
		
	}
	/**
	* 
	*     ���췽��������
	* @author ��ҷ�
	* @date  2015��5��2�� ����8:21:57
	* @Description  �ô������Ĳ�����mainFrame�����MisUser�����ʼ��
	*/
	
	public FuctionButtonListener(JFrame mainFrame,MisUser loginUser){
		this.mainFrame = mainFrame;
		this.loginUser = loginUser;
	}
	
	/**
	 * 
	  * ����ע��
	  *@return ��
	  *@author ��ҷ�
	  *@Time 2015��5��2������8:22:13
	  *@Description  ��������,���������������в���������ߵĹ��ܰ�ť�����ʱ,��ť�ұ�����
	  *            ���ִ���ù��ܵ����
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
	  *@author ��ҷ�
	  *@Time 2015��5��2������8:25:02
	  *@Description  ����ӿڱ��,java�������̬�ļ���ActionFunction�ӿڵ�ʵ����,
	  *			   �ҵ������,�õ������ʵ��,�ýӿڶ����������廭�ķ���
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
