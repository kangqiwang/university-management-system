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
* �������
* @author ��ҷ�
* @date 2015��5��2�� ����7:40:51
* @Description  �����������ϵ��Ӳ˵�������Ӳ˵������,�м�����,�ᱻ�ָ������
*              ���м�,��߻�����Ӳ˵����Ӧ�Ĺ��ܵİ�ť��
 */
public class ItemListener implements ActionListener {
	private JFrame mainFrame = null;//����������
	private JPanel workPanel = null;//�������в�����
	private JPanel leftPanel = null;//�ָ�����ߵ�����
	private JPanel leftTopPanel = null;//��������е��ϲ�����
	private MisUser loginUser = null;//��¼�û�����
	
	
	/**
	 * 
	  * ����ע��
	  *@return װ��JButton�Ķ���ļ��϶���
	  *@author ��ҷ�
	  *@Time 2015��5��2������8:00:13
	  *@Description  ���˵�id���ͽ�ɫid��Ϊ����,����dao��,
	  *				dao�᷵��һ��װ�ж��misFuction����ļ��϶���,
	  *				���˼��϶���תΪװ��JButton�Ķ���ļ��϶���
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
	  * ����ע��
	  *@return ��
	  *@author ��ҷ�
	  *@Time 2015��5��2������8:15:13
	  *@Description  ��������,������һ���Ӳ˵������ʱ,mainFraim��������в�����
	  *				�м�����,�ᱻ�ָ������ ���м�,��߻�����Ӳ˵����Ӧ�Ĺ��ܵļ�����ť��
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
		���췽��������
	* @author ��ҷ�
	* @date 2015��5��2�� ����8:17:57
	* @Description ��
	 */
	public ItemListener(){
		
	}
	/**
	 * 
		���췽��������
	* @author ��ҷ�
	* @date  2015��5��2�� ����8:18:57
	* @Description  �ô������Ĳ�����mainFrame�����MisUser�����ʼ��
	 */
	public ItemListener(JFrame mainFrame,MisUser loginUser){
		this.mainFrame = mainFrame;
		this.loginUser = loginUser;
		
	}
	
}
