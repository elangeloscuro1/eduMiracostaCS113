package edu.miracosta.cs113.hw07;

import java.io.Serializable ;

/**
 * 
 * 
 * @author Angel Tapia <angelTapia07084759@gmail.com>
 * @version 1.0
 * @param <T>  Generic type parameter
 */
@SuppressWarnings("serial")
public class BinaryTree<T> implements Serializable
{
	/** root represents the root of the tree */
	protected Node<T> root = null ;

	/**
	 * Inner class Node stores data and links of BinaryTree
	 * @param <T>  Generic type parameter
	 */
	protected static class Node<T> implements Serializable
	{
		/** data represent tree, or subtree, or leaf. */
		protected T data ;
		/** left represents the left branch of the tree. */
		protected Node<T> left ;
		/** right represents the right branch of the tree. */
		protected Node<T> right ;

		/**
		 * 
		 * @param data
		 */
		public Node(T data)
		{
			this.data = data ;
			this.left = null ;
			this.right = null ;
		}
		
		/**
		 * 
		 */
		public String toString()
		{
			return this.data.toString() ;
		}
	}
	
	/**
	 * 
	 */
	public BinaryTree()
	{
		this.root = null ;
	}
	
	
	/**
	 * 
	 * @param root
	 */
	protected BinaryTree(Node<T> root)
	{
		this.root = root ;
	}
	
	
	/**
	 * 
	 * @param data
	 * @param leftTree
	 * @param rightTree
	 */
	public BinaryTree(T data, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		this.root = new Node<T>(data) ;
		
		if (leftTree != null)
		{
			this.root.left = leftTree.root ;
		}
		else
		{
			this.root.left = null ;
		}
		if (rightTree != null)
		{
			this.root.right = rightTree.root ;
		}
		else
		{
			this.root.right = null ;
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		
	}	
	
	
	
	

}
