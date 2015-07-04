/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public static void main(String[] args)
	{
		stanford.karel.Karel.main(new String[] { "code=" + StoneMasonKarel.class.getCanonicalName() });
	}
	
	public void run()
	{
		
		while (frontIsClear())
		{
			repairColumn();
			descentColumn();
			if(frontIsClear())
			{
				moveToNextColumn();
			}
		}
		repairColumn();
	}
	
	/**
	 * Builds a column upward where Karel is standing
	 */
	private void repairColumn()
	{
		//turn Karel up
		turnLeft();
		while(frontIsClear())
		{			
			repairColumnPiece();
			move();
		}
		//final repair column piece
		repairColumnPiece();
		//turn Karel in base direction
		turnRight();
	}
	
	/**
	 * Repairs a single piece of a column putting no beeper if there is one present on the tile
	 */
	private void repairColumnPiece()
	{
		if(!beepersPresent()) putBeeper();
	}
	
	private void descentColumn()
	{
		//Turn Karel down
		turnRight();
		while(frontIsClear())
		{
			move();
		}
		//Turn Karel facing forward again
		turnLeft();
	}
	
	/**
	 * Moves Karel to the next column
	 */
	private void moveToNextColumn()
	{
		move();
		move();
		move();
		move();
	}
	

}
