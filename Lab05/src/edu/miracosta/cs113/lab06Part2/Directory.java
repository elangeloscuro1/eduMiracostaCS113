/**
 * Directory can store a list of DirectoryEntry objects.
 * This class can add, change a phone number of a person,
 * or remove a person from the list.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113.lab06Part2;

import java.util.ArrayList ;

public class Directory
{
	/**
	 * theDirectory stores a list of DirectoryEntry objects.
	 */
	private ArrayList<DirectoryEntry> theDirectory ;
	
	/**
	 * Default constructor initializes theDirectory.
	 */
	public Directory()
	{
		theDirectory = new ArrayList<DirectoryEntry>() ;
	}
	
	//*************		Lab05 part 2.1			******************
	/**
	 * Add an entry to theDirectory of change an existing entry.
	 * 
	 * @param aName The name of the person to be added of changed.
	 * @param newNumber The number of the person to be added of changed.
	 * @return The oldNumber or null if the person did not exist in the list.
	 */
	public String addOrChangeEntry(String aName, String newNumber)
	{
		// Entry to be added or changed.
		DirectoryEntry newEntry = new DirectoryEntry(aName, newNumber) ;
		int size = theDirectory.size() ;
		
		// Searches for any occurrence
		for (int i = 0 ; i < size ; i++)
		{
			if (theDirectory.get(i).getName().equals(aName))
			{
				return theDirectory.set(i, newEntry).getNumber() ;
			}
		}
		// No Occurrence found; adding newEntry to theDirectory.
		theDirectory.add(newEntry) ;
		return null ;
	}
	
	//*************		Lab05 part 2.2			******************
	/**
	 * Remove an entry from theDirectory.
	 * 
	 * @param aName The name of the person to be removed.
	 * @return the person that is removed or null if no person is removed.
	 */
	public DirectoryEntry removeEntry(String aName)
	{
		int size = theDirectory.size() ;
		
		for (int i = 0; i < size; i++)
		{			
			if (theDirectory.get(i).getName().equals(aName))
			{
				return theDirectory.remove(i) ;
			}
		}
		
		/* THE PIECE OF CODE DOES NOT WORK
		int index = theDirectory.indexOf(aName) ;		
		if (index > -1)// Found a person to remove.
		{
			return theDirectory.remove(index) ;
		}
		*/
		return null ;// No person was found.
	}
	
	/**
	 * Displays all of the entries in theDirectory.
	 */	
	public void displayEntries()
	{
		for (DirectoryEntry directoryEntry : theDirectory)
		{
			System.out.println(directoryEntry) ;
		}
	}
	
	/**
	 * Contains the total of entries.
	 * 
	 * @return the total of entries in theDirectory.
	 */
	@Override
	public String toString()
	{
		return "Total Entries: " + theDirectory.size()  ;
	}
	/**
	 * Compares if two objects of the class Directory have the same
	 * reference.
	 * 
	 *  @return true if the two objects have the same reference.
	 */
	@Override
	public boolean equals(Object object)
	{
		if (object == null || getClass() != getClass())
		{
			return false ;
		}
		Directory other = (Directory) object ;
		return this == other ;
	}	
}