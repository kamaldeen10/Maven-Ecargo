package com.bkg.bookingpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EEpouchTab {
	WebDriver driver ;
	public  EEpouchTab(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}


	@FindBy(xpath="//md-pagination-wrapper//md-tab-item[contains(@class,'md-tab ng-scope ng-isolate-scope') and contains(text(), 'Epouch')]")
	WebElement EpouchTab;
	@FindBy(xpath="//descendant::md-select[@ng-model='row.productid']")
	WebElement Type;
	@FindBy(xpath="//md-option[@ng-click='changeProduct(type,row)']//div[contains(@class , 'md-text ng-binding') and contains(text(), 'AWB')]")
	WebElement SelectType;
	@FindBy(xpath="//div//input[@ng-click='validateFileSelection(row,$event)']")
	WebElement ChooseFile;
	@FindBy(xpath="//button[@ng-click='save()']")
	WebElement SaveEpouch;
	@FindBy(xpath="//descendant::div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'Airwaybill copy')]")
	WebElement VerifyEpouch;
	public WebElement EpouchTab()
	{
		return EpouchTab;
	}
	public WebElement Type()
	{
		return Type;
	}
	public WebElement SelectType()
	{
		return SelectType;
	}
	public WebElement ChooseFile()
	{
		return ChooseFile;
	}
	public WebElement SaveEpouch()
	{
		return SaveEpouch;
	}
	public WebElement VerifyEpouch()
	{
		return VerifyEpouch;
	}
	
	
}
