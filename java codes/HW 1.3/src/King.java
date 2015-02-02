
public class King {
	private static int N=3;
	private static int board [][]=new int[N][N];
	public static void main(String args[])
	{
		int N = 3;
		
		solve(0,0);
	}
	public static void solve(int row,int col)
	{
		int count=0;
		if(row==N-1)
		{
			for(int i=0; i<3; i++)
			{
				for(int j=0;j<3;j++)
				{
					System.out.print(board[i]);
				}
				System.out.println();
			}	
		//	System.out.println("error in code");
		}
		else
		{
					if(canMove(row,col))
					{
						board[row][col]=1;
						count+=1;
						if(col<N-1)
						solve(row,col+1);
						else
						{
						row=row+1;
						solve(row,0);
						}
					}	
		}
		System.out.println(count);
	}
	
	public static boolean canMove(int r,int c)
	{
		// first line
			if((board[r][c]==0) && r==0)
					{
						if((board[r+1][c]==0) && ((board[r][c+1]==0)||(board[r][c-1]==0)) && ((board[r+1][c+1]==0)||(board[r+1][c-1]==0)))
						{
							return true;
						}
					}
			//last line
			else if((board[r][c]==0) && r==N-1)
			{
				if((board[r-1][c]==0) && ((board[r][c-1]==0)||(board[r][c+1]==0)) && ((board[r-1][c-1]==0)||(board[r-1][c+1]==0)))
				{
					return true;
				}
			}
			//middle lines
			else
			{
				if((board[r-1][c]==0) && (board[r+1][c]==0) && ((board[r][c+1]==0) || (board[r][c-1]==0)) && ((board[r-1][c-1]==0) || (board[r-1][c+1]==0)) && ((board[r+1][c-1]==0) || (board[r+1][c+1]==0)))  
				{
					return true;
				}
			}
			
		return false;
	}
}
