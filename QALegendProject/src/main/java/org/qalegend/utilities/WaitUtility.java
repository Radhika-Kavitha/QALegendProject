package org.qalegend.utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class WaitUtility 
{
	public static final long IMPLICIT_WAIT = 10;
	public static void waitUsingImplicityWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	}
}
