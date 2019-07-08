package com.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample {

	@Test
	public void test()
	{
		System.out.println("Hello..Welcome to maven world..!");
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.co.in");
		driver.findElement(By.name("q")).sendKeys("Selenium testing");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
	}
}
