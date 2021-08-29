package com.bkg.bookingpageobjects;

import java.net.SocketTimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Elogin {
	
	 public WebDriver driver ;
	 
	public Elogin(WebDriver driver) {
		
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}
	
	 @FindBy(xpath="//input[@ng-model='userLogin.userName']")
	WebElement Username;
		@FindBy(xpath="//input[@ng-model='userLogin.password']")
	WebElement Password;
		@FindBy(xpath="//button[@ng-click='login()']")
	WebElement Login;
		@FindBy(xpath="//span[contains(@class,'ng-binding') and contains(text(), 'sky.admin')]")
	WebElement user;
	
	
	public WebElement Username()
	{
		
		return Username;
	}
	public WebElement Password()
	{
		return Password;
	}
	public WebElement Login()
	{
		return Login;
	}
	public WebElement user()
	{
		
		return user;
		
	}
	
	public static void Waittilljquesryupdated(WebDriver driver) throws InterruptedException, SocketTimeoutException {
//		JavascriptExecutor js = null;
		 boolean Status = false;
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i=1; i<10; i++) {
			if (js == null) {
				Thread.sleep(150);
				js = (JavascriptExecutor) driver;
				continue;
			} else {
				try {
					while(!(js.executeScript("return document.readyState").equals("complete")))
					{
	//					System.out.println("dom state is" +(js.executeScript("return document.readyState")));
//						Thread.sleep(150);
					}
					Status = true;
					if (Status = true) { Thread.sleep(250); break; }
				} catch (Exception e) {
					continue;
				}
			}
		}	
	}
	
	
	}

