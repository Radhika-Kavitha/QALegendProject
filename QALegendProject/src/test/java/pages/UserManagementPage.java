package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtilities;

public class UserManagementPage 
{
	WebDriver driver;
	public UserManagementPage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath = "//span[@class='title' and contains(text(),'Users')]")
	WebElement user;
	@FindBy(xpath = "//span[@class='title' and contains(text(),'Roles')]")
	WebElement roles;
	@FindBy(xpath = "//span[@class='title' and contains(text(),'Sales Commission Agents')]")
	WebElement sales_commission_agents;
	public UsersPage clickOnUserButton()
	{
		WebElementUtilities.clickOnElement(user);
		return new UsersPage(driver);
	}
	public boolean isUserEnable()
	{
		boolean user_Status = WebElementUtilities.isElementEnabled(user);
		return user_Status;
	}
	public boolean isRoleEnable()
	{
		boolean role_Status = WebElementUtilities.isElementEnabled(roles);
		return role_Status;
	}
	public boolean isSaleEnable()
	{
		boolean sale_Status = WebElementUtilities.isElementEnabled(sales_commission_agents);
		return sale_Status;
	}
}
