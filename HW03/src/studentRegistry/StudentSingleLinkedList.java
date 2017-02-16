/**
 * This class Creates a list of students and can
 * add a student to the beginning or end of the list
 * And can also remove the first or by name from the list.
 */
/**
 * @author Angel Tapia
 */
package studentRegistry ;

public class StudentSingleLinkedList
{
	/***********************************
	 * Inner Class: Node.
	 ***********************************/
	private static class Node
	{
		private Node link ;
		private Student data ;

		public Node(Student data, Node link)
		{
			this.data = data ;
			this.link = link ;
		}
	}// End of inner class

	/** head represents the beginning of the list */
	private Node head ;
	/** size counts the number of student in the list */
	private int size ;

	/**
	 * Default constructor
	 */
	public StudentSingleLinkedList()
	{
		this.size = 0 ;
		this.head = null ;
	}

	/**
	 * Adds a student to the list.
	 * 
	 * @param name of the student to be added.
	 */
	public void addToStart(String name)
	{
		
		this.head = new Node(new Student(name, 1), head) ;
		Node temp = head ;
		
		for (int i = 1 ; temp != null ; i++)
		{
			temp.data.setNumberInLine(i) ;
			temp = temp.link ;
		}
		size++ ;		
	}

	/**
	 * Adds a Student to the end of the list.
	 * 
	 * @param term represents the element to be added.
	 */
	public void addToEnd(String name)
	{
		if (this.head == null)
		{
			addToStart(name) ;
		}
		else
		{
			Node newNode = this.head ;
			while (newNode.link != null)
			{
				newNode = newNode.link ;
			}
			newNode.link = new Node(new Student(name, ++size), newNode.link) ;
		}
	}

	/**
	 * Removes the first element in the list.
	 * 
	 * @return return the elements that is removed or null if list is empty.
	 */
	public Student removeFirst()
	{
		if (this.head == null)
		{
			return null ;
		}
		Student temp = head.data ;
		size-- ;
		Node tempHead = this.head = this.head.link ;
		for (int i = 0; tempHead != null; i++)
		{
			tempHead.data.setNumberInLine(i + 1) ;
			tempHead = tempHead.link ;
		}
		return temp ;
	}

	/**
	 * searches for the name of the student to be removed.
	 * 
	 * @return the element that has been removed or null if list is empty.
	 */
	public Student remove(String name)
	{
		Node temp = this.head ;
		Student student = null ;
		int index = 0 ;
		
		if (this.head == null)
		{
			return null ;
		}
		if (this.head != null && temp.data.getName().equals(name))
		{
			return removeFirst() ;
		}
		
		for (index = 2 ; temp.link != null ; index++)
		{
			if (temp.link.data.getName().equals(name))
			{
				student = temp.link.data ;
				temp.link = temp.link.link ;
				index-- ;
				size-- ;
			}
			else 
			{				
				temp = temp.link ;
			}
			temp.data.setNumberInLine(index);			
		}
		return student ;
	}

	/**
	 * @return the number of element in the list.
	 */
	public int getSize()
	{
		return this.size ;
	}
	
	/**
	 * @return an element from a specific index
	 * 		   or null if index is greater than the list size.
	 */
	public Student get(int index)
	{
		Node temp = this.head ;
		for (int i = 0 ; temp != null && i < index ; i++)
		{
			temp = temp.link ;
		}
		return temp == null ? null : temp.data ;
	}

	/**
	 * @return the every student in the list.
	 */
	@Override
	public String toString()
	{
		String temp = "" ;
		Node newNode = this.head ;
		while (newNode != null)
		{
			temp += newNode.data + "\n" ;
			newNode = newNode.link ;
		}
		return temp.length() > 0 ? temp : null ;
	}

	/**
	 * @return true if every element in the both lists have the same value.
	 */
	@Override
	public boolean equals(Object object)
	{
		if (object == null || getClass() != object.getClass() )
		{
			return false ;
		}
		Node thisList = this.head ;
		Node otherList = ((StudentSingleLinkedList) object).head ;
		while (thisList != null && otherList != null)
		{
			if (!thisList.data.equals(otherList.data))
			{
				return false ;
			}
			thisList = thisList.link ;
			otherList = otherList.link ;
		}
		return true ;
	}
}