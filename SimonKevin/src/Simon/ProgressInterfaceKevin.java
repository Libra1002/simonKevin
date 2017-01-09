package Simon;

import GUIPractice.components.Visible;

public interface ProgressInterfaceKevin extends Visible
{

	void gameOver();

	void setRound(int roundNumber);

	void setSequenceSize(int size);
}
