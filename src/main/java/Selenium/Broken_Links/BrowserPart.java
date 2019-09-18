package Selenium.Broken_Links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrowserPart {
	WebDriver driver;
	dateTime dt = new dateTime();
	
	public void openBrowser() throws MalformedURLException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Chrome\\New\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		System.out.println("Enter your URL to Check the Broken Link :");
		Scanner scan = new Scanner(System.in);		
		String url = scan.next();
//		String url = "http://182.74.129.6/demo/amperagemarketing/kings/";
		driver.get(url);
		System.out.println(" Start Time :"); 
		dt.DFormat();
		findhyperlink();	
	}
	
	public void findhyperlink() throws MalformedURLException, IOException
	{
		String url = "";
		HttpURLConnection huc;
		int validcounter = 0;
		int invalidcounter = 0;
		int nonurlcounter =0;
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		while(it.hasNext()){
			url = it.next().getAttribute("href");
			if(url.contains("http://") || url.contains("https://") ) {
				huc = (HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				int  respCode = huc.getResponseCode();
				if(respCode<=299) {
					validcounter++;
					System.out.println(url +" :- Valid URL");
				}else {
					invalidcounter++;
					System.out.println(url +" :- InValid URL");
				}
			}
			else {
				nonurlcounter++;
				System.out.println(url +" :- Not a URL ");
			}
		}
		System.out.println("Total URL Scanned ="+links.size());
		System.out.println("Total Valid URL ="+validcounter);
		System.out.println("Total InValid URL ="+invalidcounter);
		System.out.println("Total NON URL ="+nonurlcounter);
		System.out.println(" End Time :" + dt.date1);
	}

}
