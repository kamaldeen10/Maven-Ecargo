package E2EcargoProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.bkg.base.base;
import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;

public class Pdfutil_Test{
	public  static Logger log =LogManager.getLogger(base.class.getName());
PDFUtil pu = new PDFUtil();
	
	String Expectedpdf = System.getProperty("user.dir")+"\\Uploadfile\\ExpectedAirwaybill.pdf";
	
	String Actualpdf = System.getProperty("user.dir")+"\\Downloads\\ActualAirwaybill.pdf";
	
	String Resultfile = System.getProperty("user.dir")+"\\PdfResult";
	

	@Test
	public void pdfTest() throws IOException {	
				
		
		//pu.excludeText("65565570"+"\\d+");		
			pu.excludeText("18/09/2021"+"\\d+");	
	
			
			//pu.excludeText("\\d+");
			
						
	boolean isEquals = pu.compare(Expectedpdf, Actualpdf ,1 ,1);
	
	if (isEquals) {
		log.info("Both PDF files Same ");
		
	}
		
	else
	{
		log.info("Both PDF files are NOT Same ");
				
	}	
			
	}
	
	@Test(priority=2)
	public void compareTwoPDFVisually() throws IOException {
		
	pu.setCompareMode(CompareMode.VISUAL_MODE);
	pu.highlightPdfDifference(true);
	pu.setImageDestinationPath(Resultfile);
	pu.compare(Expectedpdf, Actualpdf , 1 ,1);
	
	log.info("Pdf Compare Process Completed");
		
	}
 	

	
}

