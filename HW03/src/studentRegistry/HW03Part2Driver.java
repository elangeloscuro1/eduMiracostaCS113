/**
 * This program simulates a student registry,
 * and is in charged to assign a number of registration
 * to a student and to place a student by number of
 * registration or by giving priority, placing a student
 * in the bagging of the line.
 * 
 * Algorithm:
 * 	A) Create a class Student
 * 			-Add instance variable for name and numberInLine
 * 			-Add a default, full, and copy constructor.
 * 			-Create respectively setters and getter.
 * 			-Override the toString and equals method.
 * 	B) Create a StudentSingleLinkedList class
 * 			-Create a Node inner class that has a Node variable
 * 			 that creates a link to another node and a variable of
 * 			 the class Student to save data as a list.
 * 			 Create a constructor that receives a object of the
 * 			 type student and a object of type node.
 * 			-In the outer class, create a variable of the type Node
 * 			 that represents the head of the list and a variable size of
 * 			 the type int that counts the total of object in the list.
 * 			-Create a method addToStrat that add a student to the 
 * 			 beginning of the list and sets a new number in line to
 * 			 the rest of the list (if there are more object in the list.)
 * 			-Create a method addToEnd that adds a student to the end of the list.
 * 			-Add a method removeFirst that remove the first in the list
 * 			 and returns the student that is removed.
 * 			-Add a method remove that takes in the name of a student
 * 			 and return the student or null if the student is not fund.
 * 			-Create a method getSize that return the number of student in the list.
 * 			-Override toString so it returns the list of student.
 * 			-Override equals that compares two list of students and return false
 * 			 if one of the student are not the same; true otherwise.
 * 	C) Create the Driver class.
 * 			-Create an object of the class StudentSingleLinkedList.
 * 			-Add at least 10 students.
 * 			-Prints the students to the screen.
 * 			-Call the method removeFirst.
 * 			-Display the student list.
 * 			-Call the method remove and use a name to remove a student by name.
 * 			-Print the list.
 */
/**
 * @author Angel Tapia
 */

package studentRegistry ;

public class HW03Part2Driver
{

	public static void main(String[] args)
	{
		// Creating an empty list.
		StudentSingleLinkedList studentList ;
		studentList = new StudentSingleLinkedList() ;
		
		// Adding students to the list.
		studentList.addToStart("Abidoye") ;
		studentList.addToStart("Olanduni") ;
		studentList.addToStart("Boado") ;
		studentList.addToStart("Annabelle") ;
		studentList.addToStart("Buttler") ;
		studentList.addToStart("Jamens") ;
		studentList.addToStart("Chee") ;		
		studentList.addToEnd("Yong-Han") ;		
		studentList.addToEnd("Debaggis") ;
		studentList.addToEnd("Tarra") ;					
		
		// Printing the list of student to the screen.
		System.out.println(studentList) ;
		
		// Testing the method remove fist and printing results.
		System.out.println("\nRemoving first in line: " + studentList.removeFirst()) ;		
		System.out.println(studentList) ;
		
		// Testing the method remove and printing result.
		System.out.println("\nRemoving by name: " + studentList.remove("Tarra")) ;		
		System.out.println(studentList) ;	
	}
}