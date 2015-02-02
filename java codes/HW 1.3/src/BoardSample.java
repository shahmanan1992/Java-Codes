
public class BoardSample {
static int i=0,j=0,count=0,N=10;
static int chess_board[][]=new int[N][N];
//static int position[]=new int [3];
public static void main(String args[])
{
	placeKing(i,j);
	
	for(int i=0; i<N ; i++)
	{
		for(int j=0; j<N; j++)
		{
			System.out.print(chess_board[i][j]);	
		}
		System.out.println();
	}
}
public static void placeKing(int row,int col)
{
	if(row>N-1)
		{
			System.out.println("COunt= "+count);
		}
	else
	{
		if(col>N-1)
		{
			System.out.println("Col has ended");
			row=row+1;	
			col=0;
		}
		System.out.println("Getting started");
			System.out.println(row+""+col);
			
			if(row>N-1)
			{
				placeKing(row,col);
			}
			else if(isSafe(row,col))
				{
					chess_board[row][col]=1;
					System.out.println("Placing King at "+row+""+col);
					count+=1;
					col=col+1;	
					placeKing(row,col);
				}
			else
				{
					System.out.println("Cannot place");
					col=col+1;
					placeKing(row,col);
				}
	}
}
public static boolean isSafe(int i,int j)
{
	if(i-1<0 && j-1<0)
	{
		if(chess_board[i][j+1]==1 || chess_board[i+1][j]==1 || chess_board[i+1][j+1]==1)
			return false;
		else
			return true;
	}
	if(i+1>N-1 && j-1<0)
	{
		if(chess_board[i][j+1]==1 || chess_board[i-1][j]==1 || chess_board[i-1][j+1]==1)
			return false;
		else 
			return true;
	}
	if(i-1<0 && j+1>N-1)
	{
		if(chess_board[i][j-1]==1 || chess_board[i+1][j]==1 || chess_board[i+1][j-1]==1)
			return false;
		else
			return true;
	}
	if(i+1>N-1 && j+1>N-1)
	{
		if(chess_board[i][j-1]==1 || chess_board[i-1][j]==1 || chess_board[i-1][j-1]==1)
			return false;
		else
			return true;
	}
	if((j-1<0))
	{
		if(chess_board[i-1][j]==1 || chess_board[i+1][j]==1 || chess_board[i][j+1]==1 || chess_board[i-1][j+1]==1 || chess_board[i+1][j+1]==1)
			return false;
		else
			return true;
	}
	if((j+1>N-1))
	{
		if(chess_board[i-1][j]==1 || chess_board[i+1][j]==1 || chess_board[i][j-1]==1 || chess_board[i-1][j-1]==1 || chess_board[i+1][j-1]==1)
			return false;
		else
			return true;
	}
	if((i-1<0))
	{
		if(chess_board[i][j+1]==1 || chess_board[i][j-1]==1 || chess_board[i+1][j]==1 || chess_board[i+1][j+1]==1 || chess_board[i+1][j-1]==1)
			return false;
		else
			return true;
	}
	if((i+1>N-1))
	{
		if(chess_board[i][j+1]==1 || chess_board[i][j-1]==1 || chess_board[i-1][j]==1 || chess_board[i-1][j+1]==1 || chess_board[i-1][j-1]==1)
			return false;
		else
			return true;
	}
	if(i-1>=0 && i+1<=N-1 && j-1>=0 && j+1<=N-1)
	{
		if(chess_board[i][j+1]==1 || chess_board[i][j-1]==1 || 
		chess_board[i+1][j]==1 || chess_board[i+1][j+1]==1 || chess_board[i+1][j-1]==1
		|| chess_board[i-1][j]==1 || chess_board[i-1][j+1]==1 || chess_board[i-1][j-1]==1)
			return false;
		else
			return true;
	}
	return true;
	
}
}
