package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.constants.Constants;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.WebElementUtilities;

public class UsersPage 
{
	WebDriver driver;
	public UsersPage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	
	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement add_Button;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement search_Field;
	@FindBy(xpath = "//td[@class='sorting_1']")
	WebElement user_Field_intheTable;
	@FindBy(xpath = "//a[@class='dropdown-toggle']//span[contains(text(),'kym tvm')]")
	WebElement profile_Field;
	@FindBy(xpath = "//a[@class='btn btn-default btn-flat' and contains(text(),'Sign Out')]")
	WebElement signOut_Button;
	@FindBy(xpath = "//a[@class='dropdown-toggle']//span")
	WebElement logined_user;
	
	public AddUserPage clickOnAddUserButton()
	{
		WebElementUtilities.clickOnElement(add_Button);
		return new AddUserPage(driver);
	}
	
	public void enterEmailIdToSearchField(String emailId)
	{
		WebElementUtilities.enterValue(search_Field, emailId );
	}
	public String getSearchValue()
	{
		String search_Text = WebElementUtilities.getText(user_Field_intheTable);
		return search_Text;
	}
	public void clickOnProfileButton()
	{
		WebElementUtilities.clickOnElement(profile_Field);
	}
	public LoginPage clickOnSignOutButton()
	{
		WebElementUtilities.clickOnElement(signOut_Button);
		return new LoginPage(driver);
	}
	public void clickOnUserName() {
		//WebElementUtility.clickOnElement(logined_user);
		WebElementUtilities.scrollAndClick(driver, logined_user);
	}
}
