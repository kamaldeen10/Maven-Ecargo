package com.bkg.bookingpageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EBookingTabscreens {

	WebDriver driver ;
	public EBookingTabscreens(WebDriver driver) {
		
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//md-pagination-wrapper//md-tab-item[contains(@class,'md-tab ng-scope ng-isolate-scope') and contains(text(), 'Booking')]")
	WebElement Bookingtab;
	@FindBy(xpath="//button[@ng-click='showNotes(tab)']")
	WebElement Notesbutton;
	@FindBy(xpath="//md-input-container//textarea[@ng-model='notes']")
	WebElement Notes;
	@FindBy(xpath="//div//button[contains(@class, 'md-primary md-raised md-button') and contains(text(), 'Save')]")
	WebElement NotesSave;
	@FindBy(xpath="//button[@ng-click='cancel()']")
	WebElement BookingClose;
	
	@FindBy(xpath="//button[@ng-click='sendFFR(tab)']")
	WebElement SendFFR;
	@FindBy(xpath="//button[@ng-click='send()']")
	WebElement SendFFRsend;	
	@FindBy(xpath="//md-dialog-actions//button[@ng-click='dialog.hide()']")
	WebElement PromptOK;
	@FindBy(xpath="//button[@ng-click='sendFWB(tab)']")
	WebElement SendFWB;	
	
	@FindBy(xpath="//input[@ng-model='tab.createRequest.chargesheader.$$otherchargestotAmnt']")
	WebElement OtherCharges;	
	@FindBy(xpath="//md-input-container[@class = 'mr-r5 flex-22 md-input-has-value']//input[@ng-model='tab.createRequest.chargesheader.totAmnt']")
	WebElement TotalDue;
	
	@FindBy(xpath="//button[@ng-click='tab.ui.showAllButtons=!tab.ui.showAllButtons']")
	WebElement ShowCancelbutton;
	@FindBy(xpath="//button[@ng-click='cancelBooking()']")
	WebElement BkgCancelbutton;
	 
	
	@FindBy(xpath="//md-select [@ng-model='request.cancelOption']")
	WebElement Allcateto;
	
	@FindBy(xpath="//md-option//div[contains(@class,'md-text ng-binding') and contains(text(), 'Return to GSA' )]")
	WebElement Choose_AllcatetoGSA;
	
	@FindBy(xpath="//button[contains(@class,'md-primary md-raised md-button')][@ng-click='save()']")
	WebElement CancelSave;
	
	@FindBy(xpath="//md-icon[@ng-click='removeTab($event)']")
	WebElement CloseTab;
	
	
	public WebElement CloseTab()
	{
		return CloseTab;
	}
	
	public WebElement Bookingtab()
	{
		return Bookingtab;
	}
		
	
		public WebElement Notesbutton()
	{
		return Notesbutton;
	}
		
		
	public WebElement Notes()
	{
		return Notes;
	}	
	public WebElement NotesSave()
	{
		return NotesSave;
	}
	public WebElement BookingClose()
	{
		return BookingClose;
	}
	public WebElement SendFFR()
	{
		return SendFFR;
	}
		public WebElement SendFFRsend()
	{
		return SendFFRsend;
	}
		
		public WebElement PromptOK()
	{
		return PromptOK;
	}
		public WebElement SendFWB()
	{
		return SendFWB;
	}
		public WebElement OtherCharges()
	{
		return OtherCharges;
	}
		public WebElement TotalDue()
	{
		return TotalDue;
	}
		public WebElement BkgCancelbutton()
		{
			return BkgCancelbutton;
		}
			
		public WebElement ShowCancelbutton()
		{
			return ShowCancelbutton;
		}
		public WebElement Allcateto()
		{
			return Allcateto;
		}
		public WebElement Choose_AllcatetoGSA()
		{
			return Choose_AllcatetoGSA;
		}
		public WebElement CancelSave()
		{
			return CancelSave;
		}	

}
