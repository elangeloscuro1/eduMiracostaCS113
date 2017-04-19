package edu.miracosta.cs113.hw08;

import java.util.Comparator ;

/**
 * CompareStudentByID implements the Comparator interface which
 * takes a Student as its parameter.
 * This class can be used to prioritize students in a heap
 * for a student registration list.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 */
public class CompareStudentByID implements Comparator<Student>
{
	/**
	 * Compares students by ID.
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
		if (left.getStudentID() < right.getStudentID())
		{
			return -1 ;
		}
		else if (left.getStudentID() > right.getStudentID())
		{
			return 1 ;
		}
		else
		{
			return 0 ;
		}
	}

}
