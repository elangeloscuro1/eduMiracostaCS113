package edu.miracosta.cs113.hw08 ;

import java.util.Comparator ;

/**
 * CompareStudentByName extends Heap and implements Comparator that 
 * takes a Student as its parameter.
 * This class can be use to search for a student in a list by their name.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 */
public class CompareStudentByName implements Comparator<Student>
{
	/**
	 * Compares students by Name.
	 * 
	 * @param left: left  element to be compared.
     * @param right: right element to be compared.
	 * @return   1 if left element comes before the right element lexicographically.
	 * 			-1 if left element comes after the right element lexicographically.
	 * 			 0 if both elements are equals.
     */
	@Override
	public int compare(Student left, Student right)
	{
		return left.getFirstName().compareTo(right.getFirstName()) ;
	}
}