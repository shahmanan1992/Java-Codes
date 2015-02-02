
public class Test {

	private static int N=3;
	private static int board []=new int[N];
	public static void main(String args[])
	{
		int N = 3;
		
		solve(0);
	}
	public static void solve(int row)
	{
		if(row==N)
		{
			for(int i=0; i<3; i++)
			{
				System.out.print(board[i]+" ");
			}
				System.out.println();
			
		}
		else
		{
			for(int i=0; i<N; i++)
			{
					if(canMove(row,i))
					{
						board[row]=i;
						solve(row+1);
					}	
			}
		}
		
	}
	
	public static boolean canMove(int r,int c)
	{
		for(int i=0; i<r; i++)
		{
			int other_row_pos=board[i];
			
			//if(other_row_pos == )
			return false;
		}
		return false;
	}
}
