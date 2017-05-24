package edu.miracosta.cs113 ;

import java.util.ArrayList ;
import java.util.HashSet ;
import java.util.Stack;
/**
 * TravelPlanner represent a flight planner that helps the user to
 * find the cheapest cost to the desire destination.
 * 
 * @author Steven Siddall, Angel Tapia, Nathan Tran
 * @version 1.0
 */
public class TravelPlanner
{
	/** Represents this graph to be directed/undirected  */
	public static final boolean IS_DIRECTED = false ;
	/** Represents the adjacency matrix for the airports  */
	private MatrixGraph graph ;
	/** Represents the list of airports in the planner */
	private ArrayList<String> locations ;
	
	
	/**
	 * Constructs a TravelPlanner object with a specified number of airports.
	 * 
	 * @param numAirpots: Number of airports to be used.
	 */
	public TravelPlanner(int numAirpots)
	{
		this.locations = new ArrayList<>(numAirpots) ;
		this.graph = new MatrixGraph(numAirpots, IS_DIRECTED) ;
	}
	
	/**
	 * Adds a new available flight to the planner.
	 * 
	 * @param src:  The airport to take a flight.
	 * @param dest: The destination of the flight.
	 * @param cost: The cost of the flight.
	 * @return true if the flight is successfully added.
	 */
	public boolean addFlight(String src, String dest, double cost)
	{
		int srcIndex = this.locations.indexOf(src) ;
		int destIndex = this.locations.indexOf(dest) ;
				
		if (srcIndex == -1)
		{
			srcIndex = this.locations.lastIndexOf(src) ;
		}
		if (destIndex == -1)
		{
			destIndex = this.locations.lastIndexOf(dest) ;
		}
		this.graph.insert(srcIndex, destIndex, cost) ;
		return true ;		
	}
	
	/**
	 * Removes a flight from the planner.
	 * 
	 * @param src:  The airport to take a flight.
	 * @param dest: The destination of the flight.
	 * @return true if the is successfully removed, false otherwise.
	 */
	public boolean removeFlight(String src, String dest)
	{
		int srcIndex = this.locations.indexOf(src) ;
		int destIndex = this.locations.indexOf(dest) ;
		
		if (srcIndex == -1 || destIndex == -1)
		{
			return false ;
		}
		this.graph.insert(srcIndex, destIndex, Double.POSITIVE_INFINITY) ;
		return true ;
	}
	
	/**
	 * Add a specified airport to the planner.
	 * 
	 * @param airport: The airport to be added.
	 * @return true if the airport is successfully added,
	 * 			false if the airport already exists.
	 */
	public boolean addAirport(String airport)
	{
		if (!this.locations.contains(airport))
		{
			this.locations.add(airport) ;
			return true ;
		}
		return false ;		
	}
	
	/**
	 * Access the number of airport in the planner.
	 * 
	 * @return the total number of airport in the planner.
	 */
	public int getNumAirports()
	{
		return this.locations.size();
	}
	
	/**
	 * Retrieves an airport from the specified index.
	 * 
	 * @param index: The index of the airport to retrieve.
	 * @return The airport from the specified index.
	 */
	public String getAirport(int index)
	{
		return this.locations.get(index);
	}
	
	/**
	 * Accesses the cost of a flight with the specified source and destination.
	 * 
	 * @param src: The source of the flight.
	 * @param dest The destination of the flight.
	 * @return the cost of the flight; 0 if there is not flight
	 * 			available for the specified source or destination.
	 */

	public double getFlightCost(String src, String dest)
	{
		int srcIndex = this.locations.indexOf(src) ;
		int destIndex = this.locations.indexOf(dest) ;	
		
		if (srcIndex == -1 || destIndex == -1)
		{
			return 0 ;
		}
		if (this.graph.getEdge(srcIndex, destIndex) == null)
		{
			return 0 ;
		}	
		return this.graph.getEdge(srcIndex, destIndex).getWeight() ;
	}
	
	/**
	 * Finds the cheapest path to reach the desire destination.
	 * 
	 * @param from: The airport to take the flight.
	 * @param to:   The destination of the flight.
	 * @return: an array of airport to be taken for the cheapest path.
	 */
	public String[] getCheapestPath(String from, String to)
	{
		int src = this.locations.indexOf(from) ;
		int dest = this.locations.indexOf(to) ;
		return getCheapestPath(src, dest) ;
	}
	
	/**
	 * Finds the cheapest path to reach the desire destination.
	 * 
	 * @param from: The index of  airport to take the flight.
	 * @param to:   The index of destination of the flight.
	 * @return: an array of airport to be taken for the cheapest path.
	 */
	public String[] getCheapestPath(int from, int to)
	{
		int[] pred = new int[this.graph.getNumVertices()] ;
		double[] cost = new double[this.graph.getNumVertices()] ;
		return dijkstrasAlgorithm(this.graph , from, to,  pred, cost);
		
	}
	
	/**
	 * Finds the lower cost from one specified airport
	 * to the rest of the available airports in this planner.
	 * 
	 * @param graph: The graph that contains all the available flights.  
	 * @param start: The Current destination.
	 * @param dest:  The shortest path destination list,
	 * @param pred:  the predecessor destination.
	 * @param cost: The cost of the current flight.
	 * @return an array of airport to be taken for the cheapest path.
	 */
	public String[] dijkstrasAlgorithm(MatrixGraph graph, int start, int dest, int[] pred, double[] cost)
	{
		boolean isFound = false ;
		int numV = graph.getNumVertices() ;
		HashSet<Integer> vMinusS = new HashSet<>(numV) ;
		
		// Adding values to set and initializing pred and cost.
		for (int i = 0; i < numV; i++)
		{
			if (i != start)
			{
				vMinusS.add(i) ;	
				pred[i] = start ;
				
				if (graph.isEdge(start, i))
				{
					cost[i] = graph.getEdge(start, i).getWeight() ;
				}
				else
				{
					cost[i] = Double.POSITIVE_INFINITY ;
				}
			}
		}
		
		// main loop: Updates values to the shortest distance
		while (vMinusS.size() != 0)
		{
			double minDist = Double.POSITIVE_INFINITY ;
			int u = -1 ;
			for (int v : vMinusS)
			{
				if (cost[v] < minDist)
				{
					isFound = true ;
					minDist = cost[v] ;
					u = v ;					
				}				
			}
			
			if (vMinusS.remove(u))
			{
				for (int v : vMinusS)
				{
					if (graph.isEdge(u, v))
					{
						double weight = graph.getEdge(u, v).getWeight() ;
						if (cost[u] + weight < cost[v])
						{
							cost[v] = cost[u] + weight ;
							pred[v] = u ;
						}
					}
				}
			}
			else
			{
				vMinusS.clear() ;
			}
		}
		
		// Creating an array of stopovers.
		Stack<Integer> pathStack = new Stack<Integer>();
		int i = dest;
		while(i != start)
		{
			pathStack.push(i);
			i = pred[i];
		}
		pathStack.push(start);
		
		String[] pathString = new String[pathStack.size()];
		i = 0;
		while(!pathStack.isEmpty())
		{
			pathString[i] = getAirport(pathStack.pop());
			i++;
		}
		
		if(isFound)
		{
			return pathString;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Calls the toString of the current data structure used 
	 * to stores the cost of the flights.
	 * 
	 * @return a string representation of the data structure used 
	 * 			to stores the cost of the flights.
	 */
	@Override
	public String toString()
	{
		return this.graph.toString() ;
	}
}