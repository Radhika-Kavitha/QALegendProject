package test;

import org.qalegend.automation_core.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.RandomDataUtility;
import org.qalegend.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserManagementPage;
import pages.UsersPage;

public class AddUserPageTest extends Base
{
	@Test(priority = 12, groups = "Smoke")
	public void verifyAddUserPageTitle() 
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
		UsersPage users_page = user_ManagementObj.clickOnUserButton();
		
		UsersPage usersObj = new UsersPage(driver);
		AddUserPage add_user_page = usersObj.clickOnAddUserButton();
		String actual_Title = driver.getTitle();
		System.out.println(actual_Title);
		String expected_Title = ExcelUtility.stringDataRead(0, 0, Constants.ADD_USER_PAGE_DATA);
		Assert.assertEquals(actual_Title, expected_Title, Messages.TITLE_MESSAGES);
	}
	
	@Test(priority = 13, groups = {"Sanity", "Regression"})
	public void verifyAddUser()  
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
		AddUserPage add_user_page = usersObj.clickOnAddUserButton();
		
		String firstName = RandomDataUtility.getFirstName();
		String lastName = RandomDataUtility.getLastName();
		String emailId = firstName+"."+lastName+"78@yahoo.com";
		String passwords = firstName+"."+lastName;
		String usersName = firstName+"."+lastName;
				
		
		AddUserPage addUserPageObj = new AddUserPage(driver);
		addUserPageObj.enterFirstName(firstName);
		addUserPageObj.enterLastName(lastName);
		addUserPageObj.enterEmailID(emailId);
		addUserPageObj.enterUserName(usersName);
		addUserPageObj.enterPassword(passwords);
		addUserPageObj.enterConfirmPassword(passwords);
		
		UsersPage user_pages = addUserPageObj.clickOnSaveButton();
		WaitUtility.waitUsingImplicityWait(driver);
		usersObj.enterEmailIdToSearchField(usersName);
		String actual_data = usersName;
		String search_data = usersObj.getSearchValue();
		System.out.println(search_data );
		Assert.assertEquals(actual_data, search_data, Messages.MISMAICH_WEBTABLE_DETAILS);
	}
	
	@Test(priority = 14, groups = {"Sanity", "Regression"})
	public void verifyUserLoginWithNewlyAddedUsers() 
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
		AddUserPage add_user_page = usersObj.clickOnAddUserButton();
		
		String firstName = RandomDataUtility.getFirstName();
		String lastName = RandomDataUtility.getLastName();
		String emailId = firstName+"."+lastName+"7823@yahoo.com";
		String passwords = firstName+"."+lastName;
		String usersName = firstName+"."+lastName;
					
		AddUserPage addUserPageObj = new AddUserPage(driver);
		addUserPageObj.enterFirstName(firstName);
		addUserPageObj.enterLastName(lastName);
		addUserPageObj.enterEmailID(emailId);
		addUserPageObj.enterUserName(usersName);
		addUserPageObj.enterPassword(passwords);
		addUserPageObj.enterConfirmPassword(passwords);
		UsersPage user_pages = addUserPageObj.clickOnSaveButton();
		
		WaitUtility.waitUsingImplicityWait(driver);
		usersObj.clickOnUserName();
		LoginPage re_login = usersObj.clickOnSignOutButton();
		
		WaitUtility.waitUsingImplicityWait(driver);
		String username_re = usersName;
		String password_re = passwords;
		loginObj.enterUserName(usersName);
		loginObj.enterPassword(passwords);
		HomePage home1 = loginObj.clickOnLoginButton();
		
		String actual_name = homeObj.getUserName();
		String expected_user = "Welcome "+firstName+",";
		System.out.println(actual_name);
		Assert.assertEquals(actual_name, expected_user, Messages.RE_LOGIN_FAILED);
	}

}
