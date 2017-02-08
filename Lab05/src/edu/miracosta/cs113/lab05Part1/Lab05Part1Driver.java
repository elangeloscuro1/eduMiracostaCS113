/**
 * Program Description:
 * 		This program tests the methods replace and delete that can be
 * 		used for a list object of the ArrayList class.
 * 		The method replace replaces each occurrence of an old item
 * 		with a new item in the list.
 * 		The method delete delete the first occurrence of the targeted item
 *      in the list. 
 * 
 * Algorithm:
 * 		A) Define the method replace.
 * 			-Create a for loop to traverse the list and replace each occurrence.
 * 			-Replace the old item with the new one.
 * 		B) Define the method delete.
 * 			-Using the method indexOf, store the index of the first 
 * 			 occurrence of the target item and call the method remove
 * 			 to get to remove the item in the list.
 * 		C) Test methods in main.
 * 			-Create an array of String item and an object of ArrayList
 * 			 that is a list of String objects.
 * 			-Add elements of the array to list.
 * 			-Display the original list.
 * 			-Call the method replace and chose the items to be replaced.
 * 			-Display the new List.
 * 			-Call the method delete and choose the item to be deleted.
 * 			-Display the new List.
 * 			-Display end of the program.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 */

package edu.miracosta.cs113.lab05Part1 ;

import java.util.ArrayList ;

public class Lab05Part1Driver
{
	//*************		Lab05 part 1.1			******************
	/**
	 * Replaces each occurrence of oldItem in aList with newItem 
	 * 
	 * @param aList represents a list of String objects
	 * @param oldItem represents the item to be replaced
	 * @param newItem represents the new item for the replacement.
	 */
	public static void replace(ArrayList<String> aList, String oldItem, String newItem)
	{
		for (int i = 0; i < aList.size(); i++)
		{
			if (aList.get(i).equals(oldItem))
			{
				aList.set(i, newItem) ;
			}
		}
	}

	//*************		Lab05 part 1.2			******************
	/**
	 * Deletes the first occurrence of target in aList
	 *  
	 * @param aList represents a list of String objects
	 * @param target represents the item to be deleted
	 */
	public static void delete(ArrayList<String> aList, String target)
	{
		int index = aList.indexOf(target) ;
		if (index > -1)
		{
			aList.remove(index) ;
		}
	}
	
	/**
	 * main tests the static method replace an d delete
	 * 
	 * @param args command line
	 */
	public static void main(String[] args)
	{
		//	Array of String items and object of ArrayList of String
		String[] array = { "AAA", "BBB", "CCC", "AAA", "BBB", "CCC" } ;
		ArrayList<String> list = new ArrayList<String>() ;

		//	Adding array items to list
		for (String string : array)
		{
			list.add(string) ;
		}
		
		//	Displaying original list
		System.out.println("ORIGINAL LIST: ") ;
		for (String string : list)
		{
			System.out.println(string) ;
		}
		
		//	Replacing old item with new items
		System.out.println("\nNEW LIST: ") ;
		replace(list, "AAA", "XXX") ;
		replace(list, "BBB", "YYY") ;
		replace(list, "CCC", "ZZZ") ;
		
		//	Displaying new list
		for (String string : list)
		{
			System.out.println(string) ;
		}
		
		//	Deleting first instance of target
		delete(list, "XXX") ;
		System.out.println("\nDeeting first instance of:\"XXX\"  ") ;
		
		//	Displaying new list
		for (String string : list)
		{
			System.out.println(string) ;
		}
		
		//	Displaying end of the program
		System.out.println("\nEND OF THE PROGRAM!") ;
		
	}// End of main

}