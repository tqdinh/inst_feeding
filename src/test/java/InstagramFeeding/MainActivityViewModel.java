package InstagramFeeding;

public class MainActivityViewModel {

	BaseView activity = null;
	MainActivityModel model=null;
	
	MainActivityViewModel( BaseView base)
	{
		this.activity=base;
		model=new MainActivityModel();
	}
	
	public String getTabResourceid()
	{
		return model.getResourceIdTab();
	}
	public String getStopSignWhenScrool()
	{
		return model.getStopSignWhenScrool();
	}
	
	public String getTabBarShadow()
	{
		return model.getTabBarShadow();
	}
	
}
