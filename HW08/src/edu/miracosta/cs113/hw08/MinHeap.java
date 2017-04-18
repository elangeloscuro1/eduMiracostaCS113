package edu.miracosta.cs113.hw08;

import java.util.Comparator ;

/**
 * MinHeap is a subclass of the abstract class Heap.
 * MinHeap Implements the method compare by receiving
 * an instance of the interface comparator that is used to
 * prioritize by the specified comparator.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 * @param <E>  Generic type parameter
 */
public class MinHeap<E> extends Heap<E>
{
	/** To prioritize by a specific order */
	private Comparator<E> comparator ;

	/**
	 * Default Constructor initializes comparator to null.
	 */
	public MinHeap()
	{
		this.comparator = null ;
	}
	
	/**
	 * Constructor that takes in an instance of the Comparator interface
	 * for prioritize ordering.
	 * 
	 * @param comp the comparator to be used to prioritize ordering.
	 */
	public MinHeap(Comparator<E> comp)
	{
		this.comparator = comp ;
	}	
	
	/**
     * If Comparator is not null, compares two elements using the compare method
     * else, uses the natural order compareTo method ;
     * 
     * @return -1 if left has less priority than right; 0 if left has equals 
     * 			priority than right, and 1 if left has greater priority than right.
     */
	@SuppressWarnings("unchecked")
	public int compare(E left, E right)// protected
	{
		if (this.comparator != null)
		{
			return this.comparator.compare(left, right) ;
		}
		else
		{
			return ((Comparable<E>) left).compareTo(right) ;
		}
	}
}