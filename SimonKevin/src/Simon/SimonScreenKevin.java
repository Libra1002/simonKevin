package Simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import GUIPractice.components.Action;
import GUIPractice.components.Button;
import GUIPractice.ClickableScreen;
import GUIPractice.components.TextLabel;
import GUIPractice.components.Visible;

public class SimonScreenKevin extends ClickableScreen implements Runnable
{
	private ArrayList<MoveInterfaceKevin> sequence;
	private ProgressInterfaceKevin progress;
	private TextLabel label;
	private ButtonInterfaceKevin[] button;
	
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
		changeText("");
		nextRound();
	}

	private void nextRound() 
	{
		acceptingInput = false;
		roundNumber++;
		progress.setRound(roundNumber);
		sequence.add(randomMove());
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn.");
		label.setText("");
		playSequence();
		changeText("Your turn.");
		label.setText("");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() 
	{
		ButtonInterfaceKevin b = null;
		for(MoveInterfaceKevin m: sequence)
		{
			if(b!=null)
			{		
				b.dim();
			}
			b = m.getButton();
			b.highlight();
			try 
			{
				Thread.sleep((long)(2000*(2.0/(roundNumber + 2))));
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String string) 
	{
		try
		{
			label.setText(string);
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

	public void initAllObjects(ArrayList<Visible> viewObjects) 
	{
		addButtons(viewObjects);
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
		int selectedButton = (int)(Math.random()*button.length);
		while (selectedButton == lastSelectedButton)
		{
			selectedButton = (int)(Math.random()*button.length);
		}
		b = button[selectedButton];
		lastSelectedButton = selectedButton;
		return getMove(b);
	}

	private MoveInterfaceKevin getMove(ButtonInterfaceKevin b)
	{
		return new Move(b);
	}

	private ProgressInterfaceKevin getProgress() 
	{
		//Placeholder until partner finishes implementation of ProgressInterface
		return new Progress();
	}

	private void addButtons(ArrayList<Visible> viewObjects) 
	{
		int numberOfButtons = 6;
		Color[] colors = {Color.red,Color.magenta,Color.blue,Color.green,Color.yellow,Color.orange};
		for(int i = 0; i < numberOfButtons;i++)
		{
			ButtonInterfaceKevin b = getAButton();
			b.setColor(colors[i]);
			b.setX(160 + (int)(100*Math.cos(i*2*Math.PI/(numberOfButtons))));
			b.setY(200 - (int)(100*Math.sin(i*2*Math.PI/(numberOfButtons))));
			b.setAction(new Action()
			{
				public void act()
				{
					if(acceptingInput)
					{
					    Thread blink = new Thread(new Runnable()
					    {
					        public void run()
					        {
					        	b.highlight();
					        	try
					        	{
					        		Thread.sleep(800);
					        		b.dim();
					        	}
					        	catch(InterruptedException e)
					        	{
					        		e.printStackTrace();
					        	}
					        }
					    });
					    blink.start();
					    if(b == sequence.get(sequenceIndex).getButton())
					    {
					    	sequenceIndex++;
					    }
					    else
					    {
					    	progress.gameOver();
					    }
					    if(sequenceIndex == sequence.size())
					    {
					    	Thread nextRound = new Thread(SimonScreenKevin.this);
					    	nextRound.start();
					    }
					}
				}
			});
			viewObjects.add(b);
		};
	}
	
	private ButtonInterfaceKevin getAButton() 
	{
		return new ButtonKevin();
	}

	@Override
	public void initAllObjects(List<Visible> arg0) 
	{
		
	}

	@Override
	public void initObjects(ArrayList<Visible> arg0) 
	{
		
	}
}
