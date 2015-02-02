public class Board {
static int i=0,j=0,count=0,N=8;
static int chess_board[][]=new int[N][N];
static int vchess_board[][]=new int[N][N];
static int position []=new int [20];
public static void main(String args[])
{ 
	int m,n;
	// considering the positions as wall
	vchess_board[0][5]=-1;
	vchess_board[0][6]=-1;
	for(int l=0;l<7;l++)
	{
		chess_board[1][l]=-1;
	}
	for(int l=0;l<6;l++)
	{
		chess_board[2][l]=-1;
	}
	vchess_board[3][3]=-1;
	vchess_board[3][4]=-1;
	vchess_board[3][5]=-1;
	vchess_board[4][1]=-1;
	vchess_board[4][2]=-1;
	for(int l=4;l<8;l++)
	{
		vchess_board[4][l]=-1;
	}
	
	for(int l=1;l<8;l++)
	{
		vchess_board[5][l]=-1;
	}
	for(int l=2;l<7;l++)
	{
		vchess_board[6][l]=-1;
	}
	
	vchess_board[7][0]=-1;
	vchess_board[7][1]=-1;
	vchess_board[7][5]=-1;
	vchess_board[7][6]=-1;
	
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
		
		/*if((col>N-1) && (position[row]==0))
		{
			System.out.println("Entered here");
			int j=position[row-1];
			chess_board[row-1][j]=0;
			position[row-1]=0;
			count=count-1;
			placeQueen(row-1,j+1);
			
		}*/
		

		else if(isSafeToPlace(row,col)) 
		{
			chess_board[row][col]=1;
			count+=1;
			//position[row]=col;
			for(int rem=col+1;rem<N;rem++)
			{
				if(vchess_board[row][col]!=-1)
				{
					col=col+1;
				}
				else
				{
					if(isSafeToPlace(row,col+1) && vchess_board[row][col+1]==-1)
					{
						chess_board[row][col+1]=1;
						count=count+1;			
					}
				}
			}		
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
