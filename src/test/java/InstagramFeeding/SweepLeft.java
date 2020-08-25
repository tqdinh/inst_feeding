package InstagramFeeding;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SweepLeft extends SweepAction {

	private double percent_from_x = 8 / (double)10;
	private double percent_from_y = 2 / (double)10;

	private double percent_to_x = 2 / (double)10;
	private double percent_to_y = 2 / (double)10;

	SweepLeft(AppiumDriver driver) {
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

	SweepLeft(AppiumDriver driver, MobileElement element) {
		super(driver, element);
		System.out.print("<-----<------<[]");
		double from_percent_x;
		double to_percent_x;
		double from_percent_y;
		double to_percent_y;
		double screen_sizeX = driver.manage().window().getSize().getWidth();
		double screen_sizeY = driver.manage().window().getSize().getHeight();

		int relative_element_pos_x = element.getLocation().getX();
		int relative_element_pos_y = element.getLocation().getY();

		int size_element_x = element.getSize().getWidth();
		int size_element_y = element.getSize().getHeight();

		int y_top_pos = relative_element_pos_y;
		int y_bottom_pos = relative_element_pos_y + size_element_y;

		do {
			if (y_top_pos >= 0 && y_bottom_pos <= screen_sizeY) {

				this.from_abs_y = (size_element_y * percent_from_y + relative_element_pos_y);
				this.to_abs_y = (size_element_y * percent_to_y + relative_element_pos_y);

				System.out.print("element is inside of screen " + this.from_abs_y + "---->" + this.to_abs_y);

				break;
			}

			if (y_top_pos >= 0 && y_bottom_pos > screen_sizeY) {

				int visible_element = (int) screen_sizeY - relative_element_pos_y;
				this.from_abs_y = (visible_element * percent_from_y) + y_top_pos;
				this.to_abs_y = (visible_element * percent_to_y) + y_top_pos;
				System.out.print("top element is inside , bottom one is out side of screen " + this.from_abs_y + "---->"
						+ this.to_abs_y);

				break;

			}

			if (y_top_pos < 0 && y_bottom_pos < screen_sizeY) {

				int visible_element = (int) screen_sizeY - y_bottom_pos;
				this.from_abs_y = (visible_element * percent_from_y) + y_bottom_pos;
				this.to_abs_y = (visible_element * percent_to_y) + y_bottom_pos;
				System.out.print("top element is out side  , bottom one  is in side of screen " + this.from_abs_y
						+ "---->" + this.to_abs_y);
				break;

			}

			if (y_top_pos < 0 && y_bottom_pos > screen_sizeY) {

				this.from_abs_y = (screen_sizeY * percent_from_y);
				this.to_abs_y = (screen_sizeY * percent_to_y);
				System.out.print("both top and bottom  element is out side  of screen " + this.from_abs_y + "---->"
						+ this.to_abs_y);
				break;
			}

		} while (false);

		// int length_of_visible_elemment_y=(int)screen_sizeY-relative_y;

	}

	SweepLeft(int relative_element_pos_x, int relative_element_pos_y, int size_element_y) {
		super();
		System.out.println("<-----<------<[]");
		double from_percent_x;
		double to_percent_x;
		double from_percent_y;
		double to_percent_y;
		double screen_sizeX = 1080;
		double screen_sizeY = 2340;

		int y_top_pos = relative_element_pos_y;
		int y_bottom_pos = relative_element_pos_y + size_element_y;

		do {
			if (y_top_pos >= 0 && y_bottom_pos <= screen_sizeY) {

				this.from_abs_y = (size_element_y * percent_from_y + relative_element_pos_y);
				this.to_abs_y = (size_element_y * percent_to_y + relative_element_pos_y);

				System.out.println("element is inside of screen " + this.from_abs_y + "---->" + this.to_abs_y);

				break;
			}

			if (y_top_pos >= 0 && y_bottom_pos > screen_sizeY) {

				int visible_element = (int) screen_sizeY - relative_element_pos_y;
				this.from_abs_y = (visible_element * percent_from_y) + y_top_pos;
				this.to_abs_y = (visible_element * percent_to_y) + y_top_pos;
				System.out.println("top element is inside , bottom one is out side of screen " + this.from_abs_y
						+ "---->" + this.to_abs_y);

				break;

			}

			if (y_top_pos < 0 && y_bottom_pos < screen_sizeY) {

				int visible_element = (int) screen_sizeY - y_bottom_pos;
				this.from_abs_y = (visible_element * percent_from_y) + y_bottom_pos;
				this.to_abs_y = (visible_element * percent_to_y) + y_bottom_pos;
				System.out.println("top element is out side  , bottom one  is in side of screen " + this.from_abs_y
						+ "---->" + this.to_abs_y);
				break;

			}

			if (y_top_pos < 0 && y_bottom_pos > screen_sizeY) {

				this.from_abs_y = (screen_sizeY * percent_from_y);
				this.to_abs_y = (screen_sizeY * percent_to_y);
				System.out.println("both top and bottom  element is out side  of screen " + this.from_abs_y + "---->"
						+ this.to_abs_y);
				break;
			}

		} while (false);

		// int length_of_visible_elemment_y=(int)screen_sizeY-relative_y;

	}

//	MobileElement element
	public boolean sweep(String stopSign) {

		boolean ret = false;

		stop_signature = stopSign;

		System.out.println("from " + (int) this.from_abs_x + " : " + (int) this.from_abs_y);

		System.out.println("to " + (int) this.to_abs_x + " : " + (int) this.to_abs_y);

		System.out.println("delta: " + "   " + ((int) this.from_abs_y - (int) this.to_abs_y));

		
		
		
		touchAction(1000).perform();
		
		
		

		InstagramAppication app = InstagramAppication.getInstance();

		By by_explore = By.id(stop_signature);
		MobileElement element_explore = app.findElement(by_explore, this.delay_in_second);
		if (null != element_explore) {
			element_explore.click();
			ret = false;
		}

		return ret;

	}

	@Override
	protected boolean sweep() {

		return false;
	}

}
