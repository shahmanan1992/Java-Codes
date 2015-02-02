/* 
 * Requirement2.java 
 * 
 * Version: 
 *     1 
 */

import java.util.*;

/**
 * This program generates random numbers using Hash Set.Hash Set produces numbers 
 * having unordered access but providing the best performance compared to other
 * Set methods. 
 * 
 * @author      Manan Shah     605004112	
 * @author      Vinay Kumbhar  613009443
 */

public class Requirement2 {
	/**
	 * The main program.
	 *
	 * @param    args    
	 */
	public static void main(String[] args) 
	{
		
		HashSet<Integer> hset = new HashSet<Integer>();
		
		// Random function which generates random numbers.
		Random rand=new Random();
		long stime=System.nanoTime();
		for(int i=0;i<1000;i++)
		{
			// add function which adds elements to the hash set.
		 hset.add(new Integer(rand.nextInt(1000)));	
		}
		long etime=System.nanoTime();
		long duration=etime-stime;
		
		//advance for-loop
		for(int i:hset)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		//System.out.println("Duration="+duration);
	}
}