package edu.miracosta.cs113.hw08;

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
	 * @return -1 if left has less priority than right; 0 if left has equals 
     * 			priority than right, and 1 if left has greater priority than right.
	 */
	@Override
	public int compare(Student o1, Student o2)
	{
		if (o1.getFirstName().compareTo(o2.getFirstName()) < 0)
		{
			return -1 ;
		}
		if (o1.getFirstName().compareTo(o2.getFirstName()) > 0)
		{
			return 1 ;
		}
		return 0 ;
	}

}
