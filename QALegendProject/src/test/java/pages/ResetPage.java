package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtilities;

public class ResetPage 
{
	WebDriver driver;
	public ResetPage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailAddress_field;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement sendPasswordResetLink_button;
	@FindBy(xpath = "//span[@class='help-block']")
	WebElement error_message;
	
	public void enteremailAddress(String emailAddress)
	{
		WebElementUtilities.enterValue(emailAddress_field, emailAddress);
	}
	public HomePage clickOnSendPasswordResetLinkButton()
	{
		WebElementUtilities.clickOnElement(sendPasswordResetLink_button);
		return new HomePage(driver);
	}
	public String getErrorMessage()
	{
		String text = WebElementUtilities.getText(error_message);
		return text;
	}
}
