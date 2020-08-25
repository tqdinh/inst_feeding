package InstagramFeeding;

import java.util.ArrayList;

import InstagramFeeding.ModelExplorerVideos.e_id_or_r_id_alias;

public class ModelExplorerVideoReelViewer extends ModelPicVideo{
	
	static ArrayList<String> e_id_or_r_id_str_val=new ArrayList(){{
		add("com.instagram.android:id/reel_viewer_progress_bar");

		
	}};

	public static enum e_id_or_r_id_alias {
		reel_viewer_progress_bar(0);
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

	
	public String getreel_viewer_progress_bar()
	{
		return e_id_or_r_id_alias.reel_viewer_progress_bar.getString();
	}

	

}
