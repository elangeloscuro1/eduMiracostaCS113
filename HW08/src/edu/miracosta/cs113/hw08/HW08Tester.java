package edu.miracosta.cs113.hw08;

/**
 * Algorithm:
 * 	A) Create a simple Abstract class Heap .
 * 		-Create the methods offer, peek, poll, remove, is empty;
 * 		 and that provided a abstract method compare.
 * 	B) Create a concrete MinHeap of the abstract class Heap.
 * 		-Add an instance variable of the Comparator interface.
 * 		-Create a default constructor that initializes comparator to null.
 * 		-Override the method compare by using the instance of the Comparator interface
 * 		 or compareTo if the comparator is not used.
 * 	C) Create a concrete MaxHeap of the abstract class Heap.
 * 		-Add an instance variable of the Comparator interface.
 * 		-Create a default constructor that initializes comparator to null.
 * 		-Override the method compare by using the instance of the Comparator interface
 * 		 or compareTo if the comparator is not used.
 * 		 (this can be reverted by multiplying the result of comparator by -1.)
 * 	D)	Create a Class Student to be used to test this heap data structure.
 * 		-Create instance variables of firstName, lastName, studentID, yearAdmitted.
 * 		-Create a default constructor and a full constructor.
 * 		-Create getters and setters and override the to String and equals methods.
 * 	E) Create a class CompareStudentByID that implements the Comparator interface which
 * 		 takes a Student as its parameter.
 * 		-Override the compare method to prioritize the student according to their ID number.
 * 	F) Create a class CompareStudentByName that implements the Comparator interface which
 * 		 takes a Student as its parameter.
 * 		-Override the compare method to prioritize the student according to their first name.
 * 	G) Create a tester class HW08Tester
 * 		In main:
 * 		-Create an array of Student.
 * 		-Create four instance of the type Heap:
 * 		 minHeapByID = new MinHeap<Student>(new CompareStudentByID()) ;
 *		 maxHeapByID = new MaxHeap<Student>(new CompareStudentByID()) ;
 *		 minHeapByName = new MinHeap<Student>(new CompareStudentByName()) ;
 *		 maxHeapByName = new MaxHeap<Student>(new CompareStudentByName()) ;
 * 		-use a loop to add the students to each heap.
 * 		-Display all of the heaps separately.
 */

/**
 * HW08Tester tests Heap, MinHeap, MaxHeap, with instances 
 * of the comparator interface.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 */
public class HW08Tester
{
	/**
	 * tests Heap, MinHeap, MaxHeap, with instances 
	 * of the comparator interface.
	 * 
	 * @param args Command Lines
	 */
	public static void main(String[] args)
	{
		
		// An Array of student to be tested.
		Student[] students = 
				{ new Student("Angel",    "Tapia",      338, 2017)
				, new Student("Angel",    "Tapia",      240, 2000)
				, new Student("Pascual",  "Hernadez",   541, 2007)
				, new Student("Hector",   "Torres",     162, 2011)
				, new Student("Luis",     "Garcia",     133, 2001)
				, new Student("Pedro",    "Fernandez",  174, 2001)
				, new Student("Antonio",  "Perez",      445, 2009)} ;
		
		// Instances for min and max heaps that receives a comparable object to prioritize by specific students.
		Heap<Student> minHeapByID = new MinHeap<Student>(new CompareStudentByID()) ;
		Heap<Student> maxHeapByID = new MaxHeap<Student>(new CompareStudentByID()) ;
		Heap<Student> minHeapByName = new MinHeap<Student>(new CompareStudentByName()) ;
		Heap<Student> maxHeapByName = new MaxHeap<Student>(new CompareStudentByName()) ;
		
		// Adding students to heaps
		for (Student student : students)
		{
			minHeapByID.offer(student) ;
			maxHeapByID.offer(student) ;
			minHeapByName.offer(student) ;
			maxHeapByName.offer(student) ;
		}
		
		// Displaying results.
		System.out.printf(Student.FORMAT + "%n", "FIRST_NAME", "LAST_NAME", "ID_NUMBER", "YEAR_ADMITTED") ;
		System.out.println("Students by smallest ID number:") ;
		System.out.println(minHeapByID) ;
		System.out.println("Students by largest ID number: ") ;
		System.out.println(maxHeapByID) ;
		System.out.println("Students by Name A-Z:") ;
		System.out.println(minHeapByName) ;
		System.out.println("Students by name Z-A:") ;
		System.out.println(maxHeapByName) ;	
	}
}