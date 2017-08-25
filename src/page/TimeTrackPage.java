package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.AutoUtility;
import generic.BasePage;

public class TimeTrackPage extends BasePage {
	
	@FindBy(xpath="(//div[contains(text(),'settings')][1])")
	private WebElement settings;
	
	@FindBy(linkText="Licenses")
	private WebElement licenses;
	

	public TimeTrackPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickSettings()
	{
		log.info("Clicking on settings");
		AutoUtility.sleep(2);
		settings.click();
	}
	public void clickLicenses()
	{
		log.info("Clicking on licenses");
		licenses.click();
	}
	
	

}
