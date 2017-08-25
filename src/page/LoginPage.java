package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.AutoUtility;
import generic.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(id="username")
	private WebElement usernameTXB;
	
	@FindBy(name="pwd")
	private WebElement passwordTXB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//nobr[contains(text(),'actiTIME')]")
	private WebElement version;
	
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errMsg;
	

	public LoginPage(WebDriver driver) {
		super(driver);
		}
	public void setUserName(String un)
	{
		usernameTXB.sendKeys(un);
		log.info("Entering username:"+un);
	}
	public void setPassword(String pw)
	{
		passwordTXB.sendKeys(pw);
		log.info("Entering password:"+pw);
	}
	public void clickLogin()
	{
		loginBTN.click();
		log.info("Clicking on Login");
	}
	
	public String getVersion()
	{
	String strVersion=version.getText();
	log.info("Version is:"+strVersion);
	return strVersion;
	}
	public void verifyErrMsgIsDisplayed()
	{
	log.info("verify Error Message is Displayed");
	AutoUtility.sleep(2);
	verifyElementIsPresent(errMsg);
	}
	}
