/*package Testers;
*//**
 * MatrixGraphTester.java : JUnitTester for MatrixGraph class
 * 
 * @author Steven Siddall, Angel Tapia, Nathan Tran
 * @version 1.0
 * 
 *//*
import org.junit.Test;
import org.junit.Assert;

import edu.miracosta.cs113.Edge;
import edu.miracosta.cs113.MatrixGraph;
import edu.miracosta.cs113.MatrixGraph.MatrixIterator;

public class MatrixGraphTester
{
	@Test
	public void tester()
	{
		MatrixGraph graph = new MatrixGraph(10, false);
		Iterable<Double> iter;
		Edge e1 = new Edge(3, 4, 100);
		
		//insert() && getEdge() && getWeight() method tests
		//Inserting edge from vertex to vertex, then use getEdge() to get edge.
		//then getWeight() is called on the edge to return weight value.
		graph.insert(2,5,200);
		Assert.assertTrue(200 == graph.getEdge(2,5).getWeight());
		//Inserting new value into using same vertices. Should change edge weight.
		graph.insert(2,5,150);
		Assert.assertTrue(150 == graph.getEdge(2,5).getWeight());
		//Checking if reversing source vertex and dest vertex yields same weight (Undirected)
		Assert.assertTrue(150 == graph.getEdge(5, 2).getWeight());	
		//insert() using raw data (Edge)
		graph.insert(e1);
		Assert.assertTrue(100 == graph.getEdge(3, 4).getWeight());
		
		//isEdge() method test
		Assert.assertFalse(true == graph.isEdge(0, 5));
		Assert.assertTrue(true == graph.isEdge(4, 3));
		
		//getNumEdges() method test
		Assert.assertTrue(2 == graph.getNumEdges());
		
		//getNumVertices() method test
		Assert.assertTrue(10 == graph.getNumVertices());
		
		//isDirected() method (From AbstractGraph class)
		Assert.assertTrue(false == graph.isDirected());
		
		//edgeIterator()
		iter = graph.edgeIterator(0);
		Assert.assertTrue(iter instanceof MatrixIterator);
	}
}*/