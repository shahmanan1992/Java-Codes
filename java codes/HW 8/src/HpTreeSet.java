/* 
 * Requirement1.java 
 * 
 * Version: 
 *     1 
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;
/**
 * This program generates binary tree
 * 
 * @author      Manan Shah     605004112	
 * @author      Vinay Kumbhar  613009443
 */
/* Class BSTNode */
class BSTNode
{
	BSTNode left, right;
	String data;

	/* Constructor */
	public BSTNode()
	{
		left = null;
		right = null;
		data = "";
	}
	/* Constructor */
	public BSTNode(String n)
	{
		left = null;
		right = null;
		data = n;
	}
	/* Function to get left node */
	public BSTNode getLeft()
	{
		return left;
	}
	/* Function to get right node */
	public BSTNode getRight()
	{
		return right;
	}
	/* Function to get data from node */
	public String getData()
	{
		return data;
	}   

}
class InOrder implements Iterator {  
    Stack<BSTNode> stack = new Stack<BSTNode>();  
    
    /** Push node cur and all of its left children into stack */  
    private void pushLeftChildren(BSTNode cur) {  
      while (cur != null) {  
        stack.push(cur);  
        cur = cur.left;  
      }  
    }  
    
    /** Constructor */  
    public InOrder(BSTNode root) {  
      pushLeftChildren(root);  
    }  
     
    @Override  
    public boolean hasNext() {  
      return !stack.isEmpty();  
    }  
    
    @Override  
    public String next() {  
      if (!hasNext()) {  
        throw new NoSuchElementException("All nodes have been visited!");  
      }  
    
      BSTNode res = stack.pop();  
      pushLeftChildren(res.right);  
    
     // System.out.println(res.data);
      return res.data;  
    }  
  }  
class HpTreeSet extends TreeSet
{
	private BSTNode root;
	String data,val;
	//BSTNode next;
	/* Constructor */
	public HpTreeSet()
	{
		root = null;
	}
	/* Function to check if tree is empty */
	public boolean isEmpty()
	{
		return root == null;
	}
	/* Functions to add data */
	public boolean add(Object obj)
	{

		if(obj instanceof String)
		{
			data=(String)obj;
		}

		root = add(root, data);
		if(root!=null)
			return true;
		else
			return false;
	}
	/* Function to add data recursively */
	private BSTNode add(BSTNode node, String data)
	{
		if (node == null)
			node = new BSTNode(data);
		else
		{
			if (data.compareTo(node.getData())<0)
				node.left = add(node.left, data);
			else
				node.right = add(node.right, data);
		}
		return node;
	}
	/* Functions to clear data */
	public void clear()
	{
		if(root!=null)
		{
			root=null;
		}
	} 



	/* Functions to count number of nodes */
	public int size()
	{
		return size(root);
	}
	/* Function to calculate size recursively */
	private int size(BSTNode r)
	{
		if (r == null)
			return 0;
		else
		{
			int l = 1;
			l += size(r.getLeft());
			l += size(r.getRight());
			return l;
		}
	}
	/* Functions to search for an element */
	public boolean contains(Object obj)
	{
		if(obj instanceof String)
		{
			val=(String)obj;
		}
		return containsString(root, val);
	}
	/* Function to search for an element recursively */
	private boolean containsString(BSTNode r, String val)
	{
		boolean found = false;
		while ((r != null) && !found)
		{
			String rval = r.getData();
			if (val.compareTo(rval)<0)
				r = r.getLeft();
			else if (val.compareTo(rval)>0)
				r = r.getRight();
			else
			{
				found = true;
				break;
			}
			found = containsString(r, val);
		}
		return found;
	}

	public Iterator iterator() {
		return new InOrder(root);
	}
	
}
