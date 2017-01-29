/**
 * Algorithm:
 * 		A) Analyze and test the provided java files.
 * 		   (Theorem, TheoremItem, Assistant Jack, and RandomClue)
 * 			-Create the java doc for easy reading the code.
 * 			-Reformat the code.
 * 			-Add a loop in current driver to make the testing easier.
 * 			-Remain the main method to mainA to start a new solution.
 * 		B) Create a DetectiveJill class.
 * 			-Crate instance Variable to represent assistant Jack and each
 * 			 theory item lists that will be discarded.
 * 			-Create a default constructor (Not used in this program).
 * 			-Create a Full constructor that receives an integer that
 * 			 initializes assistant jack.
 * 			 (Assistant jack is initialized by choosing an option of
 * 			  answer set.)
 * 			 Initializes Items list using the constants from TheoryItem.
 * 			-Create Mutators and Accesor for each of instances variables.
 * 			-create a method getValidTheoryItem that receives an array of
 * 			 integers that represent a list of theory items (weapons,
 * 			 (locations, and persons).
 * 			 This method used a while loop to randomly check if any of
 * 			 the theory items is marked off from the list and returns
 * 			 an integer value that represents the item in the list
 * 			 that is not marked off.
 * 			 -Create a discardTheoryItem method that receives four
 * 			  parameters that are of the type int (represent item type, 
 * 			  weapon, location, and person(murder)).
 * 			  This method uses a switch statement to mark off each item 
 * 			  int the list by initializing the element with zero.
 * 			-Crate an getCorrectTheory method that uses method of this
 * 			 same class to to solve for the correct theory.
 * 			 This method uses a while loop to discard different theory 
 * 			 items until the correct theorem is found.
 * 			 This method return an object of the class Theory.
 * 			-Override toString to display all of the instance variables values.
 * 			-Override equals to compare every instance variable.
 * 		C) Create a driver class.
 * 			-in main:
 * 				Create a loop that offers a menu with option to test:
 * 				(1) Fixed answer 1, 1, 1
 * 				(2) Fixed answer 6, 10, 6
 * 				(3) Answer set randomly assigned
 * 				Use the canner class to get imputes from the user.
 * 				Display total attempts in guessing the correct theory.
 * 				Display the end of the program.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113.hw01;

import java.util.Scanner ;

public class HW01_Driver
{
	/**
	 * main provides a menu of option to tests theorem by fixed
	 * set of answer or by randomly assigned set of answer.
	 * (Everything is in a while loop so the user can test as many
	 *  times as wanted.)
	 * 
	 * @param args not used.
	 */
	public static void mainB(String[] args)
	{
		Scanner userIn = new Scanner(System.in) ;
		
		int answerSet = -1 ; 
		while (answerSet != 0)
		{
			// Menu
			System.out.println("*** Testing Menu (Enter 1, 2 , or 3) ***") ;
			System.out.println("(1) Fixed answer 1, 1, 1") ;
			System.out.println("(2) Fixed answer 6, 10, 6") ;
			System.out.println("(3) Answer set randomly assigned") ;
			System.out.println("(0) To EXIT") ;
			
			answerSet = userIn.nextInt() ;// Requests input from the user.

			if (answerSet != 0)// The user chose to test a theory.
			{
				// Creating an object that represents detective Jill/
				DetectiveJill detectiveJill = new DetectiveJill(answerSet) ;
				
				// Solving and displaying the correct theory.
				System.out.println(detectiveJill.getCorrectTheory()) ;
				
				// Displaying total attempts.
				System.out.println("Total Attempts: " 
						+ detectiveJill.getAssistantJack().getTimesAsked()) ;
				System.out.println() ;// Keeps each test separate.
			}
			
		}
		userIn.close() ;// Closing the Scanner object.
		
		// Displaying the end of the program.
		System.out.println("End of the Program!") ;		
		
	}// End of main
}