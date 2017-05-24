/*package Testers;
*//**
 * TravelPlannerTester.java : JUnitTester for TravelPlanner class
 * 
 * @author Steven Siddall, Angel Tapia, Nathan Tran
 * @version 1.0
 * 
 *//*
import edu.miracosta.cs113.TravelPlanner;
import org.junit.Test;
import org.junit.Assert;

public class TravelPlannerTester
{
	@Test
	public void tester()
	{
		TravelPlanner tp = new TravelPlanner(6);
		
		//addAirport() method
		tp.addAirport("A");
		tp.addAirport("B");
		tp.addAirport("C");
		tp.addAirport("D");
		tp.addAirport("E");
		tp.addAirport("F");
		
		//getNumAirports() method
		Assert.assertTrue(6 == tp.getNumAirports());
		
		//getAirport() method
		Assert.assertTrue("A" == tp.getAirport(0));
		Assert.assertTrue("B" == tp.getAirport(1));
		
		//addFlight() and getFlightCost() method
		tp.addFlight("A", "B", 50);
		Assert.assertTrue(50.0 == tp.getFlightCost("B", "A"));
		
		//removeFlight() method
		tp.removeFlight("A", "B");
		Assert.assertFalse(50.0 == tp.getFlightCost("A", "B"));
		
		//getCheapestPath() method (which incorporates Dijsktra's
		//							algorithm)
		String[] expected = {"A", "F", "B"};
		String[] actual;
		tp.addFlight("A", "D", 5);
		tp.addFlight("A", "E", 15);
		tp.addFlight("A", "F", 10);
		tp.addFlight("D", "C", 10);
		tp.addFlight("D", "E", 20);
		tp.addFlight("F", "B", 5);
		tp.addFlight("C", "E", 5);
		tp.addFlight("B", "C", 20);
		actual = tp.getCheapestPath("A", "B");
		for(int i = 0; i < expected.length; i++)
		{
			Assert.assertTrue(expected[i] == actual[i]);
		}
		//Other getCheapestPath() method that uses ints
		actual = tp.getCheapestPath(0, 1);
		for(int i = 0; i < expected.length; i++)
		{
			Assert.assertTrue(expected[i] == actual[i]);
		}
	}
}*/