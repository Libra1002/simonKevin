package Simon;

import GUIPractice.GUIApplication;

public class SimonGameKevin extends GUIApplication
{

	public SimonGameKevin() 
	{
	}
	
	public static void main(String[] args) 
	{
		SimonScreenKevin ssK = new SimonScreenKevin(getWidth(),getHeight());
		setScreen(ssK);
	}
	
	protected void initScreen() 
	{
		SimonGameKevin game = new SimonGameKevin();
		Thread app = new Thread(game);
		app.start();
	}

}
