/**
 * Polynomial uses uses method of the class TermSingleLinkedList
 * to add remove and simplify a list of terms.
 */
/**
 * @author Angel Tapia
 */

package polynomial ;

public class Polynomial
{
	/** creates a linkedList of Terms objects */
	private TermSingleLinkedList termList ;
	
	/**
	 * Default constructor initializes termList.
	 */
	public Polynomial()
	{
		termList = new TermSingleLinkedList() ;
	}
	
	/**
	 * Adds a term to the list, sorted from greatest to lowest exponent values.
	 * 
	 * @param term represents a term to be added to the termList.
	 */
	public void addTerm(Term term)
	{
		termList.addSorted(term) ;
	}
	
	/**
	 * Adds another list of terms to the list.
	 * 
	 * @param list represent the list of term to be added.
	 */
	public void addList(Polynomial list)
	{	
		termList.addList(list.termList);		
	}
	
	/**
	 * Combine terms that are like term.
	 */
	public void simplify()
	{
		TermSingleLinkedList temp = new TermSingleLinkedList() ;
		int constant = 0 ;
		
		while (termList.getSize() > 0)
		{
			Term current = termList.get(0) ;
			Term next = termList.get(1) ;
			int exponent = current.getExponent() ;		
			
			if (current.isConstant())
			{
				constant += current.getCoefficient() ;
				termList.removeFirst() ;
			}
			else if (next != null && next.isConstant())
			{
				constant += next.getCoefficient() ;				
				Term newTerm = termList.get(0) ;
				termList.removeFirst() ;
				termList.removeFirst() ;
				termList.addSorted(newTerm) ;				
			}
			else if (next != null && next.getExponent() == exponent)
			{
				int coefficient = current.getCoefficient() + next.getCoefficient() ;
				termList.get(1).setCoefficient(coefficient) ;
				termList.get(1).setExponent(exponent) ;
				termList.removeFirst() ;
			}
			else
			{
				temp.addSorted(current) ;
				termList.removeFirst() ;
			}
		}
		if (constant != 0)
		{
			temp.addSorted(new Term(constant, "", 1)) ;
		}
		termList = temp ;
	}
	
	/**
	 * displays all of the term in the list by calling the toString method.
	 */
	public void display()
	{
		System.out.println(termList) ;
	}
}