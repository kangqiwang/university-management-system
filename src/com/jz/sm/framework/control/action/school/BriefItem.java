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
* 类的描述
* @Description  监听接口实现类,当学校概况按钮被点击后， 拿到主界面上的workPanel面板
* 			     清空面板,重新再上面添加一个文本域组件
 */
public class BriefItem implements ActionFunction {
		
	private JPanel workPanel = null;
	private JPanel leftPanel = null;
	private JPanel rightPanel = null;
	private JTextArea helpTextArea = null;
	/**
	 * 
	* 类的描述
	* @Description  在面板上面添加一个文本域组件
	 */
	private void createLeftPanel(){
		this.leftPanel = new ImgBriefPanel();
		this.leftPanel.setLayout(new BorderLayout());
		this.helpTextArea = new JTextArea(5, 20);
		this.helpTextArea.setText("       西安文理学院是2003年经教育部批准，省市共建、面向"
				+ "全国招生的一所全日制普通本科高校。先后由"
				+ " 五所学校合并而成，1990年西安大学与西安师范专"
				+ "科学校合并为西安联合大学；"
				+ "2003年，经国家教育部批准，西安联合大学与西安教"
				+ "育学院合并更名为西安文理学院；2006年、"
				+ "2009年，西安幼儿师范学校和西安师范学校先后并入西安文理学院。"
				+"截至2014年6月，学校占地741亩，设高新校区、太白"
				+ "校区和书院校区三个校区，建筑面积35.6万平方米，图书资料"
				+ "138万册，教学仪器设备总值约1.09亿元。教职工1170人。"
				+ "有全日制在校生13746人，设有13个二级学院、41个本科专业，"
				+ "涉及文学、理学、工学、教育学、管理学、法学、历史学、农学、"
				+ "艺术学等九大学科门类。"
				+"   办学历史： 西安文理学院的前身是西安师专、西安大学和西安"
				+ "教育学院三所高校。1990年西安师专(创建于1958年)和西安大"
				+ "学(创建于1980年)合并组建西安联合大学。"
				+ " 2003年经国家教育部批准，西安联合大学和西安教育学院(创建"
				+ "于1952年)合并更名为西安文理学院。[2] "
				+"   办学条件：   截至2014年6月，学校有12个二级学院和1个继续教"
				+ "育学院、41个本科专业，涉及文学、理学、工学、教育学、管理学、"
				+ "法学、历史学、农学、艺术学等九大学科门类。"
				+"   文化传统：  西安文理学院校赋名为《文理赋》。以”吉祥长安，"
				+ "文理赋文理赋三辅胜地。文渊深厚，独步古今。依终南之俊秀，"
				+ "揽八水之胜景。纹高新之鸿绩，蓄人才而博实力。"
				+ "遥想仓颉作书，以教后嗣；诚阅周公作《礼》，以成教化。设成均以"
				+ "明人伦，建辟雍而授六艺”开头，以“借势勋力，鼓舞士气。无以表之"
				+ "，聊以为敬”结尾，寓意深长。"		
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
	* 类的描述
	* @author 田芬芬
	* @date 2015年5月2日 上午8:25:51
	* @Description  将文本域的面板加在workPanel上
	 */
	private  void  init(){
		this.workPanel.add(this.leftPanel,BorderLayout.CENTER);
	}
	/**
	 * 
	* 类的描述
	* @author 田芬芬
	* @date 2015年5月2日 上午8:30:51
	* @Description 用传来的参数对workPanel对象初始化,调用画左边面板方法
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
