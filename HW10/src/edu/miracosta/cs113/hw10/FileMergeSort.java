package edu.miracosta.cs113.hw10 ;

import java.io.File ;
import java.io.FileNotFoundException ;
import java.io.FileOutputStream ;
import java.io.PrintWriter ;
import java.util.Scanner ;

/**
 * 
 */
/**
 * FileMergeSort is sorts file using sequential data files.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * version 1.0
 */
public class FileMergeSort
{

	/**
	 * Sorts a sequential data file that contains integers.
	 * 
	 * @param args Command Lines.
	 */
	public static void main(String[] args)
	{
		// Files to be used
		File originalFile = new File("OriginalFileForMergeSort.txt") ;
		File leftFile = new File("leftFile.txt") ;
		File rightFile = new File("rightFile.txt") ;
		File tempFile = new File("tempFile.txt") ;
		
		// flag
		boolean isSorted = false ;
		while (!isSorted )
		{
			try
			{
				// Delete any existent file
				leftFile.delete() ;
				rightFile.delete() ;
				tempFile.delete() ;				
				
				// scanner an writer for the lezt and right files
				Scanner scanOriginal = new Scanner(originalFile) ;
				PrintWriter leftWriter = new PrintWriter(new FileOutputStream(leftFile, true)) ;
				PrintWriter rightWriter = new PrintWriter(new FileOutputStream(rightFile, true)) ;

				// Scanners and writer to update the original file.
				Scanner scanLeft = new Scanner(leftFile) ;
				Scanner scanRight = new Scanner(rightFile) ;
				PrintWriter newWriter = new PrintWriter(new FileOutputStream(tempFile, true)) ;

				int countSwaps = 0 ;// 0 swaps means is sorted
				
				// 
				while (scanOriginal.hasNext())
				{
					int current = scanOriginal.nextInt() ;

					if (scanOriginal.hasNextInt())
					{
						int next = scanOriginal.nextInt() ;

						leftWriter.println((next < current) ? next : current) ;
						rightWriter.println((next > current) ? next : current) ;						
						leftWriter.flush() ;
						rightWriter.flush() ;						
						countSwaps = current > next ? (countSwaps + 1) : countSwaps ;
						
					}
					else
					{
						leftWriter.println(current) ;
						leftWriter.flush() ;
					}
				}
				
				isSorted = countSwaps == 0 ;
				
				if (isSorted)
				{
					return ;
				}

				boolean isMerging = true ;

				Integer nextLeft = scanLeft.hasNext() ? scanLeft.nextInt() : null ;
				Integer nextRight = scanRight.hasNext() ? scanRight.nextInt() : null ;

				while (isMerging)
				{
					if (nextLeft != null && nextRight != null)
					{

						if (nextLeft < nextRight)
						{
							newWriter.println(nextLeft) ;
							newWriter.flush() ;
							nextLeft = scanLeft.hasNext() ? scanLeft.nextInt() : null ;
						}
						else
						{
							newWriter.println(nextRight) ;
							newWriter.flush() ;
							nextRight = scanRight.hasNext() ? scanRight.nextInt() : null ;
						}
					}
					else if (nextLeft != null)
					{
						newWriter.println(nextLeft) ;
						newWriter.flush() ;
						nextLeft = scanLeft.hasNext() ? scanLeft.nextInt() : null ;
					}
					else if (nextRight != null)
					{
						newWriter.println(nextRight) ;
						newWriter.flush() ;
						nextRight = scanRight.hasNext() ? scanRight.nextInt() : null ;
					}
					else
					{
						isMerging = scanLeft.hasNext() || scanRight.hasNext() ;
					}

				}
				
				leftWriter.close() ;
				rightWriter.close() ;
				newWriter.close() ;

				scanOriginal.close() ;
				scanLeft.close() ;
				scanRight.close() ;

				originalFile.delete() ;
				tempFile.renameTo(originalFile) ; 
			}
			catch (FileNotFoundException e)
			{
				System.out.println(e.getMessage()) ;
			}
		}
	}

}
