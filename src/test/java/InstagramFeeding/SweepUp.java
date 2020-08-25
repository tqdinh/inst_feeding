package InstagramFeeding;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SweepUp extends SweepAction {

	private double percent_from_x = 50 / (double) 100;
	private double percent_from_y = 60 / (double) 100;

	private double percent_to_x = 50 / (double) 100;
	private double percent_to_y = 55 / (double) 100;

	

	int num_of_sweep_up = 0;

	SweepUp(AppiumDriver driver) {
		super(driver);
		System.out.print("<-----<------<");
		double from_percent_x;
		double to_percent_x;
		double from_percent_y;
		double to_percent_y;
		double screen_sizeX = driver.manage().window().getSize().getWidth();
		double screen_sizeY = driver.manage().window().getSize().getHeight();

		this.from_abs_x = screen_sizeX * percent_from_x;
		this.from_abs_y = screen_sizeY * percent_from_y;

		this.to_abs_x = screen_sizeX * percent_to_x;
		this.to_abs_y = screen_sizeY * percent_to_y;
	}

	



	

	public boolean sweep(String stopSign) {
		
		stop_signature=stopSign;
		InstagramAppication app = InstagramAppication.getInstance();

		
		
		By by_explore = By.id(stop_signature);
		app.findElement(by_explore, this.delay_in_second/2);
		
		boolean ret = true;
		num_of_sweep_up = num_of_sweep_up + 1;
		System.out.println("from " + (int) this.from_abs_x + " : " + (int) this.from_abs_y);

		System.out.println("to " + (int) this.to_abs_x + " : " + (int) this.to_abs_y);

		System.out.println("delta: " + num_of_sweep_up + "   " + ((int) this.from_abs_y - (int) this.to_abs_y));

		MultiTouchAction m = new MultiTouchAction(this.driver);
		m.add(touchAction(5000)).add(touchAction(5000)).perform();

		
		
		MobileElement element_explore = app.findElement(by_explore, this.delay_in_second);
		if (null != element_explore) {
			element_explore.click();
			ret = false;
		}

		return ret;

	}



	@Override
	protected boolean sweep() {
		// TODO Auto-generated method stub
		return false;
	}

}