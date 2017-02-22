package edu.miracosta.cs113.hw04.junittests;

import org.junit.Test ;
import org.junit.Assert ;
import java.util.ListIterator ;
import edu.miracosta.cs113.hw03.concreteclasses.Student ;
import edu.miracosta.cs113.hw04.MyDoubleLinkedList; ;

/**
 * MyDoubleLinkedListJUnitTest which is used to test each method 
 * of the class MyDoubleLinkedList.
 */
/**
 * @author Angel Tapia
 */
public class MyDoubleLinkedListJUnitTest
{
	// student list, listIterator, and  array as helpers
	private MyDoubleLinkedList<Student> studentList = null ;
	//private ListIterator<Student> studentListIterator = null ;
	public final Student[] students = {new Student("s1", 1), new Student("s2", 2), new Student("s3", 3), 
				 					   new Student("s4", 4), new Student("s5", 5), new Student("s6", 6), 
				 					   new Student("s7", 7), new Student("s8", 8), new Student("s9", 9) } ;
	@Test
	public void testAdd()
	{
		studentList = new MyDoubleLinkedList<Student>() ;
		
		studentList.add(students[0]) ;		
		Assert.assertTrue(studentList.get(0).equals(students[0])) ;
		Assert.assertFalse(studentList.get(0).equals(students[1])) ;
	}
	
	@Test
	public void testAddFirst()
	{
		studentList = new MyDoubleLinkedList<Student>() ;		
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(0, students[2]) ;
		
		String result = students[2] + "\n" + students[0] + "\n" + students[1] + "\n";
		
		Assert.assertTrue(studentList.toString().equals(result)) ;
		Assert.assertFalse(studentList.toString().equals(result + "Error")) ;	
	}
	
	@Test
	public void testAddLast()
	{
		studentList = new MyDoubleLinkedList<Student>() ;		
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(studentList.size(), students[2]) ;
		
		String result = students[0] + "\n" + students[1] + "\n" + students[2] + "\n";
		
		Assert.assertTrue(studentList.toString().equals(result)) ;
		Assert.assertFalse(studentList.toString().equals(result + "Error")) ;	
	}
	
	@Test
	public void testAddIndex()
	{
		studentList = new MyDoubleLinkedList<Student>() ;		
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(1, students[2]) ;
		
		String result = students[0] + "\n" + students[2] + "\n" + students[1] + "\n";
		
		Assert.assertTrue(studentList.toString().equals(result)) ;
		Assert.assertFalse(studentList.toString().equals(result + "Error")) ;	
	}
	
	@Test
	public void testAddAll()
	{
		studentList = new MyDoubleLinkedList<Student>() ;		
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(students[2]) ;
		
		
		MyDoubleLinkedList<Student> secondStudentList = new MyDoubleLinkedList<Student>() ;
		Student[] tempArray = { new Student("ss1", 1), new Student("ss2", 2), new Student("ss3", 3) } ;
		secondStudentList.add(tempArray[0]) ;
		secondStudentList.add(tempArray[1]) ;
		secondStudentList.add(tempArray[2]) ;
		
		//  Add all at specified index
		studentList.addAll(2, secondStudentList) ;
		
		String result = students[0] + "\n" + students[1] + "\n" + tempArray[0] + "\n"
				      + tempArray[1]+ "\n" + tempArray[2] + "\n" + students[2] + "\n" ;
		
		Assert.assertTrue(studentList.toString().equals(result)) ;
		Assert.assertFalse(studentList.toString().equals(result + "Error")) ;
		
		
		// Add all at the end of the list.		
		studentList.addAll(secondStudentList) ;
		result = result + tempArray[0]+ "\n" + tempArray[1] + "\n" + tempArray[2] + "\n" ; ; 
		
		Assert.assertTrue(studentList.toString().equals(result)) ;
		Assert.assertFalse(studentList.toString().equals(result + "Error")) ;		
	}
	
	@Test
	public void testClear()
	{
		studentList = new MyDoubleLinkedList<Student>() ;		
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(students[2]) ;
		
		Assert.assertFalse(studentList.size() == 0) ;		
		studentList.clear() ;
		Assert.assertTrue(studentList.size() == 0) ;		
	}
	
