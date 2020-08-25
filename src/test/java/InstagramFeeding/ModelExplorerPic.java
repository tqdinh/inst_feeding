package InstagramFeeding;

import java.util.ArrayList;

public class ModelExplorerPic extends ModelPicVideo {


	public static final ArrayList<String> patterns=new ArrayList()
			{{
		
			add("\\s\\d\\sof\\s\\d\\s");
			add("\\s\\d\\/\\d\\s");
		
			}};

			
			public static final ArrayList<String> patternParseNumber=new ArrayList()
			{{
		
			add("\\s\\d\\s$");
			add("\\d\\s$");
		
			}};
	public static final String numberAOfBPattern = "\\s\\d\\s$";
	static ArrayList<String> e_id_or_r_id_str_val=new ArrayList(){{

	add("com.instagram.android:id/carousel_page_indicator");add("com.instagram.android:id/carousel_image");

	}};

	public static enum e_id_or_r_id_alias {

		carousel_page_indicator(0), carousel_image(1);

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

	public String carousel_page_indicator() {
		return e_id_or_r_id_alias.carousel_page_indicator.getString();
	}

	public String carousel_image() {
		return e_id_or_r_id_alias.carousel_image.getString();
	}

}
