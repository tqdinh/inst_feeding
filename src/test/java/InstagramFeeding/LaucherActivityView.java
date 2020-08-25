package InstagramFeeding;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class LaucherActivityView extends BaseView {

	AppiumDriver driver = null;
	Wait<MobileDriver> mobileWait = null;

	LaucherActivityViewModel viewModel = null;

	MainActivityView mainActivity = null;

	public LaucherActivityView() {

	}

	public void InitMyActivity() {

		this.driver = getDriver();
		this.mobileWait = getMobileWait();
		viewModel = new LaucherActivityViewModel(this);

		mainActivity = new MainActivityView();

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

		final InstagramAppication app = this.getApp();

		ContinueAsFB(new LaucherActivityViewModel.InterfaceLaucherActivityViewModel() {

			public void onResult(String result) {
				System.out.println("result: "+result);

				By by = app.findById(result);
				MobileElement element = app.findElement(by, 1);
				if (null != element)
					element.click();
				
				mainActivity.InitMyActivity();
				mainActivity.test();
				try {
					Thread.sleep(-1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}

			public void onError(String result) {
				String fail = "";


			}
		});

	}

	public void ContinueAsFB(LaucherActivityViewModel.InterfaceLaucherActivityViewModel action) {

		viewModel.registerAction(action);
		viewModel.getContinueAsFBId();

	}

}
