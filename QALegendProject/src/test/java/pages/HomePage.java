package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.DateUtility;
import org.qalegend.utilities.WebElementUtilities;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath = "//span[text()='XYZ PQR']")
	WebElement home_Name;
	@FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement login_Date;
	public String getHomeName()
	{
		String text = WebElementUtilities.getText(home_Name);
		return text;
	}
	public String getLoginDate()
	{
		String login_date = WebElementUtilities.getText(login_Date);
		return login_date;
	}
	public String getCurrentDate()
	{
		String current_date = DateUtility.getUserLoginDate("dd-MM-YYYY");
		return current_date;
	}
}
