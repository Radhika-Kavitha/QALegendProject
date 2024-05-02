package test;

import org.qalegend.automation_core.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ResetPage;

public class ResetPageTest extends Base
{
	@Test(priority = 4, groups = "Smoke")
	public void verifyResetPageTitle() 
	{
		
		LoginPage loginObj = new LoginPage(driver);
		ResetPage reset_Page = loginObj.clickOnForgotYourPassword();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = ExcelUtility.stringDataRead(0, 0, Constants.RESET_PAGE_DATA);
		Assert.assertEquals(actualTitle, expectedTitle, Messages.TITLE_MESSAGES);
	}
	
	@Test(priority = 5, enabled = false, groups = "Sanity")
	public void verifyErrorMessageWithInvalidEmailId() 
	{
		String emailID = ExcelUtility.stringDataRead(2, 0, Constants.RESET_PAGE_DATA); 
		LoginPage loginObj = new LoginPage(driver);
		ResetPage reset_Page = loginObj.clickOnForgotYourPassword();
		ResetPage resetObj = new ResetPage(driver);
		resetObj.enteremailAddress(emailID);
		resetObj.clickOnSendPasswordResetLinkButton();
		String actual_errorMessage = resetObj.getErrorMessage();
		String expected_errorMessage = ExcelUtility.stringDataRead(3, 0, Constants.RESET_PAGE_DATA);
		Assert.assertEquals(actual_errorMessage, expected_errorMessage, Messages.ERROR_MESSAGES);
	}
	
}
