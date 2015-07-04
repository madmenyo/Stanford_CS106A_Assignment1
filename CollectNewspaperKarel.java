/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends Karel {
	
	public static void main(String[] args)
	{
		stanford.karel.Karel.main(new String[] { "code=" + CollectNewspaperKarel.class.getCanonicalName() });
	}
	// You fill in this part
	
	public void run()
	{
		moveToNewsPaper();
		pickBeeper();		
		moveToStartingPoint();
	}
	
	private void moveToNewsPaper()
	{
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();		
	}
	
	private void moveToStartingPoint()
	{
		turnAround();
		move();
		move();
		move();
		turnRight();
		move();
		turnRight();
	}
	
	private void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	private void turnAround()
	{
		turnLeft();
		turnLeft();
	}
}
