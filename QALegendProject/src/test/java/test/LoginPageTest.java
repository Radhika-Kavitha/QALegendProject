package test;

import org.qalegend.automation_core.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.dataprovider.DataProviders;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends Base
{
	@Test(priority = 1, groups = "Smoke")
	public void verifyLoginPageTitle() 
	{
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = ExcelUtility.stringDataRead(0, 0, Constants.LOGIN_PAGE_DATA);
		Assert.assertEquals(actualTitle, expectedTitle, Messages.TITLE_MESSAGES);
	}
	
	@Test(priority = 2, groups = "Sanity")
	public void verifyUserLoginWithValidCredentials() 
	{
		String userName = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.integerDataRead(3, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		HomePage homeObj = new HomePage(driver);
		WaitUtility.waitUsingImplicityWait(driver);
		String actual_userName = homeObj.getHomeName();
		System.out.println(actual_userName);
		String expected_userName =ExcelUtility.stringDataRead(0, 0, Constants.HOME_PAGE_DATA );
		Assert.assertEquals(actual_userName, expected_userName, Messages.MISMAICH_HOMEUSERNAMES);
	}
	
	@Test(priority = 3, groups = {"Sanity", "Regression"}, dataProvider = "InvalidUserCredentials", dataProviderClass = DataProviders.class)
	public void verifyErrorMessageWhileLoginWithInvalidCredentials(String userName, String password) 
	{
		String expected_ErrorMessage = ExcelUtility.stringDataRead(5, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home = loginObj.clickOnLoginButton();
		String actual_ErrorMessage = loginObj.getErrorMessage();
		Assert.assertEquals(actual_ErrorMessage, expected_ErrorMessage, Messages.ERROR_MESSAGES);
	}
}
