/**
 * This class represent a directory where the user can
 * save the name and phone number of a person.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113.lab05Part2;

public class DirectoryEntry
{
	/** Instance variables that represent 
	    name and number of a person   */
	private String name ;
	private String number ;
	
	/**
	 * Default constructor that initializes the instance variable to default 
	 */
	public DirectoryEntry()
	{
		this.name = "NO NAME" ;
		this.number = "000-000-0000" ;
	}
	/**
	 * Full constructor that initializes all of the instance variable.
	 * 
	 * @param name The name of the person to be added.
	 * @param number The phone number of the person to be added.
	 */
	public DirectoryEntry(String name, String number)
	{
		this.name = name ;
		this.number = number ;
	}
	/**
	 * Copy constructor that copies fields of another DirectoryEntry object.
	 * 
	 * @param directoryEntry The object to be copied.
	 */
	public DirectoryEntry(DirectoryEntry directoryEntry)
	{
		this.name = directoryEntry.getName() ;
		this.number = directoryEntry.getNumber() ;	
	}
	
	/**
	 * Setter for name of the person.
	 * 
	 * @param name The name of the person.
	 */
	public void setName(String name)
	{
		this.name = name.trim() ;
	}
	
	/**
	 * Getter for name of the person.
	 * 
	 * @return The name of the person.
	 */
	public String getName()
	{
		return name ;
	}
	
	/**
	 * Setter for the phone number of the person.
	 * 
	 * @param number The phone number of the person.
	 */
	public void setNumber(String number)
	{
		this.number = number.replace(" ", "") ;
	}
	
	/**
	 * Getter for the phone number of the person.
	 * 
	 * @return The phone number of the person.
	 */
	public String getNumber()
	{
		return number ;
	}
	
	/**
	 * Contains all of the values of DirectoryEntry
	 * 
	 * @return the information of all the fields of in  DirectoryEntry.
	 */
	@Override
	public String toString()
	{
		return String.format("Name: %-20s  Number: %-12s", name, number) ;
	}
	/**
	 * Compares all of the fields of two DirectoryEntry objects.
	 * 
	 *  @return true if all of the field are equivalent.
	 */
	@Override
	public boolean equals(Object object)
	{
		if (object == null || getClass() != getClass())
		{
			return false ;
		}
		DirectoryEntry other = (DirectoryEntry) object ;
		return name.equalsIgnoreCase(other.name) && number.equals(other.number) ;
	}	
}