/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public static void main(String[] args)
	{
		stanford.karel.Karel.main(new String[] { "code=" + MidpointFindingKarel.class.getCanonicalName() });
	}
	// You fill in this part
	
	public void run()
	{
		//fill row with beepers
		layBeepersOnRow();

		while (beepersPresent())
		{
			pickLastBeeper();
			move();
		}
		//No beepers anymore, since we did move an additional tile karel has to place the final one on the previous tile.
		turnAround();
		move();
		putBeeper();
		//Karel is now a very happy robot since he passed the first assignment!
	}
	
	private void layBeepersOnRow()
	{
		while(frontIsClear())
		{
			putBeeper();
			move();
		}
		putBeeper();
	}
	
	/**
	 * Moves until last beeper is found
	 */
	private void pickLastBeeper()
	{
		while(beepersPresent())
		{
			if(frontIsClear())
			{
				pickIfLast();
			}
			else
			{
				pickBeeper();
				turnAround();
			}
		}	
	}
	
	/**
	 * Picks up beeper if it is the last one and turns Karel around
	 */
	private void pickIfLast()
	{
		if (beepersPresent())
		{
			if (frontIsBlocked())
			{
				//This is last beeper of row: pickup and turn around
				pickBeeper();
				turnAround();
			}
			else
			{
				move();
				if(!beepersPresent())
				{					
					//previous tile was last beeper: turn around and pick it up
					turnAround();
					move();
					pickBeeper();
				}
			}
		}
	}	
	
}
