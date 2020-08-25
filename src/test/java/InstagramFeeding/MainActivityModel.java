package InstagramFeeding;

import java.util.ArrayList;

public class MainActivityModel implements BaseModel {

	private static final String activityname = "com.instagram.mainactivity.MainActivity";

	static ArrayList<String> e_id_or_r_id_str_val=new ArrayList(){{
		add("com.instagram.android:id/layout_container_main_panel");
		add("com.instagram.android:id/layout_container_main");
		add("com.instagram.android:id/action_bar_container");
		add("com.instagram.android:id/tab_bar_shadow");
		add("com.instagram.android:id/tab_bar");
		add("com.instagram.android:id/row_load_more_button");
	}};

	public static enum e_id_or_r_id_alias {

		layout_container_main_panel(0),
		layout_container_main(1),
		action_bar_container(2),
		tab_bar_shadow(3),
		tab_bar(4),
		row_load_more_button(5);
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

	public void onResult(String result) {
		// TODO Auto-generated method stub

	}

	public void onError(String result) {
		// TODO Auto-generated method stub

	}
	
	public String getResourceIdTab()
	{
		return e_id_or_r_id_alias.tab_bar.getString();
	}
	public String getResourceIdTabBarShadow()
	{
		return e_id_or_r_id_alias.tab_bar_shadow.getString();
	}
	
	public String getStopSignWhenScrool()
	{
		return e_id_or_r_id_alias.row_load_more_button.getString();
	}
	
	public String getTabBarShadow() {
		return e_id_or_r_id_alias.tab_bar_shadow.getString();
	}
}
