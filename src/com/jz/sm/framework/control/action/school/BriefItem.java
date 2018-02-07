package com.jz.sm.framework.control.action.school;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.model.dao.impl.IMisFuctionDAO;
import com.jz.sm.framework.model.dao.impl.MisFuctionDAOImp;
import com.jz.sm.framework.model.entity.MisFuction;
import com.jz.sm.framework.model.entity.MisUser;
import com.jz.sm.framework.view.ImgBriefPanel;
import com.jz.sm.framework.view.MainFrame;
/**
 * 
* �������
* @Description  �����ӿ�ʵ����,��ѧУ�ſ���ť������� �õ��������ϵ�workPanel���
* 			     ������,�������������һ���ı������
 */
public class BriefItem implements ActionFunction {
		
	private JPanel workPanel = null;
	private JPanel leftPanel = null;
	private JPanel rightPanel = null;
	private JTextArea helpTextArea = null;
	/**
	 * 
	* �������
	* @Description  ������������һ���ı������
	 */
	private void createLeftPanel(){
		this.leftPanel = new ImgBriefPanel();
		this.leftPanel.setLayout(new BorderLayout());
		this.helpTextArea = new JTextArea(5, 20);
		this.helpTextArea.setText("       ��������ѧԺ��2003�꾭��������׼��ʡ�й���������"
				+ "ȫ��������һ��ȫ������ͨ���Ƹ�У���Ⱥ���"
				+ " ����ѧУ�ϲ����ɣ�1990��������ѧ������ʦ��ר"
				+ "��ѧУ�ϲ�Ϊ�������ϴ�ѧ��"
				+ "2003�꣬�����ҽ�������׼���������ϴ�ѧ��������"
				+ "��ѧԺ�ϲ�����Ϊ��������ѧԺ��2006�ꡢ"
				+ "2009�꣬�����׶�ʦ��ѧУ������ʦ��ѧУ�Ⱥ�����������ѧԺ��"
				+"����2014��6�£�ѧУռ��741Ķ�������У����̫��"
				+ "У������ԺУ������У�����������35.6��ƽ���ף�ͼ������"
				+ "138��ᣬ��ѧ�����豸��ֵԼ1.09��Ԫ����ְ��1170�ˡ�"
				+ "��ȫ������У��13746�ˣ�����13������ѧԺ��41������רҵ��"
				+ "�漰��ѧ����ѧ����ѧ������ѧ������ѧ����ѧ����ʷѧ��ũѧ��"
				+ "����ѧ�ȾŴ�ѧ�����ࡣ"
				+"   ��ѧ��ʷ�� ��������ѧԺ��ǰ��������ʦר��������ѧ������"
				+ "����ѧԺ������У��1990������ʦר(������1958��)��������"
				+ "ѧ(������1980��)�ϲ��齨�������ϴ�ѧ��"
				+ " 2003�꾭���ҽ�������׼���������ϴ�ѧ����������ѧԺ(����"
				+ "��1952��)�ϲ�����Ϊ��������ѧԺ��[2] "
				+"   ��ѧ������   ����2014��6�£�ѧУ��12������ѧԺ��1��������"
				+ "��ѧԺ��41������רҵ���漰��ѧ����ѧ����ѧ������ѧ������ѧ��"
				+ "��ѧ����ʷѧ��ũѧ������ѧ�ȾŴ�ѧ�����ࡣ"
				+"   �Ļ���ͳ��  ��������ѧԺУ����Ϊ�����������ԡ����鳤����"
				+ "������������ʤ�ء���Ԩ��񣬶����Ž�������֮���㣬"
				+ "����ˮ֮ʤ�����Ƹ���֮�輨�����˲Ŷ���ʵ����"
				+ "ң�������飬�Խ̺��ã������ܹ������񡷣��Գɽ̻�����ɾ���"
				+ "�����ף�����Ӻ�������ա���ͷ���ԡ�����ѫ��������ʿ�������Ա�֮"
				+ "������Ϊ������β��Ԣ�����"		
				);
		this.helpTextArea.setEditable(false);
		this.helpTextArea.setFont(new Font("TimesRoman", Font.BOLD, 16));
		this.helpTextArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(this.helpTextArea);
		JScrollBar sBar = scrollPane.getVerticalScrollBar();
		sBar.setValue(sBar.getMinimum());
		this.leftPanel.add(scrollPane,BorderLayout.WEST);
	}
	/**
	 * 
	* �������
	* @author ��ҷ�
	* @date 2015��5��2�� ����8:25:51
	* @Description  ���ı����������workPanel��
	 */
	private  void  init(){
		this.workPanel.add(this.leftPanel,BorderLayout.CENTER);
	}
	/**
	 * 
	* �������
	* @author ��ҷ�
	* @date 2015��5��2�� ����8:30:51
	* @Description �ô����Ĳ�����workPanel�����ʼ��,���û������巽��
	 */
	public void execute(JPanel workPanel,JPanel leftPanel, MisUser loginUser) {
		this.workPanel = workPanel;
		this.workPanel.removeAll();
		this.workPanel.repaint();
		this.workPanel.setLayout(new BorderLayout());
		this.createLeftPanel();
		this.init();
		
	}
		
		
		
		
		
		
	
	
	
}
