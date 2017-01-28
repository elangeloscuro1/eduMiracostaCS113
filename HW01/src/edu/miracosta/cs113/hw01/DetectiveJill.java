/**
 *
 * @author
 * @version 1.0
 * 
 */
package edu.miracosta.cs113.hw01;

import java.util.Random ;
import java.util.Scanner ;

public class DetectiveJill
{
	
	private boolean discardedMurder ;
	private boolean discardedLocation ;
	private boolean discardedWeapon ;
	
	
	
	public static void main(String[] args)
	{
		Scanner userIn = new Scanner(System.in) ;
		boolean keepTesting = true ;// Testing
		while (keepTesting)// Testing: loop until desire testing
		{

			int answerSet, solution, murder, weapon, location ;
			//Scanner keyboard = new Scanner(System.in) ;
			Theory answer = null ;
			AssistantJack jack ;

			System.out.print("Check theory (1, 2, 3[random]): ") ;
			answerSet = userIn.nextInt() ;
			//keyboard.close() ;

			jack = new AssistantJack(answerSet) ;

			Random random = new Random() ;
			do
			{
				murder = random.nextInt(6) + 1 ;
				location = random.nextInt(10) + 1 ;
				weapon = random.nextInt(6) + 1 ;
				solution = jack.checkAnswer(weapon, location, murder) ;
			}
			while (solution != 0) ;
			answer = new Theory(weapon, location, murder) ;
			System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution = " + answer) ;

			if (jack.getTimesAsked() > 20)
			{
				System.out.println("FAILED!! You're a horrible Detective...") ;
			}
			else
			{
				System.out.println("WOW! You might as well be called Batman!") ;
			}
			
			// Testing: Option to test again
			System.out.println("Keep Testing? (y/n)") ;
			keepTesting = userIn.next().toLowerCase().charAt(0) != 'n' ;			
		}// Testing: End of testing loop
		userIn.close() ;// Testing: closing keyboard
		System.out.println("End of the program!") ;// Testing: End of test
	}
		
	
	
}
