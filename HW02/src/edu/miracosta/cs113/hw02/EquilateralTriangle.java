/**
 * This Class extends the abstract class Shape.
 * Since the class Shape is an Abstract class,
 * The methods computeArea, computePerimeter,
 * and readShapeData need to be implemented.
 * 
 * 
 * @author Angel Tapia
 *
 */

package edu.miracosta.cs113.hw02 ;
import java.util.Scanner ;

import data_structures.chapter_1.Shape ;

public class EquilateralTriangle extends Shape
{
	/**	Default size for Square
	 */
	public static final double DEFAULT_SIZE = 10 ;
	
	// Only one instance variable for size
	private double size ;
	
	/**
	 * Default constructor create a shape with default name.
	 */
	public EquilateralTriangle()
	{
		super("EQUILATERAL TRIANGLE") ;
		this.size = DEFAULT_SIZE ;
	}

	/**
	 * Full constructor receives a name for the shape
	 * @param shapeName represent the name for the shape
	 */
	public EquilateralTriangle(String shapeName)
	{
		super(shapeName) ;
		this.size = DEFAULT_SIZE ;
	}

	/**
	 * Accessor for size	
	 * @return size of Equilateral Triangle
	 */
	public double getSize()
	{
		return size ;
	}

	/**
	 * Mutator for size.
	 * @param size represents the size of the  Equilateral Triangle
	 */
	public void setSize(double size)
	{
		this.size = size ;
	}
	
	@Override
	public double computeArea()
	{
		return (size * size) / 2 ;
	}

	@Override
	public double computePerimeter()
	{
		return size * 3 ;
	}

	@Override
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in) ;
		System.out.println("Enter the size of the equilateral triangle") ;
		size = in.nextDouble() ;
		in.close() ;		
	}
	
	/**
	 * Create a string representation of the rectangle.
	 * 
	 * @return A string representation of the rectangle
	 */
	@Override
	public String toString()
	{
		return super.toString() + ": width is " + size + ", height is " + size ;
	}
	/**
	 * Compares the values of two objects of the class EquilateralTriangle
	 * @param obj represent another object of the class EquilateralTriangle
	 * @return true if the size are equals
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null && getClass() != obj.getClass())
		{
			return false ;
		}
		
		EquilateralTriangle other = (EquilateralTriangle) obj ;
		return size == other.size ;
	}
}
