/**
 * Lab08 compares a stack and a queue by testing their basics methods.
 * 
 * Algorithm:
 * 	In main method:
 * 	A)	-create two objects of the type Stack and one of the type Queue
 * 	  	 that store objects of the type Integer.
 * 	  	-Store: -1, 15, 23, 44, 4, and 99 on the first stack.
 * 		-Display the top of the stack (should store 99).
 * 	B)	-Write a loop to get the numbers of the first stack and store
 * 		 them in the second stack and the queue.
 * 		-Display the number each time it is removed from the first stack.
 * 	C)	-Write a loop to remove and display the value from the second stack
 * 		 and the queue.
 * 		 (Display each value on separately.)
 */
/**
 * @author Angel Tapia
 */

package edu.miracosta.cs113.lab08 ;
import java.util.LinkedList ;
import java.util.Queue ;
import java.util.Stack ;

public class Lab08
{
	public static void main(String[] args)
	{
		Stack<Integer> firstStack = new Stack<Integer>() ;
		Stack<Integer> secondStack = new Stack<Integer>() ;		
		Queue<Integer> queue = new LinkedList<Integer>() ;
		
		firstStack.push(-1) ;
		firstStack.push(15) ;
		firstStack.push(23) ;
		firstStack.push(44) ;
		firstStack.push(4) ;
		firstStack.push(99) ;
		
		System.out.println("Top of the first stack is: " + firstStack.peek()) ;
		
		System.out.println() ;
						
		while (!firstStack.isEmpty())
		{
			Integer temp = firstStack.pop() ;
			queue.offer(temp) ;
			secondStack.push(temp) ;			
			System.out.println("push/offer: " + temp) ;
		}
			
		System.out.println() ;
		
		while (!secondStack.isEmpty())
		{
			int queueValue = queue.poll() ;
			int stackValue = secondStack.pop() ;
			System.out.printf("STACK: %-3s     QUEUE: %-3s%n", stackValue, queueValue) ;
		}
	}
}