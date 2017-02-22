/**
 * This program demonstrates an implementation of the generic List interface.
 * This program allows the user to add, remove, and change one or more
 * elements in a list.
 * 
 * Algorithm:
 * 	A) Create a MyDoubleLinkedList that implements the generic
 * 	   interface List from the Java API.
 * 		1) Create Instance variables head and tail of the type Node
 * 		   (to be implemented in step 2 ) and size of type int .
 * 		2) Create an static Inner class Node with generic parameter.
 * 			-Node contains instance variables: next and prev of the type Node
 * 			 and data of the type generic.
 * 			-Node constructor receives a data of the type generic.
 * 		3) Create an inner generic class DoubleListIterator that extends the 
 * 		   ListIterator interface from the Java API.
 * 			-DoubleListIterator contains instance variable nextItem and 
 * 			 lastItemReturned of the type Node and index of the type int.
 * 			-DoubleListIterator default constructor initializes the iterator 
 * 			 at the head of the list.
 * 			-DoubleListIterator that receives an index initializes the 
 * 			 iterator at the specified index.
 * 			-Implement the method add by adding the specified element 
 * 			 at the end of the list.
 * 			-Implement the method hasNext by checking the existence of 
 * 			 an element next to the current element.
 * 			-Implement the method next by accessing the next element in the list.
 * 			-Implement the method hasPrevious by checking the existence of an 
 * 			 element previews to the current element.
 * 			-Implement the method previous by accessing the previews element in the list.
 * 			-Implement the method nextIndex by returning the current index value.
 * 			-Implement the method previousIndex by returning a previews index value.
 * 			-Implement the method remove by removing the last element returned 
 * 			 by next or previous method.
 * 			-Implement the method set by replacing the last element returned by 
 * 			 next or previous method with the specified element.
 * 		4) Implement the method add
 * 			a) Adding a specified element at the end of this list.
 * 			b) Adding a specified element at a specified index to this list. 		
 * 		5) Implement the method addAll
 * 			a) Adding a list of a specified element at the end of this list.
 * 			b) Adding a specified list of element at a specified index in this list.
 * 		6) Implement the method clear by setting all instance variables of this 
 * 		   list to default values (null and 0).
 * 		7) Implement the method by comparing a specified element with each element 
 * 		   in this list until a match is found; return true if the specified element is found.
 * 		8) Implement the method containsAll by Comparing each element in the specified 
 * 		   list to each element in this list; returns true if there is a match of every 
 * 		   single object of the specified list in this list.
 * 		9) Implement the method get by accessing the element at the specified index.
 * 	   10) Implement the method indexOf by searching a specified element in the list
 * 		   and returning the index of the element if element is in the list; return -1 otherwise.
 * 	   11) Implement the method lastIndexOf by searching backward a specified element in the list
 * 		   and returning the index of the element if element is in the list; return -1 otherwise.
 * 	   12) Implement the method isEmpty by returning true if list size is == 0; false otherwise.
 * 	   13) Implement the method iterator by returning an DoubleListIterator object
 * 		   with position at the head of the list.
 * 	   14) Implement the method listIterator
 * 			a) returning an DoubleListIterator object with position at the head of the list.
 * 			b) returning an DoubleListIterator object with position at a specified index in the list.
 * 	   15) Implement the method remove by removing the first instance of the specified element
 * 		   and return true if the specified element is successfully removed.
 * 	   16) Implement the method removeAll by removing from this list all of its elements 
 * 		   that are contained in the specified collection and return true if the list 
 * 		   is changed after this method is called.
 * 	   17) Implement the method retainAll by retaining only the elements in this list that are 
 * 		   contained in the specified collection and return true if the list 
 * 		   is changed after this method is called.
 * 	   18) Implement the method set by Swapping the element at a specific index of this list
 * 		   and returning the element that is remove from the list.
 * 	   19) Implement the method size by returning the size of the list.
 * 	   20) Implement the method subList by  creating and returning a list of elements from
 * 		   the specified index.
 * 	   21) Implement the method toArray 
 * 		   a) create and return an array of the type Object with items of this list.
 * 		   b) use a specified array to add the elements of this list.
 * 	   22) Override the toString method by returning a string that contains all of the data in this list.
 * 	   23) Override the equals method by comparing one-to-one element of two lists
 * 		   and return true if every elements in both list are equivalent.
 * 	B) Create a JUnitTest class
 * 		-Create an array of the of Student that will be for testing.
 * 		-Test every single method of MyDoubleLinkedList and use 
 * 		 the array of Student as necessary.
 * 	C) Create a Tester class.
 * 		-Create a list1; add data; and display list1.
 * 		-Create a list2; add data; and display list2.
 * 		-Add list2 to list 1 and displaying list 1.
 * 		-Test list1 containsAll list2.
 * 		-Test method get, indexOf, isEmpty, and last index of.
 * 		-Test the remove method by object and by index.
 * 		-Test list1 retainAll of list 2.
 * 		-Test the method set.
 * 		-Test the listIterator.
 * 		-Test the method clear.
 * 		-Test the method isEmpty.
 */

