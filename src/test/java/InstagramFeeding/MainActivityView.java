package InstagramFeeding;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MainActivityView extends BaseView {

	AppiumDriver driver = null;
	Wait<MobileDriver> mobileWait = null;

	MainActivityViewModel viewModel = null;

	public void InitMyActivity() {
		this.driver = getDriver();
		this.mobileWait = getMobileWait();

	}

	@BeforeMethod
	public void before() {
		InitMyActivity();

	}

	@AfterMethod
	public void after() {

		driver.quit();
	}

	@Test
	public void test() {
		// ScrollRight();
		clickTabOnNavigationBar();
	}

	public void clickTabOnNavigationBar() {

		String xpath_tabs = "(//*[@resource-id=\"com.instagram.android:id/tab_bar\"]/child::*)";
		String xpath_home_page = xpath_tabs + "[1]";
		String xpath_home_explore = xpath_tabs + "[2]";
		String xpath_home_camera = xpath_tabs + "[3]";
		String xpath_home_activity = xpath_tabs + "[4]";
		String xpath_home_profile = xpath_tabs + "[5]";

		By by_explore = By.xpath(xpath_home_explore);
		MobileElement element_explore = app.findElement(by_explore, 3);
		if (null != element_explore) {
			element_explore.click();

			try {
				Thread.sleep(1000);
				for (int i = 0; i < 50; i++) {

					MultiTouchAction m = new MultiTouchAction(this.driver);
					m.add(getTouchAction()).add(getTouchAction()).perform();
					Thread.sleep(1000);
					touchSomeOneStory();
					
					
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public boolean BackClick() {

		boolean ret=false;
		By by_back = By.id("com.instagram.android:id/action_bar_button_back");
		MobileElement element_back = app.findElement(by_back, 1);
		if (null != element_back)
		{
			ret=true;
			element_back.click();
			
		}

		return ret;
	}

	public void ViewSomeActivityOnExplorer() {
		// clickTabOnNavigationBar
	}

	public TouchAction getTouchAction() {

		int screenX = this.driver.manage().window().getPosition().getX();
		int screenY = this.driver.manage().window().getPosition().getX();
		int sizeX = this.driver.manage().window().getSize().getWidth();
		int sizeY = this.driver.manage().window().getSize().getHeight();

		TouchAction toa = new AndroidTouchAction(this.driver);

		int number_random1 = 2;// (int)getRandomNumber(2,5);
		int number_random2 = 5;// (int)getRandomNumber(2,5);
		LongPressOptions lpo = new LongPressOptions().withDuration(Duration.ofMillis(100))
				.withPosition(new PointOption().point(sizeX / number_random1, sizeY * number_random2 / 10));
		toa.longPress(lpo).moveTo(new PointOption().point(sizeX / number_random1, sizeY*(number_random2-2)/10)).release();

		return toa;

	}

	public double getRandomNumber(double min, double max) {
		double ret = 0;
		ret = (Math.random() * ((max - min) + 1)) + min;
		return ret;
	}

	public void touchSomeOneStory() {

		int screenX = this.driver.manage().window().getPosition().getX();
		int screenY = this.driver.manage().window().getPosition().getX();
		int sizeX = this.driver.manage().window().getSize().getWidth();
		int sizeY = this.driver.manage().window().getSize().getHeight();

		TouchAction toa = new AndroidTouchAction(this.driver);

		int number_random = (int) getRandomNumber(2, 9);
		toa.press(new PointOption().point(sizeX / number_random, sizeY * number_random / 10)).release().perform();

		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		By by = By.id("bottom_sheet_container");
		MobileElement element = app.findElement(by, 1);
		if(null!=element)
		{
			WatchVideoAndSweepDown();
		}
		else
		{
			SweepMultipleImageLeft();
		}
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(true!=BackClick())
		{
			closeVideoView();
		}
		
		
		
		
	}
	
	public void LikePost()
	{
		By by_like = By.id("com.instagram.android:id/row_feed_button_like");
		MobileElement element_like = app.findElement(by_like, 1);
		if (null != element_like)
			element_like.click();
		
	}
	public void SavePost()
	{
		By by = By.id("com.instagram.android:id/row_feed_button_save");
		MobileElement element = app.findElement(by, 1);
		if (null != element)
			element.click();
		
	}
	
	public void SweepMultipleImageLeft()
	{
		By by_page_indicator=By.id("com.instagram.android:id/carousel_page_indicator");
		MobileElement element_page_indicator = app.findElement(by_page_indicator, 1);
		if (null != element_page_indicator)			
		{
			// get position of element 
			
			
			MobileElement element_carousel_image=app.findElement(By.id("com.instagram.android:id/carousel_image"), 1);
			if(null!=element_carousel_image)
			{
				
				int numberOfImg=0;
				String content_desc=element_carousel_image.getAttribute("content-desc");
				String patter_string="\\s\\d\\sof\\s\\d\\s";
				Pattern r = Pattern.compile(patter_string);
				  Matcher m = r.matcher(content_desc);
			      if (m.find( )) {
			    	 
			    	  String numberAOfBPattern="\\s\\d\\s$";
			    	  String stringNumberFound=m.group(0);
			    	  
			    	  Pattern numberFormat = Pattern.compile(numberAOfBPattern);
			    	  Matcher numberMatch = numberFormat.matcher(stringNumberFound);
			    	  if (numberMatch.find( ))
			    	  {
			    		  String str_number=numberMatch.group(0).toString().trim();
			    		  numberOfImg=Integer.parseInt(str_number);
			    	  }
			    	  
			    	  
			    	 
			    	  
			       
			      }
				
				for(int i =0;i<numberOfImg;i++)
				{
					Point location_img=element_carousel_image.getLocation();
					int width_img=element_carousel_image.getSize().getWidth();
					int heigh_img=element_carousel_image.getSize().getHeight();
					
		
					
					Point startPosition=new Point(location_img.x+width_img*7/10,location_img.y+heigh_img/2);
					Point endPosition=new Point(location_img.x+10,location_img.y+heigh_img/2);
					
					TouchAction toa = new AndroidTouchAction(this.driver);
					LongPressOptions lpo = new LongPressOptions().withDuration(Duration.ofMillis(1))
							.withPosition(new PointOption().point(startPosition));
					toa.longPress(lpo).moveTo(new PointOption().point(endPosition)).release().perform();
				}
				
				
			}
		}
		
		
	}

	
	public void WatchVideoAndSweepDown()
	{
		
		By by = By.id("bottom_sheet_container");
		MobileElement element = app.findElement(by, 1);
		if(null!=element)
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int sizeX = this.driver.manage().window().getSize().getWidth();
			int sizeY = this.driver.manage().window().getSize().getHeight();
			
			TouchAction toa0 = new AndroidTouchAction(this.driver);
//			TouchAction toa1 = new AndroidTouchAction(this.driver);

			LongPressOptions lpo0 = new LongPressOptions().withDuration(Duration.ofMillis(1))
					.withPosition(new PointOption().point(sizeX*6/10,120));
			toa0.longPress(lpo0).moveTo(new PointOption().point(sizeX *6/ 10, sizeY * 9 / 10)).release();
			
			
//			LongPressOptions lpo1 = new LongPressOptions().withDuration(Duration.ofMillis(1))
//					.withPosition(new PointOption().point(sizeX*6/10,120));
//			toa1.longPress(lpo1).moveTo(new PointOption().point(sizeX *6/ 10, sizeY * 9 / 10)).release();
			
			MultiTouchAction m = new MultiTouchAction(this.driver);
			m.add(toa0).add(toa0).perform();
		}
		
	}
	public void closeVideoView() {

		By by_close = By.id("com.instagram.android:id/close_button");
		MobileElement element_close = app.findElement(by_close, 1);
		if (null != element_close)
			element_close.click();

	}

	public void longTouchSomeOneStory() {

		int screenX = this.driver.manage().window().getPosition().getX();
		int screenY = this.driver.manage().window().getPosition().getX();
		int sizeX = this.driver.manage().window().getSize().getWidth();
		int sizeY = this.driver.manage().window().getSize().getHeight();

		TouchAction toa = new AndroidTouchAction(this.driver);

		int number_random = (int) getRandomNumber(2, 9);

		LongPressOptions lpo = new LongPressOptions().withDuration(Duration.ofMillis(1000))
				.withPosition(new PointOption().point(sizeX / number_random, sizeY * number_random / 10));
		toa.longPress(lpo).release().perform();

	}

}
