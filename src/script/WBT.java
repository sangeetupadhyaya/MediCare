package script;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.AutoUtility;
import generic.Excel;

public class WBT extends BaseTest 
{
	@Test	
public  void testWBT ()
{
		//Logger log = Logger.getLogger("WBT");
		//log.info("My 1st log");
	int r = Excel.getRowCount(INPUT_PATH, "Sheet1");
	log.info("RowCount:"+r);
	String v = Excel.getCellValue(INPUT_PATH, "Sheet1", 0, 0);
	log.info("CellValue:"+v);
    //Reporter.log("Executing WBT test",true);
    Assert.fail();

/*	String s = AutoUtility.now();
	AutoUtility.getScreenshot(SCREENSHOT_PATH+s+"desktop.png");
	AutoUtility.getScreenshot(driver,SCREENSHOT_PATH+s+"page.png");
	*/
}	
}

	
	
	
	/*AutoUtility.getScreenshot("d:/desktop.png");
	System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8080/login.do  ");
	AutoUtility.getScreenshot(driver,"d:/page.png");
}*/
		

	
