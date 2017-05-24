package edu.miracosta.cs113;
/**
 * MatrixGraph.java : Graph Class for Travel Planner Program.
 * 						Implemented using adjacency matrix.
 * 
 * @author Steven Siddall, Angel Tapia, Nathan Tran
 * @version 1.0
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixGraph extends AbstractGraph
{
	protected double[][] matrix;	//Adjacency Matrix for graph
	private int numEdges;			//Represents number of edges in graph
	
	/**
	 * Constructor, creates a empty graph with a given number of vertices.
	 * 
	 * @param	numVertices - number of vertices in the graph
	 * @param	directed    - true if graph is directed, false otherwise
	 */
	public MatrixGraph(int numVertices, boolean directed)
	{
		super(numVertices, directed);
		this.matrix = new double[numVertices][numVertices];
		for(int i = 0; i < numVertices; i++)
		{
			for(int j = 0; j < numVertices;j++)
			{
				matrix[i][j] = Double.POSITIVE_INFINITY;
			}
		}
		this.numEdges = 0;	
	}
	
	/**
	 * Accessor, gets number of edges in graph
	 * @return	returns number of edges
	 */
	public int getNumEdges()
	{
		return this.numEdges;
	}
	
	/**
	 * Mutator, takes in edge object and adds weight to the correct position [source][dest] in matrix.
	 * 			Also makes sure it adds weight for [dest][source] location in matrix.
	 * 
	 * @param	edge - edge containing source vertex and location vertex index along with weight.
	 */
	@Override
	public void insert(Edge edge)
	{
		double newWeight = edge.getWeight();
		if(matrix[edge.getSource()][edge.getDest()] == Double.POSITIVE_INFINITY)
		{
			numEdges++;
		}
		matrix[edge.getSource()][edge.getDest()] = newWeight;
		matrix[edge.getDest()][edge.getSource()] = newWeight;
	}
	
	/**
	 * Mutator, Wrapper method for insert() that will take in source and dest
	 * 			index along with weight to create a new edge. Then the edge is
	 * 			inserted into graph.
	 * 
	 * @param	source - source vertex index
	 * @param	dest - dest vertex index
	 * @param	weight - weight of edge
	 */
	public void insert(int source, int dest, double weight)
	{
		Edge newEdge = new Edge(source, dest, weight);
		insert(newEdge);
	}
	
	/**
	 * Method that returns a boolean based on if the edge exists
	 * (weight != 0) between to given vertices
	 * 
	 * @param	source - source vertex index
	 * @param	dest - dest vertex index
	 * @return	true if edge exists (weight != 0) else false.
	 */
	@Override
	public boolean isEdge(int source, int dest)
	{
		//if weight does not exist
		if(matrix[source][dest] == Double.POSITIVE_INFINITY)
		{
			return false;
		}
		else	//Edge exists
		{
			return true;
		}
	}
	
	/**
	 * Method that will return an edge based off of given source and dest vertices.
	 * 
	 * @param	source - source vertex index
	 * @param	dest - dest vertex index
	 * @return	edge from source to dest vertex if it exists, otherwise return null;
	 */
	@Override
	public Edge getEdge(int source, int dest)
	{
		if(matrix[source][dest] == Double.POSITIVE_INFINITY)
		{
			return null;
		}
		else
		{
			Edge edge;
			double edgeWeight;
			edgeWeight = matrix[source][dest];
			edge = new Edge(source, dest, edgeWeight);
			return edge;
		}
	}
	
	/**
	 * Creates a MatrixIterator object and return an iterable object
	 * to the edges connected to a given vertex
	 * 
	 * @param	source - source vertex
	 * @return	returns an iterable<Double> to the vertices connected to source
	 */
	@Override
	public Iterable<Double> edgeIterator(int source)
	{
		return new MatrixIterator(source);
	}
	//MatrixIterator Inner Class START
	public class MatrixIterator implements Iterator<Double>, Iterable<Double>
	{
		private int x;
		private int y = 0;
		/**
		 * Constructor, initializes data field x with given value.
		 * @param	x - source vertex
		 */
		MatrixIterator(int x)
		{
			this.x = x;
		}
		/**
		 * Accessor, returns iterator<Double> object
		 */
		@Override
		public Iterator<Double> iterator()
		{
			return this;
		}
		/**
		 * Method that checks matrix to see if it has another value (!= 0).
		 * @return true if matrix has another value, false otherwise.
		 */
		@Override
		public boolean hasNext()
		{
			while(y < getNumVertices())
			{
				if(matrix[x][y] == 0)
				{
					return true;
				}
				y++;
			}
			return false;
		}
		/**
		 * Accessor, returns the next element in the iteration.
		 * @return	next element in the iteration.
		 */
		@Override
		public Double next()
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			return matrix[x][y++];
		}
		/**
		 * Method not utilized, thus is an unsupported operation.
		 */
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
	}
	//MatrixIterator Inner Class END
	
	/**
	 * toString method, outputs a string representation of the adjacency matrix
	 */
	public String toString()
	{
        for (int i = 0; i < getNumVertices(); i++) 
        {
            for (int j = 0; j < getNumVertices(); j++)
            {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
        return "";
	}
}