

public class Nqueen {
	static int N=8,count=0;
	static int board[][]=new int [N][N];
	static int L[][]=new int [N][N];
	static int R[][]=new int [N][N];
	static int U[][]=new int [N][N];
	static int D[][]=new int [N][N];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		L[0][6]=-1;
		L[1][6]=-1;
		L[1][4]=-1;
		L[2][4]=-1;
		L[3][5]=-1;
		L[4][5]=-1;
		L[4][2]=-1;
		L[5][2]=-1;
		L[6][6]=-1;
		L[7][6]=-1;
		L[7][1]=-1;
		
		R[0][5]=-1;
		R[1][5]=-1;
		R[1][3]=-1;
		R[2][3]=-1;
		R[3][4]=-1;
		R[4][4]=-1;
		R[4][1]=-1;
		R[5][1]=-1;
		R[6][5]=-1;
		R[7][5]=-1;
		
		U[2][0]=-1;
		U[2][1]=-1;
		U[2][2]=-1;
		U[3][3]=-1;
		U[3][4]=-1;
		U[3][5]=-1;
		U[5][5]=-1;
		U[5][6]=-1;
		U[5][7]=-1;
		U[6][2]=-1;
		U[6][3]=-1;
		U[6][4]=-1;
		U[7][0]=-1;
		placeQueen(0,0);
		
		 for (int i = 0; i < N; i++)
		 {
		        for (int j = 0; j < N; j++)
		        {
		        	System.out.print(board[i][j]+" ");
		        }
		        System.out.println();
		  }
	}
	
	public static void placeQueen(int row, int col)
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
		
		if((col>N-1) /*&& (position[row]==0)*/)
		{
			System.out.println("Entered here");
			/*for()
			int j=position[row-1];
			chess_board[row-1][j]=0;
			position[row-1]=0;
			count=count-1;*/
			row=row+1;
			col=0;
		//	placeQueen(row-1,j+1);
			placeQueen(row,col);
			
		}
		

		else if(isSafeToPlace(row,col)) 
		{
			board[row][col]=1;
			//position[row]=col;
			count+=1;
			System.out.println("safely placed at " + row + " " + col);
			placeQueen(row,col+1);
			
		}
		
		else
		{
			System.out.println("cannot place at " + row + " " + col);
			col=col+1;
			placeQueen(row,col);
		}
	}

	}
	public static boolean isSafeToPlace(int row, int col)
	{
	    int i, j;
	    /* Check this row on left side */
	    for (i = col; i >= 0; i--)
	    {
	    	if(board[row][i]!=1 && L[row][i]==-1)
	    	{
	    		break;
	    	}
	        if (board[row][i]==1)
	        {
	        	System.out.println("Cannot place, Queen in this row: "+row+" "+col);
	            return false;
	        }
	    }
	    
	    for(j=row; j>=0 ; j--)
	    {
	    	if(board[j][col]!=1 && U[j][col]==-1)
	    	{
	    		break;
	    	}
	    	if(board[j][col]==1 && U[row][col]!=-1)
	    	{
	    		System.out.println("Cannot place, Queen in this col:"+row+" "+col);
	    		return false;
	    	}
	    }
	    	
	 
	    /* Check upper diagonal on left side */
	    for (i = row, j = col; i > 0 && j > 0; i--, j--)
	    {
	    	if (board[i][j]!=1 && ((L[i][j] ==-1 && L[i-1][j]==-1) || (U[i][j]==-1 && U[i][j-1] ==-1)))
	    	{
	    		break;
	    	}
	        if (board[i][j]==1 && (L[row][col] !=-1 && L[row-1][col]!=-1) && (U[row][col]!=-1 && U[row][col-1] !=-1))
	        {
	        	System.out.println("Cannot place, Queen in upper diagonal:"+row+" "+col);
	            return false;
	        }
	        	
	    }
	 
	    /* Check lower diagonal on left side */
	    for (i = row, j = col; j >= 0 && i < N; i++, j--)
	    {
	        if (board[i][j]==1 && (L[row][col] !=-1 && L[row+1][col]!=-1) && (U[row+1][col]!=-1 && U[row+1][col-1] !=-1))
	        {
	        	System.out.println("Cannot place, Queen in lower diagonal:"+row+" "+col);
	            return false;
	        }
	    }
	    
	   for (i = row, j = col; i >=0  && j >= 0; i--, j--) // only checkin diagonal on upper left side
	    {
		   
	        if (board[i][j]==1)
	        {
	        	System.out.println("Cannot place, Queen in upper left diagonal:"+row+" "+col);
	        	return false;
	        }
	       
	    }
	    
	/*   for (i = row, j = col; i >=0  && j < N; i--, j++) // only checkin diagonal on upper right side
	    {
	    	if (board[i][j]!=1 && ((R[i][j] ==-1 && L[i-1][j]==-1) || (U[i][j]==-1 && U[i][j+1] ==-1)))
	    	{
	    		break;
	    	}
	        if (board[i][j]==1 && (R[row][col]!=-1 && R[row-1][col]!=-1) && (U[row][col]!=-1 && U[row][col+1] !=-1))
	        {
	        	System.out.println("Cannot place, Queen in upper right diagonal:"+row+" "+col);
	        	return false;
	        }
	    }
	    
	   for (i = row, j = col; i >=0  && j < N; i--, j++) // only checkin diagonal on upper right side
	   {
	    	if (board[i][j]==1)
	    		return false;
		  ;
	    }*/
	 
	    return true;
	}
}