	@Test
	public void testContains()
	{
		studentList = new MyDoubleLinkedList<Student>() ;
		Student[] tempArray = { new Student("ss1", 1), new Student("ss2", 2), new Student("ss3", 3) } ;
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(tempArray[0]) ;
		studentList.add(tempArray[1]) ;
		studentList.add(tempArray[2]) ;		
				
		// Contains a specific object
		Assert.assertFalse(studentList.contains(students[8])) ;
		Assert.assertTrue(studentList.contains(students[1])) ;
		
		// Contains a specific list		
		MyDoubleLinkedList<Student> secondStudentList = new MyDoubleLinkedList<Student>() ;
		secondStudentList.add(tempArray[0]) ;
		secondStudentList.add(tempArray[1]) ;
		secondStudentList.add(tempArray[2]) ;	
		Assert.assertTrue(studentList.containsAll(secondStudentList)) ;	
	}
	
	@Test
	public void testGet()
	{
		studentList = new MyDoubleLinkedList<Student>() ;		
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(students[2]) ;
		
		Assert.assertFalse(studentList.get(1).equals(students[0])) ;		
		Assert.assertTrue(studentList.get(1).equals(students[1])) ;
	}
		
	@Test
	public void testIndexOf()
	{
		studentList = new MyDoubleLinkedList<Student>() ;		
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(students[2]) ;
		studentList.add(students[0]) ;
		
		// IndexOf
		Assert.assertFalse(studentList.indexOf(students[0]) == 1) ;		
		Assert.assertTrue(studentList.indexOf(students[0]) == 0) ;
		
		// lastIndexOf
		Assert.assertFalse(studentList.lastIndexOf(students[0]) == 1) ;		
		Assert.assertTrue(studentList.lastIndexOf(students[0]) == 3) ;	
	}
	
	@Test
	public void testIsEmpty()
	{
		studentList = new MyDoubleLinkedList<Student>() ;	
		Assert.assertTrue(studentList.isEmpty()) ;
	}
	
	@Test
	public void testListIterator()
	{
		studentList = new MyDoubleLinkedList<Student>() ;		
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(students[2]) ;
		ListIterator<Student> listIterator =  studentList.listIterator() ;
		
		Assert.assertTrue(listIterator.next().equals(students[0])) ;
		
	}
	@Test
	public void testRemove()
	{
		studentList = new MyDoubleLinkedList<Student>() ;		
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(students[2]) ;
		
		// Remove object
		studentList.remove(students[0]) ;
		Assert.assertFalse(studentList.contains(students[0])) ;
		
		// Remove index
		studentList.remove(0) ;
		Assert.assertFalse(studentList.contains(students[1])) ;
	}
	
	@Test
	public void testRemoveAll()
	{
		studentList = new MyDoubleLinkedList<Student>() ;		
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(students[2]) ;
		
		
		MyDoubleLinkedList<Student> secondStudentList = new MyDoubleLinkedList<Student>() ;
		Student[] tempArray = { new Student("ss1", 1), new Student("ss2", 2), new Student("ss3", 3) } ;
		secondStudentList.add(tempArray[0]) ;
		secondStudentList.add(tempArray[1]) ;
		secondStudentList.add(tempArray[2]) ;
		studentList.addAll(secondStudentList) ;
		
		Assert.assertTrue(studentList.removeAll(secondStudentList)) ;	
	}
	
	@Test
	public void testRetainAll()
	{
		studentList = new MyDoubleLinkedList<Student>() ;		
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(students[2]) ;
		
		
		MyDoubleLinkedList<Student> secondStudentList = new MyDoubleLinkedList<Student>() ;
		Student[] tempArray = { new Student("ss1", 1), new Student("ss2", 2), new Student("ss3", 3) } ;
		secondStudentList.add(tempArray[0]) ;
		secondStudentList.add(tempArray[1]) ;
		secondStudentList.add(tempArray[2]) ;
		studentList.addAll(secondStudentList) ;
		
		Assert.assertTrue(studentList.retainAll(secondStudentList)) ;
	}	
	
	@Test
	public void testSet()
	{
		studentList = new MyDoubleLinkedList<Student>() ;		
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(students[2]) ;
		studentList.set(0, students[5]) ;
		
		String result = students[5] + "\n" + students[1] + "\n" + students[2] + "\n";		
		Assert.assertTrue(studentList.toString().equals(result)) ;	
	}
	
	@Test
	public void testSubList()
	{
		studentList = new MyDoubleLinkedList<Student>() ;
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(students[2]) ;
		Assert.assertTrue(studentList.subList(0, 1).size() == 1) ;	
	}
	
	@Test
	public void testToArray()
	{
		studentList = new MyDoubleLinkedList<Student>() ;
		studentList.add(students[0]) ;
		studentList.add(students[1]) ;
		studentList.add(students[2]) ;
		
		Object[] object = studentList.toArray() ;
		Assert.assertTrue(object.length == 3) ;
	}
}