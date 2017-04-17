package edu.miracosta.cs113.lab13.programming_1_pg_372;
/**
 * Algorithm:
 * 	A) Create a class CounterMap
 * 		-Create a protected variable buildIndex of the type Map.
 * 		-Create a protected variable scan of the type Scanner.
 * 		-Make the default constructor initializes buildIndex.
 * 		-Override the toString method by returning the data of buildIndex.
 * 		-Override the equals method by comparing the buildIndex of 
 * 		 this and another CounterMap.
 * 	B) Create a tester class... in main:
 * 		-Create an instance of the class CounterMap.
 * 		-Create a String type variable that contains any text to read.
 * 		-Create an instance of the class scanner using the protected 
 * 		 variable of the type CounterMap.
 * 		-Use a while loop  to scan the String with the Scanner object:
 * 		 while scan has next word, test if such a word is already in the
 * 		 buildIndex Map.
 * 		 If yes, add one more value
 * 		 else, add a new word to buildIndex.
 * 		-Display the result.
 * 		-close the scan variable. 
 */
import java.util.Scanner ;
/**
 * CounterMapTester is the tester of the instance variable 
 * of the class CounterMap 
 * 
 * @author Angel Tapia angelTapia07084759@gmail.com
 * version 1.0
 */
public class CounterMapTester
{	
	/**
	 * Tests the class CounterMap with a by reading a text of the type string.
	 * 
	 * @param args Command lines
	 */
	public static void main(String[] args)
	{
		CounterMap test = new CounterMap() ;
		String textTest = "This line is first and line 2 is second followed by the third line" ;
				
		test.scan = new Scanner(textTest) ;
		while (test.scan.hasNext())
		{
			String key = test.scan.next() ;
			Integer value = test.buildIndex.get(key) ;
			if ( value != null)
			{
				test.buildIndex.put(key, value + 1) ;
			}
			else
			{
				test.buildIndex.put(key, 1) ;
			}
		}
		System.out.println(test) ;
		test.scan.close() ;
	}
}