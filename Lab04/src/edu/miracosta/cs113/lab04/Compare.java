package edu.miracosta.cs113.lab04;

public class Compare
{
	// main
	public static void main(String[] args)
	{

		
		System.out.println("Y1 = (100 * variable) + 10 ") ;
		System.out.println("Y1 = (5 * variable * variable) + 2 ") ;
		System.out.println() ;
		for (int i = 0; i <= 100; i = i + 10)
		{
			Compare y1 = new Compare(i) ;
			Compare y2 = new Compare(i) ;
			
			System.out.printf("Y1 with n = %-3s:%10s%n", i , y1.getY1()) ;
			System.out.printf("Y2 with n = %-3s:%10s%n%n", i , y1.getY2()) ;
		}


						
	}
	
	// Instance variable
	private int variable ;
	
	public Compare()
	{
		this.variable = 0 ;
	}
	
	public Compare(int variable)
	{
		this.variable = variable ;
	}
	
	public Compare(Compare compare)
	{
		this.variable = compare.variable ;
	}
	
	public int getVariable()
	{
		return variable ;
	}

	public void setVariable(char variable)
	{
		this.variable = variable ;
	}
	
	public int getY1()
	{
		return (100 * variable) + 10 ;
	}
	
	public int getY2()
	{
		return (5 * variable * variable) + 2 ;
	}
	
}
