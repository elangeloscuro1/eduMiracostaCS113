package edu.miracosta.cs113.lab02;

public class Lab02Driver
{

	public static void main(String[] args)
	{
		PowerOfTwo power = new PowerOfTwo() ;
		
		for (int i = 1 ; i < 40 ; i++)
		{
			String isPower = power.isPower(i) ? "is" : "is not" ;
			
			System.out.println(i +" " + isPower + " a power of two.") ;
		}
		System.out.println() ;

	}

}
