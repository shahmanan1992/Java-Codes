import java.io.File;
import java.io.*;
import java.util.Scanner;

public class CrossWord 
{
	public static void main(String args[])
	{
		try 
		{
			
			char word[][]=new char[13][13];
			word[0][6]='0';
			word[1][5]='F';
			word[1][6]='U';
			word[1][7]='N';
			for(int i=4;i<9;i++)
			{
				word[2][i]='0';
			}
			
			for(int i=3;i<10;i++)
			{
				word[3][i]='0';
			}
			
			for(int i=2;i<6;i++)
			{
				word[4][i]='0';
			}
			
			for(int i=7;i<11;i++)
			{
				word[4][i]='0';
			}
			
			
			for(int i=1;i<5;i++)
			{
				word[5][i]='0';
			}
			
			for(int i=8;i<12;i++)
			{
				word[5][i]='0';
			}
			
			for(int i=0;i<4;i++)
			{
				word[6][i]='0';
			}
			
			for(int i=9;i<13;i++)
			{
				word[6][i]='0';
			}
			
			for(int i=1;i<5;i++)
			{
				word[7][i]='0';
			}
			
			for(int i=8;i<12;i++)
			{
				word[7][i]='0';
			}
			
			for(int i=2;i<6;i++)
			{
				word[8][i]='0';
			}
			
			for(int i=7;i<11;i++)
			{
				word[8][i]='0';
			}
		
			for(int i=3;i<10;i++)
			{
				word[9][i]='0';
			}
			
			for(int i=4;i<9;i++)
			{
				word[10][i]='0';
			}
			
			for(int i=5;i<8;i++)
			{
				word[11][i]='0';
			}	
			word[12][6]='0';
			
			//placing -1 in empty values in array
			for(int i=0;i<13;i++)
			{
				for(int j=0;j<13;j++)
				{
				if(word[i][j]=='\u0000')
					word[i][j]='1';
				}
					
			}
			
			String positions_data[]={"06D4","15D4","17D4","24A5","28D4","24D4"};
			//,"33A7","39D7","42A4","47A4",""}
			
			
			//printing the crossword puzzle
			for(int i=0;i<13;i++)
			{
				for(int j=0;j<13;j++)
				{
					System.out.print(word[i][j]+"\t");
				}
				System.out.println();
			}
			
			
		//	check(word);
			
		}
		catch ( Exception e )
		{
			System.err.println("Something went wrong!");
		}
	}	
}
	/*	public static void check(char word[][])
		{
			        
			            for(int i=0;i<13;i++)
			            {
			            	for(int j=0;j<13;j++)
			            	{
			            		if(word[i][j]!=0 && word[i][j]!=1)
			            		{
			            			int count=toBePlaced(word,i,j);
			            			while()
			            		}
			            	}
			            }
		}

			
			public static int toBePlaced(char word[][],int row,int col)
			{
				try
				{
				Scanner sc  = new Scanner( new File("words.txt"));
			       int count=0;
			       if((word[row][col-1]=='1' && word[row][col+1]=='1')|| col+1 >=13) //This is for down direction
			           {
			        	   for(int j=col; word[row][j]!=1 || word[row][j]!=0;j++)
			        		   count++;
			           }
			       
			       if(word[row][col-1]=='1' && word[row][col+1]=='0')// this is across direction
			       {
			    	   for(int j=col; word[row][j]!=1 || word[row][j]!=0;j++)
		        		   count++;
			       }
			       return count;
		    }
}*/
	
	
	/* for (int j = 0; j < word.Length; j++)
    {
    int x1 = x, y1 = y + j;
    if (!(IsValidPosition(x1, y1) && (_board[x1, y1] == ' ' || _board[x1, y1] =                    = word[j])))
        return -1;
    if (IsValidPosition(x1 - 1, y1))
        if (_hWords[x1 - 1, y1] > 0)
            return -1;
    if (IsValidPosition(x1 + 1, y1))
        if (_hWords[x1 + 1, y1] > 0)
            return -1;
    if (_board[x1, y1] == word[j])
        result++;
}

else
{
for (var j = 0; j < word.Length; j++)
{
    int x1 = x + j, y1 = y;
    if (!(IsValidPosition(x1, y1) && (_board[x1, y1] == ' ' || _board[x1, y1] =                    = word[j])))
        return -1;
    if (IsValidPosition(x1, y1 - 1))
        if (_vWords[x1, y1 - 1] > 0)
            return -1;
    if (IsValidPosition(x1, y1 + 1))
        if (_vWords[x1, y1 + 1] > 0)
            return -1;
    if (_board[x1, y1] == word[j])
        result++;
}
}*/