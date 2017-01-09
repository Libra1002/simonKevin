package Simon;

import java.awt.Color;

import GUIPractice.components.Action;
import GUIPractice.components.Clickable;

public interface ButtonInterfaceKevin extends Clickable
{

	void setColor(Color color);

	void setX(int i);

	void setY(int i);

	void setAction(Action action);

	void highlight();

	void dim();

}
