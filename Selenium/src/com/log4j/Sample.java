package com.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Sample {
	static Logger log=Logger.getLogger(Logger.class);
public static void main(String[] args) {
	DOMConfigurator.configure("log4j.xml");
	log.info("Create refrence of webdriver");
	WebDriver driver=new FirefoxDriver();
	log.info("Firefox browser opned");
	driver.get("http://google.co.in");
	log.info("Google page opned");
}
}
