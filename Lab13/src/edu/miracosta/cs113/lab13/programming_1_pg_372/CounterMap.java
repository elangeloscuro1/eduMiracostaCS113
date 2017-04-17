package edu.miracosta.cs113.lab13.programming_1_pg_372;

import java.util.HashMap ;
import java.util.Map ;
import java.util.Scanner ;

/**
 * CounterMap is a class that can be extended to build a 
 * a Map class that counts words occurrences in a text file.
 * 
 * @author Angel Tapia angelTapia07084759@gmail.com
 * version 1.0
 */
public class CounterMap
{
	/** buildIndex Stores words as the key and the number of time each word occurs*/
	protected Map<String, Integer> buildIndex ;
	/** scan reads inputs from text, string or or keyboard */
	protected Scanner scan ;
	
	/**
	 * Default constructor initializes occurrence.
	 */
	public CounterMap()
	{
		buildIndex = new HashMap<String, Integer>() ;
	}
	
	/**
	 * access the toString of buildIndex
	 * 
	 * @return returns the toString method of buildIndex.
	 */
	@Override
	public String toString()
	{		
		return buildIndex.toString() ;
	}
	
	/**
	 * Check for equality between the buildIndex if this CounterMap 
	 * and another CounterMap's builIndex.
	 * 
	 * @return true if buildIndex of both objects are equivalent; false otherwise.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || obj.getClass() != getClass())
		{
			return false ;
		}
		CounterMap other = (CounterMap) obj ;
		return buildIndex.equals(other.buildIndex) ;
	}
}