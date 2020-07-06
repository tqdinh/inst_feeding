package InstagramFeeding;

import java.util.ArrayList;

import fiato.testing.Facebook;

public class LaucherActivityModel {

	
	InterfaceLaucherActivityModel listener=null;
	 static ArrayList<String> strElements = new ArrayList() {
		{
			add("com.instagram.android:id/facebook_text_switcher");
			add("com.instagram.android:id/sign_up_with_email_or_phone");
			add("com.instagram.android:id/log_in_button");

		}
	};

	public enum enum_element {

		facebook_text_switcher(0), sign_up_with_email_or_phone(1), log_in_button(2);

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
	
	
	
	
	public void  getElementOnString(enum_element element)
	{
	
			listener.onResult(element.getString());

	}
	
	public interface  InterfaceLaucherActivityModel
	{
		public void onResult(String result);
		public void onError(String result);
	}
	
	
	
	public void register(InterfaceLaucherActivityModel r)
	{
		listener=r;
		
	}
	
	public void unregister(InterfaceLaucherActivityModel r)
	{
		listener=null;
	}
	
}
