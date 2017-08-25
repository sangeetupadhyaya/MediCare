package generic;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage implements IAutoConst{
	public WebDriver driver;
	public long lngETO;
	public Logger log;
	public WebDriverWait wait;
	
	
	@FindBy(id="logoutLink") 
	private WebElement logoutLNK;       /*Initialization*/
	
	public BasePage(WebDriver driver)
	{
	String strETO =AutoUtility.getPropertyValue(CONFIG_PATH,"ETO");
	lngETO=Long.parseLong(strETO);
    wait = new WebDriverWait(driver,lngETO);
    log=Logger.getLogger(this.getClass());
    PageFactory.initElements(driver,this); /*declaration*/
	}
	public void clickLogout() /*utilization*/
	{
		AutoUtility.sleep(2);
		logoutLNK.click();
	}
	
	public void verifyTitle(String eTitle)
	{
		log.info("Expected Title:"+eTitle);
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			log.info("Title is matching");
		}
	catch(Exception e)
		{
		String aTitle = driver.getTitle();
		log.info("Actual Title:"+aTitle);
		log.info("Title is NOT matching");
		Assert.fail();
		}
	}
	public void verifyElementIsPresent(WebElement element)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			log.info("Element is Present");
		}
	catch(Exception e)
		{
		
		log.info("Element is NOT matching");
		Assert.fail();
		}
	
	}
}
		
		
		
	
	