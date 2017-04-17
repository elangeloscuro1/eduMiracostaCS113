package edu.miracosta.cs113.lab13.programming_2_pg_372;

import java.io.FileInputStream ;
import java.io.FileNotFoundException ;
import java.util.Scanner ;

import edu.miracosta.cs113.lab13.programming_1_pg_372.CounterMap;
/**
 * CounterMap2 is a subclass of CouterMap and is used to read text files to 
 * count the occurrences of each word in the text file.
 * 
 * @author Angel Tapia angelTapia07084759@gmail.com
 * version 1.0
 */
public class CounterMap2 extends CounterMap
{
	/**
	 * Default constructor class calls the super class 
	 * to ensure the access to the protected variable buildIndex.
	 */
	public CounterMap2()
	{
		super() ;
	}
	
	/**
	 * buildWordCounts counts the occurrences of each word in a text file and stores them
	 * in the buildIndex variable which is of the type Map.
	 * Precondition: file path should include the file extension (.txt).
	 * 
	 * @param path represent the relative of absolute path of the file to be read.
	 * @return true if the file reading process succeeds; false otherwise.
	 */
	public String buildWordCounts(String path)
	{
		StringBuilder stringBuilder = new StringBuilder() ;
		try
		{
			scan = new Scanner(new FileInputStream(path)) ;
			
			while (scan.hasNextLine())
			{
				String currentLine = scan.nextLine() ;
				stringBuilder.append(currentLine + "\n") ;
				String[] keys = currentLine.replaceAll("\\p{P}", "").toLowerCase().split(" ") ;
				
				for (int i = 0; i < keys.length; i++)
				{
					Integer value = buildIndex.get(keys[i]) ;
					
					if ( value != null)
					{
						buildIndex.put(keys[i], value + 1) ;
					}
					else
					{
						buildIndex.put(keys[i], 1) ;
					}
					
				}
				
			}
		}
		catch (FileNotFoundException e)
		{
			if (scan != null)
			{
				scan.close() ;
			}
			return null ;
		}
		
		if (scan != null)
		{
			scan.close() ;
		}
		return stringBuilder.toString() ;		
	}	
}