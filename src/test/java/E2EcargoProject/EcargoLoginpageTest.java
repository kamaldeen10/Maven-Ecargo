package E2EcargoProject;


import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bkg.config.Config;
import com.bkg.excel.utility.ExcelUtil;
import com.bkg.base.base;
import com.bkg.bookingpageobjects.EBookingCreate;
import com.bkg.bookingpageobjects.ELandingpage;
import com.bkg.bookingpageobjects.Elogin;





public class EcargoLoginpageTest extends base {
	public    WebDriver driver;
	public  static Logger log =LogManager.getLogger(base.class.getName());
	protected static String className;
	protected static HashMap<Integer, HashMap<String, String>> testData;
	private ThreadLocal<String> testName = new ThreadLocal<>();
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 EBookingCreate bkg = new EBookingCreate(driver);
	 ELandingpage home = new ELandingpage(driver); 

	
	@BeforeTest
	public void Intialize () throws IOException {
		driver = Initializedriver();	
		log.info("Driver is Intialized");
		driver.get(Config.UAT_URL);
		log.info("Login Page Navigated");
		
	}
	
	@DataProvider(name = "getData", parallel = false)
	public Iterator<Object[]> getTestData() throws IOException {
		className = this.getClass().getSimpleName();
		//String excelFile = System.getProperty("user.dir")+ "\\TestData\\ECargo_TestData.xlsx";;
		String excelFile  = Config.TEST_DATA_FILE_PATH;
		testData = ExcelUtil.getTestData(excelFile, className);
		ArrayList <Object[]> dataProvider = new ArrayList<Object[]>();
		for (Integer currentKey : testData.keySet()) {
			dataProvider.add(new Object[] { testData.get(currentKey)});		
		}
		return dataProvider.iterator();	
	}
	
	 
	public   void   LoginCargoApp(HashMap<String, String> testdata) {		
		Elogin	login = new Elogin(driver);	
		login.Username().sendKeys(testdata.get("Username"));
		login.Password().sendKeys(testdata.get("Password"));
		login.Login().click();
		 
	}
	
	
	@Test(dataProvider = "getData")
	public  void Bookingflow (HashMap<String, String> testdata) throws IOException, InterruptedException
	{
		
		 LoginCargoApp(testdata);
		
		 
	}
	
	@AfterTest

	public void teardown()
	{
	driver.close();	

	}
	
	
	}
	
	

