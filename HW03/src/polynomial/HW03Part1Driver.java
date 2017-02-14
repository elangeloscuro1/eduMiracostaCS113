/**
 * This program simplifies algebraic terms of one variable.
 * 
 *  Algorithm:
 *  	1) Create a Term class that represent an algebraic term.
 *  		-Make this class implement the interface Comparable.
 *  		-Create instance variables for coefficient variable and exponent.
 *  		-Creates default copy and full constructor.
 *  		-Creates respectively setters and getters.
 *  		-Implement the method compareTo so it compares by exponents.
 *  		-Override toString and equals methods.
 *  	2) Create a TermSingleLinkedList class that creates a list of Term object.
 *  		-Create an inner class Node that stores the list of terms.
 *  		 (contains a Node and a Term variables only.)
 *  		-Create a variable Node for head and an int for size of the list
 *  		-Create an addSorted method that sorts by exponents from highest to lowest.
 *  		-Create an addList method that receives a an another TermSingleLinkedList
 *  		 and adds the entire list to the current list.
 *  		-Create an getSize method that return the size of the list.
 *  		-Create a method get that return a term of an specific index.
 *  		-Create a method removedFirst that remove the first index of the list
 *  		 and return the object that is removed.	
 *  		-Create a method displayList that displays every object in the list.
 *  		-Override the toString and equals method.
 *  	3) Create an Composition class Polynomial
 *  		-Create an instance of the class TermSingleLinkedList.
 *  		-Create the default constructor that initializes the list.
 *  		-Create a method addTerm that receives and add a object of the type term to the list.
 *  		-Create a method addList that adds another list to the current list.
 *  		-Create a method simplify that combines like terms.
 *  		-Create a method display that display the current list.
 *  	4) Create a driver class HW03Driver.
 *  		-Create two list of Polynomial.
 *  		-Add some terms to each list.
 *  		-Display list separately.
 *  		-Add the second list to the first list.
 *  		-Call the method simplify to simplify like terms.
 *  		-Display the final result.
 */
/**
 * @author Ange Tapia
 */

package polynomial ;

public class HW03Part1Driver
{
	public static void main(String[] args)
	{	
		Polynomial list1 = new Polynomial() ;
		list1.addTerm(new Term(3 , 4)) ;
		list1.addTerm(new Term(3 , 1)) ;
		list1.addTerm(new Term(2, 2)) ;
		list1.addTerm(new Term(3, 1)) ;
		list1.addTerm(new Term(7, "", 1));
		
		Polynomial list2 = new Polynomial() ;
		list2.addTerm(new Term(3 , 0)) ;	
		list2.addTerm(new Term(3 , 4)) ;
		list2.addTerm(new Term(2, 2)) ;
		list2.addTerm(new Term(3, 1)) ;			
		list2.addTerm(new Term(7, "", 1));
		
		System.out.println("-------List 1 ----------") ;
		list1.display() ;
		System.out.println("\n-------List 2 ----------") ;
		list2.display() ;
		
		System.out.println("\n---- Adding List 2 to list 1----------") ;
		list1.addList(list2) ;
		list1.display() ;		
		list1.simplify() ;
		
		System.out.println("\n----Simplifying List 1 ----------") ;
		list1.display() ;
	}
}