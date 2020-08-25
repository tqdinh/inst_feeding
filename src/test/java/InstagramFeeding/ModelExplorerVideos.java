package InstagramFeeding;

import java.util.ArrayList;

public class ModelExplorerVideos extends ModelPicVideo{
	
	
	
	static ArrayList<String> e_id_or_r_id_str_val=new ArrayList(){{
		add("com.instagram.android:id/action_bar_button_back");
		add("com.instagram.android:id/igtv_feed_preview_keep_watching_button");
		add("com.instagram.android:id/row_feed_media_feedback_content");
		
	}};

	public static enum e_id_or_r_id_alias {

		action_bar_button_back(0);
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
