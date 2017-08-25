package script;

import org.testng.annotations.Test;

import generic.Excel;
import page.LoginPage;
import page.TimeTrackPage;

public class ValidLoginLogout extends BaseTest
{
@Test(priority=1)
public void testValidLoginLogout()
{
	String un=Excel.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 0);
	String pw=Excel.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 1);
	String HPT=Excel.getCellValue(INPUT_PATH,"ValidLoginLogout", 1, 2);
	String LPT=Excel.getCellValue(INPUT_PATH,"ValidLoginLogout", 1, 3);
	//enter valid user name
	LoginPage loginPage=new LoginPage(driver);
			loginPage.setUserName(un);
	//enter valid password	
			loginPage.setPassword(pw);
    // click on Login
			loginPage.clickLogin();
	//verify that home page is displayed
			TimeTrackPage ettPage=new TimeTrackPage(driver);
			ettPage.verifyTitle(HPT);
   // click on Logout
			ettPage.clickLogout();
	//verify that login page is displayed
	loginPage.verifyTitle(LPT);
}
}

