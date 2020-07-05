package InstagramFeeding;

import java.util.ArrayList;

import org.openqa.selenium.By;


import io.appium.java_client.MobileElement;

public class LaucherActivityViewModel {
	
	LaucherActivityModel model=null;
	
	public  LaucherActivityViewModel(LaucherActivityModel _model) {
		this.model=_model;
	}
	
	
	public static boolean ContinueAsFB() {
		boolean ret = true;
//		By mobileBy = By.id(enum_element.facebook_text_switcher.getString());
//
//		if (true == SleepUntilInmilisecs(mobileBy, 5)) {
//			// see this mobileBy
//			MobileElement mobileElement = (MobileElement) driver.findElement(mobileBy);
//			mobileElement.click();
//
//		} else {
//			// dont see this mobileBy
//			ret = false;
//		}

		return ret;

	} 
	
}
