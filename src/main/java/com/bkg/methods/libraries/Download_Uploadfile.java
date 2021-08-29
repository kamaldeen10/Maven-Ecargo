package com.bkg.methods.libraries;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.bkg.bookingpageobjects.EEpouchTab;

public class Download_Uploadfile {
	static WebDriver driver ;
	
	//String downloadfilepath = (System.getProperty("user.dir")+"\\Downloads\\ActualAirwaybill.pdf");
	

	
	//	Downloadfile(downloadfilepath);
	

	public static void setClipBoard(String file) {
		
		StringSelection obj = new 	StringSelection (file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);		
					
	}
	
	
	public static void Downloadfile(String downloadfilepath) throws AWTException, InterruptedException {
		setClipBoard(downloadfilepath);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);		
		
	}
	
	public static  void upload() throws InterruptedException {
		EEpouchTab EPoTab = new EEpouchTab (driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// WebElement e =	driver.findElement(By.xpath("//div//input[@ng-click='validateFileSelection(row,$event)']"));
	//e.click();
   Actions act = new Actions(driver);
  // Thread.sleep(3000);
  // act.moveToElement(e).perform();
  // Thread.sleep(3000);
  // e.sendKeys("D:\\Arif\\file2.pdf");  
   
   js.executeScript("arguments[0].click()",EPoTab.ChooseFile());
   Thread.sleep(3000);
   act.moveToElement(EPoTab.ChooseFile()).perform();
   Thread.sleep(3000);
	String path =System.getProperty("user.dir")+"\\Uploadfile\\Uploadfile.pdf";
   EPoTab.ChooseFile().sendKeys(path);
	}

}
