/**
 * Program Description:
 * 		This Program Tests the class Directory by using the methods
 * 		addOrChangeEntry and removeEntry.
 * 		addOrChangeEntry  adds an object of the class DirectoryEntry
 * 		or change data field if the object exist.
 * 		removeEntry removes one element in the list (searched by name). 
 * 
 * Algorithm:
 * 		A) Create a class DirectoryEntry.
 * 			-Instance Variables: name and number
 * 			-Respectively constructors; 
 * 			 setters, getters, toString, and equals method.
 * 		B) Create a composite class Directory.
 * 			-Instance variable: theDirectory is an
 * 			 ArrayList of DirectoryEntry objects.
 * 			-Default Constructor initializes theDirectory.
 * 			-Create a method addOrChangeEntry that receives
 * 			 a name and number of the object to be changed or added.
 * 			-Create a removeEntry method that receives the name
 * 			 of the object to be removed.
 * 			-Create a displayEntry method that displays
 * 			 all of the elements in the list.
 * 			-Override the toString and equals method.
 * 		C) Create a Lab05Part2Driver class
 * 			-Create an instance of the class Directory.
 * 			-Add a couple entries.
 * 			-Display list.
 * 			-Replace an existing entry.
 * 			-Display new list.
 * 			-Deleting an existing entry.
 * 			-Display entries.
 * 			-Display the of the program.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113.lab05Part2;

public class Lab05Part2Driver
{
	/**
	 * main tests the class Directory
	 * 
	 * @param args command line
	 */
	public static void main(String[] args)
	{
		Directory directory = new Directory() ;
		
		System.out.println("Adding and displaying directory:") ;
		directory.addOrChangeEntry("Angel Tapia", "760-111-2222") ;
		directory.addOrChangeEntry("Pancho Villa", "187-820-1923") ;
		directory.addOrChangeEntry("Emiliano Zapata", "187-910-1919") ;
		directory.addOrChangeEntry("Donaldo Colosio", "195-023-1994") ;			
		directory.displayEntries() ;
		
		System.out.println("\nReplacing an existing directory: Angel Tapia") ;
		String replacedEntry = directory.addOrChangeEntry("Angel Tapia", "760-123-1234") ;
		System.out.println("Old Number:   " + replacedEntry) ;
		
		System.out.println("Displaying new Changes:") ;
		directory.displayEntries() ;
		
		System.out.println("\nDeleting an existing directory: Donaldo Colosio  ") ;
		System.out.println(directory.removeEntry("Donaldo Colosio")) ;
		
		System.out.println("Displaying new Changes:") ;
		directory.displayEntries() ;
		
		System.out.println("\nEnd of the program!") ;
	}
}