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
		SimonGameKevin ssK = new SimonGameKevin();
		Thread app = new Thread(ssK);
		app.start();
	}
	
	protected void initScreen() 
	{
		SimonScreenKevin screen = new SimonScreenKevin(getWidth(),getHeight());
		setScreen(screen);
	}

}
