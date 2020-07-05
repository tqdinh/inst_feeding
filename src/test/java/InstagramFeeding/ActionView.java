package InstagramFeeding;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class ActionView {
	private static AppiumDriver driver=null;
	private static DesiredCapabilities capabilities = null;
	private static Wait<MobileDriver> mobileWait;
	
	
	protected static  class LaucherActivityElements
	{
		
		static ArrayList<String>strLaucherActivityElement=new ArrayList() {{
			add("com.instagram.android:id/facebook_text_switcher");
			add("com.instagram.android:id/sign_up_with_email_or_phone");
			add("com.instagram.android:id/log_in_button");

			}};
		enum enum_element
		{
		
			facebook_text_switcher(0),
			sign_up_with_email_or_phone(1),
			log_in_button(2);
			
	        public int getVal() {
	            return val;
	        }

	        private int val = 0;

	        enum_element(int val) {
	            this.val = val;
	        }

	        public String getString() {
	            return strLaucherActivityElement.get(val);
	        }
		}

		public static void ContinueAsFB()
		{
			By mobileBy= By.id(enum_element.facebook_text_switcher.getString());
			
			SleepUntilInmilisecs(mobileBy, 5);
			
			MobileElement mobileElement =(MobileElement) driver.findElement(mobileBy);
			mobileElement.click();
			
		}
	}
	
	
	

	
	

	@BeforeMethod
	private void before() {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", AppConfiguration.deviceName);
		
		capabilities.setCapability("automationName", AppConfiguration.automationName);
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, AppConfiguration.platformname);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AppConfiguration.APP_PACKAGE);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AppConfiguration.APP_ACTIVITY);

		try {
			driver = new AndroidDriver(new URL(AppConfiguration.url_automatic_server), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod
	private void after() {
		//driver.quit();
	}
	
	
	@Test
	public void Testing()
	{
		LaucherActivityElements.ContinueAsFB();
		
	}
	
	
	
	
	public void onActionScroolUp()
	{
		
	}
	
	
	public void onActionScroolDown()
	{
		
	}
	
	private static  Wait<MobileDriver> setupFluentWait(int timeoutInSeconds, int pollingTimeInSeconds) {
		Wait<MobileDriver> fluentWait = new FluentWait<MobileDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds)).ignoring(NoSuchElementException.class);
		return fluentWait;
	}

	public static  void SleepUntilInmilisecs(By object, int milisecs) {
		mobileWait = setupFluentWait(milisecs, 1);
		mobileWait.until(ExpectedConditions.visibilityOfElementLocated(object));
	}
	
	
}
