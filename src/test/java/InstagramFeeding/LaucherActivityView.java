package InstagramFeeding;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public  class LaucherActivityView extends BaseView implements LaucherActivityViewModel.TestingAction {
	
	AppiumDriver driver=null;
	Wait<MobileDriver> mobileWait=null;
	
	LaucherActivityView()
	{
		this.driver=driver;
		this.mobileWait=mobileWait;
	
	}
	
	public void ContinueAsFB(String id) {
		By by=this.app.findById(id);
		MobileElement element=this.app.findElement(by, 1000);
		if(null!=element)
			element.click();
			
		
	}
			
}
