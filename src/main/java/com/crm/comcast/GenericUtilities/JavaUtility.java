package com.crm.comcast.GenericUtilities;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author RJ
 *
 */

public class JavaUtility {
	/**
	 * method to get random number
	 * @return
	 */
	public int getRandomNumber() {
		Random random=new Random();
		int randomnum=random.nextInt(1000);
		return randomnum;
	}
	/**
	 * method to get system date
	 * @return
	 */
	public String getSystemDate() {
		Date date=new Date();
		String dateTime=date.toString();
		return dateTime;
	}
	/**
	 * method to get system date in the required format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date date1=new Date();
		String datetime=date1.toString();
		String[]dateArr=datetime.split(" ");
		@SuppressWarnings("deprecation")
		int month=date1.getMonth()+1;
		String date=dateArr[2];
		String year=dateArr[5];
		int day=date1.getDay();
		String time=dateArr[3];
		String dateformat=month+" "+date+" "+year+" "+day;
		return dateformat;
		
	}
}
