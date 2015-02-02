
public class Board {
static int i=0,j=0,count=0,N=10;
static int chess_board[][]=new int[N][N];

public static void main(String args[])
{
	//white colour - King cannot be placed
	chess_board[0][4]=-1;
	chess_board[0][5]=-1;
	for(int k=1;k<9;k++)
	{
	chess_board[1][k]=-1;
	chess_board[8][k]=-1;
	}
	chess_board[4][0]=-1;
	chess_board[4][5]=-1;
	chess_board[5][0]=-1;
	chess_board[0][5]=-1;
	chess_board[4][4]=-1;
	chess_board[4][9]=-1;
	chess_board[5][5]=-1;
	chess_board[5][0]=-1;
	chess_board[5][4]=-1;
	chess_board[5][9]=-1;
	chess_board[9][5]=-1;
	chess_board[9][4]=-1;
	
	//green colour - King already placed
	chess_board[3][6]=1;
	chess_board[3][3]=1;
	chess_board[6][3]=1;
	chess_board[6][6]=1;
	
	
	placeKing(i,j); //This function initializes the process with position(0,0)

	//Printing the output chess board
	for(int i=0; i<N ; i++)
	{
		for(int j=0; j<N; j++)
		{
			System.out.print(chess_board[i][j]+"\t");	
		}
		System.out.println();
	}

}
public static void placeKing(int row,int col)
{
	if(row>N-1)
		{
			System.out.println("Maximum number of Kings that can be placed = "+count);
		}
	else
	{
		if(col>N-1)
		{
			row=row+1;	
			col=0;
		}
		
		if(row>N-1)
		{
			placeKing(row,col);
		}
		
		else if(isSafeToPlace(row,col) && chess_board[row][col]!=-1) 
		{
			chess_board[row][col]=1;
			count+=1;
			col=col+1;	
			placeKing(row,col);
		}
		
		else
		{
			col=col+1;
			placeKing(row,col);
		}
	}
}
public static boolean isSafeToPlace(int r,int c)
{
	
	if(i-1<0 && j-1<0) //for upper left corner element
	{
		if(chess_board[i][j+1]==1 || chess_board[i+1][j]==1 || chess_board[i+1][j+1]==1)
			return false;
		else
			return true;
	}
	
	if(i-1<0 && j+1>N-1) //for upper right corner element
	{
		if(chess_board[i][j-1]==1 || chess_board[i+1][j]==1 || chess_board[i+1][j-1]==1)
			return false;
		else
			return true;
	}
	
	if(i+1>N-1 && j-1<0) //for lower left corner element
	{
		if(chess_board[i][j+1]==1 || chess_board[i-1][j]==1 || chess_board[i-1][j+1]==1)
			return false;
		else 
			return true;
	}
	
	
	if(i+1>N-1 && j+1>N-1) //for lower right corner element
	{
		if(chess_board[i][j-1]==1 || chess_board[i-1][j]==1 || chess_board[i-1][j-1]==1)
			return false;
		else
			return true;
	}
	
	if((j-1<0))  // for uppermost column elements
	{
		if(chess_board[i-1][j]==1 || chess_board[i+1][j]==1 || chess_board[i][j+1]==1 || chess_board[i-1][j+1]==1 || chess_board[i+1][j+1]==1)
			return false;
		else
			return true;
	}
	
	if((j+1>N-1)) // for lowest column elements
	{
		if(chess_board[i-1][j]==1 || chess_board[i+1][j]==1 || chess_board[i][j-1]==1 || chess_board[i-1][j-1]==1 || chess_board[i+1][j-1]==1)
			return false;
		else
			return true;
	}
	
	if((i-1<0)) // for leftmost row elements
	{
		if(chess_board[i][j+1]==1 || chess_board[i][j-1]==1 || chess_board[i+1][j]==1 || chess_board[i+1][j+1]==1 || chess_board[i+1][j-1]==1)
			return false;
		else
			return true;
	}
	
	if((i+1>N-1)) // for rightmost row elements
	{
		if(chess_board[i][j+1]==1 || chess_board[i][j-1]==1 || chess_board[i-1][j]==1 || chess_board[i-1][j+1]==1 || chess_board[i-1][j-1]==1)
			return false;
		else
			return true;
	}
	
	if(i-1>=0 && i+1<=N-1 && j-1>=0 && j+1<=N-1) // for remaining elements
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
