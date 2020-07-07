package InstagramFeeding;

public class MainActivityViewModel {

	BaseView activity = null;
	MainActivityModel model=null;
	
	MainActivityViewModel( BaseView base)
	{
		this.activity=base;
		model=new MainActivityModel();
	}
	
}
