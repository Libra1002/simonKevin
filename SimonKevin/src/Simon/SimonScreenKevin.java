package Simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import GUIPractice.components.Button;
import GUIPractice.components.TextLabel;
import GUIPractice.components.Visible;
import GUIPractice.sampleGames.ClickableScreen;

public class SimonScreenKevin extends ClickableScreen implements Runnable
{
	private TextLabel label;
	private ArrayList<MoveInterfaceKevin> sequence;
	private ProgressInterfaceKevin progress;
	private ButtonInterfaceKevin button;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenKevin(int width, int height) 
	{
		super(width, height);
		Thread simon = new Thread(this);
		simon.start();
	}

	@Override
	public void run() 
	{
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) 
	{
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceKevin>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceKevin randomMove() 
	{
		ButtonInterfaceKevin b;
		int selectedButton = (int)(Math.random()*buttons.length);
		while (selectedButton == lastSelectedButton)
		{
			selectedButton = (int)(Math.random()*buttons.length);
		}
		lastSelectedButton = selectedButton;
		return null;
	}

	private ProgressInterfaceKevin getProgress() 
	{
		//Placeholder until partner finishes implementation of ProgressInterface
		return null;
	}

	private void addButtons() 
	{
		int numberOfButtons = 6;
		Color[] colors = {Color.red,Color.magenta,Color.blue,Color.green,Color.yellow,Color.orange};
		for(int i = 0; i < numberOfButtons;i++)
		{
			ButtonInterfaceKevin b = getAButton();
			b.setColor(colors[i]);
			
		}
	}

	private ButtonInterfaceKevin getAButton() 
	{
		
		return null;
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) 
	{
		
	}

}
