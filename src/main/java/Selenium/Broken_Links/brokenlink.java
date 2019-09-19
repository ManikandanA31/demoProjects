package Selenium.Broken_Links;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public class brokenlink {

	static WebDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, IOException
	{
		BrowserPart browser = new BrowserPart();
		browser.openBrowser();
			
	}

}