package edu.miracosta.cs113.hw04;

import java.util.ListIterator ;
import edu.miracosta.cs113.hw03.concreteclasses.Student ;

public class MyDoubleLinkedListTest
{

	public static void main(String[] args)
	{
		// Creating a list1; adding data; and displaying list1
		MyDoubleLinkedList<Student> list1 = new MyDoubleLinkedList<>() ;
		list1.add(new Student("Angel", list1.size())) ;
		list1.add(new Student("Cesar", list1.size())) ;
		list1.add(new Student("Doroteo", list1.size())) ;
		list1.add(new Student("Arango", list1.size())) ;
		list1.add(new Student("Eudosio", list1.size())) ;
		list1.add(new Student("Pablo", list1.size())) ;
		list1.add(new Student("Luis", list1.size())) ;

		System.out.println("Displaying List 1------------") ;
		System.out.println(list1) ;
		
		// Creating a list2; adding data; and displaying list2
		MyDoubleLinkedList<Student> list2 = new MyDoubleLinkedList<>() ;
		list2.add(new Student("Student1", list2.size())) ;
		list2.add(new Student("Student2", list2.size())) ;
		list2.add(new Student("Student3", list2.size())) ;
		list2.add(new Student("Student4", list2.size())) ;
		list2.add(new Student("Student2", list2.size())) ;		

		System.out.println("Displaying List 2------------------") ;
		System.out.println(list2) ;
		
		
		// Adding list2 to list 1 and displaying list 1
		System.out.println("Displaying List 1 containing list 1 at index 4----------") ;		
		list1.addAll(4,list2) ;		
		System.out.println(list1) ;
		
		// Testing if list one contains list 2
		System.out.println("List one conatinsAll list 2: " + list1.containsAll(list2)) ;
		
		// Testing method get, indexOf, isEmpty, and last index of
		System.out.println("get index 2: " + list1.get(2)) ;
		System.out.println("IndexOf Cesar: " + list1.indexOf(new Student("Cesar", 0))) ;
		System.out.println("IsEmpty list1: " + list1.isEmpty()) ;
		System.out.println("lastIndexOf Student2: " + list1.lastIndexOf(new Student("Student2", 0))) ;
		
		// Testing the remove method by object and by index.
		System.out.println("Remove pablo: " + list1.remove(new Student("Pablo", 0))) ;
		System.out.println("Remove index 4: " + list1.remove(4)) ;
		
		System.out.println("\nDisplaying modified List 1----------") ;		
		System.out.println(list1) ;
		
		// Testing retainAll
		System.out.println("retainAll that matches list2: " + list1.retainAll(list2)) ;		
		System.out.println("Displaying retainAll result in List 1----------") ;		
		System.out.println(list1) ;
		
		//Testing the method set
		System.out.println("set Angel at index 2 instead of: " 
					+ list1.set(2,new Student("Angel", list1.size()))) ;
		
		// Testing the listIterator
		System.out.println("\nDisplaying list with a listIterator---------------------") ;
		ListIterator<Student> iter  = list1.listIterator() ;
		while (iter.hasNext())
		{
			System.out.println(iter.nextIndex() + " <> " + iter.next()) ;		
		}
		
		// Testing isEmpty
		list1.clear() ;
		System.out.println("\nClearing list: IsEmpty: " + list1.isEmpty()) ;
		
		
	}
}
