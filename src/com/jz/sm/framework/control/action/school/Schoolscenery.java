package com.jz.sm.framework.control.action.school;

import javax.swing.JPanel;

import com.jz.sm.framework.control.action.org.ActionFunction;
import com.jz.sm.framework.control.action.org.ColorSet;
import com.jz.sm.framework.model.entity.MisUser;

public class Schoolscenery  implements ActionFunction{
	private JPanel leftPanel = null;
	private JPanel leftTopPanel = null;
	@Override
	public void execute(JPanel workPanel,JPanel leftPanel, MisUser loginUser) {
		this.leftTopPanel = (JPanel)leftPanel.getComponent(0);
		this.leftPanel = leftPanel;
		this.leftTopPanel.setBackground(new ColorSet().getBlue());
		this.leftPanel.setBackground(new ColorSet().getBlue());
		sceneryTread sceneryTread = new sceneryTread(workPanel);
		sceneryTread.start();
	}
		
	
}
