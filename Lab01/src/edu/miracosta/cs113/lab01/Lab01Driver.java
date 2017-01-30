/**
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 * 
 * Program Description:
 * 		This class prints number 1 to 100 with the exception 
 * 		of multiples of 3, 5, and 15.
 * 		For multiples of three prints "Fizz."
 * 		For multiples of five prints "Buzz."
 * 		For multiples of fifteen prints "Fizzbuzz." 
 * 
 * Algorithm:
 * 	-In main:
 * 		-Create an object of the class FizzBuzz.
 * 		-Create a for-loop that loops from 1 to 100.
 * 		 *Set the current value of the object FizzBuzz
 * 		  to the current index value.
 * 		 *If the current current toString value is null.
 * 		 *prints the current index value; else, print the
 * 		  toString value.
 * 		 -Let the user know when the loop end.
 */
package edu.miracosta.cs113.lab01;

public class Lab01Driver
{
	/**
	 * main prints number from 1 t0 100 except for the the following conditions:
	 * -Multiples of three: prints "Fizz"
	 * -Multiples of five: ptints "Buzz"
	 * -Multiples of five and three: prints "Fizzbuzz"
	 * @param args for line command only
	 */
	public static void main(String[] args)
	{
		FizzBuzz fizzBuzz = new FizzBuzz() ;
		
		for (int i = 1 ; i <= 100 ; i++)
		{
			fizzBuzz.setCurrentValue(i);
			
			if (fizzBuzz.toString() == null)
			{
				System.out.println(i) ;
			}
			else
			{
				System.out.println(fizzBuzz) ;
			}
		}// End of loop
		
		System.out.println("End of the test!") ;
	}// End of main
}