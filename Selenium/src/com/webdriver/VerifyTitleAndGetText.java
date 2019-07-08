package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyTitleAndGetText {
public static void main(String[] args) {
	
	WebDriver driver=new FirefoxDriver();
	driver.get("http://127.0.0.1/orangehrm-2.6/login.php");
	
	String title=driver.getTitle();
	if(title.equals("OrangeHRM - New Level of HR Management"))
	{
		System.out.println("Titlematched");
	}
	else
	{
		System.out.println("Title not matached");
	}
	
	driver.findElement(By.name("txtUserName")).sendKeys("admin");
	driver.findElement(By.name("txtPassword")).sendKeys("admin");
	driver.findElement(By.name("Submit")).click();
	
	driver.switchTo().frame(0);
	driver.findElement(By.xpath(".//*[@id='standardView']/div[3]/div[1]/input[1]")).click();
	
	String empid=driver.findElement(By.xpath(".//*[@id='txtEmployeeId']")).getAttribute("value");
	System.out.println("Emp id is="+empid);
}
}
