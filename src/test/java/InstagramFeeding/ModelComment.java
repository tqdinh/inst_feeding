package InstagramFeeding;

import java.util.ArrayList;

public class ModelComment {

	ArrayList<String> commemntList = new ArrayList() {
		{
			add("hello");
		}
	};

	static ArrayList<String> e_id_or_r_id_str_val = new ArrayList() {
		{
			add("com.instagram.android:id/action_bar_button_back");
			add("com.instagram.android:id/comment_emoji_picker_v1_emoji_container");
			add("com.instagram.android:id/layout_comment_thread_edittext");
			add("com.instagram.android:id/layout_comment_thread_post_button");

		}
	};

	public ModelComment(ArrayList<String> commemntList) {
		this.commemntList.addAll(commemntList);

	}
	
	public ModelComment() {
		

	}

	public static enum e_id_or_r_id_alias {
		// check if layout_comment_thread_edittext

		action_bar_button_back(0), comment_emoji_picker_v1_emoji_container(1), layout_comment_thread_edittext(2),
		layout_comment_thread_post_button(3);

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

	public String getlayout_comment_thread_edittext() {
		return e_id_or_r_id_alias.layout_comment_thread_edittext.getString();
	}

	
	public String getlayout_comment_thread_post_button() {
		return e_id_or_r_id_alias.layout_comment_thread_post_button.getString();
	}
	
	
	public String getaction_bar_button_back() {
		return e_id_or_r_id_alias.action_bar_button_back.getString();
	}
	
	
	public String getDefalutComment()
	{
		return commemntList.get(0).toString();
	}
}
