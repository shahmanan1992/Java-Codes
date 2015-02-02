/* 
 * YourCollections.java 
 * 
 * Version: 
 *     1 
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
/**
 * This program implements the sort and shuffle method
 * for Collections.
 * 
 * @author      Manan Shah     605004112	
 * @author      Vinay Kumbhar  613009443
 */

public class YourCollections {

	/**
	 * The main program.
	 *
	 * @param    args    
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList<Integer>();
		//Input for Integer List
		for(int i=0;i<10;i++)
		{
			list.add(new Random().nextInt(100));
		}
	    System.out.println("Input Integer List");
	    display(list);
		  
	    System.out.println("\n\nAfter sorting Elements");
	    sort(list,new IntComparison());
	    
	    display(list);
	    
	    ArrayList<String> str=new ArrayList<String>();
	    //Input for String List
	    str.add("Bye");
	    str.add("Hello");
	    str.add("Good");
	    str.add("Zebra");
	    str.add("Dog");
	    str.add("Fall");
	    str.add("GoodMorning");
	    str.add("Afternoon");
	    
	    
	    str.add("Night");
	    str.add("Java");
	    System.out.println("\n\nInput String List");
	    display(str);
	    
	    System.out.println("\n\nAfter sorting Elements");
	    sort(str,new StringComparison());
	    display(str);
	    System.out.println("\n\nAfter Shuffling Integer Elements");
	    shuffle(list);
	    display(list);
	    System.out.println("\n\nAfter Shuffling String Elements");
	    shuffle(str);
	    display(str);
	}

	/**
	 * This method sorts the given list based on the Comparator
	 * @param list List to be sorted8
	 * @param c    Comparator which gives the rules of comparison
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(List list,Comparator c)
	{
		Object arr[]=list.toArray();
		//Using insertion sort to sort the elements
		for(int i=1; i<arr.length; i++)
		{
			Object temp=arr[i];
			int j;
			for(j=i-1; j>=0 && c.compare(temp, arr[j])<0; j--)
			{
				arr[j+1]=arr[j];
			}
			arr[j+1]=temp;
		}
		ListIterator i = list.listIterator();
		//Copying elements back to list
		for (int j=0; j<arr.length; j++)
		{
			i.next();
			i.set(arr[j]);
		}
	}
	
	/**
	 * Shuffles the list
	 * @param l List to be shuffled
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void shuffle(List l)
	{
		Object arr[]=l.toArray();
		Random r=new Random();
		for(int i=0; i<arr.length; i++)
		{
			int next=i+r.nextInt(arr.length-i);
			//Swap elements between current and next random position
			Object element=l.get(i);
			l.set(i, l.get(next));
			l.set(next, element);
		}
	}
	
	/**
	 * Prints the given list
	 * @param l  List to be displayed
	 */
	@SuppressWarnings("rawtypes")
	public static void display(List l)
	{
		for(Object o : l)
		{
			System.out.print(o+" ");
		}
		System.out.println();
	}

}

class IntComparison implements Comparator<Integer>
{
	/**
	 * This method compares 2 integers and returns 1 if 1st>2nd
	 * 0 if equal, -1 otherwise
	 * 
	 * @param o1  1st integer
	 * @param o2  2nd integer
	 * @return int
	 */
	@Override
	public int compare(Integer o1, Integer o2) {
		
		return (o1>o2 ? -1 : (o1==o2 ? 0 : 1));
		
	}
}

class StringComparison implements Comparator<String>
{
	/**
	 * This method compares 2 strings and returns 1 if 1st>2nd
	 * 0 if equal, -1 otherwise
	 * 
	 * @param o1  1st integer
	 * @param o2  2nd integer
	 * @return int
	 */
	@Override
	public int compare(String o1, String o2) {
		
		return (o1.compareTo(o2)<0 ? -1 : (o1.equals(o2) ? 0 : 1));
	}
	
}