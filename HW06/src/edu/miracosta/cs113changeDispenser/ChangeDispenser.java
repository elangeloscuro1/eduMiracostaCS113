package edu.miracosta.cs113changeDispenser ;

import java.util.ArrayList ;
import java.util.Scanner ;

/**
 * ChangeDispenser calculates every possible 
 * combination in quarters, dimes, nickels, and pennies in a certain amount.
 * 
 * Algorithm:
 * 	-Create an ArrayList object to store all possible calculation.
 * 	-Create a int variable that count all of the possible calculation.
 * 	-Create a Scanner object to get input from the user.
 * 	-Create a method changeDispenser that receives a total amount, 
 * 	 quarters, dimes, nickels, and pennies:
 * 		(All pennies is one possibility.)
 * 		if pennies >= 5 add one nickel and subtract 5 pennies.
 * 		if pennies >= 10 add one dime and subtract 10 pennies.
 * 		if pennies >= 25 add one quarter and subtract 25 pennies.
 * 		display every possibility.
 * 	-in main method:
 * 	Create a while loop that allows the user to test as many times as needed.
 * 	Crate a try catch block to get valid input from the user.
 * 	If valid input use the changeDispenser method.
 * 	Offer the user to stop or continue the program.
 */
/**
 * @author Angel Tapia
 */
public class ChangeDispenser
{
	// Helpers for changeDispenser
	private static ArrayList<String> test = new  ArrayList<String>() ;
	private static int counter = 0 ;
	private static Scanner scanner  = new Scanner(System.in) ;
	
	// recursion method
	public static void changeDispenser(int total, int quarters, int dimes, int nickels, int pennies)
	{		
		String temp = String.format("T: %2s     Q: %2s D:%2s N:%2s P:%2s", total,quarters,dimes,nickels,pennies) ;
		if (!test.contains(temp))
		{
			test.add(temp) ;
			System.out.printf("#%-4s%s%n", ++counter, temp) ;
		}		
		if (pennies >= 5)
		{
			changeDispenser(total, quarters, dimes, nickels + 1, pennies - 5) ;
		}
		if (pennies >= 10)
		{
			changeDispenser(total, quarters, dimes + 1, nickels, pennies - 10) ;
		}
		if (pennies >= 25)
		{
			changeDispenser(total, quarters + 1, dimes, nickels, pennies - 25) ;
		}
	}	
	
	// main
	public static void main(String[] args)
	{
		int option = 0 ;
		
		while (option != -1)
		{
			System.out.println("Enter Amount") ;
			
			try
			{				
				int amount = scanner.nextInt() ;
				changeDispenser(amount, 0, 0, 0, amount) ;
				counter = 0 ;				
			}
			catch (Exception e)
			{
				System.out.print("Invalid input! try again:") ;
			}
			
			System.out.println("Do yu want to continue (y/n)?") ;

			if (scanner.next().toLowerCase().charAt(0) == 'n')
			{
				option = -1 ;
			}
			
		}
		System.out.println("End of the program! Thank you!") ;
	}
}