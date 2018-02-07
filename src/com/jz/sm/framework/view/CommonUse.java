package com.jz.sm.framework.view;



import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.jz.sm.framework.model.dao.impl.IMisUserDAO;
import com.jz.sm.framework.model.dao.impl.MisUserDAOImp;
import com.jz.sm.framework.model.entity.MisUser;

/**
 * 
* 类的描述
* @author 王攀登
* @date 2015年5月14日 上午10:30:01
* @Description  工具类
 */
public class CommonUse implements Serializable{
	
	

    
    /**
     * 
      * 方法注释
      *@return void 	
      *@author 王攀登
      *@Time 2015年5月16日上午12:15:07
      *@Description 让窗体出现在屏幕的中央
     */
    public static void setComponentBounts(JFrame frame, int width, int high) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        frame.setLocation((screenWidth - width) / 2, (screenHeight - high) / 2);
    }
}
