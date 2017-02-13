package polynomial;

import javax.swing.plaf.synth.SynthStyle ;

public class Polynomial
{
	private TermLinkedList termList ;
	
	public Polynomial()
	{
		termList = new TermLinkedList() ;
	}
	
	public void addTerm(Term term)
	{
		termList.addSorted(term) ;
	}
	
	public void addList(Polynomial list)
	{	
		termList.addList(list.termList);		
	}
	
	public void simplify()
	{
		TermLinkedList temp = new TermLinkedList() ;
		int constant = 0 ;
		
		while (termList.getSize() > 0)
		{
			Term current = termList.removeFirst() ;			
			if (current.isConstant())
			{
				constant += current.getCoefficient() ;				
			}
			else
			{
				temp.addSorted(current) ;
			}			
		}
		termList = temp ;
		temp = new TermLinkedList() ;
		while (termList.get(0) != null)
		{
			Term current = termList.removeFirst() ;
			Term next = termList.get(0) ;
			if (next != null && current.getExponent() == next.getExponent())
			{
				int coefficient = current.getCoefficient() + next.getCoefficient() ;
				temp.addSorted(new Term(coefficient , current.getExponent())) ;	
				termList.removeFirst() ;			
			}
			else
			{
				temp.addSorted(current) ;
			}
		}		
		if (constant != 0)
		{
			temp.addSorted(new Term(constant, "", 1)) ;
		}
		termList = temp ;
	}
		
	
	public void display()
	{
		termList.displayList() ;
	}	
}
