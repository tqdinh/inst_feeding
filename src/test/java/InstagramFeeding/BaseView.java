package InstagramFeeding;

public class BaseView {

	public InstagramAppication app=InstagramAppication.getInstance();
	public InstagramAppication getApp()
	{
		if (null==app)
			app=InstagramAppication.getInstance();
		return app;
	}
}
