package edu.miracosta.cs113.lab07;

/**
 * ArrayStackTest is a Tester class for the class ArrayStack.
 * 
 * Algorithm
 * 	A) Create a class ArrayStack that contains the basic methods of a stack.
 * 		-Create an instance variable arrayStack of the type ArrayList
 * 		 to store the data for the for the stack.
 * 		-Initialize arrayStack in the default constructor.
 * 		-Create the method empty by checking if arrayStack is empty.
 * 		-Create the method peek:
 * 		 get the last item that was added or throw EmptyStackException if empty == true.
 * 		-Create the method pop by removing the last item added 
 * 		 or throw EmptyStackException if empty == true.
 * 		-Create the method push by adding an item to arrayStack.
 * 		-Override the toString method: build a string of all of the 
 * 		 value in arrayStack such that the last item shows first.
 * 		-Override the equals method: compare the toString values.
 * 	B) Create a Tester class
 * 		-Create an object of the type ArrayStack.
 * 		-Test empty method: true
 * 		-Test method push and display stack.
 * 		-Test empty method: false
 * 		-Test method peek and display stack.
 * 		-Test method pop and display stack.
 */
/**
 * @author Angel Tapia
 */
public class ArrayStackTest
{
	public static void main(String[] args)
	{
		// ArrayStack object
		ArrayStack<String> test = new ArrayStack<String>() ;
		
		// Testing empty method: true
		System.out.println("empty: " + test.empty()) ;
		
		// Testing method push and displaying stack
		System.out.println("push: " + test.push("item1")) ;	
		System.out.println("push: " + test.push("item2")) ;	
		System.out.println("push: " + test.push("item3")) ;	
		System.out.println("push: " + test.push("item4")) ;	
		System.out.println("push: " + test.push("item5")) ;	
		System.out.println("push: " + test.push("item6")) ;			
		System.out.println("------ All Items in stack------\n" + test) ;
		
		// Testing empty method: false
		System.out.println("empty: " + test.empty()) ;
		
		// Testing method peek and displaying stack		
			
		System.out.println("pick: " + test.peek()) ;
		System.out.println("------ All Items in stack------\n" + test) ;
		
		// Testing method pop and displaying stack	
		System.out.println("pop: " + test.pop()) ;
		System.out.println("------ All Items in stack------\n" + test) ;		
	}
}