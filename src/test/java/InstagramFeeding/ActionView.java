package InstagramFeeding;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
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
	

	
//
//		static ArrayList<String> strElements = new ArrayList() {
//			{
//				add("com.instagram.android:id/facebook_text_switcher");
//				add("com.instagram.android:id/sign_up_with_email_or_phone");
//				add("com.instagram.android:id/log_in_button");
//
//			}
//		};
//
//		enum enum_element {
//
//			facebook_text_switcher(0), sign_up_with_email_or_phone(1), log_in_button(2);
//
//			public int getVal() {
//				return val;
//			}
//
//			private int val = 0;
//
//			enum_element(int val) {
//				this.val = val;
//			}
//
//			public String getString() {
//				return strElements.get(val);
//			}
//		}
//
//		
//	}
//
//	protected static class MainActivityElements {
//		static ArrayList<String> strElements = new ArrayList() {
//			{
//				add("com.instagram.android:id/action_bar_root");
//			}
//		};
//
//		enum enum_element {
//			layout_container_main(0);
//
//			public int getVal() {
//				return val;
//			}
//
//			private int val = 0;
//
//			enum_element(int val) {
//				this.val = val;
//			}
//
//			public String getString() {
//				return strElements.get(val);
//			}
//		}
//
//		public static By getByOfScroolDownNewfeed() {
//
//			By mobileBy = By.id(enum_element.layout_container_main.getString());
//			
//			List<MobileElement> list=driver.findElements(mobileBy);
//			return mobileBy;
//
//		}
//	}

	
	//}

	@AfterMethod
	private void after() {
		// driver.quit();
	}

	@Test
	public void Testing() {

//		LaucherActivityElements.ContinueAsFB();
		
//		By scrool = MainActivityElements.getByOfScroolDownNewfeed();
//		
//		for(int i=0;i<15;i++)
//		{
//			System.out.print("scroll "+i);
//			scrollBy(scrool, 100, -500);
//			
//		}
//		
		

		// 

	}

//	public void scrollBy(By locator, int xPixel, int yPixel) {
//		try {
//			
//			
//			Actions act = new Actions(driver);
//			act.moveToElement(driver.findElement(locator)).clickAndHold().moveByOffset(xPixel, yPixel).release()
//					.pause(1500).perform();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void onActionScroolUp() {
//
//	}
//
//	public void onActionScroolDown() {
//
//	}
//
//	private static Wait<MobileDriver> setupFluentWait(int timeoutInSeconds, int pollingTimeInSeconds) {
//		Wait<MobileDriver> fluentWait = new FluentWait<MobileDriver>(driver)
//				.withTimeout(Duration.ofSeconds(timeoutInSeconds))
//				.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds)).ignoring(NoSuchElementException.class);
//		return fluentWait;
//	}
//
//	public static boolean SleepUntilInmilisecs(By object, int milisecs) {
//		boolean ret = true;
//		try {
//			mobileWait = setupFluentWait(milisecs, 1);
//			mobileWait.until(ExpectedConditions.visibilityOfElementLocated(object));
//		} catch (Exception e) {
//			System.out.print(e.toString());
//			ret = false;
//		}
//
//		return ret;
//	}

}
