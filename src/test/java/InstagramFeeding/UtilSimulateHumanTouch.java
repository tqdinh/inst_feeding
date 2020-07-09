package InstagramFeeding;

import java.util.ArrayList;

import io.appium.java_client.touch.offset.PointOption;

public class UtilSimulateHumanTouch {
	private static UtilSimulateHumanTouch instance=null;
	
	public static UtilSimulateHumanTouch getInstance()
	{
		if(null==instance)
			instance=new UtilSimulateHumanTouch();
		return instance;
	}
	
	
	public ArrayList<PointOption> getPointArrayList(int start_x,int start_y,int end_x,int end_y)
	{
		ArrayList<PointOption> list=new ArrayList();
		int delta_x=Math.abs(start_x-end_x);
		int delta_y=Math.abs(end_x-end_y);
		int distance_in_pixcel=(int)Math.sqrt(delta_x*delta_x+delta_y*delta_y);
		
		
		int min=1;
		int max=100;
		int random_number = (int)(Math.random() * ((max - min) + 1)) + min;
		for(int i=0;i<distance_in_pixcel;i+=random_number)
		{
//			PointOption p=new PointOption().point(new Point())
//			random_number = (int)(Math.random() * ((max - min) + 1)) + min;
			
		}
		
		
		
		return list;
	}
	

}
