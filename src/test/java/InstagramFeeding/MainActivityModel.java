package InstagramFeeding;

import java.util.ArrayList;

public class MainActivityModel  implements BaseModel{
	
	static ArrayList<String> strElements = new ArrayList() {
		{
			add("com.instagram.android:id/tab_bar");
			

		}
	};

	public enum enum_element {

		tab_bar(0);

		public int getVal() {
			return val;
		}

		private int val = 0;

		enum_element(int val) {
			this.val = val;
		}

		public String getString() {
			return strElements.get(val);
		}
	}

	public void onResult(String result) {
		// TODO Auto-generated method stub
		
	}

	public void onError(String result) {
		// TODO Auto-generated method stub
		
	}

}
