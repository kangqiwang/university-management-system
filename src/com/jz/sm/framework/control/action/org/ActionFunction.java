package com.jz.sm.framework.control.action.org;

import javax.swing.JPanel;

import com.jz.sm.framework.model.entity.MisUser;
/**
 * 
* 接口的描述
* @Description 定义一个抽象方法
 */

public interface ActionFunction {
	public void execute(JPanel workPanel,JPanel leftPanel,MisUser loginUser);
	
	
}
