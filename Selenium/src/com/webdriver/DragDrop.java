package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {
public static void main(String[] args) {
	
	WebDriver driver=new FirefoxDriver();
	driver.get("https://jqueryui.com/droppable/");
	
	Actions a=new Actions(driver);
	
	driver.switchTo().frame(0);
	WebElement source=driver.findElement(By.id("draggable"));
	WebElement target=driver.findElement(By.id("droppable"));
	
	a.dragAndDrop(source, target).perform();
	
	
}
}
