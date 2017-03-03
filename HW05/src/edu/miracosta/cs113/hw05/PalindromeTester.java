package edu.miracosta.cs113.hw05;

public class PalindromeTester
{
	private ListStack<Character> charStack ;
	private String inputString ;
	
	public PalindromeTester()
	{
		this.inputString = "" ;
		this.charStack = new ListStack<Character>() ;
	}
	public PalindromeTester(String text)
	{
		this.inputString = text.trim() ;
		this.charStack = new ListStack<Character>() ;		
	}
	
	public void setText(String text)
	{
		this.inputString = text ;
	}
	
	public String getText()
	{
		return inputString ;
	}
	
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
	
	
	
	
	
	
	
	
	
	
}
