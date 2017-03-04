package edu.miracosta.cs113.hw05;

/**
 * HW05Test tests the class PalindromeTester
 * which test a test or phrase as a palindrome.
 * 
 * Algorithm:
 * 	A) Create a generic ListStack class which is a stack structure class.
 * 		-Create an generic inner Node class that contains a variable of
 * 		 of the same type and a generic type to store data;
 * 		-Create a topOfStack instance variable of the type Node that represents
 * 		 the top of the stack.
 * 		-Create a default constructor that initializes topOfStack to null ;
 * 		-Create the method empty return true if topOfStack == null.
 * 		-Create the method peek: if NOT empty, return the topOfStack data
 * 		 without removing it.
 * 		-Create the method pop: if NOT empty, return and remove the last 
 * 		 topOfStack data.
 * 		-Create the method push: add a new Node to the topOfStack Node ;
 * 		-Override the toSring method: create and return a string that contains
 * 		 all of the values in the stack.
 * 		-Override the equals method: compare toString methods of both classes.
 * 	B) Create a PalindromeTester that uses an instance of the class ListStack
 * 	   to store a stack of character.
 * 		-Create a instance variable charStack of the type ListStack and 
 * 		 an instance variable inputString of the type String.
 * 		-Create a default constructor that initializes the instance variables.
 * 		-Create a constructor that receives a string to initializes inputString.
 * 		-Create setter and getter of inputString.
 * 		-Create a private method fillStack that stores valid characters in inputString
 * 		 and return the number of character stored in the stack.
 * 		-Create a method isPalindrome that return true if inputString == 1
 * 		 or if charStack contains a valid palindrome and false if inputString is empty
 * 		 or if charStack contains an invalid palindrome.
 * 		-Override the toString method by testing and returning if inputString contains
 * 		 a valid or invalid palindrome.
 * 		-Override the equals method by comparing both inputString values.
 * 	C) Create a Tester class that tests for various words or phrases to be palindromes.
 * 		-Create an instance of the class PalindromeTester, using the default constructor.
 * 		-Use the methods setInputString to set and test a word/phrase for palindrome.
 * 		-Use the method isPalindrome to display if the input is or not a palindrome.
 * 		-instantiate the PalindromeTester object by using the constructor to set up
 * 		 the input to be tested.
 *		(repeat for various tests).
 */
/**
 * @author Angek Tapia
 */

public class HW05Test
{
	public static void main(String[] args)
	{
		// Testing palindromes by using the setter and getter.
		PalindromeTester test = new PalindromeTester() ;
		
		test.setInputString("palindrome") ;
		System.out.println("Is \"" + test.getInputString() 
						 + "\" a palindrome? " + test.isPalindrome() + "\n") ;
		
		test.setInputString("abcdcba") ;
		System.out.println("Is \"" + test.getInputString() 
						 + "\" a palindrome? " + test.isPalindrome() + "\n") ;
		
		
		// Testing palindromes using the constructor to set the inputStrig.
		
		test = new PalindromeTester("") ;		
		System.out.println("\n" + test) ;
		
		test = new PalindromeTester("anita");		
		System.out.println("\n" + test) ;
		
		test = new PalindromeTester("anita lava la tina");		
		System.out.println("\n" + test) ;

		test = new PalindromeTester("Anna");		
		System.out.println("\n" + test) ;

		
		test = new PalindromeTester("Kayak");		
		System.out.println("\n" + test) ;

		
		test = new PalindromeTester("I saw i was i");		
		System.out.println("\n" + test) ;
		
		

		
		
		


		
	}
}
