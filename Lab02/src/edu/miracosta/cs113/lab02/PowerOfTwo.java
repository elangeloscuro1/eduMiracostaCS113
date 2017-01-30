package edu.miracosta.cs113.lab02;

public class PowerOfTwo
{
	public static boolean isPowerOfTwo(double number)
	{
		if (number < 2)
		{
			return false ;
		}
		else if (number % 2 == 0)
		{
			return true ;
		}
		else
		{
			System.out.println(number / 2) ;
			return isPowerOfTwo(number / 2) ;
		}
	}

	public static void main(String[] args)
	{
		System.out.println(isPowerOfTwo(2)) ;
		
	}

}