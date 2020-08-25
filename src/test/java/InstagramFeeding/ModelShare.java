package InstagramFeeding;

import java.util.ArrayList;

public class ModelShare {
	static ArrayList<String> e_id_or_r_id_str_val = new ArrayList() {
		{
			add("com.instagram.android:id/search_edit_text");
			add("com.instagram.android:id/direct_private_share_recipients_recycler_view");
			add("com.instagram.android:id/row_user_container");
			add("com.instagram.android:id/selectable_user_row_avatar");
			add("com.instagram.android:id/row_user_username");
			add("com.instagram.android:id/row_user_info");
			add("com.instagram.android:id/one_tap_send_button_spinning_gradient_border");
			add("com.instagram.android:id/direct_private_share_done_button");
			
			
		}
	};

	public static enum e_id_or_r_id_alias {
		// check if layout_comment_thread_edittext

		
		search_edit_text(0),
		direct_private_share_recipients_recycler_view(1),
		row_user_container(2),
		selectable_user_row_avatar(3),
		row_user_username(4),
		row_user_info(5),
		one_tap_send_button_spinning_gradient_border(6),
		direct_private_share_done_button(7);


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
