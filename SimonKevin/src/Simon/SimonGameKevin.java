package Simon;

import GUIPractice.GUIApplication;

public class SimonGameKevin extends GUIApplication
{

	public SimonGameKevin() 
	{
		super();
	}
	
	public static void main(String[] args) 
	{
		SimonGameKevin SGK = new SimonGameKevin();
		Thread app = new Thread(SGK);
		app.start();
	}
	
	protected void initScreen() 
	{
		SimonScreenKevin screen = new SimonScreenKevin(getWidth(),getHeight());
		setScreen(screen);
	}
}
