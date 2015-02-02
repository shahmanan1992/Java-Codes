/*
 *  Java Program to Implement Binary Search Tree
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.TreeSet;

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
class TreeInOrder
{
	BSTNode treeNode;
	boolean visited;

	public TreeInOrder(BSTNode treeNode, Boolean v) {
		// TODO Auto-generated constructor stub
		this.treeNode=treeNode;
		this.visited=v;
	}
}

class InOrderItr implements Iterator
{
	Stack<TreeInOrder> stack;

	public InOrderItr(BSTNode root) {
		stack = new Stack<TreeInOrder>();
		stack.add(new TreeInOrder(root, false));
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public String next() {
		if (!hasNext())
		{
			throw new NoSuchElementException("No more nodes remain to iterate");
		}

		while (hasNext()) 
		{
			TreeInOrder top = stack.peek();
			BSTNode treeNode = top.treeNode;

			if (!top.visited) 
			{
				if (treeNode.left != null) 
				{
					stack.add(new TreeInOrder(treeNode.left, false));
				}
				top.visited = true;
			} 
			else 
			{
				stack.pop();
				if (treeNode.right != null) 
				{
					stack.add(new TreeInOrder(treeNode.right, false));
				}
				return treeNode.data;
			}
		}
		return "";
	}

}
/*class TreeIterator implements Iterator
{
	BSTNode next,parent;

	public TreeIterator(BSTNode root) {
		// TODO Auto-generated constructor stub
		next=root;
		if(next == null)
		{
			System.out.println("Tree is Empty");
		}
		while(next.left != null)
		{
			parent=next;
			next=next.left;
		}
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return next!=null;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		if(!hasNext())
			throw new NoSuchElementException();

		BSTNode r=next;

		if(next.left != null)
		{
			while(next.left != null)
			{
				parent=next;
				next=next.left;
			}

		}



		return next.data;
	}

}*/
/* Class BST */
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
	/* Functions to insert data */
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
	/* Function to insert data recursively */
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
	/* Function to count number of nodes recursively */
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

		System.out.println("In HP Iterator");
		return new InOrderItr(root);
	}
	/* Function for inorder traversal */
/*	public void inorder()
	{
		inorder(root);
	}
	private void inorder(BSTNode r)
	{
		if (r != null)
		{
			inorder(r.getLeft());
			System.out.print(r.getData() +" ");
			inorder(r.getRight());
		}
	}
	*/
}

/* Class BinarySearchTree */


/*
public static void main(String[] args)
{                 
	Scanner scan = new Scanner(System.in);

	BST bst = new BST(); 
	System.out.println("Binary Search Tree Test\n");          
	char ch;

	do    
	{
		System.out.println("\nBinary Search Tree Operations\n");
		System.out.println("1. add ");
		System.out.println("2. clear");
		System.out.println("3. contains");
		System.out.println("4. size");
		System.out.println("5. check empty"); 

		int choice = scan.nextInt();            
		switch (choice)
		{
		case 1 : 
			System.out.println("Enter integer element to insert");
			String n=scan.next();
			Object o=n;
			if(bst.add(o)==true)
				System.out.println("Element added");                     
			break;                          
		case 2 : 
			bst.clear();                     
			break;                      
		case 3 : 
			System.out.println("Enter integer element to search");
			System.out.println("Search result : "+ bst.contains( scan.next() ));
			break;                                          
		case 4 : 
			System.out.println("Nodes = "+ bst.size());
			break;     
		case 5 :  
			System.out.println("Empty status = "+ bst.isEmpty());
			break;            
		default : 
			System.out.println("Wrong Entry \n ");
			break;   
		}

		System.out.println("\nDo you want to continue (Type y or n) \n");
		ch = scan.next().charAt(0);                        
	} while (ch == 'Y'|| ch == 'y');   
	scan.close();
	Iterator m=bst.iterator();
	while(m.hasNext())
	{
		System.out.println(m.next());	
	}
	//        System.out.print("\nIn order : ");
	//        bst.inorder();

}
*/