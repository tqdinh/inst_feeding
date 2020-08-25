package InstagramFeeding;

import java.time.Duration;

import org.openqa.selenium.Point;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public abstract class SweepAction {
	protected double from_abs_x = -1;
	protected double to_abs_x = -1;

	protected double from_abs_y = -1;
	protected double to_abs_y = -1;

	protected AppiumDriver driver = null;
	protected MobileElement element = null;
	protected int delay_in_second=2;
	protected String stop_signature = "dummy";
	

	SweepAction(double from_abs_x, double to_abs_x, double from_abs_y, double to_abs_y) {
		this.from_abs_x = from_abs_x;
		this.from_abs_y = from_abs_y;
		this.to_abs_x = to_abs_x;
		this.to_abs_y = to_abs_y;
	}

	SweepAction() {

	}

	SweepAction(AppiumDriver driver) {
		this.driver = driver;

	}

	SweepAction(AppiumDriver driver, MobileElement element) {
		this.driver = driver;
		this.element = element;

	}
	
	public TouchAction touchAction(int duration) {

		TouchAction toa = new AndroidTouchAction(driver);

		Point startPosition = new Point((int) this.from_abs_x, (int) this.from_abs_y);
		Point endPosition = new Point((int) this.to_abs_x, (int) this.to_abs_y);//

		LongPressOptions lpo = new LongPressOptions().withDuration(Duration.ofMillis(duration))
				.withPosition(new PointOption().point(startPosition));

		toa.longPress(lpo).moveTo(new PointOption().point(endPosition)).release();

		return toa;
	}

	protected abstract boolean sweep(String stopSign);
	protected abstract boolean sweep();

}
