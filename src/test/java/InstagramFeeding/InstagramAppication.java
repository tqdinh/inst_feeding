package InstagramFeeding;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
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

public class InstagramAppication {

	private static AppiumDriver driver = null;
	private static DesiredCapabilities capabilities = null;
	private static Wait<MobileDriver> mobileWait;
	private static final int DEFAULT_TIMEOUT = 10000;// 10 secs ;

	private static InstagramAppication instance = null;

	public static InstagramAppication getInstance() {
		if (null == instance) {
			instance = new InstagramAppication();
		}
		return instance;
	}

	private InstagramAppication() {
		init();
	}

	
	public AppiumDriver getDriver()
	{
		return driver;
	}
	
	
	public Wait<MobileDriver> getMobileWait()
	{
		return mobileWait;
	}
	
	private void clean() {
		driver.quit();
	}

	private void init() {
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

	private void after() {
		driver.quit();
	}

	public  MobileElement findElement(By locator, int timeoutInSecond) {
		MobileElement ret = null;

		if(true==SleepUntilInmilisecs(locator, timeoutInSecond))
			ret = (MobileElement) driver.findElement(locator);

	//	System.out.print("found="+ret);
		
		return ret;
	}

	public By findById(String by_id)
	{
		By mobileBy= null;
		mobileBy=By.id(by_id);
		return mobileBy;
	}
	
	
	
	public boolean SleepUntilInmilisecs(By object, int timeoutInSecond) {
		boolean ret = true;
		try {
			mobileWait = setupFluentWait(timeoutInSecond, 1);
			mobileWait.until(ExpectedConditions.visibilityOfElementLocated(object));
		} catch (Exception e) {
			System.out.println("Sleep Until "+e.toString());
			ret = false;
		}
		return ret;
	}

	private Wait<MobileDriver> setupFluentWait(int timeoutInSeconds, int pollingTimeInSeconds) {
		Wait<MobileDriver> fluentWait = new FluentWait<MobileDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds)).ignoring(NoSuchElementException.class);
		return fluentWait;
	}

}
