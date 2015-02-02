
public class Queen {
static int i=0,j=0,count=0,N=4;
static int chess_board[][]=new int[N][N];
static int position []=new int [20];
public static void main(String args[])
{ 
	int m,n;
	placeQueen(i,j); //This function initializes the process with position(0,0)

	//Printing the output chess board
	for(m=0; m<N ; m++)
	{
		for(n=0; n<N; n++)
		{
			System.out.print(chess_board[m][n]+"\t");	
		}
		System.out.println();
	}

}
public static void placeQueen(int row,int col)
{
	if(row>N-1)
		{
			System.out.println("No. of queens that can be placed = "+count);

		}
	else
	{
		if(row>N-1)
		{
			placeQueen(row,col);
		}
		
		if((col>N-1) && (position[row]==0))
		{
			System.out.println("Entered here");
			int j=position[row-1];
			chess_board[row-1][j]=0;
			position[row-1]=0;
			count=count-1;
			placeQueen(row-1,j+1);
			
		}
		

		else if(isSafeToPlace(row,col)) 
		{
			chess_board[row][col]=1;
			position[row]=col;
			count+=1;
			System.out.println("safely placed at " + row + " " + col);
			col=0;
			placeQueen(row+1,col);
			
		}
		
		else
		{
			System.out.println("cannot place at " + row + " " + col);
			col=col+1;
			placeQueen(row,col);
		}
	}
}
public static boolean isSafeToPlace(int row,int col)
{
		for(int i=0;i<row;i++)
		{
			if(position[i]==col)
				return false;
			if(Math.abs(position[i]-col)==Math.abs(i-row))
				return false;
		}
		return true;
}

}
