package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frames {
public static void main(String[] args) {
	
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://127.0.0.1/orangehrm-2.6/login.php");
	
	driver.findElement(By.className("loginText")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin");
	
	driver.findElement(By.cssSelector(".button")).click();
	
	//Enter the frame
	driver.switchTo().frame("rightMenu");
	
	driver.findElement(By.xpath(".//*[@id='standardView']/div[3]/div[1]/input[1]")).click();
	
	//Exit the frame
	driver.switchTo().defaultContent();
	
	driver.findElement(By.linkText("Logout")).click();
	
	driver.close();
}
}
