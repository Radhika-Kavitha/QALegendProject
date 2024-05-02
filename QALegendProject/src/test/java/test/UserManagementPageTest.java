package test;

import org.qalegend.automation_core.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserManagementPage;

public class UserManagementPageTest extends Base
{
	@Test(priority = 8, groups = {"Sanity", "Regression"})
	public void verifyUsersManagementOption() 
	{
		String userName =ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.integerDataRead(3, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home = loginObj.clickOnLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		WaitUtility.waitUsingImplicityWait(driver);
		homeObj.clickOnEndTourButton();
		UserManagementPage user_manage = homeObj.clickOnUserManagementButton();
		UserManagementPage user_ManagementObj = new UserManagementPage(driver);
		boolean user_status = user_ManagementObj.isUserEnable();
		Assert.assertTrue(user_status, Messages.USER_MANAGEMENT_OPTION_STATUS);
	}
	
	@Test(priority = 9, groups = {"Smoke", "Regression"})
	public void verifyRolesManagementOption() 
	{
		String userName =ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.integerDataRead(3, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home = loginObj.clickOnLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		WaitUtility.waitUsingImplicityWait(driver);
		homeObj.clickOnEndTourButton();
		UserManagementPage user_manage = homeObj.clickOnUserManagementButton();
		UserManagementPage user_ManagementObj = new UserManagementPage(driver);
		boolean role_status = user_ManagementObj.isRoleEnable();
		Assert.assertTrue(role_status, Messages.USER_MANAGEMENT_OPTION_STATUS);
	}
	
	@Test(priority = 10, groups = {"Sanity", "Regression"})
	public void verifySalesManagementOption() 
	{
		String userName =ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.integerDataRead(3, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home = loginObj.clickOnLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		WaitUtility.waitUsingImplicityWait(driver);
		homeObj.clickOnEndTourButton();
		UserManagementPage user_manage = homeObj.clickOnUserManagementButton();
		UserManagementPage user_ManagementObj = new UserManagementPage(driver);
		boolean sales_status = user_ManagementObj.isSaleEnable();
		Assert.assertTrue(sales_status, Messages.USER_MANAGEMENT_OPTION_STATUS);
	}
}
