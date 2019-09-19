package Selenium.Broken_Links;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateTime 
{
public String date1;
	public String DFormat(Date date) 
	{
		// TODO Auto-generated method stub
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy (hh:mm:ss)");
		date1 =  dateformat.format(date);
		return date1;

	}

}
