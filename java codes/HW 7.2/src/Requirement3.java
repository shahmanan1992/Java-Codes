/* 
 * Requirement3.java 
 * 
 * Version: 
 *     1 
 */

import java.util.*;

/**
 * This program generates random numbers using Array List.Array List generates
 * numbers having unordered access. 
 * 
 * @author      Manan Shah     605004112	
 * @author      Vinay Kumbhar  613009443
 */

public class Requirement3 {
	/**
	 * The main program.
	 *
	 * @param    args    
	 */
	public static void main(String[] args) 
	{
		ArrayList<Integer> ll = new ArrayList<Integer>();
		
		// Random function which generates random numbers.
		Random rand=new Random();
		long stime=System.nanoTime();
		for(int i=0;i<1000;i++)
		{
			// add function which adds elements to the hash set.
		 ll.add(new Integer(rand.nextInt(10)));	
		}
		long etime=System.nanoTime();
		long duration=etime-stime;
		
		//advance for-loop
		for(int i:ll)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		//System.out.println("Duration="+duration);
	}
}