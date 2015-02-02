
import java.io.*;
class operation
{
int position[]=new int[20];
int count=0;
		public boolean place(int row,int col)
		{
			int i;
			for(i=1;i<=row-1;i++)
			{ //checking for column and diagonal conflicts
			if(position[i] == col)
			return false;
			else
			if(Math.abs(position[i] -  col) == Math.abs(i - row))
			return false;
			}
			return true;
		}
		public void Queen(int row,int n)
		{
			
			int column;
			for(column=1;column<=n;column++)
			{
				
				if(place(row,column) )
				{
					System.out.println("Safe row :"+row+" col :"+column);
				position[row] = column;
				if(row==n)
				print_board(n);//printing the board configuration
				else  //try next queen with next position
				Queen(row+1,n);
				}
				System.out.println("Not safe row :"+row+" col :"+column);
			}
			System.out.println("Out of for loop");
		}
		public void print_board(int n)
		{
			int i;
			System.out.println("\n\nSolution  :"+(++count));
			for(i=1;i<=n;i++)
			{
			System.out.print("           "+i);
			}
			for(i=1;i<=n;i++)
			{
			System.out.print("\n\n"+i);
			for(int j=1;j<=n;j++)// for nXn board
			{
			if(position[i]==j)
			System.out.print("          Q");
			else
			System.out.print("          -");
			}
			}
		}
}
class BacktrackDemo
{
public static void main (String args[] )throws IOException
{
DataInputStream in=new DataInputStream(System.in);
System.out.println("Enter no Of Queens");
int n=Integer.parseInt(in.readLine());
operation op=new operation();
op.Queen(1,n);
}
}