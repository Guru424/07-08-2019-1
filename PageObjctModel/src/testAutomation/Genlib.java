package testAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


import utility.ExcelUtils;
import utility.LoggerUtils;


public class Genlib 

{

	public static String invokeTest(String className)
	{
		String strData;
		String [] arrData = null;
		String datFile, sheetName;
		int testRunStatusCol;
		
		try
		{
			// Get the data file and data file sheet name from TestConfig file
			strData = ExcelUtils.readExcelRowWithChkVal(Globals.CONFIG_FILE_NAME, Globals.CONFIG_SHEET_NAME, className);
			arrData = strData.split("\\|");
			if (arrData[0].equals(className))
			{
				datFile = Globals.DATA_FILE_PATH + arrData[1];
				sheetName = arrData[2];
				testRunStatusCol = Integer.parseInt(arrData[3]);
				// Reading data from the data file
				strData = ExcelUtils.readExcelRowWithChkVal(datFile, sheetName, className);
				arrData = strData.split("\\|");
				if (arrData[0].equals(className))
				{
					Class cls = Class.forName(Globals.TESTS_ROOT + "." + arrData[2]);
					Object obj = cls.newInstance();
					Class [] params = new Class [] {String.class};
					Object [] args = new Object [] {new String(strData)};
					Method method = cls.getDeclaredMethod(arrData[3], params);
					Object testRunStatus = method.invoke(obj, args);
					setTestRunStatus(strData, (String) testRunStatus, datFile, sheetName, testRunStatusCol);
					return (String) testRunStatus;
				}
				else
				{
					//Assert.assertTrue(false, "Test Class not found");;
					return "Fail";
				}
				
			}
			else
			{
				return "Fail";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Fail";
		}

	}

	private static void setTestRunStatus(String strData, String testRunStatus, String datFile, String sheetName, int testRunStatusCol)
	{
		String [] datArr = strData.split("\\|");
		String strRowNum = datArr[(datArr.length - 1)];
		int rowNum = Integer.parseInt(strRowNum);
		ExcelUtils.setExcelFile(datFile, sheetName);
		ExcelUtils.setCellData(testRunStatus, datFile, rowNum, testRunStatusCol);
		
	}

	public static WebDriver webDriverSetUp()
	{
		WebDriver driver = null;
		
		switch (Globals.BROWSER)
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver", Globals.CHROME_DRIVER_PATH);
				ChromeOptions chromeOptions = new ChromeOptions();
				List chromeArgs = new ArrayList();
				//chromeArgs.add("user-data-dir=" + Globals.CHROME_DATA_DIR);
				chromeArgs.add("start-maximized");
				chromeOptions.addArguments(chromeArgs);
				
				//DesiredCapabilities dc = DesiredCapabilities.chrome();
				//dc.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				driver = new ChromeDriver(chromeOptions);
				break;
				
			case "firefox":
				System.setProperty("webdriver.gecko.driver", Globals.FIREFOX_DRIVER_PATH);
				//System.setProperty("webdriver.firefox.marionette", Globals.FIREFOX_DRIVER_PATH);
				driver = new FirefoxDriver();
				//ProfilesIni profile = new ProfilesIni();
				//FirefoxProfile autoProfile = profile.getProfile("FirefoxDriver");
				
				//DesiredCapabilities dc = DesiredCapabilities.firefox();
				//dc.setCapability(FirefoxDriver.PROFILE, autoProfile);
				//dc.setCapability("marionette", true);
				//driver = new FirefoxDriver(dc);
				//driver = new MarionetteDriver();
				break;

			case "ie":
				System.setProperty("webdriver.ie.driver", Globals.IE_DRIVER_PATH);
				DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
				dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				dc.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://172.16.8.85/configurator/CnfgtrMenu/Home.aspx");
				driver = new InternetExplorerDriver(dc);
				driver.manage().window().maximize();
				break;
				
			default:
				
		}

		LoggerUtils.loggerSetup();
		LoggerUtils.logInfo("Driver Setup");

		return driver;
		
	}
	
	public static void webDriverTearDown(WebDriver driver)
	{
		driver.close();
		driver.quit();
		LoggerUtils.logInfo("Driver tear down");
	}

	public static Properties readConfig()
	{
		File file = new File("config.properties");
		FileInputStream fis = null;
		
		try 
		{
			
			fis = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
		Properties prop = new Properties();

		try 
		{
			
			prop.load(fis);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		
		return prop;
		
	}
	
	public static void generate_screenshot(WebDriver driver, String path) {
		// TODO Auto-generated method stub
		 File screenshot_page= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(screenshot_page, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sleep(int mSec)
	{
		try {
			Thread.sleep(mSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void tearDown(WebDriver driver)
	{
		driver.close();
	}

	
	
}
