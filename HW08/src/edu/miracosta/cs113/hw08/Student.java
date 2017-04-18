package edu.miracosta.cs113.hw08;

/**
 * Student is a concrete class that represent a student.
 * This class can store first name, last name, student ID,
 * and the year the student is admitted.
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 */
public class Student
{
	/** The format used for the toString method to represent the student info */
	public static final String FORMAT = "%-15s%-15s%-15s%-15s" ;
	
	/** The first name of the student */
	private String firstName ;
	/** The last name of the student */
	private String lastName ;
	/** The Student ID number */
	private int studentID ;
	/** The year the student is admitted */
	private int yearAdmitted ;
	
	/**
	 * Default constructor student initializes 
	 * instance variables to default values.
	 */
	public Student()
	{
		this.firstName = "UNAVAILABLE" ;
		this.lastName  = "UNAVAILABLE" ;
		this.studentID = -1 ;
		this.yearAdmitted = -1;
	}
	
	/**
	 * Full constructor: receives values for all of the instance variable.
	 * 
	 * @param firstName:    The first name of the student
	 * @param lastName:     The last name of the student
	 * @param studentID:    The Student ID number
	 * @param yearAdmitted: The year the student is admitted
	 */
	public Student(String firstName, String lastName, int studentID, int yearAdmitted)
	{
		this.firstName = firstName ;
		this.lastName = lastName ;
		this.studentID = studentID ;
		this.yearAdmitted = yearAdmitted ;
	}
	
	/**
	 * Getter for firstName.
	 * 
	 * @return the value of firstName
	 */
	public String getFirstName()
	{
		return firstName ;
	}
	
	/**
	 * Setter for firstName.
	 * 
	 * @param firstName: the first name of the student.
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName ;
	}
	
	/**
	 * Getter for lastName.
	 * 
	 * @return the value of lastName
	 */
	public String getLastName()
	{
		return lastName ;
	}
	/**
	 * Setter for lastName.
	 * 
	 * @param lastName: the last name of the student.
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName ;
	}
	
	/**
	 * Getter for studentID.
	 * 
	 * @return the value of studentID.
	 */
	public int getStudentID()
	{
		return studentID ;
	}
	
	/**
	 * Setter for studentID.
	 * 
	 * @param studentID: the student ID number.
	 */
	public void setStudentID(int studentID)
	{
		this.studentID = studentID ;
	}
	
	/**
	 * Getter for yearAdmitted.
	 * 
	 * @return the value of yearAdmited.
	 */
	public int getYearAdmitted()
	{
		return yearAdmitted ;
	}
	
	/**
	 * Setter for yearAdmitted.
	 * 
	 * @param yearAdmitted: the year the student is admitted.
	 */
	public void setYearAdmitted(int yearAdmitted)
	{
		this.yearAdmitted = yearAdmitted ;
	}
	
	/**
	 * Builds a string with all of the information of the student.
	 * 
	 * @return a string with all of the information of the student.
	 */
	@Override
	public String toString()
	{
		return String.format(FORMAT, this.firstName
				, this.lastName, this.studentID, this.yearAdmitted) ;
	}
	
	/**
	 * Compares all of the information of this student with another student.
	 * 
	 * @return true if all of the information are equivalent; false otherwise.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || obj.getClass() != getClass())
		{
			return false ;
		}		
		Student other = (Student) obj ;
		return this.firstName.equals(other.firstName)
				&& this.lastName.equals(other.lastName)
				&& this.studentID == other.studentID 
				&& this.yearAdmitted == other.yearAdmitted ;
	}	
}