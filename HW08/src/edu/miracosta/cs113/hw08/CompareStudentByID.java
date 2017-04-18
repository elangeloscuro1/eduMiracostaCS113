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
	 * @return -1 if left has less priority than right; 0 if left has equals 
     * 			priority than right, and 1 if left has greater priority than right.
	 */
	@Override
	public int compare(Student o1, Student o2)
	{
		if (o1.getStudentID() < o2.getStudentID())
		{
			return -1 ;
		}
		if (o1.getStudentID() > o2.getStudentID())
		{
			return 1 ;
		}
		return 0 ;
	}

}
