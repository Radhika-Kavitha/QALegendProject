package test;

import java.io.IOException;
import java.time.Duration;

import org.qalegend.automation_core.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserManagementPage;
import pages.UsersPage;

public class UsersPageTest extends Base
{
	@Test
	public void verifyUsersManagePageTitle() throws IOException
	{
		String userName =ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.integerDataRead(3, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home = loginObj.clickOnLoginButton();
		HomePage homeObj = new HomePage(driver);
		homeObj.clickOnEndTourButton();
		UserManagementPage user_manage = homeObj.clickOnUserManagementButton();
		UserManagementPage user_ManagementObj = new UserManagementPage(driver);
		UsersPage users_page = user_ManagementObj.clickOnUserButton();
		UsersPage usersObj = new UsersPage(driver);
		String actual_Title = driver.getTitle();
		System.out.println(actual_Title);
		String expected_Title = ExcelUtility.stringDataRead(3, 1, Constants.USERS_MANAGE_PAGE_DATA);
		Assert.assertEquals(actual_Title, expected_Title, Messages.TITLE_MESSAGES);
	}
}
