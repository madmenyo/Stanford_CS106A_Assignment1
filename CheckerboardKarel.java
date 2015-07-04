/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import java.awt.geom.Ellipse2D;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public static void main(String[] args)
	{
		stanford.karel.Karel.main(new String[] { "code=" + CheckerboardKarel.class.getCanonicalName() });
	}
	// You fill in this part
	
	public void run()
	{
		while(frontIsClear())
		{
			//If karel is facing up then he should take a step and turn
			if (facingNorth())
			{
				step();
				turn();
			}
			while(frontIsClear())
			{
				step();
			}
			turn();			
		}
	}
	
	//Turns karel in the appropriate direction depending on walls and if he is facing a wall
	private void turn()
	{
		if (facingEast())
		{
			turnLeft();
		}
		else if (facingWest())
		{
			turnRight();
		}
		else if (facingNorth() && rightIsBlocked())
		{
			turnLeft();
		}
		else if (facingNorth() && leftIsBlocked())
		{
			turnRight();
		}
	}
	
	//Let's karel take a step and put a beeper when coming from a tile without one
	private void step()
	{
		if (beepersPresent())
			move();
		else
		{
			move();
			putBeeper();
		}
		
	}	

}
