/**
 * DetectiveJill.java is a class that represent Detective Jill.
 * Therefore, this class contains instance variables that represent
 * assistant jack and lists of weapons, locations, and person(murders)
 * involved in the crime.
 * Also includes method that helps to solve the problem by process
 * of elimination.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113.hw01;

import java.util.Random ;

public class DetectiveJill
{
	/*
	 * Instance Variable represent assistant Jack and each
	 * theory item lists that will be discarded.
	 */
	private AssistantJack assistantJack ;
	private Integer[]  weapons ;  
	private Integer[]  locations ;
	private Integer[]  persons ;	
	
	/** 
	 * Default constructor is not used in this program, but might be 
	 * useful for some programmers.
	 */
	public DetectiveJill()
	{
		assistantJack = null ;
		weapons   = null ;
		locations = null ;
		persons   = null ;		
	}
	
	/**
	 * Full constructor initializes all of the instance variables.
	 *  
	 * @param answerSet initialized assistantJack and is an 
	 * integer that represents the answer sets:
	 * 		(1) fixed answer 1, 1, 1
	 * 		(2) fixed answer 6, 10, 6
	 * 		(3) Integers randomly assigned
	 */
	public DetectiveJill(int answerSet)
	{	
		assistantJack    = new AssistantJack(answerSet) ;
		weapons   = new Integer[TheoryItem.TOTAL_WEAPONS] ;
		locations = new Integer[TheoryItem.TOTAL_LOCATIONS] ;
		persons   = new Integer[TheoryItem.TOTAL_MURDERS] ;	
	}
	
	/**
	 * Mutator for assistantJack (This might be useful for some programmers.)
	 * 
	 * @param assistantJack represents assistant Jack.
	 */
	public void setAssistantJack(AssistantJack assistantJack)
	{
		this.assistantJack = assistantJack ;
	}
	
	/**
	 * Accessor for assistantJack (This might be useful for some programmers.)
	 * 
	 * @return a shallow copy of assistantJack.
	 */
	public AssistantJack getAssistantJack()
	{
		return assistantJack ;
	}
	
	/**
	 * Mutator for weapons (This might be useful for some programmers.)
	 * 
	 * @param weapons represents the list of weapons involved in the crime.
	 */
	public void setWeapons(Integer[] weapons)
	{
		this.weapons = weapons ;
	}	
	
	/**
	 * Accessor for weapons (This might be useful for some programmers.)
	 * 
	 * @return a shallow copy of weapons.
	 */
	public Integer[] getWeapons()
	{
		return weapons ;
	}
	
	/**
	 * Mutator for locations (This might be useful for some programmers.)
	 * 
	 * @param locations represents the list of locations involved in the crime.
	 */
	public void setLocations(Integer[] locations)
	{
		this.locations = locations ;
	}
		
	/**
	 * Accessor for locations (This might be useful for some programmers.)
	 * 
	 * @return a shallow copy of locations.
	 */
	public Integer[] getLocations()
	{
		return locations ;
	}

	/**
	 * Mutator for persons (This might be useful for some programmers.)
	 * 
	 * @param persons represents the list of persons involved in the crime.
	 */
	public void setPersons(Integer[] persons)
	{
		this.persons = persons ;
	}	

	/**
	 * Accessor for persons (This might be useful for some programmers.)
	 * 
	 * @return a shallow copy of persons.
	 */
	public Integer[] getPersons()
	{
		return persons ;
	}
	
	/**
	 * getValidTheoryItem randomly looks for item that has not been
	 * checked off from the list provide in the parameter.
	 * (If the element is null, then the item in the list
	 * 	has not been checked off.)
	 * 
	 * @param theoryItems represents any of the list of items.
	 * 
	 * @return an item number in the list suggested parameter.
	 */
	public int getValidTheoryItem(Integer[] theoryItems)
	{
		Random random = new Random() ;		
		int item = random.nextInt(theoryItems.length) + 1 ;
		
		while (theoryItems[item - 1] != null)
		{
			item = random.nextInt(theoryItems.length) + 1 ;
		}
		return item ;
	}
	
	/**
	 * discardTheoryItem can be used to checks off items in the list of,
	 * weapons, locations, and persons(murders).
	 * 
	 * @param itemType represents (1) weapons, (2) locations, and (3) persons(murders).
	 * @param weapon is the index of the actual weapon in the weapons list.
	 * @param location is the index of the actual location in the locations list.
	 * @param person is the index of the actual person in the persons list.
	 */
	public void discardTheoryItem(int itemType, int weapon, int location, int person)
	{
		switch (itemType)
		{
			case 1:
			{
				weapons[weapon - 1] = 0 ;
				break ;
			}
				
			case 2:
			{
				locations[location - 1] = 0 ;
				break ;
			}
			
			case 3:
			{
				persons[person - 1] = 0 ;
				break ;
			}

			default:
			{
				break ;
			}
		}
	}
		
	/**
	 * getCorrectTheory uses a do-while to try as many solution
	 * as possible in oder to figure out the correct theory.
	 * Each cycle represents each guess from Detective Jill.
	 * In order to find the solution, the method getValidTheoryItem
	 * and discardTheoryItem are used to skip any item that has
	 * been already checked off.
	 * 
	 * @return
	 */
	public Theory getCorrectTheory()
	{
		int weapon, location, person, solution ;
		do
		{
			weapon = getValidTheoryItem(weapons) ;
			location = getValidTheoryItem(locations) ;
			person = getValidTheoryItem(persons) ;
			solution = assistantJack.checkAnswer(weapon, location, person) ;
			discardTheoryItem(solution, weapon, location, person) ;
		}
		while (solution != 0) ;
		
		return new Theory(weapon, location, person) ;
	}
	
	/**
	 * toString displays objects values
	 * 
	 * @return the different items involved in the crime.
	 */
	@Override
	public String toString()
	{
		return "In this crime there are " + weapons.length + " different weapons, "
				+ locations.length + " different locations, and " + persons.length
				+ " diferent persons.";
	}
	
	/**
	 * Equals method checks if another object of the class DetectiveJill
	 * are equals in values.
	 * 
	 * @return true if every values are equals.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || this.getClass() != obj.getClass())
		{
			return false ;
		}
		DetectiveJill other = (DetectiveJill) obj ;
		return this.assistantJack == other.assistantJack
			&& this.weapons == other.weapons 
			&& this.persons == other.persons
			&& this.locations == other.locations ;
	}	
}