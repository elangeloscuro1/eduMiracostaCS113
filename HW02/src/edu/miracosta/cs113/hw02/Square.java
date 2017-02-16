/**
 * This Class extends the abstract class Shape.
 * Since the class Shape is an Abstract class,
 * The methods computeArea, computePerimeter,
 * and readShapeData need to be implemented.
 */
/**
 *  @author Angel Tapia
 */


package edu.miracosta.cs113.hw02;
import java.util.Scanner ;

import data_structures.chapter_1.Shape ;

public class Square extends Shape
{
	/**	Default size for Square
	 */
	public static final double DEFAULT_SIZE = 10 ;
	
	// Only one instance variable for size
	private double size ;
	
	/**
	 * Default constructor create a shape with default name.
	 */
	public Square()
	{
		super("SQUARE") ;
		this.size = DEFAULT_SIZE ;
	}
	
	/**
	 * Full constructor receives a name for the shape
	 * @param shapeName represent the name for the shape
	 */
	public Square(String shapeName)
	{
		super(shapeName) ;
		this.size = DEFAULT_SIZE ;
	}
	
	/**
	 * Accessor for size	
	 * @return size of square
	 */
	public double getSize()
	{
		return size ;
	}

	/**
	 * Mutator for size.
	 * @param size represents the size of the square
	 */
	public void setSize(double size)
	{
		this.size = size ;
	}
	
	/**
	 * Calculates the area of the square.
	 * 
	 * @return the area of the square.
	 */
	@Override
	public double computeArea()
	{
		return (size * size) ;
	}

	/**
	 * Calculates the perimeter of the square.
	 * 
	 * @return the perimeter of the square.
	 */
	@Override
	public double computePerimeter()
	{
		return (size * 4) ;
	}

	/**
	 * Asks the user to enter the size of the square.
	 */
	@Override
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in) ;
		System.out.println("Enter the size of the square") ;
		size = in.nextDouble() ;
		in.close() ;
	}
	
	/**
	 * Create a string representation of the square.
	 * 
	 * @return A string representation of the square
	 */
	@Override
	public String toString()
	{
		return super.toString() + ": width is " + size + ", height is " + size ;
	}
	/**
	 * Compares the values of two objects of the class Square
	 * @param obj represent another object of the class Square
	 * @return true if the size are equals
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null && getClass() != obj.getClass())
		{
			return false ;
		}
		
		Square other = (Square) obj ;
		return size == other.size ;
	}

}
