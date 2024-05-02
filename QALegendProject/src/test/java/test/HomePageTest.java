package test;

import org.qalegend.automation_core.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.listeners.Retry_Analyzer;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base
{
	@Test(priority = 6, groups = "Smoke")
	public void verifyHomePageTitle() 
	{
		String userName =ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.integerDataRead(3, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home = loginObj.clickOnLoginButton();
		String actual_Title = driver.getTitle();
		System.out.println(actual_Title);
		String expected_Title = ExcelUtility.stringDataRead(2, 0, Constants.HOME_PAGE_DATA);
		Assert.assertEquals(actual_Title, expected_Title, Messages.TITLE_MESSAGES);
	}
	
	@Test(priority = 7, groups = {"Sanity", "Regression"}, retryAnalyzer = Retry_Analyzer.class)
	public void verifyUserLoginDate() 
	{
		String userName =ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.integerDataRead(3, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home = loginObj.clickOnLoginButton();
		HomePage homeObj = new HomePage(driver);
		String actual_logindate = homeObj.getLoginDate();
		String expected_logindate = homeObj.getCurrentDate();
		Assert.assertEquals(actual_logindate, expected_logindate, Messages.LOGIN_DATE_FAILED);
	}
}
