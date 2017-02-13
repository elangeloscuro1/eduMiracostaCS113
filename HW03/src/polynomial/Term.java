package polynomial ;

public class Term implements Comparable
{
	

	// The class Term:            The class Term:
	public static final String DEFAULT_VARIABLE = "x" ;		
	
	private int exponent ;
	private int coefficient ;
	private String variable ;
	
	public Term()
	{
		this.exponent = 0 ;
		this.coefficient = 0 ;
		this.variable = DEFAULT_VARIABLE ;
	}
	public Term(int coefficient, int exponent)
	{
		this.coefficient = exponent != 0 ? coefficient : 1;	
		this.exponent = exponent != 0 ? exponent : 1 ;			
		this.variable = exponent != 0 ? DEFAULT_VARIABLE : "" ;
	}

	public Term(int coefficient, String variable, int exponent)
	{
		this.variable = variable.trim() ;
		if (isConstant())
		{
			this.coefficient = (int) Math.pow((double) coefficient, (double) exponent) ;
			this.exponent = 1 ;
		}
		else
		{
			this.exponent = exponent ;
			this.coefficient = coefficient ;
		}
	}
	public Term(Term other)
	{
		this.coefficient = other.getCoefficient() ;
		this.exponent = other.getExponent() ;
		this.variable = other.getVariable() ;
	}
	
	public void setExponent(int exponent)
	{
		this.exponent = exponent ;
	}
	public int getExponent()
	{
		return exponent ;
	}
	public void setCoefficient(int coefficient)
	{
		this.coefficient = coefficient ;
	}
	public int getCoefficient()
	{
		return coefficient ;
	}
	public void setVariable(String variable)
	{
		this.variable = variable ;
	}	
	public String getVariable()
	{
		return variable ;
	}
	
	public boolean isConstant()
	{
		return variable.trim().length() == 0 ;
	}
	
	public String getTerm()
	{
		String temp = "" ;
				
		switch (exponent)
		{
		case 0:
			temp = Integer.toString(coefficient) + 1 ;
			//variable = "" ;
			break ;
		case 1:
			temp = coefficient + variable ;
			break ;	
		default:
			temp = coefficient + variable + "^" + exponent ;
			break ;
		}
		//System.out.println("==>>  [ " + temp + " ]") ;
		if (!temp.equals("0") && variable.length() != 0)
		{
			switch (coefficient)
			{
			case 0:
				temp = "0" ;
				break ;
			case 1:
				temp = temp.substring(temp.indexOf("1") + 1) ;
				break ;
			case -1:
				temp = temp.substring(temp.indexOf("1") + 1) ;
				break ;
			default:
				break ;
			}
		}
		//System.out.println("==>>  [ " + temp + " ]") ;
		return temp  ;
	}
	
	@Override
	public int compareTo(Object object)
	{
		Term other = (Term) object ;

		if (this.exponent > other.getExponent())
		{
			return 1 ;
		}
		else if (this.exponent == other.getExponent())
		{
			return 0 ;
		}
		return -1 ;
	}
	@Override
	public String toString()
	{
		return coefficient + variable + "^" + exponent ;
	}
	@Override
	public boolean equals(Object object)
	{
		if (object == null || getClass() != object.getClass())
		{
			return false ;
		}
		
		Term other = (Term) object ;
		return exponent == other.getExponent() 
			&& coefficient == other.getCoefficient()  ;
	}

}
