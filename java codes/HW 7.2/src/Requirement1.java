/* 
 * Requirement1.java 
 * 
 * Version: 
 *     1 
 */

import java.util.*;
/**
 * This program generates random numbers using Tree Set.Tree Set produces output
 * of sorted numbers using their natural ordering. 
 * 
 * @author      Manan Shah     605004112	
 * @author      Vinay Kumbhar  613009443
 */


public class Requirement1 {
	/**
	 * The main program.
	 *
	 * @param    args    
	 */
	public static void main(String[] args) 
	{
		TreeSet<Integer> tset = new TreeSet<Integer>();
		
		// Random function which generates random numbers.
		Random rand=new Random();
		
		for(int i=0;i<1000;i++)
		{
		// add function which adds elements to the tree set.
		 tset.add(new Integer(rand.nextInt(1000)));	
		}
		
		//advance for-loop
		for(int i:tset)
		{	
			System.out.print(i+" ");
		}
		System.out.println();
		//System.out.println("size="+tset.size());
	}
	
	/* Class BinarySearchTree */


	/*public class A
	{
	public static void main(String[] args)
	{                 
		Scanner scan = new Scanner(System.in);

		HpTreeSet bst = new HpTreeSet(); 
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
		
		for(int i=0;i<30;i++)
		{
			bst.add("A"+i);
		}
		Iterator m=bst.iterator();
		while(m.hasNext())
		{
			System.out.println(m.next());	
		}
		//        System.out.print("\nIn order : ");
		//        bst.inorder();

	}
	}*/
}

