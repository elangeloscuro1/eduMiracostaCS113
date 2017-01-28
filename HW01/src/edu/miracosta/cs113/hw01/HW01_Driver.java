/**
 * 
 * 
 * @author Angel Tapia
 *
 */
package edu.miracosta.cs113.hw01;

import java.util.Scanner ;

public class HW01_Driver
{
	public static void main(String[] args)
	{
		Scanner userIn = new Scanner(System.in) ;
		
		int answerSet = 1 ;
		while (answerSet != 0)
		{
			System.out.println("*** Testing Menu (Enter 1, 2 , or 3) ***") ;
			System.out.println("(1) Fixed answer 1, 1, 1") ;
			System.out.println("(2) Fixed answer 6, 10, 6") ;
			System.out.println("(3) Answer set randomly assigned") ;
			System.out.println("(0) To EXIT") ;
			
			answerSet = userIn.nextInt() ;

			if (answerSet != 0)
			{
				DetectiveJill detectiveJill = new DetectiveJill(answerSet) ;
				System.out.println(detectiveJill.getCorrectTheory()) ;
				System.out.println("Total Attempts: " 
						+ detectiveJill.getAssistantJack().getTimesAsked()) ;
				System.out.println() ;
			}	
			
		}
		userIn.close() ;
		System.out.println("End of the Program!") ;
		
		
	}
}
