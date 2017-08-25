package script;

import org.testng.annotations.Test;

import generic.Excel;
import page.LicensePage;
import page.LoginPage;
import page.TimeTrackPage;

public class VerifyProductEdition extends BaseTest {
	@Test(priority=3)
	public void testProductEdition()
	{
		String un=Excel.getCellValue(INPUT_PATH, "VerifyProductEdition", 1, 0);
		String pw=Excel.getCellValue(INPUT_PATH, "VerifyProductEdition", 1, 1);
		String LPT=Excel.getCellValue(INPUT_PATH,"VerifyProductEdition", 1, 2);
		
		//Get the version
		LoginPage loginPage = new LoginPage(driver);
		String version=loginPage.getVersion();
		
		//Enter valid user name
		loginPage.setUserName(un);
		//Enter valid password
		loginPage.setPassword(pw);
		
		//Click on Login
		loginPage.clickLogin();
		
		//Click Settings
		TimeTrackPage ettPage = new TimeTrackPage(driver);
		ettPage.clickSettings();
		
		//Click Licenses
		
		ettPage.clickLicenses();
		
		//Verify that Licenses page is displayed
		LicensePage licensePage = new LicensePage(driver);
		licensePage.verifyTitle(LPT);
		
		//verify product edition is same as version
		licensePage.compareProductEdition(version);

		//click on logout
		ettPage.clickLogout();
		
	}
		
		
		
		
}
