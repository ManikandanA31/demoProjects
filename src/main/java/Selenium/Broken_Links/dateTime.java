package Selenium.Broken_Links;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateTime 
{
public String date1;
	public void DFormat() 
	{
		// TODO Auto-generated method stub
		DateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		 date1 =  dateformat.format(date);
		System.out.println(date1);

	}

}
