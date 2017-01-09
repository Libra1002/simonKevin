package Simon;

public class Move implements MoveInterfaceKevin
{
	private ButtonInterfaceKevin b;
	
	public Move(ButtonInterfaceKevin b){
		this.b = b;
	}
	
	@Override
	public ButtonInterfaceKevin getButton() 
	{
		return b;
	}
}
