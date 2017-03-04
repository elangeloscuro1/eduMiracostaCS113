package edu.miracosta.cs113.hw05;

/**
 * PalindromeTester tests if a word/phrase is a palindrome
 * by filing a stack of the type ListStack and comparing the
 * first half with the second half of the stack.
 */
/**
 * @author Angel Tapia
 */
public class PalindromeTester
{
	/** charStack stores the characters of inputString. */
	private ListStack<Character> charStack ;
	/** inputString stores the word/phrase to be tested. */
	private String inputString ;
	
	/**
	 * Default constructor initializes charStack and inputString.
	 */
	public PalindromeTester()
	{
		this.inputString = "" ;
		this.charStack = new ListStack<Character>() ;
	}
	
	/**
	 * Receives the word/phrase to be tested.
	 * 
	 * @param imputString represents the word/phrase to be tested.
	 */
	public PalindromeTester(String imputString)
	{
		this.inputString = imputString.trim() ;
		this.charStack = new ListStack<Character>() ;		
	}
	
	/**
	 * Mutator for inputString
	 * 
	 * @param inputString represents the string to be tested.
	 */
	public void setInputString(String inputString)
	{
		this.inputString = inputString ;
	}
	
	/**
	 * Accessor for inputString.
	 * 
	 * @return inputString.
	 */
	public String getInputString()
	{
		return inputString ;
	}
	
	/**
	 * fillStack fills charStack with chars from a-z of inputString.
	 * 
	 * @return the number of elements in the stack.
	 */
	private int fillStack()
	{
		int totalChars = 0 ;
		for (int i = 0 ; i < this.inputString.length() ; i++)
		{
			char temp = this.inputString.toLowerCase().charAt(i) ;
			if (temp >= 'a' && temp <= 'z')
			{
				this.charStack.push(temp) ;
				totalChars++ ;
			}
		}
		return totalChars ;
	}
	
	/**
	 * Checks if the input value of inputString is a palindrome.
	 * 
	 * 
	 * @return  true if inputString is a palindrome ;
	 * 			true if length == 1 ;
	 * 			false inputString length == 0 ;
	 * 			false if inputString is not a palindrome.
	 * 		  	
	 */
	public boolean isPalindrome()
	{		
		switch (this.inputString.length())
		{
		case 0:
			return false ;
		case 1:
			return true ;
		default:
			int totalChars = fillStack() ;
			ListStack<Character> temp = new ListStack<>() ;

			for (int i = 0; i < totalChars / 2; i++)
			{
				temp.push(this.charStack.pop()) ;
			}

			if (totalChars % 2 != 0)
			{
				this.charStack.pop() ;
			}

			while (!temp.empty())
			{
				if (!temp.pop().equals(this.charStack.pop()))
				{
					return false ;
				}
			}
			return true ;
		}
	}	
	
	/**
	 * toString builds a string that contains inputString plus is or not a palindrome.
	 * 
	 * @return a string that contains inputString plus is or not a palindrome.
	 */
	@Override
	public String toString()
	{
		return "\"" + inputString + "\" is " + (isPalindrome() ? "" : "not ") + "a palindrome."  ;
	}
	
	/**
	 * equals compares this inputString of this object and another object of PalindromeTester.
	 * 
	 * @return true if both inputString are equivalent; false otherwise.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || getClass() != obj.getClass())
		{
			return false ;
		}
		
		PalindromeTester other = (PalindromeTester) obj ;		
		return this.inputString.equals(other.inputString) ;
	}
}