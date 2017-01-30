/**
 * FizzBuzz.java Represents the test for multiple o
 * a first number, a second number or the first times
 * the second times a testing value.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113.lab01 ;

public class FizzBuzz
{
	/**
	 * Constants for default test and testing values.
	 */
	public static final int DEFAULT_FIZZ_VALUE = 3 ;
	public static final int DEFAULT_BUZZ_VALUE = 5 ;
	public static final String FIZZ_STRING = "Fizz" ;
	public static final String BUZZ_STRING = "Buzz" ;
	
	/**
	 * Instance variables that represents the values for
	 * the testing and the current value to be tested.
	 */
	private int fizz ;
	private int buzz ;
	private int currentValue ;
	
	/**
	 * Default constructor that initializes all the instance variables
	 * to the default values.
	 */
	public FizzBuzz()
	{
		this.fizz = DEFAULT_FIZZ_VALUE ;
		this.buzz = DEFAULT_BUZZ_VALUE ;
		this.currentValue = 0 ;
	}
	
	/**
	 * Full constructor receives values for the testing variables. 
	 * 
	 * @param fizz represents a value of the test.
	 * @param buzz represents a value of the test.
	 */
	public FizzBuzz(int fizz, int buzz)
	{
		if (fizz == 0 || buzz == 0)
		{
			System.out.println("Fatal error: Value '0' is invalid!") ;
			System.out.println("Exiting program...") ;
			System.exit(0) ;
		}
		this.fizz = fizz ;
		this.buzz = buzz ;
		this.currentValue = 0 ;
	}
	
	/**
	 * Muttator to set a value of the test.
	 * 
	 * @param fizz represents a value of the test.
	 */
	public void setFizz(int fizz)
	{
		if (fizz == 0)
		{
			System.out.println("Fatal error: Value '0' is invalid!") ;
			System.out.println("Exiting program...") ;
			System.exit(0) ;
		}
		this.fizz = fizz ;
	}

	/**
	 * Accessor of the fizz value.
	 * 
	 * @return the value of fizz.
	 */
	public int getFizz()
	{
		return fizz ;
	}

	/**
	 * Mutator to set a value of the test.
	 * 
	 * @param buzz represent a value of the test.
	 */
	public void setBuzz(int buzz)
	{
		if (buzz == 0)
		{
			System.out.println("Fatal error: Value '0' is invalid!") ;
			System.out.println("Exiting program...") ;
			System.exit(0) ;
		}
		this.buzz = buzz ;
	}
	
	/**
	 * Accesor of the buzz value.
	 * 
	 * @return the value of buzz.
	 */
	public int getBuzz()
	{
		return buzz ;
	}
	
	/**
	 * Mutator of the value to be tested.
	 * 
	 * @param currentValue represents the value to be tested.
	 */
	public void setCurrentValue(int currentValue)
	{
		this.currentValue = currentValue ;
	}
	
	/**
	 *  Accessor of value to be tested.
	 * 
	 * @return the value of currentValue. 
	 */
	public int getCurrentValue()
	{
		return currentValue ;
	}
	
	/**
	 * Tests for multiples of buzz.
	 * 
	 * @param fizzValue represents the value to be tested.
	 * @return fizzValue / fizz has not remainder.
	 */
	public boolean isFizz(int fizzValue)
	{
		if (fizzValue < fizz)
		{
			return false ;
		}
		return (fizzValue % fizz == 0) ;
	}
	
	/**
	 * Tests for multiples of fizz.
	 * 
	 * @param buzzValue represents the value to be tested.
	 * @return true if buzzValue / buzz has not remainder.
	 */
	public boolean isBuzz(int buzzValue)
	{
		if (buzzValue < buzz)
		{
			return false ;
		}
		return (buzzValue % buzz == 0) ;
	}
	
	/**
	 * Tests for multiples of fizz and buzz.
	 * 
	 * @param fizzBuzzValue represents the value to be tested.
	 * @return true if fizzBuzzValue / fizzBuzz has not remainder.
	 */
	public boolean isFizzBuzz(int fizzBuzzValue)
	{
		int fizzBuzz = fizz * buzz ;
		
		if (fizzBuzzValue < fizzBuzz)
		{
			return false ;
		}
		return (fizzBuzzValue % fizzBuzz == 0) ;
	}
	
	/**
	 * toString prints the corresponding string of 
	 * the current value.
	 * 
	 * @return "Fizz", Buzz", or "FizzBuzz" string, according to the 
	 * 		    current value, returns null if current value is undefined.
	 */
	@Override
	public String toString()
	{
		if (isFizzBuzz(currentValue))
		{
			return FIZZ_STRING + BUZZ_STRING.toLowerCase() ;
		}
		else if (isFizz(currentValue))
		{
			return FIZZ_STRING ;
		}
		else if (isBuzz(currentValue))
		{
			return BUZZ_STRING ;
		}
		return null ;
	}
	
	/**
	 * equals method checks if two object of the same class
	 * are equals.
	 * 
	 * @return true if all values are equals.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || this.getClass() != obj.getClass())
		{
			return false ;
		}
		FizzBuzz other = (FizzBuzz) obj ;		
		return fizz == other.fizz 
			&& buzz == other.buzz && currentValue == other.currentValue ;
	}
}