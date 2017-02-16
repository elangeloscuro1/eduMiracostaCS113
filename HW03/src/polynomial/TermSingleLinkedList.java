/**
 * TermSingleLinkedList creates a list of terms
 * by adding single terms or other list of terms.
 * this class also has the ability to sort
 * terms by the highest exponent and to combine like
 * terms by calling the method simplify.
 */
/**
 * @author Angel Tapia
 */

package polynomial ;

public class TermSingleLinkedList
{
	/***********************************
	 * Inner Generic Class: Node.
	 ***********************************/
	private static class Node
	{
		private Node link ;
		private Term data ;
		
		public Node(Term data, Node link)
		{
			this.data = data ;
			this.link = link ;
		}
	}// End of inner class	
	
	/** head represents the beginning of the list */
	private Node head ;
	/** size counts the number of terms in the list */
	private int size ;
	
	/**
	 * Default constructor
	 */
	public TermSingleLinkedList()
	{
		this.size = 0 ;
		this.head = null ;
	}
	
	/**
	 * Adds a Term to the list sorted by highest exponent.
	 * 
	 * @param term represents the element to be added.
	 */
	public void addSorted(Term term)
	{		
		if (this.head == null || term.compareTo(this.head.data) > 0)
		{
			this.head = new Node(term, this.head) ;
		}
		else
		{
			Node newNode = this.head ;
			while (newNode.link != null && term.compareTo(newNode.link.data) <= 0)
			{
				newNode = newNode.link ;
			}
			newNode.link = new Node(term, newNode.link) ;
		}
		size++ ;
	}
	
	/**
	 * Adds a list of elements to the end of the list.
	 * 
	 * @param term represents the element to be added.
	 */
	public void addList(TermSingleLinkedList list)
	{
		Node newNode = list.head ;
		while (newNode != null)
		{
			addSorted(newNode.data) ;
			newNode = newNode.link ;
		}
	}
	
	/** 
	 * @return the number of element in the list.
	 */
	public int getSize()
	{
		return this.size ;
	}
	/**
	 * 
	 * @return an element from a specific index
	 * 		   or null if index is greater than the list size.
	 */
	public Term get(int index)
	{
		Node temp = this.head ;
		for (int i = 0 ; temp != null && i < index ; i++)
		{
			temp = temp.link ;
		}
		return temp == null ? null : temp.data ;
	}
	
	/**
	 * Removes the first element in the list.
	 * 
	 * @return return the elements that is removed or null if list is empty.
	 */
	public Term removeFirst()
	{
		if (this.head == null)
		{
			return null ;
		}
		Term temp = this.head.data ;
		this.head = this.head.link ;
		size-- ;
		return temp ;
	}
	
	/**
	 * @return list size information
	 */
	@Override
	public String toString()
	{
		String temp = "" ;
		Node newNode = this.head ;
		while (newNode != null)
		{			
			temp += newNode.data.getTerm() ;
			newNode = newNode.link ;
			temp += newNode != null ? " + " : "\n" ;
		}
		return temp.length() > 0 ? temp : null ;
	}
	
	/**
	 * @return true if both object have the same reference
	 */
	@Override
	public boolean equals(Object object)
	{
		if (object == null || getClass() != object.getClass() )
		{
			return false ;
		}
		TermSingleLinkedList other = (TermSingleLinkedList) object ;
		return toString().equals(other.toString()) ;
	}
}