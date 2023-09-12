package org.main1;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.awt.Robot;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void edgeLaunch() {
//		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();

	}
	

	public static void url(String url) {
		driver.get(url);
	}
	public static void impwait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		driver.manage().window().maximize();
    }

	public static void sendkeys(WebElement a, String data) {
		a.sendKeys(data);
	}
	private void sendkey(WebElement b, String info) {
		b.sendKeys(info);
	}

	public static void clk(WebElement b) {
		b.click();
	}

	public static String getTitle() {
		String title = driver.getTitle(); 
		return title;
	}
	
	public static void selectInd(int index, WebElement c) {
		Select s = new Select(c);
		s.selectByIndex(index);
		}
	
	public static void windowhandle() {
		Set<String> allid = driver.getWindowHandles();
		System.out.println(allid);
		List<String> li = new ArrayList<String>();
		li.addAll(allid);
		driver.switchTo().window(li.get(1));	 
	}
	public static String getCurrentUrl() {
		String currenturl = driver.getCurrentUrl();
		return currenturl;
	}
	public static String getAtt(WebElement e) {
		String att = e.getAttribute("value");
		return att;
		
	}
}
	


