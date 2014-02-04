package com.bn.automation.scripts;


import com.bn.automation.staf.widget.ScreenObject;
import com.bn.automation.staf.widget.TextBox;
import com.bn.automation.staf.widget.Widgets;

@Widgets
public class SO extends ScreenObject{
	
	@Widgets
	public static class SOinner {
		public static TextBox lname2 = new TextBox("name=name1");
		public TextBox lname = new TextBox("name=lastname2");
		public TextBox lname4 = new TextBox("name=lastname3");
		public TextBox fname = new TextBox("name=firstname4");
	}

	// public static TextBox searchbar = new TextBox("name=q");

	public static final String CONSTANT_1 = "1";
	public static final String CONSTANT_2 = "2";
	public static final String CONSTANT_3 = "3";
	
	private TextBox lname = new TextBox("name=lastname");
	public static TextBox name = new TextBox("name=name");
	public static TextBox email = new TextBox("name=email");
	public static TextBox phone = new TextBox("name=phone");
	public static TextBox add = new TextBox("name=address");
	public static TextBox lname5 = new TextBox("name=lastname6");

	public SO(){
		
	}

	// public static TextBox fname = new TextBox("name=firstname");

}
