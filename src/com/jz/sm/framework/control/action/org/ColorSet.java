package com.jz.sm.framework.control.action.org;

import java.awt.Color;

public class ColorSet {
	private Color whiteColor = null;
	private Color blueColor = null;
	
	public ColorSet(){
		
	}

	public Color getBlue(){
		this.blueColor = new Color(124, 177, 212);
		return this.blueColor;
	}
	
	public Color getWhite(){
		this.whiteColor = new Color(255, 242, 249);
		return this.whiteColor;
	}

}
