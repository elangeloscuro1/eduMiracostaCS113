package edu.miracosta.cs113.lab13.programming_2_pg_372;

/**
 * Algorithm:
 * 	A) Create a class CounterMap2 that extends CounterMap
 * 		-Add a method buildWordCounts that receives the name of the
 * 		 text file to be read; returns the text in the file an saves
 * 		 the count of the words in the instance variable buildIndex.
 *	B) Create a tester class that contains the main method:
 *		-Create an instance of the class CoiunterMap2.
 *		-Create a String variable to store the name of the file to be read.
 *		 call the method buildWordCounter using the string object
 *		 that contains the name of the file.
 *		 display the result of the buildIndex Map 
 */
/**
 * CounterMap2Tester test the method buildWordCounts of the class CounterMap2.
 * 
 * @author Angel Tapia angelTapia07084759@gmail.com
 * version 1.0
 */
public class CounterMap2Tester
{
	public static void main(String[] args)//textFileLab13.txt
	{
		CounterMap2 test = new CounterMap2() ;
		String textFileName = "textFileLab13.txt" ;
		
		System.out.println(test.buildWordCounts(textFileName)) ;
		System.out.println(test) ;
	}
}
