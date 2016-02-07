package com.bn.automation.scripts;


import com.bn.automation.staf.widget.Label;
import com.bn.automation.staf.widget.ScreenObject;
import com.bn.automation.staf.widget.TextBox;
import com.bn.automation.staf.widget.Widgets;

@Widgets
public class SO extends ScreenObject{
	
	@Widgets
	public static class SOinner {
		
		public static TextBox q = new TextBox("name=q");
		public static TextBox lname2 = new TextBox("name=name1");
		public TextBox lname = new TextBox("name=lastname2");
		public TextBox lname4 = new TextBox("name=lastname3");
		public TextBox fname = new TextBox("name=firstname4");
		public static TextBox name = new TextBox("name=name");
		public static TextBox email = new TextBox("name=email");
		public static TextBox phone = new TextBox("name=phone");
		public static TextBox add = new TextBox("name=address");
		
		public static Label nameLabel = new Label("xpath=html/body/form/div/table/tbody/tr[2]/td[2]");
		public static Label emailLabel = new Label("xpath=html/body/form/div/table/tbody/tr[3]/td[2]");
		public static Label phoneLabel = new Label("xpath=html/body/form/div/table/tbody/tr[4]/td[2]");
		public static Label addLabel = new Label("xpath=html/body/form/div/table/tbody/tr[5]/td[2]");
		
		public static TextBox bnemail = new TextBox("xpath=html/body/div[2]/div/div/div/section/form/fieldset[1]/input[3]");
		public static TextBox bnpass = new TextBox("xpath=html/body/div[2]/div/div/div/section/form/fieldset[1]/input[5]");
		public static TextBox bnfname = new TextBox("id=fName");
		public static TextBox bnlname = new TextBox("id=lName");
		public static TextBox bnsecurity = new TextBox("id=securityAnswer");
		
		public static Label bnmyacc = new Label("id=myAccountLink");
		
		public static TextBox emailbn = new TextBox("id=email");
		public static TextBox passbn = new TextBox("id=password");
		
		public static Label fnameLabel = new Label("xpath=.//*[@id='createAccountForm']/fieldset[1]/label[1]");
		public static Label lnameLabel = new Label("xpath=html/body/div[2]/div/div/div/section/form/fieldset[2]/label[1]");
		
		
		
	}

}
