package edu.miracosta.cs113;
/**
 * WeightedGraph.java : Graph Class that acts as the superclass for
 * 						MatrixGraph. Allows for implementation of some
 * 						methods for the graph interface and leaves other
 * 						methods for the more specific subclasses (MatrixGraph).
 * 
 * @author Steven Siddall, Angel Tapia, Nathan Tran
 * @version 1.0
 * 
 */

public abstract class AbstractGraph implements Graph
{
	private boolean directed;	//True if Graph is directed, false otherwise
	private int numVertices;	//Number of Vertices present in Graph
	
    /**
     * Constructor, constructs a graph with the specified number of
     * 				vertices and the directed flag. If the directed flag
     * 				is true, this is a directed graph.
     *
     * @param numVertices - number of vertices in graph.
     * @param directed - true for directed graph, false for undirected
     */
	public AbstractGraph(int numVertices, boolean directed)
	{
		this.numVertices = numVertices;
		this.directed	= directed;
	}
    /**
     * Accessor, returns number of vertices
     *	
     * @return numVertices - number of vertices in graph.
     */
    public int getNumVertices()
    {
        return this.numVertices;
    }
    /**
     * Accessor, returns whether this graph is directed or not
     *	
     * @return directed - true if graph is directed, false otherwise.
     */
    public boolean isDirected()
    {
        return this.directed;
    }
}