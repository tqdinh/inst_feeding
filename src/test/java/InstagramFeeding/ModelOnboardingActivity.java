package InstagramFeeding;

import java.util.ArrayList;

public class ModelOnboardingActivity {
	String activityClassName="com.instagram.nux.impl.OnboardingActivity";
	
	
	 static ArrayList<String> e_id_or_r_id_str_val = new ArrayList() {
			{
				add("com.instagram.android:id/add_photo_view");
				add("com.instagram.android:id/field_title");
				add("com.instagram.android:id/field_detail");
				add("com.instagram.android:id/button_text");
				add("com.instagram.android:id/skip_button");		
			}
		};

	
	
	
	public enum e_id_or_r_id_alias
	{
		
		add_photo_view(0), field_title(1), field_detail(2),button_text(3),skip_button(4);

		public int getVal() {
			return val;
		}

		private int val = 0;

		e_id_or_r_id_alias(int val) {
			this.val = val;
		}

		public String getString() {
			return e_id_or_r_id_str_val.get(val);
		}
		
		
	}

}
