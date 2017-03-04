package edu.miracosta.cs113.hw05;

import java.util.EmptyStackException ;

/**
 * ListStack is an implementation of a stack data structure.
 * It uses an inner class Node to store a data list for the stack.
 */
/**
 * @author Angel Tapia
 *
 * @param <T> Generic type ListStack
 */

public class ListStack<T>
{
	/** topOfStack represents the top of the stack
	 *  and links to the rest of the elements */
	private Node<T> topOfStack ;
	
	/***********************************
	 * Inner Generic Class Node
	 * (stores data for the stack)
	 ***********************************/
	private static class Node<T> 
	{
		private Node<T> link ;
		private T data ;
		
		private Node(T data, Node<T> link)
		{
			this.data = data ;
			this.link = link ;
		}
	}// End of inner class	
	
	
	/**
	 * Default constructor initializes topOfStack.
	 */
	public ListStack()
	{
		this.topOfStack = null ;
	}	
	
	/**
	 * empty checks if the stack is empty.
	 * 
	 * @return true if the stack is empty; false otherwise.
	 */
	public boolean empty()
	{
		return this.topOfStack == null ;
	}
	
	/**
	 * peek accesses the last item pushed into the stack without removing it.
	 * 
	 * @return the last item pushed into the stack without removing it.
	 * @throws EmptyStackException if peek is call on an empty stack.
	 */
	public T peek()
	{
		if (empty())
		{
			throw new EmptyStackException() ;
		}
		return this.topOfStack.data ;
	}
	
	/**
	 * pop accesses and removes the last item pushed into the stack.
	 * 
	 * @return the last item pushed into the stack and removes it from the stack.
	 * @throws EmptyStackException if pop is call on an empty stack.
	 */
	public T pop()
	{
		if (empty())
		{
			throw new EmptyStackException() ;
		}
		T temp = this.topOfStack.data ;
		this.topOfStack = this.topOfStack.link ;
		return temp ;		
	}
	
	/**
	 * push adds an element to the top of the stack. 
	 * 
	 * @param object represents the element to be added.
	 * @return the element that is added.
	 */
	public T push(T object)
	{
		this.topOfStack = new Node<T>(object, this.topOfStack) ;
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
		Node<T> tempNode = this.topOfStack ;
		
		while (tempNode != null)
		{
			temp += tempNode.data + "\n" ;			
			tempNode = tempNode.link ;
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
		ListStack<T> other = (ListStack<T>) obj ;		
		return toString().equals(other.toString()) ;		
	}	
}