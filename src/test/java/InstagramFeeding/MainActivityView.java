package InstagramFeeding;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

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

	InstagramAppication app = null;

	public void InitMyActivity() {
		this.driver = getDriver();
		this.mobileWait = getMobileWait();
		viewModel = new MainActivityViewModel(this);
		app = this.getApp();

	}

	@BeforeMethod
	public void before() {
		InitMyActivity();

	}

	@AfterMethod
	public void after() {

		driver.quit();
	}

	public void isInCurrentActivity() {

	}

	@Test
	public void test() {
		// ScrollRight();
		// adb shell dumpsys window windows | grep -E "mCurrentFocus|mFocusedApp"

		clickTabOnNavigationBar();
	}

	public void clickTabOnNavigationBar() {

		String resource_id_of_tabs = viewModel.getTabResourceid();
		String xpath_tabs = String.format("(//*[@resource-id=\"%s\"]/child::*)", resource_id_of_tabs);

		System.out.println(xpath_tabs);
//		String xpath_home_page = xpath_tabs + "[1]";
		String xpath_home_explore = xpath_tabs + "[2]";
//		String xpath_home_camera = xpath_tabs + "[3]";
//		String xpath_home_activity = xpath_tabs + "[4]";
//		String xpath_home_profile = xpath_tabs + "[5]";
//		
//		System.out.println(xpath_tabs);

		By by_explore = By.xpath(xpath_home_explore);
		MobileElement element_explore = app.findElement(by_explore, 3);
		if (null != element_explore) {
			element_explore.click();
			SweepAction action = new SweepUp(this.driver);
			String stop_signature_of_explorer = viewModel.getStopSignWhenScrool();
			for (int i = 0; i < 1024; i++) {

				if (false == action.sweep(stop_signature_of_explorer)) {
					System.out.println(stop_signature_of_explorer);
					By by_explore_more = By.id(stop_signature_of_explorer);
					MobileElement element_explore_more = app.findElement(by_explore_more, 2);
					if (null != element_explore_more) {
						element_explore_more.click();

					}

				} else {
					clickRandomlyStory();
				}

			}

//			try {
//				Thread.sleep(1000);
//				for (int i = 0; i < 500; i++) {
//
//					MultiTouchAction m = new MultiTouchAction(this.driver);
//					m.add(getTouchAction()).add(getTouchAction()).perform();
//					Thread.sleep(1000);
//					touchSomeOneStory();
//
//					Thread.sleep(1000);
//				}
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		}
	}

	public boolean BackClick() {

		boolean ret = false;
		By by_back = By.id("com.instagram.android:id/action_bar_button_back");
		MobileElement element_back = app.findElement(by_back, 1);
		if (null != element_back) {
			ret = true;
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
		int number_random2 = 6;// (int)getRandomNumber(2,5);
		LongPressOptions lpo = new LongPressOptions().withDuration(Duration.ofMillis(5000))
				.withPosition(new PointOption().point(sizeX / number_random1, sizeY * number_random2 / 10));
		toa.longPress(lpo).moveTo(
				new PointOption().point(sizeX / number_random1, sizeY * (number_random2 * 10 - 1 * 10 + 5) / 100))
				.release();

		return toa;

	}

	public double getRandomNumber(double min, double max) {
		double ret = 0;
		ret = (Math.random() * ((max - min) + 1)) + min;
		return ret;
	}

	public void clickRandomlyStory() {

		int sizeX = this.driver.manage().window().getSize().getWidth();
		int sizeY = this.driver.manage().window().getSize().getHeight();

		String str_tab_bar_shadow = viewModel.getTabBarShadow();

		By by_tab_bar_shadow = By.id(str_tab_bar_shadow);
		MobileElement element_tab_bar_shadow = app.findElement(by_tab_bar_shadow, 1);

		int relative_x_element = element_tab_bar_shadow.getLocation().getX();
		int relative_y_element = element_tab_bar_shadow.getLocation().getY();

		int number_random = (int) getRandomNumber(2, 5);

		int abs_click_x = relative_x_element + sizeX * number_random / 10;
		int abs_click_y = relative_y_element - sizeY * number_random / 10;

		System.out.println("Click on story" + abs_click_x + "  " + abs_click_y);

		TouchAction toa = new AndroidTouchAction(this.driver);

		toa.tap(new PointOption().point(abs_click_x, abs_click_y)).release().perform();

		// check if this is story with picture
		HandlePickOrVideo();

	}

	public void HandlePickOrVideo() {

		String str_action_bar_button_back = ModelPicVideo.action_bar_button_back;

		String str_xpath_action_bar_button_back = String.format("//*[@resource-id=\"%s\"]", str_action_bar_button_back);
		By by_action_bar_button_back = By.xpath(str_xpath_action_bar_button_back);
		MobileElement element_action_bar_button_back = app.findElement(by_action_bar_button_back, 1);

		ModelPicVideo model = null;
		if (null != element_action_bar_button_back) {
			System.out.println("Story pick");
			model = new ModelExplorerPic();
			MobileElement element_carousel_image = app
					.findElement(By.id(((ModelExplorerPic) model).carousel_page_indicator()), 1);
			if (null != element_carousel_image) {

				String str_img_list_xpath = String.format("//*[@resource-id=\"%s\"]",
						((ModelExplorerPic) model).carousel_image());

				MobileElement element_img_list = app.findElement(By.xpath(str_img_list_xpath), 1);
				if (null != element_img_list) {
					System.out.println("Multiple pics " + str_img_list_xpath);
					int numberOfImg = 0;
					String content_desc = element_img_list.getAttribute("content-desc");

					for (String pattern : ModelExplorerPic.patterns) {
						Pattern r = Pattern.compile(pattern);
						Matcher m = r.matcher(content_desc);

						if (m.find()) {

							String stringNumberFound = m.group(0);
							System.out.println("found pattern " + pattern + ":" + stringNumberFound);

							for (String patternNumber : ModelExplorerPic.patternParseNumber) {
								Pattern r1 = Pattern.compile(patternNumber);
								Matcher m1 = r1.matcher(stringNumberFound);
								if (m1.find()) {
									String str_number = m1.group(0).toString().trim();
									System.out.println("found number " + patternNumber + " : " + str_number);
									numberOfImg = Integer.parseInt(str_number);
									SweepAction action = new SweepLeft(driver);
									for (int i = 0; i < numberOfImg; i++)
										action.sweep("dummy");
								}
							}

						}
					}
					
					CommentPost(model.getCommentIdOrResouce());
				}

			}

			 LikePost(model.getLikeIdOrResouce());
			

			element_action_bar_button_back.click();
		} else {
			System.out.println("Story Video");
			
			model = new ModelExplorerVideos();

			ModelPicVideo picAndVideo = new ModelExplorerVideoReelViewer();

			MobileElement element = app
					.findElement(By.id(((ModelExplorerVideoReelViewer) picAndVideo).getreel_viewer_progress_bar()), 1);
			if (null == element) {
				System.out.println("Not a reel video");
				
				FollowOnVideo(model.getFollowIdOrResource());
				
			}

			driver.navigate().back();
		}
	}

	public void FollowOnVideo(String follow_resource_or_id) {
		System.out.println("Follow person's video");
		
		MobileElement element = app.findElement(By.id(follow_resource_or_id), 1);
		if (null != element)
			element.click();
		
	}

	public void CommentPost(String comment_resource_or_id) {
		System.out.println("CommentPost");

		do {
			MobileElement element = app.findElement(By.id(comment_resource_or_id), 1);
			if (null == element)
				break;

			element.click();

			ModelComment comment = new ModelComment();

			MobileElement element_post = app.findElement(By.id(comment.getlayout_comment_thread_post_button()), 1);
			if (null == element_post)
				break;

			MobileElement element_chat_box = app.findElement(By.id(comment.getlayout_comment_thread_edittext()), 1);
			if (null == element_chat_box)
				break;

			MobileElement element_back = app.findElement(By.id(comment.getaction_bar_button_back()), 1);
			if (null == element_back)
				break;

			element_chat_box.sendKeys(comment.getDefalutComment());
			
			element_post.click();
		
			element_back.click();
			UtilWait.Wait(1);

		} while (false);

	}

	public void SharePost(String share_resource_or_id) {

		System.out.println("share post");

		MobileElement element = app.findElement(By.id(share_resource_or_id), 1);
		if (null != element)
			element.click();
	}

	public void LikePost(String like_resource_or_id) {
		System.out.println("Like post");

		MobileElement element_like = app.findElement(By.id(like_resource_or_id), 1);
		if (null != element_like)
			element_like.click();
	}

	public void touchSomeOneStory() {

//		System.out.print("touchSomeOneStory");
//
//		int sizeX = this.driver.manage().window().getSize().getWidth();
//		int sizeY = this.driver.manage().window().getSize().getHeight();
//
//		MultiTouchAction m = new MultiTouchAction(this.driver);
//		int number_random = (int) getRandomNumber(2, 9);
//		int i = 0;
//		// for (int i = 0; i < 5; i++)
//		{
//			TouchAction toa = new AndroidTouchAction(this.driver);
//
//			LongPressOptions lpo = new LongPressOptions().withDuration(Duration.ofNanos(5000))
//					.withPosition(new PointOption().point(i + sizeX / number_random, i + sizeY * number_random / 10));
//
//			toa.tap(new PointOption().point(i + sizeX / number_random, i + sizeY * number_random / 10)).release()
//					.perform();
//
//		}
//
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		By by_back = By.id("com.instagram.android:id/action_bar_button_back");
//		MobileElement element_back = app.findElement(by_back, 1);
//
//		if (null != element_back) {
//
//			// image
//
//			SweepMultipleImageLeftIfNeed();
//
//			element_back.click();
//		} else {
//			// video
//			WatchVideoAndClickCloseButton();
//
//		}

	}

	public void LikePost() {
		By by_like = By.id("com.instagram.android:id/row_feed_button_like");
		MobileElement element_like = app.findElement(by_like, 1);
		if (null != element_like)
			element_like.click();

	}

	public void SavePost() {
		By by = By.id("com.instagram.android:id/row_feed_button_save");
		MobileElement element = app.findElement(by, 1);
		if (null != element)
			element.click();

	}

	public boolean SweepMultipleImageLeftIfNeed() {
		System.out.print("SweepMultipleImageLeftIfNeed");
		boolean ret = false;
		By by_page_indicator = By.id("com.instagram.android:id/carousel_page_indicator");
		MobileElement element_page_indicator = app.findElement(by_page_indicator, 1);
		if (null != element_page_indicator) {
			// get position of element

			MobileElement element_carousel_image = app.findElement(By.id("com.instagram.android:id/carousel_image"), 1);
			if (null != element_carousel_image) {

				int numberOfImg = 0;
				String content_desc = element_carousel_image.getAttribute("content-desc");
				String patter_string = "\\s\\d\\sof\\s\\d\\s";
				Pattern r = Pattern.compile(patter_string);
				Matcher m = r.matcher(content_desc);
				if (m.find()) {

					String numberAOfBPattern = "\\s\\d\\s$";
					String stringNumberFound = m.group(0);

					Pattern numberFormat = Pattern.compile(numberAOfBPattern);
					Matcher numberMatch = numberFormat.matcher(stringNumberFound);
					if (numberMatch.find()) {
						String str_number = numberMatch.group(0).toString().trim();

						try {

							numberOfImg = Integer.parseInt(str_number);
							for (int i = 0; i < numberOfImg - 1; i++) {
								Point location_img = element_carousel_image.getLocation();
								int width_img = element_carousel_image.getSize().getWidth();
								int heigh_img = element_carousel_image.getSize().getHeight();

								Point startPosition = new Point(location_img.x + width_img * 8 / 10,
										location_img.y + heigh_img / 2);
								Point endPosition = new Point(location_img.x + 10, location_img.y + heigh_img / 2);

								TouchAction toa = new AndroidTouchAction(this.driver);
								LongPressOptions lpo = new LongPressOptions().withDuration(Duration.ofMillis(1))
										.withPosition(new PointOption().point(startPosition));
								toa.longPress(lpo).moveTo(new PointOption().point(endPosition)).release().perform();
							}
						} catch (Exception e) {

						}

					}

				}

			}
		}
		return ret;

	}

	public void WatchVideoAndClickCloseButton() {

		System.out.print("WatchVideoAndClickCloseButton");
		boolean sweepLeft = false;
		boolean sweepDown = true;
		if (false == closeVideoView()) {
			// no click button

			System.out.print("video with progresss");
			By reel_view_progress = By.xpath("//*[@resource-id=\"com.instagram.android:id/reel_viewer_progress_bar\"]");
			MobileElement element = app.findElement(reel_view_progress, 1);
			if (null != element) {
				if (true == sweepDown) {
					int sizeX = this.driver.manage().window().getSize().getWidth();
					int sizeY = this.driver.manage().window().getSize().getHeight();
					int number_random1 = 2;// (int)getRandomNumber(2,5);
					int number_random2 = 8;// (int)getRandomNumber(2,5);
//				
					Point startPosition = new Point(sizeX / number_random1, sizeY * 3 / 10);
					Point endPosition = new Point(sizeX / number_random1, sizeY * (number_random2) / 10);

					TouchAction toa = new AndroidTouchAction(this.driver);

					LongPressOptions lpo = new LongPressOptions().withDuration(Duration.ofMillis(10))
							.withPosition(new PointOption().point(startPosition));
					toa.longPress(lpo).moveTo(new PointOption().point(endPosition)).release().perform();

				}

			}
		}
	}

	public void WatchVideoAndWeepDown() {

//		By video_by = By.xpath("//*[@resource-id=\"com.instagram.android:id/zoomable_view_container\"]");
//
//		MobileElement element = app.findElement(video_by, 1);
//		if (null != element) {
//			int sizeX = this.driver.manage().window().getSize().getWidth();
//			int sizeY = this.driver.manage().window().getSize().getHeight();
//
//			TouchAction toa0 = new AndroidTouchAction(this.driver);
//			LongPressOptions lpo0 = new LongPressOptions().withDuration(Duration.ofMillis(1))
//					.withPosition(new PointOption().point(sizeX * 6 / 10, 500));
//			toa0.longPress(lpo0).moveTo(new PointOption().point(sizeX * 6 / 10, sizeY * 9 / 10)).release();
//
//			MultiTouchAction m = new MultiTouchAction(this.driver);
//			m.add(toa0).add(toa0).perform();
//		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back();

	}

	public boolean closeVideoView() {

		System.out.print("closeVideoView");

		boolean ret = false;
		By by_close = By.id("com.instagram.android:id/close_button");
		MobileElement element_close = app.findElement(by_close, 1);
		if (null != element_close) {
			ret = true;
			element_close.click();

		}
		return ret;
	}

	public void longTouchSomeOneStory() {

		int screenX = this.driver.manage().window().getPosition().getX();
		int screenY = this.driver.manage().window().getPosition().getX();
		int sizeX = this.driver.manage().window().getSize().getWidth();
		int sizeY = this.driver.manage().window().getSize().getHeight();

		TouchAction toa = new AndroidTouchAction(this.driver);

		int number_random = (int) getRandomNumber(2, 9);
		System.out.print("____" + number_random);

		LongPressOptions lpo = new LongPressOptions().withDuration(Duration.ofMillis(1000))
				.withPosition(new PointOption().point(sizeX / number_random, sizeY * number_random / 10));
		toa.longPress(lpo).release().perform();

	}

	public void onReelViewVideo() {

		// sweep down to terminate video

		By video_by = By.xpath("//*[@resource-id=\"com.instagram.android:id/reel_viewer_progress_bar\"]");

		MobileElement element = app.findElement(video_by, 1);
		if (null != element) {

		}
	}

}
