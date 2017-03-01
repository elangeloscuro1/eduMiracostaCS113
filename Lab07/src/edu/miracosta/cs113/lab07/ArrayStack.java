package edu.miracosta.cs113.lab07;

import java.util.ArrayList ;
import java.util.EmptyStackException ;

/**
 * ArrayStack is a basic implementation of a stack builded with
 * an ArrayList object as the data holder.
 */
/**
 * @author Angel Tapia
 *
 * @param <T> Generic type ArrayStack
 */
public class ArrayStack<T>
{	
	/** arrayStack stores every item for the stack */
	private ArrayList<T> arrayStack ;
	
	/**
	 * Default constructor initializes arrayStack.
	 */
	public ArrayStack()
	{
		arrayStack = new ArrayList<T>() ;
	}
	
	/**
	 * empty checks if the stack is empty.
	 * 
	 * @return true if the stack is empty; false otherwise.
	 */
	public boolean empty()
	{
		return arrayStack.size() == 0 ;
	}
	
	/**
	 * peek accesses the last item pushed into the stack without removing it.
	 * 
	 * @return the last item pushed into the stack without removing it.
	 */
	public T peek()
	{
		if (empty())
		{
			throw new EmptyStackException() ;
		}
		return arrayStack.get(arrayStack.size() - 1) ;
	}
	
	/**
	 * pop accesses and removes the last item pushed into the stack.
	 * 
	 * @return the last item pushed into the stack and removes it from the stack.
	 */
	public T pop()
	{
		if (empty())
		{
			throw new EmptyStackException() ;
		}
		return arrayStack.remove(arrayStack.size() - 1) ;		
	}
	
	/**
	 * push adds an element to the top of the stack. 
	 * 
	 * @param object represents the element to be added.
	 * @return the element that is added.
	 */
	public T push(T object)
	{
		arrayStack.add(object) ;
		return object ;
	}
	
	/**
	 * toString builds a string of all of the values stored in this stack.
	 * 
	 * @return a string of all of the values stored in this stack.
	 */
	@Override
	public String toString()
	{
		String temp = "" ;
		for (T e : arrayStack)
		{
			temp = e + "\n" + temp ;
		}
		return temp.trim() ;
	}
	
	/**
	 * equals compares the values stored in this stack and the value stored
	 * in another stack by comparing their toString methods.
	 * 
	 * @return true if all of the values in their toString methods are the same;
	 * 		   false otherwise.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || getClass() != obj.getClass())
		{
			return false ;
		}
		
		@SuppressWarnings("unchecked")
		ArrayStack<T> other = (ArrayStack<T>) obj ;
		
		return toString().equals(other.toString()) ;		
	}	
}