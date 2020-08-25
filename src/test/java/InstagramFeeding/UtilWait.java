package InstagramFeeding;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class UtilWait {
	
	
	public static void Wait(int delay_in_second)
	{
		InstagramAppication app = InstagramAppication.getInstance();
		By by = By.id("dummy");
		MobileElement element = app.findElement(by, delay_in_second);
	}


}
