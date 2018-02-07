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
* �������
* @author ���ʵ�
* @date 2015��5��14�� ����10:30:01
* @Description  ������
 */
public class CommonUse implements Serializable{
	
	

    
    /**
     * 
      * ����ע��
      *@return void 	
      *@author ���ʵ�
      *@Time 2015��5��16������12:15:07
      *@Description �ô����������Ļ������
     */
    public static void setComponentBounts(JFrame frame, int width, int high) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        frame.setLocation((screenWidth - width) / 2, (screenHeight - high) / 2);
    }
}
