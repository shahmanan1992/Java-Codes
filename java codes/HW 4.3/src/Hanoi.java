/*
 * Hanoi.java
 *
 * Version:
 *     1
 */

/**
 * @author      Author name
 * @author      Vinay Kumbhar   613009443
 * @author      Manan Shah      605004112
 *
 * This program generates a solution for transferring N number of disk from pole 0
 * to pole 2 with the below conditions :
 * Only one disk can be moved at a time.
 * Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack 
 * i.e. a disk can only be moved if it is the uppermost disk on a stack.
 * No disk may be placed on top of a smaller disk.
 */

public class Hanoi {

	static int N=6;
	//Arrays storing disk information. A - PoleStart, B - PoleOver, C - PoleEnd
	static int A[]=new int[N];
	static int B[]=new int[N];
	static int C[]=new int[N];

	/**
	 * Given a start, over and end pole places the disk from start to end keeping in 
	 * check the program conditions.
	 * 
	 * @param n         Number of disks that need to be moved
	 * @param poleStart Starting pole
	 * @param poleOver  Intermediate pole
	 * @param poleEnd   Ending pole
	 */
	public static void move(int  n, String poleStart, String poleOver, String poleEnd)
	{
		int start[],end[];
		switch(poleStart)
		{
		case "0":
			start=A;
			break;
		case "1":
			start=B;
			break;
		case "2":
			start=C;
			break;
		default:
			start=A;
		}

		switch(poleEnd)
		{
		case "0":
			end=A;
			break;
		case "1":
			end=B;
			break;
		case "2":
			end=C;
			break;
		default:
			end=C;
		}

		//Base case : if 1 disk needs to be moved, move it from start to end
		if(n==1)
		{
			int top=getTop(start);
			int top_pos=getIndex(start, top);
			int free_pos=getFreePos(end);
			end[free_pos]=top;
			start[top_pos]=0;	
			System.out.println("Move disk from pole "+poleStart+" to pole "+poleEnd);
			printState();
			System.out.println();
		}
		//Else move N-1 disk from start to over, move last disk to end and then again move N-1 disks from over to end
		else
		{
			move(n-1, poleStart,poleEnd,poleOver);
			int top=getTop(start);
			int top_pos=getIndex(start, top);
			int free_pos=getFreePos(end);
			end[free_pos]=top;
			start[top_pos]=0;
			System.out.println("Move disk from pole "+poleStart+" to pole "+poleEnd);
			printState();
			System.out.println();
			move(n-1, poleOver,poleStart,poleEnd);
		}

	}


	/**
	 * Given an array finds element at the top
	 * 
	 * @param a[] Array containing disks
	 * @return int returns element at the top
	 */
	public static int getTop(int a[])
	{
		for(int i=0;i<N;i++)
		{
			if(a[i]!=0)
				return a[i];
		}
		return -1;
	}

	/**
	 * Given an array and a value finds the position in that array
	 * 
	 * @param a[] Array containing disks
	 * @param val Value whose position is to be found
	 * @return int returns position
	 */
	public static int getIndex(int a[],int val)
	{
		for(int i=0;i<N;i++)
		{
			if(a[i]==val)
				return i;
		}
		return -1;
	}

	/**
	 * Given an array and a value finds a free position
	 * 
	 * @param a[] Array containing disks
	 * @return int returns free position
	 */
	public static int getFreePos(int a[])
	{
		int i;
		for(i=N-1;i>=0;i--)
		{
			if(a[i]==0)
				return i;
		}
		return -1;	
	}

	/**
	 * The main program.
	 *
	 * @param    args
	 */
	public static void main(String args[])
	{
		//Initialization of disks in array
		for(int i=0; i<N;i ++)
		{
			A[i]=i+1;
		}
		System.out.println("Before State");

		printState();

		System.out.println("\nAfter state");

		move(N,"0","1","2");



	}

	/**
	 * Prints the current state of the array
	 */
	public static void printState()
	{
		for(int i=0;i<N;i++)
		{
			System.out.println(A[i]+" "+B[i]+" "+C[i]);
		}
		System.out.println("-----");
		System.out.println("0 1 2");
	}
}

