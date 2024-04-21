package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtilities;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName_field;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password_field;
	@FindBy(xpath = "//input[@name='remember']")
	WebElement rememberMeCheckBox;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement loginButton;
	@FindBy(xpath = "//a[@class='btn btn-link']")
	WebElement forgotPassword;
	@FindBy(xpath = "//span[@class='help-block']")
	WebElement error_message;
	
	public void enterUserName(String userName)
	{
		WebElementUtilities.enterValue(userName_field, userName);
	}
	public void enterPassword(String pass_word)
	{
		WebElementUtilities.enterValue(password_field, pass_word);
	}
	public void selectRememberMeCheckBox()
	{
		WebElementUtilities.clickOnElement(rememberMeCheckBox);
	}
	public HomePage clickOnLoginButton()
	{
		WebElementUtilities.clickOnElement(loginButton);
		return new HomePage(driver);
	}
	public ResetPage clickOnForgotYourPassword()
	{
		WebElementUtilities.clickOnElement(forgotPassword);
		return new ResetPage(driver);
	}
	public String getErrorMessage()
	{
		String text = WebElementUtilities.getText(error_message);
		return text;
	}
}
