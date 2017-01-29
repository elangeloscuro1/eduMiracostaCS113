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
 * 		-Create an for loop that contain if statements as follow:
 * 		 If a the current number divided by 15 is equals to zero, print "Fizzbuzz."
 * 		 If a the current number divided by 3 is equals to zero, print "Fizz."
 * 		 If a the current number divided by 5 is equals to zero, print "Buzz."
 * 		 Else, just print the number. 
 */
package edu.miracosta.cs113.lab01;

public class FizzBuzz
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
		for (int i = 1 ; i <= 100 ; i++)
		{
			if (i >= 15 && i % 15 == 0)
			{
				System.out.println("Fizzbuzz") ;
			}
			else if (i % 3 == 0)
			{
				System.out.println("Fizz") ;
			}
			else if (i % 5 == 0)
			{
				System.out.println("Buzz") ;
			}
			else
			{
				System.out.println(i) ;
			}
		}// End of for-loop
	}// End of main

}
