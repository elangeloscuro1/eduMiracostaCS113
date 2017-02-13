package polynomial;

public class HW03Driver
{

	public static void main(String[] args)
	{
		Polynomial list = new Polynomial() ;
		list.addTerm(new Term(3 , 4)) ;
		list.addTerm(new Term(3 , 1)) ;
		list.addTerm(new Term(2, 2)) ;
		list.addTerm(new Term(3, 1)) ;
		list.addTerm(new Term(7, "", 1));
		
		Polynomial list2 = new Polynomial() ;
		list2.addTerm(new Term(3 , 0)) ;	
		list2.addTerm(new Term(3 , 4)) ;
		list2.addTerm(new Term(2, 2)) ;
		list2.addTerm(new Term(3, 1)) ;
			
		list2.addTerm(new Term(7, "", 1));
		
		list.display() ;
		list2.display() ;
		list.addList(list2) ;
		list.display() ;
		
		list.simplify() ;
		
		list.display() ;

	}

}
