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

public class LaucherActivityViewModel  {

	LaucherActivityModel model = null;

	BaseView activity = null;

	LaucherActivityViewModel(BaseView myActivity) {
		activity = myActivity;
		model = new LaucherActivityModel();
//		model.register(this);
	}

	public void Clear() {
//		model.unregister(this);
	}

//	ArrayList<InterfaceLaucherActivityViewModel> observervable = new ArrayList();
	InterfaceLaucherActivityViewModel listener = null;

	public void registerAction(InterfaceLaucherActivityViewModel action) {
		listener=action;
	}

	public void unregisterAction(InterfaceLaucherActivityViewModel action) {
		listener=null;
	}

	public void getContinueAsFBId() {
		
		model.register(new LaucherActivityModel.InterfaceLaucherActivityModel() {
			
			public void onResult(String result) {
				// TODO Auto-generated method stub
				if(null!=listener)
					listener.onResult(result);
			}
			
			public void onError(String error) {
				// TODO Auto-generated method stub
				if(null!=listener)
					listener.onError(error);
			}
		});
		model.getElementOnString(LaucherActivityModel.enum_element.facebook_text_switcher);
		
	}



	


	public interface InterfaceLaucherActivityViewModel {
		public void onResult(String result);

		public void onError(String result);

	}



}
