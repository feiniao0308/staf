package com.bn.automation.staf.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clock {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	Calendar cal = Calendar.getInstance();
	
	public String getCurrentDateTime(){
		return dateFormat.format(date).toString();
	}
}
