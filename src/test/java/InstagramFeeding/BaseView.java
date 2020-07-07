package InstagramFeeding;

import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;

public class BaseView {

	public InstagramAppication app=InstagramAppication.getInstance();
	public InstagramAppication getApp()
	{
		if (null==app)
			app=InstagramAppication.getInstance();
		return app;
	}
	
	public AppiumDriver getDriver()
	{
		
			return getApp().getDriver();
	}
	
	public Wait<MobileDriver> getMobileWait()
	{
		return getApp().getMobileWait();
	}
}
