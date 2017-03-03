package edu.miracosta.cs113.hw05;

public class HW05Driver
{
	public static void main(String[] args)
	{
				
		PalindromeTester test = new PalindromeTester("");		
		System.out.println(test.isPalindrome()) ;
		
		test = new PalindromeTester("anita");		
		System.out.println(test.isPalindrome()) ;
		
		test = new PalindromeTester("anita lava la tina");		
		System.out.println(test.isPalindrome()) ;

		test = new PalindromeTester("Anna");		
		System.out.println(test.isPalindrome()) ;

		
		test = new PalindromeTester("Kayak");		
		System.out.println(test.isPalindrome()) ;

		
		test = new PalindromeTester("I saw i was i");		
		System.out.println(test.isPalindrome()) ;

		
		
		


		
	}
}
