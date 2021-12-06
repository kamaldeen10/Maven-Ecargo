package com.bkg.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class base {

	public WebDriver driver;
	public Properties Prop;
	
	public  static Logger log =LogManager.getLogger(base.class.getName());

	public WebDriver Initializedriver () throws IOException
	{
	Prop = new Properties();
	
	FileInputStream Fis = new FileInputStream(System.getProperty("user.dir")+"\\resources\\data.properties");
     Prop.load(Fis);
     
  //send browser parameter through Mvn cmnd   
     
//String browserName =System.getProperty("browser")  ; 
     
	String browserName = Prop.getProperty("browser");
	
	
	
	if (browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir")+"\\driver\\chromedriver_95.exe"));	
		// driver = new ChromeDriver();
		//.chromedriver().setup();
		driver = new ChromeDriver();
		 driver.manage().window().maximize();	
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
	}
	else if (browserName.equals("firefox"))
		{

	System.setProperty("webdriver.gecko.driver",(System.getProperty("user.dir")+"\\driver\\geckodriver.exe"));	
	     driver = new FirefoxDriver();
		 driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		}
	
		return driver;
	
		}
	
		
	
	public String getScreenShotPath2(String testCaseName, WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\ScreenshotPass\\"+testCaseName+".png";
	
		FileUtils.copyFile(source,new File(destinationFile));
		return 	destinationFile	;		
		
	  } 
		
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);			 
		String destinationFile = System.getProperty("user.dir")+"\\ScreenshotFail\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return 	destinationFile	;					
		
	  } 
	


	
	

}



