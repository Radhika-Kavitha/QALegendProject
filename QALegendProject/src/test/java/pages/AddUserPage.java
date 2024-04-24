package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtilities;

public class AddUserPage 
{
	WebDriver driver;
	public AddUserPage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath = "//input[@id='surname']")
	WebElement prefix_Name_Field;
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement first_Name_Field;
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement last_Name_Field;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email_ID_Field;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username_Field;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password_Field;
	@FindBy(xpath = "//input[@id='confirm_password']")
	WebElement confirm_Password_Field;
	@FindBy(xpath = "//input[@id='cmmsn_percent']")
	WebElement sales_Commision_Percentage_Field;
	@FindBy(xpath = "//button[@id='submit_user_button']")
	WebElement save_Button;
	public void enterPrefixName(String prefixName)
	{
		WebElementUtilities.enterValue(prefix_Name_Field, prefixName);
	}
	
	public void enterFirstName(String firstName)
	{
		WebElementUtilities.enterValue(first_Name_Field, firstName);
	}
	public void enterLastName(String lastName)
	{
		WebElementUtilities.enterValue(last_Name_Field, lastName);
	}
	public void enterEmailID(String emailId)
	{
		WebElementUtilities.enterValue(email_ID_Field, emailId);
	}
	public void enterUserName(String userName)
	{
		WebElementUtilities.enterValue(username_Field, userName);
	}
	public void enterPassword(String passwords)
	{
		WebElementUtilities.enterValue(password_Field, passwords);
	}
	public void enterConfirmPassword(String confirmPassword)
	{
		WebElementUtilities.enterValue(confirm_Password_Field, confirmPassword);
	}
	public void entersalesCommisionPercentage(String salesCommisionPercentageField)
	{
		WebElementUtilities.enterValue(sales_Commision_Percentage_Field, salesCommisionPercentageField);
	}
	public UsersPage clickOnSaveButton()
	{
		WebElementUtilities.clickOnElement(save_Button);
		return new UsersPage(driver);
	}
}
