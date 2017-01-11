package Simon;

import java.awt.Color;

import GUIPractice.components.Action;
import GUIPractice.components.Clickable;

public interface ButtonInterfaceKevin extends Clickable
{
	void setColor(Color color);

	void highlight();

	void dim();

	void setAction(Action action);

	void setName(String name);

	void setX(int i);

	void setY(int i);
}