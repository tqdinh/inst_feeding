package InstagramFeeding;

import java.util.ArrayList;

import InstagramFeeding.ModelExplorerPic.e_id_or_r_id_alias;

public abstract class ModelPicVideo {
	public static final String action_bar_button_back="com.instagram.android:id/action_bar_button_back";

	static ArrayList<String> e_id_or_r_id_str_val=new ArrayList(){{
		add("com.instagram.android:id/row_feed_photo_profile_imageview");
		add("com.instagram.android:id/row_feed_photo_profile_name");
		add("com.instagram.android:id/feed_more_button_stub");
		add("com.instagram.android:id/button");// follow button
		add("com.instagram.android:id/row_feed_button_like");
		add("com.instagram.android:id/row_feed_button_comment");
		add("com.instagram.android:id/row_feed_button_share");
	}};

	public static enum e_id_or_r_id_alias {

		row_feed_photo_profile_imageview(0),
		row_feed_photo_profile_name(1),
		feed_more_button_stub(2),
		button(3),
		row_feed_button_like(4),
		row_feed_button_comment(5),
		row_feed_button_share(6);
		
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
	
	
	public String getLikeIdOrResouce()
	{
		return e_id_or_r_id_alias.row_feed_button_like.getString();
	}
	
	public String getCommentIdOrResouce()
	{
		return e_id_or_r_id_alias.row_feed_button_comment.getString();
	}
	
	public String getShareIdOrResouce()
	{
		return e_id_or_r_id_alias.row_feed_button_share.getString();
	}
	
	
	public String getFollowIdOrResource()
	{
		return e_id_or_r_id_alias.button.getString();
	}
	
	
	
	
}
