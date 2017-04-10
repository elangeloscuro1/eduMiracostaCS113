package edu.miracosta.cs113.hw07;

/**
 * Algorithm:
 * A) Implement the generic BinaryTree data structure(slide show)
 * 	 
 * B) Create a class that extends BinaryTree with String parameter.
 * 		Create a method build tree that reads a text file that contains the letters
 * 		and their respectively morse coded.
  		-Crwate a metho decodeMessage:
  		-Create method EncodeMessage.
 */
import java.io.FileInputStream ;
import java.io.FileNotFoundException ;
import java.util.Scanner ;
/**
 * 
 * HW07Driver offers option view a morse code chart; translate from morse code to text 
 * or from text to morse code
 */
public class HW07Driver
{

	@SuppressWarnings("resource")
	public static void main(String[] args)//MorseCodeTable.txt
	{
		MorseCodeTree test = new MorseCodeTree() ;
		Scanner userIn = new Scanner(System.in) ;
		int option = test.menu() ;
		
		while (option != 0)
		{
			switch (option)
			{
			case 1:

				System.out.println(test.morseCodeTable()) ;
				break ;
			case 2:

				System.out.print("Enter file name(w/out the extention): ") ;
				try
				{
					Scanner scan = new Scanner(new FileInputStream(userIn.nextLine().trim() + ".txt")) ;

					String message = "" ;
					while (scan.hasNext())
					{
						message += scan.next() + " " ;
					}
					System.out.println(test.decodeMessage(message)) ;
				}
				catch (FileNotFoundException e)
				{
					System.out.println(e.getMessage()) ;
				}
				break ;
			case 3:
				System.out.print("Enter morse code: ") ;
				System.out.println(test.decodeMessage(userIn.nextLine())) ;
				break ;
			case 4:
				System.out.print("Enter word: ") ;
				System.out.println(test.encodeMessage(userIn.nextLine())) ;
				break ;
			default:
				option = 0 ;
				break ;
			}
			option = test.menu() ;
		}
		userIn.close() ;
	}
}