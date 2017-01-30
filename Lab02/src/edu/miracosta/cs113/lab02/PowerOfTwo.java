package edu.miracosta.cs113.lab02;

public class PowerOfTwo
{
	/** Default constant of base **/
	public static final double BASE = 2.0 ;
	
	/** Instance variable that represent the base
	 	of the base of the power */
	private double base ;
	
	/**
	 * Default constructor that initializes
	 * base to a default value.
	 */
	public PowerOfTwo()
	{
		this.base = BASE ;
	}
	
	/**
	 * Full constructor that initializes to a specific base.
	 * 
	 * @param base represents a specific base.
	 */
	public PowerOfTwo(double base)
	{
		
		this.base = base ;
	}
	
	/**
	 * Mutator to set a specific base to be used.
	 * 
	 * @param base represents a specific base.
	 */
	public void setBase(double base)
	{
		if (base == 0)// Base zero is invalid
		{
			System.out.println("Fatal error: inavlid value!") ;
			System.out.println("Exiting program...") ;
			System.exit(0) ;			
		}		
		this.base = base ;
	}
	
	/**
	 * Accessor to get the value of the base.
	 * 
	 * @return the value of the current base.
	 */
	public double getBase()
	{
		return base ;
	}
	
	/**
	 * Checks if the test value is a power of the base.
	 * 
	 * @param testValue represents the test value.
	 * @return true if the test value is a power of the base.
	 */
	public boolean isPower(double testValue) 
	{
		if (base == testValue)
		{
			return true ;
		}
		if (testValue < base)
		{
			return false ;
		}		
		else
		{
			return isPower(testValue / base) ;
		}
	}
	
	/**
	 * Prints the current base of the test.
	 * 
	 * @return the value of the current test.
	 */
	@Override
	public String toString()
	{
		return "Current Base: " + base ;
	}
	
	/**
	 * Compares two objects of the class PowerOfTwo.
	 * 
	 * @param obj is an object of the same class.
	 * @return true if the base of the two classes are equals.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || this.getClass() != obj.getClass())
		{
			return false ;
		}
		
		PowerOfTwo other = (PowerOfTwo) obj ;	
			
		return base == other.base ;
	}
}