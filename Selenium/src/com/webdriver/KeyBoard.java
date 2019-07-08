package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyBard {
public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver=new FirefoxDriver();
	driver.get("http://google.co.in");
	
	driver.findElement(By.name("q")).sendKeys("selenium");
	Thread.sleep(1000);
	for(int i=1;i<5;i++){
	driver.findElement(By.name("q")).sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(1000);
}
	
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
}
}
