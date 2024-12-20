package com.SeleniumTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();		
		driver.get("http://quiz-fe.hematitecorp.com/");
		
//		WebDriver driver1=new FirefoxDriver();
//		
//		driver1.get("http://quiz-fe-test-hematitiecorp.com/");
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getPageSource());
		
		driver.navigate().to("http://hematiteweb.hematitecorp.com/");
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
		driver.manage().window().maximize();
		
		driver.manage().window().minimize();
		
		driver.manage().window().setSize(new Dimension(1024,768)); //import from selenium
		
//		driver1.switchTo().alert();
		
//		driver1.manage().getCookies();
		
		driver.close();
	}

}
