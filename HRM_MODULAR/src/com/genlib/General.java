package com.genlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class General extends Global{
	WebDriver driver;
public void openbrowser(){
	driver=new FirefoxDriver();
	System.out.println("Firefox browser opened");
}

public void openApplication(){
	driver.get(url);
	System.out.println("HRMS Application opened");
}

public void login(){
	driver.findElement(By.name(username)).sendKeys(user);
	driver.findElement(By.xpath(password)).sendKeys(pwd);
	driver.findElement(By.name(loginbtn)).click();
	System.out.println("Login success");
}

public void logout(){
	driver.findElement(By.linkText(logoutlnk)).click();
	System.out.println("Logout success");
}

public void addEmp(){
	System.out.println("Added new Emp successfully");
}

public void closeBrowser(){
	driver.close();
	System.out.println("Browser closed");
}
}
