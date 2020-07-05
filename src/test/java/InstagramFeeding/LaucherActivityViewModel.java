package InstagramFeeding;

import java.time.Duration;
import java.util.ArrayList;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class LaucherActivityViewModel {

	
	static LaucherActivityViewModel instance=null;
	public static LaucherActivityViewModel getInstance()
	{
		if(null==instance)
		{
			instance=new LaucherActivityViewModel();
		}
		return instance;
	}
	
	LaucherActivityViewModel()
	{
		
	}
	
	LaucherActivityModel model = null;

	ArrayList<TestingAction> observervable = new ArrayList();

	public void registerAction(TestingAction action) {
		if (!observervable.contains(action))
			observervable.add(action);
	}

	public void unregisterAction(TestingAction action) {
		if (observervable.contains(action))
			observervable.remove(action);
	}

	public LaucherActivityViewModel() {
		model = new LaucherActivityModel();
	}

	@BeforeMethod
	public void before() {

	}

	@AfterMethod
	public void after() {

	}

	@Test
	public void test() {
		
	}
	
	public void ContinueAsFb()
	{
		for( TestingAction each : observervable)
		{
			each.ContinueAsFB(model.getElementOnString(LaucherActivityModel.enum_element.facebook_text_switcher));
		}
		
	}

	public interface TestingAction {
		public void ContinueAsFB(String id);

	}

}
